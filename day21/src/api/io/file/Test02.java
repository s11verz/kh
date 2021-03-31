package api.io.file;

import java.io.File;

public class Test02 {
	public static void main(String[] args) {
//		File 클래스를 이용해서 디렉터리(Directory) 제어
//		= 파일을 구분지을 수 있는 이름을 가진 공간
		
		File dir = new File("kh");
		
		System.out.println(dir.exists());
		
		System.out.println(dir.length());//디렉터리는 크기가 없거나 내장된 기본크기를 차지한다.
		
		System.out.println(dir.isDirectory());//디렉터리인가요?
		System.out.println(dir.isFile());//파일인가요?
		
//		디렉터리는 내부 구성요소에 대한 정보를 확인할 수 있는 명령이 있어야 한다
//		1. 이름만 확인 ---->  .list()  ---->  String[]  또는  List<String> 
//		2. 파일 정보를 확인 ----> .listFiles() ---->  File[] 또는  List<File>
		
		String[] names = dir.list();
		for(String name : names) {
			System.out.println("name = " + name);
		}
		
		for(int i=0; i < names.length; i++) {
			System.out.println("name = " + names[i]);
		}
		
		
		File[] files = dir.listFiles();
		for(File file : files) {
			System.out.println(file.getName()+"("+file.length()+")");
		}
		
		for(int i=0; i < files.length; i++) {
			System.out.println(files[i].getName()+"("+files[i].length()+")");
		}
		
	}
}






