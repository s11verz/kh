package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test11 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		3. 사용자에게 아이디와 비밀번호를 입력받아 Member 테이블을 이용하여 로그인 작업을 수행 후 출력
		
//		데이터 준비
		String memberId = "test12345";
		String memberPw = "test12345";
		
//		데이터베이스 단일조회
//		(1) 아이디를 이용하여 단일조회를 수행한 뒤 비밀번호를 비교
//		(2) 아이디와 비밀번호를 이용하여 단일조회를 수행
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		
		String sql = "select * from member where member_id = ? and member_pw = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ps.setString(2, memberPw);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {//로그인 성공
			System.out.println("로그인 성공");
		}
		else {//아이디와 비밀번호 중 뭔가 안맞는 경우 - 로그인 실패
			System.out.println("로그인 실패");
		}
		
		con.close();
	}
}








