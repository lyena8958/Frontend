package day10_0705;

import java.util.Scanner;

class Car3{
	Car3(String name){ // 사용자 이름이 꼭필요하다하면 생성자 정의! == 인자는 name
		// user=user; // 인자를 가까운 곳인 생성자 변수로 가져오는데. 지역변수바뀐다.
		this.name=name; // this == 자기자신객체 (포인터개념)
		speed =0; // 생성자 인자에 없어서 this 안써도된다.(중복변수가없다.)
	}
	String name; 
	int speed; 
	void speedUp() { 
	
		System.out.println("속도 업");
		speed+=10;
	}
	void speedDown() { // "
		System.out.println("속도 다운");
		speed-=10;
	}
}

// 자동차를 만들기 위한 공간 생성
// class 안에 생성된 변수는 지역변수다.
class Car{ 
	// 기본생성자 생성 
	Car(){ // ★리턴타입 명시안함! - 객체를 리턴하는게 확정이기 때문에 output명시 안함★
		System.out.println("기본생성자 호출됨!");
		speed = 100; // 멤버변수 초기화가 가능한 생성자!
		// 인자가 없는 생성자 == 기본생성자 == 디폴트생성자
		// 기본생성자는 "기본제공해준다!"
	}
	String name; // 멤버변수==속성==필드
	int speed; // 멤버변수의 값은 타 객체와 공유되지 않는다!!!!!!! == 객체변수(잘안부름)
	void speedUp() { // 인풋아웃풋 없음 // static xxxxx
	// 사용자정의함수와 차이는 static이 없다. 대상마다 쓸수있는 메소드가 정해져있어서.
	// 주체가 있어서
		System.out.println("속도 업");
		speed+=10;
	}
	void speedDown() { // "
		System.out.println("속도 다운");
		speed-=10;
	}
}
// 멤버변수 = 파란색!, 지역변수 = 갈색!
// 함수생성시 static은 해당 클래스만 사용하는 함수니까 사용하지않는다.

// 기본생성자 기본제공 사용
class Car2{ 
	String name; // 멤버변수==속성==필드
	int speed; // 멤버변수의 값은 공유되지 않는다!!!!!!! == 객체변수(잘안부름)
	void speedUp() { // 인풋아웃풋 없음 // static xxxxx
	// 사용자정의함수와 차이는 static이 없다. 대상마다 쓸수있는 메소드가 정해져있어서.
	// 주체가 있어서
		System.out.println("속도 업");
		speed+=10;
	}
	void speedDown() { // "
		System.out.println("속도 다운");
		speed-=10;
	}
}


public class CarTest {
	public static void main(String[] args) {
		String name; 
		// 지역변수 : 함수 내부에 선언되는 변수
		// 생명주기 == 함수까지(main)
		boolean power;
		int speed;
		
		Scanner sc = new Scanner(System.in);
		//★ 생성자 정의 
		Car    car = new Car(); // 힙써서 자동초기화 0
		Car	   car2= new Car();
		// Car 클래스의	car라는 객체화,인스턴스화 .. car2
		
		// car.하면 기능의 오른쪽-> Object는 자바에서 제공한 기능, Car라고 되어있는건 우리가 만든 기능
		System.out.println(car.speed); // 100
		System.out.println(car2.speed); // 100
		car.speedUp(); 
		car2.speedDown(); 
		// 멤버변수는 공유가 되지 않는다.
		
		System.out.println(car.speed); // 110
		System.out.println(car2.speed); //90
		
		//==================================== 생성자구분
		System.out.println();
		
		//★ 생성자 x(java 기본제공한 틀)
		Car2    car3 = new Car2(); // 힙써서 자동초기화 0
		Car2    car4 = new Car2();
		
		System.out.println(car3.speed); // 0
		System.out.println(car4.speed); // 0
		car3.speedUp(); 
		car4.speedDown(); 
		
		System.out.println(car3.speed); // 10
		System.out.println(car4.speed); //-10
		
		//==================================== 사용자정의 된 클래스 
		// Scanner sc = new Scanner(); // 생성자가 1개이상 정의가 되어 있어 인자값을 넣어야 한다.
		Car3 car5 = new Car3("홍길동");
		
		
		
	} // main종료

}
