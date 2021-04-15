package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc=new Scanner(System.in);
		System.out.println("사용자 아이디를 입력하세요.");
		String memberId = sc.next();
		System.out.println("지급할 포인트를 입력하세요.");
		int point = sc.nextInt();

		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		String sql = "update member set member_point=member_point+? where member_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, point);
		ps.setString(2, memberId);
		int count = ps.executeUpdate();
	
		con.close();
		if(count>0) {
			System.out.println(memberId+"회원에게 "+point+"점을 지급하였습니다.");
		}else {
			System.out.println(memberId+"회원은 존재하지 않습니다.");
		}
	}

}
