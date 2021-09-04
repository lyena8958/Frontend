package Team1_Project;

import java.util.Scanner;

public class projectAn {

    static void menu(int[][] a,String[] b) {
        for (int i = 0; i < a.length; i++) {
            System.out.print((i+1)+":"+b[i] + " ");
            System.out.print(a[i][0] + "원 ");
        }System.out.println("\n\n"); // 줄바꿈
    }
    static int changeMoney(int money){
        if (money < 7000) {
            System.out.println("금액이 부족합니다   ");
            System.out.println("반환 금액 :" + money + "원");
            money = 0; // 반환후 초기화
        }
        return money;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 꽃다발 종류 출력
        String[] flower = {"안개꽃", "수국", "장미", "해바라기", "카네이션"};
        int[][] fpriceCnt = {{7000, 2}, {15000, 2}, {20000, 2}, {15000, 0}, {12000, 1}}; // 상품가격&재고가ㅣ 저장되어있는 이중배열
        

        System.out.println(" 1)사용자모드  2) 관리자모드");
        System.out.print("선택해주세요 :D ");
        int modeSelect = sc.nextInt();

        if (modeSelect == 1) {
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
              changeMoney(money);
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
                                flag = false;
                                continue;
                            }
                            if(money< fpriceCnt[i][0]) { //만약 받은돈보다 상품가격이 크면
                                System.out.println("금액이 부족합니다 TvT");
                                continue;
                            }
                            fpriceCnt[i][1]--;   // i번 인덱스에 재고를 하나 줄이고
                            money -= fpriceCnt[i][0]; // 낸돈에서 가격만큼 뺀다
                            System.out.printf("%s 뿅 \n", flower[i]); // i번째상품명이 출고 되었다는 메세지
                            flag = true; // 상품 출고를 판별하는 flag
                        }
                    }
                }

                if (flag == true && money>=7000) { // 상품 출고뒤 금액이 남아있으면 또 구매
                    continue;
                }else if (flag == true && money<7000) { // 상품 출고뒤 금액이 부족하면 끝내기
                    break;
                }
            }
            // 남은 돈 반환
            if(money>0){
                System.out.println("반환금액 : " + money + "원");
                money = 0; // 반환후 money 초기화
            }
            // 종료멘트
            System.out.println(" 구매해주셔서 감사합니다");
            System.out.println(" 향기로운 하루 되세요 @->->-");

        } else if (modeSelect == 2) {
            while(true) {
                System.out.println("관리자 비밀번호 입력 : ");
                int pswd = sc.nextInt();
                if (pswd == 1004) {
                    System.out.println("[ 관리자 모드 ] 에 입장하셨습니다 :D ");
                    break;
                } else {
                    System.out.println("비밀번호가 틀렸습니다. 접근불가");
                }
            }

            while (true) {
                System.out.println("[1] 상품변경  [2] 상품가격변경  [3]재고관리 [4] 관리자모드 종료");
                System.out.print("메뉴를 선택하세요 : ");
                int manageNum = sc.nextInt();

                if (manageNum == 1) {  // 상품변경
                    for (int i = 0; i < flower.length; i++) {
                        System.out.printf("%d번 변경하실 상품명 : ", i + 1);
                        flower[i] = sc.next();
                    }
                    for (int i = 0; i < flower.length; i++) {
                        System.out.println(flower[i]);
                    }
                }
                else if (manageNum == 2) { // 상품가격변경
                    for (int i = 0; i < fpriceCnt.length; i++) {
                        System.out.printf("%d번 변경하실 금액 : ",i+1);
                        fpriceCnt[i][0] = sc.nextInt();
                    }
                    for (int i = 0; i < fpriceCnt.length; i++) {
                        System.out.println(fpriceCnt[i][0]);
                    }
                }else if (manageNum == 3) {  // 재고관리
                    for (int i = 0; i < fpriceCnt.length; i++) {
                        System.out.printf("%d번 재고 추가 : ",i+1);
                        fpriceCnt[i][1] = sc.nextInt();
                    }
                    for (int i = 0; i < fpriceCnt.length; i++) {
                        System.out.println(fpriceCnt[i][1]);
                    }

                }else if (manageNum == 4) { // 종료조건 구현
                    System.out.println("관리자 모드 종료");
                    break;
                }else{
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                }
            }
        }else{
            System.out.println("잘못된 입력입니다. :( 다시 입력하세요 1 or 2");

        }
    }
}