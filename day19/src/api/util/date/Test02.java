package api.util.date;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Test02 {

	public static void main(String[] args) {
		// 시간을 원하는 형식으로 출력
		
		Date a=new Date();
		System.out.println(a);
		
		int year=1900+a.getYear();
		int month=1+a.getMonth();
		int day=a.getDate();
		
		StringBuffer buffer=new StringBuffer();
		buffer.append(year);
		buffer.append("-");
		buffer.append(month);
		buffer.append("-");
		buffer.append(day);
		
		String time=buffer.toString();
		System.out.println(time);
		
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd");
		time=fmt.format(a);
		System.out.println(time);

	}

}
