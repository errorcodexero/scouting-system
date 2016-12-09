using System;
using System.Collections.Generic;
using System.Data;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using XeroScouterDBManage;
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
                        combo.BindingContext = new System.Windows.Forms.BindingContext();
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
            long blue1ID = -1, blue2ID = -1, blue3ID = -1, red1ID = -1, red2ID = -1, red3ID = -1;

            connection.Open();

            try
            {
                teamIDs[0] = Utils.getLongIDFromComboSelectedValue(cmbBlue1, lblStatus);
                teamIDs[1] = Utils.getLongIDFromComboSelectedValue(cmbBlue2, lblStatus);
                teamIDs[2] = Utils.getLongIDFromComboSelectedValue(cmbBlue3, lblStatus);
                teamIDs[3] = Utils.getLongIDFromComboSelectedValue(cmbRed1, lblStatus);
                teamIDs[4] = Utils.getLongIDFromComboSelectedValue(cmbRed2, lblStatus);
                teamIDs[5] = Utils.getLongIDFromComboSelectedValue(cmbRed3, lblStatus);

                blue1ID = Utils.getLongIDFromComboSelectedValue(cmbBlue1, lblStatus);
                blue2ID = Utils.getLongIDFromComboSelectedValue(cmbBlue2, lblStatus);
                blue3ID = Utils.getLongIDFromComboSelectedValue(cmbBlue3, lblStatus);
                red1ID = Utils.getLongIDFromComboSelectedValue(cmbRed1, lblStatus);
                red2ID = Utils.getLongIDFromComboSelectedValue(cmbRed2, lblStatus);
                red3ID = Utils.getLongIDFromComboSelectedValue(cmbRed3, lblStatus);
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
                    cmd.CommandText = "INSERT INTO match_data(tablet_id, competition_id, match_number, match_type, match_time, match_location," +
                    "blue_team_one_id, blue_team_two_id, blue_team_three_id, red_team_one_id, red_team_two_id, red_team_three_id, ready_to_export)" +
                    "VALUES(@tabletID, @competitionID, @matchNumber, @matchType, @matchTime, @matchLocation," +
                    "@blueTeamOneId, @blueTeamTwoId, @blueTeamThreeId, @redTeamOneId, @redTeamTwoId, @redTeamThreeId, @readyToExport)";

                    cmd.Parameters.AddWithValue("@tabletID", 0);
                    cmd.Parameters.AddWithValue("@competitionID", this.compID);
                    cmd.Parameters.AddWithValue("@matchNumber", int.Parse(txtMatchNumber.Text));
                    cmd.Parameters.AddWithValue("@matchType", txtMatchType.Text);
                    cmd.Parameters.AddWithValue("@matchTime", txtMatchTime.Text);
                    cmd.Parameters.AddWithValue("@matchLocation", txtMatchLocation.Text);
                    cmd.Parameters.AddWithValue("@blueTeamOneId", teamIDs[0]); //blue1ID);
                    cmd.Parameters.AddWithValue("@blueTeamTwoId", teamIDs[1]); //blue2ID);
                    cmd.Parameters.AddWithValue("@blueTeamThreeId", teamIDs[2]); //blue3ID);
                    cmd.Parameters.AddWithValue("@redTeamOneId", teamIDs[3]); //red1ID);
                    cmd.Parameters.AddWithValue("@redTeamTwoId", teamIDs[4]); //red2ID);
                    cmd.Parameters.AddWithValue("@redTeamThreeId", teamIDs[5]); //red3ID);
                    cmd.Parameters.AddWithValue("@readyToExport", "false");

                    cmd.ExecuteNonQuery();
                    long match_id = cmd.LastInsertedId;
                    long tablet_id = 0;
                    cmd.Parameters.Clear();

                    cmd.CommandText = 
                    "INSERT INTO team_match(tablet_id, team_id, match_id, competition_id, alliance_position, " +
                    "broke_down, no_move, lost_connection, starting_location, starting_location_X, starting_location_Y, starting_location_on_field, " +
                    "auto_totes_picked_up, auto_totes_stacked, auto_totes_scored, auto_cans_picked_up, auto_cans_scored, auto_cans_pulled_from_step, " +
                    "auto_mode_saved, auto_final_location_X, auto_final_location_Y, auto_tote_1_location_X, auto_tote_1_location_Y, " +
                    "auto_tote_2_location_X, auto_tote_2_location_Y, auto_tote_3_location_X, auto_tote_3_location_Y, " +
                    "auto_can_1_location_X, auto_can_1_location_Y, auto_can_2_location_X, auto_can_2_location_Y, auto_can_3_location_X, " +
                    "auto_can_3_location_Y, auto_can_4_location_X, auto_can_4_location_Y, auto_can_5_location_X, auto_can_5_location_Y, " +
                    "auto_can_6_location_X, auto_can_6_location_Y, auto_can_7_location_X, auto_can_7_location_Y, " +
                    "auto_robot_visible, auto_tote1_visible, auto_tote2_visible, auto_tote3_visible, auto_can1_visible, " +
                    "auto_can2_visible, auto_can3_visible, auto_can4_visible, auto_can5_visible, auto_can6_visible, auto_can7_visible, " +
                    "auto_robot_stack_list, team_match_notes, tote_stacker, can_kinger, cooperative, " +
                    "noodler, ni, tote_control_inside_robot, tote_control_fork_lift, tote_control_handle_grabber, " +
                    "tote_control_drop_alot, tote_control_great_control, ready_to_export)" +
                    "VALUES(@tablet_id, @team_id, @match_id, @competition_id, @alliance_position, " +
                    "@broke_down, @no_move, @lost_connection, @starting_location, @starting_location_X, @starting_location_Y, @starting_location_on_field, " +
                    "@auto_totes_picked_up, @auto_totes_stacked, @auto_totes_scored, @auto_cans_picked_up, @auto_cans_scored, @auto_cans_pulled_from_step, " +
                    "@auto_mode_saved, @auto_final_location_X, @auto_final_location_Y, @auto_tote_1_location_X, @auto_tote_1_location_Y, " +
                    "@auto_tote_2_location_X, @auto_tote_2_location_Y, @auto_tote_3_location_X, @auto_tote_3_location_Y, " +
                    "@auto_can_1_location_X, @auto_can_1_location_Y, @auto_can_2_location_X, @auto_can_2_location_Y, @auto_can_3_location_X, " +
                    "@auto_can_3_location_Y, @auto_can_4_location_X, @auto_can_4_location_Y, @auto_can_5_location_X, @auto_can_5_location_Y, " +
                    "@auto_can_6_location_X, @auto_can_6_location_Y, @auto_can_7_location_X, @auto_can_7_location_Y, " +
                    "@auto_robot_visible, @auto_tote1_visible, @auto_tote2_visible, @auto_tote3_visible, @auto_can1_visible, " +
                    "@auto_can2_visible, @auto_can3_visible, @auto_can4_visible, @auto_can5_visible, @auto_can6_visible, @auto_can7_visible, " +
                    "@auto_robot_stack_list, @team_match_notes, @tote_stacker, @can_kinger, @cooperative, " +
                    "@noodler, @ni, @tote_control_inside_robot, @tote_control_fork_lift, @tote_control_handle_grabber, " +
                    "@tote_control_drop_alot, @tote_control_great_control, @ready_to_export)";

                    cmd.Parameters.AddWithValue("@tablet_id", tablet_id);
                    cmd.Parameters.AddWithValue("@team_id", 0);
                    cmd.Parameters.AddWithValue("@match_id", 0);
                    cmd.Parameters.AddWithValue("@competition_id", 0);
                    cmd.Parameters.AddWithValue("@alliance_position", "");
                    cmd.Parameters.AddWithValue("@broke_down", "false");
                    cmd.Parameters.AddWithValue("@no_move", "false");
                    cmd.Parameters.AddWithValue("@lost_connection", "false");
                    cmd.Parameters.AddWithValue("@starting_location", 0);
                    cmd.Parameters.AddWithValue("@starting_location_X", 0);
                    cmd.Parameters.AddWithValue("@starting_location_Y", 0);
                    cmd.Parameters.AddWithValue("@starting_location_on_field", 0);
                    cmd.Parameters.AddWithValue("@auto_totes_picked_up", 0);
                    cmd.Parameters.AddWithValue("@auto_totes_stacked", 0);
                    cmd.Parameters.AddWithValue("@auto_totes_scored", 0);
                    cmd.Parameters.AddWithValue("@auto_cans_picked_up", 0);
                    cmd.Parameters.AddWithValue("@auto_cans_scored", 0);
                    cmd.Parameters.AddWithValue("@auto_cans_pulled_from_step", 0);
                    cmd.Parameters.AddWithValue("@auto_mode_saved", "false");
                    cmd.Parameters.AddWithValue("@auto_final_location_X", 0);
                    cmd.Parameters.AddWithValue("@auto_final_location_Y", 0);
                    cmd.Parameters.AddWithValue("@auto_tote_1_location_X", 0);
                    cmd.Parameters.AddWithValue("@auto_tote_1_location_Y", 0);
                    cmd.Parameters.AddWithValue("@auto_tote_2_location_X", 0);
                    cmd.Parameters.AddWithValue("@auto_tote_2_location_Y", 0);
                    cmd.Parameters.AddWithValue("@auto_tote_3_location_X", 0);
                    cmd.Parameters.AddWithValue("@auto_tote_3_location_Y", 0);
                    cmd.Parameters.AddWithValue("@auto_can_1_location_X", 0);
                    cmd.Parameters.AddWithValue("@auto_can_1_location_Y", 0);
                    cmd.Parameters.AddWithValue("@auto_can_2_location_X", 0);
                    cmd.Parameters.AddWithValue("@auto_can_2_location_Y", 0);
                    cmd.Parameters.AddWithValue("@auto_can_3_location_X", 0);
                    cmd.Parameters.AddWithValue("@auto_can_3_location_Y", 0);
                    cmd.Parameters.AddWithValue("@auto_can_4_location_X", 0);
                    cmd.Parameters.AddWithValue("@auto_can_4_location_Y", 0);
                    cmd.Parameters.AddWithValue("@auto_can_5_location_X", 0);
                    cmd.Parameters.AddWithValue("@auto_can_5_location_Y", 0);
                    cmd.Parameters.AddWithValue("@auto_can_6_location_X", 0);
                    cmd.Parameters.AddWithValue("@auto_can_6_location_Y", 0);
                    cmd.Parameters.AddWithValue("@auto_can_7_location_X", 0);
                    cmd.Parameters.AddWithValue("@auto_can_7_location_Y", 0);
                    cmd.Parameters.AddWithValue("@auto_robot_visible", "false");
                    cmd.Parameters.AddWithValue("@auto_tote1_visible", "false");
                    cmd.Parameters.AddWithValue("@auto_tote2_visible", "false");
                    cmd.Parameters.AddWithValue("@auto_tote3_visible", "false");
                    cmd.Parameters.AddWithValue("@auto_can1_visible", "false");
                    cmd.Parameters.AddWithValue("@auto_can2_visible", "false");
                    cmd.Parameters.AddWithValue("@auto_can3_visible", "false");
                    cmd.Parameters.AddWithValue("@auto_can4_visible", "false");
                    cmd.Parameters.AddWithValue("@auto_can5_visible", "false");
                    cmd.Parameters.AddWithValue("@auto_can6_visible", "false");
                    cmd.Parameters.AddWithValue("@auto_can7_visible", "false");
                    cmd.Parameters.AddWithValue("@auto_robot_stack_list", "");
                    cmd.Parameters.AddWithValue("@team_match_notes", "");
                    cmd.Parameters.AddWithValue("@tote_stacker", "false");
                    cmd.Parameters.AddWithValue("@can_kinger", "false");
                    cmd.Parameters.AddWithValue("@cooperative", "false");
                    cmd.Parameters.AddWithValue("@noodler", "false");
                    cmd.Parameters.AddWithValue("@ni", "false");
                    cmd.Parameters.AddWithValue("@tote_control_inside_robot", "false");
                    cmd.Parameters.AddWithValue("@tote_control_fork_lift", "false");
                    cmd.Parameters.AddWithValue("@tote_control_handle_grabber", "false");
                    cmd.Parameters.AddWithValue("@tote_control_drop_alot", "false");
                    cmd.Parameters.AddWithValue("@tote_control_great_control", "false");
                    cmd.Parameters.AddWithValue("@ready_to_export", "false");

                    for (int tm = 0; tm < teamIDs.Length; tm++)
                    {
                        cmd.Parameters["@tablet_id"].Value = tablet_id;
                        cmd.Parameters["@team_id"].Value = teamIDs[tm];
                        cmd.Parameters["@match_id"].Value = match_id;
                        cmd.Parameters["@competition_id"].Value = this.compID;
                        cmd.Parameters["@alliance_position"].Value = alliancePositions[tm];
                        cmd.Parameters["@broke_down"].Value = "false";
                        cmd.Parameters["@no_move"].Value = "false";
                        cmd.Parameters["@lost_connection"].Value = "false";
                        cmd.Parameters["@starting_location"].Value = 0;
                        cmd.Parameters["@starting_location_X"].Value = 0;
                        cmd.Parameters["@starting_location_Y"].Value = 0;
                        cmd.Parameters["@starting_location_on_field"].Value = 0;
                        cmd.Parameters["@auto_totes_picked_up"].Value = 0;
                        cmd.Parameters["@auto_totes_stacked"].Value = 0;
                        cmd.Parameters["@auto_totes_scored"].Value = 0;
                        cmd.Parameters["@auto_cans_picked_up"].Value = 0;
                        cmd.Parameters["@auto_cans_scored"].Value = 0;
                        cmd.Parameters["@auto_cans_pulled_from_step"].Value = 0;
                        cmd.Parameters["@auto_mode_saved"].Value = "false";
                        cmd.Parameters["@auto_final_location_X"].Value = 0;
                        cmd.Parameters["@auto_final_location_Y"].Value = 0;
                        cmd.Parameters["@auto_tote_1_location_X"].Value = 0;
                        cmd.Parameters["@auto_tote_1_location_Y"].Value = 0;
                        cmd.Parameters["@auto_tote_2_location_X"].Value = 0;
                        cmd.Parameters["@auto_tote_2_location_Y"].Value = 0;
                        cmd.Parameters["@auto_tote_3_location_X"].Value = 0;
                        cmd.Parameters["@auto_tote_3_location_Y"].Value = 0;
                        cmd.Parameters["@auto_can_1_location_X"].Value = 0;
                        cmd.Parameters["@auto_can_1_location_Y"].Value = 0;
                        cmd.Parameters["@auto_can_2_location_X"].Value = 0;
                        cmd.Parameters["@auto_can_2_location_Y"].Value = 0;
                        cmd.Parameters["@auto_can_3_location_X"].Value = 0;
                        cmd.Parameters["@auto_can_3_location_Y"].Value = 0;
                        cmd.Parameters["@auto_can_4_location_X"].Value = 0;
                        cmd.Parameters["@auto_can_4_location_Y"].Value = 0;
                        cmd.Parameters["@auto_can_5_location_X"].Value = 0;
                        cmd.Parameters["@auto_can_5_location_Y"].Value = 0;
                        cmd.Parameters["@auto_can_6_location_X"].Value = 0;
                        cmd.Parameters["@auto_can_6_location_Y"].Value = 0;
                        cmd.Parameters["@auto_can_7_location_X"].Value = 0;
                        cmd.Parameters["@auto_can_7_location_Y"].Value = 0;
                        cmd.Parameters["@auto_robot_visible"].Value = "false";
                        cmd.Parameters["@auto_tote1_visible"].Value = "false";
                        cmd.Parameters["@auto_tote2_visible"].Value = "false";
                        cmd.Parameters["@auto_tote3_visible"].Value = "false";
                        cmd.Parameters["@auto_can1_visible"].Value = "false";
                        cmd.Parameters["@auto_can2_visible"].Value = "false";
                        cmd.Parameters["@auto_can3_visible"].Value = "false";
                        cmd.Parameters["@auto_can4_visible"].Value = "false";
                        cmd.Parameters["@auto_can5_visible"].Value = "false";
                        cmd.Parameters["@auto_can6_visible"].Value = "false";
                        cmd.Parameters["@auto_can7_visible"].Value = "false";
                        cmd.Parameters["@auto_robot_stack_list"].Value = "none";
                        cmd.Parameters["@team_match_notes"].Value = "none";
                        cmd.Parameters["@tote_stacker"].Value = "false";
                        cmd.Parameters["@can_kinger"].Value = "false";
                        cmd.Parameters["@cooperative"].Value = "false";
                        cmd.Parameters["@noodler"].Value = "false";
                        cmd.Parameters["@ni"].Value = "false";
                        cmd.Parameters["@tote_control_inside_robot"].Value = "false";
                        cmd.Parameters["@tote_control_fork_lift"].Value = "false";
                        cmd.Parameters["@tote_control_handle_grabber"].Value = "false";
                        cmd.Parameters["@tote_control_drop_alot"].Value = "false";
                        cmd.Parameters["@tote_control_great_control"].Value = "false";
                        cmd.Parameters["@ready_to_export"].Value = "false";

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
