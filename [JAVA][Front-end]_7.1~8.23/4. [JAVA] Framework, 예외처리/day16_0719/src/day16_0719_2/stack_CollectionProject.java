package day16_0719_2;

import java.util.Scanner;
import java.util.Stack;
//�̿���
public class stack_CollectionProject {
	// Stack - ä�����α׷�
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int PASS = 1758; // ���� �н����� ���
		
		Stack <Integer> score = new Stack(); // ���� ����
		
		// ���α׷� ���� �ȳ�����
		System.out.println("�ۡ۴��б� ä�� ���α׷� �Դϴ�.");
		System.out.print("�ܺ� ������ ���� �ϰ� �ֽ��ϴ�. �н����带 �Է� ���ּ���: ");
	
		// ���� ��й�ȣ Ȯ��
		if(sc.nextInt()!=PASS) { // �Է¹�ȣ�� �ٸ��ٸ� �������
			System.out.println("�н����� ����!! ���α׷��� ����˴ϴ�.");
			return;
		}
		// ===========================================================================
		/// �١ڡ١�ä�����α׷� START�١ڡ١�
		
		int i = 0; // �Է� Ƚ�� ���庯��
		int dataSave = 0; // ������� ���� ���庯��
		while(true) {
			System.out.print("[��� ����] 1:�����Է�    2:��������    3:����     ");
			int pickMod = sc.nextInt(); // ��弱��
			System.out.println(); //������
			
			if(pickMod == 1) { // �����Է¸��
			while(true) { // ������ ������ ���ѹݺ�
			if(i==5) { // ��� �Է��ϸ� �Է¸������
				System.out.println("ä���� ��� �Է��Ͽ� ����˴ϴ�.\n\n");
				break;
			}
			System.out.println("ä������� �Է����ּ���");
			System.out.println("[����] �ּ�����: 1�� ~ �ִ�����: 10�� �Դϴ�.(��� ����: 0��)");
			int res = sc.nextInt();
			System.out.println(); // ������
			if(res == 0) { // �Է¸�� ����
				break;
			}
			else if(1 <= res && res <= 10 ) { // �ùٸ� ���� �����Է�
				score.push(res);
				System.out.println("�Է¼���!!");
				System.out.println("=====����ǥ=====");
				System.out.println(score);
				System.out.println("=============");
				i++; //n��° �Է¿Ϸ�
				System.out.println();
				
			}
			else {
				System.out.println("[�����Է� ����] �߸��� �Է��Դϴ�.\n");
				continue;
			}
				} // �ݺ�������
			}//�Է¸�� ����
			
			else if(pickMod==2) { // �������
				if(score.size()==0) {//����� ������������ �����������
					System.out.println("������� �Էµ� ���� �����ϴ�. ���â���� ���ư��ϴ�.\n");
					continue;
				}
				System.out.print("���� �������: 0��, ������� �ҷ�����: 1���� �Է����ּ���.\n[���ǻ���] �� ������  �������� �Էµ� �������� �ݿ��� �˴ϴ�. ");
				pickMod = sc.nextInt();
				System.out.println(); // ������
				if(pickMod == 0) {//���� �������
					dataSave = score.peek(); // ������� ����
					System.out.println(dataSave+" ������ ��ҵ˴ϴ�. . . .\n");
					score.pop(); // �ֱٿ� �Էµ� ��������
					System.out.println("==���� ����==");
					System.out.println(score);// ������� ��������� �ȳ�
					System.out.println("=========\n");
					i--; //�Է�Ƚ������
				}
				else if(pickMod == 1) {// ��ҵ� ���� �ҷ�����
					if(dataSave == 0) { // ���������� ���ٸ� ù��� ����
						System.out.println("����� ������ �����ϴ�.\n");
						continue;
					}
					// �ִٸ� ����
					System.out.println("���� �ֱٿ� ��ҵ� �����Դϴ�. : "+dataSave);
					System.out.println("������ �ҷ��ɴϴ�.\n");
					i++; // �Է�Ƚ������
					score.push(dataSave);
					System.out.print("�Է� �Ϸ�! : ");
					System.out.println(score);
					System.out.println(); //������
					
				}
				
			}
			
			else if(pickMod==3) { // ������
				System.out.println("ä�� ���α׷��� ����˴ϴ�. �̿��� �ּż� �����մϴ�. :)");
				break;
			}
			
		}//while����
		
		// �Էµ� ä������ ���� ���
		int sum = 0;
		for(int v: score) {
			sum +=v;
		}
		System.out.println("������ "+sum+"�Դϴ�!!");
		
		}// main����
}

// LinkedList 
// �����������α׷�
// 3�� Book ����, �뿩����(����ִ���)
// 1.�뿩 2.�ݳ� 3.��Ϻ��� 4.����
// +++)Persom

// Stack
// ä�����α׷� 
// 1) ��� ä���� �õ��ϴ��� �Է� (5�� �Է�) 1 2 4 0 0 5 6
// 2) 1~10���� �Է°��� ��, 0�� �Է��ϸ� "�������"
// ��������� �׼��� �����ֳ�?
// 3) 5���� ���� ���


// Queue
// ��ȭ ��⿭ ���α׷�
// 1. ���� 2.���� 3.��⿭��� 4.����
// 1) ���?
// 2) ����
// Person 
//		�̸�
//		�����ȣ
