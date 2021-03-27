package api.util.date;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Test03 {

	public static void main(String[] args) {
		// 2021-03-26 금 -:-:-
		Date a=new Date();
		//System.out.println(a);
		
		StringBuffer buffer=new StringBuffer();
		String time=buffer.toString();
		
		SimpleDateFormat fmt1=new SimpleDateFormat("yyyy-MM-dd E H:m:s");
		time=fmt1.format(a);
		System.out.println(time);
		
		//2021년 3월 26일 금요일 
		SimpleDateFormat fmt2=new SimpleDateFormat("yyyy년 M월 d일 E요일");
		time=fmt2.format(a);
		System.out.println(time);
		
		//-시 -분
		SimpleDateFormat fmt3=new SimpleDateFormat("H시 m분");
		time=fmt3.format(a);
		System.out.println(time);
		
		//오전/오후 -시 -분
		SimpleDateFormat fmt4=new SimpleDateFormat("a h시 m분");
		time=fmt4.format(a);
		System.out.println(time);
		
		
		

	}

}
