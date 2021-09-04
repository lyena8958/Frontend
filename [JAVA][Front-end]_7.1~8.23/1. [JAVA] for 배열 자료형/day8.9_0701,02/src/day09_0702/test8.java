package day09_0702;

import java.util.Scanner;

public class test8 {

	public static void main(String[] args) {
		// 요약 : nextline을 사용하려면 앞에 공백이 없게 만들어야한다~~~~
		// next: 띄어쓰기 출력x	, nextline: 띄어쓰기 출력o
		Scanner sc = new Scanner (System.in);
		
		// char타입의 입력
		// 문자열 중에서 가장 첫번째문자 한개만 따로 저장
		
		int i = sc.nextInt();
		System.out.println(i);
		// 위 정수 출력하면 nextline앞에 아무 값이 없어서 오류가 나온다.
		char c = sc.nextLine().charAt(0); // 문자열 중 한개문자 저장- charAt(문자열의 index)
		// 일종의 문자배열
/*
		// nextLine : 공백이 포함된 문자열 입력가능 (단, 앞의 정수를 입력했을 경우 buffer에 null값이 남아있어 제거해줘야한다) 제거: sc.nextLine();
		// next : 공백이 없는 문자열만 입력가능 (띄어쓰기가 된 문자열 출력 불가)
		
		System.out.println("정수입력: ");
		int i = sc.nextInt();
		sc.nextLine(); // i에서 입력되고 버퍼에 남은 빈공간 값을 제거하는 역할 // nextLine()을 사용하고 싶을 때
		System.out.println("문자입력: ");
		//String str=sc.next();
		String str=sc.nextLine();
		System.out.println(i+" "+str);
		
		// 문자열은 next()로 입력받는다.
		//String str=sc.next(); // 띄어쓰기 전 값만 나오지만, 앞에서 정수를 입력시 값이 잘출력된다.(buffer)
		
		String str= sc.nextLine(); // 띄어쓰기까지 나오지만, 앞에서 정수 입력시 값이 입력이안된다.
		System.out.println(str);
	*/	
	}

}
