package home.beans;

import java.sql.Date;

//board테이블의 데이터 1묶음을 포장하기 위한 클래스
public class BoardDto {
	private int boardNo;
	private String boardHeader;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	private Date boardTime;
	private int boardRead;
	private int boardLike;
	private int boardHate;
	private int boardReply;
	
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
	public String getBoardHeaderString() {
		if(boardHeader == null) return "";
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
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(int boardWriter) {
		this.boardWriter = boardWriter;
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
	public BoardDto() {
		super();
	}
}