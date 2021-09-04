package day16_0719_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Book{
	Book(String name){// ����� ����
		this.name = name;
	}
	Book(String name, int cnt){// �缭 ����
		this.name = name;
		this.cnt = cnt;
		System.out.println(this.name+" �߰� �Ϸ�!");
	}
	
	String name; // å�̸�
	int cnt; //���
	@Override
	public String toString() {
		return this.name + ": [" + this.cnt + "]" ;
	}
}
class Person{
	Person(String name){
		this.name = name;
		this.MemberNum++;
		System.out.println(this.name+"�� �ݰ����ϴ�! ������ ���� ȸ����ȣ�� "+ this.MemberNum+"�Դϴ�.");
	}
	
    String name; // ȸ�� �̸�
	static int MemberNum = 0000; // ȸ����ȣ
	//ArrayList <Book>bookList = new ArrayList(); //�迭����Ʈ ����(ĳ����: BookŬ����)
	
	//void BookAdd(int bookNum) {
	//	bookList.add(new Book(bookNum));
	//}
	ArrayList <Integer>bookList = new ArrayList(); //�迭����Ʈ ����(ĳ����: BookŬ����)
	
	void BookAdd(int bookNum) {
		bookList.add(bookNum);
	}


}

public class link_CollectionProject {
	//��ȿ���˻� �Լ�
	static int NumCheck(int a, int b, int num) {
		
		while (true) {
			if (num < a || b < num) {
				System.out.println("[����] " + a + "�̻� " + b + "���Ϸ� �ٽ� �Է����ּ���!");
				num = new Scanner(System.in).nextInt();
				continue;
			}
			break;
		}
		
		return num; // �ùٸ� ���� ����
	}
	//ȸ����ȣ ��ȿ���˻�
	static Boolean MemCheck(int memNum, ArrayList<Person> member) {
		for(int i = 0; i < member.size();i++) {
			if(memNum==member.get(i).MemberNum) {
				System.out.println(member.get(i).name+"�� �ݰ����ϴ�!");
				return false;
			}
		}
		System.out.println("ȸ����ȣ�� ��ġ�����ʾ� �̿��� �Ұ��մϴ�.");
		return true;
	}
	// LinkedList 
	// �����������α׷�
	// 3�� Book ����, �뿩����(����ִ���)
	// 1.�뿩 2.�ݳ� 3.��Ϻ��� 4.����
	// +++)Person
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Book> book = new LinkedList();
		ArrayList<Person> member= new ArrayList();

		book.add(new Book("�����", 3));
		book.add(new Book("�鼳����", 2));		
		book.add(new Book("�ξ����", 1));
				
		while(true) {
			System.out.println("0. ����ڵ��     1. �뿩     2. �ݳ�     3. ��Ϻ���     4. ����");
			int PickNum = sc.nextInt();
			if (PickNum==0) { // ����ڵ��
				System.out.print("ȸ������� ���� �̸��� �Է����ּ���!! ");
				 member.add(new Person(sc.next()));
			}
			else if(PickNum==1) {// �뿩
				System.out.println("=====å ���=====");
				for(int i = 0; i < book.size(); i++) {
					System.out.println((i+1)+". "+book.get(i));
				}
				System.out.println("============\n");
				System.out.println("�뿩�� å ��ȣ�� �Է����ּ���.");
				int bookNum = NumCheck(1, book.size(), sc.nextInt()); // 1������ å�������� ��ȿ���˻�
				if(book.get(bookNum-1).cnt==0) {
					System.out.println("���� ��� ���� �뿩�� �Ұ��մϴ�. ù ȭ������ �̵��˴ϴ�.");
					continue;
				}
				System.out.print("ȸ����ȣ�� �Է����ּ���: ");
				int memNum = sc.nextInt();
				if(MemCheck(memNum, member)) { // ȸ����ȣ�� �����ʴٸ�
					continue;
				}
				book.get(bookNum-1).cnt--;
				member.get(memNum-1).BookAdd(bookNum-1);// �뿩å ��ȣ�Է� //ȸ����ȣ - 1�� == �ε���
				System.out.println(book.get(bookNum-1).name+"å �뿩 �Ϸ�Ǿ����ϴ�!!\n");
			}
			else if(PickNum==2) { // �ݳ�
				System.out.print("ȸ����ȣ�� �Է����ּ���: ");
				int memNum = sc.nextInt();
				if(MemCheck(memNum, member)) {
					System.out.println("ȸ����ȣ�� ��ġ���� �ʾ� ���� �̿��� �Ұ��մϴ�.\n");
					continue;
				}
				System.out.println("�ݳ��� å ��ȣ�� �Է����ּ���! ");
				int bookNum = sc.nextInt();
				boolean flag = true; //�ݳ��ϷῩ��
					for(int j = 0; j < member.get(memNum-1).bookList.size(); j++) { // �ش� ȸ���� �뿩�������� �ݺ�
						if(bookNum == (Integer)member.get(memNum-1).bookList.get(j)) { // å��ȣ�� ȸ���� �뿩�� å�� ��ȣ�� ���ٸ�
							System.out.println("�ݳ� �Ϸ� �Ǿ����ϴ�!\n");
							member.get(memNum-1).bookList.remove(j); //����� �ݳ�ó��
							book.get(bookNum-1).cnt++;
							flag = false;
							System.out.println("=====���� �̳��� å��ȣ�Դϴ�.=====");
							for(Person v: member) {
								System.out.println(member.get(j).bookList);
							}
							System.out.println();
						}
					}//for����
				if(flag) { // ��ȣ�� ���������� �ݳ��Ұ�
					System.out.println("�Է��Ͻ� å�� �ݳ� ����� �ƴմϴ�!\n");
					continue;
				}
			}
			else if(PickNum==3) {// ��Ϻ���
				System.out.println("====å ���====");
				for(int i = 0; i < book.size();i++) {
					System.out.println((i+1)+". "+book.get(i)+"\t");
				}
				System.out.println("============\n");
			}
			else if(PickNum==4) {//����
				System.out.println("���� ���α׷��� ����˴ϴ�. �̿��� �ּż� �����մϴ�. *^^*");
				break;
			}
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. 1~4�� �� �������ּ���.");
			}
			
			
		}
		
		
	}//main����

}
