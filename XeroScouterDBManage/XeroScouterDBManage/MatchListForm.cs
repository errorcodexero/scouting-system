using System;
using System.Data;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using XeroScouterDBManage_Server.DatabaseInfo;

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
                        cmd.CommandText = EventTable.SELECT_NAME_FROM_MATCHING_ID + this.competitionID;
                        MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                        DataSet ds = new DataSet();
                        adap.Fill(ds);
                        if (ds.Tables.Count > 0 && ds.Tables[0].Rows.Count > 0)
                        {
                            compLabeltext = ds.Tables[0].Rows[0][EventTable.COL_NAME].ToString();
                        } else
                        {
                            Console.Out.WriteLine(String.Format("MatchListForm::LoadSelectedCompetition: Could not find competition with ID=%d", this.competitionID));
                            this.competitionID = -1;
                        }
                        //cmbCompetitionName.DataSource = ds.Tables[0].DefaultView;
                        //cmbCompetitionName.ValueMember = "event_id";
                        //cmbCompetitionName.DisplayMember = "name";
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
            /*
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
            */
        }

        public void LoadData()
        {
            if (this.competitionID < 0) return;

            MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
            MySqlCommand cmd;
            bool connectionAvailable = Utils.openConnection(connection, lblStatus);

            if (connectionAvailable)
            {
                try
                {
                    cmd = connection.CreateCommand();
                    
                    string query = MatchTable.SELECT_MATCH_NUMBER_AND_TEAMS_FROM_ID_PREFIX;
                    query += MatchTable.SELECT_BLUE1_FOR_ID_PART;
					query += MatchTable.COL_BLUE_1 + " AS 'Blue1ID',";
                    query += MatchTable.SELECT_BLUE2_FOR_ID_PART;
					query += MatchTable.COL_BLUE_2 + " AS 'Blue2ID',";
					query += MatchTable.SELECT_BLUE3_FOR_ID_PART;
					query += MatchTable.COL_BLUE_3 + " AS 'Blue3ID',";
					query += MatchTable.SELECT_RED1_FOR_ID_PART;
					query += MatchTable.COL_RED_1 + " AS 'Red1ID',";
					query += MatchTable.SELECT_RED2_FOR_ID_PART;
					query += MatchTable.COL_RED_2 + " AS 'Red2ID',";
					query += MatchTable.SELECT_RED3_FOR_ID_PART;
					query += MatchTable.COL_RED_3 + " AS 'Red3ID'";
					query += MatchTable.FROM_MATCH_FOR_EVENT_ID;
                    query += this.competitionID;

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
            /*
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
            */
        }

        private void gridMatchList_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            /*if (cell.Value == blank)
            {
                if (IsOsTurn())
                {
                    cell.Value = o;
                }
                else
                {
                    cell.Value = x;
                }
                ToggleTurn();
            }*/
        }

        private void gridMatchList_RowHeaderMouseDoubleClick(object sender, DataGridViewCellMouseEventArgs e)
        {
			DataGridViewTextBoxCell cell = (DataGridViewTextBoxCell)gridMatchList.Rows[e.RowIndex].Cells[0];
			MessageBox.Show("Row: " + cell.OwningRow.Index.ToString() + " Team: " + cell.Value.ToString());
        }

		private void gridMatchList_CellDoubleClick(object sender, DataGridViewCellEventArgs e)
		{
			// if clicking the match number, update the match data
			if (e.ColumnIndex == 1 && e.RowIndex >= 0)
			{
				DataGridViewTextBoxCell idCell = (DataGridViewTextBoxCell)gridMatchList.Rows[e.RowIndex].Cells[0];
				UpdateMatchDataForm updateForm = new UpdateMatchDataForm(this.competitionID, (Int32)idCell.Value);
				updateForm.Show();

			} else if (e.ColumnIndex > 1 && e.RowIndex >= 0)
			// if clicking a team number, update the team_match data
			{
				DataGridViewTextBoxCell mIDCell = (DataGridViewTextBoxCell)gridMatchList.Rows[e.RowIndex].Cells[0];
				DataGridViewTextBoxCell tIDCell = (DataGridViewTextBoxCell)gridMatchList.Rows[e.RowIndex].Cells[e.ColumnIndex + 1];
				TeamMatchActionEntryForm entryForm = new TeamMatchActionEntryForm((Int32)mIDCell.Value, (Int32)tIDCell.Value);
				entryForm.Show();
			}
		}

		private void gridMatchList_DataBindingComplete(object sender, DataGridViewBindingCompleteEventArgs e)
		{
			// Hide ID columns
			gridMatchList.Columns[0].Visible = false;
			gridMatchList.Columns[3].Visible = false;
			gridMatchList.Columns[5].Visible = false;
			gridMatchList.Columns[7].Visible = false;
			gridMatchList.Columns[9].Visible = false;
			gridMatchList.Columns[11].Visible = false;
			gridMatchList.Columns[13].Visible = false;
		}

		private void btnAddMatchData_Click(object sender, EventArgs e)
		{
			UpdateMatchDataForm frmUpdateMatchData = new UpdateMatchDataForm(this.competitionID, -1);
			frmUpdateMatchData.Show();
		}
	}
}
