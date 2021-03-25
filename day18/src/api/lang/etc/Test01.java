package api.lang.etc;

public class Test01 {

	public static void main(String[] args) {
		
		float a=1.5f;
		int b=(int)(a+0.5f);
		System.out.println("b="+b);
		
		int c=Math.round(a);
		System.out.println("c="+c);
		
		int v=10;
		int w=20;
		int e=Math.abs(v-w);
		System.out.println(e);
		
		int f=(int)Math.pow(2,10);
		System.out.println(f);

	}

}
