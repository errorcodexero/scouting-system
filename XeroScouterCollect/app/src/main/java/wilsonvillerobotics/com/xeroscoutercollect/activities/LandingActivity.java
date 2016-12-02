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
import android.view.ViewConfiguration;
import android.widget.TextView;

import java.lang.reflect.Field;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;

import static android.view.Window.FEATURE_ACTION_BAR;

/**
 * Created by Luke on 11/5/2016.
 */
public class LandingActivity extends Activity implements View.OnClickListener{

    private String eventName;
    private String tabletID;

    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        // Load default values if needed for preferences
        PreferenceManager.setDefaultValues(getApplicationContext(), R.xml.preferences, false);

        updateLabels();

        // TODO - is there a danger in creating the database object inside if an Activity? Think about the life cycle.
        db = DatabaseHelper.getInstance(getApplicationContext());
        // TODO - Investigate Loaders. http://www.androiddesignpatterns.com/2012/07/understanding-loadermanager.html
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateLabels();
    }

    private void updateLabels()
    {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String strTabletID = sharedPreferences.getString("edittext_tablet_id_preference", "*");
        String strEventName = sharedPreferences.getString("edittext_event_name_preference", "*");

        TextView lblTabletID = (TextView)findViewById(R.id.lbl_tablet_id);
        TextView lblEventName = (TextView)findViewById(R.id.lbl_event_name);

        if(lblTabletID != null) {
            lblTabletID.setText("Tablet ID: " + strTabletID);
        }

        if(lblEventName != null) {
            lblEventName.setText("Event Name: " + strEventName);
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
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
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
        }
    }
}
