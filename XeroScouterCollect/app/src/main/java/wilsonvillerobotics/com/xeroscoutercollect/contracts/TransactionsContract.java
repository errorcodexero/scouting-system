package wilsonvillerobotics.com.xeroscoutercollect.contracts;

import android.provider.BaseColumns;

/**
 * Created by Luke on 11/29/2016.
 */

public class TransactionsContract {

    private TransactionsContract(){}

    public static class TransactionsEntry implements BaseColumns {
        public static final String TABLE_NAME = "transactions";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_TEAM_ID = "team_id";
        public static final String COLUMN_NAME_MATCH_ID = "match_id";
        public static final String COLUMN_NAME_MATCH_NUM = "match_num";
        public static final String COLUMN_NAME_ACTION_ID = "action_id";
        public static final String COLUMN_NAME_ACTION_QUANTITY= "action_quantity";

        private static final String CREATE_TABLE_TRANSACTIONS = "CREATE TABLE "
                + TABLE_NAME + " (" + COLUMN_NAME_ID + " INTEGER PRIMARY KEY, "
                + COLUMN_NAME_TEAM_ID + " INTEGER, " +  COLUMN_NAME_MATCH_ID + " INTEGER, "
                + COLUMN_NAME_MATCH_NUM + " INTEGER, " + COLUMN_NAME_ACTION_ID + " INTEGER, "
                + COLUMN_NAME_ACTION_QUANTITY + " INTEGER)";

    }
}
