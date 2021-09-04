package day11_0706;

class Car{
	// 생성자(함수의 한 종류)
	// 생성자의 독특한 특징 3!
	// 1) 객체를 생성할때 사용하고,
	// 2) 클래스와 이름이 같은 함수(메서드 == 함수)
	// 3) 반환되는 것이 객체이기때문에 리턴타입명시xxx
	// 위 세가지 외 에는 함수의 특징을 따라간다.
	Car(){
		this("미정", 20); // 13번 메소드 재활용해서, 고정값을먼저 해준다 // == Car(name...speed)  // this() 생성자 호출
	}
	Car(String name, int maxspeed){ // String n , int m
		this.name = name; // name = n;
		this.maxSpeed=maxspeed; // maxSpeed=m;
		this.speed = 0; // 얘는 편의상 ( 가독성 ) this // ex) 인자값없는이유 - 굳이안써도되는 성별 이메일 등
	}
	String name;
	int speed;
	int maxSpeed;
	void show() {
		System.out.println(this.name+"님 현재속도: "+this.speed);
	}
}

public class Test2 {
	public static void main(String[] args) {
		
		Car car = new Car("홍길동", 60); // 인자2개->메소드(인자2개)를 부름
		car.show(); 
		// 기본생성자: null님 현재속도: 0 
		// 정의생성자: 홍길동님 현재속도: 0
		// car.name or Car(name);
	
		Car car2 = new Car(); // == Car("미정", 20)
		// == 기본, 디폴트 생성자는 기본,디폴트값을 설정하는 역할!
		car2.show();
		
		/* 메인 실행순서
		21 
		23->7 (인자 2개 메소드)
		24->15

		29->4->5->8 */

		  
		 
	}

}
