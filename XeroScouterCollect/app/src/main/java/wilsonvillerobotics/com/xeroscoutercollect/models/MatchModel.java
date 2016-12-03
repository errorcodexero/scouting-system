package wilsonvillerobotics.com.xeroscoutercollect.models;

import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract;

/**
 * Created by nick on 12/1/16.
 */

public class MatchModel {

    public static String getAllMatchs(String eventId) {

        return ("SELECT * FROM `" + MatchContract.MatchEntry.TABLE_NAME + "` WHERE " + MatchContract.MatchEntry.COLUMN_NAME_EVENT_ID + " = \'" + eventId + "\' ORDER BY id;");

    }
}
