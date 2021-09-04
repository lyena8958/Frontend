package day11_0706;

// ����� ��
class Subject2{
	Subject2(String name){
		this(name,2); // 13���� �Ѱܼ� ����
		
	}
	Subject2(int time){
		this("�������",time);
		// this.name = "�������"
		// this.time = 2 
		// �� �� ������, ȿ������ ���� �޼ҵ�Ȱ��
	}

	Subject2(String name, int time){
		this.name=name; //this.name -> ��ü , name-> ����
		this.time=time;
	}
	String name;
	int time;
	void show() {
		System.out.println(this.name+"��(��) "+this.time+"�����Դϴ�.");
	} // name, time �����ε� �ص��ǳ� �������� ���� this.�� ���δ�.
	void changeTime2(int time) {
		System.out.println(this.name+"��(��) "+this.time+"->"+time+"���� ����Ǿ����ϴ�."); // ��º�
		this.time = time; // ��ɺ�
	}
}

// ���� Ŭ����
class Subject{

	Subject(){
		this("���� ����", 2);
	}
	Subject(String name, int time){
		this.name = name;
		this.time = time;
		this.show();
	}
	Subject(String name){
		this.name = name;
		this.time = 2;
		this.show();
	}
	Subject(int time){
		this.name = "���� ����";
		this.time = time;
		this.show();
	}
	void show() {
		System.out.println(this.name+"��(��) "+this.time+"�����Դϴ�.");
	}
	void changeTime(int time) {
		// this.time -> ��ü���� �Է��� ��, time-> �޼ҵ忡�� �Է��� ��
		System.out.println(this.name+"(��)�� "+this.time+"��"+time+"���� ����Ǿ����ϴ�.");
		this.time/*��ü*/ = time;//����
	}
	
	String name; // �����
	int time; // ����
	
}

public class Test3 {
	public static void main(String[] args) {
		/*
	class Subject
	-String name // �����
	-int time // ����
	-void show()
	   ������(��) 2�����Դϴ�.
	-void changeTime(int time)
	  ������(��) 2->3�������� ����Ǿ����ϴ�.
	��main()���� ������� ������ �����غ��ڽ��ϴ�!~~
	Subject s1=new Subject(3);
	   => ������� / 3
	Subject s2=new Subject("�û翵��");
	   => �û翵�� / 2
	Subject s3=new Subject("C���",4);
	   => C��� / 4	*/
		
		// ����
		Subject s1 = new Subject(3);
		Subject s2 = new Subject("�û翵��");
		Subject s3 = new Subject("C���", 4);
		s3.changeTime(5);
		s3.show();
		
		System.out.println("");
		
		// �����
		Subject2 s21 = new Subject2("C���", 4);
		s21.show();
		
		Subject2 s22 = new Subject2("�û翵��");
		Subject2 s23 = new Subject2(3);
		s22.show();
		s23.show();
		
		
	}

}
