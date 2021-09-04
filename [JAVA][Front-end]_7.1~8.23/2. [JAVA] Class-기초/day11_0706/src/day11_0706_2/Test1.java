package day11_0706_2;

// "공개 범위" - private, getter setter, public
// 접근제어자==접근지정자==접근자
// private : 오직 자기자신 내부에서만 접근이 가능하도록 설정 (외부에서는 존재 자체를 모른다.)
// 해당 클래스 외부에서는 접근이 불가능하기 때문에,
// 접근을 도와주는 메서드들이 필요하다!
// 이를 ★getter, setter★ 라고 부른다!
// getter: private 되어있는 값을 받아오는 메서드 // 인자없고
// setter: private 되어있는 변수에 값을 주는 메서드 // 인자있고
// == (좁은의미)정보은닉 == 캡슐화

// 웹앱에서는 거의 다 private이 걸려있다!!

// public: 외부 패키지에서도 접근이 가능하도록 설정

// default : 기본값
// 접근제어자 없음을 의미하며, 해당 패키지에서 접근가능한 상태
class Account{
	private String name; // 외부접근막기
	private int money; // 멤버변수 == 속성 == 필드
	// getter
	String getName(){ // getXxx() // 리턴값에 맞춰 자료형 지정
		return this.name;
	}
	int getMoney() {
		return this.money;
	}
	// setter
	void setName(String name){ // setXxx()
		this.name=name;
	}
	void setMoney(int money){
		this.money=money;
	}
	
	Account(String name){
		this(name,0);
	}
	Account(String name, int money){
		this.money = money;
		this.name=name;
	}
	void pay(int money) {
		if(this.money<money) {
			System.out.println("잔액부족!");
			return;
		}
		this.money-=money;
		System.out.println("결제완료!");
	}
	
}

public class Test1 {

	public static void main(String[] args) {

		Account a1 = new Account("아무무", 30000);
		//a1.money -= 30000; //몰래가져감
		//a1.name = "홍길동";
		// a1. 하면 money가 뜨나, 변수앞에 private을 달면 안보인다.
		// 있는데 모르는게 아니라, 아예모르는것(감춰놔서)
		
		a1.pay(9000);
		
		

	}

}
