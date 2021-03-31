package api.io.multi;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test03 {
	public static void main(String[] args) throws IOException {
		//로또번호 6개 추첨하여 lotto.kh라느 파일에 저장하는 프로그램
		List<Integer> base=new ArrayList<>();
		for(int i=1;i<=45;i++) {
			base.add(i);
		}
		Collections.shuffle(base);
		
		List<Integer> lotto=base.subList(0,6);
		Collections.sort(lotto);
		
		File target=new File("kh","lotto.kh");
		FileOutputStream out=new FileOutputStream(target);
		BufferedOutputStream buffer=new BufferedOutputStream(out);
		DataOutputStream data=new DataOutputStream(buffer);
		
	for(int number:lotto) {
		data.writeInt(number);
	}
		
		data.close();
	}
	

}

