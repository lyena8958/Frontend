package day12_0707;

class Po{
	String name;
	int level;
	String type;
	void play() {
		System.out.println("����");
	}
	void show() {
		System.out.println("���Ҽ�����");
	}
}
class Water extends Po{ // �� �Ӽ�
	Water(){
		this.type="�� �Ӽ�";
	}
	void play() { // �Ӽ������� ���ݸ޼���� �����ǵ�! == �������̵�
		System.out.println("������");
	}
}
class Fire extends Po{ // �� �Ӽ�
	Fire(){
		this.type = "�� �Ӽ�";
	}
	void play() {
		System.out.println("�Ҳ�!");
	}
	void play(int level) { // ���� Ŭ�������� �����ǵ�! == �����ε�  == ���ڰ� �޶����
		System.out.println("+++");
	}
}	
class Pa extends Fire{ // �� �Ӽ��� ���̸�
	Pa(){
		this.name = "���̸�";
	}
	void show() { // ���ϸ� ���� ���ϴ� ��Ʈ�� �����ǵȴ�! == �������̵� == ���ڿ� ����Ÿ���� ���ƾ���
		System.out.println("��~~~~~~");
	}
}
class Ggo extends Water{ // �� �Ӽ��� ���α�
	Ggo(){
		this.name = "���α�";
	}
	void show() { // ���ϸ� ���� ���ϴ� ��Ʈ�� �����ǵȴ�! == �������̵�
		System.out.println("���ϲ���");
	}
}
	
	public class Test8 {


	public static void main(String[] args) {


	}

}
