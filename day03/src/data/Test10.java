package data;
import java.lang.*;
public class Test10 {
public static void main(String[] args) {
	//타율계산 문제
	//타율=안타수/타수
	//120타수 25안타 11홈런
	//이 선수의 타율은?
	float hit=25.0f; //안타수
	float bat=120.0f; //타수
	float battingAvg=hit/bat;
	System.out.println(battingAvg);
}
}
