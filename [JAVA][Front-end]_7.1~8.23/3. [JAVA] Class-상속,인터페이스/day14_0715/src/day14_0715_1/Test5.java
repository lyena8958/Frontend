package day14_0715_1;

interface C{
	void f(); // �̹� �߻�޼ҵ��̴�.
}
class F{
	void show() {
		System.out.println("Ȯ��");
	}
	
}
abstract class A implements C{
	// �߻�޼��带 �������ֱ⶧���� 
	// "����"����� �ƴ�! (���� ���)
}
class B implements C{
	@Override
	public void f() { // �θ�Ŭ�������� ������ �аų� ���ƾ��ϱ⶧���� public�� �Ѵ�.(��ȣ������)
		// TODO Auto-generated method stub
		
	}
	
}
class D extends F implements C{
	public void f() { // �θ�Ŭ�������� ������ �аų� ���ƾ��ϱ⶧���� public�� �Ѵ�.(��ȣ������)
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
