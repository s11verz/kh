package api.util.random;
import java.util.Random;
public class Test01 {

	public static void main(String[] args) {
		// Random 클래스:무작위 값을 추첨
		Random r=new Random();
		
		System.out.println(r.nextBoolean());//무작위 논리값 (T/F)
		System.out.println(r.nextInt());//무작위 int 값
		System.out.println(r.nextInt(5)+6);//6부터 5개
		System.out.println(r.nextFloat());//무작위 float 값
		System.out.println(r.nextDouble());//무작위 double 값
		System.out.println(r.nextGaussian());//무작위 가우스 분포(정규 분포) 값
		
		
		

	}

}
