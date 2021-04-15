package module;

import java.util.Scanner;

import beans.MemberDao;

public class Test03 {
	public static void main(String[] args) throws Exception {
		
	Scanner sc=new Scanner(System.in);
	System.out.println("사용자 아이디를 입력하세요");
	String memberId=sc.next();
	System.out.println("사용자 비밀번호를 입력하세요");
	String old_memberPw=sc.next();
	System.out.println("새로운 비밀번호를 입력하세요");
	String new_memberPw=sc.next();
	
	MemberDao memberDao=new MemberDao();
	boolean result=memberDao.changePassword(memberId,old_memberPw,new_memberPw);
	
	if(result) {
		System.out.println(memberId+"회원님의 비밀번호를 "+new_memberPw+"로 변경하였습니다.");
	}else {
		System.out.println("정보가 일치하지 않습니다.");
	}
}

}
