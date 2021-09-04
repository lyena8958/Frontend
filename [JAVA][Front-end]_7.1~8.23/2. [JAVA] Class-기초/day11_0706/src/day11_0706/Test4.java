package day11_0706;

import java.util.Scanner;

// 강사님
class Animal2{
	Animal2(String type, String name){
		this.type=type;
		this.name=name;
	}
	String type;
	String name;
	void show() {
		System.out.println(this.type+" 이름은 "+this.name+"입니다! :D");
	}
	void play() {
		if(this.type.equals("강아지")) {
			System.out.println("산책");
		}
		else if(this.type.equals("고양이")) {
			System.out.println("사냥놀이");
		}
		else if(this.type.equals("기니피그")) {
			System.out.println("쓰다듬,,");
		}
		else {
			System.out.println("해당없음");
		}
	
	
	
	}
	
	
}


// 예나
class Animal{
	Scanner sc = new Scanner(System.in);
	Animal(){
		this.ans();
	}
	
	String type; // 고양이 강아지
	String name;
	// 반려동물은 무조건 type, name이 꼭 필요하다.
	// Scanner를 사용하여 console에서 입력해주세요
	void show() {
		System.out.println(this.type+" 이름은 "+name+"입니다! :D");
	}
	void play() {
		// 강아지-산책, 고양이-사냥놀이, 기니피그- 쓰다듬... -> 없으면 해당없음
		if(this.type.equals("강아지")) {
			System.out.println(name+"(과)와 을 산책합니다!");
		}
		else if(this.type.equals("고양이")) {
			System.out.println(name+"과(와) 사냥놀이를 합니다!");
		}
		else if(this.type.equals("기니피그")) {
			System.out.println(name+"를 쓰다듬습니다!");
		}
		else {
			System.out.println("해당없음");
		}
	}
	void ans() {
		System.out.print("반려동물 타입을 입력해주세요(강아지, 고양이, 기니피그): ");
		this.type = type = sc.next();
		System.out.print("해당 반려동물의 이름을 입력해주세요 ");
		this.name = name = sc.next();
	}
}

public class Test4 {

	public static void main(String[] args) {
		
		/*예나
		Animal amal1 = new Animal(); // 강아지 봄이
		amal1.show(); 
		amal1.play();*/
		
		
		// 강사님
		Scanner sc = new Scanner(System.in);
		System.out.println("종류: ");
		String type=sc.next();
		System.out.println("이름: ");
		String name=sc.next();
		Animal2 a = new Animal2(type,name);
		a.show();
		a.play();
		
	}

}
