package input;
import java.lang.*;
import java.util.*;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//출생년도 4자리 입력받아 나이와 성인여부 판단하여 출력
		
		Scanner sc=new Scanner(System.in);
		
		int birth=sc.nextInt();
		System.out.println("출생년도:"+birth);
		
		int age=(2021-birth+1);
		boolean adult=age>=20;
		
		System.out.println("나이:"+age);
		System.out.println("성인인가?:"+adult);
		
		sc.close();

	}

}
