
/**
 * Write a description of class getMAC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class getMAC
{
   
   public static void main(String[] args)
   {
    InetAddress ip;
    try 
    {
		ip = InetAddress.getLocalHost();
		System.out.println("IP address : " + ip.getHostAddress());
		
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			
		byte[] mac = network.getHardwareAddress();
			
		System.out.println("Current MAC address : ");
			
		StringBuilder macAdd = new StringBuilder();
		for (int i = 0; i < mac.length; i++) 
		{
			macAdd.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		System.out.println(macAdd.toString());
			
	} catch (UnknownHostException e) {
		
		e.printStackTrace();
		
	} catch (SocketException e){
			
		e.printStackTrace();
			
	}
	    
   }
}
