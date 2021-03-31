package api.collection2;

import java.util.Set;
import java.util.TreeSet;

public class Test04 {

	public static void main(String[] args) {
		Set<Integer> a=new TreeSet<>();
		a.add(10);
		a.add(20);
		a.add(30);

		Set<Integer> b=new TreeSet<>();
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		
		//합집합
		Set<Integer> c=new TreeSet<>();
		c.addAll(a);//c에 a를 모두 추가
		c.addAll(b);//c에 b를 모두 추가
		System.out.println(c);
		
		//교집합
		Set<Integer> d=new TreeSet<>();
		d.addAll(a);//d에 a를 모두 추가
		d.retainAll(b);//d에 b를 교집합 연산
		System.out.println(d);
		
		//차집합
		Set<Integer> e=new TreeSet<>();
		e.addAll(a);
		e.removeAll(b);//a에서 b에 포함된 항목을 삭제
		System.out.println(e );
		
		
	}

}
