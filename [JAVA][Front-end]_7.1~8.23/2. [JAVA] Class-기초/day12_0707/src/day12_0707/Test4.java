package day12_0707;

// "���" -> ����
// �θ�Ŭ����.����Ŭ����.���̽�Ŭ����
// �ڽ�Ŭ����.����Ŭ����.�Ļ� Ŭ����

// ��� ���迡��
// �������, �޼��� ��� ��Ӱ�����
// ����-> ������ �Ұ�
class Poket{
String name;
int level;
}
class Eve extends Poket{
	// �̺��� ��ü���� ���ϸ����̱��ϳ�,
	// �׵鸸�� ��Ư�� Ư¡�� �ִٰ��Ѵ�!
	String subName;
	int level;
	void hello() {
		System.out.println("����!"); // ��� �ڽ�Ŭ������ �λ�!
	}
}
class Eve2 extends Eve{
	// Poket�� -> Eve �� �ڽ�Ŭ���� 
}
class Pika extends Poket{
	// ��ī�� Ŭ������ ���ϸ��� Ŭ������
	// �ڽ� Ŭ�����Դϴ�.
	void play() {
		System.out.println("�鸸��Ʈ!"); // ��ī�� �鸸��Ʈ
	}
}
class Pai extends Poket{
	// �ڽ�Ŭ���� 2
}


public class Test4 {

	public static void main(String[] args) {
		
		Pika m1 = new Pika();
		Pai m2 = new Pai();
		
		Poket[] data = new Poket[2];
		// ��ī��, ���̸���, �ᱹ ���ϸ����� ���� Ŭ�����̱� ������
		// ���ϸ��� ��ü�迭�� ������ �����ϴ�!
		//  --> data[0] = new Pika();
		
		Eve m3 = new Eve(); 
		// ������ subName�� Eve�� ���������
		// �θ�Ŭ������ Ÿ ����Ŭ������ �ش� ������ ������.
		
		Poket p = new Poket();
		// �θ�Ŭ���� - ����Ŭ������ ��������� �Ⱥ��δ�.
		
		Eve2 e = new Eve2(); 
		//. ������ ������ ����Ŭ�������� ��� ����´� // ���ռ� ������

		m1.play();
		
		
		
	}// main����

}
