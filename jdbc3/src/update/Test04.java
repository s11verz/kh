package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("사용자 아이디를 입력하세요.");
		String memberId = sc.next();
		System.out.println("사용자 비밀번호를 입력하세요.");
		String memberPassword=sc.next();
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		String sql = "delete from member where member_id=? and member_pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ps.setString(2, memberPassword);
		int count = ps.executeUpdate();
		con.close();
		if(count>0) {
			System.out.println(memberId+"회원을 삭제하였습니다.");
		}else {
			System.out.println(memberId+"회원은 존재하지 않습니다.");
		}
	}

}
