package oop.inherit7;

public class Monitor extends Display{

	@Override
	public void color() {
		System.out.println("컬러모드로 전환합니다.");
		
	}

	@Override
	public void grayscale() {
		System.out.println("흑백모드로 전환합니다.");
		
	}

	@Override
	public void on() {
		System.out.println("모니터 전원을 킵니다.");
		
	}

	@Override
	public void off() {
		System.out.println("모니터 전원을 끕니다.");
		
	}

}
