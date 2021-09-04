package TeamProject;/*
abstract class Animal{
	//[생성자] - 이름,종 은 필수!! (서식지,나이 선택)
	Animal(String name){
		this(name,"알수없음",0); 
		// 선택사항-서식지"알수없음", 나이 0 으로 초기화부여
	}
	Animal(String name, String habitat, int age){
		this.name = name;
		this.habitat = habitat;
		this.age = age;
		this.type = ""; //개발자가 입력
	}
	//[멤버변수]
	String name; // 이름
	String habitat; // 서식지
	String type; // 종(포유류 어류 조류)
	int age; // 나이
	
	//[메소드]
	abstract void food(); // 식사 출력(사료, 고기)
	abstract void play(); // 놀이 출력(사냥놀이, 산책)
	abstract void action(); // 행동 출력(앉아, 일어서)
	
	//[오버라이딩]
	public boolean equals(Object obj) { // 비교함수 오버라이딩
		Animal ani = (Animal) obj; 
		if(ani.type == this.type) { // 종이 같니?
			return true;
		}
		return false;
	}
	public String toString() {//출력함수 오버라이딩
		return this.name+"이는 "+this.age+"살, "+this.type+"이고, "+this.habitat+"에 삽니다!!";
	}
}//Animal 종료
//[포유류]이예나=====================================================================
abstract class TypeMal extends Animal{ // 포유류
	TypeMal(String name){
		super(name);
	}
	TypeMal(String name, String habitat, int age){
		super(name, habitat, age);
	}
	void Call() {
		System.out.println(this.name+"가 ");
	}
}
class Bare extends TypeMal{
	Bare(String name){
		this(name, "알수없음", 0);
	}
	Bare(String name, String habitat, int age){
		super(name, habitat, age);
		this.type= "곰(포유류)";
		System.out.println(this.name+"이가 주인을 향해 손을 흔듭니다!! \\\\^ㅇ㉦ㅇ^//");
	}
	@Override
	void food() {
		this.Call();
		System.out.println("주변 작은친구들 찾아 먹습니다. ┌( ㅇ㉦ㅇ)┘ ");
	}
	@Override
	void play() {
		this.Call();
		System.out.println("평야를 돌아다니며 사냥을 합니다!! \\\\('㉦')ㄴ =33 ");
		
	}
	@Override
	void action() {
		this.Call();
		System.out.println("나무를 타고 올라가 경치를 구경합니다 ㅇ㉦ㅇ\n");
	}
}
class Cat extends TypeMal{
	Cat(String name){
		this(name, "알수없음", 0);
	}
	Cat(String name, String habitat, int age){
		super(name, habitat, age);
		this.type= "고양이(포유류)";
		System.out.println("애~옹~~ 집사옆으로 다가옵니다! (⊙ㅅ⊙)__/ \n");
	}
	@Override
	void food() {
		this.Call();
		System.out.println("사료를 먹습니다. (●'ㅅ'●) \n");
	}
	@Override
	void play() {
		this.Call();
		System.out.println("                        ^_^");
		System.out.println("집사에게 명령하여 사냥놀이를 합니다 (+ㅅ+)_ _ } \n");
		
	}
	@Override
	void action() {
		this.Call();
		System.out.println("잠에 빠져듭니다. . . . . zZz\n");
	}
	
}
class Seal extends TypeMal{
	Seal(String name){
		this(name,"알수없음", 0);
	}
	Seal(String name, String habitat, int age){
		super(name, habitat, age);
		System.out.println("옹옹!!!! 반가옹!!! >mm< // \n");
	}
	@Override
	void food() {
		this.Call();
		System.out.println("물고기를 잡아먹습니다. ㅇmmㅇ\n");
	}
	@Override
	void play() {
		this.Call();
		System.out.println("공으로 치고 던지고 놀기!  ☆mm☆ 3 오~옹!! \n");
		
	}
	@Override
	void action() {
		this.Call();
		System.out.println("인사를 합니다!! 옹!! 반갑게 인사해주세요:D  ^mm^ \n");
	}
	
}*/
public class yena_project {

	public static void main(String[] args) {

/*		Seal s1 = new Seal("옹이");
		s1.action();*/
		
		
	}//main종료

}
//소규모팀프로젝트 / 추상클래스,인터페이스(필수x) 등의 설계가 잘되었나?
//생성자 에러없이 잘 동작하나?
//toString(), equals() 오버라이딩을 반드시 넣어주세요!!
//상속단계는 무조건 3단계이상
//객체배열 사용!!
//간단하게 디테일을 너~~무신경xx
// 3가지(중 택일)
// 1) 모양 클래스 - 네모,세모,원 - 정사각형, 직사각형 
// 2) 동물 클래스 - 조류,  포유류 - 닭 비둘기 , 개 고양이 - 진돗개 리트리버  말티즈 시츄 , 샴 코리안숏헤어 스코티쉬폴트
// 3) 캐릭터, 플레이어 클래스 - 포켓몬스터 동물의숲 오버워치 롤 - (롤)원딜러 탑  서포터 (옵치)탱커 힐러 딜러 (동물)주민 소 말 햄스터 -  ...
/*abs ANIMAL
String name
String habitat
String aniName
int age;

abs void food
abs void play
abs void action
 equals() -> 종류 비교
 toString() -> name이는 age살 aniName 이고, habitat에 삽니다!
===============
어류윤혁님	조류영진님	포유류예나
===============
하위클래스:3개

곰
고양이*/
