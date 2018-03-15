package wilsonvillerobotics.com.xeroscoutercollect.connection;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.TextView;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import wilsonvillerobotics.com.xeroscoutercollect.R;
import wilsonvillerobotics.com.xeroscoutercollect.activities.ManageDBActivity;

/**
 * Created by Luke Puppo on 12/21/2016.
 */

public class FTPConnection {
    private Activity activity;
    private String serverAddress;
    private String userId = "ftsscout";
    private String password = "ftsscouter";
    private String remoteDirectory = "/";
    private TextView status;
    private final String statusPrefix = "Status: ";

    private File xmlFolder = new File("/data/data/wilsonvillerobotics.com.xeroscoutercollect/xml");


    // Will want to make a custom Exception
    public FTPConnection(Activity act) {
        activity = act;
        status = (TextView) act.findViewById(R.id.lbl_user_status_text);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(act);
        xmlFolder.mkdir();
        serverAddress = sharedPreferences.getString("server_ip", "192.168.1.4");
    }

/*
    public void sendFile(File file){
        ftpAppIntent = new Intent(Intent.ACTION_SENDTO);
        ftpAppIntent.setDataAndType(android.net.Uri.parse(target),mimeType);
        ftpAppIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        Toast.makeText(activity.getApplicationContext(),file.getAbsolutePath(),Toast.LENGTH_SHORT).show();
        if (activity.getPackageManager().queryIntentActivities(ftpAppIntent,0).size() == 0) {
            Toast.makeText(activity.getApplicationContext(),
                    R.string.no_app_handling_ftp_available, Toast.LENGTH_LONG)
                    .show();
        } else {
            activity.startActivity(ftpAppIntent);
        }

    }

    public void sendFile(String path){
        //File path = Environment.getExternalStorageDirectory(); // + "/xmlData.xml";
        //String name = "Download/"+ "team.xml";

        //File path = Environment.getExternalStorageDirectory();
        //String name = filename;

        File file = new File(path);
        Intent intent = new Intent(android.content.Intent.ACTION_SENDTO);
        intent.setDataAndType(android.net.Uri.parse(target),mimeType);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        Toast.makeText(activity.getApplicationContext(),file.getAbsolutePath(),Toast.LENGTH_SHORT).show();
        if (activity.getPackageManager().queryIntentActivities(intent,0).size() == 0) {
            Toast.makeText(activity.getBaseContext(),
                    R.string.no_app_handling_ftp_available, Toast.LENGTH_LONG)
                    .show();
        } else {
            activity.startActivity(intent);
        }
    }
    */



    public boolean getFTPFiles(String baseFolder, ManageDBActivity.DataTransferTask task) {
        if(isConnected()){
            try {
                task.myPublish("Begun pulling data from FTP Server");
                //new ftp client
                FTPClient ftp = new FTPClient();
                //try to connect
                ftp.connect(serverAddress);
                //login to server
                if (!ftp.login(userId, password)) {
                    ftp.logout();
                    return false;
                }
                int reply = ftp.getReplyCode();
                //FTPReply stores a set of constants for FTP reply codes.
                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftp.disconnect();
                    return false;
                }

                //enter passive mode
                ftp.enterLocalPassiveMode();
                ftp.changeWorkingDirectory(remoteDirectory);

                //get list of filenames
                FTPFile[] ftpFiles = ftp.listFiles();

                if (ftpFiles != null && ftpFiles.length > 0) {
                    //loop thru files
                    for (FTPFile file : ftpFiles) {
                        if (!file.isFile()) {
                            continue;
                        }
                        task.myPublish("Pulling file: " + file.getName() + ". Size: " + file.getSize() );
                        //get output stream
                        OutputStream output;
                        output = new FileOutputStream(baseFolder + "/" + file.getName());
                        //get the file from the remote system
                        ftp.retrieveFile(file.getName(), output);
                        //close output stream
                        output.close();
                    }
                }

                ftp.logout();
                ftp.disconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
                task.myPublish("Failed to pull DB XML Files");
                return false;
            }
        }
        task.myPublish("Successfully pulled DB XML Files");
        return true;
    }

   /* public boolean sendFTPFiles(String baseFolder, String filename1, String filename2){
        if(isConnected()) {
            try {
                //new ftp client
                FTPClient ftp = new FTPClient();
                //try to connect
                ftp.connect(serverAddress);
                //login to server
                if (!ftp.login(userId, password)) {
                    ftp.logout();
                    return false;
                }
                int reply = ftp.getReplyCode();
                //FTPReply stores a set of constants for FTP reply codes.
                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftp.disconnect();
                    return false;
                }

                //enter passive mode
                ftp.enterLocalPassiveMode();
                ftp.changeWorkingDirectory(remoteDirectory + "/exports");

                setStatusText("Storing File");

                //get input stream
                InputStream input;
                input = new FileInputStream(baseFolder + "/" + filename1);
                //store the file in the remote server
                ftp.storeFile(filename1, input);
                input = new FileInputStream(baseFolder + "/" + filename2);
                ftp.storeFile(filename2, input);
                //close the stream
                input.close();
                setStatusText("Success!");


                ftp.logout();
                ftp.disconnect();
                setStatusText("FTP Transfer Complete");
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
            return true;
        }
        setStatusText("FTP Transfer Failed. Connect ethernet cable.");
        return false;
    }*/
    public boolean sendFTPFile(File fileToSend, ManageDBActivity.DataTransferTask task){
        if(isConnected()) {
            try {
                //new ftp client
                FTPClient ftp = new FTPClient();
                //try to connect
                ftp.connect(serverAddress);
                //login to server
                if (!ftp.login(userId, password)) {
                    ftp.logout();
                    return false;
                }
                int reply = ftp.getReplyCode();
                //FTPReply stores a set of constants for FTP reply codes.
                if (!FTPReply.isPositiveCompletion(reply)) {
                    ftp.disconnect();
                    return false;
                }

                //enter passive mode
                ftp.enterLocalPassiveMode();
                ftp.changeWorkingDirectory(remoteDirectory + "/exports");

                task.myPublish("Transferring File... Please wait.");

                //get input stream
                InputStream input;
                input = new FileInputStream(fileToSend);

                //store the file in the remote server
                ftp.storeFile(fileToSend.getName(), input);
                //close the stream
                input.close();
                task.myPublish("Success!");


                ftp.logout();
                ftp.disconnect();
                task.myPublish("FTP Transfer Complete");
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
            return true;
        }
        task.myPublish("FTP Transfer Failed. Connect ethernet cable.");
        return false;
    }


    private boolean isConnected(){
        //Toast.makeText(activity, "Is Connected check success", Toast.LENGTH_SHORT).show();
//Toast.makeText(activity, "Is Connected check failed", Toast.LENGTH_SHORT).show();
        return getLocalIpAddress() != null;
    }

    //Used to check to see if connected to Ethernet
    private String getLocalIpAddress() {
        String TAG = "LocalIP";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String ip = Formatter.formatIpAddress(inetAddress.hashCode());
                        Log.i(TAG, "***** IP="+ ip);
                        //Toast.makeText(activity, "Got an IP", Toast.LENGTH_SHORT).show();
                        return ip;
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e(TAG, ex.toString());
        }
        //Toast.makeText(activity, "Failed to find an IP. Plug in ethernet cable and try again.", Toast.LENGTH_SHORT).show();
        return null;
    }

}
