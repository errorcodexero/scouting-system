package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import wilsonvillerobotics.com.xeroscoutercollect.R;

/**
 * Created by Luke on 11/8/2016.
 */
public class SanityCheckActivity extends Activity implements View.OnClickListener{
    private String teamNum;
    private Boolean isRed;
    private TextView lblTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanity_check);
        teamNum = getIntent().getExtras().getString("team_number");
        isRed = getIntent().getExtras().getBoolean("background");
        lblTeam = (TextView)findViewById(R.id.lblTeam);
        lblTeam.setText(teamNum);
        LinearLayout layout = (LinearLayout)findViewById(R.id.sanity_layout);
        if(isRed){
            layout.setBackgroundColor(Color.RED);
        }else{ layout.setBackgroundColor(Color.BLUE);}

    }

    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_sanity_check_completed)) {
            Intent scoutingActivity = new Intent(this,ScoutingActivity.class);
            startActivity(scoutingActivity);
        }
    }
}
