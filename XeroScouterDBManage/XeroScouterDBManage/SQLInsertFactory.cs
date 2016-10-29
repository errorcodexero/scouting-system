using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace XeroScouterDBManage_Server
{
    class SQLInsertFactory
    {
        public const string MatchDataInsert = "INSERT INTO match_data(_id, tablet_id, competition_id, match_time, match_type, match_number, match_location" +
            "red_team_one_id, red_team_two_id, red_team_three_id, blue_team_one_id, blue_team_two_id, blue_team_three_id, ready_to_export) " +
            "VALUES(@ID, @TABLET_ID, @COMPETITION_ID, @MATCH_TIME, @MATCH_TYPE, @MATCH_NUMBER, @MATCH_LOCATION, " +
            "@RED_TEAM_ONE_ID, @RED_TEAM_TWO_ID, @RED_TEAM_THREE_ID, @BLUE_TEAM_ONE_ID, @BLUE_TEAM_TWO_ID, @BLUE_TEAM_THREE_ID, @READY_TO_EXPORT)";

        public static String[] MatchDataParameters = {
            "@ID", "@TABLET_ID", "@COMPETITION_ID", "@MATCH_TIME", "@MATCH_TYPE", "@MATCH_NUMBER", "@MATCH_LOCATION",
            "@RED_TEAM_ONE_ID", "@RED_TEAM_TWO_ID", "@RED_TEAM_THREE_ID", "@BLUE_TEAM_ONE_ID", "@BLUE_TEAM_TWO_ID", "@BLUE_TEAM_THREE_ID", "@READY_TO_EXPORT"
        };
    }
}
