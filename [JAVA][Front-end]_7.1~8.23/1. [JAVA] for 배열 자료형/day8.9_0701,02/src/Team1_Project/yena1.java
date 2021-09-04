

/* 예나 프로젝트 메뉴얼
 * 금액입력 -> 최저가 7000원 미만 입력시 -> [유효성검사] 재입력
 *	
 * *자판기 시작
 * 1. 메뉴표 안내
 * 2. 메뉴번호입력 → [유효성검사]if(입력금액-선택메뉴금액) < 0 이면 continue(1부터 재시작-메뉴재입력)
 * 3. if(재고 매진) → 입력(1:상품재선택, 2:종료) → 여부에따라 continue or break(잔돈반환) 결정
 * 4. 잔돈반환 → 잔돈만큼 10000, 5000...100원 cnt → cnt 1이상이면 출력멘트 나감  
 * 5. 감사인사 후 종료~~!!!!
 * */

package Team1_Project;
import java.util.Scanner;
public class yena1 {
	//[상수]
	final int SU = 5; // 메뉴판 개수
	final static int managerpass = 5959; // 메뉴판 개수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 메뉴
		String[] muName = {"안개꽃", "수국", "장미", "해바라기","카네이션"};
		
		// 제품 금액과 재고
		int[][] priceCnt = { {7000,15000,20000,15000,12000}, {1, 3, 5, 10, 0} };
		
		int money; // 사용자 현금
		
		System.out.println("구매시작: 눌러주세요!");
		int buystart = sc.nextInt();
		
		if(MaNager(priceCnt,buystart)) { //구매시작버튼이 관리자번호랑 같다면 재고추가 후, 시스템 종료
			System.exit(0);
		}
		
		menuPrint();
		
		do {//[유효성검사] 미만금액 입력시 반복 
		System.out.print("금액 투입(7,000원 이상): ");
		money = sc.nextInt();
	}while(money < 7000);

		System.out.println("[ "+money+" ] 저장");
		
		int button; // 메뉴 입력버튼
		
