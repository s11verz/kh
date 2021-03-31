package api.io.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Format;

public class Test06 {
	public static void main(String[] args) throws IOException {
		//복사 프로그램에 버퍼를 적용시켜 성능을 향상시킨 버전
		
		File origin=new File("kh","practice.kh");
		File copy=new File("kh","copy.kh");
		
		FileInputStream in=new FileInputStream(origin);
		FileOutputStream out=new FileOutputStream(copy);
		
		byte[] buffer=new byte[8192];
		
		long total=origin.length();
		long count=0L;
		Format f=new DecimalFormat("0.00");
		
		while(true) {
		int size=in.read(buffer);
		if (size==-1) break;
		out.write(buffer,0,size);
		
		count+=size;
		double percent=count*100.0/total;
		System.out.print("총"+total+" 중 "+count+"byte 이동 완료");
		System.out.println("("+f.format(percent)+"%)");
		}
		in.close();
		out.close();
		
	}

}
