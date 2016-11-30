package wilsonvillerobotics.com.xeroscoutercollect.contracts;

import android.provider.BaseColumns;

/**
 * Created by Luke on 11/29/2016.
 */

public class TeamContract {

    private TeamContract(){}

    public static class TeamEntry implements BaseColumns{
        public static final String TABLE_NAME = "team";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_TEAM_NUMBER = "team_number";

        private static final String CREATE_TABLE_TEAM = "CREATE TABLE "
                + TABLE_NAME + " (" + COLUMN_NAME_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_NAME_TEAM_NUMBER + " VARCHAR(20))";

    }
}
