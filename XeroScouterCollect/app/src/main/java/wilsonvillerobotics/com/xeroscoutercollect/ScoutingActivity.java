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

        autonomousTab.setIndicator("Autonomous Tab").setContent(R.id.Autonomous);
        teleopTab.setIndicator("Teleop Tab").setContent(R.id.Teleop);
        finalizeTab.setIndicator("Finalize Tab").setContent(R.id.Finalize);

        tabHost.addTab(autonomousTab);
        tabHost.addTab(teleopTab);
        tabHost.addTab(finalizeTab);


    }

}
