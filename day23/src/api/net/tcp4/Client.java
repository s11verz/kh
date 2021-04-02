package api.net.tcp4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws IOException  {
		String host="1.220.236.75";
		int port=30000;
		
		InetAddress address=InetAddress.getByName(host);
		Socket socket=new Socket(address, port);
		OutputStream out=socket.getOutputStream();
		
		File target=new File("kh");//파일 알아서 지정
		FileInputStream in=new FileInputStream(target);
		byte[] buffer= new byte[1024];
		System.out.println("파일 전송을 시작합니다.");
		while(true) {
			int n=in.read(buffer);
			if(n==-1) break;
			out.write(buffer,0,n);
		}
		System.out.println("파일 전송이 완료되었습니다.");
		
		in.close();
		socket.close();
	}

}
