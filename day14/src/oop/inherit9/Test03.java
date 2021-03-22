package oop.inherit9;
import java.util.Random;
public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//색상 랜덤배열
		String[] colors=new String[] {"골드", "실버", "아쿠아블루"};
		Random r=new Random();
		int choice=r.nextInt(colors.length);
		String color=colors[choice];
		
		System.out.println("choice="+choice);
		System.out.println("color="+color);

	}

}
