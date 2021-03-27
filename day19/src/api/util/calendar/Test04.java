package api.util.calendar;
import java.text.DecimalFormat;
import java.text.Format;


public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a=123456.789;
		System.out.println(a);
		
		Format f1=new DecimalFormat("####.##");
		System.out.println(f1.format(a));
		
		Format f2=new DecimalFormat("0000.00");
		System.out.println(f2.format(a));
		
		Format f3=new DecimalFormat("0.00");
		System.out.println(f3.format(a));
		
		long b=1234567890123456789L;
		System.out.println(b);
		
		Format f4=new DecimalFormat("#,###");
		System.out.println(f4.format(b));
		
		

	}

}
