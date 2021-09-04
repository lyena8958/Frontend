package day11_0706_2;

class Car2{
	String name;
	int speed;
	void show() {
		System.out.println(name+"님의 속도: "+speed);
	}
}
public class Test4 {

	public static void main(String[] args) {
		// 클래스:객체= 1:N
		// 객체:생성자 호출=1:1 <= " 객체 배열 " !!!!!!객체와 생성자호출이 1:1!!!!!!
		
//		Car2 c1=new Car2();
//		Car2 c2=new Car2();
//		Car2 c3=new Car2();
		// 를 배열로 ↓↓↓↓↓
		
		Car2[] car = new Car2[3]; // 생성자가 호출이 안됐기 때문에, 빵 상자 3개를 부른거나 마찬가지다.
//		car[0] = new Car2(); // 이제 빵상자1에 빵을 넣는다.(주소가 들어간다.)
//		car[1] = new Car2(); // "2
//		car[2] = new Car2(); // "3
		
//      위 3번 넣는 과정을 반복문으로 코드요약
		for(int i = 0; i < car.length;i++) {
			car[i] = new Car2();
		}
		for(int i = 0; i < car.length;i++) {
			car[i].show();
		}
		for(Car2 v: car) {
			v.show();
		}

		
		// 일반배열
		int[] arr = new int[3]; // 4바이트가 들어갈수있는 3개 공간을 만듦
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
				
		

	}

}
// 변수 3요소 - 크기 주소 이름
// 연산자
// 조건문
// 반복문
// 배열, 다차원배열, 문자열 (C언어와 다르게 heap영역을 사용해서 변수로 넣을수도있다.)
// 함수 3요소 - input, output, 괄호
// 함수 -> static("객체와 무관하게")
// *클래스와 객체
//   : 1 : N, 객체화(인스턴스화), 생성자(객체화를 담당), 오버로딩, 멤버변수(.), this
//		생성자에 new를 사용하기때문에 초기화가 가능
//  4가지 특징
//	 1) 추상화  
//	 2) 캡슐화-접근제어자,getter,setter  
//	 3) 상속  
//	 4) 다형성