package day10_0705;

import java.util.Scanner;

class Car3{
	Car3(String name){ // ����� �̸��� ���ʿ��ϴ��ϸ� ������ ����! == ���ڴ� name
		// user=user; // ���ڸ� ����� ���� ������ ������ �������µ�. ���������ٲ��.
		this.name=name; // this == �ڱ��ڽŰ�ü (�����Ͱ���)
		speed =0; // ������ ���ڿ� ��� this �Ƚᵵ�ȴ�.(�ߺ�����������.)
	}
	String name; 
	int speed; 
	void speedUp() { 
	
		System.out.println("�ӵ� ��");
		speed+=10;
	}
	void speedDown() { // "
		System.out.println("�ӵ� �ٿ�");
		speed-=10;
	}
}

// �ڵ����� ����� ���� ���� ����
// class �ȿ� ������ ������ ����������.
class Car{ 
	// �⺻������ ���� 
	Car(){ // �ڸ���Ÿ�� ��þ���! - ��ü�� �����ϴ°� Ȯ���̱� ������ output��� ���ԡ�
		System.out.println("�⺻������ ȣ���!");
		speed = 100; // ������� �ʱ�ȭ�� ������ ������!
		// ���ڰ� ���� ������ == �⺻������ == ����Ʈ������
		// �⺻�����ڴ� "�⺻�������ش�!"
	}
	String name; // �������==�Ӽ�==�ʵ�
	int speed; // ��������� ���� Ÿ ��ü�� �������� �ʴ´�!!!!!!! == ��ü����(�߾Ⱥθ�)
	void speedUp() { // ��ǲ�ƿ�ǲ ���� // static xxxxx
	// ����������Լ��� ���̴� static�� ����. ��󸶴� �����ִ� �޼ҵ尡 �������־.
	// ��ü�� �־
		System.out.println("�ӵ� ��");
		speed+=10;
	}
	void speedDown() { // "
		System.out.println("�ӵ� �ٿ�");
		speed-=10;
	}
}
// ������� = �Ķ���!, �������� = ����!
// �Լ������� static�� �ش� Ŭ������ ����ϴ� �Լ��ϱ� ��������ʴ´�.

// �⺻������ �⺻���� ���
class Car2{ 
	String name; // �������==�Ӽ�==�ʵ�
	int speed; // ��������� ���� �������� �ʴ´�!!!!!!! == ��ü����(�߾Ⱥθ�)
	void speedUp() { // ��ǲ�ƿ�ǲ ���� // static xxxxx
	// ����������Լ��� ���̴� static�� ����. ��󸶴� �����ִ� �޼ҵ尡 �������־.
	// ��ü�� �־
		System.out.println("�ӵ� ��");
		speed+=10;
	}
	void speedDown() { // "
		System.out.println("�ӵ� �ٿ�");
		speed-=10;
	}
}


public class CarTest {
	public static void main(String[] args) {
		String name; 
		// �������� : �Լ� ���ο� ����Ǵ� ����
		// �����ֱ� == �Լ�����(main)
		boolean power;
		int speed;
		
		Scanner sc = new Scanner(System.in);
		//�� ������ ���� 
		Car    car = new Car(); // ���Ἥ �ڵ��ʱ�ȭ 0
		Car	   car2= new Car();
		// Car Ŭ������	car��� ��üȭ,�ν��Ͻ�ȭ .. car2
		
		// car.�ϸ� ����� ������-> Object�� �ڹٿ��� ������ ���, Car��� �Ǿ��ִ°� �츮�� ���� ���
		System.out.println(car.speed); // 100
		System.out.println(car2.speed); // 100
		car.speedUp(); 
		car2.speedDown(); 
		// ��������� ������ ���� �ʴ´�.
		
		System.out.println(car.speed); // 110
		System.out.println(car2.speed); //90
		
		//==================================== �����ڱ���
		System.out.println();
		
		//�� ������ x(java �⺻������ Ʋ)
		Car2    car3 = new Car2(); // ���Ἥ �ڵ��ʱ�ȭ 0
		Car2    car4 = new Car2();
		
		System.out.println(car3.speed); // 0
		System.out.println(car4.speed); // 0
		car3.speedUp(); 
		car4.speedDown(); 
		
		System.out.println(car3.speed); // 10
		System.out.println(car4.speed); //-10
		
		//==================================== ��������� �� Ŭ���� 
		// Scanner sc = new Scanner(); // �����ڰ� 1���̻� ���ǰ� �Ǿ� �־� ���ڰ��� �־�� �Ѵ�.
		Car3 car5 = new Car3("ȫ�浿");
		
		
		
	} // main����

}
