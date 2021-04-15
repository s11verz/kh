package api.net.udp2;
//receiver->sender
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {
	public static void main(String[] args) throws IOException {
		DatagramSocket ds=new DatagramSocket(30000);
		
		byte[] data=new byte[1024];
		DatagramPacket dp=new DatagramPacket(data, data.length);
		
		while(true) {
		ds.receive(dp);
		String content=new String(data,0,dp.getLength());
		System.out.println("content="+content);
		}
	}
}
