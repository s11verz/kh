package oop.inherit9;
import java.util.Random;
public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//핸드폰 랜덤배열
		Random r=new Random();
		int choice=r.nextInt(4)+0;
		System.out.println("choice="+choice);
		
		Phone p;
		if(choice==Phone.GALAXY21S) {
			p=new Galaxy21s("01094824583", "골드");
		}
		else if (choice==Phone.GALAXYNOTE10) {
			p=new GalaxyNote10("01094824583", "골드");
		}
		else if(choice==Phone.IPHONE11) {
			p=new IPhone11("01094824583", "블랙");
		}
		else {
			p=new IPhone12("01094824583", "블랙");
		}
		p.call();
		p.sms();

	}

}
