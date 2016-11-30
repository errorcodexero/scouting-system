package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.provider.BaseColumns;

/**
 * Created by Luke on 11/29/2016.
 */

public class TransactionContract {

    private TransactionContract(){}

    public static class TransactionEntry implements BaseColumns {
        public static final String TABLE_NAME = "transaction";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_TEAM_ID = "team_id";
        public static final String COLUMN_NAME_MATCH_ID = "match_id";
        public static final String COLUMN_NAME_MATCH_NUM = "match_num";
        public static final String COLUMN_NAME_ACTION_ID = "action_id";
        public static final String COLUMN_NAME_ACTION_QUANTITY= "action_quantity";

    }
}
