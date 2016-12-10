package wilsonvillerobotics.com.xeroscoutercollect.contracts;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.database.TableColumn;
import wilsonvillerobotics.com.xeroscoutercollect.database.TableIntegerColumn;
import wilsonvillerobotics.com.xeroscoutercollect.database.TableStringColumn;
import wilsonvillerobotics.com.xeroscoutercollect.database.XMLParser;
import wilsonvillerobotics.com.xeroscoutercollect.interfaces.SQLDataTypeDefines;

/**1
 * Created by tomso on 11/30/2016.
 */

public class TeamMatchContract implements SQLDataTypeDefines {

    public TeamMatchContract(){}

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
    public void queryInsertTeamMatchData(HashMap<String, TableColumn> teamMatchMap, Context c){
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(c);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues content = new ContentValues();
        if(teamMatchMap.containsKey(TeamMatchContract.TeamMatchEntry.COLUMN_NAME_ID)){
            teamMatchMap.remove(TeamMatchContract.TeamMatchEntry.COLUMN_NAME_ID);
        }
        for(String key : teamMatchMap.keySet()){
            if(teamMatchMap.get(key).getClass() == TableStringColumn.class) {
                content.put(key, ((TableStringColumn) teamMatchMap.get(key)).getValue());
            } else if(teamMatchMap.get(key).getClass() == TableIntegerColumn.class){
                content.put(key, ((TableIntegerColumn) teamMatchMap.get(key)).getValue());
            }

        }
        try{
            db.insert(TeamMatchContract.TeamMatchEntry.TABLE_NAME,null, content);
        }
        catch (Exception e) {e.printStackTrace();}

    }
}
