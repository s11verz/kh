package api.net.tcp9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		InetAddress address=InetAddress.getByName("localhost");
		int port=30000;
		
		Socket socket=new Socket(address,port);
		
		OutputStreamWriter osw=new OutputStreamWriter(socket.getOutputStream());
		BufferedWriter bw=new BufferedWriter(osw);
		PrintWriter pw=new PrintWriter(bw);
		Scanner sc=new Scanner(System.in);
		String stop="그만";
		while(true) {
		System.out.println("메세지를 입력하세요.");
		String message=sc.next();
		if(message.equals(stop)) break;
		pw.println(message);
		pw.flush();
		}
		socket.close();
		sc.close();
		
	}

}
