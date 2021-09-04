package day09_0702;

import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		배열2)
//		정수를 1개입력 6
//		[ 1 2 3 4 5 6 ] 배열공간을 생성
//		정수를 1개입력 2
//		[ 5 6 1 2 3 4 ] 오른쪽으로 >> 2칸 이동!
		
		// 강사님의 답!
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배열크기입력: ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length;i++) {
			arr[i] = i+1;
		}
		System.out.print("몇칸이동? ");
		int move = sc.nextInt();
		//move %= num; // 움직임 횟수를 줄이기 위함
		
		// -입력에 대해서는 -2 == 4 과 같다. 
		
		//	if(move < 0) {
		//		move += num; 
		//	}
		
		int[] res = new int[num];
		for(int i = 0; i < arr.length;i++) {
			res[(i+move)%num] = arr[i];
		}
		
		
		/* 예나 다못품
		System.out.print("정수를 1개입력: ");
		int num2 = sc.nextInt();
		System.out.print("정수를 1개입력: ");
		int move = sc.nextInt();
		
		int [] arr2 = new int[num2];
		
		int[] moveArr = new int[num2];
		// 1~6
		for(int i = 0; i< arr2.length; i++) {
			arr2[i] = i+1;
			System.out.print(arr1[i]+" ");
		}
		
		// 0 ~ 5
		for(int i = 0; i< arr2.length; i++) {
			// 0 ~ 5
			for(int j = 0; j<arr2.length;j++) {
				if(move+j < arr2.length) {
					moveArr[i] = arr2[move+j];	
				}
				else {
					moveArr[i] = arr2[0];
				}
			}}
			for(int i = 0; i<arr2.length;i++) {
					System.out.print(moveArr[i]+" "); 
			}
				
*/
	}

}
