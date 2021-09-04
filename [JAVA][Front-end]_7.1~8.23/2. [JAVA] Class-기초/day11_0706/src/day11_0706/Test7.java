package day11_0706;

// 공유자원 -> 영화관, 수강신청

class Dog{
	Dog(String name){
		this.name=name;
	}
	String name;
	//★
	static String[] action = new String[3];
	// 강아지들은 공동학습이 가능
	static int index = 0; // 인덱스번호를 공유해야함
	// action배열의 index를 의미 //★ 공유자원
	void play(String str) {
		this.action[this.index++]=str; // this지워도 상관 ㄴㄴ
		// 증감연산자는 후위증가되므로 위처럼 작성해도 된다.
		//index++;
	}
}

public class Test7 {

	public static void main(String[] args) {
		
		Dog d1 = new Dog("유미");
		Dog d2 = new Dog("아리");	
		Dog d3 = new Dog("워윅");
		System.out.println(d3.action[0]);
		d2.play("앉아!");
		System.out.println(d1.action[0]);
		// └> 공유자원으로 인해 다른 객체들도 값이 공유가 된다.
		
	}

}
