package oop.basic3;

public class player {
	String name, subject;
	int gold, silver, bronze;
	
	void result() {
		System.out.println(this.name);
		System.out.println(this.subject);
		System.out.println(this.gold);
		System.out.println(this.silver);
		System.out.println(this.bronze);
	}
	 void set(String a, String b, int c, int d, int e) {
		 this.name=a;
		 this.subject=b;
		 this.gold=c;
		 this.silver=d;
		 this.bronze=e;
	 }

}
