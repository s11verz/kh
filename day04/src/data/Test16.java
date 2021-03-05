package data;
import java.lang.*;
public class Test16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//나이를 이용해서 무임 승차 대상인지 확인
		//기준: 어른(65세 이상), 유이(8세 미만)
		int age=7;
		
		boolean nopay=age>=65 || age<8;
		
		System.out.println(nopay);

	}

}
