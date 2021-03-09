package condition2;
import java.lang.*;
import java.util.*;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//방향키를 입력받아 처리하는 예제
		
		int direction=8;
		
		if (direction==2)
			System.out.println("아래쪽으로 이동!");
		else if (direction==4)
			System.out.println("왼쪽으로 이동!");
		else if (direction==6)
			System.out.println("오른쪽으로 이동!");
		else
			System.out.println("위쪽으로 이동!");
		

	}

}
