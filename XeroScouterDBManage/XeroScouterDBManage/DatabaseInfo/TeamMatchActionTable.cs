using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace XeroScouterDBManage_Server.DatabaseInfo
{
	class TeamMatchActionTable
	{
		public static String TABLE_NAME = "team_match_action";

		public static String COL_ID = "_id";
		public static String COL_TEAM_MATCH_ID = "team_match_id";
		public static String COL_ACTION_TYPE_ID = "action_type_id";
		public static String COL_QUANTITY = "quantity";
		public static String COL_START_TIME = "start_time";
		public static String COL_END_TIME = "end_time";
		public static String COL_OBJECT_COUNT = "object_count";

		public static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
		public static String SELECT_ALL_FOR_TEAM_MATCH_ID = "SELECT * FROM " + TABLE_NAME + " WHERE " + COL_TEAM_MATCH_ID + "=";

		public static String getInsertRecordQuery(Int32 tmID, Dictionary<int, Int32> dictIdToCount)
		{
			String values = "";
			int count = dictIdToCount.Keys.Count;
			foreach(int id in dictIdToCount.Keys)
			{
				int actionCount;
				bool success = dictIdToCount.TryGetValue(id, out actionCount);
				if (success)
				{
					values += "(";
					values += String.Format("{0}, ", tmID);
					values += String.Format("{0}, ", id);
					values += String.Format("{0}, ", actionCount);
					values += "\"\", \"\"";
					values += "0";
					values += ")";
					if(--count > 0)
					{
						values += ", ";
					}
				}
			}

			String query = "INSERT INTO " + Utils.getDBName() + "." + TABLE_NAME + " (";
			query += COL_TEAM_MATCH_ID + ", ";
			query += COL_ACTION_TYPE_ID + ", ";
			query += COL_QUANTITY + ", ";
			query += COL_START_TIME + ", ";
			query += COL_END_TIME + ", ";
			query += COL_OBJECT_COUNT;
			query += ") VALUES";
			query += values;

			return query;
		}

		public static String getInsertRecordQuery()
		{
			String query = "INSERT INTO " + Utils.getDBName() + "." + TABLE_NAME + " (";
			query += COL_TEAM_MATCH_ID + ", ";
			query += COL_ACTION_TYPE_ID + ", ";
			query += COL_QUANTITY + ", ";
			query += COL_START_TIME + ", ";
			query += COL_END_TIME + ", ";
			query += COL_OBJECT_COUNT;

			query += ") VALUES(";

			query += "@" + COL_TEAM_MATCH_ID + ", ";
			query += "@" + COL_ACTION_TYPE_ID + ", ";
			query += "@" + COL_QUANTITY + ", ";
			query += "@" + COL_START_TIME + ", ";
			query += "@" + COL_END_TIME + ", ";
			query += "@" + COL_OBJECT_COUNT;
			query += ")";

			return query;
		}
	}
}
