package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.Settings;
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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.cert.Certificate;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchActionContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.database.XMLExporter;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;
import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.database.TeamMatch;
import wilsonvillerobotics.com.xeroscoutercollect.adapters.TwoColumnAdapter;
import wilsonvillerobotics.com.xeroscoutercollect.models.TeamMatchActionModel;

public class ScoutingActivity extends TabActivity implements View.OnClickListener {

    protected HashMap<Integer, Integer> matchMap = new HashMap<>();

    protected ArrayList<ActionObject> actionObjectArrayList = new ArrayList<>();

    protected HashMap<Integer, ActionCreationData> actionDataMap = new HashMap<>();

    protected HashMap<String, Integer> restoreHashMap;

    protected ArrayList<Pair<String, String>> finalizeDataList = new ArrayList<>();

    protected ArrayList<String> queryStringList = new ArrayList<>();

    protected TwoColumnAdapter finalizeTabAdapter;

    private boolean didCleanExit = false;

    protected int currentClickedId;

    //protected SQLiteDatabase matchDB = openOrCreateDatabase("matchDB", MODE_PRIVATE, null);

    protected TeamMatch currentMatch = new TeamMatch();

    protected DatabaseHelper dbHelper;

    int tabletId, teamMatchId;

    protected String generateTransaction() {
        return null;


    }


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



        //matchDB.execSQL("CREATE TABLE IF NOT EXISTS team_match");

        dbHelper = DatabaseHelper.getInstance(getApplicationContext());

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String pref_default = "*";

        tabletId = Integer.valueOf(sharedPreferences.getString(getString(R.string.tablet_id_pref), pref_default));
        //teamMatchId = 0;

        updateSavedState(savedInstanceState);



    }

    private void updateSavedState(Bundle savedState){
        if(savedState!=null) {
            for (int i = 2; i < 7; i++) {
                String strId = "entry_action_" + i;
                int resid = getResources().getIdentifier(strId, "id", getPackageName());
                EditText tv = (EditText) findViewById(resid);
                if (tv != null) {
                    tv.setText(savedState.getString(strId, "0"));
                    Log.e("Saving Data", strId + " " + tv.getText().toString());
                }
            }
            CheckBox cb = (CheckBox) findViewById(R.id.chkbx_action_1);
            if (cb != null) {
                cb.setChecked(savedState.getBoolean("chkbx_action_1", false));
            }
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("Scouting Activity", "onResume");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceSate){
        super.onSaveInstanceState(savedInstanceSate);
        TabHost th = getTabHost();
        if(th!=null) {
            for (int i = 2; i < 7; i++) {
                String strId = "entry_action_" + i;
                int resid = getResources().getIdentifier(strId, "id", getPackageName());
                EditText tv = (EditText) th.findViewById(resid);
                if (tv != null) {
                    Log.e("Saving Data", strId + " " + tv.getText().toString());
                    savedInstanceSate.putString(strId, tv.getText().toString());
                }
            }
            CheckBox cb = (CheckBox) th.findViewById(R.id.chkbx_action_1);
            if (cb != null) {
                savedInstanceSate.putBoolean("chkbx_action_1", cb.isChecked());
            }
        }

    }

    private String getTimeStamp(){
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMdd_hhmmss");
        return format.format(curDate);
    }

    public void onStop() {
    super.onStop();
        if (!didCleanExit) {

            String baseFolder;
            String filename = "match_backup_";

            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                baseFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            }
            // revert to using internal storage (not sure if there's an equivalent to the above)
            else {
                baseFolder = this.getFilesDir().getAbsolutePath();
            }

            File file = new File(baseFolder + File.separator + filename);
            file.getParentFile().mkdirs();
            FileOutputStream fos;
            ObjectOutputStream oos;
            try {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);

                for (ActionObject dataObjects : actionObjectArrayList) {
                    fos.write(dataObjects.getActionCount());

                }


                fos.flush();
                fos.close();
            }
            catch (IOException ioe) {
                System.out.println(ioe.getStackTrace());
            }
        }

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
                    //Toast.makeText(this, "No Climb", Toast.LENGTH_SHORT).show();
                    action_13.setChecked(false);
                    action_14.setChecked(false);
                    action_15.setChecked(false);
                }
                break;
            case R.id.radio_action_13:
                if (checked){
                    //Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                    action_no_climb.setChecked(false);
                    action_14.setChecked(false);
                    action_15.setChecked(false);
                }
                break;
            case R.id.radio_action_14:
                if (checked){
                    //Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                    action_no_climb.setChecked(false);
                    action_13.setChecked(false);
                    action_15.setChecked(false);
                }
                break;
            case R.id.radio_action_15:
                if (checked){
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
