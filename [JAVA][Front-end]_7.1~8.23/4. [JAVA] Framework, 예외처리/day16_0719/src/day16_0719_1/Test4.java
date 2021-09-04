package day16_0719_1;

import java.util.ArrayList;

public class Test4 {

	public static void main(String[] args) {
		
		// 컬렉션에 저장될 Object의 타입을 지정해보자!
		// <제네릭>
		ArrayList<Integer> al = new ArrayList();
		// al.add("apple"); xxx -> 저장할 요소의 타입을 강제했기 때문에 불가!
		
		// 원시타입 < 반대 > Wrapper클래스
		
		al.add(10);
		al.add(11);
		al.add(12);
		if(al.get(0)<al.get(1)) {
			System.out.println("확인");
		}
		for(int v: al) {
			System.out.println(v);
		}
		

	}// main종료

}
