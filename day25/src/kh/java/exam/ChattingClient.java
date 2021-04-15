package kh.java.exam;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class ChattingClient {

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException {

		//String serverIp = "127.0.0.1";
		InetAddress address=InetAddress.getByName("127.0.0.1");

		int serverPort = 8888;

		Socket socket = null;

		DataInputStream dis = null;

		DataOutputStream dos = null;

		try {

			socket = new Socket(address, serverPort);

			InputStream in = socket.getInputStream();

			OutputStream out = socket.getOutputStream();

			dis = new DataInputStream(in);

			dos = new DataOutputStream(out);
			//BufferedInputStream buffer=new BufferedInputStream(socket.getInputStream());
			//ObjectInputStream ois=new ObjectInputStream(buffer);

			while(true) {
			String serverMsg = dis.readUTF();
			if(serverMsg==null) break;
			System.out.println(serverMsg);
			
			}
			//Date d=(Date)ois.readObject();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				dis.close();

				dos.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

}