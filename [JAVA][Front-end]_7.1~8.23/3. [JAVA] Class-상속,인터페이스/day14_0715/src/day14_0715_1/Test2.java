package day14_0715_1;

// ������ == ������� �ʱ�ȭ �Լ�==��üȭ ��� �Լ� -> �Լ�, input output ()
abstract class Shape{//�߻�Ŭ���� == �ؾƲ�� Ʋ
	// �߻�޼��带 ��������
	// �ش�Ŭ������ �ݵ�� �߻�Ŭ�������߸��Ѵ�!!!!
	
	// �߻�Ŭ����
	// : ��Ӱ��迡�� �ַ� ����Ŭ��������
	// : ��ü�� �����Ҽ�����! == �߻�Ŭ����:Ŭ����:��ü <> �ؾƲ�� Ʋ:�ؾƲ:�ؾ
	int point;
	int line;
	
	//�������� ������ ��ü�����̱�������, �ۼ��Ҽ��� �ִ�!
	// �ڽ�Ŭ�������� �θ�Ŭ������ �����ڸ� ������� ȣ��!!
	Shape(int point, int line){
		this.point = point;
		this.line = line;
	}
	
	// ���Ŭ����(�߻�Ŭ����)�� ��ӹ��� ��, ��Ʈ, ���̾Ƹ��...
	// ...�� ��ü���߿�
	// "���׸���"�� �ϴ� ��ü��?
	// => ����! -> abstract
	abstract void draw(); 
	// �߻�޼���: ���빰�� ����������!
	//{
	//	System.out.println("���׸���");
	//}
}
class Circle extends Shape{ // Ŭ����==�ؾƲ->�ؾ
	Circle(int point, int line) {
		super(point, line); // �̶�, 16�������� (�θ�)�����ڸ� �̿�!!!!!
		// TODO Auto-generated constructor stub
	}

	void draw() {
		System.out.println("���׸���");
	}
}
class Rect extends Shape{
	Rect(int point, int line) {
		super(point, line);
		// TODO Auto-generated constructor stub
	}

	void draw() {
		System.out.println("�׸�׸���");
	}
}
// �����е鲲�� ���࿡ �ڵ带 �ۼ��Ҷ�, Ŭ������ ctrl+C(����)�� �õ��ߴٸ�,
// ���踦 �ǽ��غ���!
class Tri extends Shape{
	Tri(int point, int line) {
		super(point, line);
		// TODO Auto-generated constructor stub
	}

	void draw() {
		System.out.println("����׸���");
	}
}

public class Test2 {

	public static void main(String[] args) {
//		
//		Circle c = new Circle();
//		c.draw();

		//Shape s = new Shape(); ����xxxx
		
	}

}
