package api.lang.string;

import java.util.regex.Pattern;
public class Test09 {

	public static void main(String[] args) {

		String id = "khstudent1234-_";
		String regex="^[a-z0-9-_]{5,20}$";
		if(Pattern.matches(regex,id)) {
			System.out.println("올바른 아이디 입니다.");
		}else {
			System.out.println("아이디는 영문 소문자,숫자,-,_로 구성된 5~20자로 작성하세요!");
		}
	

}}
