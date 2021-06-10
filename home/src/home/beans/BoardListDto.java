package home.beans;

import java.sql.Date;

//board_list라는 view에 대응하는 DTO
public class BoardListDto {
	//게시글 정보 저장 변수
	private int boardNo;
	private String boardHeader;
	private String boardTitle;
	private Date boardTime;
	private int boardRead;
	private int boardLike;
	private int boardHate;
	private int boardReply;
	//회원 정보 저장 변수
	private int memberNo;
	private String memberNick;
	
	private int superNo;
	private int groupNo;
	private int depth;
	
	public int getSuperNo() {
		return superNo;
	}
	public void setSuperNo(int superNo) {
		this.superNo = superNo;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getBoardReply() {
		return boardReply;
	}
	public void setBoardReply(int boardReply) {
		this.boardReply = boardReply;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardHeader() {
		return boardHeader;
	}
	public void setBoardHeader(String boardHeader) {
		this.boardHeader = boardHeader;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public Date getBoardTime() {
		return boardTime;
	}
	public void setBoardTime(Date boardTime) {
		this.boardTime = boardTime;
	}
	public int getBoardRead() {
		return boardRead;
	}
	public void setBoardRead(int boardRead) {
		this.boardRead = boardRead;
	}
	public int getBoardLike() {
		return boardLike;
	}
	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}
	public int getBoardHate() {
		return boardHate;
	}
	public void setBoardHate(int boardHate) {
		this.boardHate = boardHate;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	public BoardListDto() {
		super();
	}
}