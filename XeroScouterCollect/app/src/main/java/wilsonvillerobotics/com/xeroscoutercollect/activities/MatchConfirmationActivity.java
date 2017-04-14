package wilsonvillerobotics.com.xeroscoutercollect.activities;

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

import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamMatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.fragments.StandMatchConfirmationFragment;
import wilsonvillerobotics.com.xeroscoutercollect.models.MatchModel;

/**
 * Created by Luke on 11/5/2016.
 */
public class MatchConfirmationActivity extends FragmentActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private final int NUM_TEAMS =6;
    private Spinner spinner_match_list;
    private Spinner spinner_team_list;
    private Button btn_next;
    private Intent sanityCheckActivity;
    private Intent landingActivity;
    private List<String> match_list;
    private HashMap<Integer, String> team_list;
    private HashMap<String, Integer> teamIdMap;
    public int currentSelectedMatch;
    private int currentSelectedTeamIndex;
    private boolean isRed;
    public ArrayList<MatchModel> matchObjList;
    private ArrayList<Integer> lbl_list;
    private Integer lastMatchNum;
    private String currentSelectedTeam;


    public ArrayAdapter<String> matchDataAdapter;
    public ArrayAdapter<String> teamDataAdapter;

    private String eventName;
    private String tabletID;
    private DatabaseHelper dbHelper;

    private boolean teamSpinnerActive;
    private boolean nextButtonActive;
    private boolean matchSpinnerHasBeenCreated;
    private boolean teamSpinnerHasBeenCreated;
    private boolean manualSelection;
    private SharedPreferences sharedPreferences;
    private SQLiteDatabase db;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_confirmation);

        matchObjList = new ArrayList<MatchModel>();
        lbl_list = new ArrayList<Integer>();
        team_list = new HashMap<>();
        teamIdMap = new HashMap<>();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean testBool = sharedPreferences.getBoolean("resetEventId", true);
       /*if(sharedPreferences.getBoolean("resetEventId", true)) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("resetEventId", false);
            editor.commit();
            Intent startEventSelectorIntent = new Intent(this, EventSetupActivity.class);
            startActivity(startEventSelectorIntent);
        }*/


        dbHelper = DatabaseHelper.getInstance(getApplicationContext());
        sanityCheckActivity = new Intent(this, SanityCheckActivity.class);
        landingActivity = new Intent(this, LandingActivity.class);

        // update based on button selected on previous screen false)
        boolean standScouting = true;

        if(findViewById(R.id.ll_main_layout) != null) {

            if(savedInstanceState != null) {
                return;
            }

            if(standScouting) {
                StandMatchConfirmationFragment standFragmemt = new StandMatchConfirmationFragment();
                standFragmemt.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().
                        add(R.id.ll_main_layout, standFragmemt).commit();


            }
        }
        matchSpinnerHasBeenCreated = false;
        manualSelection = false;
        isRed = false;
        //addListenerOnButton();
    }

    private void doManualSettingCheck() {
        if(spinner_team_list != null) {
            if (manualSelection) {
                teamSpinnerActive = false;
                spinner_team_list.setEnabled(teamSpinnerActive);
                nextButtonActive = false;
                btn_next.setEnabled(nextButtonActive);
            }
            spinner_team_list.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public void onStart(){
        super.onStart();

        StandMatchConfirmationFragment frag = (StandMatchConfirmationFragment) getSupportFragmentManager().findFragmentById(R.id.ll_main_layout);

        spinner_match_list = frag.getMatchListSpinner(); // (Spinner) findViewById(R.id.spinner_match_list);
        spinner_team_list = frag.getTeanListSpinner(); // (Spinner) findViewById(R.id.spinner_team_list);
        btn_next = frag.getNextButton(); // (Button) findViewById(R.id.btn_next);
        btn_next.setEnabled(true);

        if(spinner_match_list != null) {
            spinner_match_list.setOnItemSelectedListener(this);
            addItemsToMatchSpinner();
        }
        if(spinner_team_list != null) {
            spinner_team_list.setOnItemSelectedListener(this);
            addItemsToTeamSpinner();
        }
        getSharedPrefs();
        doManualSettingCheck();
        updateTabletIdLabel();
        populateTeamList();
        getSelectedTeamIndex();
        populateLblList();
        resetLblColors(lbl_list);
        populateMatchTable();
        highlightTabletIdTeam();
        addItemsToMatchSpinner();
        addItemsToTeamSpinner();

        Spinner spinner = (Spinner) findViewById(R.id.spinner_match_list);
        spinner.setSelection(matchDataAdapter.getPosition(String.valueOf(lastMatchNum)));
    }


    private void getSelectedTeamIndex() {
        switch (tabletID) {
            case "1":
                currentSelectedTeamIndex = 0;
                break;
            case "2":
                currentSelectedTeamIndex = 1;
                break;
            case "3":
                currentSelectedTeamIndex = 2;
                break;
            case "4":
                currentSelectedTeamIndex = 3;
                break;
            case "5":
                currentSelectedTeamIndex = 4;
                break;
            case "6":
                currentSelectedTeamIndex = 5;
                break;
            default:
                currentSelectedTeamIndex = -1;
                break;
        }
    }

    //Highlights the team to scout.
    private void highlightTabletIdTeam() {
        switch (currentSelectedTeamIndex){
            case 0:
                formatTabletTeamCell(R.id.lbl_team_1);
                isRed = true;
                break;
            case 1:
                formatTabletTeamCell(R.id.lbl_team_2);
                isRed = true;
                break;
            case 2:
                formatTabletTeamCell(R.id.lbl_team_3);
                isRed = true;
                break;
            case 3:
                formatTabletTeamCell(R.id.lbl_team_4);
                isRed = false;
                break;
            case 4:
                formatTabletTeamCell(R.id.lbl_team_5);
                isRed = false;
                break;
            case 5:
                formatTabletTeamCell(R.id.lbl_team_6);
                isRed = false;
                break;
            default:
                Toast.makeText(this, "Invalid TabletID", Toast.LENGTH_LONG).show();
                break;
        }
    }

    //Sets the color of the cell.
    private void formatTabletTeamCell(int txtTeamID) {
        TextView tempView;
        tempView = (TextView) findViewById(txtTeamID);
        if(tempView != null) {
            tempView.setBackgroundColor(Color.YELLOW);
            tempView.setTextColor(Color.BLACK);
        }
    }

    public void resetLblColors(ArrayList<Integer> list){
        TextView tempView;
        for(int i = 0; i < list.size()/2; i++){
            tempView = (TextView) findViewById(list.get(i));
            if(tempView != null) {
                tempView.setBackgroundColor(Color.RED);
            }
        }
        for(int i = (list.size()/2); i < list.size(); i++){
            tempView = (TextView) findViewById(list.get(i));
            if(tempView != null) {
                tempView.setBackgroundColor(Color.BLUE);
            }
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

    //Finds the tablet id and if manual selection is checked
    private void getSharedPrefs(){
        String pref_default = getString(R.string.default_pref_value);
        tabletID = sharedPreferences.getString(getString(R.string.tablet_id_pref), pref_default);
        manualSelection = sharedPreferences.getBoolean(getString(R.string.manual_selection_pref), false);
        lastMatchNum = sharedPreferences.getInt("last_match_num", 0) + 1;

    }
    //Sets tablet id label
    private void updateTabletIdLabel() {
        TextView lblTabletID = (TextView)findViewById(R.id.lbl_tablet_id);
        if(lblTabletID != null) {
            lblTabletID.setText(getString(R.string.lbl_tablet_id) + " " + tabletID);
        }
    }

    private void populateTeamList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        teamIdMap = new HashMap<>();

        TeamContract tc = new TeamContract();
        String query = tc.getTeamListQuery();
        Cursor cursor = db.rawQuery(query, null);

        try {
            while(cursor.moveToNext()) {
                int idIndex = cursor.getColumnIndex(TeamContract.TeamEntry.COLUMN_NAME_ID);
                int numIndex = cursor.getColumnIndex(TeamContract.TeamEntry.COLUMN_NAME_TEAM_NUMBER);

                int id = cursor.getInt(idIndex);
                String teamNum = cursor.getString(numIndex);
                team_list.put(id, teamNum);
                teamIdMap.put(teamNum, id);
            }
        } finally {
            cursor.close();
        }
    }

    private void populateMatchTable() {
        db = dbHelper.getReadableDatabase();

        Cursor cursor = null;
        boolean exit = false;
        try {
            int event_id = Integer.parseInt(sharedPreferences.getString(getString(R.string.event_name_pref), "-1"));
            //int event_id = 139;

            String query = MatchModel.getAllMatches(event_id);
            cursor = db.rawQuery(query, null);
            exit = (cursor == null);
        } catch (NumberFormatException nfe) {
            Toast.makeText(this, "Invalid event, should be the event ID (number)", Toast.LENGTH_LONG).show();
            Log.e("MATCH_CONFIRMATION_ACT", nfe.getMessage());
            exit = true;
        } catch (Exception e) {
            Log.e("MATCH_CONFIRMATION_ACT", e.getMessage());
            exit = true;
        } finally {
            if(exit) return;
        }

        try {
            while(cursor.moveToNext()) {
                matchObjList.add(new MatchModel(
                        String.valueOf(cursor.getString(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_ID))),
                        String.valueOf(cursor.getString(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_MATCH_NUMBER))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_1))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_2))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_3))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_1))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_2))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_3)))));
            }
        } finally {
            cursor.close();
        }
    }

    public int getMatchNumIndex(String matchNumToGet){
        int result = -1;
        for(int i = 0; i < matchObjList.size(); i++){
            if((matchObjList.get(i).getMatchNumber()).equals(matchNumToGet)){
                result = i;
                break;
            }
        }
        return result;
    }

    //Add matches to spinner
    public void addItemsToMatchSpinner() {
        if(spinner_match_list != null) {
            match_list = new ArrayList<String>();
            match_list.add("Select A Match");
            for (MatchModel tempMatch : matchObjList) {
                //match_list.add(String.valueOf(Integer.parseInt(tempMatch.getMatchNumber().replaceAll("[\\D]", ""))));
                match_list.add(tempMatch.getMatchNumber());
            }

            matchDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, match_list);
            matchDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_match_list.setAdapter(matchDataAdapter);
        }
    }

    //Do only if manual selection is selected
    public void addItemsToTeamSpinner() {
        if(spinner_team_list != null) {
            if (manualSelection) {
                Collection<String> teamNumbers = team_list.values();
                ArrayList<String> teamArrayList = new ArrayList<String>(teamNumbers);
                teamArrayList.add(0, "Select A Team");
                teamDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamArrayList);
                teamDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner_team_list.setAdapter(teamDataAdapter);
            }
        }
    }


    // get the selected dropdown list value
    public void addListenerOnButton() {
        if(spinner_match_list != null) {
            spinner_match_list = (Spinner) findViewById(R.id.spinner_match_list);
        }
        if(btn_next != null) {
            btn_next = (Button) findViewById(R.id.btn_next);
        }
        //updateTeams();
    }


    //Updates the team field according to the selected match
    private void updateTeams() {
        //Toast.makeText(this,"Position: " + currentSelectedMatch,Toast.LENGTH_SHORT).show();
        if(!manualSelection && currentSelectedMatch >= 0) {
            for (int i = 0; i < NUM_TEAMS; i++) {
                String temp = team_list.get(Integer.parseInt(matchObjList.get(currentSelectedMatch).getTeamNumber(i)));
                TextView tempView = (TextView) findViewById(lbl_list.get(i));
                if(tempView != null) {
                    tempView.setText(temp);
                }
            }
        }
        else{
            if(currentSelectedTeamIndex >= 0) {
                TextView tempView = (TextView) findViewById(lbl_list.get(currentSelectedTeamIndex));
                if (tempView != null) {
                    tempView.setText(currentSelectedTeam);
                }
            }
        }
        highlightTabletIdTeam();
    }


    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_next)) {
            String queryString;
            MatchModel matchModel = matchObjList.get(currentSelectedMatch);
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            int matchId = 0;
            int teamMatchId;
            String tn;
            queryString = "SELECT * FROM 'match' WHERE " + MatchContract.MatchEntry.COLUMN_NAME_ID + " = " + matchModel.get_id() + ";";
            Cursor matchCursor = db.rawQuery(queryString, null);
            if(matchCursor.moveToNext())
               matchId = matchCursor.getInt(matchCursor.getColumnIndex("_id"));
            else {
                Toast.makeText(this, "NO MATCH DATA", Toast.LENGTH_LONG).show();
            }
            if(!manualSelection) {
                tn = matchObjList.get(currentSelectedMatch).getTeamNumber(currentSelectedTeamIndex);
            }
            else{
                tn = currentSelectedTeam;
            }

            //int team_id = teamIdMap.get(tn);
            queryString = "SELECT * FROM team_match WHERE team_id = " + tn + " AND " + TeamMatchContract.TeamMatchEntry.COLUMN_NAME_MATCH_ID + " = " + matchId + ";";
            Cursor teamMatchCursor = db.rawQuery(queryString, null);
            teamMatchCursor.moveToFirst();
            teamMatchId = teamMatchCursor.getInt(teamMatchCursor.getColumnIndex(TeamMatchContract.TeamMatchEntry.COLUMN_NAME_ID));
            //Toast.makeText(this, "TMA = " + teamMatchId, Toast.LENGTH_LONG).show();


            //Cursor

            //Cursor cursor = db.execSQL("SELECT * FROM team_match WHERE id = " + tn);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("last_match_num", Integer.valueOf(matchCursor.getString(matchCursor.getColumnIndex("match_number"))));
            editor.apply();

            matchCursor.close();
            teamMatchCursor.close();

            sanityCheckActivity.putExtra("background",isRed);
            sanityCheckActivity.putExtra("team_number", team_list.get(Integer.parseInt(tn)));
            sanityCheckActivity.putExtra("team_match_id", teamMatchId);
            startActivity(sanityCheckActivity);
        }
        if(view == findViewById(R.id.btn_get_teams)){
            updateTeams();
        }
        if(view.getId() == R.id.btn_home){
            startActivity(landingActivity);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int parentId = parent.getId();
        switch(parentId){
            case R.id.spinner_match_list:
                if(spinner_match_list != null) {
                    Toast.makeText(this, spinner_match_list.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                    currentSelectedMatch = spinner_match_list.getSelectedItemPosition() - 1;
                    if (matchSpinnerHasBeenCreated) { //Prevents running on startup
                        teamSpinnerActive = true;
                        spinner_team_list.setEnabled(teamSpinnerActive);
                        if(btn_next != null) {
                            btn_next.setEnabled(matchSpinnerHasBeenCreated);
                        }
                        if (manualSelection) {
                            spinner_team_list.setVisibility(View.VISIBLE);
                        }
                    }

                    if(!manualSelection){
                        updateTeams();
                    }
                    matchSpinnerHasBeenCreated = true;


                }
                break;
            case R.id.spinner_team_list:
                if(teamSpinnerHasBeenCreated) { //Prevents running on startup
                    currentSelectedTeam = ((TextView) view).getText().toString();
                    updateTeams();
                    nextButtonActive = true;
                    if(btn_next != null) {
                        btn_next.setEnabled(nextButtonActive);
                    }
                }
                teamSpinnerHasBeenCreated = true;
                break;
            default:

                break;
        }



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}