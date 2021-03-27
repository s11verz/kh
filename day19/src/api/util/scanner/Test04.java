package api.util.scanner;
import java.util.*;
public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("단어 입력");
		String word=sc.next();
		sc.nextLine();
		System.out.println("문장 입력");
		String line=sc.nextLine();
		
		sc.close();
		System.out.println(word);
		System.out.println(line);
		

	}

}
