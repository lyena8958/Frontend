package day17_0720;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		
		// [���� ó��]
		
		// ���� Exception
		Scanner sc = new Scanner(System.in);
		int act = sc.nextInt();

		// java.util.InputMismatchException
		// : � ��������?
		// Test5.java:13
		// : �߻��� �ڵ��� ����!
		
		int[] arr = new int[3];
		System.out.println(arr[act]);
		// java.lang.ArrayIndexOutOfBoundsException: 3
		
		
		int a = 10;
		int b = 0;
		try{// �������
			System.out.println("��������");//���o
			System.out.println(a/b);//���ܰ� ������ �̾ �ڵ�����Ѵ�.
			System.out.println("���⿩��");//���x
		}catch(ArithmeticException e) {// � Ÿ���ǿ���?
			e.printStackTrace();
			System.out.println(e.getMessage()); //������ ����
			System.out.println("/ by zero"); // �����Ǹ�>��ü������ ����
		}catch(Exception e) {// �˼����� ���ܰ� ����ԵǸ�(�μ����� �ֻ���Ŭ������ ,����)
			System.out.println("�˼����¿��ܹ߻�!");
		}
		finally {
			System.out.println("�׻� ����Ǵ� ����");
		}
		//System.out.println(a/b);
		//  java.lang.ArithmeticException: / by zero
		
		// �Լ����� ���� �ö󰡾��Ѵ�. �μ����̸�� ������ ����Ŭ�����̹Ƿ�
//		try{
//			System.out.println("��������");
//			System.out.println(a/b);
//			System.out.println("���⿩��");
//		}catch(Exception e) {
//			System.out.println("�˼����¿��ܹ߻�!");
//		}
//		catch(ArithmeticException e) {
//			System.out.println("/ by zero");
//		}
		
		System.out.println("Ȯ��!");
		
		// ����
		// : ������ ����xxx(�ڵ���ü���� ������ ����.)
		// : ������ ������ �ڵ�(������ �������� �� ���� ��ü�� ������)
		// : ������ �����ϸ� ������ �߻�! (==����ÿ� ������ �߻��ߴ�.)
		// => ���ܰ� �߻��ϰԵǸ�, ���α׷��� ��� �����!
		//     īƮ���̴��� �ϴٰ� �������̰� ���ܼ� �ñ�� ���� ��������
		
		// ����ó��
		// : �����߿� ������ �߻��ϴ���, 
		// ���α׷��� ������ �����ϰ������ ���!
		
		// 1. ����ó���� �߻��ϸ�
		// ������� ��Ÿ�� Ȯ���Ѵ�.
		// 2. ���ܸ� *�޸��忡 ����,
		// ��� ó���ϴ��� ���۸��Ѵ�.
		
		// try-catch��
		// 
		
		
	}

}
