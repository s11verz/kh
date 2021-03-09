package condition2;
import java.lang.*;
import java.util.*;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//switch~case 구문은 한번의 이동으로 해당 지점을 탐색
		//탐색한 지점부터 종료 지점까지 쭉 실행이 됨
		int direction=2;
		
		switch(direction) {
		
		case 2:
			System.out.println("아래쪽으로 이동!");
			break;
		case 4:
			System.out.println("왼쪽으로 이동!");
			break;
		case 6:
			System.out.println("오른쪽으로 이동!");
			break;
		case 8:
			System.out.println("위쪽으로 이동!");
			break;
		}

	}

}
