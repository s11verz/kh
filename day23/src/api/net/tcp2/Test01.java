package api.net.tcp2;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {
	public static void main(String[] args){
		//TCP 클라이언트 코드: 반드시 접속해야 할 서버의 ip와 port를 알아야 함
		String host="192.168.30.220";
		int port=30000;
		
		try {
		InetAddress address= InetAddress.getByName(host);
		System.out.println("접속 가능한 주소입니다.");
	}catch(Exception e) {
		System.out.println("접속 불가능한 주소입니다.");
	}
		}

}
