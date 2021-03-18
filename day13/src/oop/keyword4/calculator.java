package oop.keyword4;

public class calculator {
	
	
	//계산 기능
	//static-탈 각체지향 키워드
	public static int plus(int a, int b) {
		return a+b;
	}
	public static int minus(int a, int b) {
		if(a>b)
			return a-b;
		else
			return b-a;
	}

}
