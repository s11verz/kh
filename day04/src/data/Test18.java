package data;
import java.lang.*;
public class Test18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//변수가 영어글자인지 판정하여 출력
		char ch='H';
	
		
		boolean upper=(int)ch>=65 && (int)ch<=90;
		boolean lower=(int)ch>=97 && (int)ch<=122;
		boolean alpha=upper||lower;
		
		System.out.println(upper);
		System.out.println(lower);
		System.out.println(alpha);
		


	}

}
