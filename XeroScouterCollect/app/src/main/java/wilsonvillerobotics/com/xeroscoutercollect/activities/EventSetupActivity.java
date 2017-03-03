package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;

public class EventSetupActivity extends Activity implements View.OnClickListener{

    String strTabletID, strEventName;
    boolean idEmpty, nameEmpty, idValid, nameValid;

    ArrayList<String> eventList = new ArrayList<>();
    ArrayAdapter<String> eventArrayAdapter;
    HashMap<String, Integer> eventIdMap = new HashMap<>();
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_setup);
        Intent intent;
        String pref_default = getString(R.string.default_pref_value);
        //SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences sharedPreferences = this.getPreferences(this.MODE_PRIVATE);
        strTabletID = sharedPreferences.getString(getString(R.string.tablet_id_pref), pref_default);
        strEventName = sharedPreferences.getString(getString(R.string.event_name_pref), pref_default);

        dbHelper = DatabaseHelper.getInstance(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String queryString = "SELECT * FROM event;";

        Cursor cursor = db.rawQuery(queryString, null);
        eventList.add("Select An Event");
        while(cursor.moveToNext()) {
            eventList.add(cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_NAME_EVENT_NAME)));
            eventIdMap.put(cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_NAME_EVENT_NAME)), cursor.getInt(cursor.getColumnIndex("_id")));
        }

        eventArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, eventList);

        eventArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner eventSpinner = (Spinner) findViewById(R.id.event_setup_spinner);

        eventSpinner.setAdapter(eventArrayAdapter);

        idValid = nameValid = false;

        idEmpty = (strTabletID.equalsIgnoreCase(pref_default));
        nameEmpty = (strEventName.equalsIgnoreCase(pref_default));

        if(idEmpty || nameEmpty) {
            setContentView(R.layout.activity_event_setup);
            if(idEmpty && nameEmpty) {
                Toast.makeText(this, "Tablet ID and Event Name need to be set!", Toast.LENGTH_LONG).show();
            } else if(idEmpty) {
                TextView lblName = (TextView)findViewById(R.id.lbl_main_event_name);
                if(lblName != null) {
                    lblName.setVisibility(View.GONE);
                }
                Toast.makeText(this, "Tablet ID needs to be set!", Toast.LENGTH_LONG).show();
            }
        } else {
            //startLandingActivity();
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSubmit) {
            savePreferences();
            startLandingActivity();
        }
    }


    private void savePreferences() {
        Spinner spinner = (Spinner) findViewById(R.id.event_setup_spinner);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int tempInt = eventIdMap.get(spinner.getSelectedItem());
        editor.putInt("event_id", eventIdMap.get(spinner.getSelectedItem()));

        editor.commit();
        Toast.makeText(this, String.valueOf(sharedPreferences.getInt("event_id", 0)), Toast.LENGTH_SHORT).show();
    }
    private void startLandingActivity() {
        Intent intent = new Intent(this, LandingActivity.class);
        intent.putExtra(getString(R.string.event_name_intent_key), strEventName);
        intent.putExtra(getString(R.string.tablet_id_intent_key), strTabletID);
        startActivity(intent);
        finish();
    }
}
