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
 * Created by Luke on 11/29/2016.
 */

public class ActionsContract implements SQLDataTypeDefines {

    public ActionsContract(){}

    public static class ActionsEntry implements BaseColumns {
        public static final String TABLE_NAME = "action_type";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_ACTION_NAME = "name";
        public static final String COLUMN_NAME_ACTION_DESCRIPTION = "description";
        public static final String COLUMN_NAME_ACTION_MATCH_PHASE = "match_phase";
        public static final String COLUMN_NAME_ACTION_POINTS = "points";
        public static final String COLUMN_NAME_ACTION_OPPONENT_POINTS = "opponent_points";
        public static final String COLUMN_NAME_ACTION_QUAL_POINTS = "qual_points";
        public static final String COLUMN_NAME_ACTION_FOUL_POINTS = "foul_points";
        public static final String COLUMN_NAME_ACTION_COOP_FLAG = "coop_flag";
        public static final String COLUMN_NAME_ACTION_CATEGORY = "category";

        public static final String CREATE_TABLE_ACTIONS =
                "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_NAME_ID + INTPK + COMMA_SEP
                        + COLUMN_NAME_ACTION_NAME + VC255 + COMMA_SEP
                        + COLUMN_NAME_ACTION_DESCRIPTION + VC2000 + COMMA_SEP
                        + COLUMN_NAME_ACTION_MATCH_PHASE + VC45 + COMMA_SEP
                        + COLUMN_NAME_ACTION_POINTS + DOUBLE + COMMA_SEP
                        + COLUMN_NAME_ACTION_OPPONENT_POINTS + INT11 + COMMA_SEP
                        + COLUMN_NAME_ACTION_QUAL_POINTS + INT11 + COMMA_SEP
                        + COLUMN_NAME_ACTION_FOUL_POINTS + INT11 + COMMA_SEP
                        + COLUMN_NAME_ACTION_COOP_FLAG + CHAR1 + COMMA_SEP
                        + COLUMN_NAME_ACTION_CATEGORY + VC255
                        + ")";

        public static final String testData =
                "<DATA>\n" +
                "\t<ROW>\n" +
                "\t\t<" + COLUMN_NAME_ID + ">1</" + COLUMN_NAME_ID + ">\n" +
                "\t\t<" + COLUMN_NAME_ACTION_NAME + ">Crossing</" + COLUMN_NAME_ACTION_NAME + ">\n" +
                "\t\t<" + COLUMN_NAME_ACTION_DESCRIPTION + ">crossing</" + COLUMN_NAME_ACTION_DESCRIPTION + ">\n" +
                "\t\t<" + COLUMN_NAME_ACTION_MATCH_PHASE + ">teleop</" + COLUMN_NAME_ACTION_MATCH_PHASE + ">\n" +
                "\t\t<" + COLUMN_NAME_ACTION_POINTS + ">1</" + COLUMN_NAME_ACTION_POINTS + ">\n" +
                "\t\t<" + COLUMN_NAME_ACTION_OPPONENT_POINTS + ">0</" + COLUMN_NAME_ACTION_OPPONENT_POINTS + ">\n" +
                "\t\t<" + COLUMN_NAME_ACTION_QUAL_POINTS + ">0</" + COLUMN_NAME_ACTION_QUAL_POINTS + ">\n" +
                "\t\t<" + COLUMN_NAME_ACTION_FOUL_POINTS + ">0</" + COLUMN_NAME_ACTION_FOUL_POINTS + ">\n" +
                "\t\t<" + COLUMN_NAME_ACTION_COOP_FLAG + ">N</" + COLUMN_NAME_ACTION_COOP_FLAG + ">\n" +
                "\t\t<" + COLUMN_NAME_ACTION_CATEGORY + ">movement</" + COLUMN_NAME_ACTION_CATEGORY + ">\n" +
                "\t</ROW>\n" +
                "</DATA>";
    }
    public void queryInsertActionsData(HashMap<String, XMLParser.TableColumn> actionsMap, Context c){
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(c);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues content = new ContentValues();
        if(actionsMap.containsKey(ActionsContract.ActionsEntry.COLUMN_NAME_ID)){
            actionsMap.remove(ActionsContract.ActionsEntry.COLUMN_NAME_ID);
        }
        for(String key : actionsMap.keySet()){
            if(actionsMap.get(key).getClass() == XMLParser.TableStringColumn.class) {
                content.put(key, ((XMLParser.TableStringColumn) actionsMap.get(key)).getValue());
            } else if(actionsMap.get(key).getClass() == XMLParser.TableIntegerColumn.class){
                content.put(key, ((XMLParser.TableIntegerColumn) actionsMap.get(key)).getValue());
            }

        }
        try{
            db.insert(ActionsContract.ActionsEntry.TABLE_NAME,null, content);
        }
        catch (Exception e) {e.printStackTrace();}

    }

}
