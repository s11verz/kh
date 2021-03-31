package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.Date;

public class Test03 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//object 형태로 업캐스팅하여 저장
		File target=new File("kh","object.kh");
		FileInputStream in=new FileInputStream(target);
		BufferedInputStream buffer=new BufferedInputStream(in);
		ObjectInputStream ois=new ObjectInputStream(buffer);
		
		Object object=ois.readObject();
		Date d=(Date)object; //다운캐스팅
		ois.close();
		
		System.out.println(d);//하.. 어렵다
		
	}

}
