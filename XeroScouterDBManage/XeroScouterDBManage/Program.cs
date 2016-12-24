using System;
using System.Windows.Forms;


namespace XeroScouterDBManage_Server
{
    static class Program
    {
        // globals

        //public static Boolean TEST_MODE = true;
        //public static String dbName = (TEST_MODE) ? Properties.Settings.Default.TestDatabaseName : Properties.Settings.Default.DatabaseName;

        //private static String[] sA = new String[5]{
        //        Properties.Settings.Default.dbHost,
        //        Properties.Settings.Default.dbUser,
        //        Properties.Settings.Default.dbPassword,
        //        Properties.Settings.Default.dbPersistSecurity,
        //        dbName
        //    };

        //public static String connectionString = String.Format(Properties.Settings.Default.DBConnectionTemplate, sA); 
        //"server=localhost;" +
        //"port=3306;" +
        //"uid=ftsscout;" +
        //"pwd=ftsscouter;" +
        //"database=scouting_test;";

        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            try
            {
                if (Properties.Settings.Default.CompetitionID < 0)
                {
                    CompetitionSelectForm csForm = new CompetitionSelectForm();
                    csForm.ShowDialog();

                }

                MatchListForm frm = new MatchListForm();
                Application.Run(frm);
            }
            catch (Exception e)
            {
                Console.Out.WriteLine("Could not create form due to database issues");
				Console.Out.WriteLine(e.StackTrace);
            }
            
        }

        
    }
}
