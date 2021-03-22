package oop.inherit9;

public abstract class Samsung extends Phone{

    public void setColor(String color) {
		if(color=="골드"||color=="실버"||color=="아쿠아") {
		
		this.color = color;
		}else {
			
			return;
		}
	}
	public Samsung(String number, String color) {	
		super(number, color);
		
			
	}
	
	public abstract void samsungStore();
	

}
