package wilsonvillerobotics.com.xeroscoutercollect.models;

import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract;

/**
 * Created by nick on 12/3/16.
 */

public class EventModel {

    public static String getAllEvents() {
        return("SELET * FROM " + EventContract.EventEntry.TABLE_NAME);
    }

}
