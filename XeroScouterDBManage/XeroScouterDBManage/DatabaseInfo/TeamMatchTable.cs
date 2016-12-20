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
		public static String COL_SCOUT_NAME = "scout_name";

		// TODO - need to add to scouting database
		// TODO - REMOVE event ID, not needed since baked in to Match ID
		public static String COL_EVENT_ID = "event_id";

        public static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
        public static String INSERT_RECORD = "INSERT INTO " + TeamMatchTable.TABLE_NAME + " (" +
            COL_TEAM_ID + ", " + COL_MATCH_ID + ", " + //COL_EVENT_ID + ", " +
            COL_POSITION + ", " + COL_ALLIANCE +
            ") VALUES(@" +
            COL_TEAM_ID + ", @" + COL_MATCH_ID + ", @" + //COL_EVENT_ID + ", @" +
            COL_POSITION + ", @" + COL_ALLIANCE +
			")";

        public static String getIdQuery(Int32 teamID, Int32 matchID)
        {
            return "SELECT " + COL_ID + " FROM " + TABLE_NAME + " WHERE " + COL_TEAM_ID + "=" +
                String.Format("{0}", teamID) + " AND " + COL_MATCH_ID + "=" + String.Format("{0}", matchID);
        }

		public static String getRecordQuery(Int32 teamMatchID)
		{
			return "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + "=" + String.Format("{0}",teamMatchID);
		}

		public static String getScouterNameQuery(Int32 teamMatchID)
		{
			String q = "";
			q = "SELECT " + COL_SCOUT_NAME + " FROM " + TABLE_NAME + " WHERE " + COL_ID + "=" + String.Format("{0}", teamMatchID);
			return q;
		}

		public static String getUpdateScouterQuery(Int32 teamMatchID, String scouterName)
		{
			String q = "UPDATE " + TABLE_NAME + " SET " + 
				COL_SCOUT_NAME + "='" + scouterName + "'" +
				" WHERE " + COL_ID + "=" + String.Format("{0}", teamMatchID);

			return q;
		}
	}
}
