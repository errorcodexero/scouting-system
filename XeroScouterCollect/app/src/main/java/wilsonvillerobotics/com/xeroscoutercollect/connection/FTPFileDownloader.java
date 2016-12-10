package wilsonvillerobotics.com.xeroscoutercollect.connection;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by Luke on 12/10/2016.
 */

public class FTPFileDownloader extends AsyncTask<Void, Void, FTPFile[]> {
    private final int defaultFileType = FTP.ASCII_FILE_TYPE;

    private byte serverIP[];
    private int fileType;
    private String userName;
    private String password;
    private final String FTPDownloaderTag = "FTPDownloader";

    public FTPFileDownloader() {
        this.serverIP = FTSUtilities.defaultServerIP;
        this.fileType = defaultFileType;
        this.userName = FTSUtilities.user;
        this.password = FTSUtilities.pwd;
    }

    public FTPFileDownloader setServerIP(byte ipv4[]) {
        this.serverIP = ipv4;
        return this; // allow chaining commands
    }

    public FTPFileDownloader setFileType(int fileType) {
        this.fileType = fileType;
        return this;
    }

    @Override
    protected FTPFile[] doInBackground(Void... filesToGet) {
        FTPClient ftpClient = new FTPClient();
        FTPFile[] receivedFiles = null;
        boolean result = false;
        try {
            //ftpClient.connect(InetAddress.getByName(serverName));
            InetAddress ipv4 = Inet4Address.getByAddress(serverIP);
            ftpClient.setDefaultTimeout(1000);
            ftpClient.connect(ipv4);
            result = ftpClient.login(userName, password);
            Log.e("isFTPConnected", String.valueOf(result));
            ftpClient.changeWorkingDirectory(FTSUtilities.remoteDownloadPath);

            if (ftpClient.getReplyString().contains("250")) {
                File downloadPath = FTSUtilities.getFileDirectory("download");
                if(downloadPath != null) {
                    BufferedInputStream buffIn = null;
                    ftpClient.setFileType(this.fileType);
                    ftpClient.enterLocalPassiveMode();

                    Log.d(ftpClient.printWorkingDirectory(), "is working directory");
                    FTPFile[] files = null;
                    files=ftpClient.listFiles();
                    receivedFiles = new FTPFile[files.length];
                    int i = 0;

                    for(FTPFile ff : files) {
                        String ffName = ff.getName();
                        File downloadFile1 = new File(downloadPath, ffName);
                        OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
                        boolean success = ftpClient.retrieveFile(ffName, outputStream1);
                        outputStream1.close();

                        if(success) {
                            receivedFiles[i++] = ff;
                        }
                    }
                }

                /*for(File fileToSend : filesToSend) {
                    buffIn = new BufferedInputStream(new FileInputStream(fileToSend));
                    //ProgressInputStream progressInput = new ProgressInputStream(buffIn, new Handler(Looper.myLooper()));
                    //result = ftpClient.storeFile(remoteDownloadPath, progressInput);
                    result = ftpClient.storeFile(fileToSend.getAbsoluteFile().getName(), buffIn);
                    buffIn.close();

                    if(result) {

                    }
                }*/
                ftpClient.logout();
                ftpClient.disconnect();
            }

        } catch (SocketException e) {
            Log.e(FTPDownloaderTag, e.getStackTrace().toString());
        } catch (UnknownHostException e) {
            Log.e(FTPDownloaderTag, e.getStackTrace().toString());
        } catch (IOException e) {
            Log.e(FTPDownloaderTag, e.getStackTrace().toString());
        }
        return receivedFiles;
    }
}
