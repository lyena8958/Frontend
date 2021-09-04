package day08_0701;

import java.util.Scanner;

public class TEST2 {

	public static void main(String[] args) {
		
		// 입력
		Scanner sc = new Scanner(System.in); 
		// Ctrl+shift+o : 자동임포트
		// scanner== sc* 
		// 유틸이라는 상자안의 스캐너 -> sc라는 객체화 -> new라는 연산자 오른편()에는 인자를 받음
		
		
		System.out.print("정수입력: "); // 커서를 같은 칸에 입력할때 print
		int i =sc.nextInt();
		System.out.println("입력한 정수는 "+i+"입니다.");
		// 내가만들어낸 객체 스캐너 별명지는 -> sc 로 활용
		
		

		
	}

}
