package day17_0720;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		
		// [예외 처리]
		
		// 예외 Exception
		Scanner sc = new Scanner(System.in);
		int act = sc.nextInt();

		// java.util.InputMismatchException
		// : 어떤 예외인지?
		// Test5.java:13
		// : 발생한 코드의 지점!
		
		int[] arr = new int[3];
		System.out.println(arr[act]);
		// java.lang.ArrayIndexOutOfBoundsException: 3
		
		
		int a = 10;
		int b = 0;
		try{// 오류대상
			System.out.println("ㅇㄱㅇㄱ");//출력o
			System.out.println(a/b);//예외가 없으면 이어서 코드수행한다.
			System.out.println("여기여기");//출력x
		}catch(ArithmeticException e) {// 어떤 타입의오류?
			e.printStackTrace();
			System.out.println(e.getMessage()); //오류의 설명
			System.out.println("/ by zero"); // 오류되면>대체값으로 실행
		}catch(Exception e) {// 알수없는 예외가 생기게되면(인셉션이 최상위클래스로 ,지정)
			System.out.println("알수없는예외발생!");
		}
		finally {
			System.out.println("항상 수행되는 구간");
		}
		//System.out.println(a/b);
		//  java.lang.ArithmeticException: / by zero
		
		// 입센션이 위로 올라가야한다. 인셉션이모든 오류의 최종클래스이므로
//		try{
//			System.out.println("ㅇㄱㅇㄱ");
//			System.out.println(a/b);
//			System.out.println("여기여기");
//		}catch(Exception e) {
//			System.out.println("알수없는예외발생!");
//		}
//		catch(ArithmeticException e) {
//			System.out.println("/ by zero");
//		}
		
		System.out.println("확인!");
		
		// 예외
		// : 문법적 문제xxx(코드자체에는 문제가 없다.)
		// : 실행이 가능한 코드(문법적 문제없을 때 실행 자체가 가능한)
		// : 실행을 진행하면 문제가 발생! (==실행시에 문제가 발생했다.)
		// => 예외가 발생하게되면, 프로그램이 즉시 종료됨!
		//     카트라이더를 하다가 와이파이가 끊겨서 팅기는 것을 막기위함
		
		// 예외처리
		// : 실행중에 문제가 발생하더라도, 
		// 프로그램을 끝까지 수행하고싶을때 사용!
		
		// 1. 예외처리가 발생하면
		// 가장먼저 오타를 확인한다.
		// 2. 예외를 *메모장에 저장,
		// 어떻게 처리하는지 구글링한다.
		
		// try-catch문
		// 
		
		
	}

}
