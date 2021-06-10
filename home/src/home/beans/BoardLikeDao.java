package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardLikeDao {

	public static final String USERNAME = "study";
	public static final String PASSWORD = "study";
	
	//좋아요 등록 기능
	public void insert(BoardLikeDto boardLikeDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		String sql = "insert into board_like values(?, ?, sysdate)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardLikeDto.getMemberNo());
		ps.setInt(2, boardLikeDto.getBoardNo());
		ps.execute();
		con.close();
	}
	
	//좋아요 삭제 기능
	public boolean delete(BoardLikeDto boardLikeDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		String sql = "delete board_like where member_no=? and board_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardLikeDto.getMemberNo());
		ps.setInt(2, boardLikeDto.getBoardNo());
		int count = ps.executeUpdate();
		con.close();
		return count > 0;
	}
	
	//좋아요 확인 기능
	public boolean check(BoardLikeDto boardLikeDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		String sql = "select * from board_like where board_no=? and member_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardLikeDto.getBoardNo());
		ps.setInt(2, boardLikeDto.getMemberNo());
		ResultSet rs = ps.executeQuery();
		boolean result = rs.next();
		con.close();
		return result;
	}
}

