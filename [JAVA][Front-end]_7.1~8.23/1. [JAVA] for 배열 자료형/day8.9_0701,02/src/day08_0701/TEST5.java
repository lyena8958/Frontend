package day08_0701;

import java.util.Scanner;

public class TEST5 {
	/*
	 * 정수 1개입력: 5
[ _ _ _ _ _ ] 배열 생성

정수값을 입력해서 저장해주세요.
[ 10 6 6 11 7 ]

원하는 수를 입력: 5
  5는 없습니다.
원하는 수를 입력: 6
  6은 1 2  번 인덱스에 존재합니다.
	 * */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 1개입력: ");
		int num=sc.nextInt();
		int [] arr= new int[num];


		// 배열 생성!!
		for(int i = 0; i < arr.length;i++) {

			arr[i] = sc.nextInt();
		}
		
		System.out.print("[ ");
		// 정수값 입력 -> 배열 저장
		for(int i = 0; i < arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.print("]\n");
		
		int cnt = 0;
		Boolean flag = false;
		// 값을 다 찾을 때 까지 입력
		while(true) {
			int i = 1;

			System.out.print("원하는 수를 입력: ");
			int su = sc.nextInt();
			for(int v : arr) {
				if(su == v) {
					System.out.printf("%d ", i);
					cnt ++;
					flag = true;
				}
				else if(cnt == num) {
					break;
				}
				i++;
				
			}
			if(cnt == num) {
				break;
			}
			if(flag) {
				System.out.println("번 인덱스에 존재합니다.");
			}
			else {
				System.out.println("은(는) 없습니다.");
			}
			
		
		}
		System.out.println("프로그램 종료~");
		
		

	}
}
/* 강사님 답!!!
 * 
 * package day08;

import java.util.Scanner;

public class Test5 {
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.print("정수 1개입력: ");
      int num=sc.nextInt();
      int[] arr=new int[num];
      for(int i=0;i<arr.length;i++) {
         System.out.print((i+1)+"번 정수입력: ");
         arr[i]=sc.nextInt();
      }
      System.out.print("[ ");
      for(int v:arr) {
         System.out.print(v+" ");
      }
      System.out.println("]");
      System.out.print("원하는 수 입력: ");
      int ch=sc.nextInt();
      System.out.print(ch+"는(은) ");
      Boolean flag=false;
      for(int i=0;i<arr.length;i++) {
         if(ch==arr[i]) {
            System.out.print(i+" ");
            flag=true;
         }
      }
      if(flag) {
         System.out.println("번 인덱스에 존재합니다.");
      }
      else {
         System.out.println("없습니다.");
      }
   }
}
// ctrl+A : 전체선택
// ctrl+I : 정렬







+
 * 
 * */

