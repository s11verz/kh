package loop;

import java.lang.*;
import java.util.*;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String name = sc.next();

		for (int i = 0; i < 5; i++) {
			System.out.println(name);
		}
		sc.close();
	}

}
