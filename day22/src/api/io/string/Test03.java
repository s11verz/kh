package api.io.string;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test03 {
	public static void main(String[] args) throws IOException {
		//앞선 문제를 해결하기 위해 writer 계열 사용
		//FileOutputStream -> FileWriter
		//BufferedOutputStrewam -> BufferedWriter
		//PrintWriter: 출력의 편의를 위한 각종 명령을 제공하는 도구
		
		File target=new File("kh","string2.kh");
	/*	FileWriter fw=new FileWriter(target);
		BufferedWriter bw=new BufferedWriter(fw,1024);
		PrintWriter pw=new PrintWriter(bw); */
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(target),1024));
		
		
		pw.println("Hello 자바1");
		pw.println("Hello 자바2");
		pw.println(100+300);
		
		//fw.flush();
		pw.close();
	
		
	}

}
