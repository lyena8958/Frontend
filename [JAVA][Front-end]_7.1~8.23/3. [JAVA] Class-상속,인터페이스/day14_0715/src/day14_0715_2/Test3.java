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
	// �ֻ���Ŭ���� Object�κ��� �������̵�~!
	public String toString() { // ���� ������Ʈ�� �޼��带 ������!!(�������̵�)
	// �ڽ�(Student)�� �θ�(Object)���� ũ�Ⱑ �� ũ�ų� ���ƾ��ؼ� == public
		return name+"�л���"+score+"���Դϴ�.";
	//�ڡڡ� �� �޼ҵ� show() �ʿ� xxx -> �޸𸮸� �Ƴ� �� �ִ�!!!!!
	}
}
public class Test3 {
	static void f(int i) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = " �ȳ�";
		System.out.println(str);
		
		Student[] data = new Student[5]; // Object�� �ڽ�
		for(int i = 0; i < data.length;i++) {
			data[i] = new Student("ȫ�浿"+(i+1));
		}
		
		data[0].toString();
		//  2-toString()�޼����� �ڵ�ȣ��
		
		for(Student stu:data) {
			//System.out.println(stu); // �Ʒ��� ����(��� toString()�� �����Ǿ��ִ���!!!!!)
			System.out.println(stu.toString());
			// ��� stu�� ��µ���...??
			//  1) ���ڷ� Object�� �ް��־!
			//	2) 26line
		}
		// Object��?
		// �ֻ���Ŭ����
		// ��� Ŭ������ ����Ŭ�����̴�!(���������ڿ��� ������Ʈ�� ���������)
		
		
	}

}
