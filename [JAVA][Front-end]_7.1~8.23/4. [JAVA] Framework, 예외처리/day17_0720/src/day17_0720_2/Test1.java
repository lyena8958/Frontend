package day17_0720_2;

// ex) 포켓몬스터를 상속받은것
// 인터페이스를 사용안하고 직접 run을 오버라이딩할때
class Th1 extends Thread{
	// Thread클래스를 상속받아서 Th1 구현
	// 작업을 수행하는 run() 오버라이딩
	public void run() {//부모가 public이기 때문에 자식도 범위가 public여야만 한다.
		for(int i = 1; i <=10; i++) {
			System.out.println("클래스스레드"+i);
		}
	}
}
// 강제로 run을 부여(함수에서 일일이 적기싫을때)
class Th2 implements Runnable{//Runnable은 추상메서드이다.
	// Runnable 인터페이스를 구현해서 Th2 구현하는방법
	@Override
	public void run() {
		for(int i = 1; i <=10; i++) {
			System.out.println("인터페이스스레드"+i);
			//Thread.sleep(2000); //예외처리 미루기되어있어 try-catch로 구현해야함! // 2초 ->1000당 1초
			//발생예상 오류는 -> 정전이라던지.. 다른 스레드와 데이터전송이 겹치면 오류가 발생될수도있다
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();//빨간글씨보기싫어!
				System.out.println("인터럽트예외발생!");
			}
		}
	}
	
}
public class Test1 {

	public static void main(String[] args) {
		// [스레드]
		// Thread == 일꾼 == 실질적인 작업을 수행하는 대상
		// CPU, 메모리를(자원을) 할당받아야, (==밥을받아야)
		// 프로세스안에서 실질적인 작업을 진행할수있다.
		// ->밥을 주어야 일을하겠다
		
		// application==앱==SW==프로그램
		// 프로세스(실제 실행중) <- 자원을 할당받고
		
		//프로세스가 실행되는 방식
		// 1. 선점형 방식
		//	 : 우선순위 순서로 처리되는 방식
		//   : 기아현상이 발생되는 문제
		// 2. 시간순서처리 방식
		//   : 실행 순서로 진행
		// 3. 시간분할방식(시분할방식)
		//	 : 1+2 복합체

		// 스레드는 생명주기(라이프사이클)에 맞게 동작
		// 생성 -> 대기 -> 수행 --블록(시간/무한정대기)--> 데드(종료,해제) 
		// 					  데드: 메모리를 해제하는 역할
		Th1 t1= new Th1();
		
		Th2 t2 = new Th2();
		Thread t3 = new Thread(t2); // [생성]
		
		// 메인이 먼저 뜸
//		for(int i = 1; i <=10; i++) {
//			System.out.println("메인"+i);
//		}
		
		//[대기]상태 - 생성과 수행 사이
		
		// 우선순위 설정 -> 원랜 디폴트로 5이다.
		t1.setPriority(10);
		t3.setPriority(1);
		// 우선순위는 설정해볼수있으나,
		// 가급적 그렇게 진행하겠다는 것이지 절대적xxx
		
		
		// 자원을 할당해서 일을시키는 동작
		t1.start(); // [수행]
		t3.start();   
		// 어떤 결과가 먼저뜰지는 실행해봐야한다. (아이콘을 동시에 더블클릭 한 듯이)
		
		// 위 스레드가 실행되고 있는 와중에 아래 반복문이 진행돼서 섞여서 나올수도있다.
		for(int i = 1; i <=10; i++) {
			System.out.println("메인"+i);
		}
		
		// [데드]상태
		
		

		
		
		
	}//main
}
