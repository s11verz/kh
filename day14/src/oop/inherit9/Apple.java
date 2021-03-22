package oop.inherit9;

public abstract class Apple extends Phone{
	 public void setColor(String color) {
			if(color=="블랙"||color=="화이트"||color=="핑크") {
			
			this.color = color;
			}
			else return;
		}
	public Apple(String number, String color) {
		super(number, color);
		if(color=="화이트"||color=="블랙"||color=="핑크") {
			this.color=color;
		}}
	public abstract void siri();
	

}
