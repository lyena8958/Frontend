package day11_0706;

// 강사님
class Account2{
	Account2(String card){
		this.card = card;
	}
	String card;
	static int money=75000;
	void pay(int money) {
/*1*/		if (this.money<money){//체크하고 수행하는 것이 오류가 적다
			System.out.println("잔액부족!");
			return;
		}
		this.money-=money;
//2		if(this.money<0) {
//			System.out.println("잔액부족!");
//			this.money+=money;
//		}
	}
	void show() {
		System.out.println(this.card+"카드 잔액 "+this.money+"원입니다.");
	}
}


class Account{
	Account(String card){
		this.card = card;
	}
	String card; // 신용,체크,버스카드
	static int money = 5000; // 공유자원
	static int index;
	
	void pay(int money) {
		if(this.money < money) {
			System.out.println("[ERROR-잔액부족] 현재 금액: "+this.money);
			return;
		}
		this.money-=money;
	}
	void show() {
		System.out.println(this.card+"카드 잔액"+this.money+"원 입니다.");
	}
	void newCard(String card) {
		this.card = card;
	}
	
}

public class Test8 {

	public static void main(String[] args) {
/*		계좌 문제
		class Account
		 -String card
		 -int money(공유자원)
		 void pay(int money)
		   : money만큼 결제가 수행됨
		   만약, 돈없으면 결제안됨
		 void show()
		   : ㅁㅁ카드 잔액 _____원입니다.*/

		// 강사님 
		Account2 c1 = new Account2("신용");
		Account2 c2 = new Account2("버스");
		c1.show();
		c2.pay(1000);
		c2.pay(1000);
		c1.show();
		
		System.out.println();
		
		// 예나
		Account c3 = new Account("버스");
		Account c4 = new Account("신용");
		c3.show();
		c3.pay(5000);
		c4.show();
		
		
	}

}
