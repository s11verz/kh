package api.collection;

import java.util.ArrayList;
import java.util.List;

public class Test02 {
	public static void main(String[] args) {
		//ArrayList=배열과 비슷한 형태의 저장소, 하지만 크기가 가변적
		ArrayList a=new ArrayList();//내용물이 어떤 형태인지 알 수 x
		ArrayList<String> b=new ArrayList<String>();//내용물이 String 형태
		ArrayList<String> c=new ArrayList<>();
		List<String> d=new ArrayList<>();
		
		d.add("아이유");
		d.add("송중기");
		d.add("유재석");
		
		System.out.println(d.get(0));
		System.out.println(d.get(1));
		System.out.println(d.get(2));
		
		System.out.println(d.size());
		
		System.out.println(d.contains("아이유"));//저장소에 아이유가 있나?
		System.out.println(d.indexOf("아이유"));//아이유가 어디에 있나?
		
		//삭제
		//유재석 삭제
		d.remove("유재석");
		d.remove(1);
		System.out.println(d);
		
	}

}
