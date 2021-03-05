package data;

import java.lang.*;

public class Test06 {
public static void main(String[] args) {
	int a=900;
	int b=5;
	int pay;
	
	if (b%2==0) {
		pay=a*(b/2);
	}
	else {
		pay=a*(b/2)+a*(b%2);
	}
	System.out.println(pay);
}
}
