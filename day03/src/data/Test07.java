package data;

import java.lang.*;

public class Test07 {
public static void main(String[] args) {
	int pay=200000;
	int people=7;
	int pay_n=pay/7;
	int remain=pay-(pay_n*people);
	
	System.out.println("1인당 내야하는 금액:"+pay_n+"원");
	System.out.println("남은 금액:"+remain+"원");
	
}
}
