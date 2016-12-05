using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace XeroScouterDBManage_Server.DatabaseInfo
{
    class EventTable
    {
        public static String TABLE_NAME = "event";

        public static String COL_ID = "event_id";
        public static String COL_NAME = "name";
        public static String COL_LOCATION = "location";

        public static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
        public static String SELECT_NAME_FROM_MATCHING_ID = "SELECT " + COL_NAME + " FROM " + TABLE_NAME + " WHERE " + COL_ID + "=";
        public static String SELECT_ALL_ID_NAME_LOC = "SELECT " + COL_ID + ", " + COL_NAME + ", " + COL_LOCATION + " FROM " + TABLE_NAME;
    }
}
