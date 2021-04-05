package api.net.tcp8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		//접속한 사용자에게 welcome 이라는 문자열을 전송하는 서버 구현
		
		ServerSocket server=new ServerSocket(30000);
		Socket socket=server.accept();
		
		String text="Welcome!";
		
		//outputstreamwriter는 writer와 ouputstream 간의 출력변환 수행
		OutputStreamWriter osw=new OutputStreamWriter(socket.getOutputStream());
		BufferedWriter bw=new BufferedWriter(osw);
		PrintWriter pw=new PrintWriter(bw);
		
		pw.println(text);
		pw.flush();
		
		socket.close();
		server.close();
		
	}

}
