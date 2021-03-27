package api.collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Test04 {

	public static void main(String[] args) {
		//철수, 영희, 영수, 민지, 미영, 민수
		Random r=new Random();
		List<String> a=new ArrayList<>(6);
		a.add("철수");
		a.add("영희");
		a.add("영수");
		a.add("민지");
		a.add("미영");
		a.add("민수");
		
		System.out.println(a);
		int i=0;
		while(true) {
			int num1=r.nextInt(6);
			int num2=r.nextInt(6);
			if(num1!=num2) {
				System.out.println(a.get(num1));
				System.out.println(a.get(num2));
				break; 
			}
		}
		
		
		
		
		
	}

}
