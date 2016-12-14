package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.models.MatchModel;
import wilsonvillerobotics.com.xeroscoutercollect.models.TeamMatchModel;

/**
 * Created by Luke on 11/5/2016.
 */
public class MatchConfirmationActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private final int numTeams = 6;
    private Spinner spinner_match_list;
    private Button btn_next;
    private Intent sanityCheckActivity;
    private List<String> match_list;
    private ArrayList<String> team_list;
    public int currentSelectedMatch;
    public ArrayList<TeamMatchModel> matchObjList;
    private TeamMatchModel match1;
    private TeamMatchModel match2;
    private TeamMatchModel match3;
    private ArrayList<Integer> lbl_list;
    private TextView lbl_team_1;
    private TextView lbl_team_2;
    private TextView lbl_team_3;
    private TextView lbl_team_4;
    private TextView lbl_team_5;
    private TextView lbl_team_6;

    public ArrayAdapter<String> dataAdapter;

    private String tabID;
    private String eventName;
    private String tabletID;


    
    

    private DatabaseHelper dbHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_confirmation);

        matchObjList = new ArrayList<TeamMatchModel>();
        lbl_list = new ArrayList<Integer>();

        dbHelper = DatabaseHelper.getInstance(getApplicationContext());
        sanityCheckActivity = new Intent(this, SanityCheckActivity.class);

        spinner_match_list = (Spinner) findViewById(R.id.spinner_match_list);


        spinner_match_list.setOnItemSelectedListener(this);



        populateLblList();
        resetLblColors(lbl_list);
        updateLabels();
        populateMatchTable();
        highlightTabletIdTeam();
        addItemsOnSpinner();
        addListenerOnButton();
    }



    //Highlights the team to scout.
    private void highlightTabletIdTeam() {
        Boolean isRed = null;
        String tempp = null;
        switch (tabID){
            case "1":
                FormatTabletTeamCell(R.id.lbl_team_1);
                isRed = true;
                tempp = matchObjList.get(currentSelectedMatch).getTeamNumber(0);
                break;
            case "2":
                FormatTabletTeamCell(R.id.lbl_team_2);
                isRed = true;
                tempp = matchObjList.get(currentSelectedMatch).getTeamNumber(1);
             break;
            case "3":
                FormatTabletTeamCell(R.id.lbl_team_3);
                isRed = true;
                tempp = matchObjList.get(currentSelectedMatch).getTeamNumber(2);
                break;
            case "4":
                FormatTabletTeamCell(R.id.lbl_team_4);
                isRed = false;
                tempp = matchObjList.get(currentSelectedMatch).getTeamNumber(3);
                break;
            case "5":
                FormatTabletTeamCell(R.id.lbl_team_5);
                isRed = false;
                tempp = matchObjList.get(currentSelectedMatch).getTeamNumber(4);
                break;
            case "6":
                FormatTabletTeamCell(R.id.lbl_team_6);
                isRed = false;
                tempp = matchObjList.get(currentSelectedMatch).getTeamNumber(5);
                break;
        }
        sanityCheckActivity.putExtra("background",isRed);
        sanityCheckActivity.putExtra("team_number",tempp);
    }
    //Sets the color of the cell.
    private void FormatTabletTeamCell(int txtTeamID) {
        TextView tempView;
        tempView = (TextView) findViewById(txtTeamID);
        tempView.setBackgroundColor(Color.YELLOW);
        tempView.setTextColor(Color.BLACK);
    }
    public void resetLblColors(ArrayList<Integer> list){
        TextView tempView;
        for(int i = 0; i < list.size()/2; i++){
            tempView = (TextView) findViewById(list.get(i));
            tempView.setBackgroundColor(Color.RED);
        }
        for(int i = (list.size()/2); i < list.size(); i++){
            tempView = (TextView) findViewById(list.get(i));
            tempView.setBackgroundColor(Color.BLUE);
        }
    }

    //Adds textView label objects to array
    private void populateLblList(){
        lbl_list.add(R.id.lbl_team_1);
        lbl_list.add(R.id.lbl_team_2);
        lbl_list.add(R.id.lbl_team_3);
        lbl_list.add(R.id.lbl_team_4);
        lbl_list.add(R.id.lbl_team_5);
        lbl_list.add(R.id.lbl_team_6);

    }

    private void updateLabels()
    {
        String pref_default = getString(R.string.default_pref_value);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        tabletID = sharedPreferences.getString(getString(R.string.tablet_id_pref), pref_default);

        TextView lblTabletID = (TextView)findViewById(R.id.lbl_tablet_id);


        if(lblTabletID != null) {
            lblTabletID.setText(getString(R.string.lbl_tablet_id) + " " + tabletID);
        }
        tabID = tabletID;

    }

    private void populateMatchTable() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        int event_id = getIntent().getIntExtra("eventId", 1);
        String query = MatchModel.getAllMatches(event_id);
        Cursor cursor = db.rawQuery(query, null);
        int numMatches = cursor.getCount();
        //Cursor cursor = db.rawQuery(MatchModel.getAllMatchs("1"), null);

        try {
            while(cursor.moveToNext()) {
                matchObjList.add(new TeamMatchModel(
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_MATCH_NUMBER))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_1))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_2))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_3))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_1))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_2))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_3))))
                );
            }
        } finally {
            cursor.close();
        }


    }

    private void generateTestMatches() {
        match1 = new TeamMatchModel("1","1","7","13","19","25","31");
        match2 = new TeamMatchModel("2","2","8","14","20","26","32");
        match3 = new TeamMatchModel("3","3","9","15","21","27","33");
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

    //Add matches to spinner
    public void addItemsOnSpinner() {
        match_list = new ArrayList<String>();

        /*match_list.add(match1.getMatchNumber());
        match_list.add(match2.getMatchNumber());
        match_list.add(match3.getMatchNumber());*/

        for (TeamMatchModel tempMatch : matchObjList) {
            match_list.add(String.valueOf(Integer.valueOf(tempMatch.getMatchNumber())));
        }
        dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, match_list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_match_list.setAdapter(dataAdapter);
    }


    // get the selected dropdown list value
    public void addListenerOnButton() {
        spinner_match_list = (Spinner) findViewById(R.id.spinner_match_list);
        btn_next = (Button) findViewById(R.id.btn_next);
        updateTeams();
    }


    //Updates the team field according to the selected match
    private void updateTeams() {
        int currentSelectedMatch = spinner_match_list.getSelectedItemPosition(); //.getSelectedItem().toString();
        //Toast.makeText(this,"Position: " + currentSelectedMatch,Toast.LENGTH_SHORT).show();
        //currentSelectedMatch = Integer.valueOf(tempText);
        if(numTeams != 0) {
            for (int i = 0; i < numTeams; i++) {
                String temp = matchObjList.get(currentSelectedMatch).getTeamNumber(i);
                TextView tempView = (TextView) findViewById(lbl_list.get(i));
                tempView.setText(temp);
            }
        }else{Log.d("updateTeams","No teams");}
        highlightTabletIdTeam();
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


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,spinner_match_list.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
        updateTeams();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}