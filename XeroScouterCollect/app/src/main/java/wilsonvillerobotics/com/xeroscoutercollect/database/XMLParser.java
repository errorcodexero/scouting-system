package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.content.Context;
import android.util.EventLog;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.activities.ManageDBActivity;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.ActionsContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchContract.TeamMatchEntry;

import static android.content.ContentValues.TAG;



/**
 * Created by Luke on 12/3/2016.
 */

public class XMLParser{
    private String xmlFilePath;
    private DatabaseHelper myDbHelper = null;
    private Context context;
    private String dataString = "No data was found";
    private XmlPullParserFactory xmlFactoryObject;
    private XmlPullParser myParser;

    private static final String TNTAG = "Table Name";
    private static final String XML_EXT = ".xml";


    public XMLParser(String filePath, Context c){
        xmlFilePath = filePath;
        context = c;
    }
    public XMLParser(Context c){
        this("", c);
    }

    public HashMap<String, TableColumn> parseXML(String filePath) {
        xmlFilePath = filePath;
        map = parseXml();
        return map;
    }

    private String readString(XmlPullParser parser) throws IOException,
            XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private Integer readInteger(XmlPullParser parser) throws IOException,
            XmlPullParserException {
        Integer result = 0;
        if (parser.next() == XmlPullParser.TEXT) {
            result = Integer.parseInt(parser.getText());
            parser.nextTag();
        }
        return result;
    }
    private HashMap<String, TableColumn> map = null;

