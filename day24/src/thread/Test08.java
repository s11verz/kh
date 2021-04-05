package thread;

import java.util.Timer;
import java.util.TimerTask;

public class Test08 {
	public static void main(String[] args) {
		Timer timer=new Timer();
		TimerTask task=new TimerTask() {
			@Override
			public void run() {
				System.out.println("Hello Timer");
			}
			};
			
			timer.scheduleAtFixedRate(task, 5000L, 1000L);
		}
	}


