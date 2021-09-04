package day10_0705;

import java.util.Random;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// Scanner -> 클래스 (앞이 대문자면 클래스다.)
		System.out.print("배열개수입력: ");
		int num = sc.nextInt();
		
		int[] data = new int[num];
		// new연산자
		// heap 메모리영역 사용 -> 동적인 영역
		// 자동초기화, 프로그램실행이후에도 이용가능한 공간
		
		Random rand = new Random();
		for(int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(100)+1; // 0~99 -> 1~100
		
		}
		System.out.print("[ ");
		for(int v:data) {
			System.out.print(v+" ");
		}
		System.out.println("]");

		// 오름차순 정렬 == 버블정렬
		for(int i = 0; i < data.length-1;i++) { // data.length 만 해도 상관 ㄴㄴ
		//버블정렬을 데이터 개수만큼 회전하자!
			for(int j = 0; j<data.length-1;j++) {
				// 비교수행은 [데이터개수-1]번 !!!!
				if(data[j] > data[j+1]) { // 앞수>뒷수
					// 교환은 선택적 수행임에 유의 -> if
					int tmp = data[j];
					data[j] = data[j+1];
					data[j+1] = tmp;
				}
			}
		}
		
		System.out.print("[ ");
		for(int v:data) {
			System.out.print(v+" ");
		}
		System.out.print("] ");
		
	}//main 종료

}
