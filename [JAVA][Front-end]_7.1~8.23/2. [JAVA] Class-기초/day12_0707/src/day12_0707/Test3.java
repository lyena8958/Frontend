package day12_0707;

import java.util.Scanner;

//강사님
class Player{
	Player(String name){
		this.name=name;
		System.out.println(this.name+"님,  참여완료!");
	}
	String name;
	static int sand=100; // 공유자원==클래스변수
	boolean game() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력: ");
		int sand=sc.nextInt();
		this.sand -= sand;
		if(this.sand<=0) {
			return true;
		}
		return false;
	}
}

//예나
class SandGame{
	SandGame(String name){
		this.name = name;
	}
	Scanner sc = new Scanner(System.in);
	String name;
	static int sand = 100;
	
	Boolean game() {
		int ansSub; // 유저 입력값
		System.out.println(this.name+"님 모래를 얼만큼 깎으시겠습니까? ");
		ansSub = sc.nextInt();
		sand -= ansSub;
		if(sand<=0) {
			return true;
		}
	System.out.println("휴!...");
	return false;
}
}

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*1. 플레이어의 수를 입력: 5
		2. 플레이어
		   -이름
		   -공유자원(100에서시작)
		   -boolean game( )
		       1) 얼마나 깎을지를 입력하세요.
		       2) 공유자원--
		       3) false / 게임오버 true 반환
		3. main()에서는 게임오버가 나올때까지 계속 진행
		4. 누가 게임오버인지 출력해주세요!~~*/
		
		
	// 강사님
		System.out.println("플레이어 수 입력: ");
		int num = sc.nextInt();
		Player[] data = new Player[num];
		for(int i= 0; i < data.length;i++) {
			System.out.println("플레이어 이름입력: ");
			String name = sc.next();
			data[i] = new Player(name);
		}
		
		int index = 0;
		while(true) {
			if(data[index].game()) {
				System.out.println("게임 끝!  "+data[index].name+"님 실패!");
				break;
			}
			index++;
			if(index==data.length) {
				index=0;
			}
		}
		
		
		
	// 예나
		//이름과 공유자원
		
		System.out.println("플레이어의 수를 입력하세요. ");
		int people = sc.nextInt();
		
		// 플레이어 배열 
		SandGame[] user = new SandGame[people];
		
		// 생성자 입력(초기화)
		for(int i = 0; i < user.length;i++) {
			System.out.print((i+1)+"번째 유저 이름을 입력: ");
			String name = sc.next();
			user[i] = new SandGame(name);
		}
		
	for(int i = 0;; i++) {
		i = i==people? 0: i; // 인덱스 초기화
		if(user[i].game()) {
			System.out.println("\n스르르륵..... 모래성이 무너졌습니다.");
			System.out.println(user[i].name+"님.....  GAME OVER!!!!\n\n");	
			break;
		}		
	}
	System.out.println("\n프로그램이 종료됩니다.\n\n");
		
} // main 종료
}
