package day12_0707;

// "상속" -> 설계
// 부모클래스.상위클래스.베이스클래스
// 자식클래스.하위클래스.파생 클래스

// 상속 관계에서
// 멤버변수, 메서드 모두 상속가능함
// 하위-> 상위는 불가
class Poket{
String name;
int level;
}
class Eve extends Poket{
	// 이브이 객체들은 포켓몬스터이긴하나,
	// 그들만의 독특한 특징이 있다고한다!
	String subName;
	int level;
	void hello() {
		System.out.println("하이!"); // 모든 자식클래스는 인사!
	}
}
class Eve2 extends Eve{
	// Poket의 -> Eve 의 자식클래스 
}
class Pika extends Poket{
	// 피카츄 클래스는 포켓몬스터 클래스의
	// 자식 클래스입니다.
	void play() {
		System.out.println("백만볼트!"); // 피카츄만 백만볼트
	}
}
class Pai extends Poket{
	// 자식클래스 2
}


public class Test4 {

	public static void main(String[] args) {
		
		Pika m1 = new Pika();
		Pai m2 = new Pai();
		
		Poket[] data = new Poket[2];
		// 피카츄도, 파이리도, 결국 포켓몬스터의 하위 클래스이기 때문에
		// 포켓몬스터 객체배열에 저장이 가능하다!
		//  --> data[0] = new Pika();
		
		Eve m3 = new Eve(); 
		// 생성된 subName는 Eve의 멤버변수라서
		// 부모클래스나 타 하위클래스는 해당 변수를 못본다.
		
		Poket p = new Poket();
		// 부모클래스 - 하위클래스의 멤버변수는 안보인다.
		
		Eve2 e = new Eve2(); 
		//. 누르면 상위의 상위클래스까지 모두 갖고온다 // 대대손손 물려줌

		m1.play();
		
		
		
	}// main종료

}
