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
    private Button btn_submit;
    private Intent sanityCheckActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_confirmation);

        addItemsOnSpinner();
        addListenerOnButton();
        sanityCheckActivity = new Intent(this, SanityCheckActivity.class);
    }

    // add items into spinner dynamically
    public void addItemsOnSpinner() {

        spinner_match_list = (Spinner) findViewById(R.id.spinner_match_list);
        List<String> list = new ArrayList<String>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        list.add("list 3");
        list.add("list 3");
        list.add("list 3");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_match_list.setAdapter(dataAdapter);
    }


    // get the selected dropdown list value
    public void addListenerOnButton() {
        spinner_match_list = (Spinner) findViewById(R.id.spinner_match_list);
        btn_submit = (Button) findViewById(R.id.btn_submit);
    }


    @Override
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_submit)) {
            startActivity(sanityCheckActivity);
        }
    }
}