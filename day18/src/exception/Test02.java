package exception;
import java.util.*;
import java.util.regex.Pattern;
public class Test02 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		try {
		System.out.println("이름을 입력하세요.");
		String name=sc.next();
		String nameRegex="^[가-힣]{2,7}$";
		if(!Pattern.matches(nameRegex, name)) {
			throw new InputMismatchException("이름은 한글 2~7자 사이여야 합니다.");
		}
		System.out.println( "국어, 영아, 수학점수를 입력하세요.");
		int korean=sc.nextInt();
		int english=sc.nextInt();
		int math=sc.nextInt();
		if(korean<0||korean>100||english<0||english>100||math<0||math>100) {
			throw new InputMismatchException("점수는 0~100점 사이의 값이여야 합니다.");
		}
		int sum=korean+english+math;
		double avg=sum/3.0;
		
		System.out.println("점수의 총합은: "+sum);
		System.out.println("점수의 평균은: "+String.format("%.3f",avg));
		
		

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("프로그램을 종료합니다.");
			sc.close();
		}
	}

}
