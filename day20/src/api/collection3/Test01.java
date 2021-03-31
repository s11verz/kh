package api.collection3;

import java.util.HashMap;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> map=new HashMap<>();
		
		map.put("피카츄",100);
		map.put("라이츄",89);
		map.put("파이리",77);
		map.put("꼬부기",63);
		
		System.out.println(map.size());//사이즈
		
		System.out.println(map.containsKey("피카츄"));// true
		System.out.println(map.containsValue(100));//true
		
		System.out.println(map);//전부출력
		
		
		

	}

}
