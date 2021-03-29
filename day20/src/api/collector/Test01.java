package api.collector;
import java.util.*;
import java.util.Random;
import java.util.ArrayList;
public class Test01 {

	public static void main(String[] args) {
		// 사다리 타기
		Random r=new Random();
		ArrayList<String> a = new ArrayList<>();
		ArrayList<String> b = new ArrayList<>();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("인원수를 입력하세요.");
		int people=sc.nextInt();
		for(int i=0;i<people;i++) {
			System.out.println("사람 이름을 입력하세요.");
			String name=sc.next();
			a.add(name);
		}
		for(int j=0;j<people;j++) {
			System.out.println("항목을 입력하세요.");
			String subject=sc.next();
			b.add(subject);
		}
		Collections.shuffle(b);
		for(int i=0;i<people;i++) {
			System.out.println(a.get(i)+"는 "+b.get(i)+" 당첨!" );
		}

	}

}
