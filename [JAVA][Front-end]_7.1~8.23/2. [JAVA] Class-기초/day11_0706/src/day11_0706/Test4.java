package day11_0706;

import java.util.Scanner;

// �����
class Animal2{
	Animal2(String type, String name){
		this.type=type;
		this.name=name;
	}
	String type;
	String name;
	void show() {
		System.out.println(this.type+" �̸��� "+this.name+"�Դϴ�! :D");
	}
	void play() {
		if(this.type.equals("������")) {
			System.out.println("��å");
		}
		else if(this.type.equals("�����")) {
			System.out.println("��ɳ���");
		}
		else if(this.type.equals("����Ǳ�")) {
			System.out.println("���ٵ�,,");
		}
		else {
			System.out.println("�ش����");
		}
	
	
	
	}
	
	
}


// ����
class Animal{
	Scanner sc = new Scanner(System.in);
	Animal(){
		this.ans();
	}
	
	String type; // ����� ������
	String name;
	// �ݷ������� ������ type, name�� �� �ʿ��ϴ�.
	// Scanner�� ����Ͽ� console���� �Է����ּ���
	void show() {
		System.out.println(this.type+" �̸��� "+name+"�Դϴ�! :D");
	}
	void play() {
		// ������-��å, �����-��ɳ���, ����Ǳ�- ���ٵ�... -> ������ �ش����
		if(this.type.equals("������")) {
			System.out.println(name+"(��)�� �� ��å�մϴ�!");
		}
		else if(this.type.equals("�����")) {
			System.out.println(name+"��(��) ��ɳ��̸� �մϴ�!");
		}
		else if(this.type.equals("����Ǳ�")) {
			System.out.println(name+"�� ���ٵ���ϴ�!");
		}
		else {
			System.out.println("�ش����");
		}
	}
	void ans() {
		System.out.print("�ݷ����� Ÿ���� �Է����ּ���(������, �����, ����Ǳ�): ");
		this.type = type = sc.next();
		System.out.print("�ش� �ݷ������� �̸��� �Է����ּ��� ");
		this.name = name = sc.next();
	}
}

public class Test4 {

	public static void main(String[] args) {
		
		/*����
		Animal amal1 = new Animal(); // ������ ����
		amal1.show(); 
		amal1.play();*/
		
		
		// �����
		Scanner sc = new Scanner(System.in);
		System.out.println("����: ");
		String type=sc.next();
		System.out.println("�̸�: ");
		String name=sc.next();
		Animal2 a = new Animal2(type,name);
		a.show();
		a.play();
		
	}

}
