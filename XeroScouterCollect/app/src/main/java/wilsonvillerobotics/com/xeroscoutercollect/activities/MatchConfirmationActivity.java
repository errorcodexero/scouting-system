package wilsonvillerobotics.com.xeroscoutercollect.activities;

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
import java.util.HashMap;
import java.util.List;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.MatchContract;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
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
    private HashMap<Integer, String> team_list;
    public int currentSelectedMatch;
    private int currentSelectedTeamIndex;
    private boolean isRed;
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

    private String eventName;
    private String tabletID;
    private DatabaseHelper dbHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_confirmation);

        matchObjList = new ArrayList<TeamMatchModel>();
        lbl_list = new ArrayList<Integer>();
        team_list = new HashMap<Integer, String>();

        dbHelper = DatabaseHelper.getInstance(getApplicationContext());
        sanityCheckActivity = new Intent(this, SanityCheckActivity.class);

        spinner_match_list = (Spinner) findViewById(R.id.spinner_match_list);

        spinner_match_list.setOnItemSelectedListener(this);

        isRed = false;

        updateLabels();
        populateTeamList();
        getSelectedTeamIndex();
        populateLblList();
        resetLblColors(lbl_list);
        populateMatchTable();
        highlightTabletIdTeam();
        addItemsOnSpinner();
        addListenerOnButton();
    }


    private void getSelectedTeamIndex()
    {
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
        }
    }

    //Highlights the team to scout.
    private void highlightTabletIdTeam() {
        switch (currentSelectedTeamIndex){
            case 0:
                FormatTabletTeamCell(R.id.lbl_team_1);
                isRed = true;
                break;
            case 1:
                FormatTabletTeamCell(R.id.lbl_team_2);
                isRed = true;
                 break;
            case 2:
                FormatTabletTeamCell(R.id.lbl_team_3);
                isRed = true;
                break;
            case 3:
                FormatTabletTeamCell(R.id.lbl_team_4);
                isRed = false;
                break;
            case 4:
                FormatTabletTeamCell(R.id.lbl_team_5);
                isRed = false;
                break;
            case 5:
                FormatTabletTeamCell(R.id.lbl_team_6);
                isRed = false;
                break;
        }
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
    }

    private void populateTeamList()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

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
            }
        } finally {
            cursor.close();
        }
    }

    private void populateMatchTable() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        int event_id = getIntent().getIntExtra("eventId", 1);
        String query = MatchModel.getAllMatches(event_id);
        Cursor cursor = db.rawQuery(query, null);

        try {
            while(cursor.moveToNext()) {
                int red1ID = cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_1));
                int red2ID = cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_2));
                int red3ID = cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_3));
                int blue1ID = cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_1));
                int blue2ID = cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_2));
                int blue3ID = cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_3));
                matchObjList.add(new TeamMatchModel(
                        String.valueOf(cursor.getString(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_MATCH_NUMBER))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_1))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_2))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_RED_3))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_1))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_2))),
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_BLUE_3))))
                        String.valueOf(cursor.getInt(cursor.getColumnIndex(MatchContract.MatchEntry.COLUMN_NAME_MATCH_NUMBER))),
                        String.valueOf(team_list.get(red1ID)),
                        String.valueOf(team_list.get(red2ID)),
                        String.valueOf(team_list.get(red3ID)),
                        String.valueOf(team_list.get(blue1ID)),
                        String.valueOf(team_list.get(blue2ID)),
                        String.valueOf(team_list.get(blue3ID)))
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

    //Add matches to spinner
    public void addItemsOnSpinner() {
        match_list = new ArrayList<String>();

        for (TeamMatchModel tempMatch : matchObjList) {
            //match_list.add(String.valueOf(Integer.parseInt(tempMatch.getMatchNumber().replaceAll("[\\D]", ""))));
            match_list.add(tempMatch.getMatchNumber());
        }
        dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, match_list);
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
            TeamMatchModel tmModel = matchObjList.get(currentSelectedMatch);
            String tn = matchObjList.get(currentSelectedMatch).getTeamNumber(currentSelectedTeamIndex);
            sanityCheckActivity.putExtra("background",isRed);
            sanityCheckActivity.putExtra("team_number", tn);
            startActivity(sanityCheckActivity);
        }
        if(view == findViewById(R.id.btn_get_teams)){
            updateTeams();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,spinner_match_list.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
        currentSelectedMatch = spinner_match_list.getSelectedItemPosition();
        updateTeams();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}