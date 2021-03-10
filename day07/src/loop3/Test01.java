package loop3;
import java.lang.*;
import java.util.*;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//do~while 반복문
		Scanner sc=new Scanner(System.in);
		int age=0;
		do {
		System.out.println("나이를 입력하세요.");
		age=sc.nextInt();
		
		}while(age<1||age>100);
		System.out.println("나이는"+age+"세 입니다.");
		sc.close();
		

	}

}
