package api.io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test03 {

	public static void main(String[] args) {
		File drive = new File("C:/");
		System.out.println(drive.exists());
		
		System.out.println(drive.isDirectory());
		System.out.println(drive.canRead());
		System.out.println(drive.canWrite());
		System.out.println(drive.canExecute());
		
			
	}

}
