using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace XeroScouterDBManage_Server
{
    public partial class CompetitionSelectForm : Form
    {
        private long seasonID;
        private long competitionID;
        public CompetitionSelectForm()
        {
            InitializeComponent();
            seasonID = Properties.Settings.Default.SeasonID;
            competitionID = Properties.Settings.Default.CompetitionID;
            LoadCompetitions();
        }

        public void LoadCompetitions()
        {
            MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
            MySqlCommand cmd;
            bool connectionAvailable = Utils.openConnection(connection, sslblStatus);

            if (connectionAvailable)
            {
                try
                {
                    cmd = connection.CreateCommand();
                    cmd.CommandText = "SELECT _id, competition_name, competition_location FROM competition_data";
                    MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                    DataSet ds = new DataSet();
                    adap.Fill(ds);
                    cmbCompetitionName.DataSource = ds.Tables[0].DefaultView;
                    cmbCompetitionName.ValueMember = "_id";
                    cmbCompetitionName.DisplayMember = "competition_name";
                }
                catch (MySql.Data.MySqlClient.MySqlException)
                {
                    Console.Out.WriteLine("Unable to open MySQL connection - check if the database is installed and running!");
                    sslblStatus.Text = "Unable to open MySQL connection - check if the database is installed and running!";
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

        private void cmbCompetitionName_SelectedValueChanged(object sender, EventArgs e)
        {
            long val = Utils.getLongIDFromComboSelectedValue(cmbCompetitionName, sslblStatus);
            if (val >= 0)
            {
                this.competitionID = val;
            }
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            Properties.Settings.Default.CompetitionID = competitionID;
            Properties.Settings.Default.Save();
            this.Close();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
