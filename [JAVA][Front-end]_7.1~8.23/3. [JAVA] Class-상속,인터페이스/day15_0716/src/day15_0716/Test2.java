package day15_0716;

import java.util.Random;

// DB연결, 크롤링관련 인터페이스가 이미!


interface Plus{// 포켓몬들은 놀이를 해야해!
	void play();
}
interface F{
	// 모든메서드는 다 "추상메서드"
	void f1();
	void f2();
	void func();
	void attack(); 
	// 어택을 정의하는 게 추상클래스에서 한 것 왜?어차피 자식클래스에서 지정해야하니까.
	// 그럼 언제사용??
}
//class Fire implements A{
//
//	@Override
//	public void f1() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void f2() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void func() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}

abstract class Pocket {//implements Plus
	String name;
	String type; // 속성
	int level;
	int exp; // 100마다 Lv+=1
	Pocket() { // 없어도무관 왜? 자식에서 지정했기때문(그러나문법상(가독성) 쓰는게 좋다)
		this(5);
	}

	Pocket(int level) {
		// 이름은 피카츄, 파이리, 꼬부기에서 생성
		// 속성은 속성계층에서 생성(물,불)
		this.name="";// 자식에서 만들거기 때문에 없어도 무방
		this.level = level;
		this.exp = 0;
	}
	abstract boolean attack();
	void game() {
		if(this.attack()) {
			this.exp+=(new Random().nextInt(5)+1)*10;
			System.out.println("공격성공!");
			if(this.exp>=100) { // while문도 사용가능!
				this.exp -= 100;
				this.level++;
				System.out.println("레벨업!!!");
			}
		}
		else {
			System.out.println("공격실패!");
		}
		System.out.println("현재경험치: "+this.exp);
		System.out.println();
	}
	public String toString() {
		return this.name+" Lv."+this.level+" ["+this.exp+"]";
	}
}
abstract class Water extends Pocket{
	// 객체를 생성하지않기위해서 추상클래스화
	Water(){
		this(5);
	}
	Water(int level){
		super(level);
		this.type = "물 포켓몬";
	}
	@Override
	boolean attack() {
		System.out.println("물대포--!!!!!");
		return new Random().nextBoolean();
	}
	
}
abstract class Elec extends Pocket{
	// 객체를 생성하지않기위해서 추상클래스화
	Elec(){
		this(5);
	}
	Elec(int level){
		super(level);
		this.type = "전기 포켓몬";
	}
	@Override
	boolean attack() {
		System.out.println("!백만볼트!");
		return new Random().nextBoolean();
	}
	
}
class A extends Water{ // 꼬부기
	A(){
		this(5); // 안써도무관
	}
	A(int level){
		super(level);
		this.name = "꼬부기";
		System.out.println("꼬부기 생성완료"+level);
	}
}
class B extends Water{ // 리아코
	B(){
		this(5);
	}
	B(int level){
		super(level);
		this.name = "리아코";
		System.out.println("리아코 생성완료"+level);
	}
}
class C extends Elec{ // 피카츄
	C(){
		this(5);
	}
	C(int level){
		super(level);
		this.name = "피카츄";
		System.out.println("피카츄 생성완료"+level);
	}
}
class D extends Elec{ // 라이츄
	D(){
		this(5);
	}
	D(int level){
		super(level);
		this.name = "라이츄";
		System.out.println("라이츄 생성완료"+level);
	}
}
public class Test2 {

	public static void main(String[] args) {
	/*포켓몬스터
		   이름
		   레벨
		   경험치 100마다 Lv+=1
		   게임->성공 경험치++
		      실패 경험치xxx
		   boolean 공격()
		속성
		   공격: 물대포/백만볼트
		피카츄
		   이름-피카츄/이름-파이리
		   레벨-1~9 // 5
		   경험치-0*/

		//	Pocket pocket = new Pocket(); xxx
		Pocket[] data = new Pocket[4];
		data[0] = new A();
		data[1] = new B(new Random().nextInt(9)+1);
		data[2] = new C();
		data[3] = new D(new Random().nextInt(9)+1);
		
		
		for(int i = 0; i<3;i++) {
			for(Pocket p:data) {//배열인덱스 지정불가능!!
				p.game(); // 12번 수행(배열의길이(4)*i(3))
			}
		}
		
		for(Pocket p:data) {
			System.out.println(p);
		}
		// 피카츄 Lv.5 [20]
		
	}//main종료

}
