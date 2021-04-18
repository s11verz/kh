package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("음원 번호를 입력하세요");
		int no=sc.nextInt();
		System.out.println("변경할 제목을 입력하세요.");
		String name=sc.next();
		System.out.println("변경할 가수를 입력하세요.");
		String artist=sc.next();
		System.out.println("변경할 앨범 명을 입력하세요.");
		String album=sc.next();
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","study");
	
		String sql="update music set music_name=?,music_artist=?,music_album=? where music_no=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, artist);
		ps.setString(3, album);
		ps.setInt(4, no);
		
		int count=ps.executeUpdate();
		
		con.close();
		if(count>0) {
			System.out.println("음원 정보가 수정되었습니다.");
		}else {
			System.out.println("해당 번호의 음원이 존재하지 않습니다.");
		}
		
	}

}
