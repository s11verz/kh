package oop.modifier3;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ski a=new ski();
		ski b=new ski();
		ski c=new ski();
		
		a.set("주간권", 900, 1800, 80000, 64000);
		b.set("야간권", 1900, 2200, 60000, 42000);
		c.set("심야권", 2000, 2359, 45000, 32000);
		
		a.result();
		b.result();
		c.result();
		
		System.out.println(a.totalMin());
		System.out.println(b.totalMin());
		System.out.println(c.totalMin());
		
		

	}

}
