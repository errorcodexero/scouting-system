package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;

import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchActionContract;

import static wilsonvillerobotics.com.xeroscoutercollect.contracts.ActionsContract.ActionsEntry.TABLE_NAME;

/**
 * Created by nick on 12/12/16.
 */

public class XMLExporter {

    private Integer lastTeamMatchAction = 0;

    private DatabaseHelper dbHelper;

    private String CLOSETAG = ">";

    public Integer getLastTeamMatchAction() {
        return lastTeamMatchAction;
    }

    private String OPENTAG = "<";

    private String DATA = "DATA";
    private String ROW = "ROW";
    private String TABLE = "TABLE";
    private String NAME = "NAME";

    private String NEWLINE = "\n";
    private String TAB = "\t";
    private SharedPreferences sharedPreferences;

    public XMLExporter(Context appContext) {
        dbHelper = DatabaseHelper.getInstance(appContext);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(appContext);
        lastTeamMatchAction = Integer.parseInt(sharedPreferences.getString("tma_index_id", "0"));

    }

    public String GenerateTagByName(String tagName, int tabCount, Boolean closingTag, Boolean hasNewLine) {
        String tag = "";
        for(int i = 0; i < tabCount; i++) {tag += TAB;}
        if (closingTag) {
            tag += OPENTAG + "/" + tagName + CLOSETAG;
        } else {
            tag = tag + OPENTAG + tagName + CLOSETAG;
        }
        if (hasNewLine) {
            tag += NEWLINE;
        }
        //Log.d("XML", tag);
        return tag;
    }/*
            return("INSERT INTO " + TeamMatchActionContract.TeamMatchActionEntry.TABLE_NAME + " ("
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TABLET_ID + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TEAM_MATCH_ID + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_TYPE_ID + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_QUANTITY + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_START_TIME + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_END_TIME + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_OBJECT_COUNT + ") VALUES ("
                + tablet_id + COMMA_SEP + TeamMatchId + COMMA_SEP + ActionId + COMMA_SEP + quant + COMMA_SEP
                + "datetime(), datetime(), 0);");
    */

    public String generateTeamData(Integer teamId, Boolean startDataTag, Boolean endDataTag, Context context) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String queryStatement = "SELECT * FROM team WHERE _id = " + teamId + ";";

        Cursor cursor = db.rawQuery(queryStatement, null);
        cursor.moveToFirst();

        String xmlResult = "";
        if (startDataTag) {
            xmlResult = GenerateTagByName(DATA, 0, false, true);
        }

        xmlResult += GenerateTagByName(ROW, 1, false, true);

