package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) throws IOException {
		// kh폴더 안에 있는 single.kh 파일의 내용을 읽어와 콘솔에 출력
		File target=new File("kh","single.kh");
		FileInputStream in=new FileInputStream(target);
		
		//[프로그램]<in<target<[single.kh]
		/*for(long i=0;i<target.length();i++) {
		int n=in.read();
		System.out.println(("n="+n));
		}*/
		while(true) {
			int n=in.read();
			if(n==-1) break;
			System.out.println("n="+n);
		}//-1:EOF(End Of File)
		in.close();

	}

}
