package oop.basic8;
import java.util.*;
import oop.basic8.student;

public class Test01 {
	public static void main(String[] args) {
		student a=new student();
		student b=new student();
		student c=new student();
		int array1[]=new int[4];
		int array2[]=new int[4];
		int array3[]=new int[4];
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("첫번째 학생의 정보를 입력하세요.");
		for(int i=0;i<array1.length;i++) {
			array1[i]=sc.nextInt();
		}
		System.out.println("두번째 학생의 정보를 입력하세요.");
		for(int i=0;i<array1.length;i++) {
			array2[i]=sc.nextInt();
		}
		System.out.println("세번째 학생의 정보를 입력하세요.");
		for(int i=0;i<array1.length;i++) {
			array3[i]=sc.nextInt();
		}
		a.set("마리오", array1[0], array1[1], array1[2], array1[3]);
		b.set("루이지", array2[0], array2[1], array2[2], array2[3]);
		c.set("쿠파", array3[0], array3[1], array3[2], array3[3]);
		
		a.result();
		System.out.println();
		b.result();
		System.out.println();
		c.result();
		
		
	}
	
	
	

}
