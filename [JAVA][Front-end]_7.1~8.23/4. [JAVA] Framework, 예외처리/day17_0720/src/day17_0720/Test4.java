package day17_0720;

import java.util.ArrayList;
import java.util.Iterator;


public class Test4 {

	public static void main(String[] args) {
		
		// 이터레이터
		// 컬렉션이 존재할때, 해당 데이터집합을 복사하여 "출력"하는 용도로 사용
		// 기존데이터가 망가지지않는 "안정성"이있다.
		ArrayList al = new ArrayList();
		al.add(10);
		al.add(20);
		al.add(30);
		for(int i = 0; i < al.size();i++) {
			System.out.println(al.get(i));
		}
		for(Object obj:al) {
			System.out.println(obj);
		}
		Iterator itr = al.iterator();
		// al데이터내용을 복사한 복사체
		// hasNext - 다음 값을 갖고있어?
		// next - 값을 갖고오는 역할
		
		while(itr.hasNext()) {// 다음에 아무값이 없니?
			System.out.println(itr.next()); // pop.poll처럼 ->오브젝트, 객체(내용물) 반환
		}
		
		// "프레임워크" (컬렉션 프레임워크)
		// 컬렉션 :총 7가지
		// al ll stack queue (set map) itr
		// stack - 실행취소, 뒤로가기		queue - 대기열
		// ( ) - 단독사용하지않음
		// itr 기존데이터를 손상하고싶지 않을때, 출력하는 용도
		
		
		
	}

}
