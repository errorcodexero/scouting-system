package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import wilsonvillerobotics.com.xeroscoutercollect.R;

public class MainActivity extends Activity implements View.OnClickListener {

    String strTabletID, strEventName;
    boolean idEmpty, nameEmpty, idValid, nameValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent;
        String pref_default = getString(R.string.default_pref_value);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        strTabletID = sharedPreferences.getString(getString(R.string.tablet_id_pref), pref_default);
        strEventName = sharedPreferences.getString(getString(R.string.event_name_pref), pref_default);

        idValid = nameValid = false;

        idEmpty = (strTabletID.equalsIgnoreCase(pref_default));
        nameEmpty = (strEventName.equalsIgnoreCase(pref_default));

        if(idEmpty || nameEmpty) {
            setContentView(R.layout.activity_main);
            if(idEmpty && nameEmpty) {
                Toast.makeText(this, "Tablet ID and Event Name need to be set!", Toast.LENGTH_LONG).show();
            } else if(idEmpty) {
                EditText txtName = (EditText)findViewById(R.id.txt_main_event_name);
                if(txtName != null) {
                    txtName.setVisibility(View.GONE);;
                }
                TextView lblName = (TextView)findViewById(R.id.lbl_main_event_name);
                if(lblName != null) {
                    lblName.setVisibility(View.GONE);;
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
                    lblID.setVisibility(View.GONE);;
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

        if(nameEmpty) {
            EditText txtName = (EditText)findViewById(R.id.txt_main_event_name);
            if(txtName != null) {
                String strName = txtName.getText().toString();
                if(!(strName.compareTo(getString(R.string.default_pref_value)) == 0 || strName.isEmpty())) {
                    strEventName = strName;
                    nameValid = true;
                }
            }
        }
    }

    private void savePreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(idValid) {
            editor.putString(getString(R.string.tablet_id_pref), strTabletID);
        }

        if(nameValid) {
            editor.putString(getString(R.string.event_name_pref), strEventName);
        }

        editor.commit();
    }
    private void startLandingActivity() {
        Intent intent = new Intent(this, LandingActivity.class);
        intent.putExtra(getString(R.string.event_name_intent_key), strEventName);
        intent.putExtra(getString(R.string.tablet_id_intent_key), strTabletID);
        startActivity(intent);
        finish();
    }
}
