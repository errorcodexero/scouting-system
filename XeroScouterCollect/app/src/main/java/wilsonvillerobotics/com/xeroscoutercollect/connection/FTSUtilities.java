package wilsonvillerobotics.com.xeroscoutercollect.connection;

import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.widget.Button;
import android.widget.Toast;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;



/**
 * Created by Luke on 12/10/2016.
 */

public class FTSUtilities {
    public static Boolean DEBUG = true;
    public static Boolean TEST_MODE = true;
    public static String strUuid = "";
    public static Long wifiID = -1l;

    public static final String user = "ftsscout", pwd = "ftsscouter";
    public static final String remoteUploadPath = "./upload";
    public static final String remoteDownloadPath = "./download";
    public static final byte defaultServerIP[] = {(byte)10, (byte)0, (byte)0, (byte)100};
    /*
    public enum ItemType {
        ROBOT(0, "Robot"),
        PIT(1, "Pit"),
        TEAM(2, "Team"),
        ALL(3, "All"),
        NONE(4, "");

        private String name;
        private int id;
        ItemType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        static public ItemType getItemTypeByName(String name) {
            ItemType retVal = NONE;
            for(ItemType it : ItemType.values()) {
                if(it.name.equals(name)) {
                    retVal = it;
                    break;
                }
            }
            return retVal;
        }

        static public ItemType getItemTypeById(int id) {
            ItemType retVal = NONE;
            for(ItemType it : ItemType.values()) {
                if(it.id == id) {
                    retVal = it;
                    break;
                }
            }
            return retVal;
        }
    }
    *//*
    public enum ALLIANCE_POSITION {
        RED1 (0, "Red1"),
        RED2 (1, "Red2"),
        RED3 (2, "Red3"),
        BLUE1 (3, "Blue1"),
        BLUE2 (4, "Blue2"),
        BLUE3 (5, "Blue3"),
        PIT1 (6, "Pit1"),
        PIT2 (7, "Pit2"),
        PIT3 (8, "Pit3"),
        NOT_SET (9, "Not Set");

        private final int index;
        private String strAlliancePositionString;
        ALLIANCE_POSITION(int index, String alliancePosition) {
            this.index = index;
            this.strAlliancePositionString = alliancePosition;
        }

        public boolean positionIsSet() {
            return this != NOT_SET;
        }

        public static ALLIANCE_POSITION[] validPositions() {
            ALLIANCE_POSITION positions[] = {
                    RED1, RED2, RED3,
                    BLUE1, BLUE2, BLUE3
            };
            return positions;
        }

        public int getColorForAlliancePosition() {
            if(this.strAlliancePositionString.contains("Red")) {
                return Color.RED;
            } else if(this.strAlliancePositionString.contains("Blue")) {
                return Color.BLUE;
            }
            return Color.MAGENTA;
        }

        public int allianceIndex() {
            return this.index;
        }

        public String myAlliancePosition() {
            return this.strAlliancePositionString;
        }

        public static String getAlliancePositionStringForIndex(int index) {
            switch(index) {
                case 0:
                    return RED1.strAlliancePositionString;
                case 1:
                    return RED2.strAlliancePositionString;
                case 2:
                    return RED3.strAlliancePositionString;
                case 3:
                    return BLUE1.strAlliancePositionString;
                case 4:
                    return BLUE2.strAlliancePositionString;
                case 5:
                    return BLUE3.strAlliancePositionString;
                default:
                    return NOT_SET.strAlliancePositionString;
            }
        }

        public static ALLIANCE_POSITION getAlliancePositionForIndex(int index) {
            switch(index) {
                case 0:
                    return RED1;
                case 1:
                    return RED2;
                case 2:
                    return RED3;
                case 3:
                    return BLUE1;
                case 4:
                    return BLUE2;
                case 5:
                    return BLUE3;
                default:
                    return NOT_SET;
            }
        }

        public static ALLIANCE_POSITION getAlliancePositionForString(String s) {
            ALLIANCE_POSITION AP = NOT_SET;
            for(ALLIANCE_POSITION ap : ALLIANCE_POSITION.values()) {
                if(s.matches(ap.strAlliancePositionString)) {
                    AP = ap;
                }
            }
            return AP;
        }
    }
*/
    public static boolean isMyServiceRunning(Context context, String serviceName) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            // get class name string: <CLASS>.class.getName()
            if (serviceName.equals(service.service.getClassName())) {
                return true;
            }
        }

        return false;
    }
