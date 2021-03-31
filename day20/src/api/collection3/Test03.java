package api.collection3;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map=new HashMap<>();
		map.put("피카츄",100);
		map.put("라이츄",89);
		map.put("파이리",77);
		map.put("꼬부기",63);
		//Map<String, Integer> → Set<String> → Iterator<String> 또는 확장 for
		/*Set<String> set=map.keySet();
		for(String name:set) {
			System.out.println("이름="+name);
			System.out.println("점수="+map.get(name));
		}*/
		Set<Entry<String, Integer>> entrys = map.entrySet();
		for(Entry<String, Integer> entry : entrys) {
			System.out.println("이름 = " + entry.getKey());
			System.out.println("점수 = " + entry.getValue());
		}
		
		

	}

}
