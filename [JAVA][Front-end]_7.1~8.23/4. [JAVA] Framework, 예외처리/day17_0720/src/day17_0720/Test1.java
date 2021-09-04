package day17_0720;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
class Person{
	String name;
	int num;
	Person(String name){
		this.name = name;
		this.num = new Random().nextInt(90)+10; // 10~99
		System.out.println(this.name+"��, �����ȣ�� ["+num+"]");
	}
	@Override
	public String toString() {
		return name + "��  [" + num + "]";
	}
	
}

public class Test1 {
	// Queue
	// ��ȭ ��⿭ ���α׷�
	// 1. ���� 2.���� 3.��⿭��� 4.����
	// 1) ���?
	// 2) ����
	// Person 
//			�̸�
//			�����ȣ
	public static void main(String[] args) {

		// ��ȭ ��⿭ ���α׷�
		Scanner sc = new Scanner(System.in);
		
		Queue <Person>q = new LinkedList<Person>();
		
		while(true) {
			System.out.println("1���� 2���� 3��⿭ 4����");
			int act = sc.nextInt();
			if(act==1) {
				System.out.println("���?");
				int num = sc.nextInt();
				for(int i = 0; i < num; i++) {
					System.out.println("������ ������ �Է��ϼ���.");
					String name=sc.next();
					q.offer(new Person(name));
				}
			}
			else if(act ==2) {
				System.out.println("���?");
				int num = sc.nextInt();
				if(q.size()<num) {// ���Է½� ��� ����
					num = q.size();
					System.out.println("�����ڼ����� �����ϴ�. �ִ��Է�...");
				}
	            for(int i=0;i<num;i++) {
	                System.out.println(q.peek().name+"���� �����ȣ��?");
	                int pw=sc.nextInt();
	                if(pw==q.peek().num) {
	                   System.out.println("�����ȣ��ġ!");
	                   System.out.println(q.poll().name+"�� ����!");
	                }
	                else {
	                   System.out.println(q.peek().name+"��, �ٽô��!");
	                   q.offer(q.poll());//�����������̵�
	                }
	             }
	          }

			else if(act==3) {
				System.out.println("==������ ���==");
				for(Person p:q) {
					System.out.println(p);
				}
			}
			else if(act==4) {
				break;
			}
			else {
				System.out.println("�߸��� ����!");
			}
		} // while
		
		
		

	}//main����
}
