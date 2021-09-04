package day14_0715_1;

import java.util.Random;
import java.util.Scanner;

// �����
abstract class Card2{ // �߻�Ŭ���� -> "��ü�����Ұ���"
	String name;
	int money;
	Card2(String name){
		this(name,0);
	}
	Card2(String name, int money){
		this.name = name;
		this.money = money;
	}
	void show() {
		System.out.println(this.name+"���� �ܾ���"+this.money+"���Դϴ�.");
	}
	abstract void pay(); // �߻�޼��� -> �������̵� ����
}
class CheckCard2 extends Card{
	// 1) �⺻������ ����
	// 2) �θ�Ŭ������ �⺻�����ڸ� ȣ��
	// 3) �θ�Ŭ������ �⺻�����ڰ� �����Ƿ�
	CheckCard2(String name, int money){
		super(name,money);
		System.out.println(this.name+"��, üũī�� ��ϿϷ�!");
	}
	void pay() {
		int money = 1000*(new Random().nextInt(9)+1); // 1000~9000
		System.out.println("�����Ͻ� �ݾ��� "+money+"�� �Դϴ�."); // �Լ��� ���� �Ӵϸ� �����.
		if(this.money<money) {
			System.out.println("�ܾ׺������� ��������!");
			return; // �Լ�����
		}
		this.money -= money;
		System.out.println("�����Ϸ�!");
	}
}
class CreditCard2 extends Card2{
	int sum;
	int limit;
	CreditCard2(String name, int limit) {
		this(name,0,limit); // ������ȣ��
	} // ������ �����ε�
	CreditCard2(String name,int money, int limit) {
		super(name,money);
		this.limit = limit;
		this.sum = 0;
		System.out.println(this.name+"��, �ſ�ī�� ��ϿϷ�!");
	}
	void pay() {
		int money = 1000*(new Random().nextInt(9)+1); // 1000~9000
		System.out.println("�����Ͻ� �ݾ��� "+money+"�� �Դϴ�."); 
		if(sum+money>limit) {
			System.out.println("�ѵ��ʰ��� ��������!");
			return;
		}
		sum+=money;
		System.out.println("�����Ϸ�!!");
	}
}
class BusCard2 extends Card2{

	int age;
	BusCard2(String name, int money) {
		this(name,money,20);
	}
	BusCard2(String name, int money, int age) {
		super(name, money);
		this.age =age;
		System.out.println(this.name+"��, ����ī�� ��ϿϷ�!");
	}
	@Override
	void pay() {
		int money = 0;
		if(9<=age&&age<20) {
			money = 1000;
		}
		else if(20<=age&&age<=65) {
			money = 2000;
		}
		if(this.money<money) {
			System.out.println("�ܾ׺������� ž�ºҰ�!");
			return;
		}
		System.out.println("�����մϴ�.");
		this.money -= money;
		
	}
	
}


// �����ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
//�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
abstract class Card{
	Scanner sc = new Scanner(System.in);
	Card(String name, int money){
		this.name = name;
		this.money = money;
	}
	String name;
	int money;
	void show() {
		System.out.println(this.name+"���� ī���ܾ��� "+this.money+"�� �Դϴ�.");
	}
	abstract void pay(); // �������̵��� �����Ǿ���ϴ� �޼���
	
}
class CheckCard extends Card {
	CheckCard(String name, int money) {
		super(name, money);
		System.out.println(this.name+"��, üũī�� ��ϿϷ�!");
	}

	void pay() {// ������ ���� // �ܾ��� 0�̸� xx // �ٷ� �ܾ��� --
		System.out.print(this.name+"��, ���� �ݾ��� �Է����ּ��� : ");
		int money = sc.nextInt();
		if (this.money < money) {
			System.out.println("[��������] �ܾ��� �����մϴ�.");
			return;// �Լ�����
		}
		System.out.println("[�����Ϸ�!] " + money + "�� ����");
		this.money -= money;
		System.out.println("�ܾ�: " + this.money + "\n");

	} 

}

class CreditCard extends Card {
	CreditCard(String name, int money, int limit) {
		super(name, money);
		this.limit = limit;
		System.out.println(this.name+"��, �ſ�ī�� ��ϿϷ�!");
	}
	
	int sum; // ī���� �����ݾ�
	int limit; // ���ѱݾ�(�ݵ�� �����Ҷ� �ʿ��Ѱ�)
	
