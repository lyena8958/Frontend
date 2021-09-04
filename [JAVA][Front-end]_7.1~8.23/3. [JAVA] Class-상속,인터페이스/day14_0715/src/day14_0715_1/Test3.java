package day14_0715_1;

import java.util.Random;
import java.util.Scanner;

// 강사님
abstract class Card2{ // 추상클래스 -> "객체생성불가능"
	String name;
	int money;
	Card2(String name){
		this(name,0);
	}
	Card2(String name, int money){
		this.name = name;
		this.money = money;
	}
	void show() {
		System.out.println(this.name+"님의 잔액은"+this.money+"원입니다.");
	}
	abstract void pay(); // 추상메서드 -> 오버라이딩 강제
}
class CheckCard2 extends Card{
	// 1) 기본생성자 없음
	// 2) 부모클래스의 기본생성자를 호출
	// 3) 부모클래스에 기본생성자가 없으므로
	CheckCard2(String name, int money){
		super(name,money);
		System.out.println(this.name+"님, 체크카드 등록완료!");
	}
	void pay() {
		int money = 1000*(new Random().nextInt(9)+1); // 1000~9000
		System.out.println("결제하실 금액은 "+money+"원 입니다."); // 함수내 변수 머니를 갖고옴.
		if(this.money<money) {
			System.out.println("잔액부족으로 결제실패!");
			return; // 함수종료
		}
		this.money -= money;
		System.out.println("결제완료!");
	}
}
class CreditCard2 extends Card2{
	int sum;
	int limit;
	CreditCard2(String name, int limit) {
		this(name,0,limit); // 생성자호출
	} // 생성자 오버로딩
	CreditCard2(String name,int money, int limit) {
		super(name,money);
		this.limit = limit;
		this.sum = 0;
		System.out.println(this.name+"님, 신용카드 등록완료!");
	}
	void pay() {
		int money = 1000*(new Random().nextInt(9)+1); // 1000~9000
		System.out.println("결제하실 금액은 "+money+"원 입니다."); 
		if(sum+money>limit) {
			System.out.println("한도초과로 결제실패!");
			return;
		}
		sum+=money;
		System.out.println("결제완료!!");
	}
}
class BusCard2 extends Card2{

	int age;
	BusCard2(String name, int money) {
		this(name,money,20);
	}
	BusCard2(String name, int money, int age) {
		super(name, money);
		this.age =age;
		System.out.println(this.name+"님, 버스카드 등록완료!");
	}
	@Override
	void pay() {
		int money = 0;
		if(9<=age&&age<20) {
			money = 1000;
		}
		else if(20<=age&&age<=65) {
			money = 2000;
		}
		if(this.money<money) {
			System.out.println("잔액부족으로 탑승불가!");
			return;
		}
		System.out.println("승차합니다.");
		this.money -= money;
		
	}
	
}


// 예나★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
abstract class Card{
	Scanner sc = new Scanner(System.in);
	Card(String name, int money){
		this.name = name;
		this.money = money;
	}
	String name;
	int money;
	void show() {
		System.out.println(this.name+"님의 카드잔액은 "+this.money+"원 입니다.");
	}
	abstract void pay(); // 오버라이딩이 강제되어야하는 메서드
	
}
class CheckCard extends Card {
	CheckCard(String name, int money) {
		super(name, money);
		System.out.println(this.name+"님, 체크카드 등록완료!");
	}

	void pay() {// 결제만 진행 // 잔액이 0미만 xx // 바로 잔액이 --
		System.out.print(this.name+"님, 결제 금액을 입력해주세요 : ");
		int money = sc.nextInt();
		if (this.money < money) {
			System.out.println("[결제실패] 잔액이 부족합니다.");
			return;// 함수종료
		}
		System.out.println("[결제완료!] " + money + "원 결제");
		this.money -= money;
		System.out.println("잔액: " + this.money + "\n");

	} 

}

class CreditCard extends Card {
	CreditCard(String name, int money, int limit) {
		super(name, money);
		this.limit = limit;
		System.out.println(this.name+"님, 신용카드 등록완료!");
	}
	
