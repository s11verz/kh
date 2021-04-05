package thread;

import javax.swing.JOptionPane;

public class Test04 {
	public static void main(String[] args) throws InterruptedException {
		//주 스레드가 종료되면 종 스레드가 같이 따라서 종료되도록 설정
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
		//Thread가 여러개인 경우 전체가 daemon이거나 전체가 daemon이 아니거나 둘 중 하나
		t.setName("test=thread");//이름을 지정하지 않으면  Thread-0부터 자동부여
		t.setPriority(Thread.MAX_PRIORITY);
		t.setDaemon(true);
		t.start();
		JOptionPane.showMessageDialog( null,"테스트");
		
		
		
	}

}
