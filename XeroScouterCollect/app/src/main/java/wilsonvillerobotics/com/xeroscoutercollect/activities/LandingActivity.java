package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;

/**
 * Created by Luke on 11/5/2016.
 */
public class LandingActivity extends Activity implements View.OnClickListener{

    private Intent matchConfirmationActivity;

    DatabaseHelper db;

    //Intent pitScoutingIntent = new Intent(this, PitScouting.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        matchConfirmationActivity = new Intent(this, MatchConfirmationActivity.class);

        // TODO - is there a danger in creating the database object inside if an Activity? Think about the life cycle.
        db = DatabaseHelper.getInstance(getApplicationContext());
        // TODO - Let's replace the Singleton with a Loader. http://www.androiddesignpatterns.com/2012/07/understanding-loadermanager.html
    }



    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_start_stand_scouting)) {
            startActivity(matchConfirmationActivity);
        }
    }
}
