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
	abstract void game(); // �������� ����Ŭ�������� �ؾ���!
}
class Online extends Lotto{
	static ArrayList<Integer> win = new ArrayList<Integer>();
	// Ŭ���� ����==�����ڿ�
	Online(String name, int inMoney) {
		super(name, inMoney);
		this.outMoney = 10000; // ������ ��÷�Ǹ� ������ ����
		
		// win�� ��������� �׶��� ���� == ����1��
		if(win.isEmpty()) { // win�� ����ִ�?
			for(int i = 0; i < 5; i ++) {
				int num = rand.nextInt(15)+1; // 1~15
				if(win.contains(num)) {//win�� ��ݸ��� num�� �ִ�?
					i--;
					continue;	// �ٽ� num�� �����..
				}
				win.add(num); // �������� ���߰�
			}
			System.out.println("��÷��ȣ");
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
			System.out.println("�����ڹ�ȣ");
			System.out.println(lotto);
			int cnt = 0;
			for(int v:lotto) {
				if(win.contains(v)) {
					cnt++;
				}
			}
			System.out.println("cnt: "+cnt);
			if(cnt>=4) {
				System.out.println("��÷!");
				System.out.println(outMoney+"�� ����!");
			}
			lotto.clear(); // �ζǹ�ȣ �ʱ�ȭ!
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
		System.out.println("Ȧ¦");
		System.out.println(lotto);
		for(int i = 0; i < inMoney/1000; i++) {
			System.out.println("Ȧ?¦?");
			String ans = sc.next();
			if(lotto.get(i)==0&&ans.equals("¦")||lotto.get(i)==1&&ans.equals("Ȧ")) {
				System.out.println("��÷!");
				System.out.println(outMoney+"�� ����!");
			}else {
				System.out.println("��");
			}
		}
		
	}
	
}
public class Test2 {

	public static void main(String[] args) {
		
		Online l = new Online("ȫ�浿", 2000);
		l.game();
		Offline l2 = new Offline("ȫ�浿", 2000);
		l2.game();
		
		
	}//main����

}
