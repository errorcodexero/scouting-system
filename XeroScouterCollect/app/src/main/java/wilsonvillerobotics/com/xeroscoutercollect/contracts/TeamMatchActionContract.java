package wilsonvillerobotics.com.xeroscoutercollect.contracts;

import android.provider.BaseColumns;

import wilsonvillerobotics.com.xeroscoutercollect.interfaces.SQLDataTypeDefines;

/**
 * Created by Luke on 11/29/2016.
 */

public class TeamMatchActionContract implements SQLDataTypeDefines {

    private TeamMatchActionContract(){}

    public static class TeamMatchActionEntry implements BaseColumns {
        public static final String TABLE_NAME = "team_match_action";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_TABLET_ID = "tablet_id";
        public static final String COLUMN_NAME_TEAM_MATCH_ID = "team_match_id";
        public static final String COLUMN_NAME_ACTION_TYPE_ID = "action_type_id";
        public static final String COLUMN_NAME_ACTION_QUANTITY = "quantity";
        public static final String COLUMN_NAME_START_TIME = "action_start_time";
        public static final String COLUMN_NAME_END_TIME = "action_end_time";
        public static final String COLUMN_NAME_OBJECT_COUNT = "action_object_count";

        public static final String CREATE_TABLE_TEAM_MATCH_ACTION =
                "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_NAME_ID + INTPK + COMMA_SEP
                        + COLUMN_NAME_TABLET_ID + INT11 + COMMA_SEP
                        + COLUMN_NAME_TEAM_MATCH_ID + INT11 + COMMA_SEP
                        + COLUMN_NAME_ACTION_TYPE_ID + INT11 + COMMA_SEP
                        + COLUMN_NAME_ACTION_QUANTITY + INT11 + COMMA_SEP
                        + COLUMN_NAME_START_TIME + DT + COMMA_SEP
                        + COLUMN_NAME_END_TIME + DT + COMMA_SEP
                        + COLUMN_NAME_OBJECT_COUNT   + INT11
                        + ")";
    }
}
