package api.lang.string;
import java.util.*;
public class Test04 {

	public static void main(String[] args) {
		String first="바나나";
		System.out.println("제시어:"+first);
		String next;
		while(true) {
		System.out.println("다음 제시어(3글자)를 입력하세요.");
		
		Scanner sc=new Scanner(System.in);
		next=sc.next();
		if(next.length()!=3) {
			System.out.println("반드시 3글자를 입력하세요.");
			continue;
		}
		
		boolean word=(first.charAt(2)==next.charAt(0));
		if(word==false) {
			System.out.println("땡!프로그램을 종료합니다.");
			break;
		}
		first=next;

	}}

}
