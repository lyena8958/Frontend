package day21_0726;

// 스레드, 예외처리, GUI, 파일입출력, MVC
// 위에서의 명령어들은 단독으로 쓰지않는다.
class Th1 extends Thread{
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("클래스스레드");
		}
	}
}
// 상속보단 임플리먼츠가 더 많이 사용된다.
class Th2 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
				System.out.println("인터페이스스레드");
		}
	}
	
}
class TiSys implements Runnable{
	Ticket t = new Ticket();
	@Override
	public void run() {
		t.buy();
	}
	
}
class Ticket{
	static int ticket=1; // 공유자원->한장만 있다!
	public synchronized void buy() {
		//synchronized 어떤 스레드가 들어오면 다른 스레드가 접근하지 못하게 해줌
		if(ticket>0) {
			System.out.println("티켓발급");
			ticket--;
		}
		else {
			System.out.println("티켓구매실패");
		}
		System.out.println("남은 티켓수: "+ticket);
	}
}
public class Test3 {

	public static void main(String[] args) {
		
		// 순서
		// 어떤 프로그램을 먼저 실행할지 모르기 때문에 항상 대기하고 있어야 한다. == 스레드
/*
		// 스레드 생성(1)
		// thread 구현(상속)
		Th1 t1 = new Th1();
		
		// 스레드 생성(2)		--> 많이씀
		// thread imp-> 멤버변수는 없고 메서드만 구현되어있다.	
		Th2 t2 = new Th2();
		Thread t3 = new Thread(t2);
		
		// 우선순위부여 -> 높을수록 먼저 실행(권유.. 무조건은 아님)
		//시분할
		t1.setPriority(10);
		
		// GUI에서 더블클릭 한것과 같다.
		// 클릭한 순서대로 나온다.
		t1.start();
		t3.start();*/
		
		
		//파일이 오픈된 상태로 휴지통에 넣으면 사용중에 있어 제거가 불가합니다. -> 동기화
		
		TiSys sys = new TiSys();
		
		Thread t1 = new Thread(sys);
		Thread t2 = new Thread(sys);
		Thread t3 = new Thread(sys);
		
		// 모두가 구매를 하게되는상황 -> 블록을 걸어야한다.(synchronized)
		t1.start();
		t2.start();
		t3.start();
		
		
	}//main종료

}
