package module;

import java.util.Scanner;

import beans.MemberDao;

public class Test02 {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("사용자 아이디를 입력하세요");
		String memberId=sc.next();
		System.out.println("지급할 포인트를 입력하세요");
		int memberPoint=sc.nextInt();
		
		MemberDao memberDao=new MemberDao();
		int count=memberDao.givePoint(memberId,memberPoint);
		
		if(count>0) {
			System.out.println(memberId+"회원님께 "+memberPoint+"점을 지급하였습니다.");
		}else {
			System.out.println("회원이 존재하지 않습니다.");
		}
	}

}
