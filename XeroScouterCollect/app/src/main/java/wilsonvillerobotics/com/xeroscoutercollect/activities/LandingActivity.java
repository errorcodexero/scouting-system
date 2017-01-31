package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.UUID;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.utils.UUIDGenerator;

/**
 * Created by Luke on 11/5/2016.
 */
public class LandingActivity extends Activity implements View.OnClickListener{

    private String eventName;
    private String tabletID;
    private String uidString;


    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        // Load default values if needed for preferences
        PreferenceManager.setDefaultValues(getApplicationContext(), R.xml.preferences, false);
        getSharedPrefs();
        updateLabels();

        // TODO - is there a danger in creating the database object inside if an Activity? Think about the life cycle.
        db = DatabaseHelper.getInstance(getApplicationContext());
        // TODO - Investigate Loaders. http://www.androiddesignpatterns.com/2012/07/understanding-loadermanager.html

        if(uidString.equals(getString(R.string.default_pref_value))){
            UUID uid = UUIDGenerator.generateUUID();
            uidString =  uid.toString();
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(getString(R.string.uuid_value_pref), uidString).commit();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        updateLabels();
    }

    public void getSharedPrefs(){
        String pref_default = getString(R.string.default_pref_value);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        tabletID = sharedPreferences.getString(getString(R.string.tablet_id_pref), pref_default);
        eventName = sharedPreferences.getString(getString(R.string.event_name_pref), pref_default);
        uidString = sharedPreferences.getString(getString(R.string.uuid_value_pref), pref_default);
    }
    private void updateLabels()
    {
        TextView lblTabletID = (TextView)findViewById(R.id.lbl_tablet_id);
        TextView lblEventName = (TextView)findViewById(R.id.lbl_event_name);

        if(lblTabletID != null) {
            lblTabletID.setText(getString(R.string.lbl_tablet_id) + " " + tabletID);
        }

        if(lblEventName != null) {
            lblEventName.setText(getString(R.string.lbl_event_name) + " " + eventName);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent;
        switch (item.getItemId()) {
            case R.id.settings:
                intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.manage_db:
                intent = new Intent(this, ManageDBActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_start_stand_scouting) {
            Intent matchConfirmationActivity = new Intent(this, MatchConfirmationActivity.class);
            matchConfirmationActivity.putExtra("event_name", eventName);
            matchConfirmationActivity.putExtra("tablet_id", tabletID);
            startActivity(matchConfirmationActivity);
        } else if(view.getId() == R.id.btn_start_pit_scouting) {
            Intent pitScoutingIntent = new Intent(this, PitScoutingActivity.class);
            pitScoutingIntent.putExtra("event_name", eventName);
            pitScoutingIntent.putExtra("tablet_id", tabletID);
            startActivity(pitScoutingIntent);
        } else if(view.getId() == R.id.btn_start_drive_team_feedback) {
            Intent driveTeamFeedbackActivity = new Intent(this,DriveTeamFeedbackActivity.class);
            startActivity(driveTeamFeedbackActivity);
        }
    }
}
