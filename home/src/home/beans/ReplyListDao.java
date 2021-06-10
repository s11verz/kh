package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReplyListDao {
	
	public static final String USERNAME = "study";
	public static final String PASSWORD = "study";
	
	public List<ReplyListDto> list(int replyOrigin) throws Exception{
		Connection con = JdbcUtils.getConnection();;
		String sql = "select * from reply_list where reply_origin = ? order by reply_no asc";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, replyOrigin);
		ResultSet rs = ps.executeQuery();
		
		List<ReplyListDto> replyList = new ArrayList<>();
		while(rs.next()) {
			ReplyListDto replyListDto = new ReplyListDto();
			replyListDto.setReplyNo(rs.getInt("reply_no"));
			replyListDto.setReplyContent(rs.getString("reply_content"));
			replyListDto.setReplyWriter(rs.getInt("reply_writer"));
			replyListDto.setReplyTime(rs.getDate("reply_time"));
			replyListDto.setReplyOrigin(rs.getInt("reply_origin"));
			replyListDto.setMemberNick(rs.getString("member_nick"));
			replyList.add(replyListDto);
		}
		
		con.close();
		return replyList;
	}
	
	public List<ReplyListDto> list(int replyOrigin, int startRow, int endRow) throws Exception{
		Connection con = JdbcUtils.getConnection();;
		String sql = "select * from ("
							+ "select rownum rn, TMP.* from ("
								+ "select * from reply_list where reply_origin = ? order by reply_no asc"
							+ ")TMP"
						+ ") where rn between ? and ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, replyOrigin);
		ps.setInt(2, startRow);
		ps.setInt(3, endRow);
		ResultSet rs = ps.executeQuery();
		
		List<ReplyListDto> replyList = new ArrayList<>();
		while(rs.next()) {
			ReplyListDto replyListDto = new ReplyListDto();
			replyListDto.setReplyNo(rs.getInt("reply_no"));
			replyListDto.setReplyContent(rs.getString("reply_content"));
			replyListDto.setReplyWriter(rs.getInt("reply_writer"));
			replyListDto.setReplyTime(rs.getDate("reply_time"));
			replyListDto.setReplyOrigin(rs.getInt("reply_origin"));
			replyListDto.setMemberNick(rs.getString("member_nick"));
			replyList.add(replyListDto);
		}
		
		con.close();
		return replyList;
	}
	
}