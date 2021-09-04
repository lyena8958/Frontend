package stuView;

import java.util.InputMismatchException;
import java.util.Scanner;

class MyException extends Exception {
	MyException(String msg) {
		super(msg);
	}
}

public class StuView {
	// �⺻������ ���
	Scanner sc;
	MyException excp;
	public int kor;
	public int math;
	public int eng;
	public String name;

	public void numLimit(int num) throws MyException {
		MyException excep = new MyException("[�Է¿���]1~100���̷� ó������ �ٽ� �Է����ּ���!");
		if (num < 1 || 100 < num) {
			throw excep;
		}
	}

	public void viewStart() {// ���ۺκ�(�����Է�, ���ܿ���ó��)
		sc = new Scanner(System.in);
		while (true) { // �ùٸ����Է��Ҷ����� �ݺ�
			// �Է��� ������ ����(�̸�, ���񺰼���)
			String name;
			int kor, math, eng;
			try {// ���� ���� �Է� �� ����ó��(+���ǿ���)
					// �ȳ���Ʈ
				System.out.println("=========���� ���α׷�=========");
				System.out.println("���԰� ���� �°� ������ �Է��ϼ���.");
				System.out.println();

				System.out.print("�̸�: ");
				name = sc.next(); // �̸� �Է�

				// �����Է� //�����߻��� ó������ �ٽ��Է�
				System.out.print("��������: ");
				kor = sc.nextInt(); // �����Է�
				numLimit(kor); // ��������ó�� �Լ�ȣ��!

				System.out.print("��������: ");
				math = sc.nextInt();
				numLimit(kor);

				System.out.print("��������: ");
				eng = sc.nextInt();
				numLimit(kor);
			} catch (InputMismatchException e) {// Ÿ�Կ���(ex int<>str)
				sc.nextLine(); // ��������
				System.out.println("[�Է¿���]Ÿ�Կ���!!");
				System.out.println("============================\n\n");
				continue;
			} catch (MyException e) {// ��������ó��(1~100��)
				System.out.println(e.getMessage());
				System.out.println("============================\n\n");
				continue;
			} catch (Exception e) {
				System.out.println(e.getMessage() + " �����߻�");
				System.out.println("============================\n\n");
				continue;

			}
			// ������ �߻��ȵǾ� ���������� �Է��ߴٸ� -> ��������� ����
			this.kor = kor;
			this.math = math;
			this.eng = eng;
			this.name = name;
			break;
		}
	}

	public void showRes(String grade, double avg) {// ������(���ڴ� model���� �޾ƿ�)
		System.out.print(this.name + "���� ���"); // ����� �̸����
		for (int i = 0; i < 5; i++) {// . �κ� 1�ʴ� �Ѱ��� ->�� 5�� ���
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("�����߻�!");
			}
			System.out.print(". ");
		}
		System.out.printf("\n���: %.1f\t", avg); // ��հ� ���
		System.out.print("[" + grade + "]!!\n"); // ����� ���
		System.out.println("==========================\n\n");

	}

}
