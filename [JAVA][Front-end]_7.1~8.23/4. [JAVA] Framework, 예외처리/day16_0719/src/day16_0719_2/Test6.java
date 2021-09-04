package day16_0719_2;

import java.util.ArrayList;
import java.util.Scanner;

// 자판기 프로그램 -> 컬렉션 프레임워크를 활용해보자!
class Cafe {
	String manu;
	int price;
	int cnt; // 재고

	Cafe(String menu) {
		this(menu, 2000);
	}

	Cafe(String menu, int price) {
		this.manu = menu;
		this.price = price;
		this.cnt = 5;
	}

	void change(String menu) {
		this.manu = menu;
		System.out.println("메뉴이름 변경완료!");
	}

	void change(int price) {
		this.price = price;
		System.out.println("가격변경완료!");
	}

	void addCnt() {// 재고추가는 고정 10개
		this.cnt += 10;
		System.out.println(this.manu + "이(가) 추가됨!");
	}

	@Override
	public String toString() {
		return manu + ": " + price + "원 [" + cnt + "]";
	}

	public boolean equals(Object obj) {
		Cafe c = (Cafe) obj;
		if (c.manu == this.manu) {
			return false;
		}
		return true;
	}

}

public class Test6 {
	static int NumCheck(int a, int b, int num) {

		while (true) {
			if (num < a || b < num) {
				System.out.println("[오입력] " + a + "이상 " + b + "이하로 다시 입력해주세요!");
				num = new Scanner(System.in).nextInt();
				continue;
			}
			break;
		}
		return num;
	}