	void pay() {// ������ �����ݾ� // �����ݾ�<=���ѱݾ�
		System.out.print(this.name+"��, ���� �ݾ��� �Է����ּ��� : ");
		int money = sc.nextInt();
		if (sum + money > limit) { // ���������ݾ��� �ѵ��ʰ��� �ȴٸ�
			System.out.println("[��������] �ѵ��� �ʰ��Ǿ� ���� �Ұ��մϴ�.");
			return; // �Լ�����
		}
		System.out.println("[�����Ϸ�!] " + money + "�� �����Ǿ����ϴ�.");
		this.sum += money;
		System.out.println("���� �����ݾ�: " + this.sum + "\n");
		System.out.println("�ܿ��ѵ�: " + (this.limit - this.sum));
	}
	void show() {
		System.out.println(this.name+"���� �����ݾ�: "+this.sum+"��\n"+"�ܿ� �ѵ�: "+this.limit);
	}
}
class BusCard extends Card {
	BusCard(String name, int money) {
		super(name, money);
		this.age = 20;
	}

	BusCard(String name, int money, int age) {
		super(name, money);
		while (true) {
			if (0 > age) {
				System.out.println("[���Է�] ���� ���Է��ϼ���");
				age= sc.nextInt();
				continue;
			}
			break;
		}
		this.age = age;
		System.out.println(this.name + "��, ����ī�� ��ϿϷ�!");
	}

	int age; // ���� ���̵����Ͱ����ٸ� ������ 20��

	void pay() { // ���̿� ���� ��������
		// 9~19 1000��
		// 20~65 2000��
		// ������ 0��
		int subMoney = 0; // ���������ݾ�
		if (9 <= age && age <= 19) {
			System.out.println("9��~19�� �ش�ǹǷ�, 1,000�� �����˴ϴ�.");
			subMoney = 1000;
		} else if (20 <= age && age <= 65) {
			System.out.println("20��~65�� �ش�ǹǷ�, 2,000�� �����˴ϴ�.");
			subMoney = 2000;
		} else {
			System.out.println("�����Դϴ�.");
			return;
		}
		if (subMoney > money) {
			System.out.println("[��������] �ܾ��� �����մϴ�.");
			return;
		}
		System.out.println("[�����Ϸ�] " + subMoney);
		money -= subMoney;
		System.out.println("���� �ܾ�: " + money + "\n");
	}
}

public class Test3 {

	public static void main(String[] args) {
		/* ����
		class Card{
		    String name;
		    int money;
		    void show()
		        ___���� ī�� �ܾ��� ____���Դϴ�.
		    void pay() << �������̵��� �����Ǿ���ϴ� �޼���
		}
		class CheckCard{
		    void pay()->�ٷ� �ܾ��� --
		    �ܾ��� 0�̸�xxx
		}
		class CreditCard{
		    int sum; // �����ݾ�
		    int limit; // ���ѱݾ�(�ݵ�� �����Ҷ� �ʿ��Ѱ�)
		    void pay()->������ ��������
		    �����ݾ�<=���ѱݾ�
		}
		class BusCard{
		    int age;(����, ���̵����Ͱ� ���ٸ� ������ 20��)
		    void pay()->���̿� ���� ��������
		    9~19 1000
		    20~65 2000
		    ������ 0
		}*/

		//����
		CheckCard c1 = new CheckCard("üũ",5000);
		CreditCard c2 = new CreditCard("�ſ�",5000, 15000);
		BusCard b1 = new BusCard("����", 2000, 20);
		
//		c1.pay();s
//		c1.pay();
//		c1.show();
//		c2.pay();
//		b1.pay();

		
		//�����
		// Card2 c1 = new Card("ȫ�浿", 10000) // xxx �߻�Ŭ���� > ���������� ��ü�����Ұ�
		/*
		CheckCard2 c2 = new CheckCard2("ȫ�浿", 10000);
		c2.pay();
		c2.pay();
		c2.pay();
		c2.show();*/
		
		CreditCard2 c3 = new CreditCard2("�ƹ���", 20000);
		c3.pay();
		c3.pay();
		c3.pay();
		c3.pay();
		c3.pay();
		
		BusCard2 c4 = new BusCard2("�Ƹ�",2500,19);
		c4.pay();
		c4.pay();
		c4.pay();
		c4.show();
		
	}//main����

}
