package day09_0702;

import java.util.Random;
import java.util.Scanner;

public class test12_����Դ� {
	public static void main(String[] args) {

      // ����-->�˻�
      // �̺а˻�==����Ž��
      
      int[] data=new int[10];
      Random rand=new Random();
      for(int i=0;i<data.length;i++) {
         data[i]=rand.nextInt(10)+1;
         for(int j=0;j<i;j++) {
            if(data[i]==data[j]) {
               i--;
               break;
            }
         }
      }
     // �񱳼���
      for(int i=0;i<data.length-1;i++) {
         for(int j=0;j<data.length-1;j++) {
            // �񱳼���
            if(data[j] > data[j+1]) {
               int tmp=data[j];
               data[j]=data[j+1];
               data[j+1]=tmp;
            }
         }
      }
      
      
      
      for(int v:data) {
         System.out.print(v+" ");
      }
      
      System.out.println();
      
      
      Scanner sc=new Scanner(System.in);
      System.out.print("ã�°��Է�: ");
      int value=sc.nextInt();
      
      
      int l=0,h=data.length-1; //low high
      while(l<=h) {
			// cross(��������)�� �߻��ϸ�, ����
			//�������� �����ؾ���
			int m=(l+h)/2; // middle �߰����� ���ϱ� ����(0+9)/2 = [4]
         if(data[m]==value) {
            System.out.println("["+m+"]�� ����!");
            break;
         }
         else if(data[m]<value) {
            l=m+1; // �ϴܰ��� ����
         }
         else {
            h=m-1; // m:5 �׷���, 1~4���� �ȳ��ؾ��ϴ� -1�� ����� �Ѵ�!!
         }
         //���Կ����� �������� ������ �ٲ������.
         System.out.println(l+"Ȯ��"+h);
         	
      }
      
      if(l>h) {
         System.out.println("������...");
      }
   
		
		
		
		
		
	}
}
