package wilsonvillerobotics.com.xeroscoutercollect;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class ScoutingActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouting);

        TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec autonomousTab = tabHost.newTabSpec("tab1");
        TabHost.TabSpec teleopTab = tabHost.newTabSpec("tab2");
        TabHost.TabSpec finalizeTab = tabHost.newTabSpec("tab3");

        autonomousTab.setIndicator("Autonomous Tab").setContent(new Intent(this, AutonomousTab.class));
        teleopTab.setIndicator("Teleop Tab").setContent(new Intent(this, TeleopTab.class));
        finalizeTab.setIndicator("Finalize Tab").setContent(new Intent(this, FinalizeTab.class));

        tabHost.addTab(autonomousTab);
        tabHost.addTab(teleopTab);
        tabHost.addTab(finalizeTab);


    }
}
