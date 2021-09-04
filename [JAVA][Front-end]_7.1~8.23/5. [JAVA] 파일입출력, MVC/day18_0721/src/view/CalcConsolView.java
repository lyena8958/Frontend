package view;

import java.util.Scanner;

public class CalcConsolView {
	// view자체가 멈추지않게 코딩
	// view는 1회. 무한하게 호출
	Scanner sc;
	public int n1;
	public int n2;
	public String op;
	// cont'r에서 값을 가져오기 위한 멤버변수
	
	public CalcConsolView(){
		sc=new Scanner(System.in); //메소드에 넣어도됨
	}
	public void startCalc() {
		System.out.println("정수1입력: ");
		n1 = sc.nextInt();
		System.out.println("정수2입력: ");
		n2 = sc.nextInt();
		System.out.println("연산자입력: ");
		op = sc.next();
	}
	public void showRes(int res) {
	System.out.println("결과는 "+res+"입니다.");
	}
}
