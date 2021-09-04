package day11_0706_2;

// "���� ����" - private, getter setter, public
// ����������==����������==������
// private : ���� �ڱ��ڽ� ���ο����� ������ �����ϵ��� ���� (�ܺο����� ���� ��ü�� �𸥴�.)
// �ش� Ŭ���� �ܺο����� ������ �Ұ����ϱ� ������,
// ������ �����ִ� �޼������ �ʿ��ϴ�!
// �̸� ��getter, setter�� ��� �θ���!
// getter: private �Ǿ��ִ� ���� �޾ƿ��� �޼��� // ���ھ���
// setter: private �Ǿ��ִ� ������ ���� �ִ� �޼��� // �����ְ�
// == (�����ǹ�)�������� == ĸ��ȭ

// ���ۿ����� ���� �� private�� �ɷ��ִ�!!

// public: �ܺ� ��Ű�������� ������ �����ϵ��� ����

// default : �⺻��
// ���������� ������ �ǹ��ϸ�, �ش� ��Ű������ ���ٰ����� ����
class Account{
	private String name; // �ܺ����ٸ���
	private int money; // ������� == �Ӽ� == �ʵ�
	// getter
	String getName(){ // getXxx() // ���ϰ��� ���� �ڷ��� ����
		return this.name;
	}
	int getMoney() {
		return this.money;
	}
	// setter
	void setName(String name){ // setXxx()
		this.name=name;
	}
	void setMoney(int money){
		this.money=money;
	}
	
	Account(String name){
		this(name,0);
	}
	Account(String name, int money){
		this.money = money;
		this.name=name;
	}
	void pay(int money) {
		if(this.money<money) {
			System.out.println("�ܾ׺���!");
			return;
		}
		this.money-=money;
		System.out.println("�����Ϸ�!");
	}
	
}

public class Test1 {

	public static void main(String[] args) {

		Account a1 = new Account("�ƹ���", 30000);
		//a1.money -= 30000; //����������
		//a1.name = "ȫ�浿";
		// a1. �ϸ� money�� �߳�, �����տ� private�� �޸� �Ⱥ��δ�.
		// �ִµ� �𸣴°� �ƴ϶�, �ƿ��𸣴°�(�������)
		
		a1.pay(9000);
		
		

	}

}
