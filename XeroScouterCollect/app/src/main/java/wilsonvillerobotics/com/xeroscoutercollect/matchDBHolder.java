package wilsonvillerobotics.com.xeroscoutercollect;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    private static ArrayList<String> ACTIONS;

    private Context context;

    private int id;

    public matchDBHolder(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
        this.context = context;


    }
    /*public String makeSQLColumnNameFromText(String text) {

    }*/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Resources res = context.getResources();
        ACTIONS = new ArrayList<>(Arrays.asList(res.getStringArray(R.array.action_array)));

        String CREATE_MATCH_TABLE = "CREATE TABLE " + TABLE_MATCH + " (" +
                KEY_ID  + " INTEGER PRIMARY KEY, " + TEAM_ID + " TEXT";
        int i = 1;

        for ( String j : ACTIONS) {
            CREATE_MATCH_TABLE += ", action_" + i + " TEXT";
            i++;
        }
        CREATE_MATCH_TABLE += ")";

        Log.d("DEBUG", CREATE_MATCH_TABLE);
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
            Log.d("DEBUG", i);
            values.put(i, matchData.getActionPoints().get(ACTIONS.get(Integer.parseInt(i))));
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
            resultsHashMap.put(ACTIONS.get(i), cursor.getString(i+1));
        }
        dummyMatch = new Match(resultsHashMap, cursor.getString(1));
        return dummyMatch;
    }

    public ArrayList<Match> getAllMatches() {
        ArrayList<Match> matchList = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_MATCH;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        HashMap<String, String> resultsHashMap = new HashMap<>();

        if (cursor.moveToFirst()) {
            do {
                resultsHashMap.clear();
                for ( int i = 1; i <= cursor.getColumnCount(); i++) {
                    resultsHashMap.put(ACTIONS.get(i), cursor.getString(i+1));
                }

                matchList.add(new Match(resultsHashMap, cursor.getString(1)));

            } while (cursor.moveToNext());
        }
        return matchList;
    }
    public int getMatchCount() {

        String query = "SELECT * FROM " + TABLE_MATCH;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.close();

        return cursor.getCount();

    }

    public void updateMatch(Match match, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        for (String i : ACTIONS) {
            values.put(i, match.getActionPoints().get(i));
        }

        db.update(TABLE_MATCH, values, KEY_ID + " =?", new String[] {String.valueOf(id)});

    }

    public void deleteMatch(int id) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MATCH, KEY_ID + " =?", new String[] { String.valueOf(id)});
        db.close();

    }
}
