/*
���Ǳ� ���α׷�
�޴��� + ����
 -> Ŭ����(class) 
class Menu{
	String name;
	int price;
	void show(){ // ����μ� �޼��带 �ۼ��Ҽ�����!
		syso();

	}
	void changeName(){
		������ �̸���?
		- 
	}

}
*/
package day13_0714;

import java.util.Scanner;

class Point{
	int x;
	int y;
	Point(){
		this(0,0); // �ؿ� ������ ȣ��
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	void show() {
		System.out.println("("+this.x+", "+this.y+")");
	}
	void movePoint() {
		this.x++;
		this.y++;
	}
	void movePoint(int x) {
		this.x += x;
		this.y += y;
	}
	void movePoint(int x, int y) {
		this.x+=x;
		this.y+=y;
	}
	
}
// �����
class ColorPoint2 extends Point{
	// �θ�Ŭ���� ������x -> �⺻�����ڰ� �����ǰ�����
	// �� �⺻�����ڿ����� �θ��� �����ڸ� ȣ���ϴ� ��
	
	private String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	ColorPoint2(String color, int x, int y){
		super(x, y);
		this.color = color;
	}
	// �Լ� ������ == �������̵�
	void show() {
		System.out.println(this.color+"("+this.x+", "+this.y+")");
	}

}

// ���� Ǯ��
class ColorPoint extends Point{
	ColorPoint(String color){
		super();
		this.color = color;
	}
	ColorPoint(String color, int x, int y){
		super(x, y);
		this.color = color;
	}
	
	String color;
	void movePoint(){
		this.x++;
		this.y++;
	}
	void movePoint(int a){
		this.x += a;
		this.y += a;
	}
	void movePoint(int x, int y){
		this.x += x;
		this.y += y;
	}
	void show() {
		System.out.println(this.color+"("+this.x+", "+this.y+")");
	}
	
}
public class Test8 {

	//static
	// ��ü�� ���� �Լ��� ���� == static
	// "��ü�� �����ϰ�", "���α׷� ��������" -> ���α׷��� ���ſ���(�Ⱦ��°� ����)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	/*	Point p1 = new Point();
		p1.show();

		Point p2 = new Point(11,20);
		p2.show();
		
		
		Point[] data = new Point[5]; // �迭�� ������� ����
		
		for(int i = 0; i < data.length; i++) {
			data[i] = new Point(i+1,i+1);
		}
		for(Point v: data) {
			// System.out.print(v); �ּ� ���� ����
			v.show();
		}*/
		
		/*�����ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
		Test2�� ���� �ڵ����ּ���!~~

		Point�� ��ӹ޴� ColorPoint Ŭ������ �ִ�.
		 - String color
		 - show() ȣ��������,
		   ����(10,10) �̶�� ��µ�
		 - ������ �ܺο��� �����Ҽ��������ϴ�.(����������)

		�߰���, ��� ������(������ ����)
		"�̵�"�Ҽ��ְԵ�
		 movePoint() -> x++, y++
		 movePoint(10) -> x+=10, y+=10
		 movePoint(1,2) -> x+=1, y+=2*/
		
		// �����
		ColorPoint2 cp1=new ColorPoint2("����",10,20);
		cp1.movePoint(2);
		cp1.show();
		
		// ����
		ColorPoint[] c1 = new ColorPoint[3];
		
		c1[0] = new ColorPoint("����",10,1);
		c1[1] = new ColorPoint("��Ȳ");
		c1[2] = new ColorPoint("��ũ", 5, 5);
		
		c1[0].show();
		c1[1].show();
		c1[2].show();
		
		System.out.println();
		
		c1[0].movePoint(5, 10);
		c1[0].show();
		
		c1[1].movePoint(20);
		c1[1].show();
		
		c1[2].movePoint();
		c1[2].show();
		
		
		// ����
	      ColorPoint2[] data=new ColorPoint2[3];
	      for(int i=0;i<data.length;i++) {
	         System.out.println("���Է�");
	         String color=sc.next();
	         System.out.println("x��ǥ�Է�");
	         int x=sc.nextInt();
	         System.out.println("y��ǥ�Է�");
	         int y=sc.nextInt();
	         data[i]=new ColorPoint2(color,x,y);
	      }

		
		for(int i = 0; i < 5; i++) {
			System.out.println("1:���̵�\t2:������ ������ ��ü���\t3: ���α׷� ����");
			int act = sc.nextInt();
			if(act == 1) {
				System.out.println("�� ����: 1�� 2�� 3�� �߿� �������ּ���!");
				int num;
				do {
					num = sc.nextInt();
				}while(num<1 || data.length<num);
				num--; // ���ð� �ε����ѹ������� 1 ����
				System.out.println("���: 1�� 2�� 3�� �߿� �������ּ���!");
				act= sc.nextInt();
				if(act == 1) {
					data[num].movePoint();
				}
				else if(act ==2 ) {
					System.out.println("x �Է�");
					int x= sc.nextInt();
					data[num].movePoint(x);
				}
				else if(act == 3) {
					System.out.println("x �Է�");
					int x= sc.nextInt();
					System.out.println("y �Է�");
					int y = sc.nextInt();
					data[num].movePoint(x, y);
				}
				else {
					System.out.println("�ش����!");
				}
			} // 1�� ��� ����
			else if(act == 2) {
				System.out.println();
				System.out.println("==�� ���==");
				for(Point p:data) {
					p.show();
				}
			}
			else if(act == 3) {
				System.out.println("���α׷� �����...");
				break;
			}
			else {
				//��ȿ���˻�
				System.out.println("�߸��� �Է�!");
				// 5���� ��ä���� ���������ű� ������ i--�� �н�
			}
		}
		
		
	}// main����

}
