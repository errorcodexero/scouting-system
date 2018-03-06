package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.AbstractSequentialList;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.connection.BluetoothConnection;
import wilsonvillerobotics.com.xeroscoutercollect.connection.FTPConnection;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.ActionsContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.database.ManageDB;
import wilsonvillerobotics.com.xeroscoutercollect.database.XMLExporter;
import wilsonvillerobotics.com.xeroscoutercollect.database.XMLParser;


public class ManageDBActivity extends Activity implements View.OnClickListener {

    public enum TABLE_NAME{
        EVENT,
        MATCH,
        TEAM,
        ACTIONTYPE,
        TEAMMATCH,
        UNKNOWN
    }

    public DatabaseHelper db;
    private String tmaFileName;
    private String pitFileName;
    private Context tempCtx;
    private SQLiteDatabase sqlDB;
    private String pref_default = "*";
    private SharedPreferences sharedPreferences;
    private String tabletId;
    private int backupTeamMatchAction = 0;
    private String baseFolder;
    protected boolean isPitScoutingTablet;
    protected File pitFile = null;
    protected File tmaFile = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tempCtx = this;
        setContentView(R.layout.activity_manage_db);
        db = DatabaseHelper.getInstance(getApplicationContext());
        sqlDB = db.getWritableDatabase();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        tabletId = sharedPreferences.getString(getString(R.string.tablet_id_pref), pref_default);
        backupTeamMatchAction = Integer.parseInt(sharedPreferences.getString("tma_index_id", "0"));
        Log.d("OnClickBackupTMA",Integer.toString(backupTeamMatchAction));
        //TODO Add this networking on another thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setBaseFolder();
        isPitScoutingTablet = sharedPreferences.getBoolean("pit_scouting_tablet",false);
    }

    public void setBaseFolder(){
        // check if external storage is available
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            baseFolder = "/data/data/wilsonvillerobotics.com.xeroscoutercollect/xml";
        }
        // revert to using internal storage (not sure if there's an equivalent to the above)
        else {
            baseFolder = this.getFilesDir().getAbsolutePath();
        }
    }

    private final String XML_EXT = ".xml";
    private String TN = "table_file_name";


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_import_to_tablet) {
            new DataTransferTask().execute(null,null,null);
        }
        else if (view.getId() == R.id.btn_clear_db_data) {
            //Toast.makeText(this,"Completed parsing the xml file",Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("Are you sure you wish to delete the ENTIRE database?");
            builder1.setCancelable(false);

            builder1.setPositiveButton(
                    "Yes + TMA",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            clearDatabase(true);
                        }
                    });
            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert1 = builder1.create();
            alert1.show();

        }
        else if (view.getId() == R.id.btn_export) {
            new DataBuilderTask().execute(null,null,null);

            //Prompts user for xport type
            //If bluetooth fails, prompts, and allows to restore backup TMA
            //Must do this or else next time, will not have anything to xport.
            //Same with FTP
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder1.setMessage("Select Method of Export");
            builder1.setCancelable(false);

            builder1.setPositiveButton(
                    "BlueTooth",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            BluetoothConnection btc = new BluetoothConnection(ManageDBActivity.this);
                            btc.initAdapter();
                            if(isPitScoutingTablet && pitFile.exists()){
                                btc.sendBluetoothFile(pitFile);
                            }
                            else {
                                btc.sendBluetoothFile(tmaFile);
                            }

                            builder2.setMessage("Was BlueTooth Successful?");
                            builder2.setCancelable(false);

                            builder2.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            builder2.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    restoreBackupTMAIndex();
                                    dialog.cancel();
                                }
                            });
                            AlertDialog alert2 = builder2.create();
                            alert2.show();
                        }
                    });

            builder1.setNegativeButton(
                    "FTP",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            DataTransferTask transferTask = new DataTransferTask();
                            if(isPitScoutingTablet){
                                transferTask.setIsSend(true);
                                transferTask.setSendFile(pitFile);
                            }
                            else{
                                transferTask.setIsSend(true);
                                transferTask.setSendFile(tmaFile);
                            }
                            transferTask.execute(null,null,null);
                        }
                    });

            AlertDialog alert1 = builder1.create();
            alert1.show();
        }



        else if(view.getId() == R.id.btn_build_db){
            clearDatabase(false);
            //async here
            new DatabaseBuilderTask().execute(null,null,null);


        }
    }

    private void restoreBackupTMAIndex(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.tma_index_pref),Integer.toString(backupTeamMatchAction));
        editor.commit();
    }

