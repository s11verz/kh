package api.collector;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class Test03 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		List<Member> list=new ArrayList<>();
		list.add(new Member("master","master1234"));
		list.add(new Member("tester","tester1234"));
		list.add(new Member("user","user1234"));
		list.add(new Member("student","student1234"));
		list.add(new Member("manager","manager1234"));
		
		System.out.print("아이디: ");
		String name=sc.next();
		
		System.out.print("비밀번호: ");
		String pw=sc.next();
		
	int count=0;
		for(int i=0;i<list.size();i++) {
			Member m=list.get(i);
			if(m.getName().equals(name)&&m.getPw().equals(pw)) {
				count++;
				break;
			}
				
		}
		if(count>0) {
			System.out.println("로그인 성공!");
		}else {
			System.out.println("로그인 실패!");
		}
		
	}}


