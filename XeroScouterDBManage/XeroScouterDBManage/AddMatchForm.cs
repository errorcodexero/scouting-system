using System;
using System.Collections.Generic;
using System.Data;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using XeroScouterDBManage_Server.DatabaseInfo;

namespace XeroScouterDBManage_Server
{
    public partial class AddMatchForm : Form
    {
        private long compID;
        private List<ComboBox> teamComboList;
        private bool initSentinal;
        public AddMatchForm(long competition_id)
        {
            this.initSentinal = false;
            this.compID = competition_id;
            this.teamComboList = new List<ComboBox>(6);
            InitializeComponent();
            LoadCompetitions();
            initTeamComboBoxes();
            LoadTeams();
            this.initSentinal = true;
        }

        public void LoadCompetitions()
        {
            MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
            MySqlCommand cmd;
            bool connectionAvailable = Utils.openConnection(connection, lblStatus);

            if (connectionAvailable)
            {
                try
                {
                    cmd = connection.CreateCommand();
                    cmd.CommandText = EventTable.SELECT_ID_NAME_LOC;
                    MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                    DataSet ds = new DataSet();
                    adap.Fill(ds);
                    cmbCompetitionName.DataSource = ds.Tables[0].DefaultView;
                    cmbCompetitionName.ValueMember = EventTable.COL_ID;
                    cmbCompetitionName.SelectedValue = this.compID;
                    cmbCompetitionName.DisplayMember = EventTable.COL_NAME;
                    txtMatchLocation.Text = ds.Tables[0].Rows[0][EventTable.COL_LOCATION].ToString();
                }
                catch (MySql.Data.MySqlClient.MySqlException)
                {
                    string message = "Unable to open MySQL connection - check if the database is installed and running!";
                    Console.Out.WriteLine(message);
                    lblStatus.Text = message;
                }
                catch (Exception)
                {
                    string message = "Unknown error - check if the database is installed and running!";
                    Console.Out.WriteLine(message);
                    lblStatus.Text = message;
                    //throw;
                }
                finally
                {
                    if (connection.State == System.Data.ConnectionState.Open)
                    {
                        connection.Close();
                    }
                }
            }
        }

        public void initTeamComboBoxes()
        {
            teamComboList.Add(cmbBlue1);
            teamComboList.Add(cmbBlue2);
            teamComboList.Add(cmbBlue3);
            teamComboList.Add(cmbRed1);
            teamComboList.Add(cmbRed2);
            teamComboList.Add(cmbRed3);

            cmbBlue1.Text = "";
        }

        public void LoadTeams()
        {
            MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
            MySqlCommand cmd;
            bool connectionAvailable = Utils.openConnection(connection, lblStatus);

            if (connectionAvailable)
            {
                try
                {
                    cmd = connection.CreateCommand();
                    cmd.CommandText = TeamTable.SELECT_ID_AND_NUMBER;
                    MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                    DataSet ds = new DataSet();
                    adap.Fill(ds);

                    foreach (ComboBox combo in teamComboList)
                    {
                        combo.BindingContext = new BindingContext();
                        combo.DataSource = ds.Tables[0].DefaultView;
                        combo.ValueMember = TeamTable.COL_ID;
                        combo.DisplayMember = TeamTable.COL_TEAM_NUMBER;
                        //cmbCompetitionName.SelectedValue = this.compID;
                    }
                }
                catch (MySql.Data.MySqlClient.MySqlException)
                {
                    string message = "Unable to open MySQL connection - check if the database is installed and running!";
                    Console.Out.WriteLine(message);
                    lblStatus.Text = message;
                }
                catch (Exception)
                {
                    string message = "Unknown error - check if the database is installed and running!";
                    Console.Out.WriteLine(message);
                    lblStatus.Text = message;
                }
                finally
                {
                    if (connection.State == System.Data.ConnectionState.Open)
                    {
                        connection.Close();
                    }
                }
            }
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            SaveData(true);
        }

        private void btnSaveAndAddNew_Click(object sender, EventArgs e)
        {
            SaveData(false);
        }

