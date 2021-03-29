package api.collection3;

import java.util.HashMap;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		HashMap<String, String> map=new HashMap<>();
		map.put("master", "master1234");
		map.put("tester", "tester1234");
		map.put("user", "user1234");
		map.put("student", "student1234");
		map.put("manager", "manager1234");
		
		System.out.println("아이디를 입력하세요.");
		String userId=sc.next();
		System.out.println("비밀번호를 입력하세요.");
		String userPw=sc.next();
		
		if(map.containsKey(userId)==true) {
			System.out.println("이미 사용중인 아이디입니다.");
		}else {
			System.out.println("회원가입이 완료되었습니다.");
		}

	}

}
