package exception;

public class Test03 {
	public static void main(String[] args) {
		try {
		int a=Calculator.div(10,0);
		System.out.println(a);
		}catch(Exception e) {
			System.err.println("예외 발생!");
		}
	}

}
