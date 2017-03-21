package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.contracts.EventContract;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;

public class MainActivity_new extends Activity {
/*
    String strTabletID, strEventName;
    boolean idEmpty, nameEmpty, idValid, nameValid;

    ArrayList<String> eventList = new ArrayList<>();
    ArrayAdapter<String> eventArrayAdapter;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent;
        String pref_default = getString(R.string.default_pref_value);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        strTabletID = sharedPreferences.getString(getString(R.string.tablet_id_pref), pref_default);
        strEventName = sharedPreferences.getString(getString(R.string.event_name_pref), pref_default);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("resetEventId", true);
        editor.commit();


        dbHelper = DatabaseHelper.getInstance(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String queryString = "SELECT * FROM event;";

        Cursor cursor = db.rawQuery(queryString, null);
        eventList.add("Select A Team");
        while(cursor.moveToNext()) {
            eventList.add(cursor.getString(cursor.getColumnIndex(EventContract.EventEntry.COLUMN_NAME_EVENT_NAME)));
        }

        eventArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, eventList);

        Spinner eventSpinner = (Spinner) findViewById(R.id.event_spinner);

        eventSpinner.setAdapter(eventArrayAdapter);

        idValid = nameValid = false;

        idEmpty = (strTabletID.equalsIgnoreCase(pref_default));
        nameEmpty = (strEventName.equalsIgnoreCase(pref_default));

        if(idEmpty || nameEmpty) {
            setContentView(R.layout.activity_main);
            if(idEmpty && nameEmpty) {
                Toast.makeText(this, "Tablet ID and Event Name need to be set!", Toast.LENGTH_LONG).show();
            } else if(idEmpty) {
                TextView lblName = (TextView)findViewById(R.id.lbl_main_event_name);
                if(lblName != null) {
                    lblName.setVisibility(View.GONE);
                }
                Toast.makeText(this, "Tablet ID needs to be set!", Toast.LENGTH_LONG).show();
            } else if(nameEmpty) {
                Toast.makeText(this, "Event Name needs to be set!", Toast.LENGTH_LONG).show();
                EditText txtID = (EditText)findViewById(R.id.txt_main_tablet_id);
                if(txtID != null) {
                    txtID.setVisibility(View.GONE);
                }
                TextView lblID = (TextView)findViewById(R.id.lbl_main_tablet_id);
                if(lblID != null) {
                    lblID.setVisibility(View.GONE);
                }
            }
        } else {
            startLandingActivity();
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSubmit) {
            validatePreferences();
            savePreferences();
            startLandingActivity();
        }
    }

    private void validatePreferences()
    {
        if(idEmpty) {
            EditText txtID = (EditText)findViewById(R.id.txt_main_tablet_id);
            if(txtID != null) {
                String strID = txtID.getText().toString();
                if(!(strID.compareTo(getString(R.string.default_pref_value)) == 0 || strID.isEmpty())) {
                    strTabletID = strID;
                    idValid = true;
                }
            }
        }
    }

    private void savePreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("event_id", 1);
        editor.commit();
        editor.putString(getString(R.string.event_name_pref), "0");

        if(idValid) {
            editor.putString(getString(R.string.tablet_id_pref), strTabletID);
        }
        editor.commit();
    }*/
    private void startLandingActivity() {
        Intent intent = new Intent(this, LandingActivity.class);
        //intent.putExtra(getString(R.string.event_name_intent_key), strEventName);
        //intent.putExtra(getString(R.string.tablet_id_intent_key), strTabletID);
        startActivity(intent);
        finish();
    }

}
