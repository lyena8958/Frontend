package day21_0726;

// ������, ����ó��, GUI, ���������, MVC
// �������� ��ɾ���� �ܵ����� �����ʴ´�.
class Th1 extends Thread{
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("Ŭ����������");
		}
	}
}
// ��Ӻ��� ���ø������� �� ���� ���ȴ�.
class Th2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
				System.out.println("�������̽�������");
		}
	}
	
}
class TiSys implements Runnable{
	Ticket t = new Ticket();
	@Override
	public void run() {
		t.buy();
	}
	
}
class Ticket{
	static int ticket=1; // �����ڿ�->���常 �ִ�!
	public synchronized void buy() {
		//synchronized � �����尡 ������ �ٸ� �����尡 �������� ���ϰ� ����
		if(ticket>0) {
			System.out.println("Ƽ�Ϲ߱�");
			ticket--;
		}
		else {
			System.out.println("Ƽ�ϱ��Ž���");
		}
		System.out.println("���� Ƽ�ϼ�: "+ticket);
	}
}
public class Test3 {

	public static void main(String[] args) {
		
		// ����
		// � ���α׷��� ���� �������� �𸣱� ������ �׻� ����ϰ� �־�� �Ѵ�. == ������
/*
		// ������ ����(1)
		// thread ����(���)
		Th1 t1 = new Th1();
		
		// ������ ����(2)		--> ���̾�
		// thread imp-> ��������� ���� �޼��常 �����Ǿ��ִ�.	
		Th2 t2 = new Th2();
		Thread t3 = new Thread(t2);
		
		// �켱�����ο� -> �������� ���� ����(����.. �������� �ƴ�)
		//�ú���
		t1.setPriority(10);
		
		// GUI���� ����Ŭ�� �ѰͰ� ����.
		// Ŭ���� ������� ���´�.
		t1.start();
		t3.start();*/
		
		
		//������ ���µ� ���·� �����뿡 ������ ����߿� �־� ���Ű� �Ұ��մϴ�. -> ����ȭ
		
		TiSys sys = new TiSys();
		
		Thread t1 = new Thread(sys);
		Thread t2 = new Thread(sys);
		Thread t3 = new Thread(sys);
		
		// ��ΰ� ���Ÿ� �ϰԵǴ»�Ȳ -> ����� �ɾ���Ѵ�.(synchronized)
		t1.start();
		t2.start();
		t3.start();
		
		
	}//main����

}
