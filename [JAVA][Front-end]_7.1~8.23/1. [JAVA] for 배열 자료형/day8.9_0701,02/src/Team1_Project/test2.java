package Team1_Project;

import java.util.Scanner;

public class test2 {
	   // -------------------------------------------사용자 관련 함수 
	   // 메뉴 출력 함수s
	   static void menu(int[][] a, String[] b) {
	      System.out.println(" ====================♥ Flower Machine ♥==================");
	      System.out.println("                 ♥ 사랑하는 사람에게 마음을 전하세요  ♥            \n");
	      System.out.println("                          [MENU]                          \n");
	      for (int i = 0; i < a.length; i++) {
	         System.out.print("["+(i + 1)+"]"+ b[i] + " ");
	         System.out.print(a[i][0] + "원  ");
	      }
	      System.out.println("\n\n"); // 줄바꿈
	   }

	   // 금액 부족시 반환하는 함수
	   static int changeMoney(int money) {
	      if (money < 7000) {
	         System.out.println("[ERROR!!] 금액이 부족합니다  o△o;");
	         System.out.println("반환 금액 :" + money + "원\n");
	         money = 0; // 반환후 초기화
	      }
	      return money; 
	   }

	   // -------------------------------------------관리자 관련 함수
	   // 관리자 모드 메뉴 출력&메뉴번호 입력
	   static void managerMenu() {
	      System.out.println("[1]상품변경  [2]가격변경  [3]재고관리  [4]관리자모드 종료");
	      System.out.print("관리 메뉴 선택 : ");
	   }

	   // 관리자 모드 메뉴선택, 내용변경 함수
	   static Boolean MaNager(int[][] fpriceCnt, String[] flower) {
	      Scanner sc = new Scanner(System.in);
	      System.out.print("관리자 비밀번호 입력 : "); // 관리자 비밀번호 = 1004
	      int pswd = sc.nextInt();
	      if (pswd == 1004) {
	         System.out.println("[ 관리자 모드 ] 에 입장하셨습니다 :D ");
	      } else {
	         System.out.println("[Error] 비밀번호가 틀렸습니다.\nXXXXXX 접근불가 XXXXXX\n");
	         return true; // 관리자모드종료
	      }
	      // 관리할 상품 선택  함수
	      int productNum;
	      
	      // 메뉴번호 유효성검사
	      while(true) { 
	    	   System.out.print("관리할 상품번호 입력 : ");
		       productNum = sc.nextInt();
		       if(1 <= productNum && productNum <= 5) { // 1~5까지
		    	   break;
		       }
		       System.out.println("잘못된 입력입니다. 다시 입력해주세요!( 1~5 )\n");
	      }
	     
	      System.out.println("[ " + flower[productNum-1] + " ] 상품이 선택되었습니다.\n");
	      
	      // 상품관리 메뉴 선택 함수
	      int cateGoryNum; // 카테고리 넘버
	      
	      //카테고리 번호 유효성검사
	      while(true) {
	    	  managerMenu();
		      cateGoryNum = sc.nextInt(); // 카테고리 입력
		      if(1 <= cateGoryNum && cateGoryNum <= 4) { // 1~4까지
		    	  break;
		      }
		      System.out.println("잘못된 입력입니다. 다시 입력해주세요!( 1~4 )\n");
	      }
	      if (cateGoryNum < 4) {
	         if (cateGoryNum == 1) { // 상품변경
	            System.out.print("변경할 상품명 : ");
	            flower[productNum-1] = sc.next();
	            System.out.println(flower[productNum-1] + "(으)로 상품이 변경되었습니다.\n");
	         }
	         else if (cateGoryNum == 2) { // 상품가격변경
	            System.out.println("현재 " + flower[productNum-1] + "의 금액은 " + fpriceCnt[productNum-1][0] + "원 입니다.");
	            System.out.print("변경할 금액을 입력해주세요 : ");
	            fpriceCnt[productNum-1][0] = sc.nextInt();
	            System.out.println(fpriceCnt[productNum-1][0] + "원 으로 금액이 변경되었습니다.\n");
	         } else if (cateGoryNum == 3) { // 재고관리
	            System.out.println("현재 " + flower[productNum-1] + "의 잔여재고는 " + fpriceCnt[productNum-1][1] + " 입니다.\n");
	            System.out.print("추가하실 상품 수를 입력해주세요 : ");
	            int add = sc.nextInt(); // 추가 재고 수
	            fpriceCnt[productNum-1][1] += add;
	            System.out.println("입고 완료되었습니다.\n현재 재고 :  " + fpriceCnt[productNum-1][1] + " 입니다.");
	         }
	         return false;
	      } // 1~3카테고리

	      else { // 4 관리자모드 종료
	         return true;
	      }
	   }

