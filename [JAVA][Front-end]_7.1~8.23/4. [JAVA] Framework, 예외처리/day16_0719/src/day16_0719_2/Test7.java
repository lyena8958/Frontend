package day16_0719_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Test7 {
	// �÷���
			// List�� => ��ġ�ľ�o
			// ArrayList �迭����Ʈ
			//  : ����)�������� ���� �̵�, �߰�or���� � �Ҹ�
			//  : ����)�ε��̹��(�迭)�� ����ϰ��־�, �˻�(Ž��)�� ����
			// LinkedList ���Ḯ��Ʈ	// �߰������� ����� ��
			//  : �������� �߰�or���� � ����
			//  : ���(node)�� ����ϰ��־�, �˻�(Ž��)�� �Ҹ�
			
	public static void main(String[] args) {
		
		//LinkedList ���Ḯ��Ʈ
		LinkedList l1 = new LinkedList(); 
		// �� ��忡 �����ּҰ� �����ϱ� ������ �̸� ������ �����صδ� ���� �Ұ�
		// ���� �پ��� �������� �߰�, ������ �����ϴ�!
		LinkedList<String> l2 = new LinkedList();
		
		l1.add(10);
		l1.add("apple");
		// l2.add(10);
		l2.add("apple");
		//l2.addFirst("b"); -> �ش� ����� �ּҴ� 2��° ����� �ּҸ� ���Ѵ�.
		//l2.addLast("b"); -> ���� ��尡 �����Ƿ�, ����Ű�� �ּҰ� ����.
		System.out.println(l1);
		System.out.println(l2);
		
		System.out.println();
		
		//Stack ���� : ���������ڰ� ����
		//�ε��� ������ ��ƴ�(->���� ���ݿ��ȸ���.)
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		//s.pop(); // ������ �����Ͱ� ������� , ��ȯ�Ѵ�.
		System.out.println(s);
		System.out.println(s.peek()); // ������ ���������ʴ� ���(��ȯ)
		System.out.println(s.pop()); // ������ ������ ���(��ȯ)
		
		System.out.println(s); // toString�� �������̵��� �Ǿ��ִ�.
		
		// add, push ������//
		/*
		push��  Stack����̰�
		add�� Vector����̿���!
		add�� ��� "�迭��"�� �ڷᱸ����
		�⺻������ �̿��Ҽ��մ� �޼����Դϴ�!
		����� ������ ���Ѵ�� ���ŵ� ����������,
		������ stack������ add�� ����ϴٰ� �������Ǽ������Ƿ� push�� ���ڽ��ϴ�*/

		
		System.out.println();
		// Queue ť : �Ǿ� ���ڰ� ����
		double d = 10; // 10.0
		Queue q = new LinkedList(); // ť�� �����Ҷ� ��ũ����Ʈ�� �����Ǿ� ����Ʈ�� �ؾ���
		q.offer(10);
		q.offer(20);
		q.offer(30);
		System.out.println(q);
		System.out.println(q.poll()); // pop��� poll
		System.out.println(q.peek()); // ����x ��¸�
		System.out.println(q);
	
		
		
	}//main����

	// ���� VS ť => ��ġ����xxx, �������o
	// ��"������Ȳ" -> � �ڷᱸ��, �÷����� �̿��Ͽ� �ذ��ұ�?��
	
	// Stack
	// : FILO = First in Last out == ��������
	// == LIFO == ���Լ��� (��������� �����ǹ�)
	// == �Ա��� 1������ ��������
	//ó���� ���������Ͱ� �������� ������, �������� ���� �����Ͱ� ���� ���� ���´�.
	//ex) (c+z)�������, �ڷΰ���, �ֱٹ湮��������
	// �迭���
	
	// Queue
	// : FIFO == ���Լ���
	//  ==LILO == ��������
	//  == �Ա��� �ⱸ�� ������ ��������
	// ex) ��⿭ ������û(���ΰ�ħ ->��⿭ �޹�), Ƽ����, ��ȭ��, ���� ...
	// ť��� ������ ����� LinkedList�� �������� == ��� ť�� LinkedList�̴�.
	// ����Ʈ���
	
}
