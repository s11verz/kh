package oop.method3;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		smartPhone a=new smartPhone();
		smartPhone b=new smartPhone();
		smartPhone c=new smartPhone();
		
		a.set("Galaxy215", "SK", 24, 1500000);
		b.set("iPhone12", "KT", 24, 1800000);
		c.set("V60", "LG", 30, 1200000);
		
		a.result();
		b.result();
		c.result();

	}

}
