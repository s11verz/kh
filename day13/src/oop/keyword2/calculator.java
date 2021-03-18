package oop.keyword2;

public class calculator {
	//계산기-사칙연산 도우미
	private int first;
	private int second;
	
	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public calculator() {
		this.setFirst(first);
		this.setSecond(second);
	}
	public calculator(int first, int second) {
		this.setFirst(first);
		this.setSecond(second);
	}
	//계산 기능
	public int plus() {
		return this.first+this.second;
	}
	public int minus() {
		if(this.first>this.second)
			return this.first-this.second;
		else
			return this.second-this.first;
	}

}