	   // main 시작
	   public static void main(String[] args) {
	      
	         Scanner sc = new Scanner(System.in);
	         // 배열준비
	         String[] flower = { "안개꽃", "수국", "장미", "해바라기", "카네이션" };
	         int[][] fpriceCnt = { { 7000, 2 }, { 15000, 2 }, { 20000, 2 }, { 15000, 0 }, { 12000, 1 } }; // 상품가격&재고가
	                                                                                 // 저장되어있는
	         while (true) {       // 관리자 모드 사용후 사용자 모드 반영을 위해 반복문 사용                                                                  // 이중배열

	         // 사용자모드 와 관리자모드 나눠서 진행
	         System.out.println(" [1]사용자모드   [2]관리자모드  [3]프로그램 종료");
	         System.out.print("메뉴 선택 :  ");
	         int modeSelect = sc.nextInt(); // 사용자 모드 와 관리자 모드 선택

	         if (modeSelect == 2) {
	            // [함수호출]
	            if (MaNager(fpriceCnt, flower)) {
	               System.out.println("관리자모드를 종료합니다 :▶\n");
	               continue;
	            }
	         } else if (modeSelect == 1) {
	            menu(fpriceCnt, flower); // 메뉴판 출력함수 호출

	            // 금액 투입 구현
	            int money; // 사용자가 내는 금액을 입력받아 저장할 변수
	            do {
	               System.out.print("금액 입력 : ");
	               money = sc.nextInt(); // 금액 입력받기
	               // 입력금액이 최소 금액보다 적을때
	               changeMoney(money); // 금액부족시 금액 반환하는 함수 호출
	            } while (money < 7000);

	            // 입력버튼 구현
	            int button;// 입력받을 버튼 생성
	            boolean flag = false;// 상품 출고가 되었는지 확인할 flag 변수
	            while (true) {
	               System.out.print("구매하실 상품 번호를 입력해주세요 ·∪·: ");
	               button = sc.nextInt();
	               System.out.println();

	               // 메뉴 버튼 유효성검사
	               if (button < 1 || 5 < button) {
	                  System.out.println("[ERROR!!] 잘못된 번호입니다∪_∪\n1~5번 사이 입력해주세요 ·∪·\n");
	                  continue;
	               }
	               // 상품 출고
	               for (int i = 0; i < fpriceCnt.length; i++) { // 5번반복
	                  for (int j = 0; j < 1; j++) {
	                     if (button == i + 1) { // 입력한 버튼번호와 상품번호가 일치하다면

	                        if (fpriceCnt[i][1] == 0) { // 만약 버튼을 입력받았으나 재고가 0이거나 그보다 작다면 재고가 없다라는 멘트 출력후 다시 선택
	                           System.out.println("선택하신 상품이 매진되었습니다 T^T");
	                           System.out.println("불편을 드려 죄송합니다.\n ☎ 관리자 연락처 : 123)123-1234 \n");
	                           flag = false;
	                           continue;
	                        }
	                        if (money < fpriceCnt[i][0]) { // 만약 받은돈보다 상품가격이 크면
	                           System.out.println("[ERROR!!] 금액이 부족합니다 ·ㅁ·;;");
	                           continue;
	                        }
	                        fpriceCnt[i][1]--; // i번 인덱스에 재고를 하나 줄이고
	                        money -= fpriceCnt[i][0]; // 낸돈에서 가격만큼 뺀다
	                        System.out.printf("♥[ %s ]♥\n", flower[i]); // i번째상품명이 출고 되었다는 메세지
	                        System.out.println("잔여 금액: \"" + money + "원\" 남았습니다.\n");
	                        flag = true; // 상품 출고를 판별하는 flag
	                     }
	                  }
	               }

	               if (flag == true && money < 7000) { // 상품 출고뒤 금액이 부족하면 종료
	                  break;
	               } else if (flag == true && money >= 7000) { // 상품 출고뒤 금액이 남아있으면 재구매? 중단 선택
	                  System.out.print("상품을 추가 구매하시겠습니까?\nYes = 1, No = 2 : ");
	                  int ansYN = sc.nextInt();
	                  System.out.println();
	                  if (1 == ansYN) { // Yes선택시 리턴
	                     continue;
	                  } else if (2 == ansYN) { // No 선택시 종료
	                     break;
	                  }

	               }
	            }
	            // 남은 돈 반환
	            if (money > 0) {
	               System.out.println("\n반환 금액 : " + money + "원\n");
	               money = 0; // 반환후 money 초기화
	            }

				// 종료멘트
				System.out.println(" ---------------------------------------------------------- ");
				System.out.println("                                    구매해주셔서 감사합니다!♥                 ");
				System.out.println("                                   향기로운 하루 되세요  。˚   。    ˚  ~  ♥               ");
				System.out.println(" ==========================================================");
			
			} else if (modeSelect == 3) {
				System.out.println("\n                  프로그램을 종료합니다 :D\n이용해주셔서 감사합니다  ∪u∪♥ 다음에 또 이용해주세요 ♡  ");
				break;
			} else {
				System.out.println("\n                 잘못된 입력입니다 :-( \n          다시 입력해주세요  1 / 2 / 3\n");

			}
		}
	}
}