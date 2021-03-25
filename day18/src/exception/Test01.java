package exception;
import java.util.*;
public class Test01 {

	public static void main(String[] args) {
		// 오류: 실행이 불가능하도록 만드는 상황
		//예외:실행 이후에 발생하는 돌발 상황
		try {
		Scanner sc=new Scanner(System.in);
		System.out.print("정산 금액: ");
		int money =sc.nextInt();
		System.out.print("인원 수: ");
		int people=sc.nextInt();
		
		sc.close();
		int pricePerPerson=money/people;
		int change=money%people;
		System.out.println("1인당"+pricePerPerson);
		System.out.println("잔돈 "+change+"원은 저희가 지원해드려요.");
		}/*catch(InputMismatchException e){
			System.err.println("똑바로 입력하세요");
		}catch(ArithmeticException e) {
			System.err.println("인원을 입력하세요");
			
		}*/
		catch(Exception e){
			/*System.out.println(e);
			System.out.println(e.getClass());//클래스 정보
			System.out.println(e.getMessage());//원인 정보*/
			
			e.printStackTrace();//개발용으로 사용
		}

	}

}
