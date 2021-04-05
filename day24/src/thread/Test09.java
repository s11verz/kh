package thread;

public class Test09 {
	public static void main(String[] args) {
		//람다식
		Runnable r=()->{
			System.out.println("Hello Lamda");
		};
		//r을 멀티스레드로 실행시키려면 Thread 클래스 활용
		Thread t=new Thread(r);
		t.start();
		
	}

}
