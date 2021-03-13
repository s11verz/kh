package array;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[]=new int[] {30,50,20,10,40};
		
		
		
		int temp=data[1];
		data[1]=data[3];
		data[3]=temp;
		
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
		
		
		
		

	}

}
