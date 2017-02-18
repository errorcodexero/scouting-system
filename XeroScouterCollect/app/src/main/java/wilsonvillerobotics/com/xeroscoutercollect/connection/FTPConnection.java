package wilsonvillerobotics.com.xeroscoutercollect.connection;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import wilsonvillerobotics.com.xeroscoutercollect.R;

/**
 * Created by Luke Puppo on 12/21/2016.
 */

public class FTPConnection {
    Activity activity;
    private String target  = "ftp://ftsscout:ftsscouter@192.168.1.3:21/";
    private String mimeType = "text/xml";
    private Intent ftpAppIntent;


    public FTPConnection(Activity act){
        activity = act;
    }

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

    public boolean startFTP(String filePath){


        try {


            String serverAddress = "192.168.1.4";
            String userId = "ftsscout";
            String password = "ftsscouter";
            String remoteDirectory = "/";


            //new ftp client
            FTPClient ftp = new FTPClient();
            //try to connect
            ftp.connect(serverAddress);
            //login to server
            if(!ftp.login(userId, password))
            {
                ftp.logout();
                return false;
            }
            int reply = ftp.getReplyCode();
            //FTPReply stores a set of constants for FTP reply codes.
            if (!FTPReply.isPositiveCompletion(reply))
            {
                ftp.disconnect();
                return false;
            }

            //enter passive mode
            ftp.enterLocalPassiveMode();
            //get system name
            System.out.println("Remote system is " + ftp.getSystemType());
            //change current directory
            ftp.changeWorkingDirectory(remoteDirectory);
            System.out.println("Current directory is " + ftp.printWorkingDirectory());

            //get list of filenames
            FTPFile[] ftpFiles = ftp.listFiles();

            if (ftpFiles != null && ftpFiles.length > 0) {
                //loop thru files
                for (FTPFile file : ftpFiles) {
                    if (!file.isFile()) {
                        continue;
                    }
                    System.out.println("File is " + file.getName());


                    //get output stream
                    OutputStream output;
                    output = new FileOutputStream(filePath + "/" + file.getName());
                    //get the file from the remote system
                    ftp.retrieveFile(file.getName(), output);
                    //close output stream
                    output.close();

                    //delete the file
                    ftp.deleteFile(file.getName());

                }
            }

            ftp.logout();
            ftp.disconnect();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
