package oop.keyword2;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculator c=new calculator();
		c.setFirst(10);
		c.setSecond(20);
		
		System.out.println(c.plus());
		System.out.println(c.minus());
		
		c.setFirst(30);
		c.setSecond(10);
		System.out.println(c.minus());

	}

}
