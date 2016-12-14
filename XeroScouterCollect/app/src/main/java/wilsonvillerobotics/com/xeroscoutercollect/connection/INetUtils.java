package wilsonvillerobotics.com.xeroscoutercollect.connection;



        import android.content.Context;
        import android.net.wifi.WifiInfo;
        import android.net.wifi.WifiManager;
        import android.util.Log;

        import java.io.*;
        import java.net.*;
        import java.util.*;

/**
 * Created by Luke on 12/10/2016.
 */
public class INetUtils {

    /**
     * Convert byte array to hex string
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sbuf = new StringBuilder();
        for(int idx=0; idx < bytes.length; idx++) {
            int intVal = bytes[idx] & 0xff;
            if (intVal < 0x10) sbuf.append("0");
            sbuf.append(Integer.toHexString(intVal).toUpperCase());
        }
        return sbuf.toString();
    }

    /**
     * Get utf8 byte array.
     * @param str
     * @return  array of NULL if error was found
     */
    public static byte[] getUTF8Bytes(String str) {
        try { return str.getBytes("UTF-8"); } catch (Exception ex) { return null; }
    }

    /**
     * Load UTF8withBOM or any ansi text file.
     * @param filename
     * @return
     * @throws java.io.IOException
     */
    public static String loadFileAsString(String filename) throws java.io.IOException {
        final int BUFLEN=1024;
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(filename), BUFLEN);
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(BUFLEN);
            byte[] bytes = new byte[BUFLEN];
            boolean isUTF8=false;
            int read,count=0;
            while((read=is.read(bytes)) != -1) {
                if (count==0 && bytes[0]==(byte)0xEF && bytes[1]==(byte)0xBB && bytes[2]==(byte)0xBF ) {
                    isUTF8=true;
                    baos.write(bytes, 3, read-3); // drop UTF8 bom marker
                } else {
                    baos.write(bytes, 0, read);
                }
                count+=read;
            }
            return isUTF8 ? new String(baos.toByteArray(), "UTF-8") : new String(baos.toByteArray());
        } finally {
            try{ is.close(); } catch(Exception ex){}
        }
    }

    public static Byte[] getByteArrayFromMACAddressString(String macAddress) {
        ArrayList<Byte> bytes = new ArrayList<Byte>();
        String[] addressBlocks = macAddress.split(":");
        for(int i = addressBlocks.length - 1; i >= 0 ; i--) {
            Integer temp = Integer.parseInt(addressBlocks[i], 16);
            byte b = (byte)(temp & 0xFF);
            bytes.add(b);
        }
        return bytes.toArray(new Byte[6]);
    }

    public static String getWifiMACAddress(Context context) {
        String macAddress = "";
        try {
            WifiManager wManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            WifiInfo wInfo = wManager.getConnectionInfo();
            macAddress = wInfo.getMacAddress();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return macAddress;
    }

    /*public static Long getWifiMACAddressNumeric(Context context) {
        Long macAddress = -1l;
        try {
            String mac = getWifiMACAddress(context);
            Byte[] macBytes = getByteArrayFromMACAddressString(mac);
            macAddress = FTSUtilities.convertByteArrayToLong(macBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  macAddress;
    }*/

    /**
     * Returns MAC address of the given interface name.
     * @param interfaceName eth0, wlan0 or NULL=use first interface
     * @return  mac address or empty string
     */
    public static String getMACAddress(String interfaceName) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                if (interfaceName != null) {
                    if (!intf.getName().equalsIgnoreCase(interfaceName)) continue;
                }
                byte[] mac = intf.getHardwareAddress();
                if (mac==null) return "";
                StringBuilder buf = new StringBuilder();
                for (int idx=0; idx<mac.length; idx++)
                    buf.append(String.format("%02X:", mac[idx]));
                if (buf.length()>0) buf.deleteCharAt(buf.length()-1);
                return buf.toString();
            }
        } catch (Exception ex) { } // for now eat exceptions
        return "";
    }

    /**
     * Returns MAC address of the given interface name.
     * @param interfaceName eth0, wlan0 or NULL=use first interface
     * @return  mac address or empty string
     */
    /*public static Long getMACAddressNumeric(String interfaceName) {
        long macAddress = -1l;
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                byte[] mac = {};
                if (intf != null) {
                    if (!intf.getName().equalsIgnoreCase(interfaceName)) continue;
                    mac = intf.getHardwareAddress();
                }
                macAddress = FTSUtilities.convertByteArrayToLong(mac);
            }
        } catch (Exception ex) { } // for now eat exceptions
        return macAddress;
    }*/

    /**
     * Returns MAC address of the given interface name.
     * @param interfaceName eth0, wlan0 or NULL=use first interface
     * @return  mac address or empty string
     */
    public static boolean interfaceIsUp(String interfaceName) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                if (interfaceName != null) {
                    if (!intf.getName().equalsIgnoreCase(interfaceName)) continue;
                }
                return intf.isUp();
            }
        } catch (Exception ex) { } // for now eat exceptions
        return false;
    }

    public static boolean isWifiUp(Context context) {
        WifiManager wManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        return wManager.isWifiEnabled();
    }

    public static boolean toggleWifi(Context context) {
        WifiManager wManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        boolean enabled = wManager.isWifiEnabled();
        wManager.setWifiEnabled(!enabled);
        return wManager.isWifiEnabled() != enabled;
    }

    /**
     * Get IP address from first non-localhost interface
     * @param useIPv4  true=return ipv4, false=return ipv6
     * @return  address or empty string
     */
    public static String getIPAddress(boolean useIPv4) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress() && addr instanceof Inet4Address) {
                        String sAddr = addr.getHostAddress().toUpperCase();
                        if (useIPv4) {
                            return sAddr;
                        } else {
                            /*if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // drop ip6 port suffix
                                return delim<0 ? sAddr : sAddr.substring(0, delim);
                            }*/
                            Log.d("InetUtils", "Not using IPv4, IPv6 not implemented ");
                        }
                    }
                }
            }
        } catch (Exception ex) { } // for now eat exceptions
        return "";
    }

}
