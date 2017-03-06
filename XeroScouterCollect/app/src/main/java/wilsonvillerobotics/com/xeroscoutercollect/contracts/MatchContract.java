package wilsonvillerobotics.com.xeroscoutercollect.contracts;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.database.XMLParser;
import wilsonvillerobotics.com.xeroscoutercollect.interfaces.SQLDataTypeDefines;

/**
 * Created by nick on 11/29/16.
 */

public class MatchContract implements SQLDataTypeDefines {

    public MatchContract() {}

    public static class MatchEntry implements BaseColumns {
        public static final String TABLE_NAME = "match";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_EVENT_ID = "event_id";
        public static final String COLUMN_NAME_TBA_MATCH_KEY = "tba_match_key";
        public static final String COLUMN_NAME_MATCH_COMP_LEVEL  = "comp_level";
        public static final String COLUMN_NAME_MATCH_SET_NUMBER  = "set_number";
        public static final String COLUMN_NAME_MATCH_NUMBER  = "match_number";
        public static final String COLUMN_NAME_MATCH_STATUS  = "status";

        public static final String COLUMN_NAME_RED_1 = "red_1_team_id";
        public static final String COLUMN_NAME_RED_2 = "red_2_team_id";
        public static final String COLUMN_NAME_RED_3 = "red_3_team_id";
        public static final String COLUMN_NAME_RED_AUTO_SCORE = "red_auto_score";
        public static final String COLUMN_NAME_RED_TELEOP_SCORE = "red_teleop_score";
        public static final String COLUMN_NAME_RED_TOTAL_SCORE = "red_total_score";
        public static final String COLUMN_NAME_RED_QP = "red_qp";
        public static final String COLUMN_NAME_RED_FOUL_POINTS = "red_foul_points";

        public static final String COLUMN_NAME_BLUE_1 = "blue_1_team_id";
        public static final String COLUMN_NAME_BLUE_2 = "blue_2_team_id";
        public static final String COLUMN_NAME_BLUE_3 = "blue_3_team_id";
        public static final String COLUMN_NAME_BLUE_AUTO_SCORE = "blue_auto_score";
        public static final String COLUMN_NAME_BLUE_TELEOP_SCORE = "blue_teleop_score";
        public static final String COLUMN_NAME_BLUE_TOTAL_SCORE = "blue_total_score";
        public static final String COLUMN_NAME_BLUE_QP = "blue_qp";
        public static final String COLUMN_NAME_BLUE_FOUL_POINTS = "blue_foul_points";

        public static final String COLUMN_NAME_MATCH_WINNER = "winner";
        public static final String COLUMN_NAME_DRIVE_TEAM_COMMENTS = "drive_team_comments";

        public static final String CREATE_TABLE_MATCH =
                "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_NAME_ID + INTPK + COMMA_SEP
                        + COLUMN_NAME_EVENT_ID + INT11 + COMMA_SEP
                        + COLUMN_NAME_TBA_MATCH_KEY + VC255 + COMMA_SEP
                        + COLUMN_NAME_MATCH_COMP_LEVEL + VC45 + COMMA_SEP
                        + COLUMN_NAME_MATCH_SET_NUMBER + VC45 + COMMA_SEP
                        + COLUMN_NAME_MATCH_NUMBER + VC45 + COMMA_SEP
                        + COLUMN_NAME_MATCH_STATUS + VC45 + COMMA_SEP
                        + COLUMN_NAME_RED_1 + INT11 + COMMA_SEP
                        + COLUMN_NAME_RED_2 + INT11 + COMMA_SEP
                        + COLUMN_NAME_RED_3 + INT11 + COMMA_SEP
                        + COLUMN_NAME_RED_AUTO_SCORE + INT11 + COMMA_SEP
                        + COLUMN_NAME_RED_TELEOP_SCORE + INT11 + COMMA_SEP
                        + COLUMN_NAME_RED_TOTAL_SCORE + INT11 + COMMA_SEP
                        + COLUMN_NAME_RED_QP + INT11 + COMMA_SEP
                        + COLUMN_NAME_RED_FOUL_POINTS + INT11 + COMMA_SEP
                        + COLUMN_NAME_BLUE_1 + INT11 + COMMA_SEP
                        + COLUMN_NAME_BLUE_2 + INT11 + COMMA_SEP
                        + COLUMN_NAME_BLUE_3 + INT11 + COMMA_SEP
                        + COLUMN_NAME_BLUE_AUTO_SCORE + INT11 + COMMA_SEP
                        + COLUMN_NAME_BLUE_TELEOP_SCORE + INT11 + COMMA_SEP
                        + COLUMN_NAME_BLUE_TOTAL_SCORE + INT11 + COMMA_SEP
                        + COLUMN_NAME_BLUE_QP + INT11 + COMMA_SEP
                        + COLUMN_NAME_BLUE_FOUL_POINTS + INT11 + COMMA_SEP
                        + COLUMN_NAME_MATCH_WINNER + VC45 + COMMA_SEP
                        + COLUMN_NAME_DRIVE_TEAM_COMMENTS + VC2000
                        + ")";
    }
    public void queryInsertMatchData(HashMap<String, XMLParser.TableColumn> matchMap, Context c){
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(c);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues content = new ContentValues();

        for(String key : matchMap.keySet()){
            if(matchMap.get(key).getClass() == XMLParser.TableStringColumn.class) {
                content.put(key, ((XMLParser.TableStringColumn) matchMap.get(key)).getValue());
            } else if(matchMap.get(key).getClass() == XMLParser.TableIntegerColumn.class){
                content.put(key, ((XMLParser.TableIntegerColumn) matchMap.get(key)).getValue());
            }

        }
        try{
            db.insert(MatchContract.MatchEntry.TABLE_NAME,null, content);
        }
        catch (Exception e) {e.printStackTrace();}

    }
}
