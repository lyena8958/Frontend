package day08_0701;

import java.util.Scanner;

public class TEST5 {
	/*
	 * ���� 1���Է�: 5
[ _ _ _ _ _ ] �迭 ����

�������� �Է��ؼ� �������ּ���.
[ 10 6 6 11 7 ]

���ϴ� ���� �Է�: 5
  5�� �����ϴ�.
���ϴ� ���� �Է�: 6
  6�� 1 2  �� �ε����� �����մϴ�.
	 * */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("���� 1���Է�: ");
		int num=sc.nextInt();
		int [] arr= new int[num];


		// �迭 ����!!
		for(int i = 0; i < arr.length;i++) {

			arr[i] = sc.nextInt();
		}
		
		System.out.print("[ ");
		// ������ �Է� -> �迭 ����
		for(int i = 0; i < arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.print("]\n");
		
		int cnt = 0;
		Boolean flag = false;
		// ���� �� ã�� �� ���� �Է�
		while(true) {
			int i = 1;

			System.out.print("���ϴ� ���� �Է�: ");
			int su = sc.nextInt();
			for(int v : arr) {
				if(su == v) {
					System.out.printf("%d ", i);
					cnt ++;
					flag = true;
				}
				else if(cnt == num) {
					break;
				}
				i++;
				
			}
			if(cnt == num) {
				break;
			}
			if(flag) {
				System.out.println("�� �ε����� �����մϴ�.");
			}
			else {
				System.out.println("��(��) �����ϴ�.");
			}
			
		
		}
		System.out.println("���α׷� ����~");
		
		

	}
}
/* ����� ��!!!
 * 
 * package day08;

import java.util.Scanner;

public class Test5 {
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.print("���� 1���Է�: ");
      int num=sc.nextInt();
      int[] arr=new int[num];
      for(int i=0;i<arr.length;i++) {
         System.out.print((i+1)+"�� �����Է�: ");
         arr[i]=sc.nextInt();
      }
      System.out.print("[ ");
      for(int v:arr) {
         System.out.print(v+" ");
      }
      System.out.println("]");
      System.out.print("���ϴ� �� �Է�: ");
      int ch=sc.nextInt();
      System.out.print(ch+"��(��) ");
      Boolean flag=false;
      for(int i=0;i<arr.length;i++) {
         if(ch==arr[i]) {
            System.out.print(i+" ");
            flag=true;
         }
      }
      if(flag) {
         System.out.println("�� �ε����� �����մϴ�.");
      }
      else {
         System.out.println("�����ϴ�.");
      }
   }
}
// ctrl+A : ��ü����
// ctrl+I : ����







+
 * 
 * */

