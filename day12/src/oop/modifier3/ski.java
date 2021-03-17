package oop.modifier3;

public class ski {
	private String name;
	private int start, exit, adult, child;
	
	public void setName(String name) {
		this.name=name;
	}
	public void setStart(int start) {
		if(start>=0000&&start<=2359) {
		this.start=start;}
	}
	public void setExit(int exit) {
		if(exit>=0000&&exit<=2359) {
		this.exit=exit;}
	}
	public void setAdult(int adult) {
		if(adult>0) {
		this.adult=adult;
		}
	}
	public void setChild(int child) {
		if(child>0) {
		this.child=child;
		}
	}
	public void set(String name, int start, int exit, int adult, int child) {
		this.setName(name);
		this.setStart(start);
		this.setExit(exit);
		this.setAdult(adult);
		this.setChild(child);
	}
	public void result() {
		System.out.println("스키장 이용 요금");
		System.out.println("이름: "+this.name);
		System.out.println("시작 시간: "+this.start);
		System.out.println("종료 시간: "+this.exit);
		System.out.println("대인 요금: "+this.adult);
		System.out.println("소인 요금: "+this.child);
	}
	public int getStart() {
		return this.start=start;
	}
	public int getExit() {
		return this.exit=exit;
	}
	public int getStartMin() {
		return (this.start/100)*60+(this.start%100);
	}
	public int getExitMin() {
		return (this.exit/100)*60+(this.exit%100);
	}
	public int totalMin() {
		return this.getExitMin()-this.getStartMin();
	}

}
