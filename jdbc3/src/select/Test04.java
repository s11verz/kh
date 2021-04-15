package select;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//목표 : select에 조건을 부여하여 목록을 조회
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 지점 : ");
		String keyword = sc.nextLine();
		sc.close();
		
		//데이터베이스 조회
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "study");		
		
		String sql = "select * from academy where academy_name = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();//select용 실행 구문
		
		while(rs.next()) {
			System.out.println(rs.getInt("academy_no"));
			System.out.println(rs.getString("academy_name"));
		}
		
		con.close();
	}
}


