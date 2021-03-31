package api.io.object;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private int score;
	//사용은 똑같이 하지만 입출력에서만 배제시키고 싶은 키워드 transient
	private transient String phone;
	public Student() {
		super();
	}
	public Student(String name, int score, String phone) {
		super();
		this.name=name;
		this.score=score;
		this.phone=phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
