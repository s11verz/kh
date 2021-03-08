package data;
import java.lang.*;
public class Test21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pay=8500;
		int discount=30;
		int totalPay=(pay-((pay*discount)/100));
		
		System.out.println("할인 전:"+pay);
		System.out.println("할인 후:"+ totalPay);
		

	}

}
