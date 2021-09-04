package stuView;

import java.util.InputMismatchException;
import java.util.Scanner;

class MyException extends Exception {
	MyException(String msg) {
		super(msg);
	}
}

public class StuView {
	// 기본생성자 사용
	Scanner sc;
	MyException excp;
	public int kor;
	public int math;
	public int eng;
	public String name;

	public void numLimit(int num) throws MyException {
		MyException excep = new MyException("[입력오류]1~100사이로 처음부터 다시 입력해주세요!");
		if (num < 1 || 100 < num) {
			throw excep;
		}
	}

	public void viewStart() {// 시작부분(점수입력, 예외오류처리)
		sc = new Scanner(System.in);
		while (true) { // 올바르게입력할때까지 반복
			// 입력을 저장할 변수(이름, 과목별성적)
			String name;
			int kor, math, eng;
			try {// 과목별 점수 입력 및 예외처리(+정의예외)
					// 안내멘트
				System.out.println("=========성적 프로그램=========");
				System.out.println("성함과 과목에 맞게 점수를 입력하세요.");
				System.out.println();

				System.out.print("이름: ");
				name = sc.next(); // 이름 입력

				// 점수입력 //오류발생시 처음부터 다시입력
				System.out.print("국어점수: ");
				kor = sc.nextInt(); // 점수입력
				numLimit(kor); // 지정예외처리 함수호출!

				System.out.print("수학점수: ");
				math = sc.nextInt();
				numLimit(kor);

				System.out.print("영어점수: ");
				eng = sc.nextInt();
				numLimit(kor);
			} catch (InputMismatchException e) {// 타입오류(ex int<>str)
				sc.nextLine(); // 버퍼제거
				System.out.println("[입력오류]타입오류!!");
				System.out.println("============================\n\n");
				continue;
			} catch (MyException e) {// 지정예외처리(1~100값)
				System.out.println(e.getMessage());
				System.out.println("============================\n\n");
				continue;
			} catch (Exception e) {
				System.out.println(e.getMessage() + " 오류발생");
				System.out.println("============================\n\n");
				continue;

			}
			// 오류가 발생안되어 정상적으로 입력했다면 -> 멤버변수에 저장
			this.kor = kor;
			this.math = math;
			this.eng = eng;
			this.name = name;
			break;
		}
	}

	public void showRes(String grade, double avg) {// 결과출력(인자는 model에서 받아옴)
		System.out.print(this.name + "님의 결과"); // 대상자 이름출력
		for (int i = 0; i < 5; i++) {// . 부분 1초당 한개씩 ->총 5번 출력
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("오류발생!");
			}
			System.out.print(". ");
		}
		System.out.printf("\n평균: %.1f\t", avg); // 평균값 출력
		System.out.print("[" + grade + "]!!\n"); // 결과값 출력
		System.out.println("==========================\n\n");

	}

}
