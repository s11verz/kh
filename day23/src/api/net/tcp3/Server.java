package api.net.tcp3;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server=new ServerSocket(30000);
		
		Socket socket=server.accept();
		
		OutputStream out=socket.getOutputStream();
		out.write(104);
		out.write(101);
		out.write(108);
		out.write(108);
		out.write(111);
		
		out.close();
		socket.close();
		server.close();
	}

}
