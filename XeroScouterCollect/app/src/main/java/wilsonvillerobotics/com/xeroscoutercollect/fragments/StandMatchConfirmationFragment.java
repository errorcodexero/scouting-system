package wilsonvillerobotics.com.xeroscoutercollect.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import wilsonvillerobotics.com.xeroscoutercollect.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StandMatchConfirmationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StandMatchConfirmationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StandMatchConfirmationFragment extends Fragment {

    private Spinner spinner_match_list;
    private Spinner spinner_team_list;
    private Button btn_next;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public StandMatchConfirmationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StandMatchConfirmationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StandMatchConfirmationFragment newInstance(String param1, String param2) {
        StandMatchConfirmationFragment fragment = new StandMatchConfirmationFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (getArguments() != null) {
        //    mParam1 = getArguments().getString(ARG_PARAM1);
        //    mParam2 = getArguments().getString(ARG_PARAM2);
        //}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //TextView textView = new TextView(getActivity());
        //textView.setText(R.string.hello_blank_fragment);
        //return textView;
        View view = inflater.inflate(R.layout.fragment_stand_match_confirmation, container, false);

        spinner_match_list = (Spinner) view.findViewById(R.id.spinner_match_list);
        spinner_team_list = (Spinner) view.findViewById(R.id.spinner_team_list);
        btn_next = (Button) view.findViewById(R.id.btn_next);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public Spinner getMatchListSpinner()
    {
        return spinner_match_list;
    }

    public Spinner getTeanListSpinner()
    {
        return spinner_team_list;
    }

    public Button getNextButton()
    {
        return btn_next;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            //throw new RuntimeException(context.toString()
            //        + " must implement OnFragmentInteractionListener");
            mListener = null;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
