package day14_0715_2;
// 강사님

abstract class Phone{ // == smartphone
	Watch2 watch;
	String name;
	// 모든 핸드폰들은...
	// 사용자의 이름 or 사용자의 이름+워치 를 갖고있어야돼!! ↓
	Phone(String name){ //워치가 없는 경우
		this(null, name);
	}
	Phone(Watch2 watch, String name){
		this.watch = watch;
		this.name = name;
		System.out.println(this.name+"님, 폰 등록완료!");
	}
	void show() {
		System.out.print(this.name+"님의 워치: ");
		if(watch==null) {
			System.out.println("등록안됨");
		}
		else {
			System.out.println(watch.name);
		}
		System.out.println(); // [애플/스마트/등록안됨]
	}
	abstract void call();
}
class IPhone2 extends Phone{
	IPhone2(String name) {
		this(null,name);
	}
	IPhone2(Watch2 watch, String name) {
		super(watch, name);
	}

	@Override
	void call() {
		System.out.println("시리야~~~");
		
	}
	
}
class Galaxy2 extends Phone{

	Galaxy2(String name) {
		this(null,name);
	}
	Galaxy2(Watch2 watch, String name) {
		super(watch, name);
	}

	@Override
	void call() {
		// TODO Auto-generated method stub
		
	}
	
}
abstract class Watch2 implements useWatch2{ 
	// Watch2 를 추상클래스로 변경하면, 자식클래스들은
	//  추상 메소드를 생성해야한다.
	String name;

//	@Override
//	public void soundUp() {
//		System.out.println("소리++");
//		
//	}
//
//	@Override
//	public void soundDown() {
//		System.out.println("소리--");
//		
//	}
	
}
interface useWatch2{
	// 몸체가 없는 이유는 추상메소드가 됐기때문에
	void soundUp();
	void soundDown();
}
class AppleWatch2 extends Watch2{ 
	//부모메서드가 추상메소드를 정의했기 때문에 자식에서는 정의xxx
	// 부모메서드를 추상클래스로 바뀌면 자식은 모두 추상메소드를 입력해야한다. ↓
	AppleWatch2(){
		this.name = "애플";
	}
	public void soundDown() { //사운드 다운 오버라이딩
		System.out.println(this.name+"--");
	}
	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"++");
	}
}
class SmartWatch2 extends Watch2{ //부모메서드가 추상메소드를 정의했기 때문에 자식에서는 정의xxx
	SmartWatch2(){
		this.name = "스마트";
	}

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		System.out.println("소리 올라갑니다.");
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		System.out.println("소리 내려갑니다.");
	}
}


//예나★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
interface useWatch{
	void soundUp();
	void soundDown();
}
abstract class Watch implements useWatch{
	String name;
	Watch(){
		this("등록안됨");
	}
	Watch(String name){
		this.name = name;
	}
	@Override
	public void soundUp() {
		System.out.println("사운드 업!");
	}

	@Override
	public void soundDown() {
		System.out.println("사운드 다운!");
	}
}
class AppleWatch extends Watch {
	AppleWatch() {
		super("애플");
	}
}
class SmartWatch extends Watch{
	SmartWatch() {
		super("스마트");
	}	
}
abstract class SmartPhone{
	SmartPhone(String name){
		//this(name, watch); // ?????????????
	}
	SmartPhone(String name, Watch watch){
		this.name = name;
		this.watch = watch;
	}
	String name;
	Watch watch;
	void show() {
		System.out.println(this.name+"님의 워치: "+this.watch); // 애플/스마트/등록안됨
	}
	abstract void call();
}
class IPhone extends SmartPhone {
	IPhone(String name) {
		super(name);
		System.out.println(this.name+"님 환영합니다! 아이폰 개통");
	}

	void call() {
		System.out.println("시리야!!");
	}
}
class Galaxy extends SmartPhone{
	
	Galaxy(String name) {
		super(name);
		System.out.println(this.name+"님 환영합니다! 갤럭시 개통");
	}

	void call() {
		System.out.println("하이 빅스비!");
	}
}

public class Test1 {

	public static void main(String[] args) {
		//문제
	/*	스마트폰-> watch는 선택, 이름입력은 필수!
	    -Watch  watch;
	    -String name;
	    -void show()
	   _____님의 워치: [애플/스마트/등록안됨]
	    -void call() 반드시 오버라이딩해야함
	아이폰    갤럭시
	call() 시리    call() 빅스비

	Watch
	   String name
	   void soundUp()
	   void soundDown()

	AppleWatch        SmartWatch
	name=애플   name=스마트.*/
		
		// 강사님
		IPhone2 p1 = new IPhone2("홍길동");
		p1.call();
		p1.watch = new AppleWatch2();
		p1.show();
		
		Galaxy2 p2 = new Galaxy2(new SmartWatch2(),"아무무");
		p2.show();
	
		// 가장 상위에 구현된 클래스의 메서드가 아닌,
		// 실제 구현된 객체의 메서드를 찾아서 실행한다!!!!!
		p1.watch.soundUp();
		// 원본 Phone를 soundUp 메소드 생성시켜도 가까운 객체로 찾아간다. 
		p2.watch.soundUp();
		// "다형성☆이 구현(실현)되었다." 
		// 사용자는 watch라는 객체에서 soundUp()를 호출했는데,
		// 실제로 동작된것은 appleWatch의 soundUp()일때!
		// "동적바인딩"이 일어났다!!! == 다형성이 구현됐다.
	
		
		
		
		
	}
	
	
	

}
