package day16_0719_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		// ������ 10�� �Է�
		// ¦���� al�� ����
		// +) ������������ ����
		
		//�����
		Scanner sc = new Scanner(System.in);
		ArrayList data =new ArrayList();
		
		for(int i = 0; i < 3; i++) {
			System.out.println("����"+(i+1)+"�Է�");
			int num = sc.nextInt();
			if(num%2==0) {
				boolean flag = true;
				// �÷��ǿ����� ��� ��ȯxxx -> ó������ add�� �ùٸ���!!
				for(int j = 0; j < data.size(); j++) {
					if(num < (Integer)data.get(j)) {//ĳ����(����ȯ)
						data.add(j, num);
						flag = false;
						break;
					}
				}
				if(flag) { // for-if������ ��ΰ� false�� ���(����ū���϶�)
					data.add(num);
				}
				
			}
			System.out.println(data);
		}
		
		// �÷����� ������ ����!
		// AL : ������ �� ����������, ������ �̷�������ʴ� ���������忡 ����
		
		
		// ���� // �������� ���� �ȵ� �Ф�
		ArrayList al = new ArrayList(10);
		int i = 0;
		while(i < 10) {
			System.out.print((i+1)+"��° ¦���� ������ �Է��ϼ���: ");
			int num = new Random().nextInt(50)+1;
			if(num%2==0) {
				System.out.println(num+" ����Ϸ�!");
				al.add(num);
				i++;
				continue;
			}
			System.out.println("Ȧ�� �Է����� ������ �ȵ˴ϴ�.");
		}
		System.out.println(al);		
//		// �������� ����
//		for(int a = 0; a< al.size()-1;a++) {
//			if((int)al.get(a)> (int)al.get(a+1)) {
//				al.add(a, al.get(a+1));
//			}
//			
//		}
		
		
		

	}// main����

}
