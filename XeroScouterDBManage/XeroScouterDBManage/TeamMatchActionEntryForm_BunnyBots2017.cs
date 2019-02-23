﻿using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Windows.Forms;
using XeroScouterDBManage_Server.DatabaseInfo;

namespace XeroScouterDBManage_Server
{
	public partial class TeamMatchActionEntryForm_BunnyBots2017 : Form
	{
		private Int32 teamMatchID;
		private Int32 matchID, teamID;
		private Dictionary<String, Int32> dictActionTypes;
		private Dictionary<Int32, String> dictActionTypeIDs;
		private Dictionary<Control, String> dictActionTypeControls;
		private Dictionary<String, Control> dictActionTypeNames;
		private Dictionary<Int32, bool> dictUpdatedFieldIDs;
		private String statusMessage;
		private bool scouterDataFound;
		private bool existingDataFound;
		private bool cancelling;

		public TeamMatchActionEntryForm_BunnyBots2017(Int32 mID, Int32 tID)
		{
			InitializeComponent();
			this.matchID = mID;
			this.teamID = tID;
			this.cancelling = false;

            setNextID();


            // The dictionaries help map from control to description string, and description string to action_type_id
            // once the maps are hard-coded, we can iterate through the controls and insert a record for each action_type_id
            this.dictActionTypeControls = new Dictionary<Control, String>(); // maps UI control to action_type_id
			this.dictActionTypes = new Dictionary<String, Int32>(); // maps action type name to action_type_id
			this.dictActionTypeIDs = new Dictionary<int, string>(); // maps action type id to name
			this.dictActionTypeNames = new Dictionary<string, Control>(); // maps names to controls
			this.dictUpdatedFieldIDs = new Dictionary<int, bool>(); // maps ids to bool representing if the field was updated on load, use this to only save fields that didn't have data

			this.statusMessage = "";

			loadActionTypeData();
			mapActionTypeControls();
			loadTeamMatchData();
			//this.Width = 1450;
			//this.Height = 1250;

			existingDataFound = false;
			scouterDataFound = false;
			loadExistingData();
		}

        private void setNextID()
        {
            MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
            MySqlCommand cmd;
            bool connectionAvailable = Utils.openConnection(connection);
            Int32 id = -1;

            if (connectionAvailable)
            {
                try
                {
                    cmd = connection.CreateCommand();
                    cmd.CommandText = TeamMatchActionTable.getLoadTeamMatchActionIdsQuery();
                    object i = cmd.ExecuteScalar();
                    Int32 i2 = Program.TEAM_MATCH_ACTION_ID;
                    string strI = i.ToString();
                    if (!strI.Equals(""))
                    {
                        i2 = (Int32)i;
                    }

                    id = i2;
                }
                catch (Exception e)
                {
                    Console.Out.WriteLine(e.StackTrace);
                }
                finally
                {
                    if (connection.State == ConnectionState.Open)
                    {
                        connection.Close();
                    }
                }

                Program.TEAM_MATCH_ACTION_ID = Math.Max(1, id + 1);
            }
        }

		private void btnCancel_Click(object sender, EventArgs e)
		{
			this.cancelling = true;
			this.Close();
		}

		private void btnSave_Click(object sender, EventArgs e)
		{
			SaveData(true);
		}

		private void textbox_Validating(object sender,
				 System.ComponentModel.CancelEventArgs e)
		{
			if (cancelling) return;

			TextBox curTB = null;
			string name = "";
			string errorMsg = "";
			bool valid = true;

			if (sender is TextBox)
			{
				curTB = (TextBox)sender;
				name = curTB.Name;
			}

			if (curTB == null) return;

			switch (name)
			{
				case "txtScouter":
					valid = Utils.ValidAlphaString(curTB.Text, out errorMsg);
					break;
				case "txtTeamNumber":
					valid = Utils.ValidAlphaNumericString(curTB.Text, out errorMsg);
					break;
				case "txtMatchNumber":
				case "txtAutoNearBucketLift":
				case "txtAutoFarBucketLift":
				case "txtAutoMidlineCross":
                case "txtTeleBunniesFound":
                case "txtTeleBucketsSearched":
                case "txtTeleBunniesPickedUp":
                case "txtTeleBunniesPlaced":
                    valid = Utils.ValidInteger(curTB.Text, out errorMsg);
					break;
				default:
					valid = false;
					break;
			}
			
			if(!valid)
			{
				{
					// Cancel the event and select the text to be corrected by the user.
					e.Cancel = true;
					curTB.Select(0, curTB.Text.Length);

					// Set the ErrorProvider error with the text to display. 
					this.errorProvider1.SetError(curTB, errorMsg);
				}

			}

		}

