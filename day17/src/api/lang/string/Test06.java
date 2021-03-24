package api.lang.string;
import java.util.*;
public class Test06 {

	public static void main(String[] args) {
		//욕설 필터링 프로그램
		System.out.println("문장을 입력하세요.");
		Scanner sc=new Scanner(System.in);
		String sentence=sc.nextLine();
		String filter[]=new String[] {"개나리","신발끈","십장생","식빵","시베리아"};
		char star='*';
		for(int i=0;i<filter.length;i++) {
			int len=filter[i].length();
			
			sentence=sentence.replace(filter[i],starGenerator.generate(len));
		}
		System.out.println(sentence);
	}

}
