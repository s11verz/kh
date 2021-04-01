package api.net.tcp2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test02 {
	public static void main(String[] args) throws IOException {
		String host="192.168.0.102";
		int port=30000;
		
		InetAddress address=InetAddress.getByName(host);
		//연결 시도(소켓 생성)
		Socket socket=new Socket(address,port);
		System.out.println("서버와 연결되었습니다.");
		
		//연결 종료
		socket.close();
		
	}

}
