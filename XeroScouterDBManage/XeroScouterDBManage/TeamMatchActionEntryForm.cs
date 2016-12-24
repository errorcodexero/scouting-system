﻿using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Windows.Forms;
using XeroScouterDBManage_Server.DatabaseInfo;

namespace XeroScouterDBManage_Server
{
	public partial class TeamMatchActionEntryForm : Form
	{
		private Int32 teamMatchID;
		private Int32 matchID, teamID;
		private Dictionary<String, Int32> dictActionTypes;
		private Dictionary<Int32, String> dictActionTypeIDs;
		private Dictionary<Control, String> dictActionTypeControls;
		private Dictionary<String, Control> dictActionTypeNames;
		private Dictionary<Int32, bool> dictUpdatedFieldIDs;
		private bool scouterDataFound;
		private bool existingDataFound;

		public TeamMatchActionEntryForm(Int32 mID, Int32 tID)
		{
			InitializeComponent();
			this.matchID = mID;
			this.teamID = tID;

			

			// The dictionaries help map from control to description string, and description string to action_type_id
			// once the maps are hard-coded, we can iterate through the controls and insert a record for each action_type_id
			this.dictActionTypeControls = new Dictionary<Control, String>(); // maps UI control to action_type_id
			this.dictActionTypes = new Dictionary<String, Int32>(); // maps action type name to action_type_id
			this.dictActionTypeIDs = new Dictionary<int, string>(); // maps action type id to name
			this.dictActionTypeNames = new Dictionary<string, Control>(); // maps names to controls
			this.dictUpdatedFieldIDs = new Dictionary<int, bool>(); // maps ids to bool representing if the field was updated on load, use this to only save fields that didn't have data

			loadActionTypeData();
			mapActionTypeControls();
			loadTeamMatchData();
			//this.Width = 1450;
			//this.Height = 1250;

			existingDataFound = false;
			scouterDataFound = false;
			loadExistingData();
		}

		private void btnCancel_Click(object sender, EventArgs e)
		{
			this.Close();
		}

		private void btnSave_Click(object sender, EventArgs e)
		{
			SaveData(true);
		}

