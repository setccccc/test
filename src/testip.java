import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by Administrator on 2019/9/2 0002.
 */
public class testip {
    public static String getWlanIp(){
        String ipret="";
        String ip;
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // filters out 127.0.0.1 and inactive interfaces
                if (iface.isLoopback() || !iface.isUp())
                    continue;

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    ip = addr.getHostAddress();
                    //System.out.println(iface.getDisplayName() + "=" + ip);
                    if(ip.contains("192.168")){
                        ipret = ip;
                        break;
                    }
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        return ipret;
    }
    public static void main(String[] args){
        System.out.println("wlan ip="+getWlanIp());
    }
}
