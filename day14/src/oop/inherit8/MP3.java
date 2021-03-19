package oop.inherit8;

public class MP3 extends Media{
	
	private int duration;
	
	public MP3(String filename) {
		super(filename);
	}
	public MP3(String filename, long filesize, int duration) {
		super(filename, filesize);
		this.duration=duration;		
	}
	
	@Override
	public void forward() {
		System.out.println("음악을 빨리감기 합니다.");
		
	}
	@Override
	public void rewind() {
		System.out.println("음악을 되감기 합니다.");
		
	}
	@Override
	public void execute() {
		System.out.println("음악 재생을 시작 합니다.");
		
	}
	
	

}
