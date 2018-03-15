package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.adapters.TwoColumnAdapter;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionCreationData;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;
import wilsonvillerobotics.com.xeroscoutercollect.models.TeamMatchActionModel;
import wilsonvillerobotics.com.xeroscoutercollect.utils.Stopwatch;

import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.AUTO;
import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.CLIMB;
import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.FINALIZE;
import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.TELEOP;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TeleopScoutingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeleopScoutingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeleopScoutingFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_ENTRY_VALUE = "entryValues";
    private static final String ARG_QUERY_LIST = "queryList";
    private static final String ARG_ACTION_OBJECTS = "actionObjects";

    private HashMap<String, Integer> entryValues;
    private ArrayList<ActionObject> actionObjects;

    private OnFragmentInteractionListener mListener;

    protected ArrayList<ActionObject> actionObjectArrayList = new ArrayList<>();
    protected HashMap<Integer, ActionCreationData> actionDataMap = new HashMap<>();

    //Map containing entries and their values for a given TeamMatch scouted
    protected ArrayList<String> queryStringList = new ArrayList<>();
    protected DatabaseHelper dbHelper;
    String tablet_uuid;

    private ScoutingActivity parentActivity = (ScoutingActivity) getActivity();


    public TeleopScoutingFragment() {
    }

    public static TeleopScoutingFragment newInstance(HashMap<String, Integer> entryValues, ArrayList<String> queryList) {
        TeleopScoutingFragment fragment = new TeleopScoutingFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ENTRY_VALUE, new HashMap<String, Integer>());
        args.putSerializable(ARG_QUERY_LIST, new ArrayList<String>());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            entryValues = (HashMap<String, Integer>) getArguments().getSerializable(ARG_ENTRY_VALUE);
            actionObjects = (ArrayList<ActionObject>) getArguments().getSerializable(ARG_ACTION_OBJECTS);
            queryStringList = getArguments().getStringArrayList(ARG_QUERY_LIST);
        }

        queryStringList = new ArrayList<>();
        super.onCreate(savedInstanceState);

        ScoutingActivity parentActivity = (ScoutingActivity) getActivity();

        String[] actionArray = getResources().getStringArray(R.array.action_array);

        dbHelper = DatabaseHelper.getInstance(parentActivity.getApplicationContext());
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
        return inflater.inflate(R.layout.fragment_teleop_scouting, container, false);
    }

    @Override
    public void onActivityCreated(Bundle onSavedInstanceState) {
        super.onActivityCreated(onSavedInstanceState);
        parentActivity = (ScoutingActivity) getActivity();
        parentActivity.setIsStateChanging(false);
        Button teleopBackButton = (Button) parentActivity.findViewById(R.id.btn_tele_back);
        teleopBackButton.setOnClickListener(this);
        Button teleopNextButton = (Button) parentActivity.findViewById(R.id.btn_tele_next);
        teleopNextButton.setOnClickListener(this);

        Resources res = getResources();
        String packageName = parentActivity.getPackageName();

        for (int i = 1; i < 8; i++) {

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

        for (int i = 1; i < 8; i++) {
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
        parent.setIsStateChanging(false);
        switch (buttonId) {
            case R.id.btn_tele_next:
                for (ActionObject i : actionObjectArrayList) {
                    entryValues.put(getResources().getResourceEntryName(i.getTextFieldId()), i.getActionCount());
                }
                parent.changeState(CLIMB, entryValues, queryStringList);
                break;
            case R.id.btn_tele_back:
                for (ActionObject i : actionObjectArrayList) {
                    entryValues.put(getResources().getResourceEntryName(i.getTextFieldId()), i.getActionCount());
                }
                parent.changeState(AUTO, entryValues, queryStringList);
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
                            outputActionId = 44;
                            break;
                        case 2:
                            outputActionId = 46;
                            break;
                        case 3:
                            outputActionId = 34;
                            break;
                        case 4:
                            outputActionId = 35;
                            break;
                        case 5:
                            outputActionId = 43;
                            break;
                        case 6:
                            outputActionId = 36;
                            break;
                        case 7:
                            outputActionId = 47;
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
            parentActivity.updateQueryList(queryStringList);
            parentActivity.updateEntryValues(entryValues);
        }
        super.onDestroy();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
