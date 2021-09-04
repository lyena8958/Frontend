package day21_0726;

import java.util.ArrayList;
import java.util.Iterator;

// getter, setter
// : ��ü�� ��������� �ܺ��� �ڵ忡�������ϱ����� �ʿ��� �޼���
class Circle{
	private String name;
	private int radius;
	private double area;
	Circle(String name, int radius){
		this.name = name;
		this.radius = radius;
		this.area = this.radius*this.radius*3.14;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Circle [name=" + name + ", radius=" + radius + ", area=" + area + "]";
	}
	
}
public class Test1 {
	public static void main(String[] args) {
	
		Circle c = new Circle("����", 10);
		c.setName("����");
		System.out.println(c.getArea());
		System.out.println(c);
		
		
		ArrayList al = new ArrayList(2);   // ������-���⼺
		ArrayList al2 = new ArrayList();
		System.out.println(al.size());
		System.out.println(al2.size());
		//size: ���� �������� ������ �ǹ��Ѵ�.
		
		ArrayList al3 = new ArrayList();
		al3.add(10);
		al3.add(20);
		al3.add(30);
		
		// resset == iterator -> ����ü
		// ���� �����͸� �ջ��Ű�������� ������ ��¿����� ��� 
		Iterator itr = al3.iterator();
		while(itr.hasNext()) {//�������ִ�?
			System.out.println(itr.next()); // ����� �����͸� ����鼭 �������
		}
		
		
		
		
		
		
		
	}//main ����

}
