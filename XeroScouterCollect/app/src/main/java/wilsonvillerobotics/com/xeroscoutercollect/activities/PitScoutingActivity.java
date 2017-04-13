package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;

/**
 * Created by Luke on 11/15/2016.
 */

public class PitScoutingActivity extends Activity implements View.OnClickListener {

    private ListView lvCheckBox;
    private ArrayList<String> arr = new ArrayList<String>();
    private ArrayList<String> dbStringArray = new ArrayList<String>();
    private TeamContract teamContract = new TeamContract();
    private SQLiteDatabase db;
    private int teamId;
    private String teamNum;
    private String baseFolder;
    private String filename;

    private HashMap<String, String> stringVals;
    private HashMap<String, Boolean> boolVals;
    private String boolMapFileName;
    private String stringMapFileName;

    private ArrayList<Integer> ckBoxList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_scouting);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        teamId = b.getInt("teamId");
        teamNum = b.getString("teamNum");

        stringVals = new HashMap<>();
        boolVals = new HashMap<>();

        //added code to do list view with checkboxes
        ckBoxList = new ArrayList<>();
        ckBoxList.add(R.id.chbox_pit_field_1);
        ckBoxList.add(R.id.chbox_pit_field_2);
        ckBoxList.add(R.id.chbox_pit_field_3);
        ckBoxList.add(R.id.chbox_pit_field_4);

        DatabaseHelper dbHelper = DatabaseHelper.getInstance(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        addTeamContractStringToListView();
        createCheckBoxListView(); //Needs addTeamContractStringToListView
        updateTeamNumberLabel();
        createFileAssociations();

        boolMapFileName = "boolMap_backup_" + teamId + ".ser";
        stringMapFileName = "stringMap_backup_" + teamId + ".ser";
    }

    public void createFileAssociations() {
        //Sets up file location data
        filename = "pitBackup" + ".ser";
        //Gets the /mnt/sdcard/Download folder path
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            baseFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        }
        // revert to using internal storage (not sure if there's an equivalent to the above)
        else {
            baseFolder = this.getFilesDir().getAbsolutePath();
        }
    }

    public void updateTeamNumberLabel() {
        TextView tempText = (TextView) findViewById(R.id.lbl_pit_team_number);
        tempText.setText(teamNum);
    }

    public void createCheckBoxListView() {
        //Updates checkbox list
        lvCheckBox = (ListView) findViewById(R.id.lvCheckBox);
        lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); //Allows for multiple selections
        lvCheckBox.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, arr));
    }

    public void addTeamContractStringToListView() {
        arr = teamContract.getPitDataArrayList(this); //Look to TeamContract for the creation function
        dbStringArray = TeamContract.getPitDataDBNames(this); //Look to TeamContract for the creation function
    }


    public void uncheckLanguageBoxes(int fieldNum) {
        CheckBox tempBox = new CheckBox(this);
        for (int i = 0; i < ckBoxList.size(); i++) {
            if (i != fieldNum) {
                tempBox = (CheckBox) findViewById(ckBoxList.get(i));
                tempBox.setChecked(false);
            }
        }

    }

    private int checkedBox;

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        int num = -1; //tempVariable
        switch (view.getId()) {
            case R.id.chbox_pit_field_1:
                if (checked) {
                    num = 0;
                }
                break;
            case R.id.chbox_pit_field_2:
                if (checked) {
                    num = 1;
                }
                break;
            case R.id.chbox_pit_field_3:
                if (checked) {
                    num = 2;
                }
                break;
            case R.id.chbox_pit_field_4:
                if (checked) {
                    num = 3;
                }
                break;
        }
        uncheckLanguageBoxes(num);
        checkedBox = num;
    }

    public String getLanguageString() {
        String str = "";
        CheckBox tempBox;
        if (checkedBox != 3) {
            tempBox = (CheckBox) findViewById(ckBoxList.get(checkedBox));
            return tempBox.getText().toString();
        }
        EditText temp = (EditText) findViewById(R.id.entry_field_language);
        return temp.getText().toString();
    }

    public void updateHashMaps() {
        for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
            boolVals.put(dbStringArray.get(i), lvCheckBox.isItemChecked(i));
        }
        stringVals.put(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE, getLanguageString());
        stringVals.put(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE,
                ((EditText) findViewById(R.id.entry_field_drive_base)).getText().toString());
        stringVals.put(TeamContract.TeamEntry.COLUMN_NAME_MAX_FUEL_CAPACITY,
                ((EditText) findViewById(R.id.entry_field_num_balls)).getText().toString());
        stringVals.put(TeamContract.TeamEntry.COLUMN_NAME_FUEL_CONTAINER_VOLUME,
                ((EditText) findViewById(R.id.entry_field_volume)).getText().toString());
    }

    public void serializeMaps(HashMap<String, Boolean> boolMap, HashMap<String, String> stringMap) {
        //Outputs the file
        Log.d("PitScouting", "Serialize");

        File boolMapFile = new File(baseFolder + File.separator + boolMapFileName);
        boolMapFile.getParentFile().mkdirs();

        File stringMapFile = new File(baseFolder + File.separator + stringMapFileName);
        stringMapFile.getParentFile().mkdirs();

        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(boolMapFile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(boolMap);
            fos.flush();
            oos.flush();

            fos = new FileOutputStream(stringMapFile);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(stringMap);

            oos.close();
            fos.close();
            Log.d("PitScoutingActivity", "Serialized boolMap at filename: " + boolMapFileName);
            Log.d("PitScoutingActivity", "Serialized boolMap at filename: " + stringMapFileName);
        } catch (IOException ioe) {
            System.out.println(ioe.getStackTrace());
        }
    }

    public void deSerializeEntryValueMap() {
        try {
            Log.d("PitScouting", "DeSerialize");
            FileInputStream fis = new FileInputStream(baseFolder + File.separator + boolMapFileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            boolVals = (HashMap) ois.readObject();
            fis.close();
            ois.close();

            fis = new FileInputStream(baseFolder + File.separator + stringMapFileName);
            ois = new ObjectInputStream(fis);
            stringVals = (HashMap) ois.readObject();
            ois.close();
            fis.close();
            //Updates the Entry Fields with the backup values;
            updateValueFields();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }

    private void updateValueFields() {
        Log.d("PitScouting", "updateValueFields");

        for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
            for (String key : boolVals.keySet()) {
                lvCheckBox.setItemChecked(dbStringArray.indexOf(key), boolVals.get(key));
            }
        }
        TextView tempTextView;
        for (String key : stringVals.keySet()) {
            if (key.equals(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE)) {
                CheckBox tempBox;
                String tempString = stringVals.get(key);

                if (tempString.equals(getResources().getString(R.string.ckbox_entry_field_1))) {
                    tempBox = (CheckBox) findViewById(R.id.chbox_pit_field_1);
                    tempBox.setChecked(true);
                } else if (tempString.equals(getResources().getString(R.string.ckbox_entry_field_2))) {
                    tempBox = (CheckBox) findViewById(R.id.chbox_pit_field_2);
                    tempBox.setChecked(true);
                } else if (tempString.equals(getResources().getString(R.string.ckbox_entry_field_3))) {
                    tempBox = (CheckBox) findViewById(R.id.chbox_pit_field_3);
                    tempBox.setChecked(true);
                } else {
                    tempBox = (CheckBox) findViewById(R.id.chbox_pit_field_4);
                    tempBox.setChecked(true);
                    TextView tempView = (TextView) findViewById(R.id.entry_field_language);
                    tempView.setText(stringVals.get(key));
                }
            } else if (key.equals(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE)) {
                tempTextView = (TextView) findViewById(R.id.entry_field_drive_base);
                tempTextView.setText(stringVals.get(key));
            } else if (key.equals(TeamContract.TeamEntry.COLUMN_NAME_MAX_FUEL_CAPACITY)) {
                tempTextView = (TextView) findViewById(R.id.entry_field_num_balls);
                tempTextView.setText(stringVals.get(key));
            } else if (key.equals(TeamContract.TeamEntry.COLUMN_NAME_FUEL_CONTAINER_VOLUME)) {
                tempTextView = (TextView) findViewById(R.id.entry_field_volume);
                tempTextView.setText(stringVals.get(key));
            }
        }


    }

    @Override
    public void onStart() {
        super.onResume();
        Log.d("Scouting Activity", "onResume");

        File fBool = new File(baseFolder + File.separator + boolMapFileName);
        File sBool = new File(baseFolder + File.separator + stringMapFileName);

        if (fBool.exists() && !fBool.isDirectory() && sBool.exists() && !sBool.isDirectory()) {
            AlertDialog.Builder aBuilder = new AlertDialog.Builder(this);
            aBuilder.setMessage("Data has been found for this team." +
                    " Would you like to load it?")
                    .setCancelable(Boolean.FALSE)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            deSerializeEntryValueMap();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            AlertDialog.Builder aDeleteBuilder = new AlertDialog.Builder(PitScoutingActivity.this);
                            aDeleteBuilder.setMessage("Would you like to like to delete the backup?")
                                    .setCancelable(Boolean.FALSE)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            fBool.delete();
                                            sBool.delete();
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
            Log.d("FileLoader", "No backup file found");
        }
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_clear_all) {
            for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
                lvCheckBox.setItemChecked(i, false);
            }
        }

        if (view.getId() == R.id.btn_pit_done) {
            AlertDialog.Builder aBuilder = new AlertDialog.Builder(this);
            aBuilder.setMessage("Are you sure?")
                    .setCancelable(Boolean.FALSE)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            updateHashMaps();
                            try {
                                teamContract.queryUpdateTeamPitData(PitScoutingActivity.this, teamId, boolVals, stringVals);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            Intent beforePitScoutingIntent = new Intent(getApplicationContext(), BeforePitScoutingActivity.class);
                            startActivity(beforePitScoutingIntent);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = aBuilder.create();
            alert.setTitle("Alert");
            alert.show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("PitScouting", "onSaveInstanceState");

        updateHashMaps();
        serializeMaps(boolVals, stringVals);

        outState.putSerializable("boolMap", boolVals);
        outState.putSerializable("stringMap", stringVals);
        //super.onSaveInstanceState();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("PitScouting", "onRestoreInstanceState");

        boolVals = (HashMap<String, Boolean>) savedInstanceState.getSerializable("boolMap");
        stringVals = (HashMap<String, String>) savedInstanceState.getSerializable("stringMap");

        updateValueFields();
    }
}
