package oop.keyword6;
import java.util.*;
public class Test01 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//간단한 가위바위보 게임
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1.가위 2.바위 3.보");
		int user=sc.nextInt();
		sc.close();
		
		switch (user) {
		case RSP.SCISSORS:
			System.out.println("가위를 내셨습니다.");
			break;
		case RSP.ROCK:
			System.out.println("바위를 내셨습니다.");
			break;
		case RSP.PAPER:
			System.out.println("보를 내셨습니다.");
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
				
		}

	}

}
