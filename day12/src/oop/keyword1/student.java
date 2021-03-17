package oop.keyword1;

public class student {
    private final String name;
	private int score;
	
	public student(String name) {
		this.name=name;
	}
	public student(String name, int score) {
		this.name=name;
		this.score=score;
	}
	//final 항목은 setter 메소드를 만들 수 없음
	/*public void setName(String name) {
		this.name=name;
	}*/

}
