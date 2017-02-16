package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;

/**
 * Created by Luke on 11/15/2016.
 */

public class PitScoutingActivity extends Activity implements View.OnClickListener {

    private Intent landingActivity;

    private ListView lvCheckBox;
    private Button btn_check_all;
    private ArrayList<String> arr = new ArrayList<String>();
    private ArrayList<String> dbStringArray = new ArrayList<String>();
    private DatabaseHelper dbHelper;
    private TeamContract teamContract = new TeamContract();
    private String teamName;
    private SQLiteDatabase db;
    private int teamId;
    private String teamNum;
    private String baseFolder;
    private String filename;

    private HashMap<String, String> stringVals;
    private HashMap<String, Boolean> boolVals;

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
        btn_check_all = (Button)findViewById(R.id.btn_check_all);
        ckBoxList = new ArrayList<>();
        ckBoxList.add(R.id.chbox_pit_field_1);
        ckBoxList.add(R.id.chbox_pit_field_2);
        ckBoxList.add(R.id.chbox_pit_field_3);
        ckBoxList.add(R.id.chbox_pit_field_4);

        dbHelper = DatabaseHelper.getInstance(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        addTeamContractStringToListView();
        createCheckBoxListView(); //Needs addTeamContractStringToListView
        updateTeamNumberLabel();
        createFileAssociations();


    }
    public void createFileAssociations(){
        //Sets up file location data
        filename = "pitBackup" + ".ser";
        //Gets the /mnt/sdcard/Download folder path
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            baseFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
        }
        // revert to using internal storage (not sure if there's an equivalent to the above)
        else {
            baseFolder = this.getFilesDir().getAbsolutePath();
        }
    }

    public void updateTeamNumberLabel(){
        TextView tempText = (TextView) findViewById(R.id.lbl_pit_team_number);
        tempText.setText(teamNum);
    }

    public void createCheckBoxListView(){
        //Updates checkbox list
        lvCheckBox = (ListView)findViewById(R.id.lvCheckBox);
        lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); //Allows for multiple selections
        lvCheckBox.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, arr));
    }

    public void addTeamContractStringToListView(){
        arr = teamContract.getPitDataArrayList(this); //Look to TeamContract for the creation function
        dbStringArray = teamContract.getPitDataDBNames(this); //Look to TeamContract for the creation function
    }


    public void uncheckLanguageBoxes(int fieldNum){
        CheckBox tempBox = new CheckBox(this);
        for(int i = 0; i < ckBoxList.size(); i++){
            if(i != fieldNum){
                tempBox = (CheckBox)findViewById(ckBoxList.get(i));
                tempBox.setChecked(false);
            }
        }

    }

    private int checkedBox;
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        int num = -1; //tempVariable
        switch(view.getId()) {
            case R.id.chbox_pit_field_1:
                if (checked){
                    num = 0;
                }
                break;
            case R.id.chbox_pit_field_2:
                if (checked){
                    num = 1;
                }
                break;
            case R.id.chbox_pit_field_3:
                if (checked){
                    num = 2;
                }
                break;
            case R.id.chbox_pit_field_4:
                if (checked){
                    num = 3;
                }
                break;
        }
        uncheckLanguageBoxes(num);
        checkedBox = num;
    }
    public String getLanguageString(){
        String str = "";
        CheckBox tempBox;
        if(checkedBox != 3){
            tempBox = (CheckBox) findViewById(ckBoxList.get(checkedBox));
            return tempBox.getText().toString();
        }
        EditText temp = (EditText) findViewById(R.id.entry_field_language);
        return temp.getText().toString();
    }

    public void updateHashMaps(){
        for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
            boolVals.put(dbStringArray.get(i), lvCheckBox.isItemChecked(i));
        }
        stringVals.put(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE, getLanguageString());
        stringVals.put(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE,
                ((EditText) findViewById(R.id.entry_field_num_balls)).getText().toString());
        stringVals.put(TeamContract.TeamEntry.COLUMN_NAME_MAX_FUEL_CAPACITY,
                ((EditText) findViewById(R.id.entry_field_drive_base)).getText().toString());
        stringVals.put(TeamContract.TeamEntry.COLUMN_NAME_FUEL_CONTAINER_VOLUME,
                ((EditText) findViewById(R.id.entry_field_drive_base)).getText().toString());
    }
    public void serializeMap(HashMap<String, Boolean> boolMap, HashMap<String,String> stringMap){
        //Outputs the file
        File file = new File(baseFolder + File.separator + filename);
        file.getParentFile().mkdirs();
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(boolMap);
            oos.close();
            fos.close();
            Log.d("ScoutingActivity","Serialized entryValueMap at filename: " + filename);
        }
        catch (IOException ioe) {
            System.out.println(ioe.getStackTrace());
        }
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.btn_clear_all){
            for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
                lvCheckBox.setItemChecked(i, false);
            }
        }

        if(view.getId() == R.id.btn_pit_done) {
            AlertDialog.Builder aBuilder = new AlertDialog.Builder(this);
            aBuilder.setMessage("re you sure?")
                    .setCancelable(Boolean.FALSE)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            updateHashMaps();
                            try {
                                teamContract.queryUpdateTeamPitData(PitScoutingActivity.this, teamId, boolVals, stringVals);
                            }catch (Exception e){
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
}
