using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using XeroScouterDBManage;

namespace XeroScouterDBManage_Server
{
    public partial class MatchListForm : Form
    {
        long competitionID;
        long seasonID;
        public MatchListForm()
        {
            InitializeComponent();
            this.competitionID = Properties.Settings.Default.CompetitionID;
            this.seasonID = Properties.Settings.Default.SeasonID;
            this.loadSelectedSeason();
            loadSelectedCompetition();
            //LoadCompetitions();
            LoadData();

            if (Program.TEST_MODE)
            {
                lblTestMode.Text = " **** TEST MODE ****";
            }
        }

        public void loadSelectedCompetition()
        {
            string compLabeltext = string.Empty;
            if (this.competitionID < 0)
            {
                compLabeltext = "No Competition Selected";
            }
            else
            {
                MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
                MySqlCommand cmd;
                bool connectionAvailable = Utils.openConnection(connection, lblStatus);

                if (connectionAvailable)
                {
                    try
                    {
                        cmd = connection.CreateCommand();
                        cmd.CommandText = "SELECT competition_name FROM competition_data WHERE _id=" + this.competitionID;
                        MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                        DataSet ds = new DataSet();
                        adap.Fill(ds);
                        compLabeltext = ds.Tables[0].Rows[0]["competition_name"].ToString();
                        //cmbCompetitionName.DataSource = ds.Tables[0].DefaultView;
                        //cmbCompetitionName.ValueMember = "_id";
                        //cmbCompetitionName.DisplayMember = "competition_name";
                    }
                    catch (MySql.Data.MySqlClient.MySqlException)
                    {
                        Console.Out.WriteLine("Unable to open MySQL connection - check if the database is installed and running!");
                    }
                    catch (Exception)
                    {
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
            lblCompetitionValue.Text = compLabeltext;
        }

        public void loadSelectedSeason()
        {
            string seasonLabeltext = string.Empty;
            if (this.seasonID < 0)
            {
                seasonLabeltext = "No Competition Selected";
            }
            else
            {
                MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
                MySqlCommand cmd;
                bool connectionAvailable = Utils.openConnection(connection, lblStatus);

                if (connectionAvailable)
                {
                    try
                    {
                        cmd = connection.CreateCommand();
                        cmd.CommandText = "SELECT season_name FROM season_data WHERE _id=" + this.seasonID;
                        MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                        DataSet ds = new DataSet();
                        adap.Fill(ds);
                        seasonLabeltext = ds.Tables[0].Rows[0]["season_name"].ToString();
                    }
                    catch (MySql.Data.MySqlClient.MySqlException)
                    {
                        Console.Out.WriteLine("Unable to open MySQL connection - check if the database is installed and running!");
                    }
                    catch (Exception)
                    {
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
            lblSeasonValue.Text = seasonLabeltext;
        }

        public void LoadData()
        {
            if (this.competitionID < 0) return;
            //long compID = Utils.getLongIDFromComboSelectedValue(cmbCompetitionName, lblStatus);

            MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
            MySqlCommand cmd;
            bool connectionAvailable = Utils.openConnection(connection, lblStatus);

            if (connectionAvailable)
            {
                try
                {
                    cmd = connection.CreateCommand();
                    
                    string query = "SELECT match_number AS 'Match Number'," +
		            " match_time AS 'Match Time'," +
                    " match_type AS 'Match Type'," +
                    " match_location AS 'Match Location'," +
                    " (SELECT team_data.team_number FROM team_data WHERE team_data._id = match_data.blue_team_one_id) AS 'Blue One'," +
                    " (SELECT team_data.team_number FROM team_data WHERE team_data._id = match_data.blue_team_two_id) AS 'Blue Two'," +
                    " (SELECT team_data.team_number FROM team_data WHERE team_data._id = match_data.blue_team_three_id) AS 'Blue Three'," +
                    " (SELECT team_data.team_number FROM team_data WHERE team_data._id = match_data.red_team_one_id) AS 'Red One'," +
                    " (SELECT team_data.team_number FROM team_data WHERE team_data._id = match_data.red_team_two_id) AS 'Red Two'," +
                    " (SELECT team_data.team_number FROM team_data WHERE team_data._id = match_data.red_team_three_id) AS 'Red Three'" +
                    " FROM match_data" +
                    " WHERE competition_id=" + this.competitionID;

                    cmd.CommandText = query;
 
                    MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                    
                    DataSet ds = new DataSet();
                    adap.Fill(ds);
                    gridMatchList.DataSource = ds.Tables[0].DefaultView;
                }
                catch (MySql.Data.MySqlClient.MySqlException)
                {
                    string message = "Unable to open MySQL connection - check if the database is installed and running!";
                    Console.Out.WriteLine(message);
                    lblStatus.Text = message;
                }
                catch (Exception)
                {
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

        private void btnAddMatch_Click(object sender, EventArgs e)
        {
            if (this.competitionID < 0) return;
            AddMatchForm amForm = new AddMatchForm(this.competitionID);
            amForm.Show();
            //this.LoadData();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnRefreshData_Click(object sender, EventArgs e)
        {
            this.LoadData();
        }

        private void btnExportData_Click(object sender, EventArgs e)
        {
            if (this.competitionID < 0) return;
            ExportDataForm exportForm = new ExportDataForm(this.competitionID);
            exportForm.Show();
        }

        private void btnImportData_Click(object sender, EventArgs e)
        {
            if (this.competitionID < 0) return;
            ImportDataForm importForm = new ImportDataForm(this.competitionID);
            importForm.Show();
        }

        private void btnSetCompetition_Click(object sender, EventArgs e)
        {
            CompetitionSelectForm compSelect = new CompetitionSelectForm();
            System.Windows.Forms.DialogResult res = compSelect.ShowDialog();
            if (res == System.Windows.Forms.DialogResult.OK)
            {
                this.competitionID = Properties.Settings.Default.CompetitionID;
                this.loadSelectedCompetition();
                this.LoadData();
            }
        }

        private void btnSetSeason_Click(object sender, EventArgs e)
        {
            SeasonSelectForm seasonSelect = new SeasonSelectForm();
            System.Windows.Forms.DialogResult res = seasonSelect.ShowDialog();
            if (res == System.Windows.Forms.DialogResult.OK)
            {
                this.seasonID = Properties.Settings.Default.SeasonID;
                this.loadSelectedSeason();
                this.competitionID = -1;
                Properties.Settings.Default.CompetitionID = -1;
                Properties.Settings.Default.Save();
                lblCompetitionValue.Text = "No Competition Selected";
                this.LoadData();
            }
        }
    }
}
