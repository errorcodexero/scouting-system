package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;


/**
 * Created by Luke on 2/2/2017.
 */

public class BeforePitScoutingActivity extends Activity implements View.OnClickListener {
    private DatabaseHelper dbHelper;
    private Spinner spinner_pit_team_list;
    private HashMap<Integer, String> teamList;
    private ArrayList<Team> teamObjList;
    private ArrayAdapter<String> teamDataAdapter;
    private Intent pitScoutingActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_pit_scouting);

        dbHelper = DatabaseHelper.getInstance(getApplicationContext());
        spinner_pit_team_list = (Spinner) findViewById(R.id.spinner_pit_team_list);
        teamList = new HashMap<>();
        teamObjList = new ArrayList<>();


        populateTeamList();
        addTeamListItemsToTeamSpinner(); //Needs populateTeamList
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
                teamObjList.add(new Team(id, teamNum));
                //teamList.put(id, teamNum);
            }
        } finally {
            cursor.close();
        }
    }


    public void addTeamListItemsToTeamSpinner() {
        /*Collection<String> teamNumbers = teamList.values();
        ArrayList<String> teamArrayList = new ArrayList<String>(teamNumbers);
        teamArrayList.add(0, "Select A Team");
        teamDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamArrayList);
        teamDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_pit_team_list.setAdapter(teamDataAdapter);*/
        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, teamObjList);
        spinner_pit_team_list.setAdapter(spinnerArrayAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_before_pit_next){
            Team team = teamObjList.get(spinner_pit_team_list.getSelectedItemPosition());
            pitScoutingActivity = new Intent(this, PitScoutingActivity.class);
            pitScoutingActivity.putExtra("teamId",team.getTeamId());
            pitScoutingActivity.putExtra("teamNum",team.getTeamNum());

            startActivity(pitScoutingActivity);
        }
    }

    public class Team implements Serializable{
        private int teamId;
        private String teamNum;

        public Team(int teamId, String teamNum) {
            this.teamId = teamId;
            this.teamNum = teamNum;
        }
        public String toString(){
            return teamNum;
        }
        public String getTeamNum(){
            return teamNum;
        }

        public int getTeamId(){
            return teamId;
        }
    }
}
