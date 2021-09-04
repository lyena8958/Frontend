package day11_0706;

// 강사님 답
class Subject2{
	Subject2(String name){
		this(name,2); // 13열에 넘겨서 실행
		
	}
	Subject2(int time){
		this("과목미정",time);
		// this.name = "과목미정"
		// this.time = 2 
		// 위 랑 같으나, 효율성을 위해 메소드활용
	}

	Subject2(String name, int time){
		this.name=name; //this.name -> 객체 , name-> 인자
		this.time=time;
	}
	String name;
	int time;
	void show() {
		System.out.println(this.name+"은(는) "+this.time+"학점입니다.");
	} // name, time 만으로도 해도되나 가독성을 위해 this.을 붙인다.
	void changeTime2(int time) {
		System.out.println(this.name+"이(가) "+this.time+"->"+time+"으로 변경되었습니다."); // 출력부
		this.time = time; // 기능부
	}
}

// 예나 클래스
class Subject{

	Subject(){
		this("과목 미정", 2);
	}
	Subject(String name, int time){
		this.name = name;
		this.time = time;
		this.show();
	}
	Subject(String name){
		this.name = name;
		this.time = 2;
		this.show();
	}
	Subject(int time){
		this.name = "과목 미정";
		this.time = time;
		this.show();
	}
	void show() {
		System.out.println(this.name+"은(는) "+this.time+"학점입니다.");
	}
	void changeTime(int time) {
		// this.time -> 객체에서 입력한 값, time-> 메소드에서 입력한 값
		System.out.println(this.name+"(이)가 "+this.time+"→"+time+"으로 변경되었습니다.");
		this.time/*객체*/ = time;//인자
	}
	
	String name; // 과목명
	int time; // 학점
	
}

public class Test3 {
	public static void main(String[] args) {
		/*
	class Subject
	-String name // 과목명
	-int time // 학점
	-void show()
	   수학은(는) 2학점입니다.
	-void changeTime(int time)
	  수학이(가) 2->3학점으로 변경되었습니다.
	☆main()에서 과목들을 여러개 생성해보겠습니다!~~
	Subject s1=new Subject(3);
	   => 과목미정 / 3
	Subject s2=new Subject("시사영어");
	   => 시사영어 / 2
	Subject s3=new Subject("C언어",4);
	   => C언어 / 4	*/
		
		// 예나
		Subject s1 = new Subject(3);
		Subject s2 = new Subject("시사영어");
		Subject s3 = new Subject("C언어", 4);
		s3.changeTime(5);
		s3.show();
		
		System.out.println("");
		
		// 강사님
		Subject2 s21 = new Subject2("C언어", 4);
		s21.show();
		
		Subject2 s22 = new Subject2("시사영어");
		Subject2 s23 = new Subject2(3);
		s22.show();
		s23.show();
		
		
	}

}
