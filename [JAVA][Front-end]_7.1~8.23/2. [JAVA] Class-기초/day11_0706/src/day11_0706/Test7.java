package day11_0706;

// �����ڿ� -> ��ȭ��, ������û

class Dog{
	Dog(String name){
		this.name=name;
	}
	String name;
	//��
	static String[] action = new String[3];
	// ���������� �����н��� ����
	static int index = 0; // �ε�����ȣ�� �����ؾ���
	// action�迭�� index�� �ǹ� //�� �����ڿ�
	void play(String str) {
		this.action[this.index++]=str; // this������ ��� ����
		// ���������ڴ� ���������ǹǷ� ��ó�� �ۼ��ص� �ȴ�.
		//index++;
	}
}

public class Test7 {

	public static void main(String[] args) {
		
		Dog d1 = new Dog("����");
		Dog d2 = new Dog("�Ƹ�");	
		Dog d3 = new Dog("����");
		System.out.println(d3.action[0]);
		d2.play("�ɾ�!");
		System.out.println(d1.action[0]);
		// ��> �����ڿ����� ���� �ٸ� ��ü�鵵 ���� ������ �ȴ�.
		
	}

}
