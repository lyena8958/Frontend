package day12_0707;

public class Test2 {
// Ŭ������ Test1 Ŭ������ ����� Book�� ���� �´�.
	public static void main(String[] args) {
		
		//int[] arr = new int[3];
		
		Book[] data = new Book[3];
		// "�ؾ�� �����."
		//  == ��ü�� ����
		//  == ��üȭ, �ν��Ͻ�ȭ
		//  == new ������()  ȣ��
		
		Book book=new Book("��ݱ�� ũ�ν� �÷��� ������ �缺����");
		
		// 1�� ��� -> ��ü
		for(int i = 0; i < data.length;i++) {
			data[i] = new Book("å"); 
		}
		data[0] = book; // 2�� ��� -> ���� ....���� �ʱ�ȭ(��ü�� �������� ��������)
		for(Book v:data) {
			// System.out.println(v); : �ּҰ��� ���´�.
			v.show();
		}
		

	}

}
