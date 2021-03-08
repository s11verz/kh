package condition;
import java.lang.*;
import java.util.*;
public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//점수를 입력받아 성적을 분류하여 출력
		Scanner sc=new Scanner(System.in);
		
		System.out.println("점수를 입력하세요.");
		int score=sc.nextInt();
		
		if (score<=100 && score>=90) {
			System.out.println("성적은 A등급 입니다.");
		}
		else if (score<=89 && score>=70) {
			System.out.println("성적은 B등급 입니다.");
		}
		else {
			System.out.println("성적은 C등급 입니다.");
		}
		
		sc.close();
	}

}
