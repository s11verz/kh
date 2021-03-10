package loop2;
import java.lang.*;
import java.util.*;
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//사용자가 입력한 숫자의 합계 구하기
		//합계가 100이 넘어가면 프로그램 종료
		Scanner sc=new Scanner(System.in);
		int sum=0;
		int n=0;
		
		while(true) {
			System.out.println("숫자를 입력하세요.");
			int num=sc.nextInt();
			sum+=num;
			if(sum>100) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			System.out.println("입력한 수의 합계는 "+sum);
			n++;
			System.out.println("입력한 횟수는 "+n);
			
					
		}

	}

}
