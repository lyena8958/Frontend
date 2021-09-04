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
		// forEach문==향상된 for문
		for(int v:randNum) {
			// v는 randNum집합공간 안에있는 값을 복사한 것!!!
			System.out.print(v+" ");
		}
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("몇번째 볼까요?");
		int k;
		do {
			k = sc.nextInt();
		}while(k<1 || randNum.length<k);
		System.out.println(randNum[k-1]);
	} // main종료

}
