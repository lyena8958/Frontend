package view;

import java.util.Scanner;

public class CalcConsolView {
	// view��ü�� �������ʰ� �ڵ�
	// view�� 1ȸ. �����ϰ� ȣ��
	Scanner sc;
	public int n1;
	public int n2;
	public String op;
	// cont'r���� ���� �������� ���� �������
	
	public CalcConsolView(){
		sc=new Scanner(System.in); //�޼ҵ忡 �־��
	}
	public void startCalc() {
		System.out.println("����1�Է�: ");
		n1 = sc.nextInt();
		System.out.println("����2�Է�: ");
		n2 = sc.nextInt();
		System.out.println("�������Է�: ");
		op = sc.next();
	}
	public void showRes(int res) {
	System.out.println("����� "+res+"�Դϴ�.");
	}
}
