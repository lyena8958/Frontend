package day14_0715_1;

interface C{
	void f(); // 이미 추상메소드이다.
}
class F{
	void show() {
		System.out.println("확인");
	}
	
}
abstract class A implements C{
	// 추상메서드를 가질수있기때문에 
	// "강제"대상이 아님! (선택 대상)
}
class B implements C{
	@Override
	public void f() { // 부모클래스보다 범위가 넓거나 같아야하기때문에 public로 한다.(모호성때문)
		// TODO Auto-generated method stub
		
	}
	
}
class D extends F implements C{
	public void f() { // 부모클래스보다 범위가 넓거나 같아야하기때문에 public로 한다.(모호성때문)
		// TODO Auto-generated method stub
		
	}
	
}

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		D d = new D();
		d.show();
	}

}
