using System;
using System.Collections;

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
        public static String COL_EVENT_ACTION_DEFINITION_FILE = "event_action_definition_file";

        private static Type VARCHAR = typeof(String);
        private static Type INT = typeof(Int32);
        private static Type FLOAT = typeof(float);
        private static Type DATETIME = typeof(DateTime);

        public static Type COL_ID_TYPE = INT;
        public static Type COL_TBA_EVENT_KEY_TYPE = VARCHAR;
        public static Type COL_NAME_TYPE = VARCHAR;
        public static Type COL_SHORT_NAME_TYPE = VARCHAR;
        public static Type COL_EVENT_TYPE_TYPE = VARCHAR;
        public static Type COL_EVENT_DISTRICT_TYPE = VARCHAR;
        public static Type COL_YEAR_TYPE = INT;
        public static Type COL_WEEK_TYPE = INT;
        public static Type COL_LOCATION_TYPE = VARCHAR;
        public static Type COL_TBA_EVENT_CODE_TYPE = VARCHAR;
        public static Type COL_EVENT_ACTION_DEFINITION_FILE_TYPE = VARCHAR;

        public static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
        public static String SELECT_NAME_FROM_MATCHING_ID = "SELECT " + COL_NAME + " FROM " + TABLE_NAME + " WHERE " + COL_ID + "=";
        public static String SELECT_ID_NAME_LOC = "SELECT " + COL_ID + ", " + COL_NAME + ", " + COL_LOCATION + ", " + COL_EVENT_ACTION_DEFINITION_FILE + " FROM " + TABLE_NAME + " ORDER BY " + COL_NAME;

        public static String getUpdateDefinitionFileQuery(Int32 eventID, String definitionFile)
        {
            String q = "UPDATE " + TABLE_NAME + " SET " +
                COL_EVENT_ACTION_DEFINITION_FILE + "='" + definitionFile + "'" +
                " WHERE " + COL_ID + "=" + String.Format("{0}", eventID);

            return q;
        }

        public static String getDistrictsByYear(Int32 year)
        {
            String q = "SELECT DISTINCT " + COL_EVENT_DISTRICT + " FROM " + TABLE_NAME;
            q += " WHERE " + COL_YEAR + "=" + String.Format("{0}", year);
            q += " AND " + COL_EVENT_DISTRICT + " is not NULL";
            q += " ORDER BY " + COL_EVENT_DISTRICT;

            //SELECT DISTINCT event_district FROM event WHERE year=2018 AND event_district is not NULL ORDER BY event_district
            return q;
        }

        public static String getCompetitionByYear(Int32 year) //, String district)
        {
            String q = "SELECT " + COL_ID + ", " + COL_NAME + ", " + COL_LOCATION + ", " + COL_EVENT_ACTION_DEFINITION_FILE + " FROM " + TABLE_NAME;
            q += " WHERE " + COL_YEAR + "=" + String.Format("{0}", year);
            //q += " AND " + COL_SHORT_NAME + "='Wilsonville'"; // + district + "'";
            q += " ORDER BY " + COL_NAME;
            

            return q;
        }
    }
}
