package api.io.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) throws IOException {
		//문자열 입력을 reader로 진행
		File target=new File("kh","string2.kh");
		FileReader fr=new FileReader(target);
		
		char[] buffer=new char[10];
		StringBuffer sb=new StringBuffer();
		
		while(true) {
			int size=fr.read(buffer);
			if(size==-1) break;
			sb.append(buffer,0,size);
		}
		fr.close();
		System.out.println(sb.toString());
	
		
	}

}
