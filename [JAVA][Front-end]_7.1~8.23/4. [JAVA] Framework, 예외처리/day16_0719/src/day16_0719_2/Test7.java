package day16_0719_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Test7 {
	// 컬렉션
			// List류 => 위치파악o
			// ArrayList 배열리스트
			//  : 단점)데이터의 잦은 이동, 추가or삭제 등에 불리
			//  : 장점)인덱싱방식(배열)을 사용하고있어, 검색(탐색)에 유리
			// LinkedList 연결리스트	// 추가삭제가 빈번할 때
			//  : 데이터의 추가or삭제 등에 유리
			//  : 노드(node)를 사용하고있어, 검색(탐색)에 불리
			
	public static void main(String[] args) {
		
		//LinkedList 연결리스트
		LinkedList l1 = new LinkedList(); 
		// 각 노드에 다음주소가 들어가야하기 때문에 미리 공간을 저장해두는 것은 불가
		// 좀더 다양한 데이터의 추가, 삭제가 가능하다!
		LinkedList<String> l2 = new LinkedList();
		
		l1.add(10);
		l1.add("apple");
		// l2.add(10);
		l2.add("apple");
		//l2.addFirst("b"); -> 해당 노드의 주소는 2번째 노드의 주소를 뜻한다.
		//l2.addLast("b"); -> 다음 노드가 없으므로, 가르키는 주소가 없다.
		System.out.println(l1);
		System.out.println(l2);
		
		System.out.println();
		
		//Stack 스택 : 마지막숫자가 나옴
		//인덱스 지정이 어렵다(->스택 성격에안맞음.)
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		//s.pop(); // 마지막 데이터가 사라진다 , 반환한다.
		System.out.println(s);
		System.out.println(s.peek()); // 삭제를 동반하지않는 출력(반환)
		System.out.println(s.pop()); // 삭제를 동반한 출력(반환)
		
		System.out.println(s); // toString이 오버라이딩이 되어있다.
		
		// add, push 차이점//
		/*
		push는  Stack출신이고
		add는 Vector출신이에요!
		add는 모든 "배열류"의 자료구조가
		기본적으로 이용할수잇는 메서드입니다!
		결과가 같으니 편한대로 쓰셔도 무방하지만,
		협업시 stack에서의 add가 어색하다고 느껴지실수있으므로 push가 좋겠습니다*/

		
		System.out.println();
		// Queue 큐 : 맨앞 숫자가 나옴
		double d = 10; // 10.0
		Queue q = new LinkedList(); // 큐를 생성할때 링크리스트로 구현되어 리스트로 해야함
		q.offer(10);
		q.offer(20);
		q.offer(30);
		System.out.println(q);
		System.out.println(q.poll()); // pop대신 poll
		System.out.println(q.peek()); // 삭제x 출력만
		System.out.println(q);
	
		
		
	}//main종료

	// 스택 VS 큐 => 위치관련xxx, 저장관련o
	// ☆"문제상황" -> 어떤 자료구조, 컬렉션을 이용하여 해결할까?☆
	
	// Stack
	// : FILO = First in Last out == 선입후출
	// == LIFO == 후입선출 (선입후출과 같은의미)
	// == 입구가 1개뿐인 선형구조
	//처음에 넣은데이터가 마지막에 나오고, 마지막에 넣은 데이터가 제일 먼저 나온다.
	//ex) (c+z)실행취소, 뒤로가기, 최근방문한페이지
	// 배열기반
	
	// Queue
	// : FIFO == 선입선출
	//  ==LILO == 후입후출
	//  == 입구와 출구가 정해진 선형구조
	// ex) 대기열 수강신청(새로고침 ->대기열 뒷번), 티켓팅, 영화관, 순번 ...
	// 큐라는 구조의 기반을 LinkedList로 구현했음 == 모든 큐는 LinkedList이다.
	// 리스트기반
	
}
