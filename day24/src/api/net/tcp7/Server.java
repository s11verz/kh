package api.net.tcp7;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Server {
	public static void main(String[] args) throws IOException {
		//데이터 준비
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<=45;i++) {
			list.add(i);
		}
		Collections.shuffle(list);
//		List<Integer> lotto=list.subList(0, 6);
//		Collections.sort(lotto);
		Set<Integer> lotto=new TreeSet<>(list.subList(0,6));
		ServerSocket server=new ServerSocket(30000);
		Socket socket=server.accept();
		
		//BufferedOutputStream buffer=new BufferedOutputStream(socket.getOutputStream());
		//ObjectOutputStream oos=new ObjectOutputStream(buffer);
		ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
		
		oos.writeObject(lotto);
		oos.flush();
		socket.close();
	}

}
