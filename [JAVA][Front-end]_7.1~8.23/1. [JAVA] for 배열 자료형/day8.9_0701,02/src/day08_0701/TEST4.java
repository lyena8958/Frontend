package day08_0701;

import java.util.Scanner;

public class TEST4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �迭 ����
		// Stack vs Heap
		//  Stack : ����Ÿ���� ��������� ���� (int, char, double....)
		// vs Heap : "�������� ����", ���α׷��� ����� ���Ŀ��� ���� �̿밡��
		//	 new �����ڸ� �̿��Ͽ� ���� Ȯ��, �ʱ�ȭ�� �Ǿ� ���� (new�� �����Ⱚ�� �ƴѰ� ����ִ�.)
		
	      System.out.print("�л����Է�: ");
		
		// �� �� ����
	      int stu=sc.nextInt();
	      int[] arr=new int[stu];
	      for(int i=0;i<stu;i++) {
	         System.out.println((i+1)+"�����: "+arr[i]);
	      }

		// length ���
		// ��Ұ� ����� ��Ծ���! ����.������ ���ÿ�� ���� (length)
	      for(int i=0;i<arr.length;i++) {
	          arr[i]=i+1;
	       }


		//forEach == ���� for��
		//  for(���տ� ����� �������� Ÿ��:�������� ����)
	      //�ε��� ->int i =0;
	      for(int v : arr) {
	    	  // �ε����� ã�� ��ƴ�!
	          System.out.println(v);
	          // �ε��� -> [i++;]
	       }

		
		
		
	}

}
