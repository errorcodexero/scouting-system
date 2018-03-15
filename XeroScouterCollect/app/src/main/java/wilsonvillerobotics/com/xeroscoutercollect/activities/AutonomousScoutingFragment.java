package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.adapters.TwoColumnAdapter;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionCreationData;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;
import wilsonvillerobotics.com.xeroscoutercollect.models.TeamMatchActionModel;

import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.FINALIZE;
import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.TELEOP;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AutonomousScoutingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AutonomousScoutingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AutonomousScoutingFragment extends Fragment implements View.OnClickListener{

    private static final String ARG_ENTRY_VALUE = "entryValues";
    private static final String ARG_QUERY_LIST= "queryList";

    private HashMap<String, Integer> entryValues;

    private OnFragmentInteractionListener mListener;

    protected ArrayList<ActionObject> actionObjectArrayList = new ArrayList<>();
    protected HashMap<Integer, ActionCreationData> actionDataMap = new HashMap<>();

    //Map containing entries and their values for a given TeamMatch scouted
    protected HashMap<String, Integer> entryValueMap = new HashMap<>();
    protected ArrayList<Pair<String, String>> finalizeDataList = new ArrayList<>();
    protected ArrayList<String> queryStringList = new ArrayList<>();
    protected TwoColumnAdapter finalizeTabAdapter;
    private ScoutingActivity parentActivity = (ScoutingActivity) getActivity();
    String tablet_uuid;

    Resources res;

    public AutonomousScoutingFragment() {}

    public static AutonomousScoutingFragment newInstance(HashMap<String, Integer> entryValues, ArrayList<String> queryList) {
        AutonomousScoutingFragment fragment = new AutonomousScoutingFragment();
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
        res = parentActivity.getResources();

        String[] actionArray = getResources().getStringArray(R.array.action_array);

        parentActivity.dbHelper = DatabaseHelper.getInstance(parentActivity.getApplicationContext());
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
            queryStringList = (ArrayList<String>) getArguments().getSerializable(ARG_QUERY_LIST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_autonomous_scouting, container, false);
    }

    @Override
    public void onActivityCreated(Bundle onSavedInstanceState) {
        super.onActivityCreated(onSavedInstanceState);
        parentActivity = (ScoutingActivity) getActivity();
        parentActivity.setIsStateChanging(false);
        ScoutingActivity parentActivity = (ScoutingActivity) getActivity();
        Button autoNextButton = (Button) parentActivity.findViewById(R.id.btn_auto_next);
        autoNextButton.setOnClickListener(this);
        Button autoBackButton = (Button) parentActivity.findViewById(R.id.btn_auto_back);
        autoBackButton.setOnClickListener(this);
        String packageName = parentActivity.getPackageName();

        for (int i = 1; i < 4; i++) {

            int test1 = res.getIdentifier("btn_auto_action_" + i + "_incr", "id", packageName);
            int test2 = res.getIdentifier("btn_auto_action_" + i + "_decr", "id", packageName);
            int test3 = res.getIdentifier("edittext_auto_action_" + i, "id", packageName);
            String strIncId = "btn_auto_action_" + i + "_incr";
            String strDecId = "btn_auto_action_" + i + "_decr";
            String strEditTextId = "edittext_auto_action_" + i;
            actionObjectArrayList.add(new ActionObject(res.getIdentifier(strDecId, "id", packageName),
                    res.getIdentifier(strIncId, "id", packageName),
                    res.getIdentifier(strEditTextId, "id", packageName),
                    res.getIdentifier(strEditTextId, "id", packageName), 0));
        }

        for (int i = 1; i < 4; i++) {
            String strIncId = "btn_auto_action_" + i + "_incr";
            String strDecId = "btn_auto_action_" + i + "_decr";
            String editTextId = "edittext_auto_action_" + i;

            actionDataMap.put(res.getIdentifier(strIncId, "id", packageName), new ActionCreationData(false, i));
            actionDataMap.put(res.getIdentifier(strDecId, "id", packageName), new ActionCreationData(true, i));
            actionDataMap.put(res.getIdentifier(editTextId, "id", packageName), new ActionCreationData(null, i));
        }


        for (ActionObject elem : actionObjectArrayList) {
            Button incrementButton = (Button) getActivity().findViewById(elem.getIncrementButtonId());
            Button decrementButton = (Button) getActivity().findViewById(elem.getDecrementButtonId());
            incrementButton.setOnClickListener(this);
            decrementButton.setOnClickListener(this);
            try {
                elem.setActionCount(entryValues.get(getResources().getResourceEntryName(elem.getTextFieldId())));
                ((TextView) parentActivity.findViewById(elem.getTextFieldId())).invalidate();
            } catch (Exception e ) {
                Log.d("ERROR", e.getStackTrace().toString());
            }
        }

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
            case R.id.btn_auto_back:
                Intent sanityCheckActivity = new Intent(parent, SanityCheckActivity.class);
                sanityCheckActivity.putExtra("background", parentActivity.isRed);
                sanityCheckActivity.putExtra("team_number", parentActivity.teamNumber);
                sanityCheckActivity.putExtra("team_match_id", parentActivity.teamMatchId);
                startActivity(sanityCheckActivity);
                break;
            case R.id.btn_auto_next:
                for (ActionObject i : actionObjectArrayList) {
                    entryValues.put(getResources().getResourceEntryName(i.getTextFieldId()), i.getActionCount());
                }
                entryValues.put("auto_action_1_chkbx", ((CheckBox) parent.findViewById(R.id.auto_action_1_chkbx)).isChecked()? 1: 0);
                parent.changeState(TELEOP, entryValues, queryStringList);
                break;
            default:
                ActionCreationData actionData = actionDataMap.get(view.getId());
                int actionId = actionData.getAction_id();
                int id = view.getId();
                boolean belowZero = false;
                int outputActionId = 0;
                if (buttonId != 0) {

                    switch (actionId) {
                        case 1:
                            outputActionId = 31;
                            break;
                        case 2:
                            outputActionId = 33;
                            break;
                        case 3:
                            outputActionId = 30;
                            break;

                    }

                    //Toast.makeText(ScoutingActivity_Back.this, queryString, Toast.LENGTH_SHORT).show();
                    ActionObject tempObject = actionObjectArrayList.get(actionId - 1);
                    tempObject.changeValue(actionData.getDecrement());

                    EditText tempTextView = (EditText) getActivity().findViewById(tempObject.getTextFieldId());
                    if (tempTextView != null) {
                        tempTextView.setText(String.valueOf(tempObject.getActionCount()));
                        try {
                            //db.execSQL(TeamMatchActionModel.addAction(tabletId, teamMatchId, action_id, actionData.getDecrement()));
                            queryStringList.add(TeamMatchActionModel.addAction(tablet_uuid, parent.teamMatchId, outputActionId, actionData.getDecrement()));
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

    @Override
    public void onDestroy() {

        if (parentActivity.getIsStateChanging()) {
            super.onDestroy();
            return;
        } else {
            for (ActionObject i : actionObjectArrayList) {
                entryValues.put(getResources().getResourceEntryName(i.getTextFieldId()), i.getActionCount());
            }
            queryStringList.add(TeamMatchActionModel.addAction(tablet_uuid, parentActivity.teamMatchId, 32, false));
            entryValues.put("auto_action_1_chkbx", ((CheckBox) parentActivity.findViewById(R.id.auto_action_1_chkbx)).isChecked()? 1: 0);
            parentActivity.updateEntryValues(entryValues);
            parentActivity.updateQueryList(queryStringList);
        }
        super.onDestroy();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}