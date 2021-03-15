package oop.basic5;

public class Student {
	String name;
	int score;
	
	void set(String name, int score) {
		this.name=name;
		this.score=score;
	}
	void result() {
		System.out.println("<학생 정보>");
		System.out.println("이름: "+this.name);
		System.out.println("점수: "+this.score+"점");
		
		if (this.score>=60)
			System.out.println("통과");
		else
			System.out.println("재평가");
	
	}

}