/*
    public static String getTabletID(ALLIANCE_POSITION ap) {
        if(ap == null) return ALLIANCE_POSITION.NOT_SET.myAlliancePosition();
        return ap.myAlliancePosition();
    }
*//*
    private static long unsignedByteToLong(byte b) {
        long temp = (long) b & 0xFF;
        return temp;
    }
    */

    /**
     * gets the long value from byte array
     * @param byteArrayToConvert
     *//*
    public static long convertByteArrayToLong(byte[] byteArrayToConvert) {
        long address = -1l;
        if (byteArrayToConvert != null) {
            if (byteArrayToConvert.length == 6) {
                address = unsignedByteToLong(byteArrayToConvert[5]);
                address |= (unsignedByteToLong(byteArrayToConvert[4]) << 8);
                address |= (unsignedByteToLong(byteArrayToConvert[3]) << 16);
                address |= (unsignedByteToLong(byteArrayToConvert[2]) << 24);
                address |= (unsignedByteToLong(byteArrayToConvert[1]) << 32);
                address |= (unsignedByteToLong(byteArrayToConvert[0]) << 40);
            }
        }
        return address;
    }
*/
    /**
     * gets the long value from byte array
     * @param byteArrayToConvert
     */
    /*
    public static long convertByteArrayToLong(Byte[] byteArrayToConvert) {
        long address = -1l;
        if (byteArrayToConvert != null) {
            if (byteArrayToConvert.length == 6) {
                address = unsignedByteToLong(byteArrayToConvert[5]);
                address |= (unsignedByteToLong(byteArrayToConvert[4]) << 8);
                address |= (unsignedByteToLong(byteArrayToConvert[3]) << 16);
                address |= (unsignedByteToLong(byteArrayToConvert[2]) << 24);
                address |= (unsignedByteToLong(byteArrayToConvert[1]) << 32);
                address |= (unsignedByteToLong(byteArrayToConvert[0]) << 40);
            }
        }
        return address;
    }
*//*
    public static void generateDeviceID(Context context) {
        // DeviceUuidFactory loads or generates the static androidUuid in its constructor
        DeviceUuidFactory duf = new DeviceUuidFactory(context);
        strUuid = duf.getDeviceAndroidUuid().toString();
        wifiID = duf.getDeviceWiFiId();

        String deviceWiFiMAC = String.valueOf(wifiID);
        Long deviceWifiMACNumeric = 0l;
        boolean wifiUp = INetUtils.isWifiUp(context);
        FTSUtilities.printToConsole("WIFI Adapter " + (wifiUp ? "IS" : "IS NOT") + " up");

        int timeout = 500;
        while(!wifiUp && timeout > 0) {
            wifiUp = INetUtils.toggleWifi(context);
            timeout--;
        }

        timeout = 500;
        if(wifiUp) {
            FTSUtilities.printToConsole("WIFI Adapter " + (wifiUp ? "IS" : "IS NOT") + " up");
            deviceWiFiMAC = INetUtils.getMACAddress("wlan0");
            deviceWifiMACNumeric = INetUtils.getMACAddressNumeric("wlan0");

            while(wifiUp && timeout > 0) {
                wifiUp = INetUtils.toggleWifi(context);
                timeout--;
            }
        }

        String message = "WIFI Adapter MAC: " + deviceWiFiMAC + "\nMAC Numeric Value: " + deviceWiFiMAC;
        FTSUtilities.printToConsole(message);
        //Toast.makeText(context, message, Toast.LENGTH_LONG).show();

    }
*//*
    public static String getShortDeviceID(Context context) {
        if(strUuid == "") {
            if(context == null) {
                return "";
            }
            DeviceUuidFactory duf = new DeviceUuidFactory(context);
            strUuid = duf.getDeviceAndroidUuid().toString();
        }
        String parts[] = strUuid.split("-");
        if(parts.length == 5) {
            return parts[4];
        }
        return parts[parts.length - 1];
    }*/

    public static File getFileDirectory(String subDirectory) {
        if(subDirectory == null || subDirectory == "") {
            subDirectory = DataXmlExporter.DATASUBDIRECTORY;
        } else {
            subDirectory = DataXmlExporter.DATASUBDIRECTORY + "/" + subDirectory;
        }
        File fileDir = new File(Environment.getExternalStorageDirectory(), subDirectory);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        return fileDir;
    }
/*
    public static String getXmlDataFileNameForTable(String tableName) {
        // expected format: ftsData-<androidUuid>-<table_name>-<timestamp>.xml
        final String exportFileNamePrefix = "ftsData";
        final String exportTimestamp = String.valueOf(System.nanoTime());

        String dataFileName = exportFileNamePrefix + "-";
        dataFileName += getShortDeviceID(null) + "-";
        dataFileName += tableName + "-";
        dataFileName += exportTimestamp;
        dataFileName += ".xml";

        return dataFileName;
    }*/

    /*private static Hashtable<Integer, String> testTeamData = new Hashtable<Integer, String>(){
        /**
         *
         */
        /*private static final long serialVersionUID = 1L;

        {
            put(1425, "Error Code Xero");
            put(1520, "Flaming Chickens");
            put(2929, "JagBots");
            put(1114, "Derp");
            put(500, "Spots");
            put(600, "Frozen Poultry");
            put(700, "Jumping Frogs");
            put(800, "Droids");
            put(900, "Sad Pandas");
            put(1000, "Grommets");
        }
    };*/
