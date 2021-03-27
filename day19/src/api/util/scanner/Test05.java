package api.util.scanner;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;
public class Test05 {

	public static void main(String[] args) {
		// Scanner를 이용한 웹페이지 불러오기
		try {

			URL url=new URL("https://www.naver.com");
			Scanner sc=new Scanner(url.openStream());
			String regex=".*?(https?:\\/\\/)?www\\..*\r\n";
					
			while(sc.hasNextLine()) {
				String line=sc.nextLine();
				System.out.println(line);
				if(Pattern.matches(regex,line)) {
					System.out.println(line);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
