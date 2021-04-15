package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class MemberDao {
	
	public int exit(String memberId, String memberPw) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		String sql = "delete from member where member_id=? and member_pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, memberId);
		ps.setString(2, memberPw);
		int count=ps.executeUpdate();
		
		con.close();
		
		return count;
	}
	public int givePoint(String memberId, int memberPoint) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		String sql = "update member set member_point=member_point+? where member_id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, memberPoint);
		ps.setString(2, memberId);
		int count=ps.executeUpdate();
		
		con.close();
		
		return count;
	}
	public boolean changePassword(String memberId, String old_memberPw, String new_memberPw) throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		String sql = "update member set member_pw=? where member_id=? and member_pw=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, new_memberPw);
		ps.setString(2, memberId);
		ps.setString(3, old_memberPw);
		int count=ps.executeUpdate();
		
		con.close();
		
		/*if(count>0) return true;
		else return false;*/
		
		return count>0;
	}
}
