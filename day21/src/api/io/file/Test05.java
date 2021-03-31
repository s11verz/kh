package api.io.file;

import java.io.File;
import java.io.IOException;

public class Test05 {

	public static void main(String[] args)  {
		// 파일 및 폴더의 생성, 삭제
		try {
		File dir=new File("kh","test");
		
		System.out.println(dir.exists());
		
		//파일 생성
		dir.createNewFile();
		//삭제: 폴더, 파일 모두 같은 명령 사용
		dir.delete();}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
