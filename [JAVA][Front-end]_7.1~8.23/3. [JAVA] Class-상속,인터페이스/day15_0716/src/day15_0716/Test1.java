package day15_0716;

class Car {
	String name;
	int speed;
	int maxSpeed;

	Car(String name) {
		this(name, 60); // 2
		// System.out.println("a");//4
	}

	Car(String name, int maxSpeed) { // 3(12~16)
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.speed = 0;
		System.out.println("�ڵ��������Ϸ�!");
	}

	public String toString() {// public -> �θ��� �������� �ڽ��� ������ ���ų� Ŀ���ؼ�
		// �����ε�(���x) vs �������̵�(���o)
		return "Car [name=" + name + ", speed=" + speed + ", maxSpeed=" + maxSpeed + "]";
	}

}

public class Test1 {

	public static void main(String[] args) {
	
		Car car = new Car("ȫ�浿"); // 1
		System.out.println(car);
		//��µǴ�����?? 
		// 1) Object(�ֻ���Ŭ����)
		// 2) .toStrong() �ڵ�ȣ��
		
		
		
	}//main����
}
