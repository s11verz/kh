package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class Test01 {
	public static void main(String[] args) throws IOException {
		
		File target=new File("kh","multi.kh");
		FileOutputStream out=new FileOutputStream(target);
		BufferedOutputStream buffer=new BufferedOutputStream(out);
		DataOutputStream data=new DataOutputStream(buffer);
		
		data.writeInt(100);
		data.writeDouble(100);
		data.writeFloat(100);
		data.writeChar(100);
		//수동-대기실을 비워야 출력이 이루어짐
		//자동-대기실을 가득 채워도 출력이 이루어짐
		data.flush();
		data.close();
	}

}
