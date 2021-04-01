package api.net.tcp1;

import java.net.ServerSocket;

public class Test02 {
	public static void main(String[] args) {
		//TCP 통신: 연결지향형 통신 
		
		for(int port=0;port<65536;port++) {
			
		
		try {
			ServerSocket server=new ServerSocket(20000);
			//System.out.println(port+"번 포트 사용 시작");
		}catch(Exception e){
			System.out.println(port+"번 포트 사용 중");
		}
	}}

}
