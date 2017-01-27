package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.os.Bundle;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;

/**
 * Created by Luke on 1/24/2017.
 */

public class DriveTeamFeedbackActivity extends Activity{
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_team_feedback);


    }
}
