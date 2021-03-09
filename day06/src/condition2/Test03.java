package condition2;
import java.lang.*;
import java.util.*;
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//사용자에게 월을 입력받아 해당 월이 몇일까지 있는지 보여주는 프로그램
		Scanner sc=new Scanner(System.in);
		System.out.println("달을 입력하세요.");
		int month=sc.nextInt();
		int max=31;
		
		switch (month) {
		case 1: case 3:case 5:case 7:case 8:case 10:case 12 :
			break;
		case 2:
			max-=3;
			break;
		default:
			max-=1;
			break;
		}
		System.out.println(max+"일 까지 있습니다.");
			sc.close();

	}

}
