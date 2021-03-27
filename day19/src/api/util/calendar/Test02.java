package api.util.calendar;
import java.util.Calendar;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Test02 {

	public static void main(String[] args) {
		// Calender 클래스: 시간 생성 및 계산에 특화된 클래스 
		Calendar c=Calendar.getInstance();
		
		/*c.set(Calendar.YEAR, 2000);
		c.set(Calendar.MONTH,0);//월은 보정이 필요
		c.set(Calendar.DATE, 1);*/
		//c.set(2000,0,1);
		
		//7일 뒤는 며칠일까요?
		c.add(Calendar.DATE,7);
		
		Date d=c.getTime();
		Format f=new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss.SSS");
		System.out.println(f.format(d));
		
		

	}

}
