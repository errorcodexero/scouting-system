package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import wilsonvillerobotics.com.xeroscoutercollect.R;

/**
 * Created by Luke on 11/15/2016.
 */

public class PitScoutingActivity extends Activity implements View.OnClickListener  {

    private Intent landingActivity;

    private ListView lvCheckBox;
    private Button btn_check_all, btn_clear_all;
    private String[] arr = {"One", "Two", "Three", "Four", "Five", "Six"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pit_scouting);

        //added code to do list view with checkboxes
        btn_check_all = (Button)findViewById(R.id.btn_check_all);
        btn_clear_all = (Button)findViewById(R.id.btn_clear_all);

        lvCheckBox = (ListView)findViewById(R.id.lvCheckBox);
        lvCheckBox.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lvCheckBox.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice, arr));
    }


    @Override
    public void onClick(View view)
    {
        if (view == findViewById(R.id.btn_check_all)) {
            //Toast.makeText(PitScoutingActivity.this, "I AM PRESSING THE CHECK ALL BUTTON, GOD DAMMIT!", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
                lvCheckBox.setItemChecked(i, true);
            }
        }
        if(view == findViewById(R.id.btn_clear_all)){
            //Toast.makeText(PitScoutingActivity.this, "CLEAR THE DECKS! BOMBS INCOMING!", Toast.LENGTH_SHORT).show();
            for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
                lvCheckBox.setItemChecked(i, false);
            }
        }
        if(view == findViewById(R.id.btn_checked_boxes)){
            String msg = "";
            for (int i = 0; i < lvCheckBox.getAdapter().getCount(); i++) {
                if(lvCheckBox.isItemChecked(i)){
                    msg = msg + Integer.toString(i)+ ", ";
                }
            }
            //Toast.makeText(PitScoutingActivity.this, "Found: " + msg, Toast.LENGTH_SHORT).show();
        }
    }
}
