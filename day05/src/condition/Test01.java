package condition;
import java.lang.*;
import java.util.*;
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//사용자에게 숫자를 입력받아 짝수인지 홀수인지 판별 
		
		Scanner sc=new Scanner(System.in);
		System.out.println("정수를 입력하세요.");
		
		int num=sc.nextInt();
		
		if (num%2==1)
			System.out.println("홀수입니다.");
		else
			System.out.println("짝수입니다.");
		
		
		sc.close();

	}

}
