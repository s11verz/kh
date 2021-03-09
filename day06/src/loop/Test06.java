package loop;
import java.lang.*;
public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1부터 100까지 5가 들어가는 숫자 출력
		for (int i=1;i<=100;i++) {
			if (i%10==5||i/10==5 ) {
				System.out.println(i);
			}
		}

	}

}
