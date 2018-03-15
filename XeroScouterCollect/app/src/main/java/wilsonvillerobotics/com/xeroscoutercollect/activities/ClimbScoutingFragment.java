package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.adapters.TwoColumnAdapter;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionCreationData;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;
import wilsonvillerobotics.com.xeroscoutercollect.models.TeamMatchActionModel;

import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.AUTO;
import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.FINALIZE;
import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.TELEOP;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ClimbScoutingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ClimbScoutingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClimbScoutingFragment extends Fragment implements View.OnClickListener{

private static final String ARG_ENTRY_VALUE = "entryValues";
private static final String ARG_QUERY_LIST = "queryList";
private static final String ARG_ACTION_OBJECTS = "actionObjects";

private int currentlyChecked = 3;
private int currentlyCheckedAssist = 1;

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


public ClimbScoutingFragment() {}

public static ClimbScoutingFragment newInstance(HashMap<String, Integer> entryValues, ArrayList<String> queryList) {
        ClimbScoutingFragment fragment = new ClimbScoutingFragment();
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

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(parentActivity);
        String pref_default = "*";
        tablet_uuid = sharedPreferences.getString(getString(R.string.uuid_value_pref), pref_default);

        try {
            entryValues = (HashMap<String, Integer>) savedInstanceState.getSerializable("ENTRYVALUES");
            queryStringList = savedInstanceState.getStringArrayList("QUERYSTRING");
            currentlyChecked = entryValues.get("climb_option");
            currentlyCheckedAssist = entryValues.get("climb_option_assist");
        } catch (Exception e ) {
        //Don't care at all
        }

        if (getArguments() != null) {
            entryValues = (HashMap<String, Integer>) getArguments().getSerializable(ARG_ENTRY_VALUE);
            queryStringList = getArguments().getStringArrayList(ARG_QUERY_LIST);
        }

        //actionObjectArrayList.get(0);

        }


// TODO: Rename method, update argument and hook method into UI event
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
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onRadioButtonClicked(View view) {

        RadioButton climbButton = (RadioButton) parentActivity.findViewById(R.id.climb_radio);
        RadioButton climbAssist0Button = (RadioButton) parentActivity.findViewById(R.id.climb_assist_0_radio);
        RadioButton climbAssist1Button = (RadioButton) parentActivity.findViewById(R.id.climb_assist_1_radio);
        RadioButton climbAssist2Button = (RadioButton) parentActivity.findViewById(R.id.climb_assist_2_radio);
        RadioButton piggybackButton = (RadioButton) parentActivity.findViewById(R.id.climb_piggyback_radio);
        RadioButton noClimbButton = (RadioButton) parentActivity.findViewById(R.id.no_climb_radio);

        switch(view.getId()) {
            case R.id.climb_radio:

                piggybackButton.setChecked(false);
                noClimbButton.setChecked(false);
                currentlyChecked = 1;
                break;
            case R.id.climb_assist_0_radio:
                climbAssist1Button.setChecked(false);
                climbAssist2Button.setChecked(false);
                currentlyCheckedAssist = 1;
                break;
            case R.id.climb_assist_1_radio:

                climbAssist0Button.setChecked(false);
                climbAssist2Button.setChecked(false);
                currentlyCheckedAssist = 2;
                break;
            case R.id.climb_assist_2_radio:

                climbAssist0Button.setChecked(false);
                climbAssist1Button.setChecked(false);
                currentlyCheckedAssist = 3;
                break;
            case R.id.climb_piggyback_radio:

                climbButton.setChecked(false);
                noClimbButton.setChecked(false);
                currentlyChecked = 2;
                break;
            case R.id.no_climb_radio:

                piggybackButton.setChecked(false);
                climbButton.setChecked(false);
                currentlyChecked = 3;
                break;
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_climb_scouting, container, false);
    }

    @Override
    public void onActivityCreated(Bundle onSavedInstanceState) {
        super.onActivityCreated(onSavedInstanceState);
        parentActivity = (ScoutingActivity) getActivity();
        parentActivity.setIsStateChanging(false);
        //parentActivity.findViewById(R.id.btn_finalize_back).setOnClickListener(this);
        Button climbBack = (Button) parentActivity.findViewById(R.id.btn_climb_back);
        climbBack.setOnClickListener(this);
        Button climbNext = (Button) parentActivity.findViewById(R.id.btn_climb_next);
        climbNext.setOnClickListener(this);

        RadioButton climbButton = (RadioButton) parentActivity.findViewById(R.id.climb_radio);
        climbButton.setOnClickListener(this::onRadioButtonClicked);

        RadioButton climbAssist0Button = (RadioButton) parentActivity.findViewById(R.id.climb_assist_0_radio);
        climbAssist0Button.setOnClickListener(this::onRadioButtonClicked);

        RadioButton climbAssist1Button = (RadioButton) parentActivity.findViewById(R.id.climb_assist_1_radio);
        climbAssist1Button.setOnClickListener(this::onRadioButtonClicked);

        RadioButton climbAssist2Button = (RadioButton) parentActivity.findViewById(R.id.climb_assist_2_radio);
        climbAssist2Button.setOnClickListener(this::onRadioButtonClicked);

        RadioButton piggybackButton = (RadioButton) parentActivity.findViewById(R.id.climb_piggyback_radio);
        piggybackButton.setOnClickListener(this::onRadioButtonClicked);

        RadioButton noClimbButton = (RadioButton) parentActivity.findViewById(R.id.no_climb_radio);
        noClimbButton.setOnClickListener(this::onRadioButtonClicked);


        switch (currentlyChecked) {
            case 1:
                climbButton.setChecked(true);
                break;
            case 2:
                piggybackButton.setChecked(true);
                break;
            case 3:
                noClimbButton.setChecked(true);
                break;
        }
        switch (currentlyCheckedAssist) {
            case 1:
                climbAssist0Button.setChecked(true);
                break;
            case 2:
                climbAssist1Button.setChecked(true);
                break;
            case 3:
                climbAssist2Button.setChecked(true);
                break;

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_climb_back:
                entryValues.put("climb_option", currentlyChecked);
                entryValues.put("climb_option_assist", currentlyCheckedAssist);
                parentActivity.changeState(TELEOP, entryValues, queryStringList);
                break;
            case R.id.btn_climb_next:
                entryValues.put("climb_option", currentlyChecked);
                entryValues.put("climb_option_assist", currentlyCheckedAssist);
                switch (currentlyChecked) {
                    case 1:
                        queryStringList.add(TeamMatchActionModel.addAction(tablet_uuid, parentActivity.teamMatchId, 39, false));
                        break;
                    case 2:
                        queryStringList.add(TeamMatchActionModel.addAction(tablet_uuid, parentActivity.teamMatchId, 38, false));
                        break;
                    case 3:
                        break;
                }
                switch (currentlyCheckedAssist) {
                    case 1:
                        break;
                    case 2:
                        queryStringList.add(TeamMatchActionModel.addAction(tablet_uuid, parentActivity.teamMatchId, 40, false));
                        break;
                    case 3:
                        queryStringList.add(TeamMatchActionModel.addAction(tablet_uuid, parentActivity.teamMatchId, 40, false));
                        queryStringList.add(TeamMatchActionModel.addAction(tablet_uuid, parentActivity.teamMatchId, 40, false));
                        break;

                }
                parentActivity.changeState(FINALIZE, entryValues, queryStringList);
                break;
        }
    }

    @Override
    public void onDestroy() {

        if (parentActivity.getIsStateChanging()) {
            super.onDestroy();
            return;
        } else {

            entryValues.put("climb_option", currentlyChecked);
            entryValues.put("climb_option_assist", currentlyCheckedAssist);
            parentActivity.updateQueryList(queryStringList);
            parentActivity.updateEntryValues(entryValues);
        }
        super.onDestroy();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
