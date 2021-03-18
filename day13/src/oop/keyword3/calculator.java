package oop.keyword3;

public class calculator {
	
	
	//계산 기능
	public int plus(int a, int b) {
		return a+b;
	}
	public int minus(int a, int b) {
		if(a>b)
			return a-b;
		else
			return b-a;
	}

}
