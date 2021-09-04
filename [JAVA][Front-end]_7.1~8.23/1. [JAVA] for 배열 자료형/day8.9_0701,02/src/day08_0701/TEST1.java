package day08_0701;
// 자동완성키 : 명령어 치기 전에 Ctrl + Space Bar 누르면 선택해서 누르면 완성
// 실행 단축키 : Run -> Ctrl + F11

public class TEST1 { 
	// 클래스 이름과 public class 나와 있는 이름이 반드시 같아야 한다!!
	// TEST1 == 붕어빵 틀 == Class
	public static void main(String[] args) {
		// void main == c언어와 동일
		// String[] args == 문자열 배열 == 문자열 배열을 매개변수로 받아오겠다.
	
		// 출력
		
		// printf와 동일한 출력프로그램 (근데 이제 \n을 곁들은..)
		System.out.println("안녕하세요!"); // syo만 누르고 자동완성키 누르면 완성!! 
		System.out.println("반갑습니다!"); 	
		// System- java 자체 콘솔, . 누르면 관련 요소들이 보인다.
		
		// 
		int i = 10;
		double d= 3.14;
		char c = 'A'; // 18 -20 line 원시타입 
		String str = "apple";
		Boolean b=true; // or False
		
		// 형식지정자는 사용할 수 있지만, 굳이 안쓰고 아래 형식으로 많이 쓴다!!
		System.out.println("i = "+i);
		System.out.println("d = "+d);
		System.out.println("c = "+c);
		System.out.println("사과는  "+str+"입니다.");
		System.out.println(b);
		
	}	
}

