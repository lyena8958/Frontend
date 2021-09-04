package day17_0720;

import java.util.HashMap;
import java.util.HashSet;

public class Test3 {

	public static void main(String[] args) {
		
		// 집합은 순서가없는 컬렉션이다.
		//  중복을 허용하지않는다. == 입력을 받지않는다.(size길이도 중복제외한 길이가나옴)
		// 집합(Set), Map
		HashSet hs = new HashSet();
		hs.add(10);
		hs.add(20);
		hs.add(30);
		hs.add(10);
		hs.add(20);
		hs.add(30);
		System.out.println(hs.size()); // hash코드로 인해 주소순서로 나온다.
		
		System.out.println();
		
		// 맵은 key-value 쌍으로 이루어진 데이터를 저장한다.
		// key: 고유값
		// value: 중복될수도있는 값
		HashMap<Integer, String> map1 = new HashMap();
		// <String, String>
		map1.put(1, "홍길동"); // put(key, value);s
		map1.put(2, "아리");
		map1.put(3, "아무무");
		map1.remove(2); // 데이터삭제: 데이터 식별시, key값을 보고 판단한다.
		System.out.println(map1.get(3));
		
		
		
		
		
		
	}

}
