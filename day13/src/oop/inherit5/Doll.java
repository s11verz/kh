package oop.inherit5;

public class Doll {
	protected String name;
	protected int price;
	
	public Doll(String name) {
		this.name=name;
		
	}
	public Doll(String name, int price) {
		this.name=name;
		this.price=price;
	}
	public void hello() {
		System.out.println("안녕!");
	}

}
