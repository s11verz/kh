package oop.inherit9;

public abstract class Phone {
	
	protected String number;
	protected String color;
	
	public Phone(String number, String color) {
		this.setNumber(number);
		this.setColor(color);
	}
	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		
		
		this.color = color;
	}
	public abstract void call();
	public abstract void sms();
	public abstract void info();

}
