package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;
import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.database.TeamMatch;
import wilsonvillerobotics.com.xeroscoutercollect.adapters.TwoColumnAdapter;
import wilsonvillerobotics.com.xeroscoutercollect.models.TeamMatchActionModel;

public class ScoutingActivity extends TabActivity implements View.OnClickListener {

    protected HashMap<Integer, Integer> matchMap = new HashMap<>();

    protected ArrayList<ActionObject> actionObjectArrayList = new ArrayList<>();

    protected ArrayList<Pair<String, String>> finalizeDataList = new ArrayList<>();

    protected TwoColumnAdapter finalizeTabAdapter;

    //protected SQLiteDatabase matchDB = openOrCreateDatabase("matchDB", MODE_PRIVATE, null);

    protected TeamMatch currentMatch = new TeamMatch();

    protected DatabaseHelper dbHelper;

    int tabletId, teamMatchId;

    protected String generateTransaction() {
        return null;


    }


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

        //DatabaseHelper tempDB = new DatabaseHelper(this);

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

        dbHelper = DatabaseHelper.getInstance(getApplicationContext());

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String pref_default = "*";

        tabletId = Integer.valueOf(sharedPreferences.getString(getString(R.string.tablet_id_pref), pref_default));
        teamMatchId = 34;

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
        int index = -1;
        boolean decrement = false;
        Intent mainScreen = new Intent(this, MatchConfirmationActivity.class);
        String queryString = "";
        switch (view.getId()) {

            // Doing that young fallthough

            case R.id.btn_decrement_action_1:
                index = 0;
                decrement = true;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_decrement_action_2:
                index = 1;
                decrement = true;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_decrement_action_3:
                index = 2;
                decrement = true;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_decrement_action_4:
                index = 3;
                decrement = true;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_decrement_action_5:
                index = 4;
                decrement = true;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_decrement_action_6:
                index = 5;
                decrement = true;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_decrement_action_7:
                index = 6;
                decrement = true;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_decrement_action_8:
                index = 7;
                decrement = true;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_decrement_action_9:
                index = 8;
                decrement = true;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_increment_action_1:
                index = 0;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_increment_action_2:
                index = 1;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_increment_action_3:
                index = 2;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_increment_action_4:
                index = 3;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_increment_action_5:
                index = 4;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_increment_action_6:
                index = 5;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_increment_action_7:
                index = 6;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_increment_action_8:
                index = 7;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
                break;

            case R.id.btn_increment_action_9:
                index = 8;
                queryString = TeamMatchActionModel.addAction(tabletId, teamMatchId, index + 1, decrement);
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

                /*Log.d("Insert", "Inserting Match");
                matchDBHelper matchDBHelper = new matchDBHelper(this, );

                SQLiteDatabase db = matchDBHelper.getWritableDatabase();

                HashMap<String, String> tempMap = new HashMap<>();

                for (Pair<String, String> i : finalizeDataList) {
                    tempMap.put(i.first, i.second);
                }
                matchDBHelper.addMatch(new Match(tempMap, "1425"));

                */




                startActivity(mainScreen);
                break;

        }


        if (index != -1) {
            //Toast.makeText(ScoutingActivity.this, queryString, Toast.LENGTH_SHORT).show();
            ActionObject tempObject = actionObjectArrayList.get(index);
            tempObject.changeValue(decrement);

            EditText tempTextView = (EditText) findViewById(tempObject.getTextFieldId());
            if (tempTextView != null) {
                tempTextView.setText(String.valueOf(tempObject.getActionCount()));
                //Toast.makeText(ScoutingActivity.this, getResources().getResourceEntryName(tempObject.getTextFieldId()), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ScoutingActivity.this, "View is NULL", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
