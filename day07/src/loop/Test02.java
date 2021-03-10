package loop;
import java.lang.*;
import java.util.*;
public class Test02 {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		//타이머 만들기
		Scanner sc=new Scanner(System.in);
		System.out.println("분을 입력하세요.");
		int min=sc.nextInt();
		System.out.println("초를 입력하세요.");
		int sec=sc.nextInt();
		
		
		int total_sec=(60*min)+sec;
		int timer_min=0;
		int timer_sec=0;
		
		for (int i=total_sec;i>0;i--) {
			timer_min=i/60;
			timer_sec=i%60;
			
			
			System.out.println(timer_min+"분"+timer_sec+"초 후 알람이 울립니다.");
			
			Thread.sleep(1000L); //1초 정지 지연코드
		}
		System.out.println("땡~! 시간이 다 되었습니다.");
		sc.close();

	}

}
