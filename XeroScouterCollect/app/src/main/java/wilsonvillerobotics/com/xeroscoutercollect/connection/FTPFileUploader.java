package wilsonvillerobotics.com.xeroscoutercollect.connection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
/**
 * Created by Luke on 12/10/2016.
 */

public class FTPFileUploader extends AsyncTask<File, Void, Boolean> {

    private String userName;
    private String password;
    private String remotePath;
    private byte serverIP[];
    private Context context;
    private String FTPTag = "FTPUploader";

    public FTPFileUploader(Context context) {
        this.userName = FTSUtilities.user;
        this.password = FTSUtilities.pwd;
        this.remotePath = FTSUtilities.remoteUploadPath;
        this.serverIP = FTSUtilities.defaultServerIP;
        this.context = context;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public void setServerIP(byte ipArray[]) {
        this.serverIP = ipArray;
    }

    @Override
    protected Boolean doInBackground(File... filesToSend) {
        FTPClient ftpClient = new FTPClient();
        boolean result = false;
        boolean backupSuccess = false;
        Log.e("FTP", "FTP upload start file count: " + String.valueOf(filesToSend.length));
        try {
            //ftpClient.connect(InetAddress.getByName(serverName));
            InetAddress ipv4 = Inet4Address.getByAddress(serverIP);
            ftpClient.setDefaultTimeout(1000);
            ftpClient.connect(ipv4);
            result = ftpClient.login(userName, password);
            Log.e("FTPConnected: ", String.valueOf(result));
            ftpClient.changeWorkingDirectory(remotePath);

            //if (ftpClient.getReplyString().contains("250")) {
            BufferedInputStream buffIn = null;
            ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();

            for(File fileToSend : filesToSend) {
                if(!fileToSend.isDirectory()) {
                    Log.e(FTPTag, "File:  " + fileToSend.getName());
                    buffIn = new BufferedInputStream(new FileInputStream(fileToSend));
                    //ProgressInputStream progressInput = new ProgressInputStream(buffIn, new Handler(Looper.myLooper()));
                    //result = ftpClient.storeFile(remoteUploadPath, progressInput);
                    String fName = fileToSend.getAbsoluteFile().getName();

                    result = ftpClient.storeFile(fName, buffIn);
                    buffIn.close();

                    if (result) {
                        File backupDir = FTSUtilities.getFileDirectory("exported");
                        if (!backupDir.exists()) {
                            backupDir.mkdirs();
                        }

                        File backupFile = new File(backupDir, fName);
                        backupSuccess |= fileToSend.renameTo(backupFile);
                    } else {
                        File backupDir = FTSUtilities.getFileDirectory("failedExport");
                        if (!backupDir.exists()) {
                            backupDir.mkdirs();
                        }

                        File backupFile = new File(backupDir, fName);
                        fileToSend.renameTo(backupFile);
                    }
                }
            }
            ftpClient.logout();
            ftpClient.disconnect();
            //} else {
            //    Log.e("FTP: ", "Upload Failed");
            //}
        } catch (SocketException e) {
            //Toast.makeText(context, "Socket", Toast.LENGTH_LONG).show();
            Log.e(FTPTag, "Socket exception " + e.getStackTrace().toString());
        } catch (UnknownHostException e) {
            //Toast.makeText(context, "Unknown Host Exception", Toast.LENGTH_LONG).show();
            Log.e(FTPTag, "Unknown Host Exception " + e.getStackTrace().toString());
        } catch (IOException e) {
            //Toast.makeText(context, "IO Exception", Toast.LENGTH_LONG).show();
            Log.e(FTPTag, "IO Exception " + e.getStackTrace().toString());
        } catch (Exception e) {
            //Toast.makeText(context, "General Exception", Toast.LENGTH_LONG).show();
            Log.e(FTPTag, "General Exception " + e.getStackTrace().toString());
        }
        return result && backupSuccess;
    }
}
