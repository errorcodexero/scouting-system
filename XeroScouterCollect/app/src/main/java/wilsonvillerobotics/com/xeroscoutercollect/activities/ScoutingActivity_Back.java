package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

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

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.adapters.TwoColumnAdapter;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;
import wilsonvillerobotics.com.xeroscoutercollect.models.TeamMatchActionModel;
import wilsonvillerobotics.com.xeroscoutercollect.utils.Stopwatch;

public class ScoutingActivity_Back extends FragmentActivity implements View.OnClickListener {
    protected ArrayList<ActionObject> actionObjectArrayList = new ArrayList<>();
    protected HashMap<Integer, ActionCreationData> actionDataMap = new HashMap<>();

    //Map containing entries and their values for a given TeamMatch scouted
    protected HashMap<String, Integer> entryValueMap = new HashMap<>();
    protected ArrayList<Pair<String, String>> finalizeDataList = new ArrayList<>();
    protected ArrayList<String> queryStringList = new ArrayList<>();
    protected TwoColumnAdapter finalizeTabAdapter;
    private boolean didCleanExit = false;
    private boolean doRemoveOldData = false;
    protected int currentClickedId;
    //protected SQLiteDatabase matchDB = openOrCreateDatabase("matchDB", MODE_PRIVATE, null);
    protected DatabaseHelper dbHelper;
    String tablet_uuid;
    int teamMatchId;
    private String baseFolder;
    private String filename;
    private Boolean doSaveToFile = true;
    private boolean doAskRestore = true;
    private boolean didCompleteMatch = false;
    private boolean isRed;
    private String teamNum;
    private boolean resetClickedOnce = false;

    public final int ACTION_TYPE_OFFSET = 30;

