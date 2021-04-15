package api.net.udp3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Sender {
	public static void main(String[] args) throws IOException {
		
		MulticastSocket ms=new MulticastSocket();
		
		InetAddress address=InetAddress.getByName("234.234.234.234");//채널은 ip 범위가 존재
		int port=30000;
		ms.joinGroup(address);
		
		String content="Hello Multicast!";
		byte[] data=content.getBytes();
		DatagramPacket dp=new DatagramPacket(data, data.length,address,port);
		
		ms.send(dp);
		ms.close();
	
}

}
