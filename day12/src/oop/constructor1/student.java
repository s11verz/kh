package oop.constructor1;

public class student {
	private String name;
	private int java;
	private int db;
	
	public student(String name) {
		this.name=name;
		
	}
	public student(String name, int java, int db) {
		this.setName(name);
		this.setJava(java);
		this.setDb(db);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getDb() {
		return db;
	}
	public void setDb(int db) {
		this.db = db;
	}
	
	

}
