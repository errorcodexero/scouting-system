package wilsonvillerobotics.com.xeroscoutercollect.connection;

import android.app.Activity;

/**
 * Created by Luke on 11/19/2016.
 */

public class DataConnectionManager {
    private ConnectionType connectionType;
    private Activity activity;

    public DataConnectionManager(Activity act){
        connectionType = null;
        activity = act;
    }

    public void setConnectionToBluetooth(){
        connectionType = new BluetoothConnection(activity);
        connectionType.initAdapter();
    }

    public void setConnectionToFTP(){
        connectionType = new FTPConnection(activity);
        connectionType.initAdapter();
    }
    public void sendFile(){
        connectionType.sendDataFile();
    }
}
