package day11_0706;

// ��ü�鳢�� ���� ���������ʴ� ������ -> ��ü����

// Ŭ��������
//  : ��ü�鳢�� ���� ���� ������ �� �ִ� �������
//  static + �ڷ���  + �������

// static 
// : "��ü�� �����ϰ�" -> static void f() {} �Լ��� ��������(��ü�� �����ϰ� ���ɰŴ�.)

class Game{
	Game(String name){
		this.name=name;
	}
	String name;
	static int sand = 100; // Ŭ�������� ����! == �� ��������
	// == �����ڿ�
	void play(int sand) {
		this.sand-=sand;
		if(this.sand<=0) {
			System.out.println(this.name+"��, ���ӿ���!");
		}
	}
}

class Car11{
	static int speed;
}



public class Test6 {

	public static void main(String[] args) {
		
		Car11 c1 = new Car11();
		Car11 c2 = new Car11();
		
		c1.speed+=10;
		System.out.println(c2.speed);
		// c1�� c2�� speed ���� �����Ѵ�!
		
		Game g1 = new Game("ȫ�浿");
		Game g2 = new Game("�ƹ���");
		Game g3 = new Game("����");
		
		g1.play(50);
		g2.play(25);
		g3.play(5);
		g1.play(30);
		
	}// main ����

}
