package oop.inherit9;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Galaxy21s a=new Galaxy21s("01099345679","골드");
		a.info();
		a.call();
		a.sms();
		a.samsungStore();
		a.bixby();
		
		GalaxyNote10 b=new GalaxyNote10("01099234745","아쿠아블루");
		b.info();
		b.call();
		b.sms();
		b.samsungStore();
		b.note();
		
		IPhone11 c=new IPhone11("01034545667","블랙");
		c.info();
		c.call();
		c.sms();
		c.siri();
		c.iTunes();
		
		IPhone12 d=new IPhone12("01045673467","화이트");
		d.info();
		d.call();
		d.sms();
		d.siri();
		d.iCloud();
		
		Samsung[] s=new Samsung[10];
		Apple[] ap=new Apple[10];	
		Phone[]p=new Phone[10];
		for(int i=0;i<s.length;i++) {
			if(i<5) s[i]=new Galaxy21s(null, null);
			else s[i]=new GalaxyNote10(null,null);
		}
		for(int i=0;i<ap.length;i++) {
			if(i%2==0) ap[i]=new IPhone11(null,null);
			else ap[i]=new IPhone12(null,null);
		}
		for(int i=0;i<p.length;i++) {
			if(i<3) p[i]=p[i]=new Galaxy21s(null,null);
			else if(i>=3&&i<5) p[i]=new GalaxyNote10(null,null);
			else if(i>=5&&i<7) p[i]=new IPhone11(null,null);
			else p[i]=new IPhone12(null,null);
		}
		for(int j=0;j<s.length;j++) {
			s[j].samsungStore();
		}
		for(int j=0;j<ap.length;j++) {
			ap[j].siri();
		}
		for(int j=0;j<p.length;j++) {
			p[j].call();
		}

	}

}
