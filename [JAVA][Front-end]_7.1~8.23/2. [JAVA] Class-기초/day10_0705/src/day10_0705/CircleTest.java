package day10_0705;

class Circle{
	Circle(){ // ������ �����ε�(�ߺ����ǰ� �����ϴ�.)
		name="";
		radius=0;
		System.out.println("�⺻������ ȣ���!");
	}
	// ������ �����ε�
	Circle(String s, int i){ // ������ ����(���� ������ ���� �⺻�����ڰ� �ƴϴ�.)
		name = s;
		radius = i;
		System.out.println("������ ȣ���!");
	}
	String name; // null : �ּ��� ���� == �޸��ּҾ����� �ǹ�
	// String�� �ּҸ� ����ϴϱ� -> null�� ���´�.
	int radius; // ������
	void show() {
		System.out.println(name+"�� ��������"+radius);
	}
}
public class CircleTest {

	public static void main(String[] args) {
		
		// Ŭ���� ��ü�� �������Լ�(Ŭ������ �̸�����)
		// Circle c1 Circle
		Circle c1 = new Circle("����", 1); 
		Circle c2 = new Circle();
		// "�⺻������"
		// �����ڰ� 1���� ������, �⺻�����ȴ�.
		// ��, �ٸ������ڰ� 1���̻� ���ǵǸ� ���������ʴ´�!
		
		c1.show(); 
		c2.show();
		
		//System.out.println(c1.name+"�� ��������"+c1.radius);
		//System.out.println(c2.name+"�� ��������"+c2.radius);
		// -> �Լ� show�� �ڵ� ���
		
		c1.name ="����"; // . : ������� ������
		c1.radius= 1;
		
		c2.name="����";
		c2.radius=20;
		
		c1.show(); // null�� �������� 0
		c2.show();

		
	} // main ����

}
