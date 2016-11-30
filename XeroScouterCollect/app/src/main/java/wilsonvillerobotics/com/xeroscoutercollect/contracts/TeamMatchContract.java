package wilsonvillerobotics.com.xeroscoutercollect.contracts;

import android.graphics.Matrix;
import android.provider.BaseColumns;

/**
 * Created by nick on 11/29/16.
 */

public class TeamMatchContract {

    private TeamMatchContract() {}

    public static class TeamMatchEntry implements BaseColumns {
        public static final String TABLE_NAME = "team_match";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_MATCH_ID = "match_id";
        public static final String COLUMN_NAME_MATCH_NUM  = "match_num";

        public static final String COLUMN_NAME_RED_1 = "red_1";
        public static final String COLUMN_NAME_RED_2 = "red_2";
        public static final String COLUMN_NAME_RED_3 = "red_3";
        public static final String COLUMN_NAME_BLUE_1 = "blue_1";
        public static final String COLUMN_NAME_BLUE_2 = "blue_2";
        public static final String COLUMN_NAME_BLUE_3 = "blue_3";

        private static final String CREATE_TABLE_TEAM_MATCH = "CREATE TABLE "
                + TABLE_NAME + "(" + COLUMN_NAME_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_NAME_MATCH_ID + " INTEGER, " + COLUMN_NAME_MATCH_NUM
                + " INTEGER, " + COLUMN_NAME_RED_1 + " INTEGER, " + COLUMN_NAME_RED_2
                + " INTEGER, " + COLUMN_NAME_RED_3 + " INTEGER, " + COLUMN_NAME_RED_3
                + " INTEGER, " + COLUMN_NAME_BLUE_1 + " INTEGER, " + COLUMN_NAME_BLUE_2
                + " INTEGER, " + COLUMN_NAME_BLUE_3 + " INTEGER)";
    }

}
