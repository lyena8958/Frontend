package day11_0706;

// �����
class Account2{
	Account2(String card){
		this.card = card;
	}
	String card;
	static int money=75000;
	void pay(int money) {
/*1*/		if (this.money<money){//üũ�ϰ� �����ϴ� ���� ������ ����
			System.out.println("�ܾ׺���!");
			return;
		}
		this.money-=money;
//2		if(this.money<0) {
//			System.out.println("�ܾ׺���!");
//			this.money+=money;
//		}
	}
	void show() {
		System.out.println(this.card+"ī�� �ܾ� "+this.money+"���Դϴ�.");
	}
}


class Account{
	Account(String card){
		this.card = card;
	}
	String card; // �ſ�,üũ,����ī��
	static int money = 5000; // �����ڿ�
	static int index;
	
	void pay(int money) {
		if(this.money < money) {
			System.out.println("[ERROR-�ܾ׺���] ���� �ݾ�: "+this.money);
			return;
		}
		this.money-=money;
	}
	void show() {
		System.out.println(this.card+"ī�� �ܾ�"+this.money+"�� �Դϴ�.");
	}
	void newCard(String card) {
		this.card = card;
	}
	
}

public class Test8 {

	public static void main(String[] args) {
/*		���� ����
		class Account
		 -String card
		 -int money(�����ڿ�)
		 void pay(int money)
		   : money��ŭ ������ �����
		   ����, �������� �����ȵ�
		 void show()
		   : ����ī�� �ܾ� _____���Դϴ�.*/

		// ����� 
		Account2 c1 = new Account2("�ſ�");
		Account2 c2 = new Account2("����");
		c1.show();
		c2.pay(1000);
		c2.pay(1000);
		c1.show();
		
		System.out.println();
		
		// ����
		Account c3 = new Account("����");
		Account c4 = new Account("�ſ�");
		c3.show();
		c3.pay(5000);
		c4.show();
		
		
	}

}
