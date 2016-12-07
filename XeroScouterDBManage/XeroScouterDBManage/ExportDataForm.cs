using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using MySql.Data.MySqlClient;
using System.IO;
using XeroScouterDBManage;
using XeroScouterDBManage_Server.DatabaseInfo;

namespace XeroScouterDBManage_Server
{
    public partial class ExportDataForm : Form
    {
        private long compID;
        private string exportPath;

        public ExportDataForm(long competition_id)
        {
            this.compID = competition_id;
            this.exportPath = Properties.Settings.Default.ExportPath;
            
            InitializeComponent();
            LoadCompetitions();
            initTableList();

            lblPath.Text = exportPath;
        }

        public void initTableList()
        {
            CheckedListBox.ObjectCollection items = chkTableList.Items;
            items.Add("competition_data");
            items.Add("match_data");
            items.Add("robot_data");
            items.Add("team_data");
            items.Add("team_match");

            chkTableList.Refresh();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
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
                    cmd.CommandText = EventTable.SELECT_ID_NAME_LOC; // "SELECT event_id, name, location FROM event";
                    MySqlDataAdapter adap = new MySqlDataAdapter(cmd);
                    DataSet ds = new DataSet();
                    adap.Fill(ds);
                    cmbCompetitionName.DataSource = ds.Tables[0].DefaultView;
                    cmbCompetitionName.ValueMember = EventTable.COL_ID; // "event_id";
                    cmbCompetitionName.DisplayMember = EventTable.COL_NAME; // "name";
                    cmbCompetitionName.SelectedValue = this.compID;
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

        private void btnExportSelected_Click(object sender, EventArgs e)
        {
            CheckedListBox.CheckedItemCollection checkedStuff = chkTableList.CheckedItems;
            lblStatus.Text = "Items checked: " + checkedStuff.Count;

            foreach(string table in checkedStuff)
            {
                Console.Out.WriteLine("Exporting " + table + " to xml");

                long compID = Utils.getLongIDFromComboSelectedValue(cmbCompetitionName, lblStatus);

                MySqlConnection connection = new MySqlConnection(Utils.getConnectionString());
                MySqlCommand cmd;
                bool connectionAvailable = Utils.openConnection(connection, lblStatus);

                if (connectionAvailable)
                {
                    try
                    {
                        cmd = connection.CreateCommand();
                        cmd.CommandText = "SELECT *" +
                            " FROM " + table;
                        MySqlDataAdapter adap = new MySqlDataAdapter(cmd);

                        DataSet ds = new DataSet();
                        adap.Fill(ds);

                        string path = this.exportPath + "\\ftsData-" + table + "-export.xml";
                        if (File.Exists(path)) File.Delete(path);
                        var fileStream = new FileStream(path, FileMode.Create);
                        ds.WriteXml(fileStream);
                        fileStream.Close();
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
        }

        public void ChooseFolder()
        {
            if (folderBrowserDialog1.ShowDialog() == DialogResult.OK)
            {
                this.exportPath = folderBrowserDialog1.SelectedPath;
                Properties.Settings.Default.ExportPath = exportPath;
                lblPath.Text = exportPath;
                Properties.Settings.Default.Save();
            }
        }

        private void btnSetPath_Click(object sender, EventArgs e)
        {
            ChooseFolder();
        }
    }
}
