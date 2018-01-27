package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
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
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;

public class ScoutingActivity extends FragmentActivity {

    public enum ScoutingState{
        NULL,
        AUTO,
        TELEOP,
        CLIMB,
        FINALIZE;

        String value = "NULL";

        public static ScoutingState newScoutingState(String str) {
            String checkedStr = str.toUpperCase();
            switch(checkedStr) {
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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stringState = "TELEOP";

        //state = ScoutingState.newScoutingState(stringState);
        setContentView(R.layout.fragment_scouting);

        state = ScoutingState.TELEOP;
        rootView = findViewById(R.id.scouting_fragment_root);

        teamMatchId = getIntent().getExtras().getInt("team_match_id");
        isRed = getIntent().getExtras().getBoolean("background");
        teamNum = getIntent().getExtras().getString("team_number");

        createFileAssociations();

        changeState(state, new HashMap<String, Integer>());
    }

    // Think of this as an observer pattern + logic. The "notify" is the change state function
    public void changeState(ScoutingState newState, HashMap<String, Integer> entryValues) {
        try {
            scoutingValues = entryValues;
            state = newState;

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
                    scoutingFragment = new AutonomousScoutingFragment();
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
                    scoutingFragment = new FinalizeScoutingFragment();
                    break;
            }
            assert scoutingFragment != null;
            scoutingFragment.setArguments(fragmentArgs);
            getSupportFragmentManager().beginTransaction().add(rootView.getId(), scoutingFragment).commit();
        } catch (NullPointerException e ) {
            Log.e("ScoutingFragment", e.getStackTrace().toString());
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
                    scoutingFragment = new TeleopScoutingFragment();
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
