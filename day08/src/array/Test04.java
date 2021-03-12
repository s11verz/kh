package array;
import java.lang.*;
public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int day[]=new int[10];
		int pay=1;
		int total_pay=0;
		for(int i=0;i<10;i++) {
			day[i]=pay;
			total_pay+=pay;
			System.out.println(i+1+"일차에는"+day[i]+"원");
			pay*=2;
			
		}System.out.println("받을 금액의 총 합계는"+total_pay+"원");
		

	}

}
