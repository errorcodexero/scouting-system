package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.provider.BaseColumns;

/**
 * Created by Luke on 11/29/2016.
 */

public class TeamContract {

    private TeamContract(){}

    public static class TeamEntry implements BaseColumns{
        public static final String TABLE_NAME = "team";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NUMBER = "number";
    }
}
