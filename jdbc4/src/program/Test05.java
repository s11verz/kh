package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test05 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","study");
		
		String sql="select * from music order by music_no";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		con.close();
		
		while(rs.next()) {
			System.out.println("데이터 발견");
			System.out.println(rs.getInt("music_no"));
			System.out.println(rs.getString("music_name"));
			System.out.println(rs.getString("music_artist"));
			System.out.println(rs.getString("music_album"));
			
		}
		System.out.println("출력이 완료되었습니다.");
		
	}

}
