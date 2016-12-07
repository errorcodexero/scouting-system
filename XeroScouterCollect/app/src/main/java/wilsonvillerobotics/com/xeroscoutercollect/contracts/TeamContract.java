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

public class TeamContract implements SQLDataTypeDefines {

    public TeamContract(){}

    public static class TeamEntry implements BaseColumns{
        public static final String TABLE_NAME = "team";
        public static final String COLUMN_NAME_ID = "_id";
        public static final String COLUMN_NAME_TBA_TEAM_KEY = "tba_team_key";
        public static final String COLUMN_NAME_TEAM_LONG_NAME = "team_long_name";
        public static final String COLUMN_NAME_TEAM_NAME = "team_name";
        public static final String COLUMN_NAME_LOGO_FILE_LOCATION = "logo_file_location";
        public static final String COLUMN_NAME_TEAM_CITY = "team_city";
        public static final String COLUMN_NAME_TEAM_STATE_CODE = "team_state_code";
        public static final String COLUMN_NAME_TEAM_COUNTRY = "team_country";
        public static final String COLUMN_NAME_TEAM_MOTTO = "team_motto";
        public static final String COLUMN_NAME_TEAM_ROOKIE_YEAR = "team_rookie_year";
        public static final String COLUMN_NAME_ROBOT_NAME = "robot_name";
        public static final String COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION = "robot_picture_file_location";
        public static final String COLUMN_NAME_ROBOT_DRIVE_TYPE = "robot_drive_type";
        public static final String COLUMN_NAME_ROBOT_WHEEL_COUNT = "robot_wheel_count";
        public static final String COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT = "robot_drive_motor_count";
        public static final String COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE = "robot_software_language";
        public static final String COLUMN_NAME_ROBOT_DESCRIPTION = "robot_description";
        public static final String COLUMN_NAME_PIT_SCOUT_COMMENTS = "pit_scout_comments";

        public static final String CREATE_TABLE_TEAM =
                "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_NAME_ID + INTPK + COMMA_SEP
                        + COLUMN_NAME_TBA_TEAM_KEY + VC45 + COMMA_SEP
                        + COLUMN_NAME_TEAM_LONG_NAME + VC255 + COMMA_SEP
                        + COLUMN_NAME_TEAM_NAME + VC255 + COMMA_SEP
                        + COLUMN_NAME_LOGO_FILE_LOCATION + VC2000 + COMMA_SEP
                        + COLUMN_NAME_TEAM_CITY + VC255 + COMMA_SEP
                        + COLUMN_NAME_TEAM_STATE_CODE + VC45 + COMMA_SEP
                        + COLUMN_NAME_TEAM_COUNTRY + VC255 + COMMA_SEP
                        + COLUMN_NAME_TEAM_MOTTO + VC2000 + COMMA_SEP
                        + COLUMN_NAME_TEAM_ROOKIE_YEAR + INT11 + COMMA_SEP
                        + COLUMN_NAME_ROBOT_NAME + VC255 + COMMA_SEP
                        + COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION + VC2000 + COMMA_SEP
                        + COLUMN_NAME_ROBOT_DRIVE_TYPE + VC45 + COMMA_SEP
                        + COLUMN_NAME_ROBOT_WHEEL_COUNT + INT11 + COMMA_SEP
                        + COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT + INT11 + COMMA_SEP
                        + COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE + VC45 + COMMA_SEP
                        + COLUMN_NAME_ROBOT_DESCRIPTION + VC2000 + COMMA_SEP
                        + COLUMN_NAME_PIT_SCOUT_COMMENTS + VC2000
                        + ")";

    }
    public void queryInsertTeamData(HashMap<String, XMLParser.TableColumn> teamMap, Context c){
        DatabaseHelper dbHelper = DatabaseHelper.getInstance(c);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues content = new ContentValues();
        if(teamMap.containsKey(TeamContract.TeamEntry.COLUMN_NAME_ID)){
            teamMap.remove(TeamContract.TeamEntry.COLUMN_NAME_ID);
        }
        for(String key : teamMap.keySet()){
            if(teamMap.get(key).getClass() == XMLParser.TableStringColumn.class) {
                content.put(key, ((XMLParser.TableStringColumn) teamMap.get(key)).getValue());
            } else if(teamMap.get(key).getClass() == XMLParser.TableIntegerColumn.class){
                content.put(key, ((XMLParser.TableIntegerColumn) teamMap.get(key)).getValue());
            }

        }
        try{
            db.insert(TeamContract.TeamEntry.TABLE_NAME,null, content);
        }
        catch (Exception e) {e.printStackTrace();}

    }
}
