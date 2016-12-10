package wilsonvillerobotics.com.xeroscoutercollect.activities;

import java.sql.Connection;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
<<<<<<< Updated upstream

import java.util.ArrayList;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.ActionsContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.database.GenerateTestData;
import wilsonvillerobotics.com.xeroscoutercollect.database.TableColumn;
import wilsonvillerobotics.com.xeroscoutercollect.database.TableTableNameColumn;
import wilsonvillerobotics.com.xeroscoutercollect.database.XMLParser;


public class ManageDBActivity extends Activity implements View.OnClickListener {
    private XMLParser parser;
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
        db = DatabaseHelper.getInstance(getApplicationContext());

    }

/*
    public String queryMySQLDb(String queryString) {

        String results = "";

        try {

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

            sharedPreferences.getString("dbUsername");

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection();

            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(queryString);

        } finally {

        }

    }*/



    public void importDataFromXML(){
        XMLParser myParser = new XMLParser("",this);
        ArrayList<String> xmlFilePaths = new ArrayList<String>();
        xmlFilePaths.add(getFilesDir() + "/" + "event.xml");
        xmlFilePaths.add(getFilesDir() + "/" + "match.xml");
        xmlFilePaths.add(getFilesDir() + "/" + "action_type.xml");
        xmlFilePaths.add(getFilesDir() + "/" + "team_match.xml");
        xmlFilePaths.add(getFilesDir() + "/" + "team.xml");

        for(String path:xmlFilePaths){
            HashMap<String, TableColumn> map = myParser.parseXML(path);
            boolean hasTN = map.containsKey("table_name");
            if(hasTN) {
                TABLE_NAME tName = ((TableTableNameColumn) (map.get("table_name"))).getValue();
                switch (tName) {
                    case EVENT:
                        EventContract ec = new EventContract();
                        ec.queryInsertEventData(map, this);
                        break;
                    case TEAM:
                        TeamContract tc = new TeamContract();
                        tc.queryInsertTeamData(map, this);
                        break;
                    case TEAMMATCH:
                        TeamMatchContract tmc = new TeamMatchContract();
                        tmc.queryInsertTeamMatchData(map, this);
                        break;
                    case ACTIONTYPE:
                        ActionsContract ac = new ActionsContract();
                        ac.queryInsertActionsData(map, this);
                        break;
                    case MATCH:
                        MatchContract mc = new MatchContract();
                        mc.queryInsertMatchData(map, this);
                        break;

                }
            }



        }
    }

    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_import)) {
            importDataFromXML();
            //parser.parseXML(getFilesDir() + "/" + fileName);
            Toast.makeText(this,"Completed parsing the xml file",Toast.LENGTH_SHORT).show();
        }
        if (view == findViewById(R.id.btn_create_test_data)) {
            GenerateTestData g = new GenerateTestData(this);
            g.generateAllData();
            Toast.makeText(this,"Generated Test Data",Toast.LENGTH_SHORT).show();
        }
    }
}