        private void SaveData(bool exit)
        {
            MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
            MySqlCommand cmd;
            bool saved = true, validated = true;
            long[] teamIDs = new long[]{-1, -1, -1, -1, -1, -1};
            string[] alliancePositions = new string[] { "Blue1", "Blue2", "Blue3", "Red1", "Red2", "Red3" };
            
            connection.Open();

            try
            {
                teamIDs[0] = Utils.getLongIDFromComboSelectedValue(cmbBlue1, lblStatus);
                teamIDs[1] = Utils.getLongIDFromComboSelectedValue(cmbBlue2, lblStatus);
                teamIDs[2] = Utils.getLongIDFromComboSelectedValue(cmbBlue3, lblStatus);
                teamIDs[3] = Utils.getLongIDFromComboSelectedValue(cmbRed1, lblStatus);
                teamIDs[4] = Utils.getLongIDFromComboSelectedValue(cmbRed2, lblStatus);
                teamIDs[5] = Utils.getLongIDFromComboSelectedValue(cmbRed3, lblStatus);
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
                    cmd.CommandText = MatchTable.INSERT_RECORD;

                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_EVENT_ID, this.compID);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_MATCH_COMP_LEVEL, txtMatchType.Text);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_MATCH_NUMBER, int.Parse(txtMatchNumber.Text));
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_MATCH_STATUS, "");

                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_RED_1, teamIDs[3]);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_RED_2, teamIDs[4]);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_RED_3, teamIDs[5]);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_RED_AUTO_SCORE, 0);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_RED_TELEOP_SCORE, 0);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_RED_TOTAL_SCORE, 0);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_RED_QP, 0);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_RED_FOUL_POINTS, 0);

                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_BLUE_1, teamIDs[0]);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_BLUE_2, teamIDs[1]);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_BLUE_3, teamIDs[2]);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_BLUE_AUTO_SCORE, 0);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_BLUE_TELEOP_SCORE, 0);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_BLUE_TOTAL_SCORE, 0);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_BLUE_QP, 0);
                    cmd.Parameters.AddWithValue("@" + MatchTable.COL_BLUE_FOUL_POINTS, 0);

                    cmd.Parameters.AddWithValue("@" + MatchTable.COLUMN_NAME_MATCH_WINNER, "");
                    cmd.Parameters.AddWithValue("@" + MatchTable.COLUMN_NAME_DRIVE_TEAM_COMMENTS, "");

                    cmd.ExecuteNonQuery();
                    long match_id = cmd.LastInsertedId;
                    //long tablet_id = 0;
                    cmd.Parameters.Clear();

                    cmd.CommandText = TeamMatchTable.INSERT_RECORD;

                    cmd.Parameters.AddWithValue("@" + TeamMatchTable.COL_TEAM_ID, 0);
                    cmd.Parameters.AddWithValue("@" + TeamMatchTable.COL_MATCH_ID, 0);
                    //cmd.Parameters.AddWithValue("@" + TeamMatchTable.COL_EVENT_ID, 0);
                    cmd.Parameters.AddWithValue("@" + TeamMatchTable.COL_POSITION, "");
                    cmd.Parameters.AddWithValue("@" + TeamMatchTable.COL_ALLIANCE, "");

                    for (int tm = 0; tm < teamIDs.Length; tm++)
                    {
                        cmd.Parameters["@" + TeamMatchTable.COL_TEAM_ID].Value = teamIDs[tm];
                        cmd.Parameters["@" + TeamMatchTable.COL_MATCH_ID].Value = match_id;
                        //cmd.Parameters["@" + TeamMatchTable.COL_EVENT_ID].Value = this.compID;
                        cmd.Parameters["@" + TeamMatchTable.COL_POSITION].Value = (tm % 3) + 1 ;
                        cmd.Parameters["@" + TeamMatchTable.COL_ALLIANCE].Value = (tm < 3) ? "Blue" : "Red";

                        cmd.ExecuteNonQuery();
                    }

                }
                catch (Exception)
                {
                    saved = false;
                    lblStatus.Text = "Failed to save data, check that database is active, and verify data is entered correctly";
                    //throw;
                }
                finally
                {
                    if (connection.State == System.Data.ConnectionState.Open)
                    {
                        connection.Close();
                    }
                }
            }

            if (saved)
            {
                if (exit)
                {
                    MatchListForm formObj = (MatchListForm)Application.OpenForms["Form1"];
                    formObj.LoadData();
                    this.Close();
                }
                else
                {
                    txtMatchNumber.Text = "";
                    txtMatchTime.Text = "";
                    txtMatchType.Text = "Qualification";
                    txtMatchLocation.Text = "";
                    cmbBlue1.Text = "";
                    cmbBlue2.Text = "";
                    cmbBlue3.Text = "";
                    cmbRed1.Text = "";
                    cmbRed2.Text = "";
                    cmbRed3.Text = "";
                }
            }
        }

        private void cmbCompetitionName_SelectedValueChanged(object sender, EventArgs e)
        {
            object val = cmbCompetitionName.SelectedValue;
            if (this.initSentinal && val.GetType() != typeof(DataRowView))
            {
                this.compID = Utils.getLongIDFromComboSelectedValue(cmbCompetitionName, lblStatus);
                DataRowView drv = (DataRowView)cmbCompetitionName.SelectedItem;
                txtMatchLocation.Text = drv.Row[EventTable.COL_LOCATION].ToString();
            }
        }
    }
}
