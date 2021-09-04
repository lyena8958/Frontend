package day16_0719_2;

import java.util.Scanner;
import java.util.Stack;

public class stack {
	// Stack
	// 채점프로그램 
	// 1) 몇번 채점을 시도하는지 입력 (5번 입력) 1 2 4 0 0 5 6
	// 2) 1~10까지 입력가능 단, 0을 입력하면 "실행취소"
	// 실행취소할 액션이 남아있나?
	// 3) 5번의 총합 출력
	public static void main(String[] args) {
		// stack 채점 프로그램
		// 실행취소? -> stack!!!!

		Stack<Integer> s = new Stack();
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		while(s.size()<cnt) {
			System.out.println("점수입력");
			int num = sc.nextInt();
			if(1<=num&&num<=10) {
				s.push(num);
				System.out.println("채점완료!");
			}
			else if(num==0) {
				if(s.size()==0) { // 삭제할 데이터가없다면
					System.out.println("삭제할 데이터없음!");
					continue;
				}
				s.pop(); // 삭제를 동반한 출력
			}
			else {
				System.out.println("다시입력!!");
			}
		}
		int sum = 0;
//		while(s.size()!=0) {
//			sum+=v;
//		}
		for(int v: s) {
			sum+=v;
		}
		System.out.println(sum);
		
	}//main종료

}
