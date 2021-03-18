package oop.inherit6;

public class Chrome extends Broswer{
	public Chrome(String url, int version) {
		super(url, version);
	}
	
	public void develop() {
		System.out.println("개발자 도구를 실행합니다.");
	}

}
