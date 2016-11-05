package wilsonvillerobotics.com.xeroscoutercollect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Luke on 11/5/2016.
 */
public class LandingActivity extends Activity implements View.OnClickListener{

    private Intent scoutingIntent;

    //Intent pitScoutingIntent = new Intent(this, PitScouting.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        scoutingIntent = new Intent(this, ScoutingActivity.class);

    }

    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_Start_Stand_Scouting)) {
            startActivity(scoutingIntent);
        }
    }
}