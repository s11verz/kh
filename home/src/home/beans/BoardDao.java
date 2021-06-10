package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

//board 테이블과 관련된 JDBC를 수행하는 클래스
public class BoardDao {

	public static final String USERNAME = "study";
	public static final String PASSWORD = "study";
	
	//시퀀스 번호를 생성하는 기능
	public int getSequence() throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select board_seq.nextval from dual";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int no = rs.getInt(1);
		
		con.close();
		return no;
	}
	
	//게시글을 등록하는 기능
	public void write(BoardDto boardDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
//		String sql = "insert into board values(?, ?, ?, ?, ?, sysdate, 0, 0, 0, 0, ?, ?, ?)";
		String sql = "insert into board("
							+ "board_no, board_header, board_title, board_content, board_writer,"
							+ "super_no, group_no, depth) "
							+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardDto.getBoardNo());
		ps.setString(2, boardDto.getBoardHeader());
		ps.setString(3, boardDto.getBoardTitle());
		ps.setString(4, boardDto.getBoardContent());
		ps.setInt(5, boardDto.getBoardWriter());
		if(boardDto.getSuperNo() == 0) {//새글일 경우
			ps.setNull(6, Types.INTEGER);//6번 물음표에 숫자(INTEGER) 형태의 null을 설정하라!
		}
		else {//답글일 경우
			ps.setInt(6, boardDto.getSuperNo());
		}
		ps.setInt(7, boardDto.getGroupNo());
		ps.setInt(8, boardDto.getDepth());
		
		ps.execute();
		con.close();
	}

	//상세보기 기능
	public BoardDto get(int boardNo) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select * from board where board_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		ResultSet rs = ps.executeQuery();
		
		BoardDto boardDto;
		if(rs.next()) {
			boardDto = new BoardDto();
			
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardHeader(rs.getString("board_header"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardWriter(rs.getInt("board_writer"));
			boardDto.setBoardTime(rs.getDate("board_time"));
			boardDto.setBoardRead(rs.getInt("board_read"));
			boardDto.setBoardLike(rs.getInt("board_like"));
			boardDto.setBoardHate(rs.getInt("board_hate"));
			boardDto.setBoardReply(rs.getInt("board_reply"));
			
			boardDto.setSuperNo(rs.getInt("super_no"));
			boardDto.setGroupNo(rs.getInt("group_no"));
			boardDto.setDepth(rs.getInt("depth"));
		}
		else {
			boardDto = null;
		}
		
		con.close();
		
		return boardDto;
	}
	
	//게시글 수정 기능
	public boolean edit(BoardDto boardDto) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "update board "
								+ "set board_header=?, board_title=?, board_content=? "
								+ "where board_no=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, boardDto.getBoardHeader());
		ps.setString(2, boardDto.getBoardTitle());
		ps.setString(3, boardDto.getBoardContent());
		ps.setInt(4, boardDto.getBoardNo());
		int count = ps.executeUpdate();
		
		con.close();
		return count > 0;
	}
	
	//게시글 삭제 기능
	public boolean delete(int boardNo) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "delete board where board_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		int count = ps.executeUpdate();
		
		con.close();
		return count > 0;
	}
	
	//목록
	public List<BoardDto> list(int startRow, int endRow) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select * from("
								+ "select rownum rn, TMP.* from("
									+ "select "
											+ "board_no, board_header, board_title, board_writer, "
											+ "board_time, board_read, board_like, board_hate "
									+ "from board "
									+ "order by board_no desc"
								+ ")TMP"
							+ ") where rn between ? and ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, startRow);
		ps.setInt(2, endRow);
		ResultSet rs = ps.executeQuery();
		
		List<BoardDto> boardList = new ArrayList<>();
		while(rs.next()) {
			BoardDto boardDto = new BoardDto();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardHeader(rs.getString("board_header"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardTime(rs.getDate("board_time"));
			boardDto.setBoardWriter(rs.getInt("board_writer"));
			boardDto.setBoardRead(rs.getInt("board_read"));
			boardDto.setBoardLike(rs.getInt("board_like"));
			boardDto.setBoardHate(rs.getInt("board_hate"));
			boardDto.setBoardReply(rs.getInt("board_reply"));
			
			boardDto.setSuperNo(rs.getInt("super_no"));
			boardDto.setGroupNo(rs.getInt("group_no"));
			boardDto.setDepth(rs.getInt("depth"));
			
			boardList.add(boardDto);
		}
		
		con.close();
		return boardList;
	}
	
	//검색 기능
	public List<BoardDto> search(String type, String keyword, int startRow, int endRow) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select * from("
							+ "select rownum rn, TMP.* from("
								+ "select "
									+ "board_no, board_header, board_title, board_writer, "
									+ "board_time, board_read, board_like, board_hate "
									+ "from board "
								+ "where instr(#1, ?) > 0"
//								+ "where #1 like '%'||?||'%'"
								+ "order by board_no desc"
							+ ")TMP"
						+ ") where rn between ? and ?";
		sql = sql.replace("#1", type);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ps.setInt(2, startRow);
		ps.setInt(3, endRow);
		ResultSet rs = ps.executeQuery();
		
		List<BoardDto> boardList = new ArrayList<>();
		while(rs.next()) {
			BoardDto boardDto = new BoardDto();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardHeader(rs.getString("board_header"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardTime(rs.getDate("board_time"));
			boardDto.setBoardWriter(rs.getInt("board_writer"));
			boardDto.setBoardRead(rs.getInt("board_read"));
			boardDto.setBoardLike(rs.getInt("board_like"));
			boardDto.setBoardHate(rs.getInt("board_hate"));
			boardDto.setBoardReply(rs.getInt("board_reply"));
			
			boardDto.setSuperNo(rs.getInt("super_no"));
			boardDto.setGroupNo(rs.getInt("group_no"));
			boardDto.setDepth(rs.getInt("depth"));
			
			boardList.add(boardDto);
		}
		
		con.close();
		return boardList;
	}
	
	//페이지블럭 계산을 위한 카운트 기능(목록/검색)
	public int getCount() throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select count(*) from board";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		
		con.close();
		
		return count;
	}
	
	public int getCount(String type, String keyword) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select count(*) from board where instr(#1, ?) > 0";
		sql = sql.replace("#1", type);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		
		con.close();
		
		return count;
	}
	
	//조회수 증가 기능 : 특정 번호의 게시글을 작성자가 아닌 사람이 읽을 경우에만 증가되도록 구현
	public boolean read(int boardNo, int memberNo) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "update board "
							+ "set board_read = board_read + 1 "
							+ "where board_no = ? and board_writer != ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		ps.setInt(2, memberNo);
		int count = ps.executeUpdate();
		
		con.close();
		return count > 0;
	}
	
	//좋아요 개수 갱신 기능
	public boolean refreshBoardLike(int boardNo) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		String sql = "update board "
						+ "set board_like = ( select count(*) from board_like where board_no = ? ) "
						+ "where board_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		ps.setInt(2, boardNo);
		int count = ps.executeUpdate();
		con.close();
		return count > 0;
	}
	
	//댓글 개수 갱신 기능
	public boolean refreshBoardReply(int boardNo) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		String sql = "update board "
							+ "set board_reply = ( select count(*) from reply where reply_origin = ? ) "
							+ "where board_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		ps.setInt(2, boardNo);
		int count = ps.executeUpdate();
		con.close();
		return count > 0;
	}
	
	//이전글 조회 기능
	public BoardDto getPrevious(int boardNo) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		String sql = "select * from board "
						+ "where board_no = ( select max(board_no) from board where board_no < ? )";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		ResultSet rs = ps.executeQuery();
		BoardDto boardDto;
		if(rs.next()) {
			boardDto = new BoardDto();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardHeader(rs.getString("board_header"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardWriter(rs.getInt("board_writer"));
			boardDto.setBoardTime(rs.getDate("board_time"));
			boardDto.setBoardRead(rs.getInt("board_read"));
			boardDto.setBoardLike(rs.getInt("board_like"));
			boardDto.setBoardHate(rs.getInt("board_hate"));
			boardDto.setBoardReply(rs.getInt("board_reply"));
			
			boardDto.setSuperNo(rs.getInt("super_no"));
			boardDto.setGroupNo(rs.getInt("group_no"));
			boardDto.setDepth(rs.getInt("depth"));
		}
		else {
			boardDto = null;
		}
		con.close();
		return boardDto;
		
	}
	
	//다음글 조회 기능
	public BoardDto getNext(int boardNo) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		String sql = "select * from board "
						+ "where board_no = ( select min(board_no) from board where board_no > ? )";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, boardNo);
		ResultSet rs = ps.executeQuery();
		BoardDto boardDto;
		if(rs.next()) {
			boardDto = new BoardDto();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardHeader(rs.getString("board_header"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardContent(rs.getString("board_content"));
			boardDto.setBoardWriter(rs.getInt("board_writer"));
			boardDto.setBoardTime(rs.getDate("board_time"));
			boardDto.setBoardRead(rs.getInt("board_read"));
			boardDto.setBoardLike(rs.getInt("board_like"));
			boardDto.setBoardHate(rs.getInt("board_hate"));
			boardDto.setBoardReply(rs.getInt("board_reply"));
			
			boardDto.setSuperNo(rs.getInt("super_no"));
			boardDto.setGroupNo(rs.getInt("group_no"));
			boardDto.setDepth(rs.getInt("depth"));
		}
		else {
			boardDto = null;
		}
		con.close();
		return boardDto;
	}
	
}











