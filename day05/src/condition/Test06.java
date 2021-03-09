package condition;

import java.lang.*;
import java.util.*;

public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 지하철 요금 계산기
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도 4자리를 입력하세요:");
		int birth = sc.nextInt();
		int age = 2021 - birth + 1;

		if (age >= 8 && age < 14) {
			System.out.println("어린이 요금은 450원 입니다.");
		} else if (age >= 14 && age < 20) {
			System.out.println("청소년 요금은 720원 입니다.");
		} else if (age >= 20 && age < 65) {
			System.out.println("성인 요금은 1250원 입니다.");
		} else {
			System.out.println("유아 및 노인은 무료입니다.");
		}
		sc.close();

	}

}
