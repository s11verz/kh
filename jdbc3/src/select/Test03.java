package select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test03 {
	public static void main(String[] args) throws Exception{
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		
		String sql = "select "
								+ "C.*, I.*, W.wish_time "
							+ "from "
								+ "wishlist W "
									+ "inner join client C on W.client_no = C.client_no "
									+ "inner join item I on W.item_no = I.item_no";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.print(rs.getInt("client_no"));
			System.out.print("/");
			System.out.print(rs.getInt("item_no"));
			System.out.print("/");
			System.out.print(rs.getDate("wish_time"));
			System.out.print("/");
			System.out.print(rs.getString("client_id"));
			System.out.print("/");
			System.out.print(rs.getString("item_name"));
			System.out.print("/");
			System.out.print(rs.getInt("item_price"));
			
			System.out.println();
		}
		
		con.close();
		
	}
}