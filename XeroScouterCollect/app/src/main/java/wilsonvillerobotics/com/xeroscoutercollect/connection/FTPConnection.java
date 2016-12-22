package wilsonvillerobotics.com.xeroscoutercollect.connection;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;

import wilsonvillerobotics.com.xeroscoutercollect.R;

/**
 * Created by Luke Puppo on 12/21/2016.
 */

public class FTPConnection {
    Activity activity;
    private String target  = "ftp://Luke:1234@192.168.0.2:21/";
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
        String mimeType = "text/xml";
        String target= "ftp://Luke:1234@192.168.1.2:21/";
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
}
