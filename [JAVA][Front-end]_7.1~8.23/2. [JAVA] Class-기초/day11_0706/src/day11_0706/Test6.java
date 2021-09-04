package day11_0706;

// 객체들끼리 값이 공유되지않는 변수는 -> 객체변수

// 클래스변수
//  : 객체들끼리 서로 값을 공유할 수 있는 멤버변수
//  static + 자료형  + 멤버변수

// static 
// : "객체와 무관하게" -> static void f() {} 함수와 같은개념(객체와 무관하게 사용될거다.)

class Game{
	Game(String name){
		this.name=name;
	}
	String name;
	static int sand = 100; // 클래스변수 생성! == 값 공유상태
	// == 공유자원
	void play(int sand) {
		this.sand-=sand;
		if(this.sand<=0) {
			System.out.println(this.name+"님, 게임오버!");
		}
	}
}

class Car11{
	static int speed;
}



public class Test6 {

	public static void main(String[] args) {
		
		Car11 c1 = new Car11();
		Car11 c2 = new Car11();
		
		c1.speed+=10;
		System.out.println(c2.speed);
		// c1과 c2의 speed 값을 공유한다!
		
		Game g1 = new Game("홍길동");
		Game g2 = new Game("아무무");
		Game g3 = new Game("나르");
		
		g1.play(50);
		g2.play(25);
		g3.play(5);
		g1.play(30);
		
	}// main 종료

}
