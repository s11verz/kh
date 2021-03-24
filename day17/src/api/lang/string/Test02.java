package api.lang.string;

public class Test02 {

	public static void main(String[] args) {

		String url = "http://www.naver.com";
		
		//1.글자수는 얼마?
		System.out.println(url.length());
		//2.http로 시작?
		System.out.println(url.startsWith("http"));
		System.out.println(url.startsWith("http",5));//+5지점부터 확인
		//3..com으로 끝남? 
		System.out.println(url.endsWith(".com"));
		//4.naver라는 글자가 존재?
		System.out.println(url.contains("naver"));
		//5.naver라는 글자가 어디 있는지?
		System.out.println(url.indexOf("naver"));
		//6.11번째 글자가 무엇인지?
		System.out.println(url.charAt(11));

	}

}
