package wilsonvillerobotics.com.xeroscoutercollect.database;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

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


    //Create parser
    //Parse data
    //Return statement that has the data in the xml file ready to import into SQLlite db



    public void parseXML(){
        parseMatchXml();

    }
    private String readText(XmlPullParser parser) throws IOException,
            XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }
    public void parseXML(String filePath) {
        xmlFilePath = filePath;
        parseXML();
    }

    public void parseMatchXml(){
        try {
            FileInputStream fileStream = new FileInputStream(xmlFilePath);
            xmlFactoryObject = XmlPullParserFactory.newInstance();
            myParser = xmlFactoryObject.newPullParser();
            myParser.setInput(fileStream, null);

            //int event = myParser.getEventType();
            while (myParser.next() != XmlPullParser.END_TAG) {
                if (myParser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = myParser.getName();
                if (name.equals("Row")) {
                    String id = null, date = null, pob = null;
                    while (myParser.next() != XmlPullParser.END_TAG) {
                        if (myParser.getEventType() != XmlPullParser.START_TAG) {
                            continue;
                        }
                        name = myParser.getName();
                        if (name.equals("id")) {
                            id = readText(myParser);
                        } else if (name.equals("date")) {
                            date = readText(myParser);
                        } else if (name.equals("placeOfBirth")) {
                            pob = readText(myParser);
                        }
                    }
                    //myDbHelper.insertData(id,date,pob);
                    Log.d(TAG, "parseXML: " + id + date + pob);
                }
            }
        }
        catch(Exception e) {e.printStackTrace();}
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


    public ArrayList<TableColumn> makeMatchList(){
        ArrayList<TableColumn> matchList = new ArrayList<TableColumn>();
        matchList.add(new TableIntegerColumn("_id"));
        matchList.add(new TableIntegerColumn("event_id"));
        matchList.add(new TableIntegerColumn("tba_match_key"));
        matchList.add(new TableIntegerColumn("comp_level"));
        matchList.add(new TableIntegerColumn("set_number"));
        matchList.add(new TableIntegerColumn("match_number"));
        matchList.add(new TableIntegerColumn("status"));
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
        matchList.add(new TableIntegerColumn("winner"));
        matchList.add(new TableIntegerColumn("drive_team_comments"));

        return matchList;
    }
    public ArrayList<TableColumn> makeEventList(){
        ArrayList<TableColumn> eventList = new ArrayList<TableColumn>();
        eventList.add(new TableIntegerColumn("_id"));
        eventList.add(new TableIntegerColumn("name"));
        eventList.add(new TableIntegerColumn("tba_match_key"));
        eventList.add(new TableIntegerColumn("short_name"));
        eventList.add(new TableIntegerColumn("event_district"));
        eventList.add(new TableIntegerColumn("year"));
        eventList.add(new TableIntegerColumn("week"));
        eventList.add(new TableIntegerColumn("location"));
        eventList.add(new TableIntegerColumn("tba_event_code"));

        return eventList;
    }
    public ArrayList<TableColumn> makeActionTypeList(){
        ArrayList<TableColumn> actionTypeList = new ArrayList<TableColumn>();
        actionTypeList.add(new TableIntegerColumn("_id"));
        actionTypeList.add(new TableIntegerColumn("name"));
        actionTypeList.add(new TableIntegerColumn("description"));
        actionTypeList.add(new TableIntegerColumn("match_phase"));
        actionTypeList.add(new TableIntegerColumn("points"));
        actionTypeList.add(new TableIntegerColumn("opponent_points"));
        actionTypeList.add(new TableIntegerColumn("qual_points"));
        actionTypeList.add(new TableIntegerColumn("foul_points"));
        actionTypeList.add(new TableIntegerColumn("coop_flag"));
        actionTypeList.add(new TableIntegerColumn("category"));
        return  actionTypeList;
    }
    public ArrayList<TableColumn> makeTeamMatchList(){
        ArrayList<TableColumn> teamMatchList = new ArrayList<TableColumn>();
        teamMatchList.add(new TableIntegerColumn("_id"));
        teamMatchList.add(new TableIntegerColumn("team_id"));
        teamMatchList.add(new TableIntegerColumn("match_id"));
        teamMatchList.add(new TableIntegerColumn("alliance"));
        teamMatchList.add(new TableIntegerColumn("position"));
        return teamMatchList;
    }
    public ArrayList<TableColumn> makeTeamList(){
        ArrayList<TableColumn> teamList = new ArrayList<TableColumn>();
        teamList.add(new TableIntegerColumn("_id"));
        teamList.add(new TableIntegerColumn("tba_team_key"));
        teamList.add(new TableIntegerColumn("long_name"));
        teamList.add(new TableIntegerColumn("name"));
        teamList.add(new TableIntegerColumn("logo_file_location"));
        teamList.add(new TableIntegerColumn("city"));
        teamList.add(new TableIntegerColumn("state_code"));
        teamList.add(new TableIntegerColumn("country"));
        teamList.add(new TableIntegerColumn("motto"));
        teamList.add(new TableIntegerColumn("rookie_year"));
        teamList.add(new TableIntegerColumn("robot_name"));
        teamList.add(new TableIntegerColumn("robot_picture_file_location"));
        teamList.add(new TableIntegerColumn("robot_drive_type"));
        teamList.add(new TableIntegerColumn("robot_wheel_count"));
        teamList.add(new TableIntegerColumn("robot_drive_motor_count"));
        teamList.add(new TableIntegerColumn("robot_software_language"));
        teamList.add(new TableIntegerColumn("robot_description"));
        teamList.add(new TableIntegerColumn("pit_scout_comments"));
        return teamList;
    }

}

/*
//myDbHelper = DatabaseHelper.getInstance(context);
            //myDbHelper.open();
            while (myparser.next() != XmlPullParser.END_TAG) {
                if (myparser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }
                String name = myparser.getName();
                if (name.equals("Content")) {
                    String id = null, date = null, pob = null;
                    while (myparser.next() != XmlPullParser.END_TAG) {
                        if (myparser.getEventType() != XmlPullParser.START_TAG) {
                            continue;
                        }
                        name = myparser.getName();
                        if (name.equals("id")) {
                            id = readText(myparser);
                        } else if (name.equals("date")) {
                            date = readText(myparser);
                        } else if (name.equals("placeOfBirth")) {
                            pob = readText(myparser);
                        }
                    }
                    //myDbHelper.insertData(id,date,pob);
                    Log.d(TAG, "parseXML: " + id + date + pob);
                }
            }
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            /*if (myDbHelper != null) {
                myDbHelper.close();
            }
}
 */
