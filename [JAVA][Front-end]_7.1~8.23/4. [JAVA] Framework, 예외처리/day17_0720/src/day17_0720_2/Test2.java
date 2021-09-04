package day17_0720_2;

// 3자리가 있는데 교착상태가되면
// 5명  수강신청 성공할수도있다.

class TiSys implements Runnable{
	Ticket t = new Ticket();
	
	@Override
	public void run() {
		t.buy();
	}
	
}
class Ticket{
	static int ticket = 2; // 공유자원
	//synchronized ->잠시대기 처리(동기화처리!) -> 하지않으면 티켓동시에 발급이 되어 티켓이 소진되어도 동시접속시 구매가된다..
	public synchronized void buy() {//공유자원을 막지않아 3명이 동시에 티켓을발급할수있다.
		if(ticket>0) {           // ↓현재 내 스레드의 이름
			System.out.println(Thread.currentThread().getName()+"티켓발급성공!");
			ticket--;
		}
		else {
			System.out.println("티켓없음ㅠㅠㅠ");
		}
		System.out.println("남은 티켓수: "+ticket);
	}
	
}
// [공유자원과 동기화] 공유자원(전역변수 static(클래스변수)

// 공유자원을 다룰때 == 어떤 스레드가 자원을 점유하고 있을때
// 다른 스레드의 접근을 제한, 에러를 사전에 방지 해야한다. ->ex)수강신청
// == 동기화 처리

// "교착상태"(데드락) 를 일으키지 않게 하는 것이 스레드의역할
//    -> 아이콘이 켜져있는데 휴지통에 버릴때 못버리듯이


//공유자원 예시)
//class Game{
//	static int game = 100; // 공유자원==클래스변수
//	
//}
public class Test2 {

	public static void main(String[] args) {
		
		
		TiSys sys=new TiSys();
		//티켓은 2개인데, 접속하는사람이 3명..!
		Thread t1 = new Thread(sys,"아무무"); // 이름-스레드네임!
		Thread t2 = new Thread(sys,"아리");
		Thread t3 = new Thread(sys,"티모");
		
		// 3명이 버튼을 동시에 누린것과 동일
		t1.start();
		t2.start();
		t3.start(); // 티켓이 0인데도 구매가됨..!
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
