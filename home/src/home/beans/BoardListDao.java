package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//board_list라는 view를 조회하기 위한 DAO
//= BoardDao에서 해도 되지만, 역할분담을 명확히 하기 위해서 생성
//= 게시글 목록과 검색 기능만 구현(+페이징 적용)
public class BoardListDao {
	
	public static final String USERNAME = "study";
	public static final String PASSWORD = "study";
	
	//목록
	public List<BoardListDto> list(int startRow, int endRow) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select * from("
								+ "select rownum rn, TMP.* from("
//									기존의 목록 코드 : 번호 역순 조회
//									+ "select * from board_list order by board_no desc"

//									신규 목록 코드 : 트리 정렬 사용하여 계층형 구조를 조회
//									connect by prior 를 이용하여 어떤 항목이 상하관계로 연결되어있는지 설명
//									start with 를 이용하여 모든 연결의 시작점을 알려준다
//									order siblings by 를 이용하여 설정된 정보를 이용하여 정렬할 기준을 설명
									+ "select * from board_list "
									+ "connect by prior board_no = super_no "
									+ "start with super_no is null "
									+ "order siblings by group_no desc, board_no asc "
								+ ")TMP"
							+ ") where rn between ? and ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, startRow);
		ps.setInt(2, endRow);
		ResultSet rs = ps.executeQuery();
		
		List<BoardListDto> boardList = new ArrayList<>();
		while(rs.next()) {
			BoardListDto boardListDto = new BoardListDto();
			boardListDto.setBoardNo(rs.getInt("board_no"));
			boardListDto.setBoardHeader(rs.getString("board_header"));
			boardListDto.setBoardTitle(rs.getString("board_title"));
			boardListDto.setBoardTime(rs.getDate("board_time"));
			boardListDto.setBoardRead(rs.getInt("board_read"));
			boardListDto.setBoardLike(rs.getInt("board_like"));
			boardListDto.setBoardHate(rs.getInt("board_hate"));
			boardListDto.setBoardReply(rs.getInt("board_reply"));
			
			boardListDto.setMemberNo(rs.getInt("member_no"));
			boardListDto.setMemberNick(rs.getString("member_nick"));
			
			boardListDto.setSuperNo(rs.getInt("super_no"));
			boardListDto.setGroupNo(rs.getInt("group_no"));
			boardListDto.setDepth(rs.getInt("depth"));
			
			boardList.add(boardListDto);
		}
		con.close();
		return boardList;
	}
	
	//검색 기능
	public List<BoardListDto> search(String type, String keyword, int startRow, int endRow) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select * from("
							+ "select rownum rn, TMP.* from("
				
//								기존 검색 코드
//								+ "select * from board_list "
//								+ "where instr(#1, ?) > 0 "
//								+ "order by board_no desc"
								
//								신규 검색 코드 : 트리 정렬 사용하여 계층형 구조를 조회
								+ "select * from board_list "
								+ "where instr(#1, ?) > 0 "
								+ "connect by prior board_no = super_no "
								+ "start with super_no is null "
								+ "order siblings by group_no desc, board_no asc "
							+ ")TMP"
						+ ") where rn between ? and ?";
		sql = sql.replace("#1", type);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
		ps.setInt(2, startRow);
		ps.setInt(3, endRow);
		ResultSet rs = ps.executeQuery();
		
		List<BoardListDto> boardList = new ArrayList<>();
		while(rs.next()) {
			BoardListDto boardListDto = new BoardListDto();
			boardListDto.setBoardNo(rs.getInt("board_no"));
			boardListDto.setBoardHeader(rs.getString("board_header"));
			boardListDto.setBoardTitle(rs.getString("board_title"));
			boardListDto.setBoardTime(rs.getDate("board_time"));
			boardListDto.setBoardRead(rs.getInt("board_read"));
			boardListDto.setBoardLike(rs.getInt("board_like"));
			boardListDto.setBoardHate(rs.getInt("board_hate"));
			boardListDto.setBoardReply(rs.getInt("board_reply"));
			
			boardListDto.setMemberNo(rs.getInt("member_no"));
			boardListDto.setMemberNick(rs.getString("member_nick"));
			
			boardListDto.setSuperNo(rs.getInt("super_no"));
			boardListDto.setGroupNo(rs.getInt("group_no"));
			boardListDto.setDepth(rs.getInt("depth"));
			
			boardList.add(boardListDto);
		}
		con.close();
		return boardList;
	}
	
