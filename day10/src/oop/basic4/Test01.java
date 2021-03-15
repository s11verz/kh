package oop.basic4;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		product a=new product();
		product b=new product();
		product c=new product();
		
		a.set("A00001", "참이슬", "주류", 1200);
		b.set("A00002", "처음처럼", "주류", 1300);
		c.set("B00001", "고무장갑", "생필품", 2000);
		
		a.result();
		System.out.println();
		b.result();
		System.out.println();
		c.result();
		

	}

}
