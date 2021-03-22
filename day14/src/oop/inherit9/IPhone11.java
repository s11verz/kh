package oop.inherit9;

public class IPhone11 extends Apple{

	public IPhone11(String number, String color) {
		super(number, color);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void siri() {
		System.out.println("iPhone11의 시리 기능을 시작합니다.");
		
	}

	@Override
	public void call() {
		System.out.println("iPhone11의 전화 기능을 시작합니다.");
		
	}

	@Override
	public void sms() {
		System.out.println("iPhone11의 문자 기능을 시작합니다.");
		
	}
	@Override
	public void info() {
		System.out.println("<휴대폰 정보>");
		System.out.println("번호: " +this.number+" 색상: "+this.color);
		
	}
	public void iTunes() {
		System.out.println("iPhone11의 아이튠즈 기능을 시작합니다.");
	}

}
