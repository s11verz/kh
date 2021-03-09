package loop;

import java.lang.*;
import java.util.*;
public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1부터 100사이 홀수들을 모두 더한 값을 화면에 출력
		
		int num=0;
		
		for(int i=1;i<=100;i++) {
			if(i%2==1) {
				System.out.println(i);
				num+=i;
			}
			
				
		}
		System.out.println("홀수를 모두 합한 값은 "+num+"입니다.");
	}

}
