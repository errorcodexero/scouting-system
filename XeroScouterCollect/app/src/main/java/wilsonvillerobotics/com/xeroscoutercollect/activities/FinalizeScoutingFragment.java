package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.adapters.TwoColumnAdapter;
import wilsonvillerobotics.com.xeroscoutercollect.models.ActionObject;

import static wilsonvillerobotics.com.xeroscoutercollect.activities.ScoutingActivity.ScoutingState.FINALIZE;

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
    private static final String ARG_ACTION_OBJECTS = "actionObjects";

    private HashMap<String, Integer> entryValues;
    private ArrayList<ActionObject> actionObjects;

    private OnFragmentInteractionListener mListener;

    public FinalizeScoutingFragment() {}

    public static TeleopScoutingFragment newInstance(String param1, String param2) {
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finalize_scouting, container, false);
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
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
