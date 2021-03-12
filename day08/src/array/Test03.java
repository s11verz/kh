package array;
import java.lang.*;
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int day[]=new int[15];
		int pushup=10;
		
		for(int i=0;i<day.length;i++) {
			day[i]=pushup;
			pushup+=3;
		}
		for (int i=0;i<day.length;i++) {
			System.out.println(day[i]);
		}

	}

}
