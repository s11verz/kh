package oop.inherit9;

public class Galaxy21s extends Samsung{
	

	public Galaxy21s(String number, String color) {
		super(number, color);
		
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void samsungStore() {
		System.out.println("Galaxy21s의 삼성스토어 기능을 시작합니다.");
		
	}

	@Override
	public void call() {
		System.out.println("Galaxy21s의 전화 기능을 시작합니다.");
		
	}

	@Override
	public void sms() {
		System.out.println("Galaxy21s의 문자 기능을 시작합니다.");
		
	}
	public void bixby() {
		System.out.println("Galaxy21s의 빅스비 기능을 시작합니다.");
	}

	@Override
	public void info() {
		System.out.println("<휴대폰 정보>");
		System.out.println("번호: " +this.number+" 색상: "+this.color);
		
	}
	

}
