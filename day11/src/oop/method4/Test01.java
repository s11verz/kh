package oop.method4;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hotel a=new hotel();
		hotel b=new hotel();
		hotel c=new hotel();
		
		a.set("스텐다드룸", 4, 100000, 200000, 250000);
		b.set("슈페리어룸", 4, 150000, 250000, 300000);
		c.set("디럭스룸", 6, 300000, 450000, 550000);
		
		a.result();
		b.result();
		c.result();
		
		int standard_avg=(a.off_season+a.quasi+a.peak_season)/3;
		int deluxe_avg=(c.off_season+c.quasi+c.peak_season)/3;
		int dif=deluxe_avg-standard_avg;
		System.out.println("평균값의 차이는 "+dif+"원 입니다.");
		
		
		
		
		
	}

}
