package array;
import java.lang.*;
import java.util.*;
public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score[]=new int[]{50,65,77,82,90,90,59,72,85,88};
		int sum=0;
		int avg=0;
		int retest=0;
		
		int rank=0;
		
		for(int i=0;i<score.length;i++) {
		sum+=score[i];
		if (score[i]<60) {
			retest++;
		}
		
		}
		avg=sum/score.length;
		System.out.println("성적 평균은 "+avg+"점");
		System.out.println("재시험 인원수는 "+retest+"명");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		int myScore=sc.nextInt();
		for(int i=0;i<score.length;i++) {
			if(score[i]>myScore)
				rank++;
		}System.out.println("당신의 등수는 "+rank+"등 입니다.");
		
		

	}

}
