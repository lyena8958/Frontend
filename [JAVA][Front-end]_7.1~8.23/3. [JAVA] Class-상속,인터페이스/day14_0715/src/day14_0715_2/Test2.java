package day14_0715_2;
interface useTV{
	public static final int maxSound=100;
	// ���ȭ == final -> �ʱ�ȭ�� �ݵ�� �ʿ��ϴ�!
	int minSound=0; // pub~final�� �������ִ�.
	void soundUp();
	public abstract void soundDown();  // �ֵ� pub~abs���������ִ�.
	void changeCH(); 
}
class TV implements useTV{

	// ���ȭ == final
	// ��������(����ƽ)
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
