package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) throws Exception{
		
		//검색어 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("상품명 : ");
		String keyword = sc.nextLine();
		sc.close();
		
		//데이터베이스 조회
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		
		String sql = "select * from product where instr(name, ?) > 0 order by no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
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
