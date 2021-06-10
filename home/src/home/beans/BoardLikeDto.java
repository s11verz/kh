package home.beans;

import java.sql.Date;

public class BoardLikeDto {
	private int memberNo;
	private int boardNo;
	private Date likeTime;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public Date getLikeTime() {
		return likeTime;
	}
	public void setLikeTime(Date likeTime) {
		this.likeTime = likeTime;
	}
	public BoardLikeDto() {
		super();
		
	}
	
}
