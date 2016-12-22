package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import wilsonvillerobotics.com.xeroscoutercollect.R;

public class ExportActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id) {
            case R.id.btn_export_file:
                Intent dataConnectionIntent = new Intent(this, DataConnectionActivity.class);
                startActivity(dataConnectionIntent);
                break;
        }
    }
}
