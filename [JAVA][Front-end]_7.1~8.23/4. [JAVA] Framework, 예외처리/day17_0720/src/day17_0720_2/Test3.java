package day17_0720_2;

import java.util.Scanner;
class MSys implements Runnable{
	Acoount2 a = new Acoount2();
	@Override
	public void run() {
		a.outMoney();
	}
	
}
// 강사님 답
class Acoount2{
	static int money2=10000;
	public synchronized void outMoney() {//run에서 사용될 함수이므로, 혹시나해서 문제없이 수행하고싶어서 공개범위를 맞춰줬다
		if(money2<5000) { // currentThread : 현재 점유하고있는 스레드:t1...t2..
			System.out.println(Thread.currentThread().getName()+"인출실패!");
		}
		else {
			money2-=5000;
			for(int i = 0; i <3; i++) {
				System. out.print(". ");
				try {
					Thread.sleep(1000);//클래스에서 사용된메소드
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("인출성공!");
		}
	}
}
// 예나
class Draw implements Runnable{
	Account person = new Account();
	
	public void run() {//수행모드(start)로 들어오면 run()이 자동 호출된다.
		person.pay();
	}
}
class Account{//가족공동계좌
	static int money = 10000; // 공금
	synchronized void pay() {
		System.out.println("결제금액을 입력해주세요.");	
		int money =new Scanner(System.in).nextInt();
		if(this.money<money) {
			System.out.println("[결제불가] 잔액이 부족합니다. 현 잔액 : "+this.money);
			return;
		}
		this.money -= money;	
		System.out.println(Thread.currentThread().getName()+"님, "+"결제: "+money+"원 완료\n"+"잔액:"+this.money);
	}
	
}
public class Test3 {

	public static void main(String[] args) {
		/*계좌
		  공금: 10000

		아무무,아리,티모
		한번에 인출을 시도할때,
		누가 5000원을 인출하지못했는지 출력해주세요!~~
		+) . . . 인출성공!*/
		
		MSys sys = new MSys();
		Thread t4 = new Thread(sys,"아무무");
		Thread t5 = new Thread(sys,"아리");
		Thread t6 = new Thread(sys,"티모");
		//[생성]
		
		//[대기]
		
		
		
		// [수행] -> run()호출// 그러니까 수행모드인 start로 가면 run호출이된다는건가요?? yes
		// 수행모드(start) -> run()자동호출
		t4.start(); 
		t5.start();
		t6.start();
		//t6.run();		
		// start - 더블클릭해서 시스템을 사용한다는 것 -> 수행모드 실행
		// run 구현된 메소드만 쓴다는것(워드 - 그림그리기, 차트 만! 쓰겠다)
		//		현재는 메소드가 1개라 차이점이 없지만 여러개가 있다면 엇갈린다.
		
		
		//예나
		/*
		Draw draw = new Draw();
		
		Thread t1 = new Thread(draw, "김씨");
		Thread t2 = new Thread(draw, "이씨");
		Thread t3 = new Thread(draw, "여씨");
		t1.start();
		t2.start();
		t3.start();*/
		
		
	}

}
