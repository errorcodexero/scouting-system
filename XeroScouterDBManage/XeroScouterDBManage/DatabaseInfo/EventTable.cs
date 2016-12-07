using System;

namespace XeroScouterDBManage_Server.DatabaseInfo
{
    class EventTable
    {
        public static String TABLE_NAME = "event";

        public static String COL_ID = "_id";
        public static String COL_TBA_EVENT_KEY = "tba_event_key";
        public static String COL_NAME = "name";
        public static String COL_SHORT_NAME = "short_name";
        public static String COL_EVENT_TYPE = "event_type";
        public static String COL_EVENT_DISTRICT = "event_district";
        public static String COL_YEAR = "year";
        public static String COL_WEEK = "week";
        public static String COL_LOCATION = "location";
        public static String COL_TBA_EVENT_CODE = "tba_event_code";

        public static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
        public static String SELECT_NAME_FROM_MATCHING_ID = "SELECT " + COL_NAME + " FROM " + TABLE_NAME + " WHERE " + COL_ID + "=";
        public static String SELECT_ALL_ID_NAME_LOC = "SELECT " + COL_ID + ", " + COL_NAME + ", " + COL_LOCATION + " FROM " + TABLE_NAME;
    }
}
