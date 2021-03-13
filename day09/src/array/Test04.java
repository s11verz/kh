package array; //다시해보기
import java.util.*;
public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//사용자에게 숫자를 7개 입력받아서 내림차순으로 선택정렬 구현하여 출력
		//선택정렬
		Scanner sc=new Scanner(System.in);
		int data[]=new int[7];
		
		int num=0;
		
		for(int i=0;i<data.length;i++) {
			System.out.println("숫자를 입력하세요.");
			data[i]=sc.nextInt();
		}
		System.out.println("입력한 배열");
		for (int j=0;j<data.length;j++) {
			System.out.print(data[j]+" ");
		}
		for(int k=0;k<data.length;k++) {
			int point=data[k];
			int max=data[k];
			for(int l=k+1;l<data.length;l++) {
				if (data[l]>=max) {
					max=data[l];
					num=l;
					int temp=data[num];
					data[num]=data[k];
					data[k]=temp;
					
				}
			}
			
		}
		
		
		
		System.out.println();
		System.out.println("내림차순으로 정렬된 배열");
		for(int m=0;m<data.length;m++) {
			
			System.out.print(data[m]+" ");
		}}}

		


