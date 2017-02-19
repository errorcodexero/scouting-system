package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.connection.FTPConnection;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.ActionsContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.database.GenerateTestData;
import wilsonvillerobotics.com.xeroscoutercollect.database.XMLExporter;
import wilsonvillerobotics.com.xeroscoutercollect.database.XMLParser;

import org.apache.commons.net.ftp.FTP;


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
    public DatabaseHelper db;
    private String filename;
    private Context tempCtx;
    private Button btn_export;
    private SQLiteDatabase sqlDB;
    private String pref_default = "*";
    private SharedPreferences sharedPreferences;
    private String tabletId;
    private int backupTeamMatchAction = 0;
    private String baseFolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tempCtx = this;
        setContentView(R.layout.activity_manage_db);
        parser = new XMLParser(getApplicationContext());
        db = DatabaseHelper.getInstance(getApplicationContext());
        sqlDB = db.getWritableDatabase();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        tabletId = sharedPreferences.getString(getString(R.string.tablet_id_pref), pref_default);
        //TODO Add this networking on another thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setBaseFolder();
    }

    public void setBaseFolder(){
        // check if external storage is available
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            baseFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        }
        // revert to using internal storage (not sure if there's an equivalent to the above)
        else {
            baseFolder = this.getFilesDir().getAbsolutePath();
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
        if (view.getId() == R.id.btn_import_to_tablet) {
            FTPConnection ftp = new FTPConnection(this);
            ftp.getFTPFiles(baseFolder);
        }
        if (view.getId() == R.id.btn_clear_db_data) {
            //Toast.makeText(this,"Completed parsing the xml file",Toast.LENGTH_SHORT).show();
            clearDatabase();
        }
        else if (view.getId() == R.id.btn_export) {
            XMLExporter xmlExporter = new XMLExporter(tempCtx);
            filename = "tma-" + xmlExporter.getLastTeamMatchAction() + "-" + tabletId + "-" + getTimeStamp() + ".xml";
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + filename;
            File xmlFile = new File(path); // Environment.getExternalStorageDirectory() //tempCtx.getFilesDir()

            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            backupTeamMatchAction = Integer.parseInt(sharedPreferences.getString("tma_index_id", "0"));
            ArrayList<String> string = xmlExporter.GenerateNewMatches();
            String xmlTeamData = xmlExporter.generateAllTeamData(0, true, true, this);
            File file = new File(baseFolder + File.separator + filename);
            file.getParentFile().mkdirs();
            FileOutputStream fos;
            try {
                fos = new FileOutputStream(xmlFile);

                for(String teamMatchAction : string) {
                    fos.write(teamMatchAction.getBytes());
                }

                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            FTPConnection ftp = new FTPConnection(this);
            if(!ftp.sendFTPFile(baseFolder, filename)){
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getString(R.string.tma_index_pref),Integer.toString(backupTeamMatchAction));
                editor.commit();
            }


        }
        else if(view.getId() == R.id.btn_build_db){
            importDataFromXML();
        }
    }


    //Cleans up tables in the database
    private void clearDatabase() {
        ArrayList<String> tableList = new ArrayList<String>();
        tableList.add("event");
        tableList.add("match");
        tableList.add("team_match");
        tableList.add("action_type");
        tableList.add("team");
        try{
            for(String name : tableList){
                String query = "delete from " + name;
                sqlDB.execSQL(query);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        //Updates TeamMatchAction shared preference
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.tma_index_pref),"0");
        editor.commit();


    }

    private String getTimeStamp(){
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMdd_hhmmss");
        return format.format(curDate);
    }

}

