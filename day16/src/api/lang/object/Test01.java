package api.lang.object;

public class Test01 {
	public static void main(String[] args) {
		
	
		//1. 객체생성
		Object a=new Object();
		Object b=new Object();
		
		//2. 객체 사용
		//hashCode: 일련번호 반환
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		//toString
		System.out.println(a.toString());
		System.out.println(b.toString());
		

}
}
