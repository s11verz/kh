package oop.method2;

public class student {
	String name;
	int java;
	int db;
	
	//setter method
	void setName(String name) {
		this.name=name;
	}
	void setJava(int java) {
		if(java>=0&&java<=100) {
		this.java=java;}
	}
	void setDB(int db) {
		this.db=db;
	}
	void result() {
		System.out.println("<학생 정보>");
		System.out.println("이름: "+this.name);
		System.out.println("자바 점수: "+this.java+"점");
		System.out.println("DB 점수: "+this.db+"점");
	}


}
