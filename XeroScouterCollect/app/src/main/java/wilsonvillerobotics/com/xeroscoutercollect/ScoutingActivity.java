package wilsonvillerobotics.com.xeroscoutercollect;

import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ScoutingActivity extends TabActivity implements View.OnClickListener {

    protected HashMap<Integer, Integer> matchMap = new HashMap<>();

    protected ArrayList<ActionObject> actionObjectArrayList = new ArrayList<>();


    protected TeamMatch currentMatch = new TeamMatch();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouting);

        // Initializing the tabbing system

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

        // Begin mapping text entries to variables


        // b -> a; [] key -> b; b key -> textview

        /*matchMap.put(R.id.btn_decrement_action_1, currentMatch.actionCount.get(0));
        matchMap.put(R.id.btn_decrement_action_2, currentMatch.actionCount.get(1));
        matchMap.put(R.id.btn_decrement_action_3, currentMatch.actionCount.get(2));
        matchMap.put(R.id.btn_decrement_action_4, currentMatch.actionCount.get(3));
        matchMap.put(R.id.btn_decrement_action_5, currentMatch.actionCount.get(4));
        matchMap.put(R.id.btn_decrement_action_6, currentMatch.actionCount.get(5));
        matchMap.put(R.id.btn_decrement_action_7, currentMatch.actionCount.get(6));
        matchMap.put(R.id.btn_decrement_action_8, currentMatch.actionCount.get(7));
        matchMap.put(R.id.btn_decrement_action_9, currentMatch.actionCount.get(8));*/

        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_1, R.id.btn_increment_action_2, R.id.entry_action_2, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_2, R.id.btn_increment_action_1, R.id.entry_action_1, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_3, R.id.btn_increment_action_3, R.id.entry_action_3, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_4, R.id.btn_increment_action_4, R.id.entry_action_4, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_5, R.id.btn_increment_action_5, R.id.entry_action_5, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_6, R.id.btn_increment_action_6, R.id.entry_action_6, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_7, R.id.btn_increment_action_7, R.id.entry_action_7, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_8, R.id.btn_increment_action_8, R.id.entry_action_8, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_9, R.id.btn_increment_action_9, R.id.entry_action_9, 0));

    }


    @Override
    public void onClick(View view) {
        int index = 0;
        boolean decrement = false;
        switch (view.getId()) {

            // Doing that young fallthough

            case R.id.btn_decrement_action_1:
                index = 0;
                decrement = true;
                break;
            case R.id.btn_decrement_action_2:
                index = 1;
                decrement = true;
                break;
            case R.id.btn_decrement_action_3:
                index = 2;
                decrement = true;
                break;
            case R.id.btn_decrement_action_4:
                index = 3;
                decrement = true;
                break;
            case R.id.btn_decrement_action_5:
                index = 4;
                decrement = true;
                break;
            case R.id.btn_decrement_action_6:
                index = 5;
                decrement = true;
                break;
            case R.id.btn_decrement_action_7:
                index = 6;
                decrement = true;
                break;
            case R.id.btn_decrement_action_8:
                index = 7;
                decrement = true;
                break;
            case R.id.btn_decrement_action_9:
                index = 8;
                decrement = true;
                break;
            case R.id.btn_increment_action_1:
                index = 0;
                break;
            case R.id.btn_increment_action_2:
                index = 1;
                break;
            case R.id.btn_increment_action_3:
                index = 2;
                break;
            case R.id.btn_increment_action_4:
                index = 3;
                break;
            case R.id.btn_increment_action_5:
                index = 4;
                break;
            case R.id.btn_increment_action_6:
                index = 5;
                break;
            case R.id.btn_increment_action_7:
                index = 6;
                break;
            case R.id.btn_increment_action_8:
                index = 7;
                break;
            case R.id.btn_increment_action_9:
                index = 8;
                break;

        }
        ActionObject tempObject = actionObjectArrayList.get(index);
        tempObject.changeValue(decrement);

        EditText tempTextView = (EditText) findViewById(tempObject.getTextFieldId());
        if (tempTextView != null) {
            tempTextView.setText(tempObject.getActionCount());
        } else {
            Toast.makeText(ScoutingActivity.this, "Your bad at coding Nick", Toast.LENGTH_SHORT).show();
        }
    }
}
