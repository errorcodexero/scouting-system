using System;
using System.Configuration;
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
    public partial class SeasonSelectForm : Form
    {
        private long seasonID;
        public SeasonSelectForm()
        {
            InitializeComponent();
            seasonID = Properties.Settings.Default.SeasonID;
            LoadSeasons();
            if (cmbSeasonYear != null && cmbSeasonYear.HasChildren)
            {
                if (seasonID < 0)
                {
                    cmbSeasonYear.SelectedIndex = 1;
                }
                else
                {
                    cmbSeasonYear.SelectedValue = seasonID;
                }
            }
        }

        public void LoadSeasons()
        {
            MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
            MySqlCommand cmd;
            bool connectionAvailable = Utils.openConnection(connection, sslblStatus);

            if (connectionAvailable)
            {
                try
                {
                    cmd = connection.CreateCommand();
                    cmd.CommandText = "SELECT _id, CONCAT(season_year, ' - ', season_name) AS YEAR FROM season_data";
                    MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                    DataSet ds = new DataSet();
                    adap.Fill(ds);
                    cmbSeasonYear.DataSource = ds.Tables[0].DefaultView;
                    cmbSeasonYear.ValueMember = "_id";
                    cmbSeasonYear.DisplayMember = "YEAR";
                    //cmbSeasonYear.DataSource = this.fTS_TEST_DataSet.season_data.DefaultView;
                    //cmbSeasonYear.ValueMember = "_id";
                    //cmbSeasonYear.DisplayMember = "YEAR";
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

        private void cmbSeasonYear_SelectedValueChanged(object sender, EventArgs e)
        {
            long val = Utils.getLongIDFromComboSelectedValue(cmbSeasonYear, sslblStatus);
            if (val >= 0)
            {
                this.seasonID = val;
            }
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            Properties.Settings.Default.SeasonID = seasonID;
            Properties.Settings.Default.Save();
            this.Close();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
