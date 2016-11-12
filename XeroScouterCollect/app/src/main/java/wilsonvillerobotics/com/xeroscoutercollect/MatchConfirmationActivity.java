package wilsonvillerobotics.com.xeroscoutercollect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luke on 11/5/2016.
 */
public class MatchConfirmationActivity extends Activity implements View.OnClickListener{
    private Spinner spinner_match_list;
    private Button btn_next;
    private Intent sanityCheckActivity;
    private List<String> match_list;
    private ArrayList<Integer> team_list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_confirmation);

        addItemsOnSpinner();
        addListenerOnButton();
        addItemsToTeamList();
        sanityCheckActivity = new Intent(this, SanityCheckActivity.class);
        
    }

    private void addItemsToTeamList() {
        team_list = new ArrayList<>();

    }

    //add matches to spinner
    public void addItemsOnSpinner() {

        spinner_match_list = (Spinner) findViewById(R.id.spinner_match_list);
        match_list = new ArrayList<String>();
        match_list.add("1");
        match_list.add("2");
        match_list.add("3");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, match_list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_match_list.setAdapter(dataAdapter);
    }


    // get the selected dropdown list value
    public void addListenerOnButton() {
        spinner_match_list = (Spinner) findViewById(R.id.spinner_match_list);
        btn_next = (Button) findViewById(R.id.btn_next);
    }


    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_next)) {
            startActivity(sanityCheckActivity);
        }
    }
}