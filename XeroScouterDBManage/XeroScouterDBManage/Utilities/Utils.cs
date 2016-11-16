using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MySql.Data.MySqlClient;
using System.Windows.Forms;
using System.Data;
using System.Configuration;
using XeroScouterDBManage_Server;

namespace XeroScouterDBManage
{
    class Utils
    {
        public static String getConnectionString()
        {
            string csKey = (Program.TEST_MODE) ? "XeroScouterDBManage.Properties.Settings.FTS_TEST_ConnectionString" : "XeroScouterDBManage.Properties.Settings.FTS_ConnectionString";
            ConnectionStringSettings settings = ConfigurationManager.ConnectionStrings[csKey];
            string connectionString = settings.ConnectionString;

            //String connectionString = (Program.TEST_MODE) ? Program.conTestString : Program.conString;
            return connectionString;
        }

        public static bool openConnection(MySqlConnection connection, Label lblStatus)
        {
            bool connectionAvailable = true;

            try
            {
                connection.Open();
            }
            catch (MySql.Data.MySqlClient.MySqlException)
            {
                string message = "Unable to open MySQL connection - check if the database is installed and running!";
                Console.Out.WriteLine(message);
                lblStatus.Text = message;
                connectionAvailable = false;
            }
            catch (Exception)
            {
                string message = "Unknown issue at open - check if the database is installed and running!";
                Console.Out.WriteLine(message);
                lblStatus.Text = message;
                connectionAvailable = false;
            }

            return connectionAvailable;
        }

        public static bool openConnection(MySqlConnection connection, ToolStripLabel lblStatus)
        {
            bool connectionAvailable = true;

            try
            {
                connection.Open();
            }
            catch (MySql.Data.MySqlClient.MySqlException)
            {
                string message = "Unable to open MySQL connection - check if the database is installed and running!";
                Console.Out.WriteLine(message);
                lblStatus.Text = message;
                connectionAvailable = false;
            }
            catch (Exception)
            {
                string message = "Unknown issue at open - check if the database is installed and running!";
                Console.Out.WriteLine(message);
                lblStatus.Text = message;
                connectionAvailable = false;
            }

            return connectionAvailable;
        }

        public static long getLongIDFromComboSelectedValue(ComboBox combo, Label lblStatus)
        {
            long ID = -1;
            
            try
            {
                object val = combo.SelectedValue;
                if ((val != null) && (val.GetType() != typeof(DataRowView)))
                {
                    ID = Convert.ToInt64(val);
                }
                
            }
            catch (Exception)
            {
                if (ID == -1)
                {
                    string message = "Selected Value failed conversion to long for: " + combo.Name;
                    Console.Out.WriteLine(message);
                    if (lblStatus != null)
                    {
                        lblStatus.Text = message;
                    }
                }
                //throw;
            }
            return ID;
        }

        public static long getLongIDFromComboSelectedValue(ComboBox combo, ToolStripLabel lblStatus)
        {
            long ID = -1;

            try
            {
                object val = combo.SelectedValue;
                if ((val != null) && (val.GetType() != typeof(DataRowView)))
                {
                    ID = Convert.ToInt64(val);
                }

            }
            catch (Exception)
            {
                if (ID == -1)
                {
                    string message = "Selected Value failed conversion to long for: " + combo.Name;
                    Console.Out.WriteLine(message);
                    if (lblStatus != null)
                    {
                        lblStatus.Text = message;
                    }
                }
                //throw;
            }
            return ID;
        }
    }
}
