package api.lang.string;
import java.util.*;
public class Test01 {
public static void main(String[] args) {
	String id=new String("admin");
	String pw=new String("test1234");
	
	Scanner sc=new Scanner(System.in);
	System.out.println("아이디를 입력하세요");
	String userId=sc.next();
	System.out.println("비밀번호를 입력하세요");
	String userPw=sc.next();
	
	if(id.equals(userId)&&pw.equals(userPw)) {
		System.out.println("로그인 성공!");
	}else {
		System.out.println("로그인 실패!");
	}
	
	
}
}
