package thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Test06 {
	public static void main(String[] args) throws IOException {
//		전송과 수신이 동시에 가능한 클라이언트 구현
//		= 서버와 딱 3줄 다름
		
		InetAddress address = InetAddress.getByName("1.220.236.75");
		int port = 30000;
		
		Socket socket = new Socket(address, port);
		
		Thread t = new Thread() {
			@Override
			public void run() {
//				작업2 : 수신 코드
				try {
					InputStreamReader isr = new InputStreamReader(socket.getInputStream());
					BufferedReader br = new BufferedReader(isr);
					
					while(true) {
						String line = br.readLine();
						if(line == null) break;
						System.out.println("line = " + line);
					}
					
					socket.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		t.setDaemon(true);
		t.start();

//		작업1 : 전송 코드
		OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
		BufferedWriter bw = new BufferedWriter(osw);
		PrintWriter pw = new PrintWriter(bw);
		
//		입력 코드
		while(true) {
			String input = JOptionPane.showInputDialog("입력");
//			System.out.println("input = " + input);
			
			if(input != null && input.equals("그만")) {
				break;
			}
			
			if(input != null) {
				pw.println(input);
				pw.flush();
			}
		}
		
		socket.close();
	}
}


