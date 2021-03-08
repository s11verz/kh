package condition;
import java.lang.*;
import java.util.*;
public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("여행을 계획 중인 달을 입력하세요.");
		int month=sc.nextInt();
		System.out.println("여행 기간을 입력하세요.");
		int date=sc.nextInt();
		int pay=(date*100000);
		
		if (month>=6 && month<=8) {
			pay=pay*80/100;
			System.out.println("총 비용은"+pay+"입니다.");
		}
		else {
		System.out.println("총 비용은"+pay+"입니다.");
		}
		
		sc.close();
	}

}
