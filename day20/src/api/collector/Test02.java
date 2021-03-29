package api.collector;
import java.util.ArrayList;
import java.util.List;
public class Test02 {
	public static void main(String[] args) {
		List<Student> list=new ArrayList<>();
		
		Student a=new Student("홍길동",100);
		list.add(a);
		list.add(new Student("피카츄",80));
		System.out.println(list.size());
		System.out.println(list.get(0).getName());
		System.out.println(list.get(0).getScore());
		
		Student s=list.get(1);
		System.out.println(s.getName());
		System.out.println(s.getScore());
	}

}
