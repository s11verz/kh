package api.io.multi;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Test04 {
	public static void main(String[] args) throws IOException {
		List<Integer> list=new ArrayList<>();
		
		File target=new File("kh","lotto.kh");
		FileInputStream in=new FileInputStream(target);
		BufferedInputStream buffer=new BufferedInputStream(in);
		DataInputStream data=new DataInputStream(buffer);
		try {
		while(true) {
			int value=data.readInt();
			System.out.println(value);
			list.add(value);
		}
		}catch(Exception e){
			
		}
		data.close();
		for(int value:list) {
			System.out.println(value);
		}
	}

}
