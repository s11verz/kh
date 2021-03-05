package data;

import java.lang.*;

public class Test04 {
public static void main(String[] args) {
	//시간계산
	//1시간 50분+2시간 30분=?시간 ?분
	int hour1=1;
	int hour2=2;
	int min1=50;
	int min2=30;
	
	int time1=hour1*60;
	int time2=hour2*60;
	
	int time=time1+time2+min1+min2;
	System.out.println(time);
	
	int hour=time/60;
	int min=time%60;
	
	System.out.println(hour);
	System.out.println(min);
	
			
}
}
