package array;
import java.lang.*;
import java.util.*;
public class Test07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data=new int[] {30,50,20,10,40};
		int max=0;
		int num=0;
		for(int i=0;i<5;i++) {
			if(data[i]>=max) {
				max=data[i];
				num=i;
			}
			
		}System.out.println("가장 큰 숫자:"+max);
		System.out.println(num+1+"번째 입니다.");
		

	}

}
