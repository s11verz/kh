package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","study");
		
		String sql="select * from academy order by academy_no asc";
		PreparedStatement ps=con.prepareStatement(sql);
		//ps.execute();
		ResultSet rs=ps.executeQuery();
		con.close();
		//데이터가 있을 경우 만큼만 실행
		while(rs.next()) {
			System.out.println("데이터 발견");
			System.out.println(rs.getInt("academy_no"));
			System.out.println(rs.getString("academy_name"));
		}
		
		
		System.out.println("완료!");
	}

}
