package api.io.single;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test04 {
	public static void main(String[] args) throws IOException {
		File target=new File("kh", "single2.kh");
		FileOutputStream out=new FileOutputStream(target);
		
		byte[] data=new byte[]{104, 101, 108, 108,111};
		
		out.write(data);//배열의 내용 전부 출력(hello)
		out.write(data,1,3);//배열의 내용 1번부터 3개 출력(ell)
		out.write(data,0,4);//배열의 내용 0번부터 4개 출력(hell)
		
		out.close();
		
	}

}