    // TODO - Look at https://developer.android.com/training/basics/network-ops/xml.html#skip for better examples of XML Parsing. When we pass a parser to a function it keeps its current state, including 'position'
    public HashMap<String, TableColumn> parseXml(){
        try {
            FileInputStream fileStream = new FileInputStream(xmlFilePath);

            //Creates a map, then depending on filename, creates the right map

            final String TABLE_NAME_KEY = context.getString(R.string.table_name_key);
            TableTableNameColumn tc = new TableTableNameColumn(TABLE_NAME_KEY);
            if(xmlFilePath.contains(MatchContract.MatchEntry.TABLE_NAME + XML_EXT)) { // match.xml
                map = mapMaker(makeMatchList());
                tc.setValue(ManageDBActivity.TABLE_NAME.MATCH);
                map.put(TABLE_NAME_KEY,tc);
                Log.d(TNTAG, MatchContract.MatchEntry.TABLE_NAME);
            }else if(xmlFilePath.contains(EventContract.EventEntry.TABLE_NAME + XML_EXT)){
                map = mapMaker(makeEventList());
                tc.setValue(ManageDBActivity.TABLE_NAME.EVENT);
                map.put(TABLE_NAME_KEY,tc);
                Log.d(TNTAG, EventContract.EventEntry.TABLE_NAME);
            }else if(xmlFilePath.contains(ActionsContract.ActionsEntry.TABLE_NAME + XML_EXT)){
                map = mapMaker(makeActionTypeList());
                tc.setValue(ManageDBActivity.TABLE_NAME.ACTIONTYPE);
                map.put(TABLE_NAME_KEY,tc);
                Log.d(TNTAG, ActionsContract.ActionsEntry.TABLE_NAME);
            }else if(xmlFilePath.contains(TeamMatchEntry.TABLE_NAME + XML_EXT)){
                map = makeTeamMatchMap();
                tc.setValue(ManageDBActivity.TABLE_NAME.TEAMMATCH);
                map.put(TABLE_NAME_KEY,tc);
                Log.d(TNTAG, TeamMatchEntry.TABLE_NAME);
            }else if(xmlFilePath.contains(TeamContract.TeamEntry.TABLE_NAME + XML_EXT)){
                map = mapMaker(makeTeamList());
                tc.setValue(ManageDBActivity.TABLE_NAME.TEAM);
                map.put(TABLE_NAME_KEY,tc);
                Log.d(TNTAG, TeamContract.TeamEntry.TABLE_NAME);
            }

            xmlFactoryObject = XmlPullParserFactory.newInstance();
            myParser = xmlFactoryObject.newPullParser();
            myParser.setInput(fileStream, null);



            while (myParser.next() != XmlPullParser.END_TAG) {
                if (myParser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String tagName = myParser.getName();
                if (tagName.equals("Table")) {
                    //String id = null, date = null, pob = null;
                    while (myParser.next() != XmlPullParser.END_TAG) {
                        if (myParser.getEventType() != XmlPullParser.START_TAG) {
                            continue;
                        }
                        tagName = myParser.getName();
                        // Iterate through the map, setting the value of each element based on the tag name
                        if (map.containsKey(tagName)) {
                            TableColumn tableCol = map.get(tagName);
                            if (tableCol.getClass() == TableIntegerColumn.class) {
                                tableCol.setValue(readInteger(myParser));
                                Log.d(TAG, "parseXML: " + tagName + ": " + String.valueOf(tableCol.getValue()));
                            } else if (tableCol.getClass() == TableStringColumn.class) {
                                tableCol.setValue(readString(myParser));
                                Log.d(TAG, "parseXML: " + tagName + ": " + tableCol.getValue());
                            }
                        } else {
                            // We didn't find this tag, log it
                            Log.e(TAG, "Invalid tag: " + tagName);
                        }
                    }
                    //myDbHelper.insertData(id,date,pob);
                }
            }
        }
        catch(Exception e) {e.printStackTrace();}
        return map;
    }



//key value type

    public class TableColumn<E> {
        protected String key;
        protected E value;

        public TableColumn (String k) {
            key = k;
        }
        public void setValue(E v){
            value = v;
        }
        public E getValue() { return value; }
        public String toString () { return String.valueOf(this.value); }
        public E getKey() { return (E) key; }


    }

    public class TableStringColumn extends TableColumn<String> {
        public TableStringColumn(String k){
            super(k);
        }
    }

    public class TableIntegerColumn extends TableColumn<Integer> {
        public TableIntegerColumn(String k){
            super(k);
        }
    }
    public class TableTableNameColumn extends TableColumn<ManageDBActivity.TABLE_NAME> {
        public TableTableNameColumn(String k){
            super(k);
        }
    }

    //Takes an Arraylist, and creates a hashmap for it
    public HashMap<String, TableColumn> mapMaker(ArrayList<TableColumn> table){
        HashMap<String, TableColumn> map = new HashMap<String,TableColumn>(table.size());
        for(TableColumn id:table){
            map.put((String) id.getKey(),id);
        }
        return map;
    }


    // Match table
    // 25 fields
    public ArrayList<TableColumn> makeMatchList(){
        ArrayList<TableColumn> matchList = new ArrayList<TableColumn>();
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_ID));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_EVENT_ID));
        matchList.add(new TableStringColumn(MatchContract.MatchEntry.COLUMN_NAME_TBA_MATCH_KEY));
        matchList.add(new TableStringColumn(MatchContract.MatchEntry.COLUMN_NAME_MATCH_COMP_LEVEL));
        matchList.add(new TableStringColumn(MatchContract.MatchEntry.COLUMN_NAME_MATCH_SET_NUMBER));
        matchList.add(new TableStringColumn(MatchContract.MatchEntry.COLUMN_NAME_MATCH_NUMBER));
        matchList.add(new TableStringColumn(MatchContract.MatchEntry.COLUMN_NAME_MATCH_STATUS));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_RED_1));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_RED_2));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_RED_3));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_RED_AUTO_SCORE));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_RED_TELEOP_SCORE));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_RED_TOTAL_SCORE));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_RED_QP));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_RED_FOUL_POINTS));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_BLUE_1));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_BLUE_2));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_BLUE_3));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_BLUE_AUTO_SCORE));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_BLUE_TELEOP_SCORE));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_BLUE_TOTAL_SCORE));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_BLUE_QP));
        matchList.add(new TableIntegerColumn(MatchContract.MatchEntry.COLUMN_NAME_BLUE_FOUL_POINTS));
        matchList.add(new TableStringColumn(MatchContract.MatchEntry.COLUMN_NAME_MATCH_WINNER));
        matchList.add(new TableStringColumn(MatchContract.MatchEntry.COLUMN_NAME_DRIVE_TEAM_COMMENTS));

        return matchList;
    }

    // Event table
    // 9 fields
    public ArrayList<TableColumn> makeEventList(){
        ArrayList<TableColumn> eventList = new ArrayList<TableColumn>();
        eventList.add(new TableIntegerColumn(EventContract.EventEntry.COLUMN_NAME_ID));
        eventList.add(new TableStringColumn(EventContract.EventEntry.COLUMN_NAME_TBA_EVENT_KEY));
        eventList.add(new TableStringColumn(EventContract.EventEntry.COLUMN_NAME_EVENT_NAME));
        eventList.add(new TableStringColumn(EventContract.EventEntry.COLUMN_NAME_EVENT_SHORT_NAME));
        eventList.add(new TableStringColumn(EventContract.EventEntry.COLUMN_NAME_EVENT_TYPE));
        eventList.add(new TableStringColumn(EventContract.EventEntry.COLUMN_NAME_EVENT_DISTRICT));
        eventList.add(new TableIntegerColumn(EventContract.EventEntry.COLUMN_NAME_EVENT_YEAR));
        eventList.add(new TableIntegerColumn(EventContract.EventEntry.COLUMN_NAME_EVENT_WEEK));
        eventList.add(new TableStringColumn(EventContract.EventEntry.COLUMN_NAME_EVENT_LOCATION));
        eventList.add(new TableStringColumn(EventContract.EventEntry.COLUMN_NAME_TBA_EVENT_CODE));

        return eventList;
    }

    // Action table
    // 10 fields
    public ArrayList<TableColumn> makeActionTypeList(){
        ArrayList<TableColumn> actionTypeList = new ArrayList<TableColumn>();
        actionTypeList.add(new TableIntegerColumn(ActionsContract.ActionsEntry.COLUMN_NAME_ID));
        actionTypeList.add(new TableStringColumn(ActionsContract.ActionsEntry.COLUMN_NAME_ACTION_NAME));
        actionTypeList.add(new TableStringColumn(ActionsContract.ActionsEntry.COLUMN_NAME_ACTION_DESCRIPTION));
        actionTypeList.add(new TableStringColumn(ActionsContract.ActionsEntry.COLUMN_NAME_ACTION_MATCH_PHASE));
        actionTypeList.add(new TableIntegerColumn(ActionsContract.ActionsEntry.COLUMN_NAME_ACTION_POINTS));
        actionTypeList.add(new TableIntegerColumn(ActionsContract.ActionsEntry.COLUMN_NAME_ACTION_OPPONENT_POINTS));
        actionTypeList.add(new TableIntegerColumn(ActionsContract.ActionsEntry.COLUMN_NAME_ACTION_QUAL_POINTS));
        actionTypeList.add(new TableIntegerColumn(ActionsContract.ActionsEntry.COLUMN_NAME_ACTION_FOUL_POINTS));
        actionTypeList.add(new TableStringColumn(ActionsContract.ActionsEntry.COLUMN_NAME_ACTION_COOP_FLAG));
        actionTypeList.add(new TableStringColumn(ActionsContract.ActionsEntry.COLUMN_NAME_ACTION_CATEGORY));
        return  actionTypeList;
    }

    // Team-Match table
    // 5 fields
    public HashMap<String, TableColumn> makeTeamMatchMap(){
        HashMap<String, TableColumn> teamMatchMap = new HashMap<String, TableColumn>(5);
        teamMatchMap.put(TeamMatchEntry.COLUMN_NAME_ID, new TableIntegerColumn(TeamMatchEntry.COLUMN_NAME_ID));
        teamMatchMap.put(TeamMatchEntry.COLUMN_NAME_TEAM_ID, new TableIntegerColumn(TeamMatchEntry.COLUMN_NAME_TEAM_ID));
        teamMatchMap.put(TeamMatchEntry.COLUMN_NAME_MATCH_ID, new TableIntegerColumn(TeamMatchEntry.COLUMN_NAME_MATCH_ID));
        teamMatchMap.put(TeamMatchEntry.COLUMN_NAME_ALLIANCE, new TableStringColumn(TeamMatchEntry.COLUMN_NAME_ALLIANCE));
        teamMatchMap.put(TeamMatchEntry.COLUMN_NAME_POSITION, new TableIntegerColumn(TeamMatchEntry.COLUMN_NAME_POSITION));
        return teamMatchMap;
    }

    // Team table
    // 18 fields
    public ArrayList<TableColumn> makeTeamList(){
        ArrayList<TableColumn> teamList = new ArrayList<TableColumn>();
        teamList.add(new TableIntegerColumn(TeamContract.TeamEntry.COLUMN_NAME_ID));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_TBA_TEAM_KEY));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_TEAM_LONG_NAME));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_TEAM_NAME));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_LOGO_FILE_LOCATION));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_TEAM_CITY));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_TEAM_STATE_CODE));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_TEAM_COUNTRY));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_TEAM_MOTTO));
        teamList.add(new TableIntegerColumn(TeamContract.TeamEntry.COLUMN_NAME_TEAM_ROOKIE_YEAR));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_NAME));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_PICTURE_FILE_LOCATION));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE));
        teamList.add(new TableIntegerColumn(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_WHEEL_COUNT));
        teamList.add(new TableIntegerColumn(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_MOTOR_COUNT));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DESCRIPTION));
        teamList.add(new TableStringColumn(TeamContract.TeamEntry.COLUMN_NAME_PIT_SCOUT_COMMENTS));
        return teamList;
    }
}


