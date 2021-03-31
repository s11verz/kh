package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Test05 {

	public static void main(String[] args) throws IOException {
		// 싱글바이트 입력을 여러개 묶어서 처리
		File target=new File("kh","single2.kh");
		FileInputStream in=new FileInputStream(target);
		
		byte[] buffer=new byte[5];
		/*System.out.println(Arrays.toString(buffer));
		in.read(buffer);*/
		
		while(true) {
			int n=in.read(buffer);
			if(n==-1) break;
			System.out.println("n="+n);
			System.out.println(Arrays.toString(buffer));
		}
		in.close();
		

	}

}
