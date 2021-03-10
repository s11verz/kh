package loop2;
import java.lang.*;
import java.util.*;
public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//구구단 2단 출제
		//사용자가 3번 틀리거나 다 맞히면 게임 끝
		//마지막으로 정답 개수를 구하여 화면에 출력
		
		Scanner sc=new Scanner(System.in);
		int ans=0;
		int ans_num=0;
		int ans_incorrect=0;
		int i=1;
				
			for(i=1;i<10;i++) {		
				while(ans_incorrect<4) {
					
			System.out.println("2*"+i+"=");
			int user_ans=sc.nextInt();
			ans=2*i;
			
			if(user_ans==ans) {
				ans_num++;
			}
			else {
				ans_incorrect++;
			    System.out.println("오답입니다.");
				
			}
			
			break;
		}}System.out.println("정답 갯수:"+ans_num);
		System.out.println("틀린 갯수:"+ans_incorrect);
		

	}

}
