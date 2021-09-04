package day16_0719_2;

import java.util.Scanner;
import java.util.Stack;
//이예나
public class stack_CollectionProject {
	// Stack - 채점프로그램
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int PASS = 1758; // 접속 패스워드 상수
		
		Stack <Integer> score = new Stack(); // 스택 생성
		
		// 프로그램 접속 안내문구
		System.out.println("○○대학교 채점 프로그램 입니다.");
		System.out.print("외부 출입을 제한 하고 있습니다. 패스워드를 입력 해주세요: ");
	
		// 보안 비밀번호 확인
		if(sc.nextInt()!=PASS) { // 입력번호가 다르다면 즉시종료
			System.out.println("패스워드 오류!! 프로그램이 종료됩니다.");
			return;
		}
		// ===========================================================================
		/// ☆★☆★채점프로그램 START☆★☆★
		
		int i = 0; // 입력 횟수 저장변수
		int dataSave = 0; // 실행취소 점수 저장변수
		while(true) {
			System.out.print("[모드 선택] 1:점수입력    2:점수수정    3:종료     ");
			int pickMod = sc.nextInt(); // 모드선택
			System.out.println(); //줄정리
			
			if(pickMod == 1) { // 점수입력모드
			while(true) { // 종료할 때까지 무한반복
			if(i==5) { // 모두 입력하면 입력모드종료
				System.out.println("채점을 모두 입력하여 종료됩니다.\n\n");
				break;
			}
			System.out.println("채점결과를 입력해주세요");
			System.out.println("[기준] 최소점수: 1점 ~ 최대점수: 10점 입니다.(모드 복귀: 0번)");
			int res = sc.nextInt();
			System.out.println(); // 줄정리
			if(res == 0) { // 입력모드 종료
				break;
			}
			else if(1 <= res && res <= 10 ) { // 올바른 숫자 점수입력
				score.push(res);
				System.out.println("입력성공!!");
				System.out.println("=====점수표=====");
				System.out.println(score);
				System.out.println("=============");
				i++; //n번째 입력완료
				System.out.println();
				
			}
			else {
				System.out.println("[점수입력 오류] 잘못된 입력입니다.\n");
				continue;
			}
				} // 반복문종료
			}//입력모드 종료
			
			else if(pickMod==2) { // 수정모드
				if(score.size()==0) {//저장된 점수가없으면 수정모드종료
					System.out.println("현재까지 입력된 값이 없습니다. 모드창으로 돌아갑니다.\n");
					continue;
				}
				System.out.print("점수 실행취소: 0번, 취소점수 불러오기: 1번을 입력해주세요.\n[주의사항] 위 설정은  마지막에 입력된 점수에만 반영이 됩니다. ");
				pickMod = sc.nextInt();
				System.out.println(); // 줄정리
				if(pickMod == 0) {//점수 실행취소
					dataSave = score.peek(); // 취소점수 저장
					System.out.println(dataSave+" 점수가 취소됩니다. . . .\n");
					score.pop(); // 최근에 입력된 점수삭제
					System.out.println("==현재 점수==");
					System.out.println(score);// 현재까지 저장된점수 안내
					System.out.println("=========\n");
					i--; //입력횟수차감
				}
				else if(pickMod == 1) {// 취소된 점수 불러오기
					if(dataSave == 0) { // 저장점수가 없다면 첫모드 복귀
						System.out.println("저장된 점수가 없습니다.\n");
						continue;
					}
					// 있다면 실행
					System.out.println("가장 최근에 취소된 점수입니다. : "+dataSave);
					System.out.println("점수를 불러옵니다.\n");
					i++; // 입력횟수증가
					score.push(dataSave);
					System.out.print("입력 완료! : ");
					System.out.println(score);
					System.out.println(); //줄정리
					
				}
				
			}
			
			else if(pickMod==3) { // 종료모드
				System.out.println("채점 프로그램이 종료됩니다. 이용해 주셔서 감사합니다. :)");
				break;
			}
			
		}//while종료
		
		// 입력된 채점점수 총합 출력
		int sum = 0;
		for(int v: score) {
			sum +=v;
		}
		System.out.println("총점은 "+sum+"입니다!!");
		
		}// main종료
}

// LinkedList 
// 도서대출프로그램
// 3권 Book 제목, 대여여부(몇권있는지)
// 1.대여 2.반납 3.목록보기 4.종료
// +++)Persom

// Stack
// 채점프로그램 
// 1) 몇번 채점을 시도하는지 입력 (5번 입력) 1 2 4 0 0 5 6
// 2) 1~10까지 입력가능 단, 0을 입력하면 "실행취소"
// 실행취소할 액션이 남아있나?
// 3) 5번의 총합 출력


// Queue
// 영화 대기열 프로그램
// 1. 예약 2.입장 3.대기열출력 4.종료
// 1) 몇명?
// 2) 입장
// Person 
//		이름
//		예약번호
