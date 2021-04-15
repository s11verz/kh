package update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("상품 번호를 입력하세요.");
		int no=sc.nextInt();
		System.out.println("상품 가격을 입력하세요.");
		int price=sc.nextInt();
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","study","study");
		
		String sql="update product set price=? where no=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, price);
		ps.setInt(2, no);
		
		int count=ps.executeUpdate();
		
		con.close();
		
		if(count>0) {
			System.out.println("상품 가격이 수정되었습니다.");
		}else {
			System.out.println("해당 번호의 상품이 존재하지 않습니다.");
		}
	}

}
