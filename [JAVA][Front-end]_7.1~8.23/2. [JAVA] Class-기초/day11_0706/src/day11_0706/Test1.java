package day11_0706;

// �ڡڡ��������� ȿ�������ڡڡ� -> Ư�� ����� �ݺ�������(��ȸ���� �ƴ�) ����ϸ�, �޼���ȭ! - �ڵ� ���뼺�� ������Ű�°�.
// �ڡڡ��ڵ尡���� ȿ�������ڡڡ�
class Circle{ // ������ ���ǰ� 1���̻� ������, �⺻�����ڴ� ��������. (����ߴ� �⺻������ ��ü�� ���������.)
	// 16�� 23����  ������ �ΰ��� ���� �� ������??? -> �ִ�!!!
	Circle(){ 
		this("����", 1); // �ݵ�� �� ù�ٿ� ��ġ�ؾ���!!!!!
		// �� 13�� ������ ȣ���Ұ�-> ���� 2���� ������ -> this.Circle("����", 1); -> ��? -> this
		//this�� ���
		// 1) . ��������� ����
		// 2) () �����ڸ� ȣ�� -> �ڱ� �ڽ� ������ �θ��� this() ��ȣ�� ����.
		// ���> ������� . // ������ ()
		System.out.println("�⺻������ȣ���");
	}
//	Circle(){
//		// ��԰� ������ �Է� ���ߴ�..! �׷��� �������� ���� �� ���~!
//		//System.out.println("�⺻������ ȣ���");
//		this.name="����";
//		this.radius=1;
//		this.area=this.radius*this.radius*3.14;
//	}
	Circle(String name, int radius){ // ���ڿ� �ٸ� �ܾ �Է��ϸ� �򰥸��ϱ� �Ȱ��� �Է�!!
		// ���� �̰��� �� �־�ߵ�. �ϸ� ���ڸ� �ִ´�.
		//System.out.println("������ ȣ���");
		this.name=name;
		this.radius=radius;
		//this.area = this.radius*this.radius*3.14;
		  // area������ �ߺ��̾��� this�� �Ƚᵵ�ǳ�, �������� ���°� ���� (��ü�� ����Ű�� �����̸� ����)
		// -> 
		this.getArea();
		System.out.println("������ȣ���");
	}
	
	String name;
	int radius;
	double area; // �ٲܿ����� ��
	// area = radius * radius * 3.14 �ϸ� radius�� 0�̱⶧���� �ǹ� ����
	void show() { // �޼ҵ�
		// Circle(Ŭ����)�� ����� �� �ִ� �Լ��̱� ������ static ���xx 
		System.out.println(name+"��(��) ���̰�"+area+"�Դϴ�.");
	}
	String show2() { // �޼ҵ�
		return name+"��(��) ���̰�"+area+"�Դϴ�."; 
	}
	void changeRadius(int radius) {
		this.radius=radius;
		//this.area = this.radius*this.radius*3.14;
		 // -> ���
		this.getArea();
		System.out.println("������ ����!");
	}
	void getArea() { // ���� ���̸� ���ϴ� �޼ҵ�
		this.area = this.radius*this.radius*3.14; // ���� ���� �İ� �����ϰ� ��������
		// return this.radius*this.radius*3.14; -> double �޼ҵ���
		
	}
}
// �Լ� -����, ������- ������

public class Test1 {

	public static void main(String[] args) {
		

		Circle c1 = new Circle();
		//���ڰ� ���� Ŭ������ �����ڰ� �ڹٿ��� �⺻���� �����ȴ�.
		
		//��������� ���޾� ������ �ȵȴ�. (1������ ����) -> �� �̻��� �޼ҵ�� ������
		c1.name="����"; // ������� �� ����
		//c1.radius=10; // �̸����ٲ�� ���������� �ȹٲ��.
		//c1.changeRadius(10); //changeRadius ����ϸ� �ٲ� �� �ִ�.
		c1.show(); 
		 //System.out.println(c1); // day11_0706.Circle@7852e922
		 // �ּҰ� ���´�.
		 // int[] arr = new int[3], syso(arr) == �����°Ժ���ϴ�.
		
		 //System.out.println(c1.show()); ���� -> show������ ��±���� �־ �ߺ� �ȵ�
		 //System.out.println(c1.show2()); // ���� ����Ϸ��� �ش� �����ִ� �޼ҵ��!
		System.out.println();
		
		Circle c2 = new Circle("����", 20);
		c2.changeRadius(1);
		c2.show();
		
	} // main����

}
