package api.util.calendar;
import java.util.Calendar;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Test01 {

	public static void main(String[] args) {
		// Calender 클래스: 시간 생성 및 계산에 특화된 클래스 
		Calendar c=Calendar.getInstance();
		
		//int year=c.get(1);
		int year=c.get(Calendar.YEAR);
		System.out.println("year="+year );
		
		int month=c.get(Calendar.MONTH)+1;
		System.out.println("month="+month);
		
		int day=c.get(Calendar.DATE);
		System.out.println("day="+day);
		
		
		
		int hour=c.get(Calendar.HOUR);
		System.out.println("hour="+hour);
		
		int minute=c.get(Calendar.MINUTE);
		System.out.println("minute="+minute);
		
		int second=c.get(Calendar.SECOND);
		System.out.println("second="+second);
		
		

	}

}
