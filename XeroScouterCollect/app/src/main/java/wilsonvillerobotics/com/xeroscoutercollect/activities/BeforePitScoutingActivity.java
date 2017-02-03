package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.TeamContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;

import static wilsonvillerobotics.com.xeroscoutercollect.R.id.spinner_pit_team_list;


/**
 * Created by Luke on 2/2/2017.
 */

public class BeforePitScoutingActivity extends Activity implements View.OnClickListener {
    private DatabaseHelper dbHelper;
    private Spinner spinner_pit_team_list;
    private HashMap<Integer, String> teamList;
    private ArrayAdapter<String> teamDataAdapter;
    private Intent pitScoutingActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_pit_scouting);

        dbHelper = DatabaseHelper.getInstance(getApplicationContext());
        spinner_pit_team_list = (Spinner) findViewById(R.id.spinner_pit_team_list);
        teamList = new HashMap<Integer, String>();


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
                teamList.put(id, teamNum);
            }
        } finally {
            cursor.close();
        }
    }

    public void addTeamListItemsToTeamSpinner() {
        Collection<String> teamNumbers = teamList.values();
        ArrayList<String> teamArrayList = new ArrayList<String>(teamNumbers);
        teamArrayList.add(0, "Select A Team");
        teamDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, teamArrayList);
        teamDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_pit_team_list.setAdapter(teamDataAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_before_pit_next){
            pitScoutingActivity = new Intent(this, PitScoutingActivity.class);
            pitScoutingActivity.putExtra("team_number",spinner_pit_team_list.getSelectedItem().toString());
            startActivity(pitScoutingActivity);
        }
    }
}
