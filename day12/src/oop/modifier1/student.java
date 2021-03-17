package oop.modifier1;

public class student {
	//private 클래스 외부의 접근 차단
	private String name;
	private int java;
	private int db;

	public void setName(String name){
		this.name=name;
	}
	public void setJava(int java) {
		this.java=java;
	}
	public void setDB(int db) {
		this.db=db;
	}
	void set(String name, int java, int db) {
		this.setName(name);
		this.setJava(java);
		this.setDB(db);
	}
	
	//getter method
	String getName() {
		return this.name;
	}
	int getJava() {
		return this.java;
	}
	int getDB() {
		return this.db;
	}
	int getTotal() {
		return this.java+this.db;
	}
	double getAverage() {
		return this.getTotal()/2.0;
	}
}