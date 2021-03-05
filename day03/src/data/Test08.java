package data;

import java.lang.*;

public class Test08 {
public static void main(String[] args) {
	//2과목 성적의 총점과 평균 구하기
	int javaScore=90;
	int dbScore=75;
	
	int totalScore=javaScore+dbScore;
	float avgScore=totalScore/2;
	
	System.out.println(totalScore);
	System.out.println(avgScore);
}
}
