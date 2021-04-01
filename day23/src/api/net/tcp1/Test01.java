package api.net.tcp1;

import java.net.ServerSocket;

public class Test01 {
	public static void main(String[] args) {
		//TCP 통신: 연결지향형 통신 
		
		try {
			ServerSocket server=new ServerSocket(20000);
			System.out.println("20000번 포트 사용 시작");
		}catch(Exception e){
			System.out.println("20000번 포트 사용 중");
		}
	}

}
