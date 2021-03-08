package input;
import java.lang.*;
import java.util.*;
public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		System.out.println("시작시간과 종료시간을 입력하세요.");
		int start=sc.nextInt();
		int exit=sc.nextInt();
		
		int start_min=(((start/100)*60)+(start%100));
		int exit_min=(((exit/100)*60)+(exit%100));
		int total=(exit_min-start_min);
		int total_hour=total/60;
		int total_min=total%60;
		
		System.out.println("총 이용시간:"+total_hour+"시간"+total_min+"분");
		
		sc.close();

	}

}
