package array;
import java.lang.*;
public class Test03_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pushup[]=new int[10];
		pushup[0]=10;
		
		for(int i=0;i<10;i++) {
			if(i<1) {
				System.out.println(i+1+"일차에는"+pushup[i]+"개");
			}else {
			pushup[i]=pushup[i-1]+3;
			System.out.println(i+1+"일차에는"+pushup[i]+"개");
		}}
		

	}

}
