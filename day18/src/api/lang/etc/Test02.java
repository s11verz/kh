package api.lang.etc;

import java.util.regex.Pattern;

public class Test02 {

	public static void main(String[] args) {
		
		System.out.println("표준메세지");
		System.err.println("오류메세지");
		
		long time=System.currentTimeMillis();
		System.out.println(time);
		
		System.out.println(System.getProperties());
		System.out.println(System.getProperty("java.specification.version"));
		System.out.println(System.getProperty("os.name"));
		
		String regex="^Windows.*$";
		if(Pattern.matches(regex, System.getProperty("os.name"))){
			System.out.println("윈도우입니다.");
		}else {
			System.out.println("윈도우가 아닙니다.");
		}
		
		//프로그램 종료
		System.exit(0);
		System.out.println("이 메세지는 나오지 않습니다.");
	

	}

}
