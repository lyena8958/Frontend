package day11_0706;

class Car{
	// ������(�Լ��� �� ����)
	// �������� ��Ư�� Ư¡ 3!
	// 1) ��ü�� �����Ҷ� ����ϰ�,
	// 2) Ŭ������ �̸��� ���� �Լ�(�޼��� == �Լ�)
	// 3) ��ȯ�Ǵ� ���� ��ü�̱⶧���� ����Ÿ�Ը��xxx
	// �� ������ �� ���� �Լ��� Ư¡�� ���󰣴�.
	Car(){
		this("����", 20); // 13�� �޼ҵ� ��Ȱ���ؼ�, ������������ ���ش� // == Car(name...speed)  // this() ������ ȣ��
	}
	Car(String name, int maxspeed){ // String n , int m
		this.name = name; // name = n;
		this.maxSpeed=maxspeed; // maxSpeed=m;
		this.speed = 0; // ��� ���ǻ� ( ������ ) this // ex) ���ڰ��������� - ���̾Ƚᵵ�Ǵ� ���� �̸��� ��
	}
	String name;
	int speed;
	int maxSpeed;
	void show() {
		System.out.println(this.name+"�� ����ӵ�: "+this.speed);
	}
}

public class Test2 {
	public static void main(String[] args) {
		
		Car car = new Car("ȫ�浿", 60); // ����2��->�޼ҵ�(����2��)�� �θ�
		car.show(); 
		// �⺻������: null�� ����ӵ�: 0 
		// ���ǻ�����: ȫ�浿�� ����ӵ�: 0
		// car.name or Car(name);
	
		Car car2 = new Car(); // == Car("����", 20)
		// == �⺻, ����Ʈ �����ڴ� �⺻,����Ʈ���� �����ϴ� ����!
		car2.show();
		
		/* ���� �������
		21 
		23->7 (���� 2�� �޼ҵ�)
		24->15

		29->4->5->8 */

		  
		 
	}

}
