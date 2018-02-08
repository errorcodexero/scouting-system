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
import android.widget.EditText;
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
    private static final String ARG_ACTION_OBJECTS = "actionObjects";

    private HashMap<String, Integer> entryValues;
    private ArrayList<ActionObject> actionObjects;

    private OnFragmentInteractionListener mListener;


    protected ArrayList<ActionObject> actionObjectArrayList = new ArrayList<>();
    protected HashMap<Integer, ActionCreationData> actionDataMap = new HashMap<>();

    //Map containing entries and their values for a given TeamMatch scouted
    protected HashMap<String, Integer> entryValueMap = new HashMap<>();
    protected ArrayList<Pair<String, String>> finalizeDataList = new ArrayList<>();
    protected ArrayList<String> queryStringList = new ArrayList<>();
    protected TwoColumnAdapter finalizeTabAdapter;
    private ScoutingActivity parentActivity = (ScoutingActivity) getActivity();
    String packageName = parentActivity.getPackageName();
    String tablet_uuid;

    Resources res = parentActivity.getResources();

    public AutonomousScoutingFragment() {}

    public static AutonomousScoutingFragment newInstance(HashMap<String, Integer> entryValues) {
        AutonomousScoutingFragment fragment = new AutonomousScoutingFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ENTRY_VALUE, new HashMap<String, Integer>());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            entryValues = (HashMap<String, Integer>) getArguments().getSerializable(ARG_ENTRY_VALUE);
            actionObjects = (ArrayList<ActionObject>) getArguments().getSerializable(ARG_ACTION_OBJECTS);
        }
        super.onCreate(savedInstanceState);

        ScoutingActivity parentActivity = (ScoutingActivity) getActivity();

        String[] actionArray = getResources().getStringArray(R.array.action_array);

        parentActivity.dbHelper = DatabaseHelper.getInstance(parentActivity.getApplicationContext());
        // Mildly proud I fit this in one line

        //void test[] = {findViewById(elem.getDecrementButtonId()).setOnClickListener(this), findViewById(elem.getDecrementButtonId()).setOnClickListener(this)};

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(parentActivity);
        String pref_default = "*";
        tablet_uuid = sharedPreferences.getString(getString(R.string.uuid_value_pref), pref_default);

        actionObjectArrayList.get(0);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teleop_scouting, container, false);
    }

    @Override
    public void onActivityCreated(Bundle onSavedInstanceState) {
        super.onActivityCreated(onSavedInstanceState);
        ScoutingActivity parentActivity = (ScoutingActivity) getActivity();
        Button autoNextButton = (Button) parentActivity.findViewById(R.id.btn_auto_next);
        autoNextButton.setOnClickListener(this);
        Button autoBackButton = (Button) parentActivity.findViewById(R.id.btn_auto_back);
        autoBackButton.setOnClickListener(this);


        for (int i = 0; i < 12; i++) {

            int test1 = res.getIdentifier("btn_action_" + i + "_incr", "id", packageName);
            int test2 = res.getIdentifier("btn_action_" + i + "_decr", "id", packageName);
            int test3 = res.getIdentifier("edittext_action_" + i, "id", packageName);
            String strIncId = "btn_action_" + i + "_incr";
            String strDecId = "btn_action_" + i + "_decr";
            String strEditTextId = "edittext_action_" + i;
            actionObjectArrayList.add(new ActionObject(res.getIdentifier(strDecId, "id", packageName),
                    res.getIdentifier(strIncId, "id", packageName),
                    res.getIdentifier(strEditTextId, "id", packageName),
                    res.getIdentifier(strEditTextId, "id", packageName), 0));
        }

        for (int i = 0; i < 12; i++) {
            String strIncId = "btn_action_" + i + "_incr";
            String strDecId = "btn_action_" + i + "_decr";
            String editTextId = "edittext_action_" + i;

            actionDataMap.put(res.getIdentifier(strIncId, "id", packageName), new ActionCreationData(false, i));
            actionDataMap.put(res.getIdentifier(strDecId, "id", packageName), new ActionCreationData(true, i));
            actionDataMap.put(res.getIdentifier(editTextId, "id", packageName), new ActionCreationData(null, i));
        }

        for (ActionObject elem : actionObjectArrayList) {
            Button incrementButton = (Button) getActivity().findViewById(elem.getIncrementButtonId());
            Button decrementButton = (Button) getActivity().findViewById(elem.getDecrementButtonId());
            incrementButton.setOnClickListener(this);
            decrementButton.setOnClickListener(this);
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
                Intent sanityCheck = new Intent(parent, SanityCheckActivity.class);

                startActivity(sanityCheck);
                break;
            case R.id.btn_auto_next:
                parent.changeState(TELEOP, entryValues);
                break;
            default:
                int id = view.getId();
                ActionCreationData actionData = actionDataMap.get(view.getId());
                int actionId = actionData.getAction_id();
                boolean belowZero = false;
                if (buttonId != 0) {

                    //Toast.makeText(ScoutingActivity_Back.this, queryString, Toast.LENGTH_SHORT).show();
                    ActionObject tempObject = actionObjectArrayList.get((buttonId - 1) - 33);
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