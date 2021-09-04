package day12_0707;

// ★★★
// 자식클래스를 사용하는 도중에, 부모클래스를 변경하는 일은 
// 흔하지않다!!!!! -> 올바르지않다. (자식클래스에서 오류를 찾기)
// => 부모클래스에게 기본생성자가 없을수도있다!!!!!!!!!!!!!!!!!
class Person{ // 부모클래스에 기본생성자가 없다-> 생성자를 정의했기때문
	Person(String name){ // 이름이 들어간 생성자 생성
		this.name = name;
	}
	//Person(){
		// 사용자가 이름없는 객체를 만든다. -> 자식클래스가 오류났다고 부모클래스를 수정하지말자
	//}
	String name;
	void hello() {
		System.out.println("안녕하세요~");
	}
}
class Student extends Person{
	// 자식클래스는 생성시
	// 1) 부모클래스의 "기본생성자"를 호출하여 뼈대를 만들고,
	// 2) 자식클래스(Student)의 생성자를 마저 수행한다!☆
	Student(){
		
		// ★자식클래스의 생성자에서는
		// "가장먼저" 부모클래스의 기본생성자를 호출한다!
		// 이후 본인생성자를 마저 수행한다.
		
		// => 부모클래스에게 기본생성자가 없다면?
		// 다른 생성자를 이용한다!(생성자는 최소 1개있으니 해당 로직에 맞게 입력~)
		super("이름"); // -> 부모클래스(super로 호출) -- "가장먼저" 부모클래스의 생성자를 호출해야한다.
		//this() -> 자기자신
		System.out.println("자식클래스");
	}
	int num;
	void study() {
		System.out.println("공부중!!!!!");
	}
}
class Teacher extends Person{
	Teacher(String name){ // 부모클래스 생성자호출시 많이 사용하는방식!!!!
		super(name); // 부모클래스의 생성자 호출
	}
	String subject;
	void teach() {
		System.out.println("출석체크를 시작하겠습니다~~!");
	}
}

public class Test5 {

	public static void main(String[] args) {
		
		Student s = new Student();
		s.name="홍길동";
		s.num=11;
		

	}

}
