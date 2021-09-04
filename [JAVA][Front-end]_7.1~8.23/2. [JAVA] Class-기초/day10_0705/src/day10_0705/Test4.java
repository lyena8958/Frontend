package day10_0705;

import java.util.Scanner;

public class Test4 {
// next - 널값 포함안됨(띄어쓰기 x), 	nextLine - 널값 포함가능(띄어쓰기 가능)
	public static void main(String[] args) {
		/*
		String str = "BanaNA";
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		System.out.println(str.toLowerCase()); // 소문자를 리턴해줌(원본 값 변화없음)
		System.out.println(str);*/
		// 즉 String는 value가 아니라, 객체로 이루어져있다.
		
		String str2 = "서울시 강남구 xx동";
		String[] strData = str2.split(" "); // 띄어쓰기 기준으로 자를게! // 전화번호 "-" 등 쓰임새 많음
		for(String v:strData) {
			System.out.println(v);
		}
		
		String str3 = "applepiebanana";
		System.out.println(str3.substring(5)); //0~4번의 인덱스를 자르고 그뒤의 숫자 출력
		// substring는 오버로딩으로 한개가 더 있는데, 인덱스의 끝자리도 지정할 수 있다~!
		// 인덱스만큼 잘라서 문자열을 보인다
		
		
		// int a = 10; (저장공간, 주소, 변수명) -> 원시타입!!
		
		// String 
		// 1)배열개수만큼 공간 생성(공간이 각각 흩어져있다, 메모리에는 주소만 저장되어 있음) 
		//   -> 비교식을 하면 strarr[0] == strarr[1]은 주소값이 같냐고 물어보는거다.
		
		
		Scanner sc = new Scanner(System.in);
		// String는 자료형(int..)보다는 Scanner와 같은 클래스 개념이다.
		String[] strArr=new String[3];
		strArr[0] = "apple";
		System.out.print("두번째 단어: ");
		strArr[1] = sc.next();
		System.out.print("세번째 단어: ");
		sc.nextLine(); // 아래 문자열이 안들어가니 공백값을 넣어줘야 한다.
		strArr[2] = sc.nextLine(); //next() 사용함으로써 엔터값이 들어감
		
		for(String v:strArr) {
			System.out.println(v);
		}
		
		// strArr[0~2] 까지 같은 단어를 입력했을 때 아래 확인!이 출력이 안된다.
		// 이유? 18~20Line 참고 -> 주소랑 비교하기 때문
		//출력불가!!!!
		if(strArr[0]==strArr[1]) { // 기존 c언어에서는 strcmp사용했었다.
			System.out.println("확");
		}
		else if(strArr[0]==strArr[2]) {
			System.out.println("인");
		}
		else if(strArr[1]==strArr[2]) {
			System.out.println("!");
		}
		
		//1번만 출력가능!!!!!
		// 이유? next(), nextLine() 로직이 다르기 때문이다. ->띄어쓰기를 사용하지 않는이상: next사용하는것이 더 좋다.
		// nextLine: "apple\0"이 되어있고, next: "apple"이 되어있는거라 다른거임
		if(strArr[0].equals(strArr[1])) {
			// 실질적인 값을 비교할수있게됨!! -> equals 메소드
			System.out.println("확");
		}
		else if(strArr[0].equals(strArr[2])) {
			System.out.println("인");
		}
		else if(strArr[1].equals(strArr[2])) {
			System.out.println("!");
		}
		
		
		
		
		
		
		
	} // main종료

}
