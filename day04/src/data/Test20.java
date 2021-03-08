package data;
import java.lang.*;

public class Test20 {
public static void main(String[] args) {
	String st="20190503";
	String year=st.substring(0,4);
	String month=st.substring(4,6);
	String date=st.substring(6,8);
	
	System.out.println(year);
	System.out.println(month);
	System.out.println(date);
}
}
