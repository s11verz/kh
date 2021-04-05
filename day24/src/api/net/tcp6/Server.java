package api.net.tcp6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	public static void main(String[] args) throws IOException {
		//날짜 객체를 클라이언트 접속 시 전송
		
		ServerSocket server=new ServerSocket(30000);
		Socket socket=server.accept();
		
		//날짜 객체 생성
		Date d=new Date();
		
		//출력 스트림 생성
		BufferedOutputStream buffer=new BufferedOutputStream(socket.getOutputStream());
		ObjectOutputStream oos=new ObjectOutputStream(buffer);
		
		oos.writeObject(d);
		oos.flush();
		
		
		
		socket.close();
		server.close();
	}

}
