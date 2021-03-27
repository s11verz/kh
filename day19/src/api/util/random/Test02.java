package api.util.random;
import java.util.Random;
public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		
		r.setSeed(1L);
		System.out.println(r.nextInt(6)+1);
		r.setSeed(1L);
		System.out.println(r.nextInt(6)+1);
		r.setSeed(1L);
		System.out.println(r.nextInt(6)+1);
		r.setSeed(1L);
		System.out.println(r.nextInt(6)+1);
	

	}

}
