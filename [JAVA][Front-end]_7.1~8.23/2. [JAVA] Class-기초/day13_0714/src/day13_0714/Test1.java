package day13_0714;

import java.util.Scanner;

public class Test1 {
	/*
	�޴� 5��
	1.ġ����� 400
	2.��ä���� 340
	3.���� 170
	4.������� 100
	5.������ 70
	�޴��� 2�� ����
	���� 500���� ũ�� angry, no angry

	1. �迭 ����
	 - ���� ���õ� �������ΰ�?
	 - ���� �ڷ����ΰ�?
	 - ����� ������ ��Ȯ�� �˰��ֳ�?
	=> �޴��� String[] / Į�θ� int[]

	Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
	   at test.Test1.main(Test1.java:25)
	=> ArrayIndexOutOfBoundsException  ���۸�
	   : 2  �ش��ε����� �ǵ�Ȱ�,(�湮) �� �ε����� �����ϴ�.
	   (Test1.java:25)  �ڵ��� ��� ���ο��� �߻��� ���������� �������!
	*/
   public static void main(String[] args) {
            
      String[] menuName=new String[2];
      // �޴����� ����� �迭
      int[] menuKcal=new int[2];
      // �޴��� Į�θ��� ����� �迭
      Scanner sc=new Scanner(System.in);
      for(int i=0;i<menuName.length;i++) {
         System.out.println((i+1)+"��° �޴����Է�");
         menuName[i]=sc.next();
         System.out.println("Į�θ���?");
         menuKcal[i]=sc.nextInt();
      }
      
      System.out.println("�޴��� 2�� �����ϼ���.");
      // tip. �迭 vs ���� -> �ϴ� ��������ض�.
      int a,b;
      do {
         System.out.println("1�� �޴��Է���...");
         a=sc.nextInt();
      }while(a<1||a>menuName.length);
      // 1���� ���� �޴��� ����.
      // �޴��������� Ŭ���� ����.
      do {
         System.out.println("2�� �޴��Է���...");
         b=sc.nextInt();
      }while(b<1||b>menuName.length);
      
      int i=0;
      int sum=0;
      while(i<2) {
         System.out.println((i+1)+"�� �޴��Է���...");
         a=sc.nextInt();
         if(a<1 || a>menuName.length) {
            continue;
         }
         sum+=menuKcal[a-1];
         i++;
      }
     
      // sum���� ��ü����!
      if(menuKcal[a-1]+menuKcal[b-1]>500) {
         System.out.println("angry");
         // Į�θ��� ���Ϸ��� �ϴµ�..!
         // 1,2 -> [?],[?] ���ǿ��� ����� ������ ��ȣ-1 == [�ε���]
      }
      else {
         System.out.println("no angry");
      }
      
      
   }

}
