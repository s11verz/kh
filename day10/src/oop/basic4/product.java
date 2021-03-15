package oop.basic4;

public class product {
	String code,name,category;
	int price;
	
	void result() {
		System.out.println(this.code);
		System.out.println(this.name);
		System.out.println(this.category);
		System.out.println(this.price);
		
	}
	void set(String code, String name, String category, int price) {
		this.code=code;
		this.name=name;
		this.category=category;
		this.price=price;
	}
}
