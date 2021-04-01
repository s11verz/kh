package com.kh.test.run;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RunTest {
	public static void main(String[] args) {
		Random r=new Random();
		Scanner sc=new Scanner(System.in);
		System.out.println("출력 횟수를 입력하세요.");
		int num=sc.nextInt();
		
		
		
		for(int j=0;j<num;j++) {
			HashSet<Integer> set=new HashSet<>();
			
			while (true) {
	            if(set.size()==6) break;
	            int array_num = r.nextInt(45) + 1;
	            set.add(array_num);
	         }
			List<Integer> list=new ArrayList<>(set);
			Collections.sort(list);
			System.out.println(list);
		}
		}
		
		
		
		
		

}
