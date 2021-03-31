package api.io.file;

import java.io.File;

public class Test04 {

	public static void main(String[] args) {
		// 파일 및 폴더의 생성, 삭제
		
		File dir=new File("kh","test");
		
		System.out.println(dir.exists());
		
		//폴더 생성
		//-mkdir(): 중간 경로가 없으면 생성이 안됨
		//-mkdirs():중간 경로가 없으면 중간 경로 디렉터리까지 생성해줌
		dir.mkdirs();
		
		//삭제: 폴더, 파일 모두 같은 명령 사용
		dir.delete();

	}

}
