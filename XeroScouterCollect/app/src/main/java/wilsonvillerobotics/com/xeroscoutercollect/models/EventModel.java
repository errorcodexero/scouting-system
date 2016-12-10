package wilsonvillerobotics.com.xeroscoutercollect.models;

import java.util.ArrayList;

import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.TableColumn;
import wilsonvillerobotics.com.xeroscoutercollect.database.TableIntegerColumn;
import wilsonvillerobotics.com.xeroscoutercollect.database.TableStringColumn;

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

    public Integer getEventId() {

        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    private Integer eventId;
    private String eventShortName;
    private String eventType;
    private String eventDistrict;
    private String eventYear;
    private String eventWeek;

    private String eventLocation;

    private String tbaEventCode;

    private ArrayList<TableColumn> columnNames;

    public EventModel() {
        columnNames.add(new TableIntegerColumn("_id", x -> setEventId(Integer.valueOf(x))))d;
        columnNames.add(new TableStringColumn("name", x -> setEventName(String.valueOf(x))));
        columnNames.add(new TableStringColumn("tba_event_key", x -> setTbaEventKey(String.valueOf(x))));
        columnNames.add(new TableStringColumn("short_name", x -> setEventShortName(String.valueOf(x))));
        columnNames.add(new TableStringColumn("event_type", x -> setEventType(String.valueOf(x))));
        columnNames.add(new TableStringColumn("event_district", x -> setEventDistrict(String.valueOf(x))));
        columnNames.add(new TableIntegerColumn("year", x -> setEventYear(Integer.valueOf(x))));
        columnNames.add(new TableIntegerColumn("week", x -> setEventWeek(Integer.valueOf(x))));
        columnNames.add(new TableStringColumn("location", x -> setEventLocation(String.valueOf(x))));
        columnNames.add(new TableStringColumn("tba_event_code", x -> setTbaEventCode(String.valueOf(x))));
    }
    public static String getAllEvents() {
        return("SELET * FROM " + EventContract.EventEntry.TABLE_NAME);
    }
}
