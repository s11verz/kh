package api.net.udp1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Test01 {
	public static void main(String[] args) throws IOException {
		//UDP 통신 - 비연결형 통신
		InetAddress address=InetAddress.getByName("localhost");
		int port=30000;
		//전송용 우체국
		DatagramSocket ds=new DatagramSocket();
		//편지 내용
		String content="Hello UDP!";
		//편지봉투+내용
		byte[] data=content.getBytes();
		DatagramPacket dp=new DatagramPacket(data, data.length,address,port);
		//전송
		ds.send(dp);
		
		//종료
		ds.close();
		
	}

}
