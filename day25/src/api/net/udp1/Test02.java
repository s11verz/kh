package api.net.udp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Test02 {
	public static void main(String[] args) throws IOException {
		int port=30000;
		DatagramSocket ds=new DatagramSocket(port);
		
		//받을 수 있는 공간 확보
		byte[] data=new byte[1024];
		DatagramPacket dp=new DatagramPacket(data, data.length);
		
		ds.receive(dp);
		
		int size=dp.getLength();
		System.out.println("size="+size);
		String content=new String(data,0,size);
		
		ds.close();
		System.out.println("content="+content);
		
	}

}
