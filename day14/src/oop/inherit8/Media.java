package oop.inherit8;

public abstract class Media extends File{

	public Media(String filename) {
		super(filename);
		// TODO Auto-generated constructor stub
	}
	public Media(String filename, long filesize) {
		super(filename, filesize);
	}
	public abstract void forward();
	public abstract void rewind();

}