    Stopwatch sw;
    long climbTime;
    boolean climbing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_teleop_scouting);
        Log.i("Scouting Activity", "onCreate");

        sw = new Stopwatch();
        climbing = false;

        setContentView(R.layout.fragment_teleop_scouting);

        teamMatchId = getIntent().getExtras().getInt("team_match_id");
        isRed = getIntent().getExtras().getBoolean("background");
        teamNum = getIntent().getExtras().getString("team_number");

        //RadioButton noClimb = (RadioButton) findViewById(R.id.radio_no_climb);

        if (isRed) {
            LinearLayout baseLayout = (LinearLayout) findViewById(R.id.scouting_root);

            LinearLayout portalColumn = (LinearLayout) findViewById(R.id.portal_column);
            LinearLayout exchangeColumn = (LinearLayout) findViewById(R.id.exchange_column);
            LinearLayout centerColumn = (LinearLayout) findViewById(R.id.center_action_column);

            baseLayout.removeAllViews();

            baseLayout.addView(exchangeColumn);
            baseLayout.addView(centerColumn);
            baseLayout.addView(portalColumn);

        } else {
            LinearLayout scaleSwitchBlock = (LinearLayout) findViewById(R.id.switch_scale_divider);

            LinearLayout allianceSwitchBlock = (LinearLayout) findViewById(R.id.alliance_switch_block);
            LinearLayout scaleBlock = (LinearLayout) findViewById(R.id.scale_block);
            LinearLayout opponentSwitchBlock = (LinearLayout) findViewById(R.id.opponent_switch_block);

            scaleSwitchBlock.removeAllViews();

            scaleSwitchBlock.addView(opponentSwitchBlock);
            scaleSwitchBlock.addView(scaleBlock);
            scaleSwitchBlock.addView(allianceSwitchBlock);
        }

        // b -> a; [] key -> b; b key -> textview
        finalizeTabAdapter = new TwoColumnAdapter(this, finalizeDataList);

        String[] actionArray = getResources().getStringArray(R.array.action_array);

        Resources res = getResources();

        int j = 1;

        for (int i = 34; i < 46; i++) {
            int offset = (i - 1);
            if (i == 37 || i == 38 || i == 39 || i == 40 || i == 42)

                continue;

            int test1 = res.getIdentifier("btn_action_" + j + "_incr", "id", getPackageName());
            int test2 = res.getIdentifier("btn_action_" + j + "_decr", "id", getPackageName());
            int test3 = res.getIdentifier("edittext_action_" + j, "id", getPackageName());
            String strIncId = "btn_action_" + j + "_incr";
            String strDecId = "btn_action_" + j + "_decr";
            String strEditTextId = "edittext_action_" + j;
            actionObjectArrayList.add(new ActionObject(res.getIdentifier(strDecId, "id", getPackageName()),
                    res.getIdentifier(strIncId, "id", getPackageName()),
                    res.getIdentifier(strEditTextId, "id", getPackageName()),
                    res.getIdentifier(strEditTextId, "id", getPackageName()), 0));
            j++;
        }

        for (int i = 34; i < 46; i++) {
            String strIncId = "btn_action_" + (i - 33) + "_incr";
            String strDecId = "btn_action_" + (i - 33) + "_decr";
            String editTextId = "edittext_action_" + (i - 33);

            actionDataMap.put(res.getIdentifier(strIncId, "id", getPackageName()), new ActionCreationData(false, i));
            actionDataMap.put(res.getIdentifier(strDecId, "id", getPackageName()), new ActionCreationData(true, i));
            actionDataMap.put(res.getIdentifier(editTextId, "id", getPackageName()), new ActionCreationData(null, i));
        }
        dbHelper = DatabaseHelper.getInstance(getApplicationContext());
        // Mildly proud I fit this in one line

        //void test[] = {findViewById(elem.getDecrementButtonId()).setOnClickListener(this), findViewById(elem.getDecrementButtonId()).setOnClickListener(this)};

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String pref_default = "*";
        tablet_uuid = sharedPreferences.getString(getString(R.string.uuid_value_pref), pref_default);

        createFileAssociations();

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
    public void onResume() {
        super.onResume();

        for (ActionObject elem : actionObjectArrayList) {
            Button incrementButton = (Button) findViewById(elem.getIncrementButtonId());
            Button decrementButton = (Button) findViewById(elem.getDecrementButtonId());
            incrementButton.setOnClickListener(this);
            decrementButton.setOnClickListener(this);

        }

        Log.e("Scouting Activity", "onStart");

        File f = new File(baseFolder + File.separator + filename);
        if (f.exists() && !f.isDirectory() && doAskRestore) {
            AlertDialog.Builder aBuilder = new AlertDialog.Builder(this);
            aBuilder.setMessage("Previous data for this match has been found." +
                    " Would you like to load it?")
                    .setCancelable(Boolean.FALSE)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //RadioButton noClimbTempDisable = (RadioButton) findViewById(R.id.radio_no_climb);
                            //noClimbTempDisable.setChecked(false);
                            deSerializeEntryValueMap();
                            doRemoveOldData = true;
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AlertDialog.Builder aDeleteBuilder = new AlertDialog.Builder(ScoutingActivity_Back.this);
                            aDeleteBuilder.setMessage("Would you like to like to delete the backup?")
                                    .setCancelable(Boolean.FALSE)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            f.delete();
                                            Toast.makeText(ScoutingActivity_Back.this, "Deleted All of the Things!", Toast.LENGTH_SHORT).show();
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
            Log.d("FileLoader", "No backup file found:" + filename);
        }
    }


    private String getTimeStamp() {
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMdd_hhmmss");
        return format.format(curDate);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (doSaveToFile) {
            if (!didCleanExit) {
                updateEntryValueMap();
                serializeEntryValueMap();
            }
        }
    }

    //Gets all the values of each Entry method(EditText, Radio buttons, and Checkboxes,
    //and puts them into the HashMap EntryValueMap
    public void updateEntryValueMap() {
        for (ActionObject object : actionObjectArrayList) {
            entryValueMap.put(getResources().getResourceEntryName(object.getTextFieldId()), object.getActionCount());
        }
        /*CheckBox action_1 = (CheckBox) findViewById(R.id.chkbx_action_1);
        entryValueMap.put(getResources().getResourceEntryName(R.id.chkbx_action_1), action_1.isChecked() ? 1 : 0);
        RadioButton checkedRadio = (RadioButton) findViewById(currentClickedId);
        entryValueMap.put(getResources().getResourceEntryName(currentClickedId), 1);
        ToggleButton currentToggle = (ToggleButton) findViewById(R.id.btn_action_16);
        entryValueMap.put(getResources().getResourceEntryName(currentToggle.getId()), currentToggle.isChecked() ? 1 : 0);
        currentToggle = (ToggleButton) findViewById(R.id.btn_action_17);
        entryValueMap.put(getResources().getResourceEntryName(currentToggle.getId()), currentToggle.isChecked() ? 1 : 0);
        currentToggle = (ToggleButton) findViewById(R.id.btn_action_18);
        entryValueMap.put(getResources().getResourceEntryName(currentToggle.getId()), currentToggle.isChecked() ? 1 : 0);
        entryValueMap.put("doRestore", doSaveToFile ? 1 : 0);*/


    }

    //Serializes the EntryValueMap, saves to downloads folder
    public void serializeEntryValueMap() {
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
            Log.d("ScoutingActivity_Back", "Serialized entryValueMap at filename: " + filename);
        } catch (IOException ioe) {
            System.out.println(ioe.getStackTrace());
        }
    }

    public void deSerializeEntryValueMap() {
        try {
            FileInputStream fis = new FileInputStream(baseFolder + File.separator + filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            entryValueMap = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            //Updates the Entry Fields with the backup values;
            updateEntryValues();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

    public void updateEntryValues() {
        EditText tempTextView;

        for (ActionObject a : actionObjectArrayList) {
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
        /*ToggleButton currentToggle = (ToggleButton) findViewById(R.id.btn_action_16);
        currentToggle.setChecked((entryValueMap.get("btn_action_16") == 1));

        currentToggle = (ToggleButton) findViewById(R.id.btn_action_17);
        currentToggle.setChecked((entryValueMap.get("btn_action_17") == 1));

        currentToggle = (ToggleButton) findViewById(R.id.btn_action_18);
        currentToggle.setChecked((entryValueMap.get("btn_action_18") == 1));
        CheckBox action_1 = (CheckBox) findViewById(R.id.chkbx_action_1);
        action_1.setChecked(entryValueMap.get("chkbx_action_1") == 1);*/

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        /*RadioButton action_13 = (RadioButton) findViewById(R.id.radio_action_13);
        RadioButton action_14 = (RadioButton) findViewById(R.id.radio_action_14);
        RadioButton action_15 = (RadioButton) findViewById(R.id.radio_action_15);
        RadioButton action_no_climb = (RadioButton) findViewById(R.id.radio_no_climb);*/

        /*switch (view.getId()) {
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
                if (checked) {
                    currentClickedId = R.id.radio_action_13;

                    //Toast.makeText(this, "14", Toast.LENGTH_SHORT).show();
                    action_no_climb.setChecked(false);
                    action_14.setChecked(false);
                    action_15.setChecked(false);
                }
                break;
            case R.id.radio_action_14:
                if (checked) {
                    currentClickedId = R.id.radio_action_13;

                    //Toast.makeText(this, "15", Toast.LENGTH_SHORT).show();
                    action_no_climb.setChecked(false);
                    action_13.setChecked(false);
                    action_15.setChecked(false);
                }
                break;
            case R.id.radio_action_15:
                if (checked) {
                    currentClickedId = R.id.radio_action_15;

                    //Toast.makeText(this, "16", Toast.LENGTH_SHORT).show();
                    action_no_climb.setChecked(false);
                    action_13.setChecked(false);
                    action_14.setChecked(false);
                }
                break;
        }*/
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

    private int getActionArrayIndex(int inputIndex) {
        return (inputIndex - 2);
    }


    @Override
    public void onClick(View view) {
        int index = -1;
        int action_id = 0;
        boolean decrement = false;
        Intent mainScreen = new Intent(this, MatchConfirmationActivity.class);
        String queryString = "";
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        double time;
        boolean climbSuccess = false;

        switch (view.getId()) {
            case R.id.btn_finalize:

                LayoutInflater inflater = getLayoutInflater();
                inflater.inflate(R.layout.fragment_finalize_scouting, null);

                for (ActionObject i : actionObjectArrayList) {
                    finalizeDataList.add(new Pair<>(getString(i.getTextFieldValueId()), String.valueOf(i.getActionCount())));
                }

                //break;
            default:
                ActionCreationData actionData = actionDataMap.get(view.getId());
                action_id = actionData.getAction_id();
                int id = view.getId();
                boolean belowZero = false;
                if (action_id != 0) {

                    //Toast.makeText(ScoutingActivity_Back.this, queryString, Toast.LENGTH_SHORT).show();
                    ActionObject tempObject = actionObjectArrayList.get((action_id - 1) - 33);
                    tempObject.changeValue(actionData.getDecrement());

                    EditText tempTextView = (EditText) findViewById(tempObject.getTextFieldId());
                    if (tempTextView != null) {
                        tempTextView.setText(String.valueOf(tempObject.getActionCount()));
                        try {
                            //db.execSQL(TeamMatchActionModel.addAction(tabletId, teamMatchId, action_id, actionData.getDecrement()));
                            queryStringList.add(TeamMatchActionModel.addAction(tablet_uuid, teamMatchId, action_id, actionData.getDecrement()));
                        } finally {

                        }
                        //Toast.makeText(ScoutingActivity_Back.this, getResources().getResourceEntryName(tempObject.getTextFieldId()), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(ScoutingActivity_Back.this, "View is NULL", Toast.LENGTH_SHORT).show();
                    }
                    for (ActionObject spinBox : actionObjectArrayList) {
                        Button decrementButton = (Button) findViewById(spinBox.getDecrementButtonId());
                        if (id == spinBox.getDecrementButtonId()) {

                            if (spinBox.getActionCount() < 1) {
                                belowZero = true;
                                decrementButton.setEnabled(false);
                            }
                            break;
                        } else if (!decrementButton.isEnabled()) {
                            decrementButton.setEnabled(true);
                        }
                    }
                break;
            }
        }
    }
}
