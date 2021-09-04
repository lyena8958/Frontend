package day10_0705;

import java.util.Random;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		
		// 배열의 개수를 입력: 10
		// [ 1 2 3 4 1 2 3 4 1 1 ]
		// 랜덤으로 값을 1~5까지 생성
		/*
		 *1: 4 
		 *2: 2
		 *3: 2
		 *4: 2
		 */
		
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("배열의 개수를 입력: ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		System.out.print("[ ");
		for(int i = 0; i < arr.length;i++) {
			arr[i] = rand.nextInt(5)+1; // 1~5까지 랜덤으로 생성
			System.out.print(arr[i]+" ");
		}
		System.out.println("]");
		
		// ★강사님 답★
//	     System.out.print("배열개수입력: ");
//	      int num=sc.nextInt();
//	      int[] data=new int[num];
//	      for(int i=0;i<data.length;i++) {
//	         data[i]=rand.nextInt(5)+1;
//	      }
//	      System.out.print("[ ");
//	      for(int v:data) {
//	         System.out.print(v+" ");
//	      }
//	      System.out.println("]");

		// *1) 정보를 "출력"
//		for(int i = 1; i <= 5; i++) {
//			int cnt = 0;
//			for(j = 0; j < arr.length; j++) {
//				if(i==data[j]) {
//					cnt++;
//				}
//			}
//			if(cnt == 0) {
//				continue;
//			}
//			System.out.println(i+": "+cnt);
//		}
		
		// *2) 정보를 "저장" -> 출력
//		int[] cntData = new int[5];
//		// 1~5까지 몇개인지를 저장하는 배열

//		for(int i = 0; i < arr.length; i++) {
//			cntData[arr[i]-1]++;
//		}
//		
//		for(int i = 0; i < cntData.length; i++) {
//			if(cntData[i]==0) {
//				continue;
//			}
//			System.out.println((i+1)+": "+cntData[i]);
//		}
		
		
		// ★예나★
		int[] cnt = new int[num];
		for(int i = 0; i < arr.length;i++) {
			cnt[arr[i]-1]++;
		}
		
		
		for(int i = 0; i < cnt.length; i++) {
			
			if(cnt[i]==0) {
				continue;
			}
			System.out.println((i+1)+": "+cnt[i]);
			
		}
		
		
		
		
	} // main종료

}
