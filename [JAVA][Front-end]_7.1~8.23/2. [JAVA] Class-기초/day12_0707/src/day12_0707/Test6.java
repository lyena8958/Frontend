package day12_0707;

// ����� ��

// 1. ���� ������ ���� �޼�������� ����
// 2. ����� �۾��� �����Ѵٸ�, ���� Ŭ�������� �Ѱ��ش�.
// 3. ����Ŭ������ ������ �״�� ����ȴ�..... << ������ �߰�!

class Pokemon{
	Pokemon(int level){
		this.level=level;
	}
	String name;
	int level;
	void show() {
		System.out.println(this.name+"  Lv."+this.level);
	}
	void game() { // �ڵ� ���뼺�� ����
		System.out.println("����!"); // ���� �����𸣴� �ϴ� ����
	}
}
class Pika3 extends Pokemon{
	// �⺻������
	// �θ��� �⺻�����ڸ� ȣ����... -> �⺻�����ڰ� ���ٸ� -> �װŴ�� �������!
	Pika3(int level){
		super(level);
		this.name="��ī��";
	}
	
	// ���� Ŭ������ �޼��� ������
	// ���� Ŭ�������� "������" �Ҽ�����!!!!! (1)
	// �ڿ������̵��� ��
	void game() {
		System.out.println("�鸸��Ʈ!");
	}
	// 1)�����ε� VS 2)�������̵�
	// 1) �Լ��� �ߺ�����
	//	    ��Ӱ���xxx
	//    � �Լ��� ������ ����, Ÿ�� or ����Ÿ���� �ٸ��ٸ�
	//	  (�ٵ� ����� ����)
	//    ������ ������ �� �ִ�!!
	// 2) �Լ� ������
	//    ��Ӱ���o
	//    � �޼����� ����� �������ϰ� ������ ���
    //    ������ ����, Ÿ�� and ����Ÿ�� ��� ���ƾ���
	// 	  == �޼��� �ñ״�ó�� �����ؾ���
}
class Pai3 extends Pokemon{
	Pai3(){
		super(5);
		// ����, ������̸����� Lv.5�� ��Ȳ�̶��
		// ���� ���� �ۼ��Ҽ����ִ�!!
		this.name="���̸�";
	}
	// �θ��� �޼��带 ������(2)
	void game() {
		System.out.println("�Ҳ�!");
	}
	
}
class Eve extends Pokemon{
	   Eve(int level) {
	      super(level);
	      this.name="�̺���";
	   }
	   
	}


// ����
class Poket2{
	Poket2(int level){
		this.level=level;
	}
	String name;
	int level;
	
	void show() {
		System.out.println(this.name+"  Lv."+this.level);
	}
	
}
class Pika2 extends Poket2{
	Pika2(int level){// �θ�Ŭ���� ������case1
		super(level);
		this.name="��ī��";
	}
	
	void play() {
		System.out.println("�鸸��Ʈ!!!!");
	}
}
class Pai2 extends Poket2{
	Pai2(int level){// �θ�Ŭ���� ������case2
		super(level);
		this.name = "���̸�";
	}
	void game() {
		System.out.println("�Ҳ�!!!!");
	}
}

public class Test6 {

	public static void main(String[] args) {
		/* ����!!!
		class Poket
		   -String name
		   -int level // ������ �� �޾ƾ��Ѵ�
		   -void show()
		   : ��ī�� Lv.6
		 Poket(int level)
		        

		class Pika
		    -void play()
		             : �鸸��Ʈ
		"��ī��"

		class Pai
		    -void game()
		             : �Ҳ�!!!
		"���̸�"*/
		
		Pika3 p1 = new Pika3(10);
		Pai3 p2 = new Pai3();
		p1.show();
		p2.show();
		p1.game();
		p2.game();
		
		Eve p3 = new Eve(1);
		p3.game();
		
		Pokemon[] data = new Pokemon[2];
		data[0] = new Pika3(10);
		data[1] = new Pai3();
		//�ٻ���Ŭ������ ����Ŭ���� ������ �����Ѵٸ�,
		// ��������� �����ϰ� 
		// ����Ŭ������ ������� �̿��Ҽ� ����! --> ���߿� ������ �˷��� ����
		data[0].game();//[�������ε�] 
		data[1].game();//����� �ȴ�! �޼ҵ� �������̵�
		
		System.out.println();
		
		//����
		Pika2 pk1 = new Pika2(10); // ��ī�� Ŭ���� ����
		Pai2 pi1 = new Pai2(7); // ���̸� Ŭ���� ����
		
		pk1.show();
		pk1.play();
		
		pi1.show();
		pi1.game();
		
	} // main ����

}
