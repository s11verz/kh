package oop.method5;

public class student {
	String name;
	int java;
	int db;

	void setName(String name){
		this.name=name;
	}
	void setJava(int java) {
		this.java=java;
	}
	void setDB(int db) {
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