//
    //Cleans up tables in the database
    private void clearDatabase(boolean clearTMA) {
        TextView txt = (TextView) findViewById(R.id.lbl_user_status_text);
        ArrayList<String> tableList = new ArrayList<String>();

        //TODO: Compile time optimization?
        tableList.add("event");
        tableList.add("match");
        tableList.add("team_match");
        tableList.add("action_type");
        tableList.add("team");
       // if(clearTMA){
        tableList.add("team_match_action");
        txt.setText("Deleted entire database.");

        //}

        try{
            for(String name : tableList){
                String query = "delete from " + name;
                sqlDB.execSQL(query);
                //txt.setText("Deleted database. Saved TeamMatchAction.");
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

    private class DataBuilderTask extends AsyncTask<Void,String,Boolean>{
        private TextView txt = (TextView) findViewById(R.id.lbl_user_status_text);
        protected void onPreExecute() {
            txt.setText("Preparing to build XML File.");
        }
        protected Boolean doInBackground(Void... params) {
            Boolean bool = buildExportData();
            return bool;
        }

        protected void onProgressUpdate(String... values) {
            txt.setText(values[0]);
        }

        protected void onPostExecute(Boolean aBoolean) {
            txt.setText("Built XML File. Ready to export.");
        }

        protected boolean buildExportData(){
            XMLExporter xmlExporter = new XMLExporter(tempCtx);
            //String temp = xmlExporter.generateAllTeamData(true, true, this);
            String filename = "tma-" + xmlExporter.getLastTeamMatchAction() + "-" + tabletId + "-" + getTimeStamp() + ".xml";
            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + filename;
            Log.d("BeginDataExprtBackupTMA",Integer.toString(backupTeamMatchAction));
            publishProgress("Creating file associations.");
            //File xmlFile = new File(path); // Environment.getExternalStorageDirectory() //tempCtx.getFilesDir()
            ArrayList<String> string = xmlExporter.GenerateNewMatches();
            File file = new File(baseFolder + File.separator + filename);
            file.getParentFile().mkdirs();
            FileOutputStream fos;
            if(isPitScoutingTablet) {
                publishProgress("Begun building Pit XML.");
                String pitOut = xmlExporter.generateAllTeamData(true, true, ManageDBActivity.this);
                pitFileName = "pit" + "-" + tabletId + "-" + getTimeStamp() + ".xml";
                pitFile = new File(baseFolder + File.separator + pitFileName);

                try {
                    fos = new FileOutputStream(pitFile);
                    fos.write(pitOut.getBytes());
                    fos.flush();
                    fos.close();
                    if(pitFile.getTotalSpace() < 0){
                        publishProgress("Successfully built pit export.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else {
                tmaFileName = "tma-" + xmlExporter.getLastTeamMatchAction() + "-" + tabletId + "-" + getTimeStamp() + ".xml";

                tmaFile = new File(baseFolder + File.separator + tmaFileName);
                tmaFile.getParentFile().mkdirs();

                publishProgress("Building XML File. Please wait to export.");

                try {
                    fos = new FileOutputStream(tmaFile);
                    for(String teamMatchAction : string) {
                        fos.write(teamMatchAction.getBytes());
                    }

                    fos.flush();
                    fos.close();
                    if(tmaFile.getTotalSpace() < 0){
                        publishProgress("Successfully built TMA export.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Log.d("DoneDataXPTBackupTMA",Integer.toString(backupTeamMatchAction));
            return true;

        }

    }

    public class DataTransferTask extends AsyncTask<Void,String,Boolean>{
        private TextView txt = (TextView) findViewById(R.id.lbl_user_status_text);
        private boolean _isSend = false;
        private File sendFile;
        private boolean didSucceed;


        public void setIsSend(boolean isSend){
            Log.d("DataTransferTask","Set to Send");
            _isSend = isSend;
        }

        public void setSendFile(File file){
            sendFile = file;
        }

        protected Boolean doInBackground(Void... params) {
            FTPConnection ftp = new FTPConnection(ManageDBActivity.this);
            if(_isSend){
                if (!ftp.sendFTPFile(sendFile, this)) {
                    restoreBackupTMAIndex();
                }
                else {didSucceed = true;}
            }
            else{
                ftp.getFTPFiles(baseFolder,this);
                didSucceed = true;}
            return true;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            txt.setText(values[0]); //Tests text to status text
        }

        public void myPublish(String... values){
            publishProgress(values);
        }


        protected void onPostExecute(Boolean aBoolean) {
            if(!didSucceed){
                restoreBackupTMAIndex();
                txt.setText("Export Failed. Please try again.");
            }
        }
    }

    public class DatabaseBuilderTask extends AsyncTask<Void,String,Boolean>{
        private TextView txt = (TextView) findViewById(R.id.lbl_user_status_text);
        protected Boolean doInBackground(Void... params) {
            importDataFromXML();
            return true;
        }

        protected void onProgressUpdate(String... values) {
            txt.setText(values[0]);
        }

        public void builderPublish(String s){
            publishProgress(s);
        }

        public void importDataFromXML(){
            //String downloadDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            String downloadDirectory = "/data/data/wilsonvillerobotics.com.xeroscoutercollect/xml";

            XMLParser myParser = new XMLParser("",ManageDBActivity.this,DatabaseBuilderTask.this);
            ArrayList<String> xmlFilePaths = new ArrayList<String>();
            xmlFilePaths.add(downloadDirectory + "/" + EventContract.EventEntry.TABLE_NAME + XML_EXT); //getFilesDir()
            xmlFilePaths.add(downloadDirectory + "/" + MatchContract.MatchEntry.TABLE_NAME + XML_EXT);
            xmlFilePaths.add(downloadDirectory + "/" + ActionsContract.ActionsEntry.TABLE_NAME + XML_EXT);
            xmlFilePaths.add(downloadDirectory + "/" + TeamMatchContract.TeamMatchEntry.TABLE_NAME + XML_EXT);
            xmlFilePaths.add(downloadDirectory + "/" + TeamContract.TeamEntry.TABLE_NAME + XML_EXT);

            for(String path:xmlFilePaths){
                ArrayList<HashMap<String, XMLParser.TableColumn>> hashMapArrayList = myParser.parseXML(path);
                publishProgress("Received Hashmap. Begun to build SQL DB.");
                for(HashMap<String, XMLParser.TableColumn> map : hashMapArrayList){
                    boolean hasTN = map.containsKey(TN);
                    if (hasTN) {
                        TABLE_NAME tName = ((XMLParser.TableTableNameColumn) (map.get(TN))).getValue();
                        switch (tName) {
                            case EVENT:
                                EventContract ec = new EventContract();
                                ec.queryInsertEventData(map, ManageDBActivity.this);
                                break;
                            case TEAM:
                                TeamContract tc = new TeamContract();
                                tc.queryInsertTeamData(map, ManageDBActivity.this);
                                break;
                            case TEAMMATCH:
                                TeamMatchContract tmc = new TeamMatchContract();
                                tmc.queryInsertTeamMatchData(map, ManageDBActivity.this);
                                break;
                            case ACTIONTYPE:
                                ActionsContract ac = new ActionsContract();
                                ac.queryInsertActionsData(map, ManageDBActivity.this);
                                break;
                            case MATCH:
                                MatchContract mc = new MatchContract();
                                mc.queryInsertMatchData(map, ManageDBActivity.this);
                                break;
                        }
                    }
                }
            }
            publishProgress("Done building the database.");
        }

    }



}

