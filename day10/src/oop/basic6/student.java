package oop.basic6;

public class student {
	String name;
	int grade, korean, english, math, sum, avg;
	
	void set(String name, int grade, int korean, int english, int math) {
		this.name=name;
		this.grade=grade;
		this.korean=korean;
		this.english=english;
		this.math=math;
		
	}
	void result() {
		System.out.println("학생 성적 정보");
		System.out.println("이름: "+this.name);
		System.out.println("학년: "+this.grade);
		System.out.println("국어 성적: "+this.korean);
		System.out.println("영어 성적: "+this.english);
		System.out.println("수학 성적: "+this.math);
		sum=korean+english+math;
		System.out.println("총점: "+sum);
		avg=sum/3;
		System.out.println("평균: "+avg);
	}

}
