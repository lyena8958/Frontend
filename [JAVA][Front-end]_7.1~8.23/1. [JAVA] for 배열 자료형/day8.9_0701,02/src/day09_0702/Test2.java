package day09_0702;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
//		�迭1)
//
//		������ 1���Է� 5
//
//		[ 1 2 3 4 5 ] �迭������ ����
//
//		5 4 3 2 1 �� ����Ǿ����ϴ�!
		
		// ������� ��!
	      Scanner sc=new Scanner(System.in);
	      
	      System.out.print("�迭�� ũ���Է�: ");      
	      int n=sc.nextInt();
	      int[] arr=new int[n];
	      
	      Random rand=new Random();
	      
	      for(int i=0;i<arr.length;i++) {
	         arr[i]=rand.nextInt(6)+1;
	         // rand()%6 + 1
	      }
	      
	      for(int i=arr.length-1;i>=0;i--) {
	         System.out.print(arr[i]+" ");
	      }

		/* ����
		System.out.print("������ 1���Է�: ");
		int num1 = sc.nextInt();
		
		// �迭����
		int [] arr1 = new int[num1];
		
		// �迭 �ʱ�ȭ
		int numCnt = num1+1;
		
		for(int i = 0; i< arr1.length; i++) {
			arr1[i] = (num1)-i;
			System.out.print(arr1[i]+" ");
		}
		System.out.print("�� ����Ǿ����ϴ�!\n\n");*/
		

	}

}
