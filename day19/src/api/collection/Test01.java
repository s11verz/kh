package api.collection;

import java.util.ArrayList;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {
		//TreeSet: 오름차순 정렬 (전화번호부, 출석부,...)
		//ArrayList: 추가 순서대로 정렬 (댓글, 방명록,통화내역,...)
		TreeSet a=new TreeSet();
		ArrayList b=new ArrayList();
		
		a.add("아이유");	b.add("아이유");
		a.add("조세호");	b.add("조세호");
		a.add("유재석");	b.add("유재석");
		a.add("송중기");	b.add("송중기");
		a.add("유희열");	b.add("유희열");
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		
	}

}
