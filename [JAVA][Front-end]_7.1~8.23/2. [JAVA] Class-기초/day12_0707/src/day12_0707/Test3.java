package day12_0707;

import java.util.Scanner;

//�����
class Player{
	Player(String name){
		this.name=name;
		System.out.println(this.name+"��,  �����Ϸ�!");
	}
	String name;
	static int sand=100; // �����ڿ�==Ŭ��������
	boolean game() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է�: ");
		int sand=sc.nextInt();
		this.sand -= sand;
		if(this.sand<=0) {
			return true;
		}
		return false;
	}
}

//����
class SandGame{
	SandGame(String name){
		this.name = name;
	}
	Scanner sc = new Scanner(System.in);
	String name;
	static int sand = 100;
	
	Boolean game() {
		int ansSub; // ���� �Է°�
		System.out.println(this.name+"�� �𷡸� ��ŭ �����ðڽ��ϱ�? ");
		ansSub = sc.nextInt();
		sand -= ansSub;
		if(sand<=0) {
			return true;
		}
	System.out.println("��!...");
	return false;
}
}

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*1. �÷��̾��� ���� �Է�: 5
		2. �÷��̾�
		   -�̸�
		   -�����ڿ�(100��������)
		   -boolean game( )
		       1) �󸶳� �������� �Է��ϼ���.
		       2) �����ڿ�--
		       3) false / ���ӿ��� true ��ȯ
		3. main()������ ���ӿ����� ���ö����� ��� ����
		4. ���� ���ӿ������� ������ּ���!~~*/
		
		
	// �����
		System.out.println("�÷��̾� �� �Է�: ");
		int num = sc.nextInt();
		Player[] data = new Player[num];
		for(int i= 0; i < data.length;i++) {
			System.out.println("�÷��̾� �̸��Է�: ");
			String name = sc.next();
			data[i] = new Player(name);
		}
		
		int index = 0;
		while(true) {
			if(data[index].game()) {
				System.out.println("���� ��!  "+data[index].name+"�� ����!");
				break;
			}
			index++;
			if(index==data.length) {
				index=0;
			}
		}
		
		
		
	// ����
		//�̸��� �����ڿ�
		
		System.out.println("�÷��̾��� ���� �Է��ϼ���. ");
		int people = sc.nextInt();
		
		// �÷��̾� �迭 
		SandGame[] user = new SandGame[people];
		
		// ������ �Է�(�ʱ�ȭ)
		for(int i = 0; i < user.length;i++) {
			System.out.print((i+1)+"��° ���� �̸��� �Է�: ");
			String name = sc.next();
			user[i] = new SandGame(name);
		}
		
	for(int i = 0;; i++) {
		i = i==people? 0: i; // �ε��� �ʱ�ȭ
		if(user[i].game()) {
			System.out.println("\n��������..... �𷡼��� ���������ϴ�.");
			System.out.println(user[i].name+"��.....  GAME OVER!!!!\n\n");	
			break;
		}		
	}
	System.out.println("\n���α׷��� ����˴ϴ�.\n\n");
		
} // main ����
}
