package day16_0719_1;

import java.util.ArrayList;

public class Test4 {

	public static void main(String[] args) {
		
		// �÷��ǿ� ����� Object�� Ÿ���� �����غ���!
		// <���׸�>
		ArrayList<Integer> al = new ArrayList();
		// al.add("apple"); xxx -> ������ ����� Ÿ���� �����߱� ������ �Ұ�!
		
		// ����Ÿ�� < �ݴ� > WrapperŬ����
		
		al.add(10);
		al.add(11);
		al.add(12);
		if(al.get(0)<al.get(1)) {
			System.out.println("Ȯ��");
		}
		for(int v: al) {
			System.out.println(v);
		}
		

	}// main����

}
