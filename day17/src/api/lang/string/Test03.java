package api.lang.string;

import java.util.*;

public class Test03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("닉네임을 입력하세요.");
		String name=sc.next();
		
		boolean b1=name.contains("운영자");
		boolean b2=Character.isDigit(name.charAt(0));
		
		if(b1==false &&b2==false && name.length()>=2&&name.length()<=10) {
			System.out.println("닉네임 설정이 완료되었습니다.");
		}else {
			System.out.println("잘못된 닉네임입니다.");
		}
		
		

	}

}
