package day10_0705;

import java.util.Random;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		// �迭�� ������ �Է�: 10
		// [ 1 2 3 4 1 2 3 4 1 1 ]
		// �������� ���� 1~5���� ����
		/*
		 *1: 4 
		 *2: 2
		 *3: 2
		 *4: 2
		 */
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("�迭�� ������ �Է�: ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		System.out.print("[ ");
		for(int i = 0; i < arr.length;i++) {
			arr[i] = rand.nextInt(5)+1; // 1~5���� �������� ����
			System.out.print(arr[i]+" ");
		}
		System.out.println("]");
		
		// �ڰ���� ���
//	     System.out.print("�迭�����Է�: ");
//	      int num=sc.nextInt();
//	      int[] data=new int[num];
//	      for(int i=0;i<data.length;i++) {
//	         data[i]=rand.nextInt(5)+1;
//	      }
//	      System.out.print("[ ");
//	      for(int v:data) {
//	         System.out.print(v+" ");
//	      }
//	      System.out.println("]");

		// *1) ������ "���"
//		for(int i = 1; i <= 5; i++) {
//			int cnt = 0;
//			for(j = 0; j < arr.length; j++) {
//				if(i==data[j]) {
//					cnt++;
//				}
//			}
//			if(cnt == 0) {
//				continue;
//			}
//			System.out.println(i+": "+cnt);
//		}
		
		// *2) ������ "����" -> ���
//		int[] cntData = new int[5];
//		// 1~5���� ������� �����ϴ� �迭

//		for(int i = 0; i < arr.length; i++) {
//			cntData[arr[i]-1]++;
//		}
//		
//		for(int i = 0; i < cntData.length; i++) {
//			if(cntData[i]==0) {
//				continue;
//			}
//			System.out.println((i+1)+": "+cntData[i]);
//		}
		
		
		// �ڿ�����
		int[] cnt = new int[num];
		for(int i = 0; i < arr.length;i++) {
			cnt[arr[i]-1]++;
		}
		
		
		for(int i = 0; i < cnt.length; i++) {
			
			if(cnt[i]==0) {
				continue;
			}
			System.out.println((i+1)+": "+cnt[i]);
			
		}
		
		
		
		
	} // main����

}
