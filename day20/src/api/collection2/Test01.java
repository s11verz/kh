package api.collection2;
import java.util.TreeSet;
public class Test01 {

	public static void main(String[] args) {
		//set: 순서가 내부적으로 정해져 있는 장소 
		
		TreeSet<Integer> set=new TreeSet<>();
		
		set.add(25);
		set.add(10);
		set.add(32);
		set.add(45);
		set.add(29);
		set.add(5);
		set.add(17);
		
		System.out.println(set);
		System.out.println(set.contains(10));
		System.out.println(set);

	}

}
