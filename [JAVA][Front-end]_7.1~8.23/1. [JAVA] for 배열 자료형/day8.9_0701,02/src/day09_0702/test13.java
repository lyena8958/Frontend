package day09_0702;

//*페이지를 코드화한 것
public class test13 {

	// 사용자 정의 함수
	// 함수명 중복정의를 허용해보자!!!!!!
	//   조건: 같은 알고리즘(로직), 기능
	//		: input,매개변수,인자의 개수/자료형이 다르거나,
	//		: output, return,반환값의 자료형이 다르면
	// 함수명 중복정의 허용!!!!!
	// == "오버로딩" ★☆★☆ (.print하면 -> 같은 함수가 좌르륵 나오는데 그걸 뜻함)
	
	static int func(int a, int b) {
		System.out.println("함수1");
	// static : 프로그램수준으로~ (안붙이면 객체로 구별하여 함수못만듬)
		return a+b; // 즉시종료
	}
	// "모호성이 발생되면 에러!"
	static int func(int a, int b,int c) {
		System.out.println("함수2");
	// static : 프로그램수준으로~ (안붙이면 객체로 구별하여 함수못만듬)
		return a+b+c; // 즉시종료
	}
	
	static double func(double a, double b) {
		System.out.println("함수3");
		return a+b;
	}
	
	static double func(double a, double b,double c) {
		System.out.println("함수4");
		return a+b+c;
	}
	
	public static void main(String[] args) {
		
		int x = 10;
		int y = 20;
		int z = 30;
		System.out.println(func(x,y,z));
		

		
		
	}

}//*//
