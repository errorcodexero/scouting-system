package wilsonvillerobotics.com.xeroscoutercollect.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.connection.DataConnectionManager;

/**
 * Created by Luke on 11/19/2016.
 */

public class DataConnectionActivity extends Activity implements View.OnClickListener{

    private DataConnectionManager dataConnectionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_connection);
        dataConnectionManager = new DataConnectionManager(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_enable_bluetooth){
            dataConnectionManager.setConnectionToBluetooth();
            Toast.makeText(this,"Set connection to Bluetooth",Toast.LENGTH_SHORT).show();
        }
        if(view.getId() == R.id.btn_enable_ftp){
            dataConnectionManager.setConnectionToFTP();
            Toast.makeText(this,"Set connection to FTP",Toast.LENGTH_SHORT).show();
        }
        if(view.getId() == R.id.btn_send_file){
            dataConnectionManager.sendFile();
        }
    }
}
