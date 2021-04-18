package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
	public void regist(String memberId, String memberPw, String memberNickname,String memberBirth, String memberPhone, String memberEmail) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		String sql="insert into member values("
				+ "member_seq.nextval,?,?,?,?,?,sysdate,?,0,'일반')";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, memberId);
		ps.setString(2, memberPw);
		ps.setString(3, memberNickname);
		ps.setString(4, memberBirth);
		ps.setString(5, memberPhone);
		ps.setString(6, memberEmail);
		ps.execute();
		
		con.close();
		
		
	}
	public void regist(MemberDto memberDto) throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		String sql="insert into member values("
				+ "member_seq.nextval,?,?,?,?,?,sysdate,?,0,'일반')";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, memberDto.getId());
		ps.setString(2, memberDto.getPw());
		ps.setString(3, memberDto.getNickname());
		ps.setString(4, memberDto.getBirth());
		ps.setString(5, memberDto.getPhone());
		ps.setString(6, memberDto.getEmail());
		ps.execute();
		
		con.close();
	}
	public List<MemberDto> selectList() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "study", "study");
		String sql="select * from member order by member_no asc";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		List<MemberDto> list=new ArrayList<>();
		
		while(rs.next()) {
			MemberDto memberDto=new MemberDto();
			
			memberDto.setNo(rs.getInt("member_no"));
			memberDto.setId(rs.getString("member_id"));
			memberDto.setPw(rs.getString("member_pw"));
			memberDto.setNickname(rs.getString("member_nickname"));
			memberDto.setBirth(rs.getString("member_birth"));
			memberDto.setPhone(rs.getString("member_phone"));
			memberDto.setEmail(rs.getString("member_email"));
			memberDto.setPoint(rs.getInt("member_point"));
			memberDto.setJoin(rs.getDate("member_join"));
			memberDto.setGrade(rs.getString("member_grade"));
			list.add(memberDto);
		}
		

		
		con.close();
		return list;
	}
}
