package array;
import java.lang.*;
import java.util.*;
public class Test08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int []data=new int[5];
		
		for(int i=0;i<5;i++) {
			System.out.println("숫자를 입력하세요.");
			data[i]=sc.nextInt();
		}
		for(int j=0;j<5;j++) {
			System.out.println(data[j]);
		}
		
		int min=data[0];
		int num=0;
		for(int k=0;k<5;k++) {
			if(data[k]<=min) {
				min=data[k];
				num=k;
			}
		}System.out.println("최솟값은 "+min);
		System.out.println(num+1+"번째 숫자입니다.");
		

	}

}
