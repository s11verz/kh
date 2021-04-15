package api.net.udp3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receiver {
	public static void main(String[] args) throws IOException {
		MulticastSocket ms=new MulticastSocket(30000);
		
		InetAddress address=InetAddress.getByName("234.234.234.234");
		ms.joinGroup(address);
		 
		byte[] data=new byte[1024];
		DatagramPacket dp=new DatagramPacket(data, data.length);
		ms.receive(dp);
		
		String content=new String(data,0,dp.getLength());
		System.out.println(content);
		
		ms.close();
	}

}
