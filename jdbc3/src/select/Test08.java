package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test08 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		Q : 단일조회 살펴보기
//		= 결과가 1개만 나오는 조회 (안나올 수는 있음)
//		= 유니크(Unique) 또는 기본키(Primary key) 항목으로 조회할 경우가 여기에 해당
//		= 유사검색을 수행하면 안되고 일치하는 항목만 조회해야 함
				
		int academy_no = 10;
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		
		String sql = "select * from academy where academy_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, academy_no);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			System.out.println("데이터 발견");
			System.out.print(rs.getInt("academy_no"));
			System.out.print("/");
			System.out.print(rs.getString("academy_name"));
			System.out.println();
		}
		else {
			System.out.println("찾으시는 데이터가 존재하지 않습니다");
		}
		
		con.close();
	}
}