		private void textbox_Validated(object sender, System.EventArgs e)
		{
			// If all conditions have been met, clear the ErrorProvider of errors.
			if (sender is TextBox)
			{
				errorProvider1.SetError((TextBox)sender, "");
			}
		}

		private void mapActionTypeControls()
		{
            this.dictActionTypeControls.Add(this.txtAutoNearBucketLift, "auto_team_bucket_picked_up");
            this.dictActionTypeControls.Add(this.txtAutoFarBucketLift, "auto_field_bucket_picked_up");
            this.dictActionTypeControls.Add(this.txtAutoMidlineCross, "auto_midfield_cross");

            this.dictActionTypeControls.Add(this.txtTeleBunniesFound, "tele_bunnies_found");
			this.dictActionTypeControls.Add(this.txtTeleBucketsSearched, "tele_buckets_searched");
			this.dictActionTypeControls.Add(this.txtTeleBunniesPickedUp, "tele_bunnies_picked_up");
            this.dictActionTypeControls.Add(this.txtTeleBunniesPlaced, "tele_bunnies_placed");
            this.dictActionTypeControls.Add(this.chkDefenceFlag, "tele_played_defense");
            this.dictActionTypeControls.Add(this.chkBreakdownFlag, "breakdown");
            this.dictActionTypeControls.Add(this.chkDisconnectFlag, "disconnect");

            this.dictActionTypeNames.Add("auto_team_bucket_picked_up", this.txtAutoNearBucketLift);
            this.dictActionTypeNames.Add("auto_field_bucket_picked_up", this.txtAutoFarBucketLift);
            this.dictActionTypeNames.Add("auto_fuel_bin_triggered", this.txtAutoMidlineCross);

            this.dictActionTypeNames.Add("tele_bunnies_found", this.txtTeleBunniesFound);
            this.dictActionTypeNames.Add("tele_buckets_searched", this.txtTeleBucketsSearched);
            this.dictActionTypeNames.Add("tele_bunnies_picked_up", this.txtTeleBunniesPickedUp);
            this.dictActionTypeNames.Add("tele_bunnies_placed", this.txtTeleBunniesPlaced);
            this.dictActionTypeNames.Add("tele_played_defense", this.chkDefenceFlag);
            this.dictActionTypeNames.Add("breakdown", this.chkBreakdownFlag);
            this.dictActionTypeNames.Add("disconnect", this.chkDisconnectFlag);

        }

        private void loadActionTypeData()
		{
			MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
			MySqlCommand cmd;
			bool connectionAvailable = Utils.openConnection(connection);

			if (connectionAvailable)
			{
				try
				{
					cmd = connection.CreateCommand();

					cmd.CommandText = ActionTypeTable.SELECT_ALL;

					MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
					DataSet ds = new DataSet();
					adap.Fill(ds);

					if (ds.Tables.Count > 0)
					{
						foreach (DataRow r in ds.Tables[0].Rows)
						{
                            if (!dictActionTypes.ContainsKey(r.Field<String>(ActionTypeTable.COL_NAME)) &&
                                !dictActionTypeIDs.ContainsKey(r.Field<Int32>(ActionTypeTable.COL_ID)))
                            {
                                dictActionTypes.Add(r.Field<String>(ActionTypeTable.COL_NAME), r.Field<Int32>(ActionTypeTable.COL_ID));
                                dictActionTypeIDs.Add(r.Field<Int32>(ActionTypeTable.COL_ID), r.Field<String>(ActionTypeTable.COL_NAME));
                            }
						}
					}
				}
				catch (Exception e)
				{
					Console.Out.WriteLine(e.StackTrace);
				}
				finally
				{
					if (connection.State == ConnectionState.Open)
					{
						connection.Close();
					}
				}
			}
		}

