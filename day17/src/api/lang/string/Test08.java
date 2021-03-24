package api.lang.string;

public class Test08 {
	public static void main(String[] args) {
		
	StringBuilder buffer=new StringBuilder();
	
	long start=System.currentTimeMillis();
	
	for(int i=0;i<1000;i++) {
		buffer.append("hello\n");
	}
	long finish=System.currentTimeMillis();
	System.out.println(buffer.toString());
	System.out.println("소요시간"+(finish-start)+"ms");

}
}