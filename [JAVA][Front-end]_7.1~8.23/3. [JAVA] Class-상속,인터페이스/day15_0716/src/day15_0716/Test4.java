package day15_0716;

import java.util.ArrayList;
class Student{
	String name;
	Student(){
		this.name= "�л�";
	}
	@Override
	public String toString() { // �������̵�
		return "Student [name=" + name + "]";
	}
	
}
public class Test4 {

	public static void main(String[] args) {
		// �÷��� �����ӿ�ũ
		// "�����ӿ�ũ"
		
		// [�迭����Ʈ]
		// : �迭�� ����Ʈȭ�� �÷���(�ڷᱸ��)
		// "����Ʈ"?
		//ArrayList al = new ArrayList(3); // ���� ���̰��� �����ʾƵ��ȴ�.
		ArrayList al = new ArrayList(); // �����������ص� ������ ������ ������ ���� �����Ѵ�.
		// ArrayList -> �ձ��� �빮��? Ŭ������!!
		al.add(new Student());
		al.add("apple");
		al.add("ġŲ");
		
		al.add(10); // ���η����� ���� ��������!! == ĸ��ȭ
		al.add(20);// �Լ�ȣ��!!
		System.out.println(al.size()); // ���̸� ã����
		al.add(0, 10); // �ε��� ����(0�� �ε����� 30�� �ְڴ�.)
		al.add(40);
		System.out.println(al);
		System.out.println(al.get(2));// al[index]�� ���� ����ü��� ���� get�Լ��� ������ش�.
		System.out.println(al.indexOf(10)); // �� �˻�����(���ǰ��� �������´�))
		// ���� ã�� �ε����ѹ��� �˷���(������ -1) 
		System.out.println(al.lastIndexOf(10));
		//[]��� get�Լ�
//		for(int i = 0; i < al.size();i++) {
//			if((Integer)al.get(i)==10) { // Integer == int (��ü������ Ŭ����->����ȯ Integer���Ѵ�)
//				// al.get(i)==10 �ڷ����� �޶� �ȵ�(int, Object class)
//				System.out.println(i);
//			}
//		}
		
		if(al.contains(10)) { // al�ȿ� 10�̶� ���� �ִ�?
			System.out.println("�־�.");
		}
		if(al.indexOf(100)==-1) {
			System.out.println("����.");
		}
		
		al.clear(); // ���ڸ� �پ����ִ� �Լ�
		if(al.isEmpty()) {// is==�װŴ�?? �� ���̴� isEmpty==�ֺ���ִ�??
			System.out.println("�ֺ�");
		}
		System.out.println(al); // toString�� ����������
		System.out.println(al.size()); // ���̸� ã����
		
		al.clear();
		
	}//main ����
}
/*
�����ӿ�ũ
- framework
- ����, ���, ����, Ʋ

�÷��� �����ӿ�ũ�١١١١�
spring �����ӿ�ũ�١١١١�

������>>>>>>>
�������� ����>>>>>>>
// �������� �������� �������� ������ ���ƾ��Ѵ�.


"�迭": ���������� ���õ� �����͸� �Ѱ����� ����
==�÷���(�ڷᱸ��: ������)
	�迭,����Ʈ,����,ť,��,����(Set).... // ���̽� list set�� ����ϴ�.
========================================================

int[] data=new int[5];   vs	�÷���
ũ�� ����			ũ�������̾���
data[0] = 10;		data.add(10);
data[1] = 20;		data.add(20);
�����Ͽ� ������ ����	�پ��� �����͸� �����Ҽ��ִ� ���� �޼��尡 �̹� �����Ǿ��ִ�!


�� ���� �迭���ٴ�[ �÷��� ]�� ����Ѵ�.*/