package thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Test05 {
	public static void main(String[] args) throws IOException {
		//전송과 수신이 동시에 가능한 서버 구현
		//전송: 사용자가 입력한 내용이 클라이언트에게 전송
		//수신: 클라이언트가 전송한 내용을 수신하여 화면에 출력
		
		
		ServerSocket server=new ServerSocket(30000);
		Socket socket=server.accept();
		
		Thread t=new Thread() {
			@Override
			public void run() {
				try {
			
				InputStreamReader isr=new InputStreamReader(socket.getInputStream());
				BufferedReader br=new BufferedReader(isr);
				while(true) {
				String line=br.readLine();
				if(line==null) break;
				System.out.println("line="+line);
				}
				socket.close();
				server.close();
			}catch(Exception e) {
				e.printStackTrace();
				}
			}
		};
		t.setDaemon(true);
		t.start();
		
		//전송 코드
		OutputStreamWriter osw=new OutputStreamWriter(socket.getOutputStream());
		BufferedWriter bw=new BufferedWriter(osw);
		PrintWriter pw=new PrintWriter(bw);
		
		//입력 코드
		while(true) {
		String input=JOptionPane.showInputDialog("입력");
		System.out.println("input:"+input);
		if(input!=null && input.equals("그만")) break;
		if(input!=null) {
			pw.println(input);
			pw.flush();
		}
		
	}

	}}
