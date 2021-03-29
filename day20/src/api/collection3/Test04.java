package api.collection3;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class Test04 {

	public static void main(String[] args) {
		// 투표 프로그램 만들기
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("임영웅", 0);
		map.put("아이유", 0);
		map.put("장범준", 0);
		map.put("BTS", 0);
		map.put("폴킴", 0);

		String stop = "그만";

		while (true) {
			System.out.println("투표할 가수 이름을 입력하세요.");
			String singer = sc.next();

			if (map.containsKey(singer) == true) {
				
				map.put(singer, map.get(singer)+1);
			} else if (singer.equals(stop)) {
				System.out.println("투표를 종료합니다.");
				break;
			} else {
				System.out.println("해당 가수에게는 투표하실 수 없습니다.");
			}

		}
		System.out.println();
		System.out.println("<투표 결과>");
		Set<Entry<String, Integer>> entrys = map.entrySet();
		for (Entry<String, Integer> entry : entrys) {
			System.out.println(entry.getKey() + ":" + entry.getValue() + "표");

		}

	}

}
