using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using XeroScouterDBManage_Server.DatabaseInfo;

namespace XeroScouterDBManage_Server
{
    public partial class AddPitDataForm : Form
    {

        public AddPitDataForm()
        {
            InitializeComponent();
            LoadTeams();
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

        private void SaveData()
        {

        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            SaveData();
            Close();
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
