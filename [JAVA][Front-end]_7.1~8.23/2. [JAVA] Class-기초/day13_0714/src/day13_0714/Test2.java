package day13_0714;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		int[] randNum = new int[10];
		Random rand = new Random();
		for(int i = 0; i < randNum.length;i++) {
			randNum[i] = rand.nextInt(100)+1; // 1~100
		}
		// forEach��==���� for��
		for(int v:randNum) {
			// v�� randNum���հ��� �ȿ��ִ� ���� ������ ��!!!
			System.out.print(v+" ");
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���° �����?");
		int k;
		do {
			k = sc.nextInt();
		}while(k<1 || randNum.length<k);
		System.out.println(randNum[k-1]);
	} // main����

}