		public void loadTeamMatchData()
		{
			if (this.matchID < 0 || this.teamID < 0) return;

			MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
			bool connectionAvailable = Utils.openConnection(connection);

			if (connectionAvailable)
			{
				try
				{
					if (!loadTeamMatchID(connection))
					{
						this.txtScouter.Enabled = false;
						this.txtMatchNumber.Enabled = false;
						this.txtTeamNumber.Enabled = false;
						this.cmbAllianceColor.Enabled = false;
      //                  this.chkAutoBaselineCross.Enabled = false;
      //                  this.radClimbNoClimb.Enabled = false;
      //                  this.radClimbAttempt.Enabled = false;
      //                  this.radClimbSuccess.Enabled = false;
      //                  this.radClimbTriggered.Enabled = false;
      //                  this.chkDisconnectFlag.Enabled = false;
						//this.chkBreakdownFlag.Enabled = false;
						//this.chkDefenceFlag.Enabled = false;
						foreach(Control c in dictActionTypeNames.Values)
						{
							c.Enabled = false;
						}
						return;
					}

					bool colorFound = loadAllianceColorForMatch(connection);
					bool found = loadMatchNumberForMatch(connection);
					bool numFound = loadTeamNumberForMatch(connection);
					bool actionsFound = loadTeamMatchActions(connection);
					scouterDataFound = loadScouter(connection);
				}
				catch (MySqlException)
				{
					string message = "Unable to open MySQL connection - check if the database is installed and running!";
					Console.Out.WriteLine(message);
				}
				catch (Exception)
				{
					throw;
				}
				finally
				{
					if (connection.State == ConnectionState.Open)
					{
						connection.Close();
					}
				}
			}
		}

		private bool loadTeamMatchID(MySqlConnection connection)
		{
			MySqlCommand cmd = connection.CreateCommand();
			DataSet ds = new DataSet();

			cmd.CommandText = TeamMatchTable.getIdQuery(teamID, matchID);
			MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
			adap.Fill(ds);

			if (ds.Tables.Count > 0 && ds.Tables[0].Rows.Count > 0)
			{
				this.teamMatchID = ds.Tables[0].Rows[0].Field<Int32>(TeamMatchTable.COL_ID);
				return true;
			}
			else
			{
				statusMessage = "There is no TeamMatchID";
				toolStripStatusLabel1.Text = statusMessage;
			}

			return false;
		}

		private bool loadAllianceColorForMatch(MySqlConnection connection)
		{
			MySqlCommand cmd = connection.CreateCommand();
			DataSet ds = new DataSet();

			cmd.CommandText = TeamMatchTable.getRecordQuery(this.teamMatchID);
			MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
			adap.Fill(ds);

			if (ds.Tables.Count > 0 && ds.Tables[0].Rows.Count > 0)
			{
				String color = ds.Tables[0].Rows[0].Field<String>(TeamMatchTable.COL_ALLIANCE);
				int index = this.cmbAllianceColor.FindString(color);
				if (index >= 0)
				{
					this.cmbAllianceColor.SelectedIndex = index;
					return true;
				}
			}

			return false;
		}

		private bool loadMatchNumberForMatch(MySqlConnection connection)
		{
			MySqlCommand cmd = connection.CreateCommand();
			DataSet ds = new DataSet();

			cmd.CommandText = MatchTable.SELECT_NUMBER_FROM_MATCHING_ID + String.Format("{0}", this.matchID);
			MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
			adap.Fill(ds);

			Int32 num = -1;
			if (ds.Tables.Count > 0 && ds.Tables[0].Rows.Count > 0)
			{
				num = ds.Tables[0].Rows[0].Field<Int32>(MatchTable.COL_MATCH_NUMBER);
				this.txtMatchNumber.Text = String.Format("{0}", num);
				return true;
			}

			return false;
		}

