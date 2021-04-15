package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("성공!");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","study");
		System.out.println("DB 연결 성공!");
		
		con.close();
		System.out.println("연결 종료!");
	}

}
