package day12_0707;

class Po{
	String name;
	int level;
	String type;
	void play() {
		System.out.println("공격");
	}
	void show() {
		System.out.println("말할수있음");
	}
}
class Water extends Po{ // 물 속성
	Water(){
		this.type="물 속성";
	}
	void play() { // 속성단위로 공격메서드는 재정의됨! == 오버라이딩
		System.out.println("물대포");
	}
}
class Fire extends Po{ // 불 속성
	Fire(){
		this.type = "불 속성";
	}
	void play() {
		System.out.println("불꽃!");
	}
	void play(int level) { // 같은 클래스에서 재정의됨! == 오버로딩  == 인자가 달라야함
		System.out.println("+++");
	}
}	
class Pa extends Fire{ // 불 속성인 파이리
	Pa(){
		this.name = "파이리";
	}
	void show() { // 포켓몬에 따라 말하는 멘트는 재정의된다! == 오버라이딩 == 인자와 리턴타입이 같아야함
		System.out.println("파~~~~~~");
	}
}
class Ggo extends Water{ // 물 속성인 꼬부기
	Ggo(){
		this.name = "꼬부기";
	}
	void show() { // 포켓몬에 따라 말하는 멘트는 재정의된다! == 오버라이딩
		System.out.println("꼬북꼬북");
	}
}
	
	public class Test8 {


	public static void main(String[] args) {


	}

}
