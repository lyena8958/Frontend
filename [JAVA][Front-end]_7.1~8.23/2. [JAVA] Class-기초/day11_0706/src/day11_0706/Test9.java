package day11_0706;

import java.util.Scanner;

// ����� ��
class Bomb3{
	Bomb3(String player){
		this.player = player;
	}
	static int bomb = 100;
	String player;
	boolean play(int bomb) {
		this.bomb-=bomb;
		if(this.bomb<=0) {
			System.out.println(this.player+"��, ���ӿ���!");
			return true;
		}
		return false; // ������ �ȳ���
	}
	
}

// ����
class Bomb{
	Bomb(String player){
		this.player = player;
	}
	Scanner sc = new Scanner(System.in);
	static int bomb = 100;
	String player;
	void play(int bomb) {
		System.out.println(bomb+" �Է�!!");
		this.bomb -= bomb;
		
		if(this.bomb<=0) {
			System.out.println(this.player+"�Բ��� �й��ϼ̽��ϴ�!!!");
			return;
			
		}
		
		}
	}
// ���� - ����
class Bomb2{
	Bomb2(String player1, String player2){
		this.player[0] = player1;
		this.player[1] = player2;
	}
	Scanner sc = new Scanner(System.in);
	static int bomb = 100;
	String[] player = new String[2];
	
	void play() {
	int playNum;
	int index = 0;
	while(true) {
		System.out.println(player[index]+"�� �����Դϴ�.\n"+"���� ���ڸ� �Է��ϼ��� ");
		playNum = sc.nextInt();
		this.bomb -= playNum;
		if(bomb <= 0) {
			System.out.println("��!!! "+player[index]+"�� �й�!!");
			break;
		}
		index = index==0 ? 1:0;
		
	}
}
}

public class Test9 {

	public static void main(String[] args) {
		/*
	  class Bomb{
      int bomb=100;
	  // �����ڿ�
	  String player;
	  boolean play(int bomb)
	   : �����ڿ��� 0���ϰ� �Ǹ� ���ӿ���!
	    ���ӿ����� ����̸� ������ּ���!~~
	    ���ӿ������Ǹ� true�� ����(��ȯ)
			}

		main(){
		   �迭�̿�xxx
	 	   �÷��̾ 2�� : �̸��� �ݵ�� �������ֵ���!
	       ���� ������ �Է¹޾Ƽ� ����
		  ���ӿ����� �ɶ����� ���}*/
		
		
		// ����
		Bomb u1 = new Bomb("Ǫ");
		Bomb u2 = new Bomb("�Ǳ۷�");
		
		u1.play(50);
		u2.play(10);
		u1.play(40);
		
		// ����2
		Bomb2 u3 = new Bomb2("����","����");
		
		u3.play();
		
		// �����
		Scanner sc = new Scanner(System.in);
		Bomb3 p1 = new Bomb3("ȫ�浿");
		Bomb3 p2 = new Bomb3("�ƹ���");
	
		while(true) {
			System.out.println("1. �Է�: ");
			int bomb = sc.nextInt();
			if(p1.play(bomb)) {
				break;
			}
			
			System.out.println("2. �Է�: ");
			bomb = sc.nextInt();
			if(p2.play(bomb)) {
				break;
			}
		}
		// ** ������ ������ bomb�� 100���� �ʱ�ȭ��������
		
		
		
	}

}
