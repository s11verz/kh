package loop;
import java.lang.*;
import java.util.*;
public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<10;i++) {
		System.out.println("숫자를 입력하세요.");
		int num=sc.nextInt();
		
		if (num%2==0) {
			System.out.println("짝수입니다.");
		}
		else {
			System.out.println("홀수입니다.");
		}
		}
		
		sc.close();
	}

}
