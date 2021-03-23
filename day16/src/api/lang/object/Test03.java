package api.lang.object;
import java.util.*;
public class Test03 {
	public static void main(String[] args) {
		Object a=10;
		Object b="hello";
		Object sc=new Scanner(System.in);
		Object d=3.13;
		Object e=true;
		
		System.out.println(a.getClass());
		System.out.println(b.getClass());
		
		System.out.println(a instanceof Integer);
		System.out.println(b instanceof String);
	}

}
