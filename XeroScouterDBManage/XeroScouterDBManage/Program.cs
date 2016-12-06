using System;
using System.Windows.Forms;


namespace XeroScouterDBManage_Server
{
    static class Program
    {
        // globals

        public static Boolean TEST_MODE = false;

        public static String conString = Properties.Settings.Default.FTS_ConnectionString;
            //"server=localhost;" +
            //"port=3306;" +
            //"uid=ftsscout;" +
            //"pwd=ftsscouter;" +
            //"database=scouting;";

        public static String conTestString = Properties.Settings.Default.FTS_TEST_ConnectionString;
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
                if (Properties.Settings.Default.SeasonID < 0)
                {
                    SeasonSelectForm ssForm = new SeasonSelectForm();
                    ssForm.ShowDialog();

                }

                MatchListForm frm = new MatchListForm();
                Application.Run(frm);
            }
            catch (Exception)
            {
                Console.Out.WriteLine("Could not create form due to database issues");
            }
            
        }

        
    }
}
