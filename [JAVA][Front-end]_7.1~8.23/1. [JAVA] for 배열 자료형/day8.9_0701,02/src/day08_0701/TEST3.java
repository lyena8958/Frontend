package day08_0701;

import java.util.Scanner;

public class TEST3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
	
		
		/*
		 * 1. �������Է�: 10
			���� ���̴� 314.0�Դϴ�.
			(�Ǽ��� ���)
		 */
		
		// ����� ��!
		System.out.print("�������Է�: ");
	      int r=sc.nextInt();
	      
	      final double PI=3.14; // ���ȭ
	      double area=r*r*PI;
	      System.out.println("���� ���̴� "+area+"�Դϴ�.");

		
		
		// ���� ��
		/*
		System.out.print("�������Է�: ");
		double d = sc.nextInt();
		System.out.println("���� ���̴�"+3.14*d*d+"�Դϴ�.");
		
		
		System.out.println("");
		*/
		
		/*
		 * 2. ����3���Է�
			���� 1�Է�: 10
			���� 2�Է�: 20
			���� 3�Է�: 30
			���� 60�̰�, ����� 20.0�Դϴ�.
      			(��� �Ǽ�)
		 * */
		
		
		// ����� ��!
	      int sum=0;
	      for(int i=0;i<3;i++) {
	         System.out.print("���� "+(i+1)+"�Է�: ");
	         int n=sc.nextInt();
	         sum+=n;
	      }
	      System.out.print("���� "+sum+"�̰�, ");
	      double avg=sum/3.0;
	      System.out.println("����� "+avg+"�Դϴ�.");

		
		
		//���� ��
	      /*
		int sum = 0;
		double d2 = 0;
		
		for(int j = 1; j <= 3; j++) {
			System.out.print("���� "+j+"�� �Է�: ");
			int a = sc.nextInt();
			sum+=a;
			
			if(j == 3) {
				d2 = sum * 1.0/ j;
			}
		}
		
		System.out.println("���� "+sum+"�̰�, �����"+d2+"�Դϴ�.");
		
		*/
		
	}

}
