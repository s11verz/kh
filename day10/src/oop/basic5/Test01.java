package oop.basic5;

public class Test01 {
	public static void main(String[] args) {
		Student a=new Student();
		Student b=new Student();
		
		a.set("홍길동", 70);
		b.set("최배달", 50);
		
		a.result();
		System.out.println();
		b.result();
	}

}
