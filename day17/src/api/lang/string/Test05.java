package api.lang.string;

public class Test05 {

	public static void main(String[] args) {
		String word="Hello World!";
		System.out.println(word.toUpperCase());
		System.out.println(word.toLowerCase());
		System.out.println(word);
		
		String url="www.naver.com";
		System.out.println(url.substring(4));//+4지점부터 끝까지 잘라내기
		System.out.println(url.substring(4,9));
		
		String keyword="    안녕하 세요    ";
		System.out.println(keyword.trim());
		System.out.println(keyword.trim().length());
		
		String str="오늘 점심은 피자다";
		System.out.println(str);
		System.out.println(str.replace("피자","파스타"));
		

	}

}