        for ( String i : TeamContract.getPitDataDBNames(context)) {

            if (cursor.getType(cursor.getColumnIndex(i)) == Cursor.FIELD_TYPE_INTEGER) {

                xmlResult += GenerateTagByName(i, 2, false, false) +
                        cursor.getInt(cursor.getColumnIndex(i)) + GenerateTagByName(i, 0, true, true);

            } else if (cursor.getType(cursor.getColumnIndex(i)) == Cursor.FIELD_TYPE_STRING) {
                xmlResult += GenerateTagByName(i, 2, false, false) +
                        cursor.getString(cursor.getColumnIndex(i)) + GenerateTagByName(i, 0, true, true);
            }

        }
        if (endDataTag) {
            xmlResult = GenerateTagByName(DATA, 0, false, true);
        }
        return xmlResult;

    }

    public String generateAllTeamData(Boolean startDataTag, Boolean endDataTag, Context context) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String queryStatement = "SELECT * FROM team;";

        Cursor cursor = db.rawQuery(queryStatement, null);
        cursor.moveToFirst();

        String xmlResult = "";
        if (startDataTag) {
            xmlResult = GenerateTagByName(DATA, 0, false, true);
        }

        xmlResult += GenerateTagByName(ROW, 1, false, true);

        String tempString;

        int tempTypeHolder = 0;

        do {

            for ( String i : TeamContract.getPitDataDBNames(context)) {

                int tempColumnIndex = cursor.getColumnIndex(i);
                tempTypeHolder = cursor.getType(tempColumnIndex);



                if (tempTypeHolder == Cursor.FIELD_TYPE_INTEGER) {

                    tempString = GenerateTagByName(i, 2, false, false) +
                            cursor.getInt(cursor.getColumnIndex(i)) + GenerateTagByName(i, 0, true, true);

                    xmlResult += tempString;

                } else if (tempTypeHolder == Cursor.FIELD_TYPE_STRING) {

                    tempString = GenerateTagByName(i, 2, false, false) +
                            cursor.getString(cursor.getColumnIndex(i)) + GenerateTagByName(i, 0, true, true);

                    xmlResult += tempString;

                }
                tempString = "";

            }
        } while(cursor.moveToNext());
        if (endDataTag) {
            xmlResult += GenerateTagByName(DATA, 0, true, true);
        }
        return xmlResult;

    }

    private String GenerateTeamMatchAction(Integer matchId, Boolean startDataTag, Boolean endDataTag) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String queryStatement = "SELECT * FROM team_match_action WHERE _id = " + matchId + ";";

        Cursor cursor = db.rawQuery(queryStatement, null);
        cursor.moveToFirst();

        String xmlResult = "";
        if (startDataTag) { 
            xmlResult = GenerateTagByName(DATA, 0, false, true);
        }

        xmlResult += GenerateTagByName(ROW, 1, false, true);


        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ID, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("_id")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ID, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TEAM_MATCH_ID, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("team_match_id")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TEAM_MATCH_ID, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_TYPE_ID, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("type_id")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_TYPE_ID, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_QUANTITY, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("quantity")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_QUANTITY, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_START_TIME, 2, false, false) +
                cursor.getString(cursor.getColumnIndex("start_time")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_START_TIME, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_END_TIME, 2, false, false) +
                cursor.getString(cursor.getColumnIndex("end_time")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_END_TIME, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_OBJECT_COUNT, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("object_count")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_OBJECT_COUNT, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TABLET_UUID, 2, false, false) +
                cursor.getString(cursor.getColumnIndex("tablet_uuid")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TABLET_UUID, 0, true, true);


        xmlResult += GenerateTagByName(ROW, 1, false, true) + "\n";

        if (endDataTag) {
            xmlResult = GenerateTagByName(DATA, 0, false, true);
        }
        return xmlResult;
    }

    private String GenerateTeamMatchAction(Integer matchId, Boolean startDataTag, Boolean endDataTag, Cursor cursor) {

        String xmlResult = "";
        if (startDataTag) {
            xmlResult = GenerateTagByName(DATA, 0, false, true);
            //Adds table name tag for DataManager
            xmlResult += GenerateTagByName(TABLE,1,false,false) + "\n";
            xmlResult += GenerateTagByName(NAME, 2, false, false) + TeamMatchActionContract.TeamMatchActionEntry.TABLE_NAME + GenerateTagByName(NAME, 0, true, true) + "\n";
            xmlResult += GenerateTagByName(TABLE,1,true,true);
        }

        xmlResult += GenerateTagByName(ROW, 1, false, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ID, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("_id")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ID, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TEAM_MATCH_ID, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("team_match_id")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TEAM_MATCH_ID, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_TYPE_ID, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("action_type_id")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_TYPE_ID, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_QUANTITY, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("quantity")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_QUANTITY, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_START_TIME, 2, false, false) +
                cursor.getString(cursor.getColumnIndex("start_time")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_START_TIME, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_END_TIME, 2, false, false) +
                cursor.getString(cursor.getColumnIndex("end_time")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_END_TIME, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_OBJECT_COUNT, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("object_count")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_OBJECT_COUNT, 0, true, true);

        xmlResult += GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TABLET_UUID, 2, false, false) +
                cursor.getString(cursor.getColumnIndex("tablet_uuid")) + GenerateTagByName(TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TABLET_UUID, 0, true, true);

        xmlResult += GenerateTagByName(ROW, 1, true, true) + "\n";

        if (endDataTag) {
            xmlResult = GenerateTagByName(DATA, 0, false, true);
        }
        return xmlResult;
    }

    public String GenerateTeam(Integer matchId, Boolean startDataTag, Boolean endDataTag, Cursor cursor) {


        String xmlResult = "";
        if (startDataTag) {
            xmlResult = GenerateTagByName(DATA, 0, false, true);
            xmlResult += GenerateTagByName(TABLE,1,false,false) + "\n";
            xmlResult += GenerateTagByName(NAME, 2, false, false) + TABLE_NAME + GenerateTagByName(NAME, 0, true, true) + "\n";
            xmlResult += GenerateTagByName(TABLE,1,true,true);
        }

        xmlResult += GenerateTagByName(ROW, 1, false, true);

        xmlResult += GenerateTagByName(TeamContract.TeamEntry.COLUMN_NAME_ID, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("_id")) + GenerateTagByName(TeamContract.TeamEntry.COLUMN_NAME_ID, 0, true, true);
        xmlResult += GenerateTagByName(TeamContract.TeamEntry.COLUMN_NAME_ID, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("_id")) + GenerateTagByName(TeamContract.TeamEntry.COLUMN_NAME_ID, 0, true, true);
        xmlResult += GenerateTagByName(TeamContract.TeamEntry.COLUMN_NAME_ID, 2, false, false) +
                cursor.getInt(cursor.getColumnIndex("_id")) + GenerateTagByName(TeamContract.TeamEntry.COLUMN_NAME_ID, 0, true, true);
        xmlResult += GenerateTagByName(ROW, 1, true, true) + "\n";

        if (endDataTag) {
            xmlResult = GenerateTagByName(DATA, 0, false, true);
        }
        return xmlResult;
    }

    public String GenerateNextTeamMatchAction(Boolean startDataTag, Boolean endDataTag, Cursor cursor) {
        // Generate XML for next match sequentially
        return GenerateTeamMatchAction(lastTeamMatchAction + 1, startDataTag, endDataTag, cursor);
    }

    public ArrayList<String> GenerateNewMatches() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String queryStatement = "SELECT * FROM team_match_action WHERE _id > " + lastTeamMatchAction + ";";
        ArrayList<String> xmlResult = new ArrayList<String>();
        Log.d("DEBUG", String.valueOf(lastTeamMatchAction));

        Boolean firstRun = true;

        Cursor cursor = db.rawQuery(queryStatement, null);
        //cursor.moveToFirst();
        try {
            while (cursor.moveToNext()) {
                xmlResult.add(GenerateNextTeamMatchAction(firstRun, false, cursor));
                firstRun = false;
            }
            cursor.moveToLast();
            lastTeamMatchAction = cursor.getInt(cursor.getColumnIndex("_id"));
        } catch (CursorIndexOutOfBoundsException e) {
            Log.d("ERROR", "No Data Present!");
        } finally {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("tma_index_id", String.valueOf(lastTeamMatchAction));
            editor.commit();
            cursor.close();
            xmlResult.add(GenerateTagByName(DATA, 0, true, false));
            }
        return xmlResult;
    }

    public ArrayList<String> generatePitExport(){
        ArrayList<String> pitExport = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String queryStatement = "SELECT * FROM " + TeamContract.TeamEntry.TABLE_NAME + " WHERE _id > 0;";
        Cursor cursor = db.rawQuery(queryStatement, null);
        cursor.moveToFirst();




        


        return pitExport;
    }

}


