package api.collection2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> set=new HashSet<>();
		set.add("자바");
		set.add("파이썬");
		set.add("ios");
		set.add("안드로이드");
		set.add("c++");
		
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()) {
			String item=iter.next();
			System.out.println(item);
		}
		
		for(String item:set) {
			System.out.println(item);
		}

	}

}
