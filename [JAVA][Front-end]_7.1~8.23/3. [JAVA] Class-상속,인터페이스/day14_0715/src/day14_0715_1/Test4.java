package day14_0715_1;

// 인터페이스를 받을때에는 implements를 사용
class SamSungTV implements RemoteTV{

	// public 기본상태(디폴트) private
	//"자식의 공개범위는 부모의 공개범위와 같거나 넓어야한다." → 자식공개범위>=부모공개범위
	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		
	}
//	void soundUp() {
//		System.out.println("소리++");
//	}
//	void soundDown() {
//		System.out.println("소리--");
//	}
}
class LGTV implements RemoteTV{

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		
	}
//	void soundUp() {
//		System.out.println("소리++");
//	}
//	void soundDown() {
//		System.out.println("소리--");
//	}
}
// 같은 기능을 수행하는 메서드끼리
//서로 다른 클래스여도 메서드명을 일치시켜보자!
public class Test4 {

	public static void main(String[] args) {
		

	}

}
