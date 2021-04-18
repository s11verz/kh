package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("음원 번호를 입력하세요.");
		int no=sc.nextInt();
		int like_count=1;

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","study");
		
		String sql="update music set music_like_count=music_like_count+? where music_no=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, like_count);
		ps.setInt(2, no);
		
		int count=ps.executeUpdate();
		
		con.close();
		
		if(count>0) {
			System.out.println("좋아요 갯수가 수정되었습니다.");
		}else {
			System.out.println("해당 번호의 음원이 존재하지 않습니다.");
		}
	}

}
