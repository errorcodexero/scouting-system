package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import wilsonvillerobotics.com.xeroscoutercollect.contracts.ActionsContract.ActionsEntry;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract.TeamEntry;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchContract.TeamMatchEntry;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract.MatchEntry;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchActionContract.TeamMatchActionEntry;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract.EventEntry;

/**
 * Created by tomso on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // static Singleton object
    private static DatabaseHelper sInstance;

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "ecxScoutingData";

    public static synchronized DatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // creating required tables
        Log.i(LOG, "Creating table " + ActionsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(ActionsEntry.CREATE_TABLE_ACTIONS);

        Log.i(LOG, "Creating table " + EventEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(EventEntry.CREATE_TABLE_EVENT);

        Log.i(LOG, "Creating table " + MatchEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(MatchEntry.CREATE_TABLE_MATCH);

        Log.i(LOG, "Creating table " + TeamEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(TeamEntry.CREATE_TABLE_TEAM);

        Log.i(LOG, "Creating table " + TeamMatchActionEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(TeamMatchActionEntry.CREATE_TABLE_TEAM_MATCH_ACTION);

        Log.i(LOG, "Creating table " + TeamMatchEntry.TABLE_NAME);
        sqLiteDatabase.execSQL(TeamMatchEntry.CREATE_TABLE_TEAM_MATCH);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // TODO - do we need to save data before dropping the tables?
        // on upgrade drop older tables
        Log.i(LOG, "Dropping table " + ActionsEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ActionsEntry.TABLE_NAME);

        Log.i(LOG, "Dropping table " + EventEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EventEntry.TABLE_NAME);

        Log.i(LOG, "Dropping table " + MatchEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MatchEntry.TABLE_NAME);

        Log.i(LOG, "Dropping table " + TeamEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TeamEntry.TABLE_NAME);

        Log.i(LOG, "Dropping table " + TeamMatchActionEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TeamMatchActionEntry.TABLE_NAME);

        Log.i(LOG, "Dropping table " + TeamMatchEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TeamMatchEntry.TABLE_NAME);

        // create new tables
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        // TODO - should we save data before downgrading the tables?
    }
}
