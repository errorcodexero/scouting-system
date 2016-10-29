using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace XeroScouterDBManage_Server.Utilities
{
    public class MySQL_ErrorCodes
    {
        public Dictionary<Int32, String> errorCodes = new Dictionary<Int32, String>();

        public MySQL_ErrorCodes()
        {
            errorCodes.Add(1054, "Bad Field Error");
            errorCodes.Add(1366, "Incorrect String Value");  //Incorrect string value: '\xF0\x9F\x98\x8A' for column 'team_match_notes' at row 1
        }
    }
}
