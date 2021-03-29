package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test05 {

	public static void main(String[] args) {
		Set<String> iPhone=new TreeSet<>();
		iPhone.add("블랙");
		iPhone.add("그린");
		iPhone.add("옐로우");
		iPhone.add("퍼플");
		iPhone.add("레드");
		iPhone.add("화이트");
		
		Set<String> galaxy=new TreeSet<>();
		galaxy.add("블랙");
		galaxy.add("화이트");
		galaxy.add("팬텀 그레이");
		galaxy.add("팬텀 핑크");
		
		//모든 색상 목록 출력
		Set<String> a=new TreeSet<>();
		a.addAll(iPhone);
		a.addAll(galaxy);
		System.out.println(a);
		
		
		//교집합
		Set<String> b=new TreeSet<>();
		b.addAll(iPhone);
		b.retainAll(galaxy);
		System.out.println(b);
		
		//아이폰만 가지고 있는 색상 출력
		Set<String> c=new TreeSet<>();
		c.addAll(iPhone);
		c.removeAll(galaxy);
		System.out.println(c);
		
		//갤럭시만 가지고 있는 색상 출력
		Set<String> d=new TreeSet<>();
		d.addAll(galaxy);
		d.removeAll(iPhone);
		System.out.println(d);
		
	}

}
