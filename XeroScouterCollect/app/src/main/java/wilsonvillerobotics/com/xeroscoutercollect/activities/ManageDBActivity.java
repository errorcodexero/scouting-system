package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;

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

    public String queryMySQLDb(String queryString) {

        String results = "";

        try {

            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

            String defaultString = "*";

            String user = sharedPreferences.getString("dbUsername", "root");
            String pass = sharedPreferences.getString("dbPassword", "D3@ThC0D3");
            String ip   = sharedPreferences.getString("dbIp", "127.0.0.1");

            String url = "jdbc://" + ip + ":3306/match";

            //Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(queryString);
            ResultSetMetaData rsmd = rs.getMetaData();

            String ColumnNames = "";

            int i = 1;

            while(rs.next()) {
                ColumnNames += rsmd.getColumnName(i);
                i++;
            }

            //Toast.makeText(this, results, Toast.LENGTH_SHORT).show();

        } catch (SQLException e) {
            Log.d("Debug", "Failed to execute sql");
        }
            finally {
            return "yay";
        }
    }

    private final String XML_EXT = ".xml";
    private String TN = "table_file_name";

    public void importDataFromXML(){
        String downloadDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();

        XMLParser myParser = new XMLParser("",this);
        ArrayList<String> xmlFilePaths = new ArrayList<String>();
        xmlFilePaths.add(downloadDirectory + "/" + EventContract.EventEntry.TABLE_NAME + XML_EXT); //getFilesDir()
        xmlFilePaths.add(downloadDirectory + "/" + MatchContract.MatchEntry.TABLE_NAME + XML_EXT);
        xmlFilePaths.add(downloadDirectory + "/" + ActionsContract.ActionsEntry.TABLE_NAME + XML_EXT);
        xmlFilePaths.add(downloadDirectory + "/" + TeamMatchContract.TeamMatchEntry.TABLE_NAME + XML_EXT);
        xmlFilePaths.add(downloadDirectory + "/" + TeamContract.TeamEntry.TABLE_NAME + XML_EXT);

        for(String path:xmlFilePaths){
            ArrayList<HashMap<String, XMLParser.TableColumn>> hashMapArrayList = myParser.parseXML(path);
            for(HashMap<String, XMLParser.TableColumn> map : hashMapArrayList){
                boolean hasTN = map.containsKey(TN);
                if (hasTN) {
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
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {
            case R.id.btn_import:
                importDataFromXML();
                //parser.parseXML(getFilesDir() + "/" + fileName);
                //Toast.makeText(this,"Completed parsing the xml file",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_create_test_data:
                GenerateTestData g = new GenerateTestData(this);
                g.generateAllData();
                //Toast.makeText(this,"Generated Test Data",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_export:
                Intent dataConnectionIntent = new Intent(this, DataConnectionActivity.class);
                startActivity(dataConnectionIntent);
                break;
        }
    }
}
