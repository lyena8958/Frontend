package day09_0702;

//*�������� �ڵ�ȭ�� ��
public class test13 {

	// ����� ���� �Լ�
	// �Լ��� �ߺ����Ǹ� ����غ���!!!!!!
	//   ����: ���� �˰���(����), ���
	//		: input,�Ű�����,������ ����/�ڷ����� �ٸ��ų�,
	//		: output, return,��ȯ���� �ڷ����� �ٸ���
	// �Լ��� �ߺ����� ���!!!!!
	// == "�����ε�" �ڡ١ڡ� (.print�ϸ� -> ���� �Լ��� �¸��� �����µ� �װ� ����)
	
	static int func(int a, int b) {
		System.out.println("�Լ�1");
	// static : ���α׷���������~ (�Ⱥ��̸� ��ü�� �����Ͽ� �Լ�������)
		return a+b; // �������
	}
	// "��ȣ���� �߻��Ǹ� ����!"
	static int func(int a, int b,int c) {
		System.out.println("�Լ�2");
	// static : ���α׷���������~ (�Ⱥ��̸� ��ü�� �����Ͽ� �Լ�������)
		return a+b+c; // �������
	}
	
	static double func(double a, double b) {
		System.out.println("�Լ�3");
		return a+b;
	}
	
	static double func(double a, double b,double c) {
		System.out.println("�Լ�4");
		return a+b+c;
	}
	
	public static void main(String[] args) {
		
		int x = 10;
		int y = 20;
		int z = 30;
		System.out.println(func(x,y,z));
		

		
		
	}

}//*//