		private void mapActionTypeControls()
		{
			this.dictActionTypeControls.Add(this.txtAutoLinesCrossed, "Auto Line Crossed");
			this.dictActionTypeControls.Add(this.txtAutoBunniesPicked, "Auto Bunnies Picked-up");
			this.dictActionTypeControls.Add(this.txtAutoBunniesScored, "Auto Bunnies Scored");
			this.dictActionTypeControls.Add(this.txtTeleLinesCrossed, "Lines Crossed");
			this.dictActionTypeControls.Add(this.txtTeleBunniesScored, "Bunnies Deposited");
			this.dictActionTypeControls.Add(this.txtTeleBunniesGround, "Bunnies Picked-up");
			this.dictActionTypeControls.Add(this.txtTeleBunniesStolen, "Bunnies Stolen");
			this.dictActionTypeControls.Add(this.txtNerfShotsHit, "Shots Hit");
			this.dictActionTypeControls.Add(this.txtNerfShotsMissed, "Shots Missed");

			this.dictActionTypeNames.Add("Auto Line Crossed", this.txtAutoLinesCrossed);
			this.dictActionTypeNames.Add("Auto Bunnies Picked-up", this.txtAutoBunniesPicked);
			this.dictActionTypeNames.Add("Auto Bunnies Scored", this.txtAutoBunniesScored);
			this.dictActionTypeNames.Add("Lines Crossed", this.txtTeleLinesCrossed);
			this.dictActionTypeNames.Add("Bunnies Deposited", this.txtTeleBunniesScored);
			this.dictActionTypeNames.Add("Bunnies Picked-up", this.txtTeleBunniesGround);
			this.dictActionTypeNames.Add("Bunnies Stolen", this.txtTeleBunniesStolen);
			this.dictActionTypeNames.Add("Shots Hit", this.txtNerfShotsHit);
			this.dictActionTypeNames.Add("Shots Missed", this.txtNerfShotsMissed);
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
							dictActionTypes.Add(r.Field<String>(ActionTypeTable.COL_NAME), r.Field<Int32>(ActionTypeTable.COL_ID));
							dictActionTypeIDs.Add(r.Field<Int32>(ActionTypeTable.COL_ID), r.Field<String>(ActionTypeTable.COL_NAME));
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
			MySqlCommand cmd;
			bool connectionAvailable = Utils.openConnection(connection);

			if (connectionAvailable)
			{
				try
				{
					cmd = connection.CreateCommand();

					cmd.CommandText = TeamMatchTable.getIdQuery(teamID, matchID); ;

					MySqlDataAdapter adap = new MySqlDataAdapter(cmd);

					DataSet ds = new DataSet();
					adap.Fill(ds);

					if (ds.Tables.Count > 0 && ds.Tables[0].Rows.Count > 0)
					{
						this.teamMatchID = ds.Tables[0].Rows[0].Field<Int32>(TeamMatchTable.COL_ID);
						if (teamMatchID < 0) return;
					}

					cmd.CommandText = TeamMatchTable.getRecordQuery(this.teamMatchID);
					adap = new MySqlDataAdapter(cmd);
					ds.Clear();
					adap.Fill(ds);

					if (ds.Tables.Count > 0 && ds.Tables[0].Rows.Count > 0)
					{
						String color = ds.Tables[0].Rows[0].Field<String>(TeamMatchTable.COL_ALLIANCE);

						int index = this.cmbAllianceColor.FindString(color);
						if (index >= 0)
						{
							this.cmbAllianceColor.SelectedIndex = index;
						}
					}

					cmd.CommandText = MatchTable.SELECT_NUMBER_FROM_MATCHING_ID + String.Format("{0}", this.matchID);
					adap = new MySqlDataAdapter(cmd);
					ds.Clear();
					adap.Fill(ds);

					if (ds.Tables.Count > 0 && ds.Tables[0].Rows.Count > 0)
					{
						Int32 num = ds.Tables[0].Rows[0].Field<Int32>(MatchTable.COL_MATCH_NUMBER);
						this.txtMatchNumber.Text = String.Format("{0}", num);
					}

					cmd.CommandText = TeamTable.SELECT_NUMBER_FROM_MATCHING_ID + String.Format("{0}", this.teamID);
					adap = new MySqlDataAdapter(cmd);
					ds.Clear();
					adap.Fill(ds);

					if (ds.Tables.Count > 0 && ds.Tables[0].Rows.Count > 0)
					{
						String num = ds.Tables[0].Rows[0].Field<String>(TeamTable.COL_TEAM_NUMBER);
						this.txtTeamNumber.Text = num;
					}

					// load the TeamMatchActions
					cmd.CommandText = TeamMatchActionTable.SELECT_ALL_FOR_TEAM_MATCH_ID + String.Format("{0}", this.teamMatchID);
					adap = new MySqlDataAdapter(cmd);
					ds.Clear();
					adap.Fill(ds);

					Dictionary<Int32, int> dictTemp = new Dictionary<Int32, int>();
					int quantity = 0;

					if (ds.Tables.Count > 0)
					{
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

							if(!dictUpdatedFieldIDs.ContainsKey(id))
							{
								dictUpdatedFieldIDs.Add(id, true);
							}
						}
					}

					String strAction;
					foreach(Int32 id in dictTemp.Keys)
					{
						Control textBox = null;
						dictTemp.TryGetValue(id, out quantity);
						dictActionTypeIDs.TryGetValue(id, out strAction);
						dictActionTypeNames.TryGetValue(strAction, out textBox);

						if(textBox != null)
						{
							textBox.Text = String.Format("{0}", quantity);
						}
					}


					cmd.CommandText = TeamMatchTable.getScouterNameQuery(this.teamMatchID);
					adap = new MySqlDataAdapter(cmd);
					ds.Clear();
					adap.Fill(ds);

					if (ds.Tables.Count > 0 && ds.Tables[0].Rows.Count > 0)
					{
						scouterDataFound = true;
						txtScouter.Text = ds.Tables[0].Rows[0].Field<String>(TeamMatchTable.COL_SCOUT_NAME);
					}
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

		private void loadExistingData()
		{
			this.existingDataFound = false;
		}

		private void SaveData(bool exit)
		{
			MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
			MySqlCommand cmd;
			bool saved = true, validated = true;
			String scoutName = "";

			Dictionary<int, Int32> dictIdToCount = new Dictionary<int, Int32>();
			
			connection.Open();

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
					if (k.Text != "" && !hasData)
					{
						dictIdToCount.Add(id, Int32.Parse(k.Text));
					}
				}

				scoutName = txtScouter.Text;
			}
			catch (Exception e)
			{
				validated = false;
				Console.Out.WriteLine(e.Message);
			}

			if (validated)
			{
				try
				{
					cmd = connection.CreateCommand();
					cmd.CommandText = TeamMatchActionTable.getInsertRecordQuery();

					cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_TEAM_MATCH_ID, 0);
					cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_ACTION_TYPE_ID, 0);
					cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_QUANTITY, 0);
					cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_START_TIME, 0);
					cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_END_TIME, 0);
					cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_OBJECT_COUNT, 0);

					foreach (Int32 id in dictIdToCount.Keys)
					{
						int count = 0;
						dictIdToCount.TryGetValue(id, out count);
						cmd.Parameters["@" + TeamMatchActionTable.COL_TEAM_MATCH_ID].Value = this.teamMatchID;
						cmd.Parameters["@" + TeamMatchActionTable.COL_ACTION_TYPE_ID].Value = id;
						cmd.Parameters["@" + TeamMatchActionTable.COL_QUANTITY].Value = count;
						cmd.Parameters["@" + TeamMatchActionTable.COL_START_TIME].Value = 0;
						cmd.Parameters["@" + TeamMatchActionTable.COL_END_TIME].Value = 0;
						cmd.Parameters["@" + TeamMatchActionTable.COL_OBJECT_COUNT].Value = 0;

						cmd.ExecuteNonQuery();
					}

					if (!scouterDataFound)
					{
						cmd.CommandText = TeamMatchTable.getUpdateScouterQuery(this.teamMatchID, scoutName);
						int numRowsUpdated = cmd.ExecuteNonQuery();
					}

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
