package day21_0726;

import java.util.ArrayList;
import java.util.Iterator;

// getter, setter
// : 객체의 멤버변수를 외부의 코드에서접근하기위해 필요한 메서드
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
	
		Circle c = new Circle("피자", 10);
		c.setName("도넛");
		System.out.println(c.getArea());
		System.out.println(c);
		
		
		ArrayList al = new ArrayList(2);   // 사이즈-경향성
		ArrayList al2 = new ArrayList();
		System.out.println(al.size());
		System.out.println(al2.size());
		//size: 실제 데이터의 개수를 의미한다.
		
		ArrayList al3 = new ArrayList();
		al3.add(10);
		al3.add(20);
		al3.add(30);
		
		// resset == iterator -> 복사체
		// 원본 데이터를 손상시키지않으니 보통은 출력용으로 사용 
		Iterator itr = al3.iterator();
		while(itr.hasNext()) {//다음이있니?
			System.out.println(itr.next()); // 복사된 데이터를 지우면서 값을출력
		}
		
		
		
		
		
		
		
	}//main 종료

}
