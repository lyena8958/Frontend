package day13_0714;

import java.util.Random;
import java.util.Scanner;

public class Test6 {
static int NumCheck(int a, int num) {
	Scanner sc = new Scanner(System.in);
	while(true) {
		if(num<a) {
			System.out.println("���ڸ� �߸��Է��ϼ̽��ϴ�. "+a+"�̻����� �Է����ּ���.");
			num = sc.nextInt();
			continue;
		}
		break;
	}
	return num;
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 ž�� ������ �Է��ϼ���.
		5
 		��, ž�� ������ 0����xxx
		5���� ž�� ���̸� �Է��ϼ���. 6 9 5 7 4 [ 0 0 2 2 4]
		1: 6
		2: 9
		3: 5
		4: 7
		5: 4
 		��, ���̴� 0����xxx
		=> [ 0 0 2 2 4 ] */
		
		// ������� ��
		System.out.println("ž�� ������ �Է��ϼ���.");
		int n = sc.nextInt();
		
		int[] data = new int[n];
		Random rand = new Random();
		
		for(int i = 0; i < data.length;i++) {
			data[i] = rand.nextInt(9)+1; // 1~9
		}
		
		for(int v:data) {
			System.out.print(v+" ");
		}
		System.out.println();
		/* �迭
		int[] res = new int[n];

		for (int a = data.length-1; a >= 0; a--) {
			// data[4]�� �������� ����!
			for (int i = a-1; i >= 0; i--) {
				if (data[a] <= data[i]) { // ������ ũ�ų� ���� ž�� ������,
					res[a] = i + 1;
					break;
				}
			}
		}
		
		for(int v:res) {
			System.out.print(v+" ");
		}*/
		
		// ����
		for (int a = 0; a <data.length; a++) { // ������ ��� ������ �״�� �ϸ� ���� �ݴ�� ��µȴ�.
			int pos= 0; //������
			for (int i = a-1; i >= 0; i--) {
				if (data[a] <= data[i]) { // ������ ũ�ų� ���� ž�� ������,
					pos = i + 1;
					break;
				}
			}
			System.out.print(pos+" ");
		}
		
		/* ����
		System.out.println("ž�� ������ �Է��ϼ���.");
		int num = NumCheck(1,sc.nextInt());
		
		int[] NumArr = new int[num];
		
		for(int i = 0; i < NumArr.length;i++) {
			System.out.println((i+1)+"��° ž�� ���̸� �Է��ϼ���");
			NumArr[i] = NumCheck(1,sc.nextInt());
		}
		
		int[] NumIndex = new int[num]; // ������ �ε����� ��ȣ�� ����
		
		for(int i = num-1; i > 0; i--) {
			for(int j = i-1; j >= 0; j--) {
			if(NumArr[i] <NumArr[j]) {
				NumIndex[i] = j+1;
				break;
			}
		}
	}
		System.out.print("[ ");
		for(int v: NumIndex) {
			System.out.print(v+" ");
		}
		System.out.println("]");
		*/

}//main����
}