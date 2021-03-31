package api.io.single;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {
	public static void main(String[] args) throws IOException {
		//kh라는 폴더 안에 single.kh라는 이름의 파일을 만들고 원하는 내용을 byte 단위로 출력
		
		File target=new File("kh", "single.kh");
		FileOutputStream out= new FileOutputStream(target);
		
		out.write(65);
		out.write(66);//out으로 65라는 byte 데이터를 출력
		
		out.close();
		
	}

}
