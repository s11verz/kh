package thread;

import javax.swing.JOptionPane;

public class Test02 {
	public static void main(String[] args) throws InterruptedException {
		
		Thread t=new Thread() {
			@Override
			public void run() {
				for(int i=1;i<=100;i++) {
					System.out.println(i);
					try {
					Thread.sleep(1000L);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
		JOptionPane.showMessageDialog( null,"테스트");
		
		
		
	}

}
