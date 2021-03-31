package api.io.object;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test01 {
	public static void main(String[] args) throws IOException {
		//객체를 만들어서 파일에 출력
		
		//객체 생성
		Date d=new Date();
		
		//파일 출력
		File target=new File("kh","object.kh");
		FileOutputStream out=new FileOutputStream(target);
		BufferedOutputStream buffer=new BufferedOutputStream(out);
		ObjectOutputStream oos=new ObjectOutputStream(buffer);
		
		oos.writeObject(d);//d라는 객체를 출력
		
		oos.close();
	}

}
