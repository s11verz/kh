package oop.inherit8;

public class AVI extends Media{
	
	protected float  speed;

	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public AVI(String filename) {
		super(filename);
		// TODO Auto-generated constructor stub
	}
	public AVI(String filename, long filesize, float speed) {
		super(filename, filesize);
		this.setSpeed(speed);
		
	}
	@Override
	public void forward() {
		System.out.println("영상을 빨리감기 합니다.");
		
	}
	@Override
	public void rewind() {
		System.out.println("영상을 되감기 합니다.");
		
	}
	@Override
	public void execute() {
		System.out.println("영상을 "+this.speed+"배속으로 시작 합니다.");
		
	}
	

}
