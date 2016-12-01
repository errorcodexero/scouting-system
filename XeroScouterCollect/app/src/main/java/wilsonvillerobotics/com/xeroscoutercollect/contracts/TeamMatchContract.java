package wilsonvillerobotics.com.xeroscoutercollect.contracts;

import android.provider.BaseColumns;

import wilsonvillerobotics.com.xeroscoutercollect.interfaces.SQLDataTypeDefines;

/**
 * Created by tomso on 11/30/2016.
 */

public class TeamMatchContract implements SQLDataTypeDefines {

    private TeamMatchContract(){}

    public static class TeamMatchEntry implements BaseColumns {
        public static final String TABLE_NAME = "team_match";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_TEAM_ID = "team_id";
        public static final String COLUMN_NAME_MATCH_ID = "match_id";
        public static final String COLUMN_NAME_ALLIANCE = "alliance";
        public static final String COLUMN_NAME_POSITION = "position";

        public static final String CREATE_TABLE_TEAM_MATCH =
                "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_NAME_ID + INTPK + COMMA_SEP
                        + COLUMN_NAME_TEAM_ID + INT11 + COMMA_SEP
                        + COLUMN_NAME_MATCH_ID + INT11 + COMMA_SEP
                        + COLUMN_NAME_ALLIANCE + VC45 + COMMA_SEP
                        + COLUMN_NAME_POSITION   + INT11
                        + ")";
    }
}
