package api.net.tcp5;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(30000);
		Socket socket=server.accept();
		OutputStream out=socket.getOutputStream();
		Random r=new Random();
		int array[]= new int[6];
		for(int i=0;i<6;i++) {
			array[i]=r.nextInt(45)+1;
			for(int j=0;j<i;j++) {
				if(array[i]==array[j]) {
					i--;
				}
			}
		}for(int i=0;i<6;i++) {
			out.write(array[i]);
		}
		out.close();
		socket.close();
		server.close();
			
						
	}

}
