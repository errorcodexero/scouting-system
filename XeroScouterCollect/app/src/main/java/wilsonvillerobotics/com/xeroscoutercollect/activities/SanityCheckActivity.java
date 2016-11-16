package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import wilsonvillerobotics.com.xeroscoutercollect.R;

/**
 * Created by Luke on 11/8/2016.
 */
public class SanityCheckActivity extends Activity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanity_check);
    }

    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_sanity_check_completed)) {
            Intent scoutingActivity = new Intent(this,ScoutingActivity.class);
            startActivity(scoutingActivity);
        }
    }
}
