package data;
import java.lang.*;

public class Test11 {
	public static void main(String[] args) {
		//BMI 계산
		//BMI=키(m)/체중(kg)제곱
		//키 180, 체중 80인 사람의 BMI 지수를 구하여라
		
		int tall=180;
		int weight=80;
		double BMI=(weight/((tall/100.0)*(tall/100.0)));
		System.out.println(BMI);
	}
	
}