	int sum; // 카드사용 누적금액
	int limit; // 제한금액(반드시 생성할때 필요한값)
	
	void pay() {// 결제만 누적금액 // 누적금액<=제한금액
		System.out.print(this.name+"님, 결제 금액을 입력해주세요 : ");
		int money = sc.nextInt();
		if (sum + money > limit) { // 누적예정금액이 한도초과가 된다면
			System.out.println("[결제실패] 한도가 초과되어 결제 불가합니다.");
			return; // 함수종료
		}
		System.out.println("[결제완료!] " + money + "원 결제되었습니다.");
		this.sum += money;
		System.out.println("누적 결제금액: " + this.sum + "\n");
		System.out.println("잔여한도: " + (this.limit - this.sum));
	}
	void show() {
		System.out.println(this.name+"님의 누적금액: "+this.sum+"원\n"+"잔여 한도: "+this.limit);
	}
}
class BusCard extends Card {
	BusCard(String name, int money) {
		super(name, money);
		this.age = 20;
	}

	BusCard(String name, int money, int age) {
		super(name, money);
		while (true) {
			if (0 > age) {
				System.out.println("[오입력] 나이 재입력하세요");
				age= sc.nextInt();
				continue;
			}
			break;
		}
		this.age = age;
		System.out.println(this.name + "님, 버스카드 등록완료!");
	}

	int age; // 만약 나이데이터가없다면 무조건 20살

	void pay() { // 나이에 따른 결제진행
		// 9~19 1000원
		// 20~65 2000원
		// 나머지 0원
		int subMoney = 0; // 차감예정금액
		if (9 <= age && age <= 19) {
			System.out.println("9살~19살 해당되므로, 1,000원 결제됩니다.");
			subMoney = 1000;
		} else if (20 <= age && age <= 65) {
			System.out.println("20살~65살 해당되므로, 2,000원 결제됩니다.");
			subMoney = 2000;
		} else {
			System.out.println("무료입니다.");
			return;
		}
		if (subMoney > money) {
			System.out.println("[결제실패] 잔액이 부족합니다.");
			return;
		}
		System.out.println("[결제완료] " + subMoney);
		money -= subMoney;
		System.out.println("남은 잔액: " + money + "\n");
	}
}

public class Test3 {

	public static void main(String[] args) {
		/* 문제
		class Card{
		    String name;
		    int money;
		    void show()
		        ___님의 카드 잔액은 ____원입니다.
		    void pay() << 오버라이딩이 강제되어야하는 메서드
		}
		class CheckCard{
		    void pay()->바로 잔액이 --
		    잔액이 0미만xxx
		}
		class CreditCard{
		    int sum; // 누적금액
		    int limit; // 제한금액(반드시 생성할때 필요한값)
		    void pay()->결제만 누적진행
		    누적금액<=제한금액
		}
		class BusCard{
		    int age;(만약, 나이데이터가 없다면 무조건 20살)
		    void pay()->나이에 따른 결제진행
		    9~19 1000
		    20~65 2000
		    나머지 0
		}*/

		//예나
		CheckCard c1 = new CheckCard("체크",5000);
		CreditCard c2 = new CreditCard("신용",5000, 15000);
		BusCard b1 = new BusCard("버스", 2000, 20);
		
//		c1.pay();s
//		c1.pay();
//		c1.show();
//		c2.pay();
//		b1.pay();

		
		//강사님
		// Card2 c1 = new Card("홍길동", 10000) // xxx 추상클래스 > 문법적으로 객체생성불가
		/*
		CheckCard2 c2 = new CheckCard2("홍길동", 10000);
		c2.pay();
		c2.pay();
		c2.pay();
		c2.show();*/
		
		CreditCard2 c3 = new CreditCard2("아무무", 20000);
		c3.pay();
		c3.pay();
		c3.pay();
		c3.pay();
		c3.pay();
		
		BusCard2 c4 = new BusCard2("아리",2500,19);
		c4.pay();
		c4.pay();
		c4.pay();
		c4.show();
		
	}//main종료

}
