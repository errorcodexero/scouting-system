package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

public class PitScoutingActivity extends Activity implements View.OnClickListener  {

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

    private ArrayList<Integer> ckBoxList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_scouting);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        teamId = b.getInt("teamId");
        teamNum = b.getString("teamNum");

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

    @Override
    public void onClick(View view)
    {
        /*if (view.getId() == R.id.btn_check_all) {
            for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
                lvCheckBox.setItemChecked(i, true);
            }
        }
        if(view.getId() == R.id.btn_clear_all){
            for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
                lvCheckBox.setItemChecked(i, false);
            }
        }*/

        if(view.getId() == R.id.btn_clear_all) {
            HashMap<String, Boolean> boolVals = new HashMap<>();
            if (view.getId() == R.id.btn_clear_all) {
                for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
                    boolVals.put(dbStringArray.get(i), lvCheckBox.isItemChecked(i));
                }
            }
            HashMap<String, String> stringVals = new HashMap<>();
            stringVals.put(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_SOFTWARE_LANGUAGE, getLanguageString());
            stringVals.put(TeamContract.TeamEntry.COLUMN_NAME_ROBOT_DRIVE_TYPE,
                    ((EditText) findViewById(R.id.entry_field_drive_base)).getText().toString());


            try {
                teamContract.queryUpdateTeamPitData(PitScoutingActivity.this, teamId, boolVals, stringVals);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
