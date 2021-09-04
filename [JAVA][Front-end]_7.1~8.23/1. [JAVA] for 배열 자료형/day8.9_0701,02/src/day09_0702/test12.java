package day09_0702;

import java.util.Random;
import java.util.Scanner;

/* 정렬알고리즘 : 이분검색 == 이진탐색 하기@@
1) 랜덤으로 값 10개 생성(정수,1~100) - 중복없이하려고 범위를 넓게잡음!
2) ☆정렬 먼저! 진행해야함
3) 이분검색 알고리즘을 구현해주세요!~~ */
public class test12 {
	public static void main(String[] args) {
	Random rand = new Random();
	Scanner sc = new Scanner(System.in);
	
	int[] Data = new int[10];
	
	// 10개의 값 0~100사이 랜덤으로 지정
	for(int i = 0;i<Data.length;i++) {
		Data[i] = rand.nextInt(100)+1; // 1~100
		for(int j = 0; j<i;j++) {
			if(Data[j]==Data[j+1]) {
				System.out.println("확인"+Data[j]+" "+Data[j+1]);
				int tmp = Data[j];
				Data[j] = Data[j+1];
				Data[j+1] = tmp;
			}
		}
	}
	
	// 정렬
	for(int i = 0; i < Data.length-1;i++) {
		for(int j= 0; j<Data.length-1;j++) {
			if(Data[j] >Data[j+1]) {
				int tmp = Data[j];
				Data[j] = Data[j+1];
				Data[j+1] = tmp;
			}
		}
		
		int min = 1, max = 100;
		int[] value = new int[10];
		
		while(true) {
			System.out.print("숫자를 입력해주세요 ");
			int ans = sc.nextInt();
			
			if(ans>max) { // 범위 값 넘어가면 프로그램 종료 조건문
				System.out.println("범위에 초과된 숫자를 입력하여 프로그램이 종료됩니다.");
				break;
			}
			// 내림차순 값부터 반복 1 55 66 77 //value[i1] = ans;
			for(int i3 = 0; i3<Data.length;i3++) {
				
				if(ans==Data[i3]) {
					value[i3] = Data[i3];
				if(Data[Data.length-1] < ans) {
						max = ans;
						
						}
					else {
						min = ans;
					}
				break;
				}
			}
			}
			//지금까지 맞춘 답 출력
			int Cnt = 0; //맞춘갯수 카운트
			System.out.print("[ ");
			for(int i2 = 0; i2 < value.length;i2++) {
				
				if(value[i2]>0) {
				System.out.print(value[i2]+" ");
				Cnt++;
				}
				else {
					System.out.print("_"+" ");
				}
				
			}
			if(Cnt == 10) {
				break;
			}
			System.out.println("]");
			System.out.println(min+" ~ "+max+"사이에 있습니다!");
			
			
			
			
			
			
		}
		  
	

	} //main종료

}
