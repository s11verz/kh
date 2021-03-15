package oop.basic7;

public class menu {

	String name, category, event;
	int price;
	
	void set(String name, String category, int price, String event) {
		this.name=name;
		this.category=category;
		this.price=price;
		this.event=event;
	}
	void result() {
		System.out.println("이름: "+this.name);
		System.out.println("종류: "+this.category);
		System.out.println("가격: "+this.price);
		System.out.println("행사 여부: "+this.event);
		if(this.event=="yes") {
			int discount=this.price*80/100;
			System.out.println("할인된 가격: "+discount);
		}
	}
}
