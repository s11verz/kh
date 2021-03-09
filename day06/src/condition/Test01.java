package condition;
import java.lang.*;
import java.util.*;
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//사용자에게 인원수, 기간, 월을 입력받아 예상 경비를 계산하여 출력
		Scanner sc=new Scanner(System.in);
		System.out.println("인원 수를 입력하세요.");
		int people=sc.nextInt();
		System.out.println("여행 기간을 입력하세요.");
		int date=sc.nextInt();
		System.out.println("여행 달을 입력하세요.");
		int month=sc.nextInt();
		int pay=200000*people*date;
		
		if (month>=3&&month<=5) {
			pay=pay*80/100;
			System.out.println("예상 여행 경비는 "+pay+"원 입니다.");
		}
		else if (month>=6&&month<=8) {
			pay=pay*95/100;
			System.out.println("예상 여행 경비는 "+pay+"원 입니다.");
		}
		else if (month>=9&&month<=11) {
			pay=pay*90/100;
			System.out.println("예상 여행 경비는 "+pay+"원 입니다.");
		}
		else {
			pay=pay*75/100;
			System.out.println("예상 여행 경비는 "+pay+"원 입니다.");
		}
		sc.close();
	}

}
