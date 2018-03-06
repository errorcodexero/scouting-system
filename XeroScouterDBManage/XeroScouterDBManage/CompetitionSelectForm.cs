using System;
using System.Data;
using System.Net;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using XeroScouterDBManage_Server.DatabaseInfo;
using System.Collections.Generic;

namespace XeroScouterDBManage_Server
{
    public partial class CompetitionSelectForm : Form
    {
        private long seasonID;
        private long competitionID;
        private int competitionIndex;
        private String competitionType;
        private String competitionDefinitionFile;
        private Dictionary<long, String> eventDefinitionFileList;
        private bool definitionFileChanged = false;
        private bool formInitialized = false;
        public CompetitionSelectForm()
        {
            InitializeComponent();
            seasonID = Properties.Settings.Default.SeasonID;
            competitionID = Properties.Settings.Default.CompetitionID;
            competitionIndex = 0;
            competitionDefinitionFile = Properties.Settings.Default.DefinitionFileName;
            eventDefinitionFileList = new Dictionary<long, string>();
            competitionType = "District";
            cmbYear.SelectedIndex = 0;
            cmbEventType.SelectedIndex = 1;
            LoadDistricts();
            LoadCompetitions();
            formInitialized = true;
        }

        public void LoadDistricts()
        {
            Int32 year = 2018;
            Int32.TryParse(cmbYear.Text, out year);
            if (year == 0)
            {
                year = 2018;
            }

            MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
            MySqlCommand cmd;
            bool connectionAvailable = Utils.openConnection(connection, sslblStatus);

            if (connectionAvailable)
            {
                try
                {
                    cmd = connection.CreateCommand();
                    cmd.CommandText = EventTable.getDistrictsByYear(year);
                    MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                    DataSet ds = new DataSet();
                    adap.Fill(ds);

                    cmbDistrict.DataSource = ds.Tables[0].DefaultView;
                    cmbDistrict.ValueMember = EventTable.COL_EVENT_DISTRICT;
                    cmbDistrict.DisplayMember = EventTable.COL_EVENT_DISTRICT;
                    cmbDistrict.SelectedIndex = 0;
                }
                catch (MySql.Data.MySqlClient.MySqlException)
                {
                    Console.Out.WriteLine("Unable to open MySQL connection - check if the database is installed and running!");
                    sslblStatus.Text = "Unable to open MySQL connection - check if the database is installed and running!";
                }
                catch (Exception)
                {
                    sslblStatus.Text = "General exception!!";
                    throw;
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

        public void LoadCompetitions()
        {
            Int32 year = 2018;
            Int32.TryParse(cmbYear.Text, out year);
            if(year == 0)
            {
                year = 2018;
            }

            String competitionDistrict = (String)cmbDistrict.SelectedValue;

            MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
            MySqlCommand cmd;
            bool connectionAvailable = Utils.openConnection(connection, sslblStatus);

            if (connectionAvailable)
            {
                try
                {
                    cmd = connection.CreateCommand();
                    cmd.CommandText = EventTable.getCompetitionByYear(year, competitionDistrict);
                    MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                    DataSet ds = new DataSet();
                    adap.Fill(ds);

                    if(ds.Tables[0].Rows.Count > 0)
                    {
                        eventDefinitionFileList.Clear();
                    }

                    int index = 0;
                    foreach(DataRow dr in ds.Tables[0].Rows)
                    {
                        long id = (long)(dr.Field<int>(EventTable.COL_ID));
                        if(id == this.competitionID)
                        {
                            this.competitionIndex = index;
                        }
                        String file = dr.Field<String>(EventTable.COL_EVENT_ACTION_DEFINITION_FILE);
                        eventDefinitionFileList.Add(id, file);
                        index++;
                    }
                    cmbCompetitionName.DataSource = ds.Tables[0].DefaultView;
                    cmbCompetitionName.ValueMember = EventTable.COL_ID;
                    cmbCompetitionName.DisplayMember = EventTable.COL_NAME;
                    cmbCompetitionName.SelectedIndex = this.competitionIndex;
                }
                catch (MySql.Data.MySqlClient.MySqlException)
                {
                    Console.Out.WriteLine("Unable to open MySQL connection - check if the database is installed and running!");
                    sslblStatus.Text = "Unable to open MySQL connection - check if the database is installed and running!";
                }
                catch (Exception)
                {
                    sslblStatus.Text = "General exception!!";
                    throw;
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

        private void cmbCompetitionName_SelectedValueChanged(object sender, EventArgs e)
        {
            long val = Utils.getLongIDFromComboSelectedValue(cmbCompetitionName, sslblStatus);
            if (val >= 0)
            {
                this.competitionID = val;
                if (eventDefinitionFileList.ContainsKey(val))
                {
                    competitionDefinitionFile = eventDefinitionFileList[val];
                    txtDefinitionFile.Text = string.Format("{0}", WebUtility.HtmlDecode(competitionDefinitionFile));
                    definitionFileChanged = false;
                }
            }
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            Properties.Settings.Default.CompetitionID = competitionID;
            Properties.Settings.Default.DefinitionFileName = txtDefinitionFile.Text;
            Properties.Settings.Default.Save();

            if(definitionFileChanged)
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

                        cmd.CommandText = EventTable.getUpdateDefinitionFileQuery((Int32)competitionID, WebUtility.HtmlEncode(txtDefinitionFile.Text));
                        int rowsUpdated = cmd.ExecuteNonQuery();
                        
                        if(rowsUpdated < 1)
                        {
                            toolStripStatusLabel1.Text = "Event not found, definition file not updated";
                        }
                    }
                    catch (Exception ex)
                    {
                        Console.Out.WriteLine(ex.StackTrace);
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

            this.Close();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void txtDefinitionFile_TextChanged(object sender, EventArgs e)
        {
            definitionFileChanged = true;
        }

        private void btnSelectConfigFile_Click(object sender, EventArgs e)
        {
            if(this.openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                this.txtDefinitionFile.Text = openFileDialog1.FileName;
                definitionFileChanged = true;
            }
        }

        private void cmbYear_SelectedValueChanged(object sender, EventArgs e)
        {
            if (formInitialized)
            {
                LoadCompetitions();
            }
            
        }

        private void cmbYear_SelectedIndexChanged(object sender, EventArgs e)
        {
            //LoadCompetitions();
        }
    }
}
