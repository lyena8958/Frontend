package day17_0720_2;

import java.util.Scanner;
class MSys implements Runnable{
	Acoount2 a = new Acoount2();
	@Override
	public void run() {
		a.outMoney();
	}
	
}
// ����� ��
class Acoount2{
	static int money2=10000;
	public synchronized void outMoney() {//run���� ���� �Լ��̹Ƿ�, Ȥ�ó��ؼ� �������� �����ϰ�; ���������� �������
		if(money2<5000) { // currentThread : ���� �����ϰ��ִ� ������:t1...t2..
			System.out.println(Thread.currentThread().getName()+"�������!");
		}
		else {
			money2-=5000;
			for(int i = 0; i <3; i++) {
				System. out.print(". ");
				try {
					Thread.sleep(1000);//Ŭ�������� ���ȸ޼ҵ�
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("���⼺��!");
		}
	}
}
// ����
class Draw implements Runnable{
	Account person = new Account();
	
	public void run() {//������(start)�� ������ run()�� �ڵ� ȣ��ȴ�.
		person.pay();
	}
}
class Account{//������������
	static int money = 10000; // ����
	synchronized void pay() {
		System.out.println("�����ݾ��� �Է����ּ���.");	
		int money =new Scanner(System.in).nextInt();
		if(this.money<money) {
			System.out.println("[�����Ұ�] �ܾ��� �����մϴ�. �� �ܾ� : "+this.money);
			return;
		}
		this.money -= money;	
		System.out.println(Thread.currentThread().getName()+"��, "+"����: "+money+"�� �Ϸ�\n"+"�ܾ�:"+this.money);
	}
	
}
public class Test3 {

	public static void main(String[] args) {
		/*����
		  ����: 10000

		�ƹ���,�Ƹ�,Ƽ��
		�ѹ��� ������ �õ��Ҷ�,
		���� 5000���� �����������ߴ��� ������ּ���!~~
		+) . . . ���⼺��!*/
		
		MSys sys = new MSys();
		Thread t4 = new Thread(sys,"�ƹ���");
		Thread t5 = new Thread(sys,"�Ƹ�");
		Thread t6 = new Thread(sys,"Ƽ��");
		//[����]
		
		//[���]
		
		
		
		// [����] -> run()ȣ��// �׷��ϱ� �������� start�� ���� runȣ���̵ȴٴ°ǰ���?? yes
		// ������(start) -> run()�ڵ�ȣ��
		t4.start(); 
		t5.start();
		t6.start();
		//t6.run();		
		// start - ����Ŭ���ؼ� �ý����� ����Ѵٴ� �� -> ������ ����
		// run ������ �޼ҵ常 ���ٴ°�(���� - �׸��׸���, ��Ʈ ��! ���ڴ�)
		//		����� �޼ҵ尡 1���� �������� ������ �������� �ִٸ� ��������.
		
		
		//����
		/*
		Draw draw = new Draw();
		
		Thread t1 = new Thread(draw, "�达");
		Thread t2 = new Thread(draw, "�̾�");
		Thread t3 = new Thread(draw, "����");
		t1.start();
		t2.start();
		t3.start();*/
		
		
	}

}
