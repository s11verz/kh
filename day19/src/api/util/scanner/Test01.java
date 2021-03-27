package api.util.scanner;
import java.util.*;
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="빨강,주황-노랑*초록+파랑=남색 보라";
		Scanner sc=new Scanner(str);
		sc.useDelimiter("[,\\s+\\-*=]");
		while(sc.hasNext()) {
			
			String word=sc.next();
			System.out.println("word="+word);
			
		}
		sc.close();
	}

}
