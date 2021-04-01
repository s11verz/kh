package api.net.tcp5;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class Clinet {
	public static void main(String[] args) throws IOException {
		String host = "localhost";
		int port = 30000;

		InetAddress address = InetAddress.getByName(host);
		Socket socket = new Socket(address, port);
		InputStream in = socket.getInputStream();

		while (true) {
			int n = in.read();
			if (n == -1)
				break;
			System.out.println(n);

		}
		socket.close();
		
	}

}
