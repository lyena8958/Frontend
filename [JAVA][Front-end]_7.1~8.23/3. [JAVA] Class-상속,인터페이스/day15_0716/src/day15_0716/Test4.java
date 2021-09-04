package day15_0716;

import java.util.ArrayList;
class Student{
	String name;
	Student(){
		this.name= "학생";
	}
	@Override
	public String toString() { // 오버라이딩
		return "Student [name=" + name + "]";
	}
	
}
public class Test4 {

	public static void main(String[] args) {
		// 컬렉션 프레임워크
		// "프레임워크"
		
		// [배열리스트]
		// : 배열을 리스트화한 컬렉션(자료구조)
		// "리스트"?
		//ArrayList al = new ArrayList(3); // 굳이 길이값을 넣지않아도된다.
		ArrayList al = new ArrayList(); // 길이지정안해도 되지만 보통은 공간을 놓고 시작한다.
		// ArrayList -> 앞글자 대문자? 클래스네!!
		al.add(new Student());
		al.add("apple");
		al.add("치킨");
		
		al.add(10); // 내부로직을 몰라도 쓸수있음!! == 캡슐화
		al.add(20);// 함수호출!!
		System.out.println(al.size()); // 길이를 찾아줌
		al.add(0, 10); // 인덱스 삽입(0번 인덱스에 30을 넣겠다.)
		al.add(40);
		System.out.println(al);
		System.out.println(al.get(2));// al[index]로 값을 갖고올수가 없어 get함수로 끌고와준다.
		System.out.println(al.indexOf(10)); // → 검색방향(앞의값이 먼저나온다))
		// 값을 찾아 인덱스넘버를 알려줌(없으면 -1) 
		System.out.println(al.lastIndexOf(10));
		//[]대신 get함수
//		for(int i = 0; i < al.size();i++) {
//			if((Integer)al.get(i)==10) { // Integer == int (대체적으로 클래스->형변환 Integer로한다)
//				// al.get(i)==10 자료형이 달라서 안됨(int, Object class)
//				System.out.println(i);
//			}
//		}
		
		if(al.contains(10)) { // al안에 10이란 값이 있니?
			System.out.println("있어.");
		}
		if(al.indexOf(100)==-1) {
			System.out.println("없어.");
		}
		
		al.clear(); // 인자를 다없애주는 함수
		if(al.isEmpty()) {// is==그거니?? 란 뜻이다 isEmpty==텅비어있니??
			System.out.println("텅빔");
		}
		System.out.println(al); // toString이 숨겨져있음
		System.out.println(al.size()); // 길이를 찾아줌
		
		al.clear();
		
	}//main 종료
}
/*
프레임워크
- framework
- 뼈대, 골격, 구조, 틀

컬렉션 프레임워크☆☆☆☆☆
spring 프레임워크☆☆☆☆☆

자유도>>>>>>>
개발자의 역량>>>>>>>
// 자유도가 높을수록 개발자의 역량이 높아야한다.


"배열": 여러가지의 관련된 데이터를 한공간에 저장
==컬렉션(자료구조: 웹개발)
	배열,리스트,스택,큐,맵,집합(Set).... // 파이썬 list set과 비슷하다.
========================================================

int[] data=new int[5];   vs	컬렉션
크기 제한			크기제한이없음
data[0] = 10;		data.add(10);
data[1] = 20;		data.add(20);
지정하여 데이터 저장	다양한 데이터를 관리할수있는 관련 메서드가 이미 구현되어있다!


→ ★즉 배열보다는[ 컬렉션 ]을 사용한다.*/