package wilsonvillerobotics.com.xeroscoutercollect.connection;

import android.app.Activity;

/**
 * Created by Luke on 11/19/2016.
 */

public class DataConnectionManager {
    private BluetoothConnection bt_Connection;
    private Activity activity;

    public DataConnectionManager(Activity act){
        bt_Connection = null;
        activity = act;
    }

    public void setConnectionToBluetooth(){
        bt_Connection = new BluetoothConnection(activity);
        bt_Connection.initAdapter();
    }
    public void sendFile(){
        bt_Connection.sendDataFile();
    }

}