		// ★자판기 이용 START★
		while(true) { 
			
			//현금 지폐종류 및 반환개수 카운트
			int mCount[][] = { { 10000, 5000, 1000, 500, 100 } , {0,0,0,0,0} };
			
			// [함수]메뉴판 안내
			menuPrint();
			
			System.out.println("자판기 번호 클릭(1~5): ");
			button = sc.nextInt();
			
			// [유효성검사]입력버튼 
			if(button<1||5<button) {
				System.out.println("[Error] 메뉴번호 1~5번 사이 재입력 해주세요.");
				continue;  // 번호 오입력 → 메뉴판부터 재안내
			}
			
			
			// 입력한 금액 - 선택 메뉴 = 마이너스 금액 확인하는 변수
			int minus = money - priceCnt[0][button-1];
			
			// [유효성검사]투입금액 - 구매금액 = 0 미만인 경우, 메뉴 재선택
			if(minus<0) { // + 시간이 된다면 금액을 처음부터 입력하는 것 도 좋을듯!!~
				System.out.println("\n===================================================");
				System.out.printf("[재입력] 입력금액: %d, %s: %d원 = %d원이 부족합니다.\n메뉴 선택창으로 되돌아갑니다.\n",money,muName[button-1], priceCnt[0][button-1],priceCnt[0][button-1]-money);
				System.out.println("===================================================\n\n");
				continue;
			}
			
			// 선택된 메뉴안내
			System.out.println(muName[button-1]+" 선택!\n");
			
			money -= priceCnt[0][button-1]; //반환할 금액
			
			
			// 재고 감소
			priceCnt[1][button-1]--;
			
			// 매진된 상품이 있다면, 재선택or구매취소 택일을 한다. (재선택==1)
			if(priceCnt[1][button-1] < 0) {
			if(soldout(priceCnt[1][button-1])){
				mReturn(mCount,money); // [함수] - 잔돈받을 지폐 cnt 
				break;
			}
			else {
				continue;
			}
			}
			
			mReturn(mCount,money); // [함수] - 잔돈받을 지폐 cnt 
			
			break;
		}
		System.out.println("\n♡♡♡꽃 자판기 이용해 주셔서 감사합니다♡♡♡ *아름다운 하루 보내세요  \n");

	} //====================================================================================================================== main
	 //=======================================================================================================================  종료
	// 관리자 모드 함수
	public static Boolean MaNager(int[][] priceCnt,int pass) {
		Scanner sc = new Scanner(System.in);
		if(pass==managerpass) {
			
			System.out.println("재고를 추가할 메뉴번호를 입력: ");
			int mgnum = sc.nextInt();	// 관리자 메뉴번호 입력
			System.out.println("재고 개수입력: ");
			int cntAdd = sc.nextInt(); // 추가할 재고개수
			priceCnt[1][mgnum] += cntAdd; 
			
			return true;
			
		}
		return false;
	
	}
	
	
	// 매진 안내 함수(1또는 0 반환)
	public static Boolean soldout(int user) {
		Scanner sc = new Scanner(System.in);
		

			System.out.println("선택하신 상품이 매진되었습니다.\n");
			
			do { //[유효성검사] 안내멘트 1,0 외 값 입력할 경우 반복
				System.out.print("상품 재선택: 1번\t구매 취소: 2번 입력 >> ");
				user = sc.nextInt(); // 변수 재사용	
			}while(!(user==1||user==2));
			if(user==1) {
				return false;
			}
			else {
				return true;
			}
		}//if종료
	
	   static int MoneyCom(int money) {
		      if (money < 7000) {
		         System.out.println("[ERROR!!] 금액이 부족합니다  o△o;");
		         System.out.println("반환 금액 :" + money + "원\n");
		         money = 0; // 반환후 초기화
		      }
		      return money; 
		   }	
	// 반환금액 출력(지폐별)
	public static int CashReturn(int[][] mCount, int money){
	   if (money > 0) { // 반환할 금액이 0보다 크면
		   System.out.print("[ ");
        	System.out.println(money+"원 반환됩니다.");
            for (int i = 0; money > 0;) { // 잔돈이 0이 될때까지 반복
            
                if (money >= mCount[0][i] ) { // 10000..500..10원 단위로 보다 작다면?
                	mCount[1][i]++;	// 지폐 cnt++;
                    money -= mCount[0][i]; // 저장된 지폐수만큼 잔돈 차감 
                }
                else {
                	i++;
                }
            }//for1
            for (int i = 0; i < 5; i++) {
                if (mCount[1][i]==0) { // 지폐마다 반환할 현금이 없다면, 되돌아간다.
                    continue;
                }
                else { // 출력될 현금 안내
                	System.out.println("- "+mCount[0][i]+"원: "+mCount[1][i]+"장 ");
            }
                System.out.print("]");
        }//for2
		
	}//if>0 
        else {
        	System.out.println("반환금액 = 0\n");
        }
	   
	   return money; // 남은 money 반환
	}//함수종료
	
	// [함수] 메뉴판 출력
	public static void menuPrint() {
		System.out.println("˚         。  ˚   ˚");
		System.out.println("∴ ∴ ∴ ∴ ∴。∴˚∴ ∴˚∴ ˚˚∴ ∴˚∴ ˚˚∴ ∴˚∴ ˚˚∴ ∴˚∴ \n∴ ∴ ∴꽃˚자판기。∴˚∴ ∴˚∴∴˚∴ ∴˚∴∴˚∴ ∴˚∴∴˚∴ ∴˚∴");
		System.out.println(" ∴ ∴ ∴˚∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴\n∴ ∴ ∴ ∴  ⌒∴ ⌒∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴");
		System.out.println(" _-(())(())-_ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴\n-((()))♥((()))- ∴  1.안개꽃     7,000원∴ ∴˚∴ ∴ ");
		System.out.println("(())∞((∂))∞(())∴ ∴ 2.수국      15,000원 ∴ ∴ ∴ ∴˚ \n∴ ∴ ∴(())∞(()) ∴ ∴ ∴  3. 장미     20,000원∴ ∴˚∴ ∴ ");
		System.out.println("∴   ∴   ∴  ∴ | |  ∴ ∴ ∴ ∴   4. 해바라기 15,000원 ∴ ∴ ∴ ∴ \n∴  ∴ ∴ ∴ ∴   == ∴ ∴ ∴ ∴ ∴    5. 카네이션 12,000원 ∴ ∴˚");
		System.out.println("∴  ∴  ∴ ∴ d| |b ∴ ∴ ∴ ∴ ∴˚∴ ∴ ∴。∴ ∴ ∴˚∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴  \n∴  ∴  ∴  ∴  ∴  ∴  ∴  ∴  ∴˚ ∴  ∴  ∴ ˚ ∴  ∴  ∴˚ ∴  ∴ ∴  ∴ ∴ ∴ ∴ ∴");
		System.out.println(" ∴ ∴ ∴ ∴˚∴ ∴ ∴ ∴ ∴˚∴ ∴ ∴ ∴ ∴˚∴ ∴ ∴ ∴˚∴ ∴ ∴ ∴ ∴ ∴ ∴  ∴ ∴ ∴ ∴  \n∴ ∴ ∴ ∴ ∴ ∴˚ ∴ ∴ ∴ ∴˚∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ \n∴ ∴。∴ ∴˚∴ ∴ ∴ ∴˚∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴ ∴");	
			}
	
}