	public static void main(String[] args) {
		/* 문제
		프로그램실행

		1.구매 2.변경 3.재고추가 4.종료

		1)
		목록보기
		구매번호
		수량
		총 결제 금액

		2)
		메뉴이름 vs 가격

		3)
		목록보기
		추가번호*/
		Scanner sc = new Scanner(System.in);
		ArrayList<Cafe> cafe = new ArrayList();
		ArrayList<Cafe> al = new ArrayList(); // 강사님

		al.add(new Cafe("아메리카노"));
		al.add(new Cafe("카페라떼", 2500));

		// 강사님 답
		/*
		while (true) {
			System.out.println("1-구매 2-변경 3-재고추가 4-메뉴추가 5-종료");
			int act = sc.nextInt();
			if (act == 1) {
				System.out.println("==메뉴판==");
				for(int i = 0; i < al.size();i++) {
					System.out.println((i+1)+"번 "+al.get(i));
				}
				System.out.println();
				System.out.println("구매할 메뉴의 번호입력: "); 
				int num = sc.nextInt(); // 유효성검사가 필요하나 생략
				System.out.println("구매 수량 입력");
				int cnt = sc.nextInt(); // 생략2
				if(al.get(num-1).cnt<cnt) {
					System.out.println("수량부족!");
					continue;
				}
				System.out.println("총 금액은 "+al.get(num-1).price*cnt+"원입니다.");
				al.get(num-1).cnt-=cnt;
				
			} 
			  else if(act==2) {
		            System.out.println("변경할 메뉴의 번호입력");
		            int num=sc.nextInt();
		            System.out.println("1-메뉴명변경  2-가격변경");
		            int ans=sc.nextInt();
		            if(ans==1) {
		               al.get(num-1).change("메뉴명");
		            }
		            else {
		               al.get(num-1).change(1000);
		            }
		         }

			else if (act == 3) {
				for (Cafe menu : al) {
					System.out.println(menu);
				}
				System.out.println("재고를 추가할 메뉴번호입력");
				int num = sc.nextInt();
				if (num < 1 || al.size() < num) {
					System.out.println("번호에러!");
					continue;
				}
				al.get(num - 1).addCnt();
			} 
			else if (act == 4) {
				System.out.println("추가하실 메뉴의 이름입력");
				String name = sc.next();
				System.out.println("가격을 함께 입력?");
				String ans = sc.next();
				if(ans.equals("yes")||ans.equals("Y")) { // 메뉴+가격입력
					System.out.println("가격입력");
					int price = sc.nextInt();
					al.add(new Cafe(name,price));
				}
				else {// 메뉴입력
					al.add(new Cafe(name));
				}
			} 
			else if (act == 5) {
				break;
			} 
			else {
				System.out.println("잘못입력함!");
			}
		}*/

		// 예나
		// 구매모드에 재고비교와 총금액 구현필요
		while(true) {
			System.out.println("1.사용자모드  2. 관리자모드  3. 프로그램 종료");
			int ans = NumCheck(1,3,sc.nextInt());
			//사용자모드
			if(ans == 1) {
			while(true) {
				System.out.println("==사용자모드==\n1.메뉴판 확인  2. 구매  3. 사용자 종료");
				ans = NumCheck(1,3,sc.nextInt());
				// 메뉴판확인
				if(ans==1) {
					System.out.println("========메뉴판=======\n");
					for(Cafe v: cafe) {
						System.out.println(v);
					}
				}//ifend
					else if (ans == 2) {
						if (cafe.size() == 0) { // 유효성검사
							System.out.println("구매할 물품이 없습니다. 이용에 불편을 드려 죄송합니다.");
							continue;
						}
						int pay = 0; //결제금액
						while (true) {
							System.out.println("구매종료: 0번입니다. 계속 구매하시려면 다른숫자를 입력하세요");
							ans = sc.nextInt();
							if (ans == 0) {
								break;
							}
							System.out.println("========메뉴판=======\n");
							for (Cafe v : cafe) {
								System.out.println(v);
							}
							System.out.println("구매하실 메뉴의 번호를 입력해주세요!");
							ans = NumCheck(1, cafe.size(), sc.nextInt());
							if (cafe.get(ans - 1).cnt == 0) {
								System.out.println("[구매 오류] 해당 메뉴 재고가 없어 구매가 불가합니다.");
								continue;
							}
							System.out.println(cafe.get(ans - 1) + " 주문완료!!");
							pay +=cafe.get(ans-1).price;
							System.out.println("총 금액: "+pay);
							cafe.get(ans - 1).cnt--;
						}
					}
				else {
					System.out.println("사용자 모드를 종료합니다! 이용에 감사드립니다.");
					break;
				}
				
			}
			}
			
			
		else if (ans ==2) {
		while (true) {
			System.out.println("==관리자모드==\n1.메뉴 및 가격변경\t2.재고추가\t3.메뉴추가\t4.종료");
			ans = NumCheck(1, 5, sc.nextInt());
				if (ans == 1) {// 변경
				System.out.println("[변경모드] 1.메뉴이름\t2.가격\t");
				ans = NumCheck(1, 2, sc.nextInt());
				System.out.println("========메뉴판=======\n");
				for (Cafe v : cafe) {
					System.out.println(v);
				}
				System.out.println(ans + "번 모드선택: 변경할 메뉴를 선택해주세요!");
				int menuPick = NumCheck(1, cafe.size(), sc.nextInt());
				if (ans == 1) {// 메뉴이름변경
					System.out.println("변경할 메뉴이름을 입력해주세요!");
					String manuName = sc.next();
					boolean flag = true;
					for (int i = 0; i < cafe.size(); i++) {
						if (manuName.equals(cafe.get(i).manu)) {
							System.out.println(cafe.get(menuPick - 1).manu + "→ " + manuName + "변경완료!!");
							cafe.get(menuPick - 1).manu = manuName;
							flag = false;
						}
					}
				} else if (ans == 2) {// 가격변경
					System.out.println("변경할 금액을 입력해주세요!");
					ans = sc.nextInt();
					System.out.println(cafe.get(menuPick - 1).price + "→ " + ans + "변경완료!!");
					cafe.get(menuPick - 1).price = ans;
				}
			} else if (ans == 2) {// 재고추가
				System.out.println("재고를 추가할 메뉴를 선택해주세요!");
				for (Cafe v : cafe) {
					System.out.print(v);
					System.out.println();
				}
				ans = NumCheck(1, cafe.size(), sc.nextInt());
				System.out.println(cafe.get(ans - 1).manu + "선택하셨습니다. 추가할 재고개수를 입력하세요: ");
				int add = sc.nextInt();
				cafe.get(ans - 1).addCnt();
			} else if (ans == 3) { // 메뉴추가
				System.out.println("추가할 메뉴를 문자로 입력해주세요!");
				String menuAdd = sc.next();
				boolean flag = false;
				// 메뉴명 유효성검사
				for (int i = 0; i < cafe.size(); i++) {
					if (cafe.get(i).manu.equals(menuAdd)) {
						flag = true;
					}
				}
				if (flag) {// 중복된 메뉴가 있으면 모드로 복귀
					System.out.println("[오류] 중복된 메뉴로 등록이 불가합니다.");
					continue;
				}
				System.out.println("금액을 입력해주세요!");
				ans = sc.nextInt();
				cafe.add(new Cafe(menuAdd, ans));
				System.out.println("[신메뉴] " + menuAdd + ": " + ans + "원 등록 완료!!");
			} else if (ans == 4) {// 종료
				System.out.println("카페 프로그램을 종료합니다. 이용해 주셔서 감사합니다!");
				break;
			}

		}
		}
		else {
			System.out.println("카페 프로그램이 종료됩니다. 이용해 주셔서 감사합니다.");
			break;
		}
		}

	}// main종료
}
