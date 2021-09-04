package day11_0706_2;

import java.util.Scanner;

class Card{
	// 공개범위를 좁힌 상태다(private와 게터셋터를 사용함으로써)
	// 불필요한 접근, 실수 등을 줄이는 목적
	Card(String name){
		this(name,1234,0);
	}
	Card(String name, int passwd){
		this(name,passwd,0);
	}
	Card(String name, int passwd, int money){
		this.name = name;
		this.passwd=passwd;
		this.money =money;
	}
	private String name;
	private	int passwd;
	private	int money;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPasswd() {
		return passwd;
	}
	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}

public class Test3 {

	public static void main(String[] args) {

		Card card= new Card("아무무", 5678);
		System.out.println(card.getName());
		
		card.setPasswd(8765); // 비밀번호를 바꾸고싶을때
		System.out.println(card.getPasswd());
		/*
	main()함수에 코딩해주세요!~~

	1. 새로 만든 card 객체의
	사용자이름+잔액 출력해주세요!~~

	2. 비밀번호를 변경하고싶어요.
	 1) 현재 비밀번호를 입력: ****
	 2-1)  비밀번호 불일치!
	 2-2)  새 비밀번호를 입력: 
		 변경완료!

	3. 결제시도
     1) 100,000원이상이면 비밀번호를 확인,
	 2) 불일치! / 결제진행!
	    잔액부족! / 결제완료!*/
		Scanner sc = new Scanner(System.in);
		
		// 강사님 답!!
		Card card3 = new Card("아리",1111,200000);
		System.out.println(card3.getName()+"/"+card3.getMoney());
		
		System.out.println("현재 비밀번호 입력: ");
		int passwd = sc.nextInt();
		if(card3.getPasswd()==passwd) {
			System.out.println("새 비밀번호를 입력: ");
			passwd=sc.nextInt();
			card.setPasswd(passwd);
		}
		else {
			System.out.println("비밀번호 불일치!");
		}
		
	      System.out.print("결제금액 입력: ");
	      int money2=sc.nextInt();
	      if(money2>=100000) {
	         System.out.print("비밀번호 입력: ");
	         passwd=sc.nextInt();
	         if(card3.getPasswd()==passwd) {
	            if(card3.getMoney()<money2) {
	               System.out.println("잔액부족!");
	            }
	            else {
	               System.out.println("결제완료!");
	               card3.setMoney(card.getMoney()-money2);
	            }
	         }
	         else {
	            System.out.println("비밀번호 불일치!");
	         }
	      }
	      else {
	         if(card3.getMoney()<money2) {
	            System.out.println("잔액부족!");
	         }
	         else {
	            System.out.println("결제완료!");
	            card3.setMoney(card3.getMoney()-money2);
	         }
	      }

		
		
		
		//예나		
		//1번
		Card card2 = new Card("이예나",6666,200000);
		System.out.println("사용자: "+card2.getName()+"  잔액: "+card2.getMoney()+"원"); // 1번
		
		System.out.println();
		
		//2번
		System.out.println("현재 비밀번호를 입력: ");
		int pw = sc.nextInt();
		
		if(pw==card2.getPasswd()) {
			System.out.println("새 비밀번호를 입력: ");
			card2.setPasswd(sc.nextInt());
			System.out.println(card2.getPasswd()+"로 변경완료!!");
		}
		else {
			System.out.println("[ERROR] 비밀번호 불일치 변경불가");
		}
		
		System.out.println();
		
		//3번
		System.out.println("결제할 금액을 입력하세요 ");
		int money = sc.nextInt();
		if(money >= 100000) {
			System.out.println("10만원 이상 결제금액은 보안을 위해\n"+"비밀번호를 확인하고 있습니다. 4자리를 입력해주세요.");
			pw = sc.nextInt();
			if(pw==card2.getPasswd()) {
				if(card2.getMoney()<money) {
					System.out.println("[ERROR] 잔액부족!! 결제가 취소 됩니다.");
				}
				else {
					card2.setMoney(card2.getMoney()-money);
				System.out.println("결제완료!!  "+"잔액: "+card2.getMoney()+"원");
				}
			}
			else {
				System.out.println("[ERROR] 패스워드 불일치! 결제실패");
			}
		}
		else {
			if(card2.getMoney()<money) {
				System.out.println("[ERROR] 잔액부족!! 결제가 취소 됩니다.");
			}
			else {
				card2.setMoney(card2.getMoney()-money);
			System.out.println("결제완료!!  "+"잔액: "+card2.getMoney()+"원");
			}
			
		}
		
		
	
	}

}
