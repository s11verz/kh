package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) throws Exception {
		
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("제목을 입력하세요.");
		String name=sc.next();
		System.out.println("가수를 입력하세요.");
		String artist=sc.next();
		System.out.println("앨범 명을 입력하세요.");
		String album=sc.next();
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","study");
		
		String sql="insert into music values (music_seq.nextval,?,?,?,0,0)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,name);
		ps.setString(2,artist);
		ps.setString(3,album);
		
		ps.execute();
		con.close();
		System.out.println("삽입 완료!");
		
	}
}
