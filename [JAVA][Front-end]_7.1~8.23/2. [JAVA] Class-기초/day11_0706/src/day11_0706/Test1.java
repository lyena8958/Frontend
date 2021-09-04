package day11_0706;

// ★★★유지보수 효율증가★★★ -> 특정 기능을 반복적으로(일회성이 아닌) 사용하면, 메서드화! - 코드 재사용성을 증가시키는것.
// ★★★코드가독성 효율증가★★★
class Circle{ // 생성자 정의가 1개이상 있으면, 기본생성자는 없어진다. (사용했던 기본생성자 객체는 오류생긴다.)
	// 16번 23번의  생성자 두개를 줄일 순 없을까??? -> 있다!!!
	Circle(){ 
		this("미정", 1); // 반드시 맨 첫줄에 위치해야함!!!!!
		// 나 13번 생성자 호출할게-> 인자 2개가 있으니 -> this.Circle("미정", 1); -> 나? -> this
		//this의 사용
		// 1) . 멤버변수에 접근
		// 2) () 생성자를 호출 -> 자기 자신 생성자 부를때 this() 괄호를 쓴다.
		// 요약> 멤버변수 . // 생성자 ()
		System.out.println("기본생성자호출됨");
	}
//	Circle(){
//		// 까먹고 정보를 입력 못했다..! 그러면 고정값을 해줄 게 써봐~!
//		//System.out.println("기본생성자 호출됨");
//		this.name="미정";
//		this.radius=1;
//		this.area=this.radius*this.radius*3.14;
//	}
	Circle(String name, int radius){ // 인자에 다른 단어를 입력하면 헷갈리니까 똑같이 입력!!
		// 나는 이것은 꼭 넣어야돼. 하면 인자를 넣는다.
		//System.out.println("생성자 호출됨");
		this.name=name;
		this.radius=radius;
		//this.area = this.radius*this.radius*3.14;
		  // area에서는 중복이없어 this를 안써도되나, 가독성상 쓰는게 좋다 (객체를 가르키는 방향이면 쓰자)
		// -> 
		this.getArea();
		System.out.println("생성자호출됨");
	}
	
	String name;
	int radius;
	double area; // 바꿀예정인 값
	// area = radius * radius * 3.14 하면 radius는 0이기때문에 의미 없다
	void show() { // 메소드
		// Circle(클래스)만 사용할 수 있는 함수이기 때문에 static 사용xx 
		System.out.println(name+"은(는) 넓이가"+area+"입니다.");
	}
	String show2() { // 메소드
		return name+"은(는) 넓이가"+area+"입니다."; 
	}
	void changeRadius(int radius) {
		this.radius=radius;
		//this.area = this.radius*this.radius*3.14;
		 // -> 요약
		this.getArea();
		System.out.println("반지름 변경!");
	}
	void getArea() { // 원의 넓이를 구하는 메소드
		this.area = this.radius*this.radius*3.14; // 위의 구한 식과 동일하게 적기위해
		// return this.radius*this.radius*3.14; -> double 메소드형
		
	}
}
// 함수 -동물, 생성자- 강아지

public class Test1 {

	public static void main(String[] args) {
		

		Circle c1 = new Circle();
		//인자가 없는 클래스는 생성자가 자바에서 기본으로 제공된다.
		
		//멤버변수를 연달아 변경이 안된다. (1개까지 적용) -> 그 이상은 메소드로 만들자
		c1.name="도넛"; // 멤버변수 값 변경
		//c1.radius=10; // 이름만바뀌고 반지름값은 안바뀐다.
		//c1.changeRadius(10); //changeRadius 사용하면 바뀔 수 있다.
		c1.show(); 
		 //System.out.println(c1); // day11_0706.Circle@7852e922
		 // 주소가 나온다.
		 // int[] arr = new int[3], syso(arr) == 나오는게비슷하다.
		
		 //System.out.println(c1.show()); 오류 -> show에서는 출력기능이 있어서 중복 안됨
		 //System.out.println(c1.show2()); // 굳이 사용하려면 해당 리턴있는 메소드로!
		System.out.println();
		
		Circle c2 = new Circle("피자", 20);
		c2.changeRadius(1);
		c2.show();
		
	} // main종료

}
