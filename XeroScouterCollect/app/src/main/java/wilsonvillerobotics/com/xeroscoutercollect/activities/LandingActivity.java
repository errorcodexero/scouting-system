package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import wilsonvillerobotics.com.xeroscoutercollect.R;

/**
 * Created by Luke on 11/5/2016.
 */
public class LandingActivity extends Activity implements View.OnClickListener{

    private Intent matchConfirmationActivity;

    //Intent pitScoutingIntent = new Intent(this, PitScouting.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        matchConfirmationActivity = new Intent(this, MatchConfirmationActivity.class);

    }

    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_start_stand_scouting)) {
            startActivity(matchConfirmationActivity);
        }
    }
}
