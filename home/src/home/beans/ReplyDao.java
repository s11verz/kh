package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReplyDao {

	public static final String USERNAME = "study";
	public static final String PASSWORD = "study";
	
	//댓글 등록 : 댓글내용, 원본글번호, 회원번호 --> 댓글정보
	public void insert(ReplyDto replyDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		String sql = "insert into reply values(reply_seq.nextval, ?, sysdate, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, replyDto.getReplyContent());
		ps.setInt(2, replyDto.getReplyWriter());
		ps.setInt(3, replyDto.getReplyOrigin());
		ps.execute();
		con.close();
	}
	
	//댓글 수정 : 댓글내용, 댓글번호, 회원번호 --> 댓글정보
	public boolean edit(ReplyDto replyDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		String sql = "update reply set reply_content = ? where reply_no = ? and reply_writer = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, replyDto.getReplyContent());
		ps.setInt(2, replyDto.getReplyNo());
		ps.setInt(3, replyDto.getReplyWriter());
		int count = ps.executeUpdate();
		con.close();
		return count > 0;
	}
	
	//댓글 삭제 : 댓글번호, 회원번호 --> 댓글정보
	public boolean delete(ReplyDto replyDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		String sql = "delete reply where reply_no = ? and reply_writer = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, replyDto.getReplyNo());
		ps.setInt(2, replyDto.getReplyWriter());
		int count = ps.executeUpdate();
		con.close();
		return count > 0;
	}
	
	//댓글 리스트 : 원본글번호
	public List<ReplyDto> list(int replyOrigin) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		String sql = "select * from reply where reply_origin = ? order by reply_no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, replyOrigin);
		ResultSet rs = ps.executeQuery();
		
		List<ReplyDto> replyList = new ArrayList<>();
		while(rs.next()) {
			ReplyDto replyDto = new ReplyDto();
			replyDto.setReplyNo(rs.getInt("reply_no"));
			replyDto.setReplyContent(rs.getString("reply_content"));
			replyDto.setReplyTime(rs.getDate("reply_time"));
			replyDto.setReplyOrigin(rs.getInt("reply_origin"));
			replyDto.setReplyWriter(rs.getInt("reply_writer"));
			replyList.add(replyDto);
		}
		
		con.close();
		return replyList;
	}
}



