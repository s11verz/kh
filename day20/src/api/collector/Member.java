package api.collector;

public class Member {
	private String name;
	private String pw;
	
	public Member() {
		super();
	}
	public Member(String name, String pw) {
		super();
		this.name=name;
		this.pw=pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

}
