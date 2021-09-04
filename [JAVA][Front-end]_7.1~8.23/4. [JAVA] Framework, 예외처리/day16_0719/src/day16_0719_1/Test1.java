package day16_0719_1;

import java.util.Random;

// extends implements
// 상속(부모클래스, 추상클래스)
// vs 인터페이스(->협업시 메서드들의 가이드라인, 객체가 가져야하는 메서드를 강제하는 용도)

// 공격 성공, 실패 -> 랜덤
// 포켓몬의 울음소리가 출력
interface C{
	void game();
	void sound();
	}

abstract class A implements C {
	String name;
	int level;
	int exp;
	A(int level){
		// 생성자: 객체화를  담당하는 메서드
		//		멤버변수를 초기화하는 작업
		this.level = level;
		this.exp = 0;
		// name은 하위클래스에서 초기화할 예정!
	}
	public void game() {
		if(new Random().nextBoolean()) {
			this.exp++;
			System.out.println("게임성공!");
		}
		else {
			System.out.println("게임실패!");
		}
	}
	// 하위클래스에서 오버라이딩(==메서드 재정의)을 강제해야함!
	public abstract void sound() ;
}
class B extends A{
	B(int level) {
		super(level);
		this.name = "피카츄";
	}

	@Override
	public void sound() {
		this.game();
		System.out.println("피카피카");
		
	}
	
}
public class Test1 {

	public static void main(String[] args) {
		
		/*
		 * 포켓몬
	이름
	레벨
	경험치
	게임()

	피카츄, 파이리, 꼬부기
	울음소리()
		 */
		
		

	}// main종료
}
