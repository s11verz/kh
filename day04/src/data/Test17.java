package data;
import java.lang.*;
public class Test17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//각각의 과목이 40점 이상이면서 평균이 60점 이상이면 이수 인정
		//1과목 40점, 2과목 80
		
		int sub1=40;
		int sub2=60;
		float avg=(sub1+sub2)/(float)2;
		
		boolean pass=sub1>=40 && sub2>=40 && avg>=60;
		System.out.println(pass);
		
		if (pass==true) {
			System.out.println("congrats!!");
		}
		else
			System.out.println("sorry...");

	}

}
