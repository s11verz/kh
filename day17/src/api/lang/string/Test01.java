package api.lang.string;

public class Test01 {

	public static void main(String[] args) {
		// new가 있고 없고의 차이
		String a="hello";
		String b="hello";

		String c=new String("hello");
		String d=new String("hello");
		
		System.out.println(a==b);
		System.out.println(b==c);
		System.out.println(c==d);
		System.out.println(a==d);

	}

}
