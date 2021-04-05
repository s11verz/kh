package api.net.tcp9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String[] args) throws IOException {
		//사용자 접속 후 지속적으로 전달되는 채팅 메세지를 받아서 출력
		ServerSocket server=new ServerSocket(30000);
		Socket socket=server.accept();
		System.out.println("사용자가 접속했습니다."+socket.getInetAddress());
		//파일
		File dir=new File("kh");
		dir.mkdirs();
		File target=new File(dir,"chat.log");
		FileWriter fw=new FileWriter(target);
		BufferedWriter bw=new BufferedWriter(fw);
		PrintWriter pw=new PrintWriter(bw);
		
		InputStreamReader isr=new InputStreamReader(socket.getInputStream());
		BufferedReader br=new BufferedReader(isr);
		
		while(true) {
			String message=br.readLine();
			if(message==null) break;//'그만'이라고 입력하면 client가 꺼지는 것
			System.out.println("메세지: "+message);
			pw.println(message);
		}
		pw.close();
		socket.close();
		server.close();
	}
	
	

}
