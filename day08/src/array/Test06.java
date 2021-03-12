package array;
import java.lang.*;
import java.util.*;
public class Test06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String array[]=new String[5];
		for(int i=0;i<5;i++) {
			System.out.println("이름을 입력하세요.");
			 array[i]=sc.next();
		}
		for(int i=0;i<5;i++) {
		System.out.println(array[i]);
		}

	}

}
