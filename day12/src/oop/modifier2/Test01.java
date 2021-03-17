package oop.modifier2;
import oop.modifier1.*;
public class Test01 {
	public static void main(String[] args) {
		student a=new student();
		//아무런 제한 키워드가 없으면 패키지 까지만 접근 가능
		a.setName("피카츄");
		a.setJava(100);
		a.setDB(80);
	}

}
