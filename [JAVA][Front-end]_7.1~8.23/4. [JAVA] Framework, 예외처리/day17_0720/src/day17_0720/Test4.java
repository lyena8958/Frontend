package day17_0720;

import java.util.ArrayList;
import java.util.Iterator;


public class Test4 {

	public static void main(String[] args) {
		
		// ���ͷ�����
		// �÷����� �����Ҷ�, �ش� ������������ �����Ͽ� "���"�ϴ� �뵵�� ���
		// ���������Ͱ� ���������ʴ� "������"���ִ�.
		ArrayList al = new ArrayList();
		al.add(10);
		al.add(20);
		al.add(30);
		for(int i = 0; i < al.size();i++) {
			System.out.println(al.get(i));
		}
		for(Object obj:al) {
			System.out.println(obj);
		}
		Iterator itr = al.iterator();
		// al�����ͳ����� ������ ����ü
		// hasNext - ���� ���� �����־�?
		// next - ���� ������� ����
		
		while(itr.hasNext()) {// ������ �ƹ����� ����?
			System.out.println(itr.next()); // pop.polló�� ->������Ʈ, ��ü(���빰) ��ȯ
		}
		
		// "�����ӿ�ũ" (�÷��� �����ӿ�ũ)
		// �÷��� :�� 7����
		// al ll stack queue (set map) itr
		// stack - �������, �ڷΰ���		queue - ��⿭
		// ( ) - �ܵ������������
		// itr ���������͸� �ջ��ϰ���� ������, ����ϴ� �뵵
		
		
		
	}

}
