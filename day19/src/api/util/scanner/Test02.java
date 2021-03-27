package api.util.scanner;
import java.util.*;
public class Test02 {

	public static void main(String[] args) {
		//문장 읽기
		
		String song="떴다 떴다 비행\n날아라 날아라\n떴다 떴 비행기\n우리 비행기";
		Scanner sc=new Scanner(song);
		while(sc.hasNextLine()) {
			String word=sc.nextLine();
			System.out.println(word);
					
		}
		sc.close();

	}

}
