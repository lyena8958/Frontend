package day09_0702;

import java.util.Random;
import java.util.Scanner;

public class test9 {

	public static void main(String[] args) {	
		/*�⼮�� ���α׷�

		����� �л�: 3
		   => �̸� �Է�(�̸��� ����� �迭)
		�����Ⱓ: 5

		1: �⼮ 0 : �Ἦ ( ���� ���� �ص� ����)
		day1) 1���л�: 1
		2���л�: 0
		3���л�: 1

		1) ���� day�� �⼮�� (�Ǽ�) ���
		2) ������ �л��� �⼮�� (�Ǽ�) ��¤�
		3) �⼮���� 80%�̸��� �л��� ����
		   => ����ó���� �л��� �̸����!~~~
		   */

	      Scanner sc=new Scanner(System.in);
	      
	      System.out.print("�л����Է�: ");
	      int stu=sc.nextInt();
	      
	      String[] stuName=new String[stu];
	      for(int i=0;i<stuName.length;i++) {
	         System.out.print((i+1)+"�� �л��̸��Է�: ");
	         stuName[i]=sc.next();
	      }
	      
	      
	      System.out.print("��¥�Է�: ");
	      int day=sc.nextInt();
	      
	      Random rand=new Random();
	      
	      // 1) data[day][stu]
	      // 2) data[stu][day] �̰ɷ� ����!��
	      int[][] data=new int[stu][day];
	      for(int i=0;i<day;i++) {
	         System.out.println("day"+(i+1));
	         int dayCnt=0;
	         for(int j=0;j<stu;j++) {
	            System.out.print((j+1)+"���л�: ");
	            data[j][i]=rand.nextInt(2);
	            if(data[j][i]==1) {
	               System.out.println("�⼮");
	               dayCnt++;
	            }
	            else {
	               System.out.println("�Ἦ");
	            }
	         }
	         System.out.println("day"+(i+1)+" �⼮��: "+(dayCnt*100.0/stu)+"%");
	      }
	      
	      for(int i=0;i<stu;i++) {
	         int stuCnt=0;
	         for(int j=0;j<day;j++) {
	            if(data[i][j]==1) {
	               stuCnt++;
	            }
	         }
	         double check=stuCnt*100.0/day;
	         System.out.println((i+1)+"���л� �⼮��: "+check+"%");
	         if(check<50.0) {
	            System.out.println(stuName[i]+"�л� ����ó��...");
	         }
	      }


		/* ����
		System.out.print("�л� �ο���:");
		int stu = sc.nextInt();
		
		System.out.print("�����Ⱓ �����Է�(1�� = 1): ");
		int studay = sc.nextInt();

		int[][] StuArr = new int[stu][studay];
		String[] name = new String[stu];
		
		// �л����� �̸� ����
		for(int i = 0; i < name.length;i++) {
			System.out.print((i+1)+"�� �л��� "+"�̸��� �Է��ϼ���: ");
			name[i] = sc.next(); // �̸����� ���ǹ� �������ҵ�
			System.out.print(" ");
		}
		
		double[] AvgArr = new double[stu];
		
		for(int i = 0; i < StuArr.length;i++) {
			
			for(int j = 0;j<StuArr[i].length;j++) {
				
				StuArr[i][j] = rand.nextInt(2); // 0~1����
				AvgArr[i] += StuArr[i][j];
				System.out.println((i+1)+"�� �л�"+(j+1)+"�� �⼮: "+StuArr[i][j]);
			}
			AvgArr[i] /= studay*1.0; // ���
			AvgArr[i] *= 100; // �⼮��
			System.out.println((i+1)+"�� �л��� �⼮��"+AvgArr[i]);
			System.out.println();
		}
		
		for(int i = 0; i < AvgArr.length;i++) {
			
			if(AvgArr[i]<80) {
				System.out.println("�⼮�� 80% �̸����� ����ó���� �� �л��� "+name[i]+" �Դϴ�.");
			}
			
		}*/ 
		


	} //main ����

}
