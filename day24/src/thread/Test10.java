package thread;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

class ATM{
	int money=10000000;
	
	synchronized void withdraw(int amount) {
		System.out.println("출금을 시작합니다.");
		try {
		Thread.sleep(5000L);//5초 정지
		}catch(InterruptedException e) {}
		this.money-=amount;
		try {
		Thread.sleep(5000L);//5초 정지
		}catch(InterruptedException e) {}
		System.out.println("출금이 완료되었습니다. 보유금액: "+money);
	}
	
}
public class Test10 {
	public static void main(String[] args) {
		ATM atm=new ATM();
		//스레드가 main 1개인 경우 순차적으로 실행
		/*atm.withdraw(1000000);
		atm.withdraw(1000000);
		atm.withdraw(1000000);*/
		
		Runnable r=()->{
			atm.withdraw(100000);
		};
			Thread t1 = new Thread(r, "피카츄");
			Thread t2 = new Thread(r, "라이츄");
			Thread t3 = new Thread(r, "파이리");
			Thread t4 = new Thread(r, "꼬부기");
			Thread t5 = new Thread(r, "버터플");
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
		
	}

}
