using System;

namespace XeroScouterDBManage_Server.DatabaseInfo
{
    class ActionTypeTable
    {
        public static String TABLE_NAME = "action_type";

        public static String COL_ID = "_id";
        public static String COL_NAME = "name";
        public static String COL_SHORT_DESCRIPTION = "description";
        public static String COL_MATCH_PHASE = "match_phase";
        public static String COL_POINTS = "points";
        public static String COL_OPPONENT_POINTS = "opponent_points";
        public static String COL_QUALIFICATION_POINTS = "qual_points";
        public static String COL_FOUL_POINTS = "foul_points";
        public static String COL_COOP_FLAG = "coop_flag";
        public static String COL_CATEGORY = "category";

        public static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
        public static String SELECT_NAME_FROM_MATCHING_ID = "SELECT " + COL_NAME + " FROM " + TABLE_NAME + " WHERE " + COL_ID + "=";
    }
}
