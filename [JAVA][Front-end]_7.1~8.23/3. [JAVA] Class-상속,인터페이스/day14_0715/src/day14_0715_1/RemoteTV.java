package day14_0715_1;
//serviceTV , useTV... 인터페이스는 보조 이름을 붙힌다
public interface RemoteTV { //인터페이스는 모든 메소드가 추상메소드이다.
	void soundUp();// 추상메서드
	public abstract void soundDown();
	// public, abstract이 생략되어있음!!!
	
	//{ 
//		System.out.println("소리++");
//	}
}
// public interface TV 
//	클래스가 아님 
//	인터페이스
//	 -> 객체를 생성xxx
//	 => public abstract이 모든 메서드에 붙는다!

// Q&A
//조금 헷갈려서 그런데요..! 인터페이스는 클래스들에게 "기능"을 부여해주기 위해 생성되는게 맞다라고 보면되나요?
// -> 네 정확합니다!