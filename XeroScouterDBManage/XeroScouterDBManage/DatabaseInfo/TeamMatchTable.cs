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

        // TODO - need to add to scouting database
        public static String COL_EVENT_ID = "event_id";

        public static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
        public static String INSERT_RECORD = "INSERT INTO " + TeamMatchTable.TABLE_NAME + " (" +
            COL_TEAM_ID + ", " + COL_MATCH_ID + ", " + COL_EVENT_ID + ", " +
            COL_POSITION + ", " + COL_ALLIANCE +
            ") VALUES(@" +
            COL_TEAM_ID + ", @" + COL_MATCH_ID + ", @" + COL_EVENT_ID + ", @" +
            COL_POSITION + ", @" + COL_ALLIANCE + ")";

        public static String getIdQuery(int teamID, int matchID)
        {
            return "SELECT " + COL_ID + " FROM " + TABLE_NAME + " WHERE " + COL_TEAM_ID + "=" +
                String.Format("%d", teamID) + " AND " + COL_MATCH_ID + "=" + String.Format("%d", matchID);
        }
    }
}