	//특정회원의 글 목록 조회 기능
	public List<BoardListDto> searchByWriter(int memberNo, int startRow, int endRow) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select * from("
							+ "select rownum rn, TMP.* from(" 
								+ "select * from board_list "
								+ "where member_no = ?"
								+ "order by board_no desc"
							+ ")TMP"
						+ ") where rn between ? and ?";
							
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, memberNo);
		ps.setInt(2, startRow);
		ps.setInt(3, endRow);
		ResultSet rs = ps.executeQuery();
		
		List<BoardListDto> boardList = new ArrayList<>();
		while(rs.next()) {
			BoardListDto boardListDto = new BoardListDto();
			boardListDto.setBoardNo(rs.getInt("board_no"));
			boardListDto.setBoardHeader(rs.getString("board_header"));
			boardListDto.setBoardTitle(rs.getString("board_title"));
			boardListDto.setBoardTime(rs.getDate("board_time"));
			boardListDto.setBoardRead(rs.getInt("board_read"));
			boardListDto.setBoardLike(rs.getInt("board_like"));
			boardListDto.setBoardHate(rs.getInt("board_hate"));
			boardListDto.setBoardReply(rs.getInt("board_reply"));
			
			boardListDto.setMemberNo(rs.getInt("member_no"));
			boardListDto.setMemberNick(rs.getString("member_nick"));
			
			boardListDto.setSuperNo(rs.getInt("super_no"));
			boardListDto.setGroupNo(rs.getInt("group_no"));
			boardListDto.setDepth(rs.getInt("depth"));
			
			boardList.add(boardListDto);
		}
		con.close();
		return boardList;
	}
	
	//특정회원의 좋아요 글 목록 조회 기능
	public List<BoardListDto> searchByLike(int memberNo, int startRow, int endRow) throws Exception {
		Connection con = JdbcUtils.getConnection();;
		
		String sql = "select * from("
							+ "select rownum rn, TMP.* from(" 
								+"select "
									+ "BLIST.* "
									+ "from board_list BLIST "
									+ "inner join board_like BLIKE on BLIST.board_no = BLIKE.board_no "
									+ "where BLIST.member_no = ?"
									+ "order by BLIST.board_no desc"
								+ ")TMP"
							+ ") where rn between ? and ?";
							
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, memberNo);
		ps.setInt(2, startRow);
		ps.setInt(3, endRow);
		ResultSet rs = ps.executeQuery();
		
		List<BoardListDto> boardList = new ArrayList<>();
		while(rs.next()) {
			BoardListDto boardListDto = new BoardListDto();
			boardListDto.setBoardNo(rs.getInt("board_no"));
			boardListDto.setBoardHeader(rs.getString("board_header"));
			boardListDto.setBoardTitle(rs.getString("board_title"));
			boardListDto.setBoardTime(rs.getDate("board_time"));
			boardListDto.setBoardRead(rs.getInt("board_read"));
			boardListDto.setBoardLike(rs.getInt("board_like"));
			boardListDto.setBoardHate(rs.getInt("board_hate"));
			boardListDto.setBoardReply(rs.getInt("board_reply"));
			
			boardListDto.setMemberNo(rs.getInt("member_no"));
			boardListDto.setMemberNick(rs.getString("member_nick"));
			
			boardListDto.setSuperNo(rs.getInt("super_no"));
			boardListDto.setGroupNo(rs.getInt("group_no"));
			boardListDto.setDepth(rs.getInt("depth"));
			
			boardList.add(boardListDto);
		}
		con.close();
		return boardList;
	}
	
}



