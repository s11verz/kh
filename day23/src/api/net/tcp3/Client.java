package api.net.tcp3;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws IOException {
		// String host="127.0.0.1";//자기자신
		String host = "localhost";// 자기자신
		int port = 30000;

		// 유효성 검증
		InetAddress address = InetAddress.getByName(host);

		// 소켓 생성
		Socket socket = new Socket(address, port);

		// 전송되는 byte를 수신하옇 화면에 출력
		InputStream in = socket.getInputStream();

		while (true) {
			int n = in.read();
			if (n == -1)
				break;
			System.out.println("n=" + n);
		}

		// 연결 종료
		socket.close();

	}

}
