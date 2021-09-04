package day11_0706_2;

import java.util.Scanner;

class Card{
	// ���������� ���� ���´�(private�� ���ͼ��͸� ��������ν�)
	// ���ʿ��� ����, �Ǽ� ���� ���̴� ����
	Card(String name){
		this(name,1234,0);
	}
	Card(String name, int passwd){
		this(name,passwd,0);
	}
	Card(String name, int passwd, int money){
		this.name = name;
		this.passwd=passwd;
		this.money =money;
	}
	private String name;
	private	int passwd;
	private	int money;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPasswd() {
		return passwd;
	}
	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}

public class Test3 {

	public static void main(String[] args) {

		Card card= new Card("�ƹ���", 5678);
		System.out.println(card.getName());
		
		card.setPasswd(8765); // ��й�ȣ�� �ٲٰ������
		System.out.println(card.getPasswd());
		/*
	main()�Լ��� �ڵ����ּ���!~~

	1. ���� ���� card ��ü��
	������̸�+�ܾ� ������ּ���!~~

	2. ��й�ȣ�� �����ϰ�;��.
	 1) ���� ��й�ȣ�� �Է�: ****
	 2-1)  ��й�ȣ ����ġ!
	 2-2)  �� ��й�ȣ�� �Է�: 
		 ����Ϸ�!

	3. �����õ�
     1) 100,000���̻��̸� ��й�ȣ�� Ȯ��,
	 2) ����ġ! / ��������!
	    �ܾ׺���! / �����Ϸ�!*/
		Scanner sc = new Scanner(System.in);
		
		// ����� ��!!
		Card card3 = new Card("�Ƹ�",1111,200000);
		System.out.println(card3.getName()+"/"+card3.getMoney());
		
		System.out.println("���� ��й�ȣ �Է�: ");
		int passwd = sc.nextInt();
		if(card3.getPasswd()==passwd) {
			System.out.println("�� ��й�ȣ�� �Է�: ");
			passwd=sc.nextInt();
			card.setPasswd(passwd);
		}
		else {
			System.out.println("��й�ȣ ����ġ!");
		}
		
	      System.out.print("�����ݾ� �Է�: ");
	      int money2=sc.nextInt();
	      if(money2>=100000) {
	         System.out.print("��й�ȣ �Է�: ");
	         passwd=sc.nextInt();
	         if(card3.getPasswd()==passwd) {
	            if(card3.getMoney()<money2) {
	               System.out.println("�ܾ׺���!");
	            }
	            else {
	               System.out.println("�����Ϸ�!");
	               card3.setMoney(card.getMoney()-money2);
	            }
	         }
	         else {
	            System.out.println("��й�ȣ ����ġ!");
	         }
	      }
	      else {
	         if(card3.getMoney()<money2) {
	            System.out.println("�ܾ׺���!");
	         }
	         else {
	            System.out.println("�����Ϸ�!");
	            card3.setMoney(card3.getMoney()-money2);
	         }
	      }

		
		
		
		//����		
		//1��
		Card card2 = new Card("�̿���",6666,200000);
		System.out.println("�����: "+card2.getName()+"  �ܾ�: "+card2.getMoney()+"��"); // 1��
		
		System.out.println();
		
		//2��
		System.out.println("���� ��й�ȣ�� �Է�: ");
		int pw = sc.nextInt();
		
		if(pw==card2.getPasswd()) {
			System.out.println("�� ��й�ȣ�� �Է�: ");
			card2.setPasswd(sc.nextInt());
			System.out.println(card2.getPasswd()+"�� ����Ϸ�!!");
		}
		else {
			System.out.println("[ERROR] ��й�ȣ ����ġ ����Ұ�");
		}
		
		System.out.println();
		
		//3��
		System.out.println("������ �ݾ��� �Է��ϼ��� ");
		int money = sc.nextInt();
		if(money >= 100000) {
			System.out.println("10���� �̻� �����ݾ��� ������ ����\n"+"��й�ȣ�� Ȯ���ϰ� �ֽ��ϴ�. 4�ڸ��� �Է����ּ���.");
			pw = sc.nextInt();
			if(pw==card2.getPasswd()) {
				if(card2.getMoney()<money) {
					System.out.println("[ERROR] �ܾ׺���!! ������ ��� �˴ϴ�.");
				}
				else {
					card2.setMoney(card2.getMoney()-money);
				System.out.println("�����Ϸ�!!  "+"�ܾ�: "+card2.getMoney()+"��");
				}
			}
			else {
				System.out.println("[ERROR] �н����� ����ġ! ��������");
			}
		}
		else {
			if(card2.getMoney()<money) {
				System.out.println("[ERROR] �ܾ׺���!! ������ ��� �˴ϴ�.");
			}
			else {
				card2.setMoney(card2.getMoney()-money);
			System.out.println("�����Ϸ�!!  "+"�ܾ�: "+card2.getMoney()+"��");
			}
			
		}
		
		
	
	}

}
