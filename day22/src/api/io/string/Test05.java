package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test05 {
	public static void main(String[] args) throws IOException {
		File target=new File("kh","song.txt");
		FileReader fr=new FileReader(target);
		BufferedReader br=new BufferedReader(fr);
		int line_num=0;
		int char_num=0;
		while(true) {
			String line=br.readLine();
			
			if(line==null) break;
			
			char_num+=line.length();
			if(!line.trim().isEmpty()) {
				line_num++;
			}
			
		}
		
		br.close();
		System.out.println("글자 수: "+char_num);
		System.out.println("글자줄 수: "+line_num);
		
	}

}
