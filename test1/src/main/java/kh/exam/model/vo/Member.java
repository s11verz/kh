package kh.exam.model.vo;

public class Member {

private int memberNo;

private String memberId;

private String memberPw;

private String memberName;

private String memberAddr;

public Member() {

super();

// TODO Auto-generated constructor stub

}

public Member(int memberNo, String memberId, String memberPw, String memberName, String memberAddr) {

super();

this.memberNo = memberNo;

this.memberId = memberId;

this.memberPw = memberPw;

this.memberName = memberName;

this.memberAddr = memberAddr;

}

public int getMemberNo() {

return memberNo;

}

public void setMemberNo(int memberNo) {

this.memberNo = memberNo;

}

public String getMemberId() {

return memberId;

}

public void setMemberId(String memberId) {

this.memberId = memberId;

}

public String getMemberPw() {

return memberPw;

}

public void setMemberPw(String memberPw) {

this.memberPw = memberPw;

}

public String getMemberName() {

return memberName;

}

public void setMemberName(String memberName) {

this.memberName = memberName;

}

public String getMemberAddr() {

return memberAddr;

}

public void setMemberAddr(String memberAddr) {

this.memberAddr = memberAddr;

}

}