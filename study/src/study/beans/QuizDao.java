package study.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuizDao {
	public static final String USERNAME="study";
	public static final String PASSWORD="study";
	
	public int getSequenceNumber() throws Exception{
		Connection con=JdbcUtils.getConnection(USERNAME, PASSWORD);
		
		String sql="select quiz_seq.nextval from dual";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		rs.next();
		
		int sequence=rs.getInt(1);
		
		con.close();
		return sequence;
	}
	
	public void insert(QuizDto quizDto) throws Exception{
		Connection con=JdbcUtils.getConnection(USERNAME, PASSWORD);
		
		String sql = "insert into quiz values(?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, quizDto.getQuizNo());
		ps.setString(2, quizDto.getQuizContent());
		ps.execute();
		
		con.close();
	}

}
