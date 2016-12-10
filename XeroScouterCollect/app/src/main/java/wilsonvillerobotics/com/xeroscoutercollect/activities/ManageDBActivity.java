package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

            sharedPreferences.getString("dbUsername")

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection();

            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(queryString);

        }

    }*/

    private final String XML_EXT = ".xml";
    private String TN = "table_name";

    public void importDataFromXML(){
        XMLParser myParser = new XMLParser("",this);
        ArrayList<String> xmlFilePaths = new ArrayList<String>();
        xmlFilePaths.add(getFilesDir() + "/" + EventContract.EventEntry.TABLE_NAME + XML_EXT);
        xmlFilePaths.add(getFilesDir() + "/" + MatchContract.MatchEntry.TABLE_NAME + XML_EXT);
        xmlFilePaths.add(getFilesDir() + "/" + ActionsContract.ActionsEntry.TABLE_NAME + XML_EXT);
        xmlFilePaths.add(getFilesDir() + "/" + TeamMatchContract.TeamMatchEntry.TABLE_NAME + XML_EXT);
        xmlFilePaths.add(getFilesDir() + "/" + TeamContract.TeamEntry.TABLE_NAME + XML_EXT);

        for(String path:xmlFilePaths){
            HashMap<String, XMLParser.TableColumn> map = myParser.parseXML(path);
            boolean hasTN = map.containsKey(TN);
            if(hasTN) {
                TABLE_NAME tName = ((XMLParser.TableTableNameColumn) (map.get(TN))).getValue();
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
