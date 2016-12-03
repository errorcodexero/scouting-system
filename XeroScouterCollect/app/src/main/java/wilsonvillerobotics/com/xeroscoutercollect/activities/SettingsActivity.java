package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import wilsonvillerobotics.com.xeroscoutercollect.R;

/**
 * Created by tomso on 12/2/2016.
 * More info: https://developer.android.com/guide/topics/ui/settings.html
 */

public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        SettingsFragment frag = new SettingsFragment();
        frag.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, frag)
                .commit();
    }
}
