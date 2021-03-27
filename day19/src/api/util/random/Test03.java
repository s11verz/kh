package api.util.random;
import java.util.Random;
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id="khacademy";
		String id2="admin";
		
		Random r=new Random();
		while(true) {
			long current =System.currentTimeMillis()/10000;
			//1번 사용자
			r.setSeed(current+id.hashCode());
			int otp=r.nextInt(1000000)+0;
			//2번 사용자
			r.setSeed(current+id2.hashCode());
			int otp2=r.nextInt(1000000)+0;
			System.out.println("current(seed)="+current+" otp="+otp+" otp2="+otp2);
		}

	}

}