/*
    public static void printToConsole(String message) {
        if(message.isEmpty() || !DEBUG) return;
        int len = 50 - message.length();
        String spacer = "";
        for(int i = 0; i < len/2;i++) {
            spacer += " ";
        }
        System.out.println("");
        System.out.println("**************************************************");
        System.out.println(spacer + message);
        System.out.println("**************************************************");
        System.out.println("");
    }

    public static Set<Integer> getTestTeamNumbers() {
        Set<Integer> teamNums = testTeamData.keySet();
        return teamNums;
    }

    public static String getTeamName(int tNum) {
        return testTeamData.get(tNum);
    }

    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    /*
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    public static boolean initializeBluetooth(Activity activity) {
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
            return false;
        }

        int REQUEST_ENABLE_BT = 1;

        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            activity.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }


        return false;
    }

    public static Uri sendFileByBluetooth(Context context, String filePath, String btDeviceAddress) {
        //BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();

        //BluetoothDevice device = btAdapter.getRemoteDevice(btDeviceAddress);
        //String filePath = Environment.getExternalStorageDirectory().toString() + "/file.jpg";

        ContentValues values = new ContentValues();
        values.put(BluetoothShare.URI, Uri.fromFile(new File(filePath)).toString());
        values.put(BluetoothShare.DESTINATION, btDeviceAddress); // device.getAddress());
        values.put(BluetoothShare.DIRECTION, BluetoothShare.DIRECTION_OUTBOUND);
        Long ts = System.currentTimeMillis();
        values.put(BluetoothShare.TIMESTAMP, ts);
        Uri contentUri = context.getContentResolver().insert(BluetoothShare.CONTENT_URI, values);
        return contentUri;
    }

    public static void setButtonStyles(Hashtable<Integer, Button> buttonHash, Boolean undo) {
        int color = (undo) ? Color.RED : Color.BLUE;

        for(Integer bID : buttonHash.keySet()) {
            buttonHash.get(bID).setTextColor(color);
        }
    }

    private static String getIntCSVHeader() {
        String COMMA = ", ";
        String retVal = "";
        retVal += TeamMatchDBAdapter.COLUMN_NAME_START_LOCATION + COMMA;

        return retVal;
    }

    private static String getBoolCSVHeader() {
        String COMMA = ", ";
        String retVal = "";
        //retVal += TeamMatchDBAdapter.COLUMN_NAME_TEAM_MATCH_HAS_SAVED_DATA + COMMA;
        retVal += TeamMatchDBAdapter.COLUMN_NAME_BROKE_DOWN + COMMA;
        retVal += TeamMatchDBAdapter.COLUMN_NAME_NO_MOVE + COMMA;
        retVal += TeamMatchDBAdapter.COLUMN_NAME_LOST_CONNECTION + COMMA;

        return retVal;
    }

    public static String getCSVHeaderString() {
        String COMMA = ", ";
        String headerOut = "tablet_id" + COMMA;
        headerOut += TeamMatchDBAdapter._ID + COMMA + TeamMatchDBAdapter.COLUMN_NAME_TEAM_ID + COMMA;
        headerOut += TeamMatchDBAdapter.COLUMN_NAME_MATCH_ID + COMMA;
        headerOut += FTSUtilities.getIntCSVHeader() + COMMA;
        headerOut += FTSUtilities.getBoolCSVHeader() + COMMA;
        headerOut += TeamMatchDBAdapter.COLUMN_NAME_TEAM_MATCH_NOTES + "\n";
        return headerOut;
    }

    /*  http://stackoverflow.com/questions/1277880/how-can-i-get-the-count-of-line-in-a-file-in-an-efficient-way  */
    /*
    public static int countLines(File aFile) throws IOException {
        LineNumberReader reader = null;
        try {
            reader = new LineNumberReader(new FileReader(aFile));
            while ((reader.readLine()) != null);
            return reader.getLineNumber();
        } catch (Exception ex) {
            return -1;
        } finally {
            if(reader != null)
                reader.close();
        }
    }

    /* http://stackoverflow.com/questions/1714297/android-view-setidint-id-programmatically-how-to-avoid-id-conflicts */
            /*
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    /**
     * This value will not collide with ID values generated at build time by aapt for R.id.
     *
     * @return a generated ID value
     */
    /*
    public static int generateViewId() {
        for (;;) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }
    */
}
