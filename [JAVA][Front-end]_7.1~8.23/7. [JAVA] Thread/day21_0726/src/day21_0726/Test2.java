package day21_0726;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract class Lotto{
	String name;
	int inMoney;
	int outMoney;
	Lotto(String name, int inMoney){
		this.name = name;
		this.inMoney = inMoney;
		rand = new Random();
		lotto = new ArrayList<Integer>();
	}
	Random rand;
	ArrayList<Integer> lotto;
	abstract void game(); // 모든게임은 하위클래스에서 해야해!
}
class Online extends Lotto{
	static ArrayList<Integer> win = new ArrayList<Integer>();
	// 클래스 변수==공유자원
	Online(String name, int inMoney) {
		super(name, inMoney);
		this.outMoney = 10000; // 복권이 당첨되면 무조건 만원
		
		// win이 비어있으면 그때만 돌아 == 최초1번
		if(win.isEmpty()) { // win이 비어있니?
			for(int i = 0; i < 5; i ++) {
				int num = rand.nextInt(15)+1; // 1~15
				if(win.contains(num)) {//win에 방금만든 num이 있니?
					i--;
					continue;	// 다시 num을 만들어..
				}
				win.add(num); // 없을때만 값추가
			}
			System.out.println("당첨번호");
			System.out.println(win);
			
		}
	}

	@Override
	void game() {
		while(inMoney>=1000) {
			inMoney -= 1000;
			while(lotto.size()<5) {
				int num = rand.nextInt(15)+1;
				if(lotto.contains(num)) {
					continue;
				}
				lotto.add(num);
			}
			System.out.println("구매자번호");
			System.out.println(lotto);
			int cnt = 0;
			for(int v:lotto) {
				if(win.contains(v)) {
					cnt++;
				}
			}
			System.out.println("cnt: "+cnt);
			if(cnt>=4) {
				System.out.println("당첨!");
				System.out.println(outMoney+"원 지급!");
			}
			lotto.clear(); // 로또번호 초기화!
		}
		
	}
	
}

class Offline extends Lotto{
	Scanner sc ;
	Offline(String name, int inMoney) {
		super(name, inMoney);
		this.outMoney = (rand.nextInt(3)+1)*1000; // 1000~3000
		sc = new Scanner(System.in);
	}

	@Override
	void game() {
		for(int i =0; i < inMoney/1000;i++) {
			lotto.add(rand.nextInt(2)); // 0~1
		}
		System.out.println("홀짝");
		System.out.println(lotto);
		for(int i = 0; i < inMoney/1000; i++) {
			System.out.println("홀?짝?");
			String ans = sc.next();
			if(lotto.get(i)==0&&ans.equals("짝")||lotto.get(i)==1&&ans.equals("홀")) {
				System.out.println("당첨!");
				System.out.println(outMoney+"원 지급!");
			}else {
				System.out.println("ㅠ");
			}
		}
		
	}
	
}
public class Test2 {

	public static void main(String[] args) {
		
		Online l = new Online("홍길동", 2000);
		l.game();
		Offline l2 = new Offline("홍길동", 2000);
		l2.game();
		
		
	}//main종료

}
