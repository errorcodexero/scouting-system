package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
    private DatabaseHelper dbHelper;
    private TeamContract teamContract = new TeamContract();
    private String teamName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_scouting);

        //added code to do list view with checkboxes
        btn_check_all = (Button)findViewById(R.id.btn_check_all);

        dbHelper = DatabaseHelper.getInstance(getApplicationContext());

        addTeamContractStringToListView();
        createCheckBoxListView(); //Needs addTeamContractStringToListView
        updateTeamNumberLabel();
    }

    public void updateTeamNumberLabel(){
        teamName = "Team: " + getIntent().getExtras().getString("team_number");
        TextView tempText = (TextView) findViewById(R.id.lbl_pit_team_number);
        tempText.setText(teamName);
    }

    public void createCheckBoxListView(){
        //Updates checkbox list
        lvCheckBox = (ListView)findViewById(R.id.lvCheckBox);
        lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); //Allows for multiple selections
        lvCheckBox.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, arr));
    }

    public void addTeamContractStringToListView(){
        arr = teamContract.getPitDataArrayList(); //Look to TeamContract for the creation function
    }



    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.btn_check_all) {
            for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
                lvCheckBox.setItemChecked(i, true);
            }
        }
        if(view.getId() == R.id.btn_clear_all){
            for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
                lvCheckBox.setItemChecked(i, false);
            }
        }
        if(view.getId() == R.id.btn_checked_boxes){
            String msg = "";
            for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
                if(lvCheckBox.isItemChecked(i)){
                    msg = msg + Integer.toString(i)+ ", ";
                }
            }
            Toast.makeText(PitScoutingActivity.this, "Found: " + msg, Toast.LENGTH_SHORT).show();
        }
    }
}
