package api.collection2;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		Set<Integer> set=new TreeSet<>();
		int i=0;
		while(i<6) {
			int num=r.nextInt(45)+1;
			if(!set.contains(num)) {
				set.add(num);
				i++;
			}else {
				continue;
			}
		}
		
		
		System.out.println(set);

	}

}
