package day13_0714;

import java.util.Random;
import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("n�� �Է��ϼ���.");
		int n= sc.nextInt();
		int[] data = new int[n];

//		Random rand = new Random();
//		for(int i = 0; i < data.length;i++) {
//			data[i] = rand.nextInt(9)+1; // 1~9
//		}
		
		//while vs for
		int j = 0;
		while(j<data.length) {
			System.out.println((j+1)+"��°�Է�");
			data[j] = sc.nextInt();
			// "continue�� ���� j�� ������ 0�� �ƴϴ�."
			// data[j-1]>data[j] && j!=0 -> �ϸ� ������ ��?? �������� �������� ���ϱ⶧���� -1�� �ɸ��ϱ�.
			// �ٵ� �Ʒ�ó���ϸ� 0&&�ϱ� �ٷ� false���� ������ �����Ű������
			if(j!=0 && data[j-1]>data[j]) { // �������� �Է��� �ƴ϶��,
				continue;
			}
			j++;
		}
		
		
		for(int v: data) {
			System.out.print(v+" ");
		}
		System.out.println();
		
		System.out.println("k(ã������ ��)�� �Է��ϼ���.");
		int k = sc.nextInt();
		
		for(int i = 0; i < data.length;i++) {
			if(data[i]>=k) {
				System.out.println(i+1);
				break;
			}
		}
	}

}
