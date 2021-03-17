package oop.constructor2;

public class game {
	private String id;
	private String job;
	private int level=1;
	private int money=0;
	
	public game(String id, String job) {
		this.id=id;
		this.job=job;
	}
	public game(String id, String job, int level, int money) {
		this.id=id;
		this.job=job;
		this.level=level;
		this.money=money;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		if(job=="전사"||job=="마법사"||job=="궁수") {
		this.job = job;}
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level>=1)  {
		this.level = level;}
		else
			return;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		if(money>=0) {
		this.money = money;}
		else
			return;
		
	}
	public void result() {
		System.out.println("게임 캐릭터 정보");
		System.out.println("아이디: "+this.id);
		System.out.println("직업: "+this.job);
		System.out.println("레벨: "+this.level);
		System.out.println("소지금: "+this.money);
	}
	
	

}
