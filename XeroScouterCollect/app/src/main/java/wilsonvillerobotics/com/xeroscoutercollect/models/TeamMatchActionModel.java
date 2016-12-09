package wilsonvillerobotics.com.xeroscoutercollect.models;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;

import wilsonvillerobotics.com.xeroscoutercollect.contracts.ActionsContract;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchActionContract;
import wilsonvillerobotics.com.xeroscoutercollect.interfaces.SQLDataTypeDefines;


/**
 * Created by nick on 12/3/16.
 */

public class TeamMatchActionModel implements SQLDataTypeDefines {

    private Integer id;
    private Integer tabletId;
    private Integer teamMatchId;

    private Integer actionTypeId;
    private Integer actionQuantity;

    private String actionStartTime;
    private String actionEndTime;

    private Integer actionObjectCount;


    public static String addAction(int tablet_id, int TeamMatchId, int ActionId, Boolean isDec) {

        int quant = isDec ? -1 : 1;

        return("INSERT INTO " + TeamMatchActionContract.TeamMatchActionEntry.TABLE_NAME + " ("
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TABLET_ID + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_TEAM_MATCH_ID + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_TYPE_ID + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_ACTION_QUANTITY + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_START_TIME + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_END_TIME + COMMA_SEP
                + TeamMatchActionContract.TeamMatchActionEntry.COLUMN_NAME_OBJECT_COUNT + ") VALUES ("
                + tablet_id + COMMA_SEP + TeamMatchId + COMMA_SEP + ActionId + COMMA_SEP + quant + COMMA_SEP
                + "datetime(), datetime(), ");

    }

}
