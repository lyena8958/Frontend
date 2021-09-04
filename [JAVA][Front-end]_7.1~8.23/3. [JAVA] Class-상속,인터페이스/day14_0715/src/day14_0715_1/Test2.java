package day14_0715_1;

// 생성자 == 멤버변수 초기화 함수==객체화 담당 함수 -> 함수, input output ()
abstract class Shape{//추상클래스 == 붕어빵틀의 틀
	// 추상메서드를 가지려면
	// 해당클래스는 반드시 추상클래스여야만한다!!!!
	
	// 추상클래스
	// : 상속관계에서 주로 상위클래스개념
	// : 객체를 생성할수없다! == 추상클래스:클래스:객체 <> 붕어빵틀의 틀:붕어빵틀:붕어빵
	int point;
	int line;
	
	//생성자의 역할이 객체생성이긴하지만, 작성할수는 있다!
	// 자식클래스에서 부모클래스의 생성자를 가장먼저 호출!!
	Shape(int point, int line){
		this.point = point;
		this.line = line;
	}
	
	// 모양클래스(추상클래스)를 상속받은 별, 하트, 다이아몬드...
	// ...의 객체들중에
	// "모양그리기"를 하는 객체는?
	// => 없다! -> abstract
	abstract void draw(); 
	// 추상메서드: 내용물을 가질수없다!
	//{
	//	System.out.println("모양그리기");
	//}
}
class Circle extends Shape{ // 클래스==붕어빵틀->붕어빵
	Circle(int point, int line) {
		super(point, line); // 이때, 16번라인의 (부모)생성자를 이용!!!!!
		// TODO Auto-generated constructor stub
	}

	void draw() {
		System.out.println("원그리기");
	}
}
class Rect extends Shape{
	Rect(int point, int line) {
		super(point, line);
		// TODO Auto-generated constructor stub
	}

	void draw() {
		System.out.println("네모그리기");
	}
}
// 여러분들께서 만약에 코드를 작성할때, 클래스를 ctrl+C(복사)를 시도했다면,
// 설계를 의심해보자!
class Tri extends Shape{
	Tri(int point, int line) {
		super(point, line);
		// TODO Auto-generated constructor stub
	}

	void draw() {
		System.out.println("세모그리기");
	}
}

public class Test2 {

	public static void main(String[] args) {
//		
//		Circle c = new Circle();
//		c.draw();

		//Shape s = new Shape(); 오류xxxx
		
	}

}
