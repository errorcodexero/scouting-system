package wilsonvillerobotics.com.xeroscoutercollect;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nick on 11/5/16.
 */
public final class matchDBHolder extends SQLiteOpenHelper {

    //private matchDBHolder() {}

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "match_db";

    private static final String TABLE_MATCH = "match";

    private static final String KEY_ID = "local_match_id";
    private static final String TEAM_ID = "team_id";

    private static String[] ACTIONS;

    private Context context;

    public matchDBHolder(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        this.context = context;


    }
    /*public String makeSQLColumnNameFromText(String text) {

    }*/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Resources res = context.getResources();
        ACTIONS = res.getStringArray(R.array.action_array);



        String CREATE_MATCH_TABLE = "CREATE TABLE " + TABLE_MATCH +
                KEY_ID  + "INTEGER PRIMARY KEY, " + TEAM_ID + " TEXT,";
        for ( String j : ACTIONS) {
            int i = 1;
            CREATE_MATCH_TABLE += ", action_" + i + " TEXT";

        }
        CREATE_MATCH_TABLE += ")";

        sqLiteDatabase.execSQL(CREATE_MATCH_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MATCH);

        onCreate(sqLiteDatabase);
    }

    public void addMatch(Match matchData) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        for (String i : ACTIONS) {
            values.put(i, matchData.getActionPoints().get(i));
        }

        db.insert(TABLE_MATCH, null, values);

    }

    public Match getMatch(int id ) {
        SQLiteDatabase db = this.getReadableDatabase();

        Match dummyMatch;

        ArrayList<String> dummyList = new ArrayList();
        dummyList.add(0, KEY_ID);
        dummyList.add(1, TEAM_ID);

        HashMap<String, String> resultsHashMap = new HashMap<>();

        Cursor cursor = db.query(TABLE_MATCH, (String[]) dummyList.toArray(), KEY_ID + "=?", new String[] { String.valueOf(id)},
                null, null, null ,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        //Match match = new Match();
        for ( int i = 1; i <= cursor.getColumnCount(); i++) {
            resultsHashMap.put(ACTIONS[i], cursor.getString(i+1));
        }
        dummyMatch = new Match(resultsHashMap, cursor.getString(1));
        return dummyMatch;
    }

    //public ArrayList<Match> getAllMatches
    /*public int getMatchCount() {

    }

    public void updateMatch() {

    }

    public void deleteMatch() {

    }

    public Pair<String, String> getAllMatches() {

    }*/
}
