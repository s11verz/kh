package oop.inherit8;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MP3 a=new MP3("노래.mp3",20000,30);
		a.execute();
		a.forward();
		a.rewind();
		
		AVI b=new AVI("자바수업.avi", 50000, 1.5f);
		b.execute();
		b.forward();
		b.rewind();
		
		PPT c= new PPT("발표.txt", 15000, 12);
		c.information();
		c.execute();
		

	}

}
