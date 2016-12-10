using System;

namespace XeroScouterDBManage_Server.DatabaseInfo
{
    class MatchTable
    {
        public static String TABLE_NAME = "match";

        public static String COL_ID = "_id";
        public static String COL_EVENT_ID = "event_id";
        public static String COL_TBA_MATCH_KEY = "tba_match_key";
        public static String COL_MATCH_COMP_LEVEL  = "comp_level";
        public static String COL_MATCH_SET_NUMBER  = "set_number";
        public static String COL_MATCH_NUMBER  = "match_number";
        public static String COL_MATCH_STATUS  = "status";

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

        public static String COLUMN_NAME_MATCH_WINNER = "winner";
        public static String COLUMN_NAME_DRIVE_TEAM_COMMENTS = "drive_team_comments";

        public static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
        public static String SELECT_NUMBER_FROM_MATCHING_ID = "SELECT " + COL_MATCH_NUMBER + " FROM " + TABLE_NAME + " WHERE " + COL_ID + "=";
        public static String SELECT_MATCH_AND_TEAMS_FROM_ID_PREFIX = "SELECT " + COL_ID + ", " + COL_MATCH_NUMBER + " AS 'Match Number',";
        public static String SELECT_BLUE1_FOR_ID_PART = " (SELECT " + TeamTable.COL_TEAM_NUMBER + " FROM " + TeamTable.TABLE_NAME + " WHERE " + TeamTable.TABLE_NAME + "." + TeamTable.COL_ID + "=" + COL_BLUE_1 + ") AS 'Blue One',";
        public static String SELECT_BLUE2_FOR_ID_PART = " (SELECT " + TeamTable.COL_TEAM_NUMBER + " FROM " + TeamTable.TABLE_NAME + " WHERE " + TeamTable.TABLE_NAME + "." + TeamTable.COL_ID + "=" + COL_BLUE_2 + ") AS 'Blue Two',";
        public static String SELECT_BLUE3_FOR_ID_PART = " (SELECT " + TeamTable.COL_TEAM_NUMBER + " FROM " + TeamTable.TABLE_NAME + " WHERE " + TeamTable.TABLE_NAME + "." + TeamTable.COL_ID + "=" + COL_BLUE_3 + ") AS 'Blue Three',";
        public static String SELECT_RED1_FOR_ID_PART = " (SELECT " + TeamTable.COL_TEAM_NUMBER + " FROM " + TeamTable.TABLE_NAME + " WHERE " + TeamTable.TABLE_NAME + "." + TeamTable.COL_ID + "=" + COL_RED_1 + ") AS 'Red One',";
        public static String SELECT_RED2_FOR_ID_PART = " (SELECT " + TeamTable.COL_TEAM_NUMBER + " FROM " + TeamTable.TABLE_NAME + " WHERE " + TeamTable.TABLE_NAME + "." + TeamTable.COL_ID + "=" + COL_RED_2 + ") AS 'Red Two',";
        public static String SELECT_RED3_FOR_ID_PART = " (SELECT " + TeamTable.COL_TEAM_NUMBER + " FROM " + TeamTable.TABLE_NAME + " WHERE " + TeamTable.TABLE_NAME + "." + TeamTable.COL_ID + "=" + COL_RED_3 + ") AS 'Red Three'";
        public static String FROM_MATCH_FOR_EVENT_ID = " FROM " + Program.dbName + "." + MatchTable.TABLE_NAME + " WHERE " + MatchTable.COL_EVENT_ID + "=";

        public static String INSERT_RECORD = "INSERT INTO " + Program.dbName + "." + MatchTable.TABLE_NAME + "(" +
            COL_EVENT_ID + ", " +
            COL_MATCH_NUMBER + ", " +
            COL_MATCH_COMP_LEVEL + ", " + 
            //"match_time, " + "match_location, " +
            COL_BLUE_1 + ", " + COL_BLUE_2 + ", " + COL_BLUE_3 + ", " +
            COL_RED_1 + ", " + COL_RED_2 + ", " + COL_RED_3 + ", " +
            COL_BLUE_AUTO_SCORE + ", " + COL_BLUE_TELEOP_SCORE + ", " + COL_BLUE_TOTAL_SCORE + ", " +
            COL_BLUE_QP + ", " + COL_BLUE_FOUL_POINTS + ", " + 
            COL_RED_AUTO_SCORE + ", " + COL_RED_TELEOP_SCORE + ", " + COL_RED_TOTAL_SCORE + ", " +
            COL_RED_QP + ", " + COL_RED_FOUL_POINTS + ", " +
            COLUMN_NAME_MATCH_WINNER + ", " + COLUMN_NAME_DRIVE_TEAM_COMMENTS + ") " +
            "VALUES(@" + COL_EVENT_ID + ", @" + COL_MATCH_NUMBER + ", @" + 
            COL_MATCH_COMP_LEVEL + ", @" + 
            //matchTime + ", @" + matchLocation + ", @" +
            COL_BLUE_1 + ", @" + COL_BLUE_2 + ", @" + COL_BLUE_3 + ", @" +
            COL_RED_1 + ", @" + COL_RED_2 + ", @" + COL_RED_3 + ", @" +
            COL_BLUE_AUTO_SCORE + ", @" + COL_BLUE_TELEOP_SCORE + ", @" + COL_BLUE_TOTAL_SCORE + ", @" +
            COL_BLUE_QP + ", @" + COL_BLUE_FOUL_POINTS + ", @" +
            COL_RED_AUTO_SCORE + ", @" + COL_RED_TELEOP_SCORE + ", @" + COL_RED_TOTAL_SCORE + ", @" +
            COL_RED_QP + ", @" + COL_RED_FOUL_POINTS + ", @" +
            COLUMN_NAME_MATCH_WINNER + ", @" + COLUMN_NAME_DRIVE_TEAM_COMMENTS + ")";
    }
}
