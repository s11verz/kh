package oop.inherit6;

public class Broswer {
	protected String url;
	protected int version;
	
	public Broswer(String url, int version) {
		this.url=url;
		this.version=version;
	}
	public void move() {
		System.out.println("다른 페이지로 이동합니다.");
	}
	public void refresh(){
		System.out.println("새로고침을 시도합니다.");
	}

}
