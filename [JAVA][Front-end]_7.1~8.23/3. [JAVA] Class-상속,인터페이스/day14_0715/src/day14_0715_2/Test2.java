package day14_0715_2;
interface useTV{
	public static final int maxSound=100;
	// 상수화 == final -> 초기화가 반드시 필요하다!
	int minSound=0; // pub~final가 숨겨져있다.
	void soundUp();
	public abstract void soundDown();  // 애도 pub~abs가숨겨져있다.
	void changeCH(); 
}
class TV implements useTV{

	// 상수화 == final
	// 정적변수(스테틱)
	//	static final String name;
	//	final int num;
	
	int sound;
	@Override
	public void soundUp() {
		sound += 10;
		if(sound>maxSound) {
			sound=maxSound;
		}
		
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeCH() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
