package array;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[]=new int[] {30,50,20,10,40};
		int point=0;
		int min=0;
		int num=0;
		int temp=0;
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		for(int i=0;i<data.length;i++) {
			point=data[i];
			min=data[i];
			for(int j=i+1;j<data.length;j++) {
				if(data[j]<=min) {
					min=data[j];
					num=j;
				}
				
			}
			temp=data[num];
			data[num]=data[i];
			data[i]=temp;
			
		}
		
	    System.out.println();
	    System.out.println("오름차순으로 정렬된 배열");
		for(int k=0;k<data.length;k++) {
			System.out.print(data[k]+" ");
	}
		}

}
