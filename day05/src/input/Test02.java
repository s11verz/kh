package input;
import java.lang.*;
import java.util.*;
//import java.util.Scanner;
public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		//Scanner를 이용한 입력 방법 
		
		Scanner sc=new Scanner(System.in);
		
		//.next(): 띄어쓰기 전까지 문자열 입력받고 String 형태로 저장
		String a=sc.next();
		System.out.println("a="+a);
		
		//.nextInt(): 띄어쓰기 전까지 숫자를 입력받아 Int 형태로 저장
		int b=sc.nextInt();
		System.out.println("b="+b);
		
		sc.close(); //도구 정리

	}

}
