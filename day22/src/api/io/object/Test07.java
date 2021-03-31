package api.io.object;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Test07 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//저장된 student.kh의 객체를 불러와서 정보 출력
		File target=new File("kh", "student.kh");
		FileInputStream in=new FileInputStream(target);
		BufferedInputStream buffer=new BufferedInputStream(in);
		ObjectInputStream ois=new ObjectInputStream(buffer);
		
		Student s=(Student)ois.readObject();
		ois.close();
		System.out.println("이름:"+s.getName());
		System.out.println("점수:"+s.getScore());
		System.out.println("전화번호:"+s.getPhone());
		
	}

}
