package day17_0720_2;

// 3�ڸ��� �ִµ� �������°��Ǹ�
// 5��  ������û �����Ҽ����ִ�.

class TiSys implements Runnable{
	Ticket t = new Ticket();
	
	@Override
	public void run() {
		t.buy();
	}
	
}
class Ticket{
	static int ticket = 2; // �����ڿ�
	//synchronized ->��ô�� ó��(����ȭó��!) -> ���������� Ƽ�ϵ��ÿ� �߱��� �Ǿ� Ƽ���� �����Ǿ �������ӽ� ���Ű��ȴ�..
	public synchronized void buy() {//�����ڿ��� �����ʾ� 3���� ���ÿ� Ƽ�����߱��Ҽ��ִ�.
		if(ticket>0) {           // ������ �� �������� �̸�
			System.out.println(Thread.currentThread().getName()+"Ƽ�Ϲ߱޼���!");
			ticket--;
		}
		else {
			System.out.println("Ƽ�Ͼ����ФФ�");
		}
		System.out.println("���� Ƽ�ϼ�: "+ticket);
	}
	
}
// [�����ڿ��� ����ȭ] �����ڿ�(�������� static(Ŭ��������)

// �����ڿ��� �ٷ궧 == � �����尡 �ڿ��� �����ϰ� ������
// �ٸ� �������� ������ ����, ������ ������ ���� �ؾ��Ѵ�. ->ex)������û
// == ����ȭ ó��

// "��������"(�����) �� ����Ű�� �ʰ� �ϴ� ���� �������ǿ���
//    -> �������� �����ִµ� �����뿡 ������ ����������


//�����ڿ� ����)
//class Game{
//	static int game = 100; // �����ڿ�==Ŭ��������
//	
//}
public class Test2 {

	public static void main(String[] args) {
		
		
		TiSys sys=new TiSys();
		//Ƽ���� 2���ε�, �����ϴ»���� 3��..!
		Thread t1 = new Thread(sys,"�ƹ���"); // �̸�-���������!
		Thread t2 = new Thread(sys,"�Ƹ�");
		Thread t3 = new Thread(sys,"Ƽ��");
		
		// 3���� ��ư�� ���ÿ� �����Ͱ� ����
		t1.start();
		t2.start();
		t3.start(); // Ƽ���� 0�ε��� ���Ű���..!
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
