package wilsonvillerobotics.com.xeroscoutercollect;

import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class ScoutingActivity extends TabActivity implements View.OnClickListener {

    protected HashMap<Integer, Integer> matchMap = new HashMap<>();

    protected ArrayList<ActionObject> actionObjectArrayList = new ArrayList<>();

    protected ArrayList<Pair<String, String>> finalizeDataList = new ArrayList<>();

    protected TwoColumnAdapter finalizeTabAdapter;

    //protected SQLiteDatabase matchDB = openOrCreateDatabase("matchDB", MODE_PRIVATE, null);

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
        finalizeTabAdapter = new TwoColumnAdapter(this, finalizeDataList);

        Resources res = getResources();

        String[] actionArray = res.getStringArray(R.array.action_array);

        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_1, R.id.btn_increment_action_1, R.id.entry_action_1, R.string.action_1, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_2, R.id.btn_increment_action_2, R.id.entry_action_2, R.string.action_2, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_3, R.id.btn_increment_action_3, R.id.entry_action_3, R.string.action_3, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_4, R.id.btn_increment_action_4, R.id.entry_action_4, R.string.action_4, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_5, R.id.btn_increment_action_5, R.id.entry_action_5, R.string.action_5, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_6, R.id.btn_increment_action_6, R.id.entry_action_6, R.string.action_6, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_7, R.id.btn_increment_action_7, R.id.entry_action_7, R.string.action_7, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_8, R.id.btn_increment_action_8, R.id.entry_action_8, R.string.action_8, 0));
        actionObjectArrayList.add(new ActionObject(R.id.btn_decrement_action_9, R.id.btn_increment_action_9, R.id.entry_action_9, R.string.action_9, 0));

        //matchDB.execSQL("CREATE TABLE IF NOT EXISTS team_match");

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                // If string is identical
                ListView finalizeDataView = (ListView) findViewById(R.id.finalizeDataView);

                finalizeDataList.clear();

                for ( ActionObject i : actionObjectArrayList) {
                    finalizeDataList.add(new Pair<>(getString(i.getTextFieldValueId()), String.valueOf(i.getActionCount())));
                }


                finalizeDataView.setAdapter(finalizeTabAdapter);

                if (s.compareTo("tab3") == 0) {



                }
            }
        });

    }


    @Override
    public void onClick(View view) {
        int index = 0;
        boolean decrement = false;
        Intent mainScreen = new Intent(this, MatchConfirmationActivity.class);
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

            case R.id.btn_auto_back:
                // Moves back to main screen
                startActivity(mainScreen);
                break;

            case R.id.btn_auto_next:
                // Moves to Teleop Tab
                getTabHost().setCurrentTabByTag("tab2");
                break;

            case R.id.btn_teleop_back:
                // Moves to Auto Tab
                getTabHost().setCurrentTabByTag("tab1");
                break;

            case R.id.btn_teleop_next:
                // Moves to finalize
                getTabHost().setCurrentTabByTag("tab3");
                break;

            case R.id.btn_finalize_back:
                // Moves to Teleop
                getTabHost().setCurrentTabByTag("tab2");
                break;

            case R.id.btn_finalize_finish:
                // Moves back to main screen, Starts a Toast, and Adds enties

                Log.d("Insert", "Inserting Match");
                matchDBHolder db = new matchDBHolder(this);

                HashMap<String, String> tempMap = new HashMap<>();

                for (Pair<String, String> i : finalizeDataList) {
                    tempMap.put(i.first, i.second);
                }
                db.addMatch(new Match(tempMap, "1425"));



                for(Match m : db.getAllMatches() ) {
                    Log.d("Team id", m.team_id);
                }

                startActivity(mainScreen);
                break;

        }
        ActionObject tempObject = actionObjectArrayList.get(index);
        tempObject.changeValue(decrement);

        EditText tempTextView = (EditText) findViewById(tempObject.getTextFieldId());
        if (tempTextView != null) {
            tempTextView.setText(String.valueOf(tempObject.getActionCount()));
        } else {
            Toast.makeText(ScoutingActivity.this, "View is NULL", Toast.LENGTH_SHORT).show();
        }
    }

}
