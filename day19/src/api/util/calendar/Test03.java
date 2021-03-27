package api.util.calendar;
import java.util.Calendar;
import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;
public class Test03 {

	public static void main(String[] args) {
		// D-77이 되는 날짜를 계산하여 출력
		Calendar c=Calendar.getInstance();
		c.set(2021,7, 4);
		c.add(Calendar.DATE,-77);
		Date d=c.getTime();
		Format f=new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(f.format(d));

	}

}
