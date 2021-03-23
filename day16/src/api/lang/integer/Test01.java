package api.lang.integer;

public class Test01 {
public static void main(String[] args) {
	Integer a=new Integer(100);
	Integer b=new Integer(100);
	
	System.out.println("a="+a.toString());
	System.out.println("b="+b.toString());
	System.out.println(a==b);
	System.out.println(a.equals(b));
}
}
