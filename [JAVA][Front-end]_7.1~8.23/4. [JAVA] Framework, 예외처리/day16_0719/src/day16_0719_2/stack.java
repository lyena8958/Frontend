package day16_0719_2;

import java.util.Scanner;
import java.util.Stack;

public class stack {
	// Stack
	// ä�����α׷� 
	// 1) ��� ä���� �õ��ϴ��� �Է� (5�� �Է�) 1 2 4 0 0 5 6
	// 2) 1~10���� �Է°��� ��, 0�� �Է��ϸ� "�������"
	// ��������� �׼��� �����ֳ�?
	// 3) 5���� ���� ���
	public static void main(String[] args) {
		// stack ä�� ���α׷�
		// �������? -> stack!!!!

		Stack<Integer> s = new Stack();
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		while(s.size()<cnt) {
			System.out.println("�����Է�");
			int num = sc.nextInt();
			if(1<=num&&num<=10) {
				s.push(num);
				System.out.println("ä���Ϸ�!");
			}
			else if(num==0) {
				if(s.size()==0) { // ������ �����Ͱ����ٸ�
					System.out.println("������ �����;���!");
					continue;
				}
				s.pop(); // ������ ������ ���
			}
			else {
				System.out.println("�ٽ��Է�!!");
			}
		}
		int sum = 0;
//		while(s.size()!=0) {
//			sum+=v;
//		}
		for(int v: s) {
			sum+=v;
		}
		System.out.println(sum);
		
	}//main����

}
