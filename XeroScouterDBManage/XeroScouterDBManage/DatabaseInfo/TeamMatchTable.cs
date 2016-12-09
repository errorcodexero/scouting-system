using System;

namespace XeroScouterDBManage_Server.DatabaseInfo
{
    class TeamMatchTable
    {
        public static String TABLE_NAME = "team_match";
        public static String COL_ID = "_id";
        public static String COL_TEAM_ID = "team_id";
        public static String COL_MATCH_ID = "match_id";
        public static String COL_ALLIANCE = "alliance";
        public static String COL_POSITION = "position";

        public static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;

        public static String getIdQuery(int teamID, int matchID)
        {
            return "SELECT " + COL_ID + " FROM " + TABLE_NAME + " WHERE " + COL_TEAM_ID + "=" +
                String.Format("%d", teamID) + " AND " + COL_MATCH_ID + "=" + String.Format("%d", matchID);
        }
    }
}
