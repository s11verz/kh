package oop.basic7;

public class Test01 {
	public static void main(String[] args) {
		menu a=new menu();
		menu b=new menu();
		menu c=new menu();
		menu d=new menu();
		
		a.set("아메리카노", "음료", 2000, "yes");
		b.set("프라푸치노", "음료", 3500, "no");
		c.set("치즈케이크", "빵", 5000, "yes");
		d.set("유기농 샌드위치", "빵", 3000, "no");
		
		a.result();
		System.out.println();
		b.result();
		System.out.println();
		c.result();
		System.out.println();
		d.result();
	}

}
