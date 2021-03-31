package api.io.object;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test06 {
	public static void main(String[] args) throws IOException {
		Student s=new Student("홍길동",90,"010-9903-5444");
		
		File target=new File("kh","student.kh");
		FileOutputStream out=new FileOutputStream(target);
		BufferedOutputStream buffer=new BufferedOutputStream(out);
		ObjectOutputStream oos=new ObjectOutputStream(buffer);
		
		oos.writeObject(s);
		oos.close();
	}

}
