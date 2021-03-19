package oop.inherit8;

public abstract class File {
	
	protected String filename;
	protected long filesize=0;
	
	public File(String filename) {
		this.setFilename(filename);
	}
	public File(String filename, long filesize) {
		this.setFilename(filename);
		this.setFilesize(filesize);
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		if(filesize<0) return;
		this.filesize = filesize;
	}
	
	
	public abstract void execute();

	

	

}
