package Team1_Project;

import java.util.Scanner;

public class yena2_An {

    static void menu(int[][] a,String[] b) {
        for (int i = 0; i < a.length; i++) {
            System.out.print((i+1)+":"+b[i] + " ");
            System.out.print(a[i][0] + "원 ");
        }System.out.println("\n\n"); // 줄바꿈
    }
    static int changeMoney(int button,int money,int[][]fpriceCnt){
        if (money >= fpriceCnt[button][0]) {
            money -= fpriceCnt[button][0]; // 반환후 초기화
            System.out.println("반환 금액 :" + money + "원\n\n");
        }
        else if (money < 7000) {
        	System.out.println("금액이 부족합니다 . ");
        }
        return money;
    }

    //함수 [예나] - 메뉴선택 - 카테고리 - 변경 
    static Boolean MaNager(int[][] fpriceCnt, String []flower){
    	Scanner sc = new Scanner(System.in);
    	
        System.out.println("관리자 비밀번호 입력 : ");
        int pswd = sc.nextInt();
        if (pswd == 1004) {
            System.out.println("[ 관리자 모드 ] 에 입장하셨습니다 :D ");
        } else {
            System.out.println("비밀번호가 틀렸습니다. 접근불가");
            return true; // 관리자모드 종료
        }
    	// 꽃 메뉴입력
        int menuNum;
    		do {//메뉴번호 유효성검사
    	System.out.println("관리할 상품번호를 입력하세요. ");
    	menuNum = sc.nextInt();	
    	System.out.println(flower[menuNum-1]+" 선택!!\n\n");
    		}while(menuNum < 1 || 5 < menuNum); 
    	 
    	// 	카테고리 선택
    	int cateGoryNum; // 카테고리 넘버
    		do {
        System.out.println("[1] 상품변경  [2] 상품가격변경  [3]재고관리 [4] 관리자모드 종료");
        System.out.print("메뉴를 선택하세요 : ");
        cateGoryNum = sc.nextInt(); // 카테고리 입력
    		}while(cateGoryNum < 1 || 4 < cateGoryNum);
    		if(cateGoryNum<4) {
        if (cateGoryNum == 1) {  // 상품변경
                System.out.printf("변경하실 상품명 : ");
                flower[menuNum-1] = sc.next();
                System.out.println(flower[menuNum-1]+"원 (으)로 상품이 변경되었습니다.\n");
        }
        
        else if (cateGoryNum == 2) { // 상품가격변경
                System.out.println("현 "+flower[menuNum-1]+"의 금액은 "+fpriceCnt[menuNum-1][0]+" 입니다.");
                System.out.println("변경 금액을 입력해주세요 : ");
                fpriceCnt[menuNum-1][0] = sc.nextInt();
                System.out.println(fpriceCnt[menuNum-1][0]+"으로 금액이 변경되었습니다.\n");
        }
        else if (cateGoryNum == 3) {  // 재고관리
        	System.out.println("현 "+flower[menuNum-1]+"의 잔여재고는 "+fpriceCnt[menuNum-1][1]+" 입니다.");
        	System.out.println("추가 재고 수를 입력해주세요 : ");
        	int add = sc.nextInt(); // 추가 재고 수
            fpriceCnt[menuNum-1][1] += add;
            System.out.println("입고 완료!! 현 재고는 "+fpriceCnt[menuNum-1][1]+" 입니다.");
        }
        return false;
    		} // 1~3카테고리
    		
        else { // 4 관리자모드 종료
        	return true;
        }
    		}
    		



    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
		String[] flower = {"안개꽃", "수국", "장미", "해바라기", "카네이션"};
        int[][] fpriceCnt = {{7000, 2}, {15000, 2}, {20000, 2}, {15000, 0}, {12000, 1}}; // 상품가격&재고가ㅣ 저장되어있는 이중배열
		
