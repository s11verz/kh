package oop.inherit6;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chrome a=new Chrome("www.chrome.co.kr", 10);
		a.move();
		a.refresh();
		a.develop();
		
		Edge b=new Edge("www.edge.co.kr", 8);
		b.move();
		b.refresh();
		b.windows();
		
		

	}

}
