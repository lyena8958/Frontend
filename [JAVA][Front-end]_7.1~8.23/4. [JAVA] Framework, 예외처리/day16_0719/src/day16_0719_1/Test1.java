package day16_0719_1;

import java.util.Random;

// extends implements
// ���(�θ�Ŭ����, �߻�Ŭ����)
// vs �������̽�(->������ �޼������ ���̵����, ��ü�� �������ϴ� �޼��带 �����ϴ� �뵵)

// ���� ����, ���� -> ����
// ���ϸ��� �����Ҹ��� ���
interface C{
	void game();
	void sound();
	}

abstract class A implements C {
	String name;
	int level;
	int exp;
	A(int level){
		// ������: ��üȭ��  ����ϴ� �޼���
		//		��������� �ʱ�ȭ�ϴ� �۾�
		this.level = level;
		this.exp = 0;
		// name�� ����Ŭ�������� �ʱ�ȭ�� ����!
	}
	public void game() {
		if(new Random().nextBoolean()) {
			this.exp++;
			System.out.println("���Ӽ���!");
		}
		else {
			System.out.println("���ӽ���!");
		}
	}
	// ����Ŭ�������� �������̵�(==�޼��� ������)�� �����ؾ���!
	public abstract void sound() ;
}
class B extends A{
	B(int level) {
		super(level);
		this.name = "��ī��";
	}

	@Override
	public void sound() {
		this.game();
		System.out.println("��ī��ī");
		
	}
	
}
public class Test1 {

	public static void main(String[] args) {
		
		/*
		 * ���ϸ�
	�̸�
	����
	����ġ
	����()

	��ī��, ���̸�, ���α�
	�����Ҹ�()
		 */
		
		

	}// main����
}
