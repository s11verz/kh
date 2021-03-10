package loop2;
import java.lang.*;
import java.util.*;
public class Test02 {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 
	 while(true) {
		 
	 System.out.println("숫자를 입력하세요.(0 입력시 종료)");
	 int user=sc.nextInt();
	 System.out.println("입력한 숫자는"+user);
	 if(user==0) {
		 System.out.println("program terminated!");
		 break;
	
	 }}
	 
	 //sc.close();	 
 }
}
