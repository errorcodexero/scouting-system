using System;

namespace XeroScouterDBManage_Server.DatabaseInfo
{
    class MatchTable
    {
        public static String TABLE_NAME = "match";

        public static String COL_ID = "id";
        public static String COL_EVENT_ID = "event_id";
        public static String COL_TBA_MATCH_KEY = "tba_match_key";
        public static String COL_MATCH_COMP_LEVEL  = "match_comp_level";
        public static String COL_MATCH_SET_NUMBER  = "match_set_number";
        public static String COL_MATCH_NUMBER  = "match_number";
        public static String COL_MATCH_STATUS  = "match_status";

        public static String COL_RED_1 = "red_1_team_id";
        public static String COL_RED_2 = "red_2_team_id";
        public static String COL_RED_3 = "red_3_team_id";
        public static String COL_RED_AUTO_SCORE = "red_auto_score";
        public static String COL_RED_TELEOP_SCORE = "red_teleop_score";
        public static String COL_RED_TOTAL_SCORE = "red_total_score";
        public static String COL_RED_QP = "red_qp";
        public static String COL_RED_FOUL_POINTS = "red_foul_points";

        public static String COL_BLUE_1 = "blue_1_team_id";
        public static String COL_BLUE_2 = "blue_2_team_id";
        public static String COL_BLUE_3 = "blue_3_team_id";
        public static String COL_BLUE_AUTO_SCORE = "blue_auto_score";
        public static String COL_BLUE_TELEOP_SCORE = "blue_teleop_score";
        public static String COL_BLUE_TOTAL_SCORE = "blue_total_score";
        public static String COL_BLUE_QP = "blue_qp";
        public static String COL_BLUE_FOUL_POINTS = "blue_foul_points";

        public static String COLUMN_NAME_MATCH_WINNER = "match_winner";
        public static String COLUMN_NAME_DRIVE_TEAM_COMMENTS = "drive_team_comments";

        public static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
        public static String SELECT_NUMBER_FROM_MATCHING_ID = "SELECT " + COL_MATCH_NUMBER + " FROM " + TABLE_NAME + " WHERE " + COL_ID + "=";
    }
}
