package data;

import java.lang.*;

public class Test05 {
public static void main(String[] args) {
	//10시 20분 30초 시작
	//15시 10분 25초에 종료
	int hour1=10*3600;
	int min1=20*60;
	int sec1=30;
	int hour2=15*3600;
	int min2=10*60;
	int sec2=25;
	
	int time1=hour1+min1+sec1;
	int time2=hour2+min2+sec2;
	
	int time=time2-time1;
	//System.out.println(time);
	
	int hour=time/3600;
	int min=(time-hour*3600)/60;
	int sec=(time-hour*3600)%60;
	System.out.println("총 이용한 시간");
	System.out.print(hour+"시간");
	System.out.print(min+"분");
	System.out.println(sec+"초");
	
	//1시간당 1000원일 경우 요금은?
		int min_pay=1000/60;
		int hour_pay=1000;
		int pay=(hour_pay*hour)+(min_pay*min);
		
		System.out.println("총 이용 요금:"+pay+"원");
	
}
}
