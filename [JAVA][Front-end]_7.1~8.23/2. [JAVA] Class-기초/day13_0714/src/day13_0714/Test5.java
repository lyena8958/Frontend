package day13_0714;

import java.util.Random;
import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("n을 입력하세요.");
		int n= sc.nextInt();
		int[] data = new int[n];

//		Random rand = new Random();
//		for(int i = 0; i < data.length;i++) {
//			data[i] = rand.nextInt(9)+1; // 1~9
//		}
		
		//while vs for
		int j = 0;
		while(j<data.length) {
			System.out.println((j+1)+"번째입력");
			data[j] = sc.nextInt();
			// "continue를 당한 j는 무조건 0은 아니다."
			// data[j-1]>data[j] && j!=0 -> 하면 오류남 왜?? 좌측에서 우측으로 비교하기때문에 -1이 걸리니까.
			// 근데 아래처럼하면 0&&니까 바로 false으로 조건을 실행시키지않음
			if(j!=0 && data[j-1]>data[j]) { // 오름차순 입력이 아니라면,
				continue;
			}
			j++;
		}
		
		
		for(int v: data) {
			System.out.print(v+" ");
		}
		System.out.println();
		
		System.out.println("k(찾으려는 수)를 입력하세요.");
		int k = sc.nextInt();
		
		for(int i = 0; i < data.length;i++) {
			if(data[i]>=k) {
				System.out.println(i+1);
				break;
			}
		}
	}

}
