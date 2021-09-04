package day14_0715_1;

import java.util.Scanner;

// 1) ���->���� ����(==���Ǵܰ�)
// 2) �������, �޼��� ����(����)
// 3) ������ ����
abstract class Phone{ //class Phone{ 
	String name; // �̸�
	String num; // ��ȭ��ȣ
	String[][] data; // ��ȭ��ȣ��(�̸�,��ȭ��ȣ)
	int index; // ��ȭ��ȣ�ο� ���� ����� �������� ����(�����)
	Phone(String name, String num){
		this.name = name;
		this.num = num;
		this.data = new String[2][3]; // 3���� �̸��� ��ȭ��ȣ(2�� 5��)
		this.index=0;
	}
	void play() {
		System.out.println("�������");
	}
	abstract void call();
//	void call() { // ����Ʈ�� ȣ��
//		System.out.println("����Ʈ�� ȣ��");
//	}
//	void addData() { // �����
//		// �����Է�
//	}
	void addData(String name, String num) { // �����
		// �����Ͱ��� �����Ǿ��ֱ⶧����, ũ�⸦ ������� �����!!!!!!
		if(data[0].length ==index) {
			System.out.println("�޸𸮺���!");
			return;
		}
		
		// ...���ڷ� ���� �޾ƿ�
		// �ߺ��Է°��� ���ڷ� ������ �޼��� �������
		
		// �� �κп��� �ߺ�üũ�� �����ҿ���!
		// �ߺ�üũ�� ����� �����͸��� ���尡���� �������̴�!!!
		for(int i =0; i<index; i++) {
			// ���� �����͸� 2�� �߰��Ͽ� index==2�� ��Ȳ(����)
			// ���� �˻��� �������� ������ 2��(0, 1)
			// i = 0, i = 1 �� 2�� �˻��Ѵ�!
			if(name.equals(data[0][i])) {
				System.out.println("�̸��ߺ�");
				return; //�޼��� �������(�Լ������ϴ� ���)
			}
			else if(num.equals(data[1][i])) {
				System.out.println("��ȣ�ߺ�");
				return; //(�޼��� �������(�Լ������ϴ� ���)
			}
		}
		
		// ��ȭ��ȣ�ο� �������� ������ �����ϴ� ���
		// 1) null�϶����� ��� 
		// 2) ������ �����ϴ� ������ �ʿ�
		data[0][index]= name;
		data[1][index]= num;
		index++; // index�� 0-> 1
		System.out.println("����Ϸ�!");
		for(int i = 0; i < index; i++) {
			System.out.println((i+1)+". "+data[0][i]+" "+data[1][i]);
		}
	}
	void DataAdd() { //����
		Scanner sc = new Scanner(System.in);
		int i = 0; 
		while(true) {
			System.out.println("��ȭ��ȣ�θ� �߰��Ͻðڽ��ϱ�? ��: 1��, ����: 2��");
			int ans = sc.nextInt();
			if (ans == 1) {
				while (i<3) {
					Boolean flag = false; // ���ϰ��ִ�������
					System.out.println((i+1)+"�� �̸��� �Է����ּ���. ");
					String name = sc.next();
					System.out.println((i+1)+"�� ��ȭ��ȣ�� �Է����ּ���.(\"-\" ǥ��)");
					String num = sc.next();
					for (int j = i; j >= 0; j--) {
						if (name.equals(this.data[0][j])|| num.equals(this.data[1][j])) {
							flag = true;
							break;
						}
					} // for ����
					if(flag) {
						System.out.println("���� �����Ͱ� �־� ������ �Ұ��մϴ�. �ٽ� �Է����ּ���.\n");
						continue;
					}
						System.out.println("�Է¿Ϸ�!! "+name+" "+num);
						this.data[0][i] = name;
						this.data[1][i] = num;
						i++;
						System.out.println();
				}
				System.out.println("�ִ� ���尪 �ʰ��� ��ȭ��ȣ �ΰ� ����˴ϴ�.");
			}
			else if(ans == 2) {
				System.out.println("����˴ϴ�!");
				break;
			}
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.(1~2��)");
			}
		}
	}

}
class Galaxy extends Phone{
	Galaxy(String name, String num) {
		super(name, num);
		System.out.println(this.name+"��, ������ ��ϿϷ�!");
	}
	// �������̵��� �ؾ��ϴ� ��Ȳ(ȣ��->�򽺺�)
	// ���������ʰ�����!
	void call() { 
		System.out.println("���� �򽺺�~");
	}
}

class IPhone extends Phone {
	IPhone(String name, String num) {
		super(name, num);
		System.out.println(this.name + "��, ������ ��ϿϷ�!");
	}
	// �������̵�
	void call() {
		System.out.println("�ø���!~~");
	}
}

public class Test1 {
static int NumCheck(int a, int b, int num) {
	/* !!!!!!!!!!!!!!����!!!!!!!!!!!!!!!!
	1. ������ ����
	2. ������ ����

	"��"�� ��ȭ��ȣ�ο� ����� �߰��Ҽ��ֽ��ϴ�!
	����� ���� �����Ǿ��ִ�.
	�̸��̳� ��ȣ�� �ߺ��Ǿ� ��������ʵ��� ���ּ���!~~
	 -> ��� �߰� (�޼��� ����)

	1,2�� ��ü�� �̿��Ͽ� ��ȭ��ȣ�θ� ������ּ���!~~ */ 
	Scanner sc = new Scanner(System.in);
	while(true) {
		if(num<a || b< num) {
			System.out.println("���Է�: "+a+"�̻� "+b+"���Ϸ� �Է����ּ���.");
			num = sc.nextInt();
			continue;
		}
		break;
	}
	return num;
}
	public static void main(String[] args) {
		Galaxy g1 = new Galaxy("Ǫ��", "010-3333-6666");
		IPhone i1 = new IPhone("����", "010-7777-7777");
		
		g1.call();
		i1.call();
		g1.DataAdd();
		System.out.println(g1.data[0][0]+" "+g1.data[1][0]);
		g1.DataAdd();
//		for(String[][] v: data) {
//			System.out.print(v+" ");
//		}
		
		//�����
		IPhone phone = new IPhone("�̸�","010-1111-1111");
		// ����ڵ��� �Ϲ� Phone ��ü����
		// IPhone, Galaxy�� �� �̿��Ѵ�. -> Phone call�� ����� �ʿ䰡 ����.
		
	      IPhone iPhone=new IPhone("�ƹ���","010-1234-1234");
	      iPhone.addData("�Ƹ�","010-1234-5678");
	      iPhone.addData("Ƽ��","010-1234-9876");
	      iPhone.addData("����","010-4321-9876");
	      iPhone.addData("����","010-1111-9876");
	      

	}

}
