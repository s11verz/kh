package oop.inherit8;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File a=new MP3("test.mp3");
		File b=new AVI("test.avi");
		File c=new PPT("test.pptx");
		
		a.execute();
		b.execute();
		c.execute();

	}

}
