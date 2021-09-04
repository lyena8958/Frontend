package day11_0706;

import java.util.Scanner;

// 강사님 답
class Bomb3{
	Bomb3(String player){
		this.player = player;
	}
	static int bomb = 100;
	String player;
	boolean play(int bomb) {
		this.bomb-=bomb;
		if(this.bomb<=0) {
			System.out.println(this.player+"님, 게임오버!");
			return true;
		}
		return false; // 게임이 안끝남
	}
	
}

// 예나
class Bomb{
	Bomb(String player){
		this.player = player;
	}
	Scanner sc = new Scanner(System.in);
	static int bomb = 100;
	String player;
	void play(int bomb) {
		System.out.println(bomb+" 입력!!");
		this.bomb -= bomb;
		
		if(this.bomb<=0) {
			System.out.println(this.player+"님께서 패배하셨습니다!!!");
			return;
			
		}
		
		}
	}
// 예나 - 변형
class Bomb2{
	Bomb2(String player1, String player2){
		this.player[0] = player1;
		this.player[1] = player2;
	}
	Scanner sc = new Scanner(System.in);
	static int bomb = 100;
	String[] player = new String[2];
	
	void play() {
	int playNum;
	int index = 0;
	while(true) {
		System.out.println(player[index]+"님 차례입니다.\n"+"깎을 숫자를 입력하세요 ");
		playNum = sc.nextInt();
		this.bomb -= playNum;
		if(bomb <= 0) {
			System.out.println("펑!!! "+player[index]+"님 패배!!");
			break;
		}
		index = index==0 ? 1:0;
		
	}
}
}

public class Test9 {

	public static void main(String[] args) {
		/*
	  class Bomb{
      int bomb=100;
	  // 공유자원
	  String player;
	  boolean play(int bomb)
	   : 공유자원이 0이하가 되면 게임오버!
	    게임오버된 사람이름 출력해주세요!~~
	    게임오버가되면 true를 리턴(반환)
			}

		main(){
		   배열이용xxx
	 	   플레이어를 2명 : 이름을 반드시 넣을수있도록!
	       깎을 정도를 입력받아서 진행
		  게임오버가 될때까지 계속}*/
		
		
		// 예나
		Bomb u1 = new Bomb("푸");
		Bomb u2 = new Bomb("피글렛");
		
		u1.play(50);
		u2.play(10);
		u1.play(40);
		
		// 예나2
		Bomb2 u3 = new Bomb2("파인","애플");
		
		u3.play();
		
		// 강사님
		Scanner sc = new Scanner(System.in);
		Bomb3 p1 = new Bomb3("홍길동");
		Bomb3 p2 = new Bomb3("아무무");
	
		while(true) {
			System.out.println("1. 입력: ");
			int bomb = sc.nextInt();
			if(p1.play(bomb)) {
				break;
			}
			
			System.out.println("2. 입력: ");
			bomb = sc.nextInt();
			if(p2.play(bomb)) {
				break;
			}
		}
		// ** 게임이 끝나도 bomb이 100으로 초기화되지않음
		
		
		
	}

}
