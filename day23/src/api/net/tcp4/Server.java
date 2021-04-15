package api.net.tcp4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(30000);

		Socket socket = server.accept();
		System.out.println(socket.getInetAddress() + "가 접속하였습니다.");
		InputStream in = socket.getInputStream();

		File dir = new File("kh");//파일 알아서 지정
		dir.mkdirs();
		File target = new File(dir, "test");
		FileOutputStream out = new FileOutputStream(target);
		System.out.println("사용자가 보낸 파일을 수신합니다.");
		//byte[] buffer=new byte[1024];
		while (true) {
			int n = in.read();
			if (n == -1)
				break;
			out.write(n);
		}
		System.out.println("사용자가 보낸 파일을 모두 수신하였습니다.");
		out.close();
		socket.close();
		server.close();

	}

}
