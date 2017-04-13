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
 * Created by tomso on 11/30/2016.
 */

public class EventContract implements SQLDataTypeDefines {

    public EventContract(){}

    public static class EventEntry implements BaseColumns {
        public static final String TABLE_NAME = "event";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_TBA_EVENT_KEY = "tba_event_key";
        public static final String COLUMN_NAME_EVENT_NAME = "name";
        public static final String COLUMN_NAME_EVENT_SHORT_NAME = "short_name";
        public static final String COLUMN_NAME_EVENT_TYPE = "event_type";
        public static final String COLUMN_NAME_EVENT_DISTRICT = "event_district";
        public static final String COLUMN_NAME_EVENT_YEAR = "year";
        public static final String COLUMN_NAME_EVENT_WEEK = "week";
        public static final String COLUMN_NAME_EVENT_LOCATION = "location";
        public static final String COLUMN_NAME_TBA_EVENT_CODE = "tba_event_code";

        public static final String CREATE_TABLE_EVENT =
                "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_NAME_ID + INTPK + COMMA_SEP
                        + COLUMN_NAME_TBA_EVENT_KEY + VC45 + COMMA_SEP
                        + COLUMN_NAME_EVENT_NAME + VC255 + COMMA_SEP
                        + COLUMN_NAME_EVENT_SHORT_NAME + VC255 + COMMA_SEP
                        + COLUMN_NAME_EVENT_TYPE + VC255 + COMMA_SEP
                        + COLUMN_NAME_EVENT_DISTRICT + VC255 + COMMA_SEP
                        + COLUMN_NAME_EVENT_YEAR + INT11 + COMMA_SEP
                        + COLUMN_NAME_EVENT_WEEK + INT11 + COMMA_SEP
                        + COLUMN_NAME_EVENT_LOCATION + VC255 + COMMA_SEP
                        + COLUMN_NAME_TBA_EVENT_CODE + VC45
                        + ")";
        }
    public void queryInsertEventData(HashMap<String, XMLParser.TableColumn> eventMap, Context c){
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(c);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues content = new ContentValues();

        for(String key : eventMap.keySet()){
            if(eventMap.get(key).getClass() == XMLParser.TableStringColumn.class) {
                content.put(key, ((XMLParser.TableStringColumn) eventMap.get(key)).getValue());
            } else if(eventMap.get(key).getClass() == XMLParser.TableIntegerColumn.class){
                content.put(key, ((XMLParser.TableIntegerColumn) eventMap.get(key)).getValue());
            }

        }
        try{
            db.insert(EventEntry.TABLE_NAME,null, content);
        }
        catch (Exception e) {e.printStackTrace();}

    }


}
