package day13_0714;

import java.util.Random;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * �̾�Ĺ�� 5������ �ִ�.
		 * ���� �Ѹ����� �� �� ������,
		 * ���κ��� Ű�� ū �̾�Ĺ�� ������ �����̾�Ĺ�� ������.
		 * �̶� �� 5������ �Ӹ��� �� �� �ִ� ������ �Է��ϼ���
		 * */
		int[] cat = new int[5];
		Random rand= new Random();
		for(int i = 0; i < 5; i++) {
			cat[i] = rand.nextInt(9)+1; // 1~9
		}
		for(int v: cat) {
			System.out.print(v+" ");
		}
		System.out.println();
		
		// �Ѹ����� (���� ��������ִ���) �����͸� �����ϴ� ���
		// : �迭
		// �ᱹ, ������ ���ϴ� �� (��ü �����ִ� ������)�� �����ϴ� ���
		// : ����
		
		//�迭
//		int[] data = new int[5];
//		// data[]�迭�� 0���� �ʱ�ȭ �ؾ��ұ��?
//		// new �����ڸ� ����Ͻø� : 1
//		// Heap �޸� ������ �̿� : 2
//		//  ��"�������� ����" == ���α׷� ���� ���Ŀ��� ��밡���� ����
//		// �ڵ��ʱ�ȭ : 3
//		
//		for (int a = 0; a < cat.length; a++) {
//			// [0]�� �ִ� cat�� �����ִ� �������� ī����
//			for (int i = a+1; i < cat.length; i++) {
//				data[a]++;
//				if (cat[a] < cat[i]) { // �ڱ⺸�� Ű�� ū �̾�Ĺ�� �����ٸ�,
//					break;
//				}
//			}
//		}
//		int sum = 0;
//		for(int v:data) {
//			System.out.print(v+" ");
//			sum+=v;
//		}
//		System.out.println();
//		System.out.println(sum);
		
		// ����
		int sum = 0;
		for (int a = 0; a < cat.length; a++) {
			// [0]�� �ִ� cat�� �����ִ� �������� ī����
			for (int i = a+1; i < cat.length; i++) {
				sum++;
				if (cat[a] < cat[i]) { // �ڱ⺸�� Ű�� ū �̾�Ĺ�� �����ٸ�,
					break;
				}
			}
		}
		System.out.println(sum);
		
		
		
	}//main����

}