		private bool loadTeamNumberForMatch(MySqlConnection connection)
		{
			MySqlCommand cmd = connection.CreateCommand();
			DataSet ds = new DataSet();

			cmd.CommandText = TeamTable.SELECT_NUMBER_FROM_MATCHING_ID + String.Format("{0}", this.teamID);
			MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
			adap.Fill(ds);

			String strTeamNum = "";
			if (ds.Tables.Count > 0 && ds.Tables[0].Rows.Count > 0)
			{
				strTeamNum = ds.Tables[0].Rows[0].Field<String>(TeamTable.COL_TEAM_NUMBER);
				this.txtTeamNumber.Text = strTeamNum;
				return true;
			}

			return false;
		}

		private bool loadTeamMatchActions(MySqlConnection connection)
		{
			MySqlCommand cmd = connection.CreateCommand();
			DataSet ds = new DataSet();

			cmd.CommandText = TeamMatchActionTable.SELECT_ALL_FOR_TEAM_MATCH_ID + String.Format("{0}", this.teamMatchID);
			MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
			adap.Fill(ds);

			Dictionary<Int32, int> dictTemp = new Dictionary<Int32, int>();
			int quantity = 0;
			bool recordsFound = false;

			if (ds.Tables.Count > 0)
			{
				recordsFound = true;
				foreach (DataRow r in ds.Tables[0].Rows)
				{
					int id = r.Field<Int32>(TeamMatchActionTable.COL_ACTION_TYPE_ID);
					if (!dictTemp.ContainsKey(id))
					{
						dictTemp.Add(id, r.Field<int>(TeamMatchActionTable.COL_QUANTITY));
					}
					else
					{
						dictTemp.TryGetValue(id, out quantity);
						dictTemp[id] = quantity + r.Field<int>(TeamMatchActionTable.COL_QUANTITY);
					}

					if (!dictUpdatedFieldIDs.ContainsKey(id))
					{
						dictUpdatedFieldIDs.Add(id, true);
					}
				}
			}

			String strAction;
			foreach (Int32 id in dictTemp.Keys)
			{
				Control myControl = null;
				dictTemp.TryGetValue(id, out quantity);
				dictActionTypeIDs.TryGetValue(id, out strAction);
				dictActionTypeNames.TryGetValue(strAction, out myControl);

                if (myControl != null)
                {
                    Type t = myControl.GetType();
                    string s = t.Name;
                    switch (s)
                    {
                        case "TextBox":
                            myControl.Text = String.Format("{0}", quantity);
                            break;
                        case "CheckBox":
                            ((CheckBox)myControl).Checked = (quantity > 0);
                            break;
                        case "RadioButton":
                            ((RadioButton)myControl).Checked = (quantity > 0);
                            break;
                    }
				}
			}

			return recordsFound;
		}

		private bool loadScouter(MySqlConnection connection)
		{
			MySqlCommand cmd = connection.CreateCommand();
			DataSet ds = new DataSet();

			cmd.CommandText = TeamMatchTable.getScouterNameQuery(this.teamMatchID);
			MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
			adap.Fill(ds);

			if (ds.Tables.Count > 0 && ds.Tables[0].Rows.Count > 0)
			{
				txtScouter.Text = ds.Tables[0].Rows[0].Field<String>(TeamMatchTable.COL_SCOUT_NAME);
				return true;
			}
			return false;
		}

		private void loadExistingData()
		{
			this.existingDataFound = false;
		}

        private void chkDefenceFlag_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void chkBreakdownFlag_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void chkDisconnectFlag_CheckedChanged(object sender, EventArgs e)
        {

        }

