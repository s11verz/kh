package condition;
import java.lang.*;
import java.util.*;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//사용자에게 소지금을 입력받아 주문 가능한 메뉴를 화면에 출력
		System.out.println("추천메뉴");
		System.out.println("떡볶이(3000원)");
		System.out.println("자장면(5000원)");
		System.out.println("오므라이스(7000원)");
		System.out.println("치킨(15000원)");
		Scanner sc=new Scanner(System.in);

		System.out.println("가지고 있는 금액을 입력하세요.");
		
		int money=sc.nextInt();
		if (money>=15000)
			System.out.println("떡볶이, 자장면, 오므라이스, 치킨");
		else if (money>=7000)
			System.out.println("떡볶이, 자장면, 오므라이스");
		else if (money>=5000)
			System.out.println("떡볶이, 자장면");
		else if (money>=3000)
			System.out.println("떡볶이");

		sc.close();

	}

}
