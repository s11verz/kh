package oop.inherit9;

public class GalaxyNote10 extends Samsung{

	public GalaxyNote10(String number, String color) {
		super(number, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void samsungStore() {
		System.out.println("GalaxyNote 10의 삼성스토어 기능을 시작합니다.");
		
	}

	@Override
	public void call() {
		System.out.println("GalaxyNote 10의 전화 기능을 시작합니다.");
		
	}

	@Override
	public void sms() {
		System.out.println("GalaxyNote 10의 문자 기능을 시작합니다.");
		
	}
	@Override
	public void info() {
		System.out.println("<휴대폰 정보>");
		System.out.println("번호: " +this.number+" 색상: "+this.color);
		
	}
	public void note() {
		System.out.println("GalaxyNote 10의 노트 기능을 시작합니다.");
	}
	

}
