package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import wilsonvillerobotics.com.xeroscoutercollect.R;

/**
 * Created by Luke on 11/8/2016.
 */
public class SanityCheckActivity extends Activity implements View.OnClickListener{
    private String teamNum;
    private Boolean isRed;
    private TextView lblTeam;
    private Integer teamMatchId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanity_check);
        teamNum = getIntent().getExtras().getString("team_number");
        isRed = getIntent().getExtras().getBoolean("background");
        teamMatchId = getIntent().getExtras().getInt("team_match_id");
        Toast.makeText(this, String.valueOf(teamMatchId), Toast.LENGTH_LONG).show();
        lblTeam = (TextView)findViewById(R.id.lblTeam);
        lblTeam.setText(teamNum);
        LinearLayout layout = (LinearLayout)findViewById(R.id.sanity_layout);
        if(isRed){
            layout.setBackgroundColor(Color.RED);
        }else{ layout.setBackgroundColor(Color.BLUE);}

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_sanity_check_completed) {
            Intent scoutingActivity = new Intent(this,ScoutingActivity.class);
            scoutingActivity.putExtra("background",isRed);
            scoutingActivity.putExtra("team_number", teamNum);
            scoutingActivity.putExtra("team_match_id", teamMatchId);
            startActivity(scoutingActivity);
        }
    }
}
