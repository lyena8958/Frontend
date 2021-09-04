package day12_0707;

// 강사님 답

// 1. 같은 로직은 같은 메서드명으로 정의
// 2. 공통된 작업을 수행한다면, 상위 클래스에게 넘겨준다.
// 3. 상위클래스의 내용이 그대로 노출된다..... << 문제점 발견!

class Pokemon{
	Pokemon(int level){
		this.level=level;
	}
	String name;
	int level;
	void show() {
		System.out.println(this.name+"  Lv."+this.level);
	}
	void game() { // 코드 재사용성을 증가
		System.out.println("공격!"); // 누가 쓸지모르니 일단 공격
	}
}
class Pika3 extends Pokemon{
	// 기본생성자
	// 부모의 기본생성자를 호출중... -> 기본생성자가 없다면 -> 그거대로 따라야함!
	Pika3(int level){
		super(level);
		this.name="피카츄";
	}
	
	// 상위 클래스의 메서드 내용을
	// 하위 클래스에서 "재정의" 할수있음!!!!! (1)
	// ★오버라이딩★ ↑
	void game() {
		System.out.println("백만볼트!");
	}
	// 1)오버로딩 VS 2)오버라이딩
	// 1) 함수명 중복정의
	//	    상속관계xxx
	//    어떤 함수가 인자의 개수, 타입 or 리턴타입이 다르다면
	//	  (근데 기능은 같음)
	//    여러개 정의할 수 있다!!
	// 2) 함수 재정의
	//    상속관계o
	//    어떤 메서드의 기능을 재정의하고 싶을때 사용
    //    인자의 개수, 타입 and 리턴타입 모두 같아야함
	// 	  == 메서드 시그니처가 동일해야함
}
class Pai3 extends Pokemon{
	Pai3(){
		super(5);
		// 만약, 모든파이리들이 Lv.5인 상황이라면
		// 위와 같이 작성할수도있다!!
		this.name="파이리";
	}
	// 부모의 메서드를 재정의(2)
	void game() {
		System.out.println("불꽃!");
	}
	
}
class Eve extends Pokemon{
	   Eve(int level) {
	      super(level);
	      this.name="이브이";
	   }
	   
	}


// 예나
class Poket2{
	Poket2(int level){
		this.level=level;
	}
	String name;
	int level;
	
	void show() {
		System.out.println(this.name+"  Lv."+this.level);
	}
	
}
class Pika2 extends Poket2{
	Pika2(int level){// 부모클래스 생산자case1
		super(level);
		this.name="피카츄";
	}
	
	void play() {
		System.out.println("백만볼트!!!!");
	}
}
class Pai2 extends Poket2{
	Pai2(int level){// 부모클래스 생산자case2
		super(level);
		this.name = "파이리";
	}
	void game() {
		System.out.println("불꽃!!!!");
	}
}

public class Test6 {

	public static void main(String[] args) {
		/* 문제!!!
		class Poket
		   -String name
		   -int level // 레벨을 꼭 받아야한다
		   -void show()
		   : 피카츄 Lv.6
		 Poket(int level)
		        

		class Pika
		    -void play()
		             : 백만볼트
		"피카츄"

		class Pai
		    -void game()
		             : 불꽃!!!
		"파이리"*/
		
		Pika3 p1 = new Pika3(10);
		Pai3 p2 = new Pai3();
		p1.show();
		p2.show();
		p1.game();
		p2.game();
		
		Eve p3 = new Eve(1);
		p3.game();
		
		Pokemon[] data = new Pokemon[2];
		data[0] = new Pika3(10);
		data[1] = new Pai3();
		//☆상위클래스로 하위클래스 내용을 저장한다면,
		// 저장까지만 가능하고 
		// 하위클래스의 멤버들을 이용할순 없다! --> 나중에 세세히 알려줄 예정
		data[0].game();//[동적바인딩] 
		data[1].game();//현재는 된다! 메소드 오버라이딩
		
		System.out.println();
		
		//예나
		Pika2 pk1 = new Pika2(10); // 피카츄 클래스 생성
		Pai2 pi1 = new Pai2(7); // 파이리 클래스 생성
		
		pk1.show();
		pk1.play();
		
		pi1.show();
		pi1.game();
		
	} // main 종료

}
