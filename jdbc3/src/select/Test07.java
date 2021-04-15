package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) throws Exception{
//		Q : 검색어 하나만이 아닌 분류(항목)까지 선택하여 검색할 수 있는가?
		
//		데이터 준비
		Scanner sc = new Scanner(System.in);
		System.out.print("검색항목 : ");
		String type = sc.nextLine();
		System.out.print("검색어 : ");
		String keyword = sc.nextLine();
		sc.close();
		
//		데이터베이스 조회
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		
//		통합 SQL구문
//		= 항목도 모르고, 검색어도 모르니까 다 위치홀더(?) 처리해서 구현해본다
//		= 원하는 검색이 이루어지지 않는다
//		= 항목은 동적으로 설정되면 안된다(따옴표가 추가되면 안된다)
//		= 항목은 정적으로 설정해야 한다.
		String sql = "select * from product where instr(#1, ?) > 0 order by #1 asc";
		sql = sql.replace("#1", type);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ResultSet rs = ps.executeQuery();
			
		int count = 0;
		while(rs.next()) {
			System.out.print(rs.getInt("no"));
			System.out.print("/");
			System.out.print(rs.getString("name"));
			System.out.print("/");
			System.out.print(rs.getString("type"));
			System.out.print("/");
			System.out.print(rs.getInt("price"));
			System.out.println();
			count++;
		}
		
		con.close();
		
		if(count == 0) {
			System.out.println("데이터가 존재하지 않습니다");
		}
		
	}
}