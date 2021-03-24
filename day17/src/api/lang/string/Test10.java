package api.lang.string;
import java.util.regex.Pattern;
import java.util.*;
public class Test10 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("우편번호를 입력하세요.(신주소/구주소)");
		String postNum=sc.nextLine();
		String regex1="^\\d{5}$";
		String regex2="^\\d{6}$";
		
		if(Pattern.matches(regex1, postNum))
			System.out.println("올바른 우편번호 입니다.");
		else if(Pattern.matches(regex2, postNum))
				System.out.println("올바른 우편번호 입니다.");
		else System.out.println("우편번호가 틀렸습니다.");
		
		System.out.println("비밀번호를 입력하세요.");
		String password=sc.nextLine();
		String regex3="^[a-zA-Z0-9!@#$]{8,16}$";
		if(Pattern.matches(regex3,password))
			System.out.println("올바른 비밀번호 입니다.");
		else
			System.out.println("비밀번호가 틀렸습니다.");
		
		System.out.println("이름을 입력하세요.");
		String name=sc.nextLine();
		String regex4="^[가-힣]{2,10}$";
		if(Pattern.matches(regex4,name))
			System.out.println("올바른 이름 입니다.");
		else
			System.out.println("이름이 틀렸습니다.");
		
		System.out.println("전화번호를 입력하세요.(-포함)");
		String number=sc.nextLine();
		String regex5="^010-\\d{4}-\\d{4}$";
		if(Pattern.matches(regex5,number))
			System.out.println("올바른 번호 입니다.");
		else
			System.out.println("번호가 틀렸습니다.");
		
		System.out.println("생년월일을 입력하세요.");
		String birth=sc.nextLine();
		String regex6="^19[0-9][0-9]|20[0-9][0-9]-0[1-9]|1[0-2]-0[1-9]|1[0-9]|2[0-9]|3[0-1]$";
		if(Pattern.matches(regex6,birth))
			System.out.println("올바른 생년월일 입니다.");
		else
			System.out.println("생년월일이 틀렸습니다.");
		
				

	}

}
