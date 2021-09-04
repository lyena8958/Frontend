package day10_0705;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		// ����)
		// �迭ũ�� �Է�: 7
		// 1~100���� �������� ���� �迭�� ����
		// [ 34 96 1 20 35 ]
		// �ִ밪�� 96�̰�,
		// �ּҰ��� [2]�� ��ġ�մϴ�.
		
		// ����
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("�迭ũ�� �Է�: ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100)+1; // 1~100
		}
		
		// ����� ���� �� ���
		System.out.print("[ ");
		for(int v: arr) {
			System.out.print(v+" ");
		}
		System.out.println("]");
		
		int maxValue = arr[0]; // �ִ밪
		int minValue = arr[0]; // �ּҰ�
		int minIndex = 0; // �ּҰ��� ��ġ (~��)
		
		for(int i = 0; i < arr.length; i++) {//max,min�� 0���� �ʱ�ȭ�߱� ������, i =1�� �ϴ°� ����(�ӵ�)
			if(maxValue<arr[i]) {
				maxValue = arr[i];
			}
			if(minValue > arr[i]) {
				minIndex = i;
				minValue = arr[i];
			}
		}
System.out.println("�ִ밪�� "+maxValue+"�̰�,");
System.out.println("�ּҰ��� Index�� [ "+(minIndex+1)+" ] ���� ��ġ�ϸ�,"+minValue+" �Դϴ�.");
		
/* ����� ��!
      Scanner sc=new Scanner(System.in);
      Random rand=new Random();
      
      System.out.print("�迭ũ���Է�: ");
      int num=sc.nextInt();
      int[] data=new int[num];
      for(int i=0;i<data.length;i++) {
         data[i]=rand.nextInt(100)+1;
      }
      System.out.print("[ ");
      for(int v:data) {
         System.out.print(v+" ");
      }
      System.out.println("]");
      
      int max=data[0];
      int min=data[0];
      int minIndex=0;
      
      for(int i=1;i<data.length;i++) {
         if(max<data[i]) {
            // max�� max�� �ƴϾ��ٸ�,
            max=data[i];
         }
         else if(min>data[i]) {
            min=data[i];
            minIndex=i;
         }
      }
      System.out.println("max: "+max);
      System.out.println("min��ġ: ["+minIndex+"]");
      */
 


		
	} // main ����

}
