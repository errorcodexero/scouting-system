package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.BuildConfig;
import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;

public class ScoutingActivity extends FragmentActivity {

    public ScoutingActivity() {
        entryValues = new HashMap<>();
    }

    public enum ScoutingState {
        NULL,
        AUTO,
        TELEOP,
        CLIMB,
        FINALIZE;

        String value = "NULL";

        public static ScoutingState newScoutingState(String str) {
            String checkedStr = str.toUpperCase();
            switch (checkedStr) {
                case "NULL":
                    return NULL;
                case "AUTO":
                    return AUTO;
                case "TELEOP":
                    return TELEOP;
                case "CLIMB":
                    return CLIMB;
                case "FINALIZE":
                    return FINALIZE;
                default:
                    return NULL;
            }
        }

        public String toString() {
            switch (this) {
                case NULL:
                    return "NULL";
                case AUTO:
                    return "AUTO";
                case TELEOP:
                    return "TELEOP";
                case CLIMB:
                    return "CLIMB";
                case FINALIZE:
                    return "FINALIZE";

            }
            // Defaults to null
            return "NULL";
        }

    }


    private String stringState = "";

    ScoutingState state = ScoutingState.NULL;

    private View rootView;

    HashMap<String, Integer> scoutingValues;
    ArrayList<ActionObject> actionObjects;

    private String baseFolder;
    private String filename;

    int teamMatchId;
    private boolean isRed;
    private String teamNum;

    public HashMap<String, Integer> entryValues;

    public HashMap<String, Integer> getEntryValues() {
        return entryValues;
    }

