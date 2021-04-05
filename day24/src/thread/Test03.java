package thread;

import javax.swing.JOptionPane;

class MyThread extends Thread{
	@Override
	public void run() {
		for(int i=0;i<=100;i++) {
			System.out.println(i);
			try {
			Thread.sleep(1000L);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
public class Test03 {
	public static void main(String[] args) {
		//작업2를 t에게 위임
		MyThread t=new MyThread();
		t.start();
		//작업1
		JOptionPane.showMessageDialog( null,"테스트");
	}

}
