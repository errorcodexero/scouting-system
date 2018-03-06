using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Windows.Forms;
using XeroScouterDBManage_Server.DatabaseInfo;

namespace XeroScouterDBManage_Server
{
    public partial class AddPitDataForm : Form
    {
        private bool cancelling;
        private String statusMessage;
        private bool scouterDataFound;

        private Dictionary<Control, String> dictPitDataControls;
        private Dictionary<String, Control> dictPitDataNames;

        enum FUEL_INDEX
        {
            GROUND_COLLECT,
            FEEDER_COLLECT,
            HOPPER_COLLECT,
            SCORE_LOW,
            SCORE_HIGH
        }

        enum GEAR_INDEX
        {
            GROUND_COLLECT,
            FEEDER_COLLECT,
            SCORE,
            DROP
        }

        enum MISC_INDEX
        {
            CLIMB,
            ACTIVATE_TOUCHPAD,
            USES_OWN_ROPE,
            DEFENSIVE
        }

        public AddPitDataForm()
        {
            InitializeComponent();

            // The dictionaries help map from control to description string, and description string to action_type_id
            // once the maps are hard-coded, we can iterate through the controls and insert a record for each action_type_id
            this.dictPitDataControls = new Dictionary<Control, String>(); // maps UI control to pit data item
            this.dictPitDataNames = new Dictionary<string, Control>(); // maps names to controls

            statusMessage = "---";
            LoadTeams();
        }

        private void mapActionTypeControls()
        {
            this.dictPitDataControls.Add(this.txtTeamName, TeamTable.COL_TEAM_NAME);
            this.dictPitDataControls.Add(this.txtLongTeamName, TeamTable.COL_TEAM_LONG_NAME);
            this.dictPitDataControls.Add(this.txtCity, TeamTable.COL_TEAM_CITY);
            this.dictPitDataControls.Add(this.txtCountry, TeamTable.COL_TEAM_COUNTRY);
            this.dictPitDataControls.Add(this.txtDescription, TeamTable.COL_ROBOT_DESCRIPTION);
            this.dictPitDataControls.Add(this.txtMotorCount, TeamTable.COL_ROBOT_DRIVE_MOTOR_COUNT);
            this.dictPitDataControls.Add(this.txtMotto, TeamTable.COL_TEAM_MOTTO);
            this.dictPitDataControls.Add(this.txtRobotDriveBase, TeamTable.COL_ROBOT_DRIVE_TYPE);
            this.dictPitDataControls.Add(this.txtRobotName, TeamTable.COL_ROBOT_NAME);
            this.dictPitDataControls.Add(this.txtRookieYear, TeamTable.COL_TEAM_ROOKIE_YEAR);
            this.dictPitDataControls.Add(this.txtScoutComments, TeamTable.COL_PIT_SCOUT_COMMENTS);
            this.dictPitDataControls.Add(this.txtState, TeamTable.COL_TEAM_STATE_CODE);
            this.dictPitDataControls.Add(this.txtWheelCount, TeamTable.COL_ROBOT_WHEEL_COUNT);
        }

        public void LoadTeams()
        {
            MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
            MySqlCommand cmd;
            bool connectionAvailable = Utils.openConnection(connection);

            if (connectionAvailable)
            {
                try
                {
                    cmd = connection.CreateCommand();
                    cmd.CommandText = TeamTable.SELECT_ID_AND_NUMBER;
                    MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                    DataSet ds = new DataSet();
                    adap.Fill(ds);

                    comboTeamNumber.BindingContext = new BindingContext();
                    comboTeamNumber.DataSource = ds.Tables[0].DefaultView;
                    comboTeamNumber.ValueMember = TeamTable.COL_ID;
                    comboTeamNumber.DisplayMember = TeamTable.COL_TEAM_NUMBER;
                    //cmbCompetitionName.SelectedValue = this.compID;
                }
                catch (MySql.Data.MySqlClient.MySqlException)
                {
                    string message = "Unable to open MySQL connection - check if the database is installed and running!";
                    Console.Out.WriteLine(message);
                    toolStripStatusLabel1.Text = message;
                }
                catch (Exception)
                {
                    string message = "Unknown error - check if the database is installed and running!";
                    Console.Out.WriteLine(message);
                    toolStripStatusLabel1.Text = message;
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

        private void LoadData()
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

            toolStripStatusLabel1.Text = statusMessage;
            toolStripStatusLabel1.ForeColor = System.Drawing.Color.Black;

            foreach(int c in checkedListBoxFuel.SelectedIndices)
            {

            }

            try
            {
                foreach (Control k in dictPitDataControls.Keys)
                {
                    String name;
                    int id;
                    dictPitDataControls.TryGetValue(k, out name);
                    //dictActionTypes.TryGetValue(name, out id);
                    bool hasData = false;
                    //dictUpdatedFieldIDs.TryGetValue(id, out hasData);
                    if (!String.IsNullOrEmpty(k.Text) && !hasData)
                    {
                        Type t = k.GetType();
                        string s = t.Name;
                        switch (s)
                        {
                            case "TextBox":
                                //dictIdToCount.Add(id, Int32.Parse(k.Text));
                                break;
                            case "CheckBox":
                                //dictIdToCount.Add(id, ((((CheckBox)k).Checked) ? 1 : 0));
                                break;
                            case "RadioButton":
                                //dictIdToCount.Add(id, ((((RadioButton)k).Checked) ? 1 : 0));
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

            if (validated)
            {
                try
                {
                    cmd = connection.CreateCommand();

                    cmd.CommandText = TeamMatchActionTable.getInsertRecordQuery();

                    cmd.Parameters.AddWithValue("@" + TeamMatchActionTable.COL_ID, 0);

                    foreach (Int32 id in dictIdToCount.Keys)
                    {
                        int count = 0;
                        dictIdToCount.TryGetValue(id, out count);
                        cmd.Parameters["@" + TeamMatchActionTable.COL_ID].Value = 0; /// TODO - Update this

                        cmd.ExecuteNonQuery();
                        Program.TEAM_MATCH_ACTION_ID++;
                    }

                    if (!scouterDataFound)
                    {
                        //cmd.CommandText = TeamMatchTable.getUpdateScouterQuery(this.teamMatchID, scoutName);
                        //int numRowsUpdated = cmd.ExecuteNonQuery();
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
            }
            else
            {
                MessageBox.Show("Save failed, please try again.");
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
            Close();
        }
    }
}
