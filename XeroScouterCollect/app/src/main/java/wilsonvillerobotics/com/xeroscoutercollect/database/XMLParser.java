package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.activities.ManageDBActivity;
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
            TableTableNameColumn tc = new TableTableNameColumn("table_name");
            if(xmlFilePath.contains("match.xml")){
                map = mapMaker(makeMatchList());
                tc.setValue(ManageDBActivity.TABLE_NAME.MATCH);
                map.put("table_name",tc);
                Log.d("Table Name", "match");
            }else if(xmlFilePath.contains("event.xml")){
                map = mapMaker(makeEventList());
                tc.setValue(ManageDBActivity.TABLE_NAME.EVENT);
                map.put("table_name",tc);
                Log.d("Table Name", "event");
            }else if(xmlFilePath.contains("action.xml")){
                map = mapMaker(makeActionTypeList());
                tc.setValue(ManageDBActivity.TABLE_NAME.ACTIONTYPE);
                map.put("table_name",tc);
                Log.d("Table Name", "action");
            }else if(xmlFilePath.contains("teamMatch.xml")){
                map = makeTeamMatchMap();
                tc.setValue(ManageDBActivity.TABLE_NAME.TEAMMATCH);
                map.put("table_name",tc);
                Log.d("Table Name", "teamMatch");
            }else if(xmlFilePath.contains("team.xml")){
                map = mapMaker(makeTeamList());
                tc.setValue(ManageDBActivity.TABLE_NAME.TEAM);
                map.put("table_name",tc);
                Log.d("Table Name", "team");
            }

            xmlFactoryObject = XmlPullParserFactory.newInstance();
            myParser = xmlFactoryObject.newPullParser();
            myParser.setInput(fileStream, null);



            while (myParser.next() != XmlPullParser.END_TAG) {
                if (myParser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String tagName = myParser.getName();
                if (tagName.equals("ROW")) {
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
        matchList.add(new TableIntegerColumn("_id"));
        matchList.add(new TableIntegerColumn("event_id"));
        matchList.add(new TableStringColumn("tba_match_key"));
        matchList.add(new TableStringColumn("comp_level"));
        matchList.add(new TableStringColumn("set_number"));
        matchList.add(new TableStringColumn("match_number"));
        matchList.add(new TableStringColumn("status"));
        matchList.add(new TableIntegerColumn("red_1_team_id"));
        matchList.add(new TableIntegerColumn("red_2_team_id"));
        matchList.add(new TableIntegerColumn("red_3_team_id"));
        matchList.add(new TableIntegerColumn("red_auto_score"));
        matchList.add(new TableIntegerColumn("red_teleop_score"));
        matchList.add(new TableIntegerColumn("red_total_score"));
        matchList.add(new TableIntegerColumn("red_qp"));
        matchList.add(new TableIntegerColumn("red_foul_points"));
        matchList.add(new TableIntegerColumn("blue_1_team_id"));
        matchList.add(new TableIntegerColumn("blue_2_team_id"));
        matchList.add(new TableIntegerColumn("blue_3_team_id"));
        matchList.add(new TableIntegerColumn("blue_auto_score"));
        matchList.add(new TableIntegerColumn("blue_teleop_score"));
        matchList.add(new TableIntegerColumn("blue_total_score"));
        matchList.add(new TableIntegerColumn("blue_qp"));
        matchList.add(new TableIntegerColumn("blue_foul_points"));
        matchList.add(new TableStringColumn("winner"));
        matchList.add(new TableStringColumn("drive_team_comments"));

        return matchList;
    }

    // Event table
    // 9 fields
    public ArrayList<TableColumn> makeEventList(){
        ArrayList<TableColumn> eventList = new ArrayList<TableColumn>();
        eventList.add(new TableIntegerColumn("_id"));
        eventList.add(new TableStringColumn("name"));
        eventList.add(new TableStringColumn("tba_event_key"));
        eventList.add(new TableStringColumn("short_name"));
        eventList.add(new TableStringColumn("event_type"));
        eventList.add(new TableStringColumn("event_district"));
        eventList.add(new TableIntegerColumn("year"));
        eventList.add(new TableIntegerColumn("week"));
        eventList.add(new TableStringColumn("location"));
        eventList.add(new TableStringColumn("tba_event_code"));

        return eventList;
    }

    // Action table
    // 10 fields
    public ArrayList<TableColumn> makeActionTypeList(){
        ArrayList<TableColumn> actionTypeList = new ArrayList<TableColumn>();
        actionTypeList.add(new TableIntegerColumn("_id"));
        actionTypeList.add(new TableStringColumn("name"));
        actionTypeList.add(new TableStringColumn("description"));
        actionTypeList.add(new TableStringColumn("match_phase"));
        actionTypeList.add(new TableIntegerColumn("points"));
        actionTypeList.add(new TableIntegerColumn("opponent_points"));
        actionTypeList.add(new TableIntegerColumn("qual_points"));
        actionTypeList.add(new TableIntegerColumn("foul_points"));
        actionTypeList.add(new TableStringColumn("coop_flag"));
        actionTypeList.add(new TableStringColumn("category"));
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
        teamList.add(new TableIntegerColumn("_id"));
        teamList.add(new TableStringColumn("tba_team_key"));
        teamList.add(new TableStringColumn("long_name"));
        teamList.add(new TableStringColumn("name"));
        teamList.add(new TableStringColumn("logo_file_location"));
        teamList.add(new TableStringColumn("city"));
        teamList.add(new TableStringColumn("state_code"));
        teamList.add(new TableStringColumn("country"));
        teamList.add(new TableStringColumn("motto"));
        teamList.add(new TableIntegerColumn("rookie_year"));
        teamList.add(new TableStringColumn("robot_name"));
        teamList.add(new TableStringColumn("robot_picture_file_location"));
        teamList.add(new TableStringColumn("robot_drive_type"));
        teamList.add(new TableIntegerColumn("robot_wheel_count"));
        teamList.add(new TableIntegerColumn("robot_drive_motor_count"));
        teamList.add(new TableStringColumn("robot_software_language"));
        teamList.add(new TableStringColumn("robot_description"));
        teamList.add(new TableStringColumn("pit_scout_comments"));
        return teamList;
    }
}


