using System;
using MySql.Data.MySqlClient;
using System.Windows.Forms;
using System.Data;
using System.Linq;

namespace XeroScouterDBManage_Server
{
	class Utils
    {
		public static String getDBName()
		{
			return (Properties.Settings.Default.TEST_MODE) ? Properties.Settings.Default.TestDatabaseName : Properties.Settings.Default.DatabaseName;
		}

		public static String getConnectionString()
        {
			String dbName = Utils.getDBName();

			String[] sA = new String[5]{
				Properties.Settings.Default.dbHost,
				Properties.Settings.Default.dbUser,
				Properties.Settings.Default.dbPassword,
				Properties.Settings.Default.dbPersistSecurity,
				dbName
			};

			String connectionString = String.Format(Properties.Settings.Default.DBConnectionTemplate, sA);

            return connectionString;
        }

		public static bool openConnection(MySqlConnection connection)
		{
			bool connectionAvailable = true;

			try
			{
				connection.Open();
			}
			catch (MySqlException)
			{
				string message = "Unable to open MySQL connection - check if the database is installed and running!";
				Console.Out.WriteLine(message);
				connectionAvailable = false;
			}
			catch (Exception)
			{
				string message = "Unknown issue at open - check if the database is installed and running!";
				Console.Out.WriteLine(message);
				connectionAvailable = false;
			}

			return connectionAvailable;
		}

		public static bool openConnection(MySqlConnection connection, Label lblStatus)
        {
            bool connectionAvailable = true;

            try
            {
                connection.Open();
            }
            catch (MySqlException)
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
            catch (MySqlException)
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

		public static bool ValidAlphaNumericString(string strIntEntry, out string errorMessage)
		{
			// Confirm that the e-mail address string is not empty.
			if (strIntEntry.Length == 0)
			{
				//errorMessage = "entry is required.";
				//return false;
				errorMessage = "";
				return true;
			}

			if (!strIntEntry.All(char.IsLetterOrDigit))
			{
				errorMessage = "string must contain only letters";
				return false;
			}
			else
			{
				errorMessage = "";
			}
			return true;
		}

		public static bool ValidAlphaString(String strIntEntry, out string errorMessage)
		{
			// Confirm that the e-mail address string is not empty.
			if (strIntEntry.Length == 0)
			{
				//errorMessage = "entry is required.";
				//return false;
				errorMessage = "";
				return true;
			}

			if (!strIntEntry.All(char.IsLetter))
			{
				errorMessage = "string must contain only letters";
				return false;
			}
			else
			{
				errorMessage = "";
			}
			return true;
		}

		public static bool ValidInteger(string strIntEntry, out string errorMessage)
		{
			// Confirm that the e-mail address string is not empty.
			if (strIntEntry.Length == 0)
			{
				//errorMessage = "entry is required.";
				//return false;
				errorMessage = "";
				return true;
			}

			int i;
			bool isNumber = int.TryParse(strIntEntry, out i);
			if (!isNumber)
			{
				errorMessage = "must be a valid integer";
				return false;
			}
			else
			{
				errorMessage = "";
			}
			return true;
		}

		public static bool ValidEmailAddress(string emailAddress, out string errorMessage)
		{
			// Confirm that the e-mail address string is not empty.
			if (emailAddress.Length == 0)
			{
				//errorMessage = "e-mail address is required.";
				//return false;
				errorMessage = "";
				return true;
			}

			// Confirm that there is an "@" and a "." in the e-mail address, and in the correct order.
			if (emailAddress.IndexOf("@") > -1)
			{
				if (emailAddress.IndexOf(".", emailAddress.IndexOf("@")) > emailAddress.IndexOf("@"))
				{
					errorMessage = "";
					return true;
				}
			}

			errorMessage = "e-mail address must be valid e-mail address format.\n" +
			   "For example 'someone@example.com' ";
			return false;
		}
	}
}
