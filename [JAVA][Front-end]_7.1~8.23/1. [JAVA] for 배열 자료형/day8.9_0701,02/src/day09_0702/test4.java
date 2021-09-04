package day09_0702;

import java.util.Scanner;

public class test4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr= new int[3];
		for(int i = 0; i < arr.length;i++) {
			arr[i] = i+1;
			// 원본!
		}
		
		// value만 본다. 원본 값은 유지가 된다
		for(int v:arr) {
			// v는 arr의 데이터들의 복사본일뿐!
			v+=2;
			System.out.println(v);
		}
		for(int v:arr) {
			// 원본값과 같다 
			System.out.println(v);
		}
		
		for(int i = 0; i < arr.length;i++) {
			System.out.println(arr[i]);
		}
		

	}// main 종료

}
