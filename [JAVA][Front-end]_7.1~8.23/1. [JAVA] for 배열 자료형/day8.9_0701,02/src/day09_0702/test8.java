package day09_0702;

import java.util.Scanner;

public class test8 {

	public static void main(String[] args) {
		// ��� : nextline�� ����Ϸ��� �տ� ������ ���� �������Ѵ�~~~~
		// next: ���� ���x	, nextline: ���� ���o
		Scanner sc = new Scanner (System.in);
		
		// charŸ���� �Է�
		// ���ڿ� �߿��� ���� ù��°���� �Ѱ��� ���� ����
		
		int i = sc.nextInt();
		System.out.println(i);
		// �� ���� ����ϸ� nextline�տ� �ƹ� ���� ��� ������ ���´�.
		char c = sc.nextLine().charAt(0); // ���ڿ� �� �Ѱ����� ����- charAt(���ڿ��� index)
		// ������ ���ڹ迭
/*
		// nextLine : ������ ���Ե� ���ڿ� �Է°��� (��, ���� ������ �Է����� ��� buffer�� null���� �����־� ����������Ѵ�) ����: sc.nextLine();
		// next : ������ ���� ���ڿ��� �Է°��� (���Ⱑ �� ���ڿ� ��� �Ұ�)
		
		System.out.println("�����Է�: ");
		int i = sc.nextInt();
		sc.nextLine(); // i���� �Էµǰ� ���ۿ� ���� ����� ���� �����ϴ� ���� // nextLine()�� ����ϰ� ���� ��
		System.out.println("�����Է�: ");
		//String str=sc.next();
		String str=sc.nextLine();
		System.out.println(i+" "+str);
		
		// ���ڿ��� next()�� �Է¹޴´�.
		//String str=sc.next(); // ���� �� ���� ��������, �տ��� ������ �Է½� ���� ����µȴ�.(buffer)
		
		String str= sc.nextLine(); // ������� ��������, �տ��� ���� �Է½� ���� �Է��̾ȵȴ�.
		System.out.println(str);
	*/	
	}

}
