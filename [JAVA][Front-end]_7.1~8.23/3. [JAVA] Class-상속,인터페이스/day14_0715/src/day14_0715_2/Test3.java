package day14_0715_2;
import java.util.Random;

class Student{
	String name;
	int score;
	Student(String name){
		this(name,new Random().nextInt(101));
	}
	Student(String name, int score){
		this.name = name;
		this.score = score;
	}
	// 최상위클래스 Object로부터 오버라이딩~!
	public String toString() { // 기존 오브젝트의 메서드를 재정의!!(오버라이딩)
	// 자식(Student)이 부모(Object)보다 크기가 더 크거나 같아야해서 == public
		return name+"학생은"+score+"점입니다.";
	//★★★ → 메소드 show() 필요 xxx -> 메모리를 아낄 수 있다!!!!!
	}
}
public class Test3 {
	static void f(int i) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = " 안녕";
		System.out.println(str);
		
		Student[] data = new Student[5]; // Object의 자식
		for(int i = 0; i < data.length;i++) {
			data[i] = new Student("홍길동"+(i+1));
		}
		
		data[0].toString();
		//  2-toString()메서드의 자동호출
		
		for(Student stu:data) {
			//System.out.println(stu); // 아래랑 동일(사실 toString()가 생략되어있던것!!!!!)
			System.out.println(stu.toString());
			// 어떻게 stu가 출력되지...??
			//  1) 인자로 Object를 받고있어서!
			//	2) 26line
		}
		// Object란?
		// 최상위클래스
		// 모든 클래스의 상위클래스이다!(참조연산자에서 오브젝트로 갖고와있음)
		
		
	}

}