    	while(true) {

    	  System.out.println(" 1)사용자모드 \t2) 관리자모드\t3)프로그램 종료");
          System.out.print("선택해주세요 :D ");
          int modeSelect = sc.nextInt();
         
    	if(modeSelect==1) {
               // 꽃다발 자판기
            System.out.println(" ==========* Flower Machine *========");
            System.out.println("        ♥ 사랑하는 사람에게 마음을 전하세요  ♥   \n");
            System.out.println("              MENU          ");


            menu(fpriceCnt, flower); // 메뉴판 출력함수 호

        // 금액투입
            int money; // 사용자가 내는 금액을 입력받아 저장할 변수
            do {
                System.out.print("금액 투입구 : ");
                money = sc.nextInt(); // 금액 입력받기
                // 입력금액이 최소 금액보다 적을때
            	if(money < 7000) {
          		  System.out.println("금액이 부족합니다   ");
          	         System.out.println("반환 금액 :" + money + "원");
          	         money = 0; // 반환후 초기화
          	}
            } while (money<7000);
         // 입력버튼
            int button;// 입력받을 버튼 생성
            boolean flag = false;// 상품 출고가 되었는지 확인할 flag 변수
            while (true) {
                System.out.print("구매하실 상품 번호를 입력해주세요 uUu : ");
                button = sc.nextInt();

                // 메뉴 버튼 유효성검사
                if (button < 1 || 5 < button) {
                    System.out.println("잘못된 번호입니다  1~5번 사이 입력해주세요");
                    continue;
                }
                // 상품 출고
                for(int i=0;i<fpriceCnt.length;i++) { //5번반복
                    for(int j=0;j<1;j++) {
                        if(button == i+1) { // 입력한 버튼번호와 상품번호가 일치하다면
                            if(fpriceCnt[i][1]==0) { // 만약 버튼을 입력받았으나 재고가 0이거나 그보다 작다면 재고가 없다라는 멘트 출력후 다시 선택
                                System.out.println("선택하신 상품이 매진되었습니다 T^T");
                                System.out.println("관리자에게 연락해놓겠습니다 T^T");
                                money += fpriceCnt[button][0];
                                flag = false;
                                continue;
                            }
                            if(money< fpriceCnt[i][0]) { //만약 받은돈보다 상품가격이 크면
                                System.out.println("금액이 부족합니다 TvT");
                                continue;
                            }
                            fpriceCnt[i][1]--;   // i번 인덱스에 재고를 하나 줄이고
                            money -= fpriceCnt[i][0]; // 낸돈에서 가격만큼 뺀다
                            System.out.printf("♥ [ %s ] ♥\n", flower[i]); // i번째상품명이 출고 되었다는 메세지
                            System.out.println("잔여금액: \""+money+"원\" 남았습니다.");
                            flag = true; // 상품 출고를 판별하는 flag
                        }
                    }
                }
                if (flag == true && money < 7000) { // 상품 출고뒤 금액이 부족하면 종료
                    break;
                 } else if (flag == true && money >= 7000) { // 상품 출고뒤 금액이 남아있으면 재구매? 중단 선택
                    System.out.println("상품을 추가 구매하시겠습니까? 구매 = 1, 이제그만 = 2");
                    int ansYN = sc.nextInt();
                    if (1 == ansYN) { // Yes선택시 리턴
                    	System.out.println(money+"원 남았습니다.\n");
                       continue;
                    }else if(2==ansYN) { // No 선택시 종료
                    	money = changeMoney(button,money,fpriceCnt);
                              break;
                           }

                 }
            
            // 남은 돈 반환
                money = changeMoney(button,money,fpriceCnt);
            // 종료멘트
          
       
        }
            System.out.println(" 구매해주셔서 감사합니다");
            System.out.println(" 향기로운 하루 되세요 @->->-");

        
        } // user
    	
    	if(modeSelect==2) {
        	//[함수호출]
        	if(MaNager(fpriceCnt,flower)) {
            	System.out.println("관리자모드 종료\n================================");
            	continue;
        	} 
    	}// manager
    	
        if(modeSelect==3) {
        	System.out.println("프로그램이 종료 되었습니다.\n");
        	break;
        }
    	   
    	}// 프로그램 종료


    }
}
