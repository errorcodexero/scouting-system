package wilsonvillerobotics.com.xeroscoutercollect.connection;


import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.AdvertiseCallback;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Config;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import static android.support.v4.app.ActivityCompat.startActivityForResult;


/**
 * Created by Luke on 11/19/2016.
 */

public class BluetoothConnection extends ConnectionType{

    private final int REQUEST_ENABLE_BT = 1425;
    private BluetoothAdapter btAdapter;
    private final String BT_TAG = "Bluetooth";
    private Activity activity;
    private BluetoothDevice btDevice;


    public BluetoothConnection(Activity act){
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        activity = act;
        btDevice = null;
    }

    public boolean initAdapter(){
        if(btAdapter == null){
            Log.d(BT_TAG,"No Bluetooth On Board");
            return false;
        }

        if (!btAdapter.isEnabled() && activity != null) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            activity.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
        String connectionName = btAdapter.getName();
        Log.d(BT_TAG, (connectionName != null)? connectionName:"NameError");

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
        String path = Environment.getExternalStorageDirectory() + "/test.xml";

        File file = new File(path);
        try {
            boolean result = file.createNewFile();
            boolean r = result;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setComponent(new ComponentName(
                "com.android.bluetooth",
                "com.android.bluetooth.opp.BluetoothOppLauncherActivity"));
        intent.setType("text/xml");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        activity.startActivity(intent);
        return true;
    }

    public boolean receiveDataFile(){
        super.receiveDataFile();
        return false;
    }


}
