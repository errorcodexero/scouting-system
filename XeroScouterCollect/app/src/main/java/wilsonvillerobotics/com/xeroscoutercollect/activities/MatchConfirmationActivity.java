package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.utils.TestMatch;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;

/**
 * Created by Luke on 11/5/2016.
 */
public class MatchConfirmationActivity extends Activity implements View.OnClickListener{
    private Spinner spinner_match_list;
    private Button btn_next;
    private Intent sanityCheckActivity;
    private List<String> match_list;
    private ArrayList<String> team_list;
    private int currentSelectedMatch;


    private ArrayList<TestMatch> matchObjList;
    private TestMatch match1;
    private TestMatch match2;
    private TestMatch match3;
    private ArrayList<Integer> lbl_list;
    private TextView lbl_team_1;
    private TextView lbl_team_2;
    private TextView lbl_team_3;
    private TextView lbl_team_4;
    private TextView lbl_team_5;
    private TextView lbl_team_6;
    
    

    private DatabaseHelper dbHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_confirmation);

        matchObjList = new ArrayList<TestMatch>();
        lbl_list = new ArrayList<Integer>();


        generateTestMatches();
        populateLblList();
        addItemsOnSpinner();
        addListenerOnButton();
        //addItemsToTeamList();

        dbHelper = DatabaseHelper.getInstance(getApplicationContext());

        addItemsOnSpinner();
        addListenerOnButton();
        //addItemsToTeamList();



        sanityCheckActivity = new Intent(this, SanityCheckActivity.class);
        
        
        
    }
    private void populateLblList(){
        lbl_list.add(R.id.lbl_team_1);
        lbl_list.add(R.id.lbl_team_2);
        lbl_list.add(R.id.lbl_team_3);
        lbl_list.add(R.id.lbl_team_4);
        lbl_list.add(R.id.lbl_team_5);
        lbl_list.add(R.id.lbl_team_6);

    }

    private void generateTestMatches() {
        match1 = new TestMatch("1","1","7","13","19","25","31");
        match2 = new TestMatch("2","2","8","14","20","26","32");
        match3 = new TestMatch("3","3","9","15","21","27","33");
        matchObjList.add(match1);
        matchObjList.add(match2);
        matchObjList.add(match3);
    }

    /*private void addItemsToTeamList() {
        team_list = new ArrayList<String>();
        match_list.add(match1.getTeam1());
        match_list.add(match1.getTeam2());
        match_list.add(match1.getTeam3());
        match_list.add(match1.getTeam4());
        match_list.add(match1.getTeam5());
        match_list.add(match1.getTeam6());
        match_list.add(match2.getTeam1());
        match_list.add(match2.getTeam2());
        match_list.add(match2.getTeam3());
        match_list.add(match2.getTeam4());
        match_list.add(match2.getTeam5());
        match_list.add(match2.getTeam6());
        match_list.add(match3.getTeam1());
        match_list.add(match3.getTeam2());
        match_list.add(match3.getTeam3());
        match_list.add(match3.getTeam4());
        match_list.add(match3.getTeam5());
        match_list.add(match3.getTeam6());

    }*/

    //add matches to spinner
    public void addItemsOnSpinner() {

        spinner_match_list = (Spinner) findViewById(R.id.spinner_match_list);
        match_list = new ArrayList<String>();

        match_list.add(match1.getMatchNumber());
        match_list.add(match2.getMatchNumber());
        match_list.add(match3.getMatchNumber());



        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, match_list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_match_list.setAdapter(dataAdapter);
    }


    // get the selected dropdown list value
    public void addListenerOnButton() {
        spinner_match_list = (Spinner) findViewById(R.id.spinner_match_list);
        btn_next = (Button) findViewById(R.id.btn_next);
    }

    private final int numTeams = 6;
    //Updates the team field according to the selected match
    private void updateTeams() {
        String tempText = spinner_match_list.getSelectedItem().toString();
        Toast.makeText(this,tempText,Toast.LENGTH_SHORT).show();
        currentSelectedMatch = Integer.valueOf(tempText) - 1;
        for(int i = 0; i < numTeams; i++){
            String temp = matchObjList.get(currentSelectedMatch).getTeamNumber(i);
            TextView tempView = (TextView) findViewById(lbl_list.get(i));
            tempView.setText(temp);

        }

    }


    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_next)) {
            startActivity(sanityCheckActivity);
        }
        if(view == findViewById(R.id.btn_get_teams)){
            updateTeams();
        }
    }


}