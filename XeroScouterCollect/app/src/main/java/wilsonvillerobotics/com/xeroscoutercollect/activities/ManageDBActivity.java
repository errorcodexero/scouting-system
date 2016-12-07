package wilsonvillerobotics.com.xeroscoutercollect.activities;

import java.sql.Connection

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
<<<<<<< HEAD
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
=======
import java.util.ArrayList;
import java.util.HashMap;
>>>>>>> 7007016a61901ba3ac0c1c719ed113328bfdaa4b

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.database.XMLParser;

import static wilsonvillerobotics.com.xeroscoutercollect.contracts.ActionsContract.queryInsertActionsData;
import static wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract.queryInsertMatchData;
import static wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract.queryInsertTeamData;
import static wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchContract.queryInsertTeamMatchData;

public class ManageDBActivity extends Activity implements View.OnClickListener {
    private XMLParser parser;
    private String fileName = "event.xml";
    public enum TABLE_NAME{
        EVENT,
        MATCH,
        TEAM,
        ACTIONTYPE,
        TEAMMATCH,
        UNKNOWN
    };
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_db);
        parser = new XMLParser(getApplicationContext());
        File file = new File(this.getFilesDir(), fileName);
        db = DatabaseHelper.getInstance(getApplicationContext());


        String string ="<DATA>\n" +
                "\n" +
                "\t<ROW>\n" +
                "\t\t<_id>1</_id>\n" +
                "\t\t<tba_event_key>TBA_1</tba_event_key>\n" +
                "\t\t<name>BunnyBots2016</name>\n" +
                "\t\t<short_name>BunnyBots2016</short_name>\n" +
                "\t\t<event_type>Exhibition</event_type>\n" +
                "\t\t<event_district>PNW</event_district>\n" +
                "\t\t<year>2016</year>\n" +
                "\t\t<week>50</week>\n" +
                "\t\t<location>Catlin Gabel</location>\n" +
                "\t\t<tba_event_code>A</tba_event_code>\n" +
                "\t</ROW>\n" +
                "</DATA>";


                /*
                "<?xml version=\"1.0\"?>\n" +
                "<P>\n" +
                "    <Content>\n" +
                "        <id>1016576</id>\n" +
                "        <date>20.08.2012</date>\n" +
                "        <placeOfBirth>KUALA LUMPUR</placeOfBirth>\n" +
                "    </Content>\n" +
                "    <Content>\n" +
                "        <id>1016620</id>\n" +
                "        <date>20.08.2012</date>\n" +
                "        <placeOfBirth>SINGAPORE</placeOfBirth>\n" +
                "    </Content>\n" +
                "    <Content>\n" +
                "        <id>1020907</id>\n" +
                "        <date>20.08.2012</date>\n" +
                "        <placeOfBirth>SINGAPORE</placeOfBirth>\n" +
                "    </Content>\n" +
                "</P>";*/
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(fileName, this.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


<<<<<<< HEAD
    public String queryMySQLDb(String queryString) {

        String results = "";

        try {

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

            sharedPreferences.getString("dbUsername")

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection();

            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(queryString);

        }

    }


=======
    public void importDataFromXML(){
        XMLParser myParser = new XMLParser("",this);
        ArrayList<String> xmlFilePaths = new ArrayList<String>();
        xmlFilePaths.add(getFilesDir() + "/" + "event.xml");
        xmlFilePaths.add(getFilesDir() + "/" + "match.xml");
        xmlFilePaths.add(getFilesDir() + "/" + "action_type.xml");
        xmlFilePaths.add(getFilesDir() + "/" + "team_match.xml");
        xmlFilePaths.add(getFilesDir() + "/" + "team.xml");

        for(String path:xmlFilePaths){
            HashMap<String, XMLParser.TableColumn> map = myParser.parseXML(path);
            //TABLE_NAME tName = ((XMLParser.TableTableNameColumn)(map.get("table_name"))).getValue();
            /*switch(tName){
                case EVENT:
                    EventContract ec = new EventContract();
                    ec.queryInsertEventData(map,this);
                    break;
                case TEAM:
                    queryInsertTeamData(map);
                    break;
                case TEAMMATCH:
                    queryInsertTeamMatchData(map);
                    break;
                case ACTIONTYPE:
                    queryInsertActionsData(map);
                    break;
                case MATCH:
                    queryInsertMatchData(map);
                    break;

            }*/
            EventContract ec = new EventContract();
            ec.queryInsertEventData(map,this);
        }





    }

>>>>>>> 7007016a61901ba3ac0c1c719ed113328bfdaa4b
    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_import)) {
            importDataFromXML();
            //parser.parseXML(getFilesDir() + "/" + fileName);
            Toast.makeText(this,"Completed parsing the xml file",Toast.LENGTH_LONG).show();

        }
    }
}
