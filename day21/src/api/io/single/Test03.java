package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {

	private static final int EOF = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File origin = new File("kh", "practice.kh");
		FileInputStream in = new FileInputStream(origin);
		File copy = new File("kh", "copy.kh");
		FileOutputStream out = new FileOutputStream(copy);
		String str = "hello java\n파일 입출력 예제입니다.";
		long total=origin.length();
		long count=0L;
		while(true) {
			int n=in.read();
			if(n==EOF) break;
			out.write(n);
		}
		
		in.close();
		out.close();

	}

}
