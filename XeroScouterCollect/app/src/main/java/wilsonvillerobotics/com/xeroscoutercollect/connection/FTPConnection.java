package wilsonvillerobotics.com.xeroscoutercollect.connection;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import wilsonvillerobotics.com.xeroscoutercollect.R;


/**
 * Created by Luke on 11/19/2016.
 */

public class FTPConnection extends ConnectionType{

    private final int REQUEST_ENABLE_BT = 1425;
    private BluetoothAdapter btAdapter;
    private final String FTP_TAG = "FTP";
    private Activity activity;
    private BluetoothDevice btDevice;


    public FTPConnection(Activity act){
        //btAdapter = BluetoothAdapter.getDefaultAdapter();
        activity = act;
        btDevice = null;
    }

    public boolean initAdapter(){
        if(btAdapter == null){
            Log.d(FTP_TAG,"No Bluetooth On Board");
            return false;
        }

        if (!btAdapter.isEnabled() && activity != null) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            activity.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
        String connectionName = btAdapter.getName();
        Log.d(FTP_TAG, (connectionName != null)? connectionName:"NameError");

        Set<BluetoothDevice> btDeviceSet = btAdapter.getBondedDevices();
        if(btDeviceSet != null){
            for(BluetoothDevice btd : btDeviceSet){
                String name = btd.getName();
                if(name.equals("LUKE")){
                    Toast.makeText(activity,"LUKE Found",Toast.LENGTH_SHORT).show();
                    btDevice = btd;
                    break;
                }
            }
        }
        return true;
    }

    public boolean sendDataFile() {
        super.sendDataFile();
        //String path = Environment.getExternalStorageDirectory() + "/test.xml";
        File path = Environment.getExternalStorageDirectory(); // + "/xmlData.xml";
        String name = "Download/match.xml";


        File file = new File(path, name);
        String mimeType = "text/xml";
        String target= "ftp://ftsscout:ftsscouter@10.0.0.28:21/";
        Intent intent = new Intent(android.content.Intent.ACTION_SENDTO);
        intent.setDataAndType(android.net.Uri.parse(target),mimeType);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        if (activity.getPackageManager().queryIntentActivities(intent,0).size() == 0) {
            Toast.makeText(activity.getBaseContext(),
                    R.string.no_app_handling_ftp_available, Toast.LENGTH_LONG)
                    .show();
        } else {
            activity.startActivity(intent);
        }


        return true;
    }

    public boolean receiveDataFile(){
        super.receiveDataFile();
        return false;
    }


}
