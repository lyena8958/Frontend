package day09_0702;

import java.util.Scanner;

public class test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("안녕하세요!");
		int i = sc.nextInt(); // 123
		System.out.println("i= "+i+1); // 1231

		// 연산자 우선순위
		// 디버깅표

		// 조건문
		// 선택적으로 작업이 수행될때 사용

		// 반복문
		// while VS for 
		// 반복횟수를 모르거나, 무한(종료조건 필수!), ~~할때까지 계속 → "while"
		// 분명할때, N번, A회, a~b까지(범위), 배열과 함께 → "for

while(true) {
	System.out.println("확인");
	if(true) {
		break;
	}
}
	
// 배열
// int[] arr = new int[N];
// arr.length
// forEach문 - > v에 배열의 값이 복사된다
// for(v:arr)


	}// 메인종료
}

