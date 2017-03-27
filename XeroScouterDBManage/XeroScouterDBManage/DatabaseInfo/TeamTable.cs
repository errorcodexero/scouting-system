using System;
using System.Collections.Generic;

namespace XeroScouterDBManage_Server.DatabaseInfo
{
    class TeamTable
    {
        public static String TABLE_NAME = "team";

        public static String COL_ID = "_id";
        public static String COL_TEAM_NUMBER = "team_number";
        public static String COL_TBA_TEAM_KEY = "tba_team_key";
        public static String COL_TEAM_LONG_NAME = "long_name";
        public static String COL_TEAM_NAME = "name";
        public static String COL_LOGO_FILE_LOCATION = "logo_file_location";
        public static String COL_TEAM_CITY = "city";
        public static String COL_TEAM_STATE_CODE = "state_code";
        public static String COL_TEAM_COUNTRY = "country";
        public static String COL_TEAM_MOTTO = "motto";
        public static String COL_TEAM_ROOKIE_YEAR = "rookie_year";
        public static String COL_ROBOT_NAME = "robot_name";
        public static String COL_ROBOT_PICTURE_FILE_LOCATION = "robot_picture_file_location";
        public static String COL_ROBOT_DRIVE_TYPE = "robot_drive_type";
        public static String COL_ROBOT_WHEEL_COUNT = "robot_wheel_count";
        public static String COL_ROBOT_DRIVE_MOTOR_COUNT = "robot_drive_motor_count";
        public static String COL_ROBOT_SOFTWARE_LANGUAGE = "robot_software_language";
        public static String COL_ROBOT_DESCRIPTION = "robot_description";
        public static String COL_PIT_SCOUT_COMMENTS = "pit_scout_comments";

        public static String SELECT_ALL = "SELECT * FROM " + TABLE_NAME;
        public static String SELECT_NAME_FROM_MATCHING_ID = "SELECT " + COL_TEAM_LONG_NAME + " FROM " + TABLE_NAME + " WHERE " + COL_ID + "=";
        public static String SELECT_NUMBER_FROM_MATCHING_ID = "SELECT " + COL_TEAM_NUMBER + " FROM " + TABLE_NAME + " WHERE " + COL_ID + "=";
        public static String SELECT_ID_AND_NUMBER = "SELECT " + COL_ID + ", " + COL_TEAM_NUMBER + " FROM " + TABLE_NAME;
        public static String ORDER_TEAM_NUMBERS_NUMERICALLY = " ORDER BY " + COL_TEAM_NUMBER + " * 1";

        public static String SelectIdAndNumberWithFilter(List<long> idFilterList)
        {
            string retVal = "";

            retVal = SELECT_ID_AND_NUMBER;

            if (idFilterList != null)
            {
                List<long> IdList = new List<long>();
                foreach (long id in idFilterList)
                {
                    if (id != -1)
                    {
                        IdList.Add(id);
                    }
                }

                if (IdList.Count > 0)
                {
                    retVal += " WHERE _id<>" + IdList[0];
                }

                for (int i = 1; i < IdList.Count; i++)
                {
                    retVal += " AND _id<>" + IdList[i];
                }
            }

            retVal += ORDER_TEAM_NUMBERS_NUMERICALLY;

            return retVal;
        }
    }
}
