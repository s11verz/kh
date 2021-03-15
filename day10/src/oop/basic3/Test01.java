package oop.basic3;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		player a=new player();
		player b=new player();
		player c=new player();
		
		/*a.name="김연아";
		a.subject="피겨스케이트";
		a.gold=2;
		a.silver=0;
		a.bronze=1;*/
		
		//a를 주인공으로 set 코드의 5개의 데이터를 전달
		a.set("김연아", "피겨스케이팅", 2, 0, 1);
		b.set("이상화", "스피드스케이팅", 1, 2, 1);
		c.set("윤성빈", "스켈레톤", 1, 0, 1);
		
		//a를 주인공으로 해서 result 안의 코드를 출력
		a.result();
		b.result();
		c.result();

	}

}
