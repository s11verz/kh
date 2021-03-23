package api.lang.integer;

public class Test02 {
	public static void main(String[] args) {
		
	
	int a=10;
	int b=20;
	int c=a+b;
	System.out.println(c);
	
	Integer d=new Integer(10);
	Integer e=new Integer(20);
	Integer f=Integer.sum(d, e);
	System.out.println(f.toString());

}}
