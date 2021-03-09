package loop;
import java.lang.*;
public class Test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pay=1;
		int total=0;
		for(int i=1;i<=30;i++) {
			System.out.println(i+"일날 받을 금액은"+pay+"원 입니다.");
			pay*=2;
			total+=pay;
		}
		System.out.println("30일 동안의 총 금액은"+total+"원 입니다.");

	}

}
