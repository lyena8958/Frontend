package day12_0707;
/* ����!!
class Calc{
   Calc(){
      this.name="�Ϲ� ����";
   }
   String name;
   void func(int a,int b) {
      System.out.println(a+"+"+b+"="+(a+b));
   }
   // �Ϲݰ���� ����2���� ���� ���
   // ����3���� �յ� ����Ҽ��ֵ��� "�����ε�"���ּ���!~~
}
class GongCalc{ // ���п����� �Ϲݰ����� ����� ��ΰ�����,
   // �߰���
   // ���� 2���� �Է����ָ�
   // a~b���� �����ְ� -1
   // �װ͵��� ���� ����ϴ� -2
   // ����� �������ϴ�! => funcPlus   
}
public class Test3 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }

}*/

// �����
class Calc2{
	Calc2(){
		this.name="�Ϲ� ����";
	}
	String name;
	void func(int a, int b) {
		System.out.println(a+" + "+b+" = "+(a+b));
	}
	void func(int a, int b, int c) {
		System.out.println(a+" + "+b+" + "+c+" = "+(a+b+c));
	}
}
class GongCalc2 extends Calc2{
	GongCalc2(){
		// super(); -> ������!!!!!!
		this.name = "���п� ����";
	}
	// ���� �������ϰ��������? ��� (1) -> �������̵�(�ڽĿ��� ������ �� ���)
	void func(int a, int b) {
		System.out.println(a+b);
	}
	// ���� �������ϰ��������? ��� (2) -> �������̵�
	void func(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	void funcPlus(int a, int b) {
		if(a>b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int sum= 0;
		for(int i = a; i <= b; i++) {
			System.out.print(i+" ");
			sum += i;
		}
		System.out.println();
		System.out.println("���� "+sum+"�Դϴ�.");
	}
	
}

// ����
class Calc{
	Calc(){
		this.name="�Ϲ� ����";
	}
	String name;
	void func(int a, int b) {
		System.out.println(a+" + "+b+" = "+(a+b));
	}
	void func(int a, int b, int c) {
	// �Ϲݰ���� ����2���� ���� ���
	// ����3���� �յ� ����� �� �ֵ��� "�����ε�"���ּ���
		System.out.println(a+" + "+b+" + "+c+" = "+(a+b+c));
	}
}
class GongCalc extends Calc { // ���п����� �Ϲݰ����� ����� ��ΰ�����,
	GongCalc(){
	this.name = "���п� ����";
		}
	// �߰���
	// ���� 2���� �Է����ָ� 
	// a~b���� �����ְ� > 1
	// �װ͵��� ���� ����ϴ� > 2
	// ����� �������ϴ�! => funcPlus
	void funcPlus(int a, int b){
		System.out.println("\n"+a+"�� "+b+"�� �Է��ϼ̽��ϴ�.");
		if(a>b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int sum = 0;
		System.out.print("[ ");
		for(int i = a; i <= b;i++) {
			System.out.print(i+" ");
			sum += i;
		}
		System.out.println("]");
		System.out.println("�� ��: "+sum);
	} // �޼��� ����
	
}

public class Test7 {

	public static void main(String[] args) {
		
		
		// ����
		GongCalc c1 = new GongCalc();
		
		c1.func(5, 6);
		c1.func(1, 1, 5);
		
		c1.funcPlus(15, 2);
		

	}

}
