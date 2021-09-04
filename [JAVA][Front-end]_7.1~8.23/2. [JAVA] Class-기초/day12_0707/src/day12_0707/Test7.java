package day12_0707;
/* 문제!!
class Calc{
   Calc(){
      this.name="일반 계산기";
   }
   String name;
   void func(int a,int b) {
      System.out.println(a+"+"+b+"="+(a+b));
   }
   // 일반계산기는 정수2개의 합을 출력
   // 정수3개의 합도 출력할수있도록 "오버로딩"해주세요!~~
}
class GongCalc{ // 공학용계산기는 일반계산기의 기능을 모두가졌고,
   // 추가로
   // 정수 2개를 입력해주면
   // a~b까지 보여주고 -1
   // 그것들의 합을 출력하는 -2
   // 기능을 가졌습니다! => funcPlus   
}
public class Test3 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub

   }

}*/

// 강사님
class Calc2{
	Calc2(){
		this.name="일반 계산기";
	}
	String name;
	void func(int a, int b) {
		System.out.println(a+" + "+b+" = "+(a+b));
	}
	void func(int a, int b, int c) {
		System.out.println(a+" + "+b+" + "+c+" = "+(a+b+c));
	}
}
class GongCalc2 extends Calc2{
	GongCalc2(){
		// super(); -> 생략됨!!!!!!
		this.name = "공학용 계산기";
	}
	// 값만 나오게하고싶은데요? 라면 (1) -> 오버라이딩(자식에서 재정의 한 기능)
	void func(int a, int b) {
		System.out.println(a+b);
	}
	// 값만 나오게하고싶은데요? 라면 (2) -> 오버라이딩
	void func(int a, int b, int c) {
		System.out.println(a+b+c);
	}
	void funcPlus(int a, int b) {
		if(a>b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int sum= 0;
		for(int i = a; i <= b; i++) {
			System.out.print(i+" ");
			sum += i;
		}
		System.out.println();
		System.out.println("합은 "+sum+"입니다.");
	}
	
}

// 예나
class Calc{
	Calc(){
		this.name="일반 계산기";
	}
	String name;
	void func(int a, int b) {
		System.out.println(a+" + "+b+" = "+(a+b));
	}
	void func(int a, int b, int c) {
	// 일반계산기는 정수2개의 합을 출력
	// 정수3개의 합도 출력할 수 있도록 "오버로딩"해주세요
		System.out.println(a+" + "+b+" + "+c+" = "+(a+b+c));
	}
}
class GongCalc extends Calc { // 공학용계산기는 일반계산기의 기능을 모두가졌고,
	GongCalc(){
	this.name = "공학용 계산기";
		}
	// 추가로
	// 정수 2개를 입력해주면 
	// a~b까지 보여주고 > 1
	// 그것들의 합을 출력하는 > 2
	// 기능을 가졌습니다! => funcPlus
	void funcPlus(int a, int b){
		System.out.println("\n"+a+"와 "+b+"를 입력하셨습니다.");
		if(a>b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int sum = 0;
		System.out.print("[ ");
		for(int i = a; i <= b;i++) {
			System.out.print(i+" ");
			sum += i;
		}
		System.out.println("]");
		System.out.println("총 합: "+sum);
	} // 메서드 종료
	
}

public class Test7 {

	public static void main(String[] args) {
		
		
		// 예나
		GongCalc c1 = new GongCalc();
		
		c1.func(5, 6);
		c1.func(1, 1, 5);
		
		c1.funcPlus(15, 2);
		

	}

}
