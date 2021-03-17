package oop.constructor2;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		game a=new game("뽀로로", "전사" ,50,50000);
		game b=new game("크롱", "전사",35,20000);
		game c=new game("루피", "전사");
		
		a.result();
		b.result();
		c.result();

	}

}
