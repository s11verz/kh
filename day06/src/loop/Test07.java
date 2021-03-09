package loop;
import java.lang.*;
public class Test07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int day=10;
		int total=0;
		for (int i=1;i<=30;i++) {
			
			System.out.println(i+"번째 날은 "+day+"개");
			day+=3;
			total+=day;
		}
     System.out.println("한달동안 하게 되는 총 푸시업 수는"+total+"개");
	}

}
