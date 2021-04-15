package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Q : Product 테이블의 데이터를 조회
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		
		String sql = "select * from product order by no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getInt("no"));//no라는 컬럼의 값을 출력
			//System.out.print(rs.getInt(1));//1번째 컬럼의 값을 출력
			System.out.print("/");
			System.out.print(rs.getString("name"));
			System.out.print("/");
			System.out.print(rs.getString("type"));
			System.out.print("/");
			System.out.print(rs.getInt("price"));
			System.out.print("/");
			System.out.print(rs.getDate("made"));//java.sql.Date 형태로 추출
			System.out.print("/");
			System.out.print(rs.getDate("expire"));
			
			System.out.println();
		}
		
		con.close();
	}
}
