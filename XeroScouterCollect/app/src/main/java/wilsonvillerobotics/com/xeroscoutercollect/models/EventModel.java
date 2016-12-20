package wilsonvillerobotics.com.xeroscoutercollect.models;

import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract;

/**
 * Created by nick on 12/3/16.
 */

public class EventModel {

    private String tbaEventKey;
    private String eventName;

    public String getTbaEventKey() {
        return tbaEventKey;
    }

    public void setTbaEventKey(String tbaEventKey) {
        this.tbaEventKey = tbaEventKey;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventShortName() {
        return eventShortName;
    }

    public void setEventShortName(String eventShortName) {
        this.eventShortName = eventShortName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDistrict() {
        return eventDistrict;
    }

    public void setEventDistrict(String eventDistrict) {
        this.eventDistrict = eventDistrict;
    }

    public String getEventYear() {
        return eventYear;
    }

    public void setEventYear(String eventYear) {
        this.eventYear = eventYear;
    }

    public String getEventWeek() {
        return eventWeek;
    }

    public void setEventWeek(String eventWeek) {
        this.eventWeek = eventWeek;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getTbaEventCode() {
        return tbaEventCode;
    }

    public void setTbaEventCode(String tbaEventCode) {
        this.tbaEventCode = tbaEventCode;
    }

    private String eventShortName;
    private String eventType;
    private String eventDistrict;
    private String eventYear;
    private String eventWeek;
    private String eventLocation;
    private String tbaEventCode;

    public static String getAllEvents() {
        return("SELET * FROM " + EventContract.EventEntry.TABLE_NAME);
    }

}
