package module;

import beans.MemberDao;

public class Test04 {
	public static void main(String[] args) throws Exception {
		String memberId="khacademy";
		String memberPw="khacademy";
		String memberNickname="학생님";
		String memberBirth="2000-01-01";
		String memberPhone="010-1212-3434";
		String memberEmail="khacademy@iei.or.kr";
		
		MemberDao memberDao =new MemberDao();
		memberDao.regist(memberId,memberPw,memberNickname,memberBirth,memberPhone,memberEmail);
		
		System.out.println("가입완료");
		


	}

}
