package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;
import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.adapters.TwoColumnAdapter;
import wilsonvillerobotics.com.xeroscoutercollect.models.TeamMatchActionModel;

public class ScoutingActivity extends TabActivity implements View.OnClickListener {
    protected ArrayList<ActionObject> actionObjectArrayList = new ArrayList<>();
    protected HashMap<Integer, ActionCreationData> actionDataMap = new HashMap<>();

    //Map containing entries and their values for a given TeamMatch scouted
    protected HashMap<String, Integer> entryValueMap = new HashMap<>();
    protected ArrayList<Pair<String, String>> finalizeDataList = new ArrayList<>();
    protected ArrayList<String> queryStringList = new ArrayList<>();
    protected TwoColumnAdapter finalizeTabAdapter;
    private boolean didCleanExit = false;
    protected int currentClickedId;
    //protected SQLiteDatabase matchDB = openOrCreateDatabase("matchDB", MODE_PRIVATE, null);
    protected DatabaseHelper dbHelper;
    int tabletId, teamMatchId;
    private String baseFolder;
    private String filename;
    private Boolean doSaveToFile = true;
    private boolean doAskRestore = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouting);
        Log.i("Scouting Activity", "onCreate");

        // Initializing the tabbing system

        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec autonomousTab = tabHost.newTabSpec("tab1");
        TabHost.TabSpec teleopTab = tabHost.newTabSpec("tab2");
        TabHost.TabSpec finalizeTab = tabHost.newTabSpec("tab3");

        teamMatchId = getIntent().getExtras().getInt("team_match_id");

        RadioButton noClimb = (RadioButton) findViewById(R.id.radio_no_climb);
        noClimb.setChecked(true);
        currentClickedId = R.id.radio_no_climb;

        autonomousTab.setIndicator("Autonomous Tab").setContent(R.id.Autonomous);
        teleopTab.setIndicator("Teleop Tab").setContent(R.id.Teleop);
        finalizeTab.setIndicator("Finalize Tab").setContent(R.id.Finalize);

        tabHost.addTab(autonomousTab);
        tabHost.addTab(teleopTab);
        tabHost.addTab(finalizeTab);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                // If string is identical
                ListView finalizeDataView = (ListView) findViewById(R.id.finalizeDataView);

                finalizeDataList.clear();

                for ( ActionObject i : actionObjectArrayList) {
                    finalizeDataList.add(new Pair<>(getString(i.getTextFieldValueId()), String.valueOf(i.getActionCount())));
                }
                finalizeDataView.setAdapter(finalizeTabAdapter);

                if (s.compareTo("tab3") == 0) {
                }
            }
        });

        //DatabaseHelper tempDB = new DatabaseHelper(this);

        // Begin mapping text entries to variables

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        // b -> a; [] key -> b; b key -> textview
        finalizeTabAdapter = new TwoColumnAdapter(this, finalizeDataList);

        Resources res = getResources();

        String[] actionArray = res.getStringArray(R.array.action_array);

        //actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_1, R.id.btn_increment_action_1, R.id.entry_action_1, R.string.action_1, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_2, R.id.btn_increment_action_2, R.id.entry_action_2, R.string.action_2, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_3, R.id.btn_increment_action_3, R.id.entry_action_3, R.string.action_3, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_4, R.id.btn_increment_action_4, R.id.entry_action_4, R.string.action_4, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_5, R.id.btn_increment_action_5, R.id.entry_action_5, R.string.action_5, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_6, R.id.btn_increment_action_6, R.id.entry_action_6, R.string.action_6, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_7, R.id.btn_increment_action_7, R.id.entry_action_7, R.string.action_7, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_8, R.id.btn_increment_action_8, R.id.entry_action_8, R.string.action_8, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_9, R.id.btn_increment_action_9, R.id.entry_action_9, R.string.action_9, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_10, R.id.btn_increment_action_10, R.id.entry_action_10, R.string.action_10, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_11, R.id.btn_increment_action_11, R.id.entry_action_11, R.string.action_11, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_12, R.id.btn_increment_action_12, R.id.entry_action_12, R.string.action_12, 0));


        for (int i = 2; i < 13; i++) {
            String strIncId = "btn_increment_action_" + i;
            String strDecId = "btn_decrement_action_" + i;
            String entryId = "entry_action_" + i;

            actionDataMap.put(getResources().getIdentifier(strIncId, "id", getPackageName()), new ActionCreationData(false, i));
            actionDataMap.put(getResources().getIdentifier(strDecId, "id", getPackageName()), new ActionCreationData(true, i));
            actionDataMap.put(getResources().getIdentifier(entryId, "id", getPackageName()), new ActionCreationData(true, i));
        }
        dbHelper = DatabaseHelper.getInstance(getApplicationContext());

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String pref_default = "*";
        tabletId = Integer.valueOf(sharedPreferences.getString(getString(R.string.tablet_id_pref), pref_default));

        createFileAssociations();
    }

    public void createFileAssociations(){
        //Sets up file location data
        filename = "match_backup_entryValueMap_" + teamMatchId + ".ser";
        //Gets the /mnt/sdcard/Download folder path
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            baseFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        }
        // revert to using internal storage (not sure if there's an equivalent to the above)
        else {
            baseFolder = this.getFilesDir().getAbsolutePath();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        doSaveToFile = false; // FFFFFAAAAALLLLLSSSSSEEEEE
        updateEntryValueMap();
        serializeEntryValueMap();

        outState.putSerializable("entryValueMap", entryValueMap);
        //super.onSaveInstanceState();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        doAskRestore = false;
        entryValueMap = (HashMap<String, Integer>) savedInstanceState.getSerializable("entryValueMap");
        updateEntryValues();

    }


    @Override
    public void onResume(){
        super.onResume();
        Log.e("Scouting Activity", "onStart");

        File f = new File(baseFolder + File.separator + filename);
        if(f.exists() && !f.isDirectory() && doAskRestore) {
            AlertDialog.Builder aBuilder = new AlertDialog.Builder(this);
            aBuilder.setMessage("Previous data for this match has been found." +
                    " Would you like to load it?")
                    .setCancelable(Boolean.FALSE)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            RadioButton noClimbTempDisable = (RadioButton) findViewById(R.id.radio_no_climb);
                            noClimbTempDisable.setChecked(false);
                            deSerializeEntryValueMap();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AlertDialog.Builder aDeleteBuilder = new AlertDialog.Builder(ScoutingActivity.this);
                            aDeleteBuilder.setMessage("Would you like to like to delete the backup?")
                                    .setCancelable(Boolean.FALSE)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            f.delete();
                                        }
                                    })
                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.cancel();
                                        }
                                    });
                            AlertDialog alert = aDeleteBuilder.create();
                            alert.setTitle("Delete Backup?");
                            alert.show();
                        }
                    });
            AlertDialog alert = aBuilder.create();
            alert.setTitle("Alert");
            alert.show();
        } else {
            Log.d("FileLoader","No backup file found");
        }
    }


    private String getTimeStamp(){
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMdd_hhmmss");
        return format.format(curDate);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(doSaveToFile) {
            if (!didCleanExit) {
                updateEntryValueMap();
                serializeEntryValueMap();
            }
        }
    }

    //Gets all the values of each Entry method(EditText, Radio buttons, and Checkboxes,
    //and puts them into the HashMap EntryValueMap
    public void updateEntryValueMap(){
        for(ActionObject object : actionObjectArrayList){
            entryValueMap.put(getResources().getResourceEntryName(object.getTextFieldId()), object.getActionCount());
        }
        CheckBox action_1 = (CheckBox) findViewById(R.id.chkbx_action_1);
        entryValueMap.put(getResources().getResourceEntryName(R.id.chkbx_action_1), action_1.isChecked()? 1 : 0);
        RadioButton checkedRadio = (RadioButton) findViewById(currentClickedId);
        entryValueMap.put(getResources().getResourceEntryName(currentClickedId), 1);
        ToggleButton currentToggle = (ToggleButton) findViewById(R.id.btn_action_16);
        entryValueMap.put(getResources().getResourceEntryName(currentToggle.getId()), currentToggle.isChecked()? 1 : 0);
        currentToggle = (ToggleButton) findViewById(R.id.btn_action_17);
        entryValueMap.put(getResources().getResourceEntryName(currentToggle.getId()), currentToggle.isChecked()? 1 : 0);
        currentToggle = (ToggleButton) findViewById(R.id.btn_action_18);
        entryValueMap.put(getResources().getResourceEntryName(currentToggle.getId()), currentToggle.isChecked()? 1 : 0);
        entryValueMap.put("doRestore", doSaveToFile? 1 : 0);


    }

    //Serializes the EntryValueMap, saves to downloads folder
    public void serializeEntryValueMap(){
        //Outputs the file
        File file = new File(baseFolder + File.separator + filename);
        file.getParentFile().mkdirs();
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(entryValueMap);
            oos.close();
            fos.close();
            Log.d("ScoutingActivity","Serialized entryValueMap at filename: " + filename);
        }
        catch (IOException ioe) {
            System.out.println(ioe.getStackTrace());
        }
    }

    public void deSerializeEntryValueMap(){
        try
        {
            FileInputStream fis = new FileInputStream(baseFolder + File.separator + filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            entryValueMap = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            //Updates the Entry Fields with the backup values;
            updateEntryValues();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

    public void updateEntryValues(){
        EditText tempTextView;

        for(ActionObject a : actionObjectArrayList){
            tempTextView = (EditText) findViewById(a.getTextFieldId());
            a.setActionCount(entryValueMap.get(getResources().getResourceEntryName(a.getTextFieldId())));
            if (tempTextView != null) {
                tempTextView.setText(String.valueOf(a.getActionCount()));
            }

        }
        for (String key : entryValueMap.keySet()) {
            if (key.contains("radio")) {
                RadioButton radio = (RadioButton) findViewById(getResources().getIdentifier(key, "id", getPackageName()));
                radio.setChecked(true);
            }
        }
        ToggleButton currentToggle = (ToggleButton) findViewById(R.id.btn_action_16);
        currentToggle.setChecked((entryValueMap.get("btn_action_16") == 1));

        currentToggle = (ToggleButton) findViewById(R.id.btn_action_17);
        currentToggle.setChecked((entryValueMap.get("btn_action_17") == 1));

        currentToggle = (ToggleButton) findViewById(R.id.btn_action_18);
        currentToggle.setChecked((entryValueMap.get("btn_action_18") == 1));
        CheckBox action_1 = (CheckBox) findViewById(R.id.chkbx_action_1);
        action_1.setChecked(entryValueMap.get("chkbx_action_1") == 1);

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        RadioButton action_13 = (RadioButton) findViewById(R.id.radio_action_13);
        RadioButton action_14 = (RadioButton) findViewById(R.id.radio_action_14);
        RadioButton action_15 = (RadioButton) findViewById(R.id.radio_action_15);
        RadioButton action_no_climb = (RadioButton) findViewById(R.id.radio_no_climb);

        switch(view.getId()) {
            case R.id.radio_no_climb:
                if (checked) {
                    currentClickedId = R.id.radio_no_climb;
                    //Toast.makeText(this, "No Climb", Toast.LENGTH_SHORT).show();
                    action_13.setChecked(false);
                    action_14.setChecked(false);
                    action_15.setChecked(false);
                }
                break;
            case R.id.radio_action_13:
                if (checked){
                    currentClickedId = R.id.radio_action_13;

                    //Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                    action_no_climb.setChecked(false);
                    action_14.setChecked(false);
                    action_15.setChecked(false);
                }
                break;
            case R.id.radio_action_14:
                if (checked){
                    currentClickedId = R.id.radio_action_13;

                    //Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                    action_no_climb.setChecked(false);
                    action_13.setChecked(false);
                    action_15.setChecked(false);
                }
                break;
            case R.id.radio_action_15:
                if (checked){
                    currentClickedId = R.id.radio_action_15;

                    //Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                    action_no_climb.setChecked(false);
                    action_13.setChecked(false);
                    action_14.setChecked(false);
                }
                break;
        }
    }

    private class ActionCreationData {
        private Boolean isDecrement;
        public Integer action_id;

        public ActionCreationData(Boolean isDecrement, Integer action_id) {
            this.isDecrement = isDecrement;
            this.action_id = action_id;
        }

        public Boolean getDecrement() {
            return isDecrement;
        }

        public void setDecrement(Boolean decrement) {
            isDecrement = decrement;
        }

        public Integer getAction_id() {
            return action_id;
        }

        public void setAction_id(Integer action_id) {
            this.action_id = action_id;
        }
    }

    private int getActionArrayIndex(int inputIndex) {return (inputIndex - 2);}


    @Override
    public void onClick(View view) {
        int index = -1;
        int action_id = 0;
        boolean decrement = false;
        Intent mainScreen = new Intent(this, MatchConfirmationActivity.class);
        String queryString = "";
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        switch (view.getId()) {
            case R.id.btn_finalize_back:
                // Moves to Teleop
                getTabHost().setCurrentTabByTag("tab2");
                break;

            case R.id.btn_finalize_finish:

                didCleanExit = true;

                CheckBox autoBaseline = (CheckBox) findViewById(R.id.chkbx_action_1);

                RadioButton action_13 = (RadioButton) findViewById(R.id.radio_action_13);
                RadioButton action_14 = (RadioButton) findViewById(R.id.radio_action_14);
                RadioButton action_15 = (RadioButton) findViewById(R.id.radio_action_15);

                ToggleButton defensiveToggle = (ToggleButton) findViewById(R.id.btn_action_16);
                ToggleButton disconnectToggle = (ToggleButton) findViewById(R.id.btn_action_17);
                ToggleButton breakdownToggle = (ToggleButton) findViewById(R.id.btn_action_18);


                if (autoBaseline.isChecked()) {
                    db.execSQL(TeamMatchActionModel.addAction(tabletId, teamMatchId, 1, false));
                }
                if (action_13.isChecked()) {
                    db.execSQL(TeamMatchActionModel.addAction(tabletId, teamMatchId, 13, false));
                } else if (action_14.isChecked()) {
                    db.execSQL(TeamMatchActionModel.addAction(tabletId, teamMatchId, 14, false));
                } else if (action_15.isChecked()) {
                    db.execSQL(TeamMatchActionModel.addAction(tabletId, teamMatchId, 15, false));
                }

                if (defensiveToggle.isChecked()) {
                    db.execSQL(TeamMatchActionModel.addAction(tabletId, teamMatchId, 16, false));
                }
                if (disconnectToggle.isChecked()) {
                    db.execSQL(TeamMatchActionModel.addAction(tabletId, teamMatchId, 17, false));
                }
                if (breakdownToggle.isChecked()) {
                    db.execSQL(TeamMatchActionModel.addAction(tabletId, teamMatchId, 18, false));
                }

                for (String queryStringInstance : queryStringList) {
                    db.execSQL(queryStringInstance);
                }

                startActivity(mainScreen);

                break;
            default:
                ActionCreationData actionData = actionDataMap.get(view.getId());
                action_id = actionData.getAction_id();
                int id = view.getId();
                boolean belowZero = false;
                if (action_id != 0) {

                    if (belowZero == false) {
                        //Toast.makeText(ScoutingActivity.this, queryString, Toast.LENGTH_SHORT).show();
                        ActionObject tempObject = actionObjectArrayList.get(getActionArrayIndex(action_id));
                        tempObject.changeValue(actionData.getDecrement());

                        EditText tempTextView = (EditText) findViewById(tempObject.getTextFieldId());
                        if (tempTextView != null) {
                            tempTextView.setText(String.valueOf(tempObject.getActionCount()));
                            try {
                                //db.execSQL(TeamMatchActionModel.addAction(tabletId, teamMatchId, action_id, actionData.getDecrement()));
                                queryStringList.add(TeamMatchActionModel.addAction(tabletId, teamMatchId, action_id, actionData.getDecrement()));
                            } finally {

                            }
                            //Toast.makeText(ScoutingActivity.this, getResources().getResourceEntryName(tempObject.getTextFieldId()), Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(ScoutingActivity.this, "View is NULL", Toast.LENGTH_SHORT).show();
                        }
                    }
                    for (ActionObject spinBox : actionObjectArrayList) {
                        Button decrementButton = (Button) findViewById(spinBox.getDecrementButtonId());
                        if (id == spinBox.getDecrementButtonId()) {

                            if (spinBox.getActionCount() < 1) {
                                belowZero = true;
                                decrementButton.setEnabled(false);
                            }
                            break;
                        } else if (!decrementButton.isEnabled()){
                            decrementButton.setEnabled(true);
                        }
                    }
                    break;

                }
        }


    }

}
