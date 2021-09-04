package day10_0705;

class Circle{
	Circle(){ // 생성자 오버로딩(중복정의가 가능하다.)
		name="";
		radius=0;
		System.out.println("기본생성자 호출됨!");
	}
	// 생성자 오버로딩
	Circle(String s, int i){ // 생성자 정의(정의 했으니 이제 기본생성자가 아니다.)
		name = s;
		radius = i;
		System.out.println("생성자 호출됨!");
	}
	String name; // null : 주소의 부재 == 메모리주소없음을 의미
	// String은 주소를 기억하니까 -> null로 나온다.
	int radius; // 반지름
	void show() {
		System.out.println(name+"의 반지름은"+radius);
	}
}
public class CircleTest {

	public static void main(String[] args) {
		
		// 클래스 객체명 생성자함수(클래스와 이름동일)
		// Circle c1 Circle
		Circle c1 = new Circle("도넛", 1); 
		Circle c2 = new Circle();
		// "기본생성자"
		// 생성자가 1개도 없을때, 기본제공된다.
		// 즉, 다른생성자가 1개이상 정의되면 제공되지않는다!
		
		c1.show(); 
		c2.show();
		
		//System.out.println(c1.name+"의 반지름은"+c1.radius);
		//System.out.println(c2.name+"의 반지름은"+c2.radius);
		// -> 함수 show로 코드 요약
		
		c1.name ="도넛"; // . : 멤버접근 연산자
		c1.radius= 1;
		
		c2.name="피자";
		c2.radius=20;
		
		c1.show(); // null의 반지름은 0
		c2.show();

		
	} // main 종료

}
