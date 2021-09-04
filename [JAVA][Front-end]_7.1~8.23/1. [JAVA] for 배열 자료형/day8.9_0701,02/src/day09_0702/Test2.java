package day09_0702;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
//		배열1)
//
//		정수를 1개입력 5
//
//		[ 1 2 3 4 5 ] 배열공간을 생성
//
//		5 4 3 2 1 이 저장되었습니다!
		
		// 강사님의 답!
	      Scanner sc=new Scanner(System.in);
	      
	      System.out.print("배열의 크기입력: ");      
	      int n=sc.nextInt();
	      int[] arr=new int[n];
	      
	      Random rand=new Random();
	      
	      for(int i=0;i<arr.length;i++) {
	         arr[i]=rand.nextInt(6)+1;
	         // rand()%6 + 1
	      }
	      
	      for(int i=arr.length-1;i>=0;i--) {
	         System.out.print(arr[i]+" ");
	      }

		/* 예나
		System.out.print("정수를 1개입력: ");
		int num1 = sc.nextInt();
		
		// 배열생성
		int [] arr1 = new int[num1];
		
		// 배열 초기화
		int numCnt = num1+1;
		
		for(int i = 0; i< arr1.length; i++) {
			arr1[i] = (num1)-i;
			System.out.print(arr1[i]+" ");
		}
		System.out.print("이 저장되었습니다!\n\n");*/
		

	}

}
