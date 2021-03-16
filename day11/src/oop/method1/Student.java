package oop.method1;

public class Student {
	//멤버 변수 정의
	String name;
	int java;
	int database;
	
	//멤버 메소드 정의 
	void set(String name, int java, int database) {
		this.name=name;
		this.java=java;
		this.database=database;
	}
	void set(String name) {
		this.name=name;
	}
	//에러 발생
	/*void set(int java){
	 this.java=java;
	 }*/
	void set(int java, int database) {
		this.java=java;
		this.database=database;
	}
	void result() {
		System.out.println("<학생 정보>");
		System.out.println("이름: "+this.name);
		System.out.println("자바 점수: "+this.java+"점");
		System.out.println("DB 점수: "+this.database+"점");
	}

	
}
