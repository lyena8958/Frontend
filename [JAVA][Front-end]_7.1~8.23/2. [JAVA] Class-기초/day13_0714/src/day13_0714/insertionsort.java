package day13_0714;

import java.util.Random;
import java.util.Scanner;

public class insertionsort {
	// �������� ����
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		System.out.println("������ ������ �Է��ϼ���");
		int n = sc.nextInt();
		int[] data = new int[n]; // ���� ����迭

		// ������ �ο�
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(50) + 1; // 1~50
			System.out.print(data[i] + " "); // ��ǥ��
		}
		System.out.println(); // ������

		// �������� �ι�°�ڸ����� ��(ù�ڸ��� �񱳴����⶧��)
		for (int a = 1; a < data.length; a++) {// �ι�° �ε�������
			int IndexMin = a; // ��� a ����
			for (int i = 0; i < a; i++) { // ó������ ��������� �ݺ�
				// �񱳴���� �� ���ڰ� �۴ٸ� ���� �����Ͽ� �������ش�.(���������̴� �������ڰ� ������ ������)
				if (data[IndexMin] < data[i]) {
					int tmp = data[a]; // �ӽ����庯��
					data[a] = data[i];
					data[i] = tmp;
					IndexMin = i; // �ٲ� ����� ��ġ�� �ε�����ȣ ����(���� ���� ���� ���� ���� ���� ��)	
				}
			}// ���ĵ� �� ���
			for (int v : data) {
				System.out.print(v + " ");
			}
			System.out.println();

		}
			
		/* �̺���
  Random rand = new Random();
      int[] arr = new int[5];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = rand.nextInt(30) + 1;
      }

      /////////////// ���� �迭 ��� //////////////////
      System.out.print("���� �迭 : ");
      for (int v : arr) {
         System.out.print(v + " ");
      }

      ////////////// �������� �˰��� /////////////////
      for (int i = 1; i < arr.length; i++) {          // �迭 �� ���� �Ͽ�
         while (i > 0 && arr[i - 1] > arr[i]) {    // �� ����
            int tmp = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = tmp;
            i--;
         }

      }

      ////////////// ȸ�� ��� ��� /////////////////
      System.out.print("\n ���� �迭 : ");
      for (int v : arr) {
         System.out.print(v + " ");
      }
   }*/

	} // main����
}