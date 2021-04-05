package api.net.tcp7;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Set;

public class Client {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		InetAddress address=InetAddress.getByName("localhost");
		int port=30000;
		Socket socket=new Socket(address,port);
		
		//통로
		//BufferedInputStream buffer=new BufferedInputStream(socket.getInputStream());
		//ObjectInputStream ois=new ObjectInputStream(buffer);
		ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
		
		Set<Integer> lotto=(Set<Integer>) ois.readObject();//다운캐스팅
		
		socket.close();
		for(int number:lotto) {
			System.out.println(number);
		}
		
	}

}
