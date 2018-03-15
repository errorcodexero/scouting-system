package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.adapters.TwoColumnAdapter;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionCreationData;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;
import wilsonvillerobotics.com.xeroscoutercollect.models.TeamMatchActionModel;

import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.CLIMB;
import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.FINALIZE;
import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.TELEOP;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FinalizeScoutingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FinalizeScoutingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FinalizeScoutingFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_ENTRY_VALUE = "entryValues";
    private static final String ARG_QUERY_LIST = "queryList";

    private HashMap<String, Integer> entryValues;
    private ArrayList<ActionObject> actionObjects;

    private OnFragmentInteractionListener mListener;


    protected ArrayList<ActionObject> actionObjectArrayList = new ArrayList<>();
    protected HashMap<Integer, ActionCreationData> actionDataMap = new HashMap<>();

    //Map containing entries and their values for a given TeamMatch scouted
    protected ArrayList<Pair<String, String>> finalizeDataList = new ArrayList<>();
    protected ArrayList<String> queryStringList = new ArrayList<>();
    protected TwoColumnAdapter finalizeTabAdapter;
    protected ListView finalizeView;
    private boolean didCleanExit = false;
    private boolean doRemoveOldData = false;
    //protected SQLiteDatabase matchDB = openOrCreateDatabase("matchDB", MODE_PRIVATE, null);
    protected DatabaseHelper dbHelper;
    String tablet_uuid;

    private ScoutingActivity parentActivity = (ScoutingActivity) getActivity();


    public FinalizeScoutingFragment() {}

    public static FinalizeScoutingFragment newInstance(HashMap<String, Integer> entryValues, ArrayList<String> queryList) {
        FinalizeScoutingFragment fragment = new FinalizeScoutingFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ENTRY_VALUE, new HashMap<String, Integer>());
        args.putSerializable(ARG_QUERY_LIST, new ArrayList<String>());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScoutingActivity parentActivity = (ScoutingActivity) getActivity();

        String[] actionArray = getResources().getStringArray(R.array.action_array);

        Resources res = getResources();

        String packageName = parentActivity.getPackageName();

        dbHelper = DatabaseHelper.getInstance(parentActivity.getApplicationContext());
        TwoColumnAdapter finalizeDataAdapter;
        ListView finalizeListView;
        // Mildly proud I fit this in one line

        //void test[] = {findViewById(elem.getDecrementButtonId()).setOnClickListener(this), findViewById(elem.getDecrementButtonId()).setOnClickListener(this)};

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(parentActivity);
        String pref_default = "*";
        tablet_uuid = sharedPreferences.getString(getString(R.string.uuid_value_pref), pref_default);

        try {
            entryValues = (HashMap<String, Integer>) savedInstanceState.getSerializable("ENTRYVALUES");
            queryStringList = savedInstanceState.getStringArrayList("QUERYSTRING");
        } catch (Exception e ) {
            //Don't care at all
        }

        if (getArguments() != null) {
            entryValues = (HashMap<String, Integer>) getArguments().getSerializable(ARG_ENTRY_VALUE);
            queryStringList = getArguments().getStringArrayList(ARG_QUERY_LIST);
        }

        //actionObjectArrayList.get(0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finalize_scouting, container, false);
    }

    @Override
    public void onActivityCreated(Bundle onSavedInstanceState) {
        super.onActivityCreated(onSavedInstanceState);
        parentActivity = (ScoutingActivity) getActivity();
        parentActivity.setIsStateChanging(false);
        //parentActivity.findViewById(R.id.btn_finalize_back).setOnClickListener(this);
        Button finalizeBack = (Button) parentActivity.findViewById(R.id.btn_finalize_back);
        finalizeBack.setOnClickListener(this);
        parentActivity.findViewById(R.id.btn_finalize_finish).setOnClickListener(this);
        Button finalizeFinish = (Button) parentActivity.findViewById(R.id.btn_finalize_finish);
        finalizeFinish.setOnClickListener(this);

        for (int i = 0; i < 12; i++) {
            String actionName = "";
            String actionTempName = "action_";

            if (i == 0 ) {
                actionName = "auto_action_" + (i + 1) + "_chkbx";
                actionTempName += (32);
                finalizeDataList.add(Pair.create(parentActivity.getResources().getString(parentActivity.getResources()
                        .getIdentifier(actionTempName, "string", parentActivity.getPackageName())), entryValues.get(actionName) == 1 ? "True" : "False"));
            } else if ( i < 4) {
                actionTempName = actionTempName + (i + 30);
                if (i == 2)
                    actionTempName = "action_30";
                actionName = "edittext_auto_action_" + (i);
                finalizeDataList.add(Pair.create(parentActivity.getResources().getString(parentActivity.getResources().getIdentifier(actionTempName, "string", parentActivity.getPackageName())), String.valueOf(entryValues.get(actionName))));
            } else if (i < 11){
                actionName = "edittext_action_" + (i - 3);

                int j = 0;

                if (i >= 7) {
                    j += 6;
                }
                actionTempName = actionTempName + (i + 30 + j);
                finalizeDataList.add(Pair.create(parentActivity.getResources().getString(parentActivity.getResources().getIdentifier(actionTempName, "string", parentActivity.getPackageName())), String.valueOf(entryValues.get(actionName))));
            } else {
                String climbType = "";
                int climbTypeInt = entryValues.get("climb_option");
                switch (climbTypeInt) {
                    case 1:
                        climbType = "Climb";
                        break;
                    case 2:
                        climbType = "Piggyback Climb";
                        break;
                    case 3:
                        climbType = "No Climb";
                        break;
                }
                int climbTypeAssistInt = entryValues.get("climb_option_assist");
                switch (climbTypeAssistInt) {
                    case 1:
                        climbType += " and Assist None";
                        break;
                    case 2:
                        climbType += " and Assist One";
                        break;
                    case 3:
                        climbType += " and Assist Two";
                        break;
                    default:
                        climbType = " and Assist None";
                        break;
                }
                finalizeDataList.add(Pair.create("Climb Type", climbType));
            }
        }
        finalizeView = (ListView) parentActivity.findViewById(R.id.finalize_list);
        finalizeTabAdapter = new TwoColumnAdapter(parentActivity, finalizeDataList);
        finalizeView.setAdapter(finalizeTabAdapter);

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } /*else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        int buttonId = view.getId();

        ScoutingActivity parent = (ScoutingActivity) getActivity();
        switch (buttonId) {
            case R.id.btn_finalize_finish:

                if(doRemoveOldData) {
                    parent.db.rawQuery("DELETE FROM 'team_match_action' WHERE `team_match_id` = " + parent.teamMatchId + ";", null );
                }

                didCleanExit = true;

                for (String queryStringInstance : queryStringList) {
                    parent.db.execSQL(queryStringInstance);
                }

                Intent mainScreen = new Intent(parent, MatchConfirmationActivity.class);

                startActivity(mainScreen);
            case R.id.btn_finalize_back:
                parent.changeState(CLIMB, entryValues, queryStringList);
                break;
            default:
                ActionCreationData actionData = actionDataMap.get(view.getId());
                int actionId = actionData.getAction_id();
                int id = view.getId();
                boolean belowZero = false;
                if (buttonId != 0) {

                    //Toast.makeText(ScoutingActivity_Back.this, queryString, Toast.LENGTH_SHORT).show();
                    ActionObject tempObject = actionObjectArrayList.get(actionId);
                    tempObject.changeValue(actionData.getDecrement());

                    EditText tempTextView = (EditText) getActivity().findViewById(tempObject.getTextFieldId());
                    if (tempTextView != null) {
                        tempTextView.setText(String.valueOf(tempObject.getActionCount()));
                        try {
                            //db.execSQL(TeamMatchActionModel.addAction(tabletId, teamMatchId, action_id, actionData.getDecrement()));
                            queryStringList.add(TeamMatchActionModel.addAction(tablet_uuid, parent.teamMatchId, buttonId, actionData.getDecrement()));
                        } finally {

                        }
                        //Toast.makeText(ScoutingActivity_Back.this, getResources().getResourceEntryName(tempObject.getTextFieldId()), Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getActivity(), "View is NULL", Toast.LENGTH_SHORT).show();
                    }
                    for (ActionObject spinBox : actionObjectArrayList) {
                        Button decrementButton = (Button) getActivity().findViewById(spinBox.getDecrementButtonId());
                        if (id == spinBox.getDecrementButtonId()) {

                            if (spinBox.getActionCount() < 1) {
                                belowZero = true;
                                decrementButton.setEnabled(false);
                            }
                            break;
                        } else if (!decrementButton.isEnabled()) {
                            decrementButton.setEnabled(true);
                        }
                    }
                    break;
                }
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}