    public void updateEntryValues(HashMap<String, Integer> entryValues) {
        this.entryValues = entryValues;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getBaseFolder() {
        return baseFolder;
    }

    public void setBaseFolder(String baseFolder) {
        this.baseFolder = baseFolder;
    }

    DatabaseHelper dbHelper;

    SQLiteDatabase db;


    public boolean getIsStateChanging() {
        return isStateChanging;
    }

    public void setIsStateChanging(boolean isStateChanging) {
        this.isStateChanging = isStateChanging;
    }

    private boolean isStateChanging;


    static HashMap<String, Integer> actionMap = new HashMap<>();

    static {
        actionMap.put("btn_action_1_incr", 44);
        actionMap.put("btn_action_1_decr", 44);
        actionMap.put("btn_action_2_incr", 46);
        actionMap.put("btn_action_2_decr", 46);
        actionMap.put("btn_action_3_incr", 34);
        actionMap.put("btn_action_3_decr", 34);
        actionMap.put("btn_action_4_incr", 35);
        actionMap.put("btn_action_4_decr", 35);
        actionMap.put("btn_action_5_incr", 43);
        actionMap.put("btn_action_5_decr", 43);
        actionMap.put("btn_action_6_incr", 36);
        actionMap.put("btn_action_6_decr", 36);
        actionMap.put("btn_action_7_incr", 47);
        actionMap.put("btn_action_7_decr", 47);
        actionMap.put("auto_action_1_chkbx", 30);
        actionMap.put("auto_action_2_chkbx", 31);
        actionMap.put("auto_action_3_chkbx", 32);
        actionMap.put("auto_action_4_chkbx", 33);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stringState = "TELEOP";
        dbHelper = DatabaseHelper.getInstance(getApplicationContext());

        db = dbHelper.getWritableDatabase();

        //state = ScoutingState.newScoutingState(stringState);
        setContentView(R.layout.fragment_scouting);

        state = ScoutingState.TELEOP;
        rootView = findViewById(R.id.scouting_fragment_root);

        teamMatchId = getIntent().getExtras().getInt("team_match_id");
        isRed = getIntent().getExtras().getBoolean("background");
        teamNum = getIntent().getExtras().getString("team_number");

        createFileAssociations();

        try {
            entryValues = (HashMap<String, Integer>) savedInstanceState.getSerializable("ENTRYVALUES");
        } catch (Exception e ) {
             //TL;DR Don't care
        }

        changeState(state, entryValues);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("ENTRYVALUES", entryValues);
    }

    // Think of this as an observer pattern + logic. The "notify" is the change state function
    public void changeState(ScoutingState newState, HashMap<String, Integer> newEntryValues) {
        try {
            scoutingValues = entryValues;
            setIsStateChanging(true);
            state = newState;

            entryValues = newEntryValues;

            Bundle fragmentArgs = new Bundle();
            fragmentArgs.putSerializable("entryValues", scoutingValues);
            fragmentArgs.putSerializable("actionObjects", actionObjects);
            Fragment scoutingFragment = null;
            assert state == ScoutingState.NULL;
            switch (state) {
                case NULL:
                    Log.e("ScoutingFragment", "[!] ERROR: state is \'null\'.\n");
                    break;
                case AUTO:
                    scoutingFragment = AutonomousScoutingFragment.newInstance(entryValues);
                    break;
                case TELEOP:
                    scoutingFragment = TeleopScoutingFragment.newInstance(entryValues);
                    break;
                case CLIMB:
                    // NYI
                    Log.d("ScoutingFragment", "[*] Warning: case \'CLIMB\' is not yet implemented.\n");
                    scoutingFragment = new TeleopScoutingFragment();
                    break;
                case FINALIZE:
                    scoutingFragment = FinalizeScoutingFragment.newInstance(entryValues);
                    break;
            }
            assert scoutingFragment != null;
            scoutingFragment.setArguments(fragmentArgs);
            getSupportFragmentManager().beginTransaction().replace(rootView.getId(), scoutingFragment).commit();
        } catch (NullPointerException e ) {
            Log.e("ScoutingFragment", String.valueOf(e.getStackTrace()));
        }
    }
    // Think of this as an observer pattern + logic. The "notify" is the change state function
    public void changeState(String newStateStr, HashMap<String, Integer> entryValues) {
        try {
            scoutingValues = entryValues;
            Bundle fragmentArgs = new Bundle();
            fragmentArgs.putSerializable("entryValues", scoutingValues);
            state = ScoutingState.newScoutingState(newStateStr);
            Fragment scoutingFragment = null;
            assert state == ScoutingState.NULL;
            switch(state) {
                case NULL:
                    Log.e("ScoutingFragment", "[!] ERROR: state is \'null\'.\n");
                    break;
                case AUTO:
                    // NYI
                    Log.d("ScoutingFragment", "[*] Warning: case \'AUTO\' is not yet implemented.\n");
                    scoutingFragment = new AutonomousScoutingFragment();
                    break;
                case TELEOP:
                    scoutingFragment = new TeleopScoutingFragment();
                    return;
                case CLIMB:
                    // NYI
                    Log.d("ScoutingFragment", "[*] Warning: case \'CLIMB\' is not yet implemented.\n");
                    scoutingFragment = new TeleopScoutingFragment();
                    break;
                case FINALIZE:
                    // NYI
                    Log.d("ScoutingFragment", "[*] Warning: case \'FINALIZE\' is not yet implemented.\n");
                    scoutingFragment = new TeleopScoutingFragment();
                    break;
            }
            scoutingFragment.setArguments(fragmentArgs);
            getSupportFragmentManager().beginTransaction().add(rootView.getId(), scoutingFragment).commit();
        } catch (NullPointerException e) {
            Log.e("ScoutingFragment", e.getStackTrace().toString());
        }
    }

    public void createFileAssociations() {
        //Sets up file location data
        filename = "match_backup_entryValueMap_" + teamMatchId + ".ser";
        //Gets the /mnt/sdcard/Download folder path
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            baseFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        }
        // revert to using internal storage (not sure if there's an equivalent to the above)
        else {
            baseFolder = this.getFilesDir().getAbsolutePath();
        }
    }

}
