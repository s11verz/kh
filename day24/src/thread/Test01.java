package thread;

import javax.swing.JOptionPane;

public class Test01 {
	public static void main(String[] args) throws InterruptedException {
		
		JOptionPane.showMessageDialog( null,"테스트");
		
		for(int i=1;i<=100;i++) {
			System.out.println(i);
			Thread.sleep(1000L);
		}
		
	}

}
