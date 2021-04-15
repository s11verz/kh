package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test06 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//데이터 입력
		int min = 1000;
		int max = 2000;
		
		//데이터베이스 조회
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		
//		String sql = "select * from product where price >= ? and price <= ? order by price asc, no asc";
		String sql = "select * from product where price between ? and ? order by price asc, no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, min);
		ps.setInt(2, max);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getInt("no"));
			System.out.print("/");
			System.out.print(rs.getString("name"));
			System.out.print("/");
			System.out.print(rs.getInt("price"));
			System.out.println();
		}
		
		con.close();
		
	}
}