        private void SaveData(bool exit)
		{
			MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
			MySqlCommand cmd;
			bool saved = true, validated = true;
			String scoutName = "";

			Dictionary<int, Int32> dictIdToCount = new Dictionary<int, Int32>();
			
			connection.Open();

			if(this.teamMatchID <= 0)
			{
				toolStripStatusLabel1.Text = "There is no TeamMatchID";
				toolStripStatusLabel1.ForeColor = System.Drawing.Color.Red;
				return;
			}
			else
			{
				toolStripStatusLabel1.Text = statusMessage;
				toolStripStatusLabel1.ForeColor = System.Drawing.Color.Black;
			}

			try
			{
				foreach(Control k in dictActionTypeControls.Keys)
				{
					String name;
					int id;
					dictActionTypeControls.TryGetValue(k, out name);
					dictActionTypes.TryGetValue(name, out id);
					bool hasData = false;
					dictUpdatedFieldIDs.TryGetValue(id, out hasData);
                    if (!String.IsNullOrEmpty(k.Text) && !hasData)
                    {
                        Type t = k.GetType();
                        string s = t.Name;
                        switch (s)
                        {
                            case "TextBox":
                                dictIdToCount.Add(id, Int32.Parse(k.Text));
                                break;
                            case "CheckBox":
                                dictIdToCount.Add(id, ((((CheckBox)k).Checked) ? 1 : 0));
                                break;
                            case "RadioButton":
                                dictIdToCount.Add(id, ( (((RadioButton)k).Checked) ? 1 : 0) );
                                break;
                            default:
                                toolStripStatusLabel1.Text = "Bad control type: " + s;
                                break;
                        }
					}
				}

				scoutName = txtScouter.Text;
			}
			catch (Exception e)
			{
				validated = false;
				Console.Out.WriteLine(e.Message);
			}

            /// TODO 
            // DBManager needs to create an _id for each entry - base it off of system clock so it auto increments

			if (validated)
			{
				try
				{
					cmd = connection.CreateCommand();

					cmd.CommandText = TeamMatchActionTable.getInsertRecordQuery();

                    cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_ID, 0);
                    cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_TEAM_MATCH_ID, 0);
					cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_ACTION_TYPE_ID, 0);
					cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_QUANTITY, 0);
					cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_START_TIME, DateTime.Now);
					cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_END_TIME, DateTime.Now);
					cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_OBJECT_COUNT, 0);
                    cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_TABLET_UUID, "");

                    String systemuuid = "\"" + Properties.Settings.Default.SYSTEM_UUID + "\"";

                    foreach (Int32 id in dictIdToCount.Keys)
					{
						int count = 0;
						dictIdToCount.TryGetValue(id, out count);
                        cmd.Parameters["@" + TeamMatchActionTable.COL_ID].Value = Program.TEAM_MATCH_ACTION_ID;
                        cmd.Parameters["@" + TeamMatchActionTable.COL_TEAM_MATCH_ID].Value = this.teamMatchID;
						cmd.Parameters["@" + TeamMatchActionTable.COL_ACTION_TYPE_ID].Value = id;
						cmd.Parameters["@" + TeamMatchActionTable.COL_QUANTITY].Value = count;
						cmd.Parameters["@" + TeamMatchActionTable.COL_START_TIME].Value = DateTime.Now;
						cmd.Parameters["@" + TeamMatchActionTable.COL_END_TIME].Value = DateTime.Now;
						cmd.Parameters["@" + TeamMatchActionTable.COL_OBJECT_COUNT].Value = 0;
                        cmd.Parameters["@" + TeamMatchActionTable.COL_TABLET_UUID].Value = systemuuid;

                        cmd.ExecuteNonQuery();
                        Program.TEAM_MATCH_ACTION_ID++;
                    }

					if (!scouterDataFound)
					{
						cmd.CommandText = TeamMatchTable.getUpdateScouterQuery(this.teamMatchID, scoutName);
						int numRowsUpdated = cmd.ExecuteNonQuery();
					}

				}
				catch (FormatException fe)
                {
                    System.Console.WriteLine(fe.StackTrace);
                    saved = false;
                }
                catch (Exception)
                {
                    saved = false;
                }
                finally
                {
					if (connection.State == ConnectionState.Open)
					{
						connection.Close();
					}
				}
			}

			if (saved)
			{
				if (exit)
				{
					MatchListForm formObj = (MatchListForm)Application.OpenForms["MatchListForm"];
					formObj.LoadMatchData();
					this.Close();
				}
				else
				{
					MessageBox.Show("Save failed, please try again.");
				}
			}
		}
	}
}
