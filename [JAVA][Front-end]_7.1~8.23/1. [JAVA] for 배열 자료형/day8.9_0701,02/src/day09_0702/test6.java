package day09_0702;

import java.util.Random;
import java.util.Scanner;

public class test6 {

	/*�л��� ���� �Է��ϼ���.
	�л����� ������ ��������� �Է����ּ���.

	2 3
	�л�1�� ä����...
	0~100 �������� ä������!

	�� �л��� ��յ��� ������ �迭�� ������ּ���!~~
	1���� ��ȣ�� ������ּ���!~~
	 * */
	public static void main(String[] args) {
		
		// ����� ��
	      Scanner sc=new Scanner(System.in);
	      System.out.print("�л���: ");
	      int stu=sc.nextInt();
	      System.out.print("�����: ");
	      int test=sc.nextInt();
	      
	      int[][] STU=new int[stu][test];
	      
	      Random rand=new Random();
	      double[] stuAvg=new double[stu];
	      for(int i=0;i<STU.length;i++) {
	         for(int j=0;j<STU[i].length;j++) {
	            STU[i][j]=rand.nextInt(101);
	            System.out.print( STU[i][j]+"�� ");
	            stuAvg[i]+=STU[i][j];
	         }
	         stuAvg[i]/=STU[i].length;
	         System.out.println("��� " +stuAvg[i]+"�� ");
	      }
	      
	      
	      double max=stuAvg[0];
	      int maxIndex=0;
	      for(int i=1;i<stuAvg.length;i++) {
	         if(max<stuAvg[i]) {
	            max=stuAvg[i];
	            maxIndex=i;
	         }
	      }
	      
	      System.out.println("1���� "+(maxIndex+1)+"���л��Դϴ�.");
	      

		
		
		/* ���� ������ Ǯ�ٸ�
		Random rand = new Random();
		
		System.out.print("�л��� ���� �Է��ϼ���: ");
		int stu = sc.nextInt();
		System.out.print("�� ���� ��ȸ���� �Է��ϼ��� ");		
		int num = sc.nextInt();

		
		int [][] arr = new int[stu][num];
		double [] darr = new double[stu];
		
		
		for(int i =0; i < arr.length;i++) {
			System.out.println("�л�"+(i+1)+"�� ä����...");
			for(int j = 0; j < arr[i].length;j++) {
				arr[i][j] = rand.nextInt(101); // 0~100
				darr[i] += arr[i][j];
				System.out.println((j+1)+"ȸ ����"+arr[i][j]+"��!");
			}
			darr[i] /= arr[i].length;
			darr[i] *= 1.0;
			System.out.printf("[���] : %f��\n\n", darr[i]);
			}
		
		double max = darr[0];
		
		for(int i = 0; i<(arr[0].length-1;i++){
		if(darr[i]<darr[i+1]){
		max = darr[i+1];
		}
		
		}
		// Ǯ�ٸ�
		System.out.println("1���� ��ȣ�� "+(max+1)+" �Դϴ�!");
		
*/
	} // main ����
}

// for - arr[i+1]�� ä���� ...
// 
// for	 rand[i][j] = rand

// double d[stu]
// for(<double[i].length) 
