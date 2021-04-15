package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String menuName="프라푸치노";
		int menuPrice=4000;
		
		//드라이버 설치
		Class.forName("oracle.jdbc.OracleDriver");
		
		//데이터베이스 연결
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","study");
		
		//명령 전송
		//String sql="insert into menu values (menu_seq.nextval,'"+menuName+"','"+menuPrice+"')";
		String sql="insert into menu values (menu_seq.nextval,?,?)";
		System.out.println(sql);
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,menuName);
		ps.setInt(2,menuPrice);
		
		ps.execute();
	
		
		//데이터베이스 출력
		con.close();
		
		System.out.println("성공!");
	}

}
