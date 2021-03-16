package oop.method3;

public class smartPhone {
	String name, company;
	int month,price;
	
	void set(String name, String company, int month, int price) {
		this.name=name;
		
		if(company=="SK"||company=="KT"||company=="LG") {
			this.company=company;
		}
		
		if(month==24||month==30||month==36) {
			this.month=month;
		}
		if(price>0) {
		this.price=price;
		}
	}
	void result() {
		System.out.println("스마트폰 판매 정보");
		System.out.println("이름: "+this.name);
		System.out.println("통신사: "+this.company);
		System.out.println("약정 개월: "+this.month);
		System.out.println("판매가: "+this.price);
	}

}
