package api.io.string;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test04_1 {
	public static void main(String[] args) throws IOException {
		// 문자열 입력을 reader로 진행
		File target = new File("kh", "string2.kh");
		FileReader fr = new FileReader(target);
		BufferedReader br = new BufferedReader(fr);
		

		while (true) {

			String line = br.readLine();// 한줄 읽기
			if (line == null)
				break;
			System.out.println("line=" + line);

		}
		br.close();

	}

}
