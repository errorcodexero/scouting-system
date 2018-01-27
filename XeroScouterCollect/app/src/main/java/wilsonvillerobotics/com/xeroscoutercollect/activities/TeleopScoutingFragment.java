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
import android.widget.LinearLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.adapters.TwoColumnAdapter;
import wilsonvillerobotics.com.xeroscoutercollect.database.DatabaseHelper;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionCreationData;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;
import wilsonvillerobotics.com.xeroscoutercollect.utils.Stopwatch;

import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.FINALIZE;

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
    private boolean didCleanExit = false;
    private boolean doRemoveOldData = false;
    protected int currentClickedId;
    //protected SQLiteDatabase matchDB = openOrCreateDatabase("matchDB", MODE_PRIVATE, null);
    protected DatabaseHelper dbHelper;
    String tablet_uuid;
    private Boolean doSaveToFile = true;
    private boolean doAskRestore = true;
    private boolean didCompleteMatch = false;

    public TeleopScoutingFragment() {}

    public static TeleopScoutingFragment newInstance(HashMap<String, Integer> entryValues) {
        TeleopScoutingFragment fragment = new TeleopScoutingFragment();
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

        Resources res = getResources();

        String packageName = parentActivity.getPackageName();

        int j = 1;

        for (int i = 34; i < 46; i++) {
            int offset = (i - 1);
            if (i == 37 || i == 38 || i == 39 || i == 40 || i == 42)

                continue;

            int test1 = res.getIdentifier("btn_action_" + j + "_incr", "id", packageName);
            int test2 = res.getIdentifier("btn_action_" + j + "_decr", "id", packageName);
            int test3 = res.getIdentifier("edittext_action_" + j, "id", packageName);
            String strIncId = "btn_action_" + j + "_incr";
            String strDecId = "btn_action_" + j + "_decr";
            String strEditTextId = "edittext_action_" + j;
            actionObjectArrayList.add(new ActionObject(res.getIdentifier(strDecId, "id", packageName),
                    res.getIdentifier(strIncId, "id", packageName),
                    res.getIdentifier(strEditTextId, "id", packageName),
                    res.getIdentifier(strEditTextId, "id", packageName), 0));
            j++;
        }

        for (int i = 34; i < 46; i++) {
            String strIncId = "btn_action_" + (i - 33) + "_incr";
            String strDecId = "btn_action_" + (i - 33) + "_decr";
            String editTextId = "edittext_action_" + (i - 33);

            actionDataMap.put(res.getIdentifier(strIncId, "id", packageName), new ActionCreationData(false, i));
            actionDataMap.put(res.getIdentifier(strDecId, "id", packageName), new ActionCreationData(true, i));
            actionDataMap.put(res.getIdentifier(editTextId, "id", packageName), new ActionCreationData(null, i));
        }
        dbHelper = DatabaseHelper.getInstance(parentActivity.getApplicationContext());
        // Mildly proud I fit this in one line

        //void test[] = {findViewById(elem.getDecrementButtonId()).setOnClickListener(this), findViewById(elem.getDecrementButtonId()).setOnClickListener(this)};

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(parentActivity);
        String pref_default = "*";
        tablet_uuid = sharedPreferences.getString(getString(R.string.uuid_value_pref), pref_default);

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
        Button finalizeButton = (Button) parentActivity.findViewById(R.id.btn_finalize);
        finalizeButton.setOnClickListener(this);
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
    public void onClick(View v) {
        int buttonId = v.getId();
        switch (buttonId) {
            case R.id.btn_finalize_finish:
                ((ScoutingActivity) getActivity()).changeState(FINALIZE, entryValues);
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
