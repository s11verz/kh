package oop.basic6;

public class Test01 {
	public static void main(String[] args) {
		student a=new student();
		student b=new student();
		student c=new student();
		
		a.set("마리오", 1, 90, 80, 70);
		b.set("루이지", 1, 85, 85, 83);
		c.set("쿠파", 3, 70, 60, 55);
		
		a.result();
		b.result();
		c.result();
		
	}
	
	
	

}
