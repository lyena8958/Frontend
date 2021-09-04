package day10_0705;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1번 문제) 휴대폰 번호를 입력하세요
		// 1번째: 010
		// 2번째: 1234
		// 3번째: 5678
		
		/* 강사님 답
	     System.out.println("휴대폰 번호를 입력하세요.");
	      String str=sc.next();
	      String[] number=str.split("-");
	      for(int i=0;i<number.length;i++) {
	         System.out.println((i+1)+"번째: "+number[i]);
	      }*/
		
		
		/* 예나
		System.out.println("휴대폰 번호를 입력하세요.");
		String str = sc.next();
		String[] phoneNum = str.split("-");
		
		int i = 1;
		for(String v:phoneNum) {
			System.out.println(i+"번째: "+v);
			i++;
		}
		*/
		
	    //====================================================
		
		// 2번 문제)
		// 대소문자가 섞인 문자열을 입력
		// 소문자로 apple
		// 대문자로 APPLE
	      
		/* 강사님 답!
	     System.out.println("대소문자가 섞인 문자열 입력");
	     String str2=sc.next();
	     System.out.println("소문자로 "+str2.toLowerCase());
	     System.out.println("대문자로 "+str2.toUpperCase());*/
	      
		/*예나
		System.out.print("대소문자가 섞인 문자열을 입력");
		String str2 = sc.next();
		System.out.println("소문자: "+str2.toLowerCase());
		System.out.println("대문자: "+str2.toUpperCase());*/
		
		//====================================================
		
		// 3번 문제)
		// 다시할까요? y, yes, yEs, Y, YeS ... 계속 진행
	    // [즉시종료]
		
	    // 강사님의 답!
	    // 1. 검열방식 - 게임에서 욕설을하면 *** 처리되는 것처럼
		/*
		String [] checkData = new String[3]; // 검열대상단어목록
		checkData[0] = "yes";
		checkData[1] = "Yes";
		checkData[2] = "yEs";
		
		while(true) {
			System.out.println("계속할까요?");
			String ans = sc.next();
			Boolean flag = false;
			for(int i = 0; i < checkData.length;i++) {
				if(checkData[i].equals(ans)) {
					flag=true;
					break;
				}
			}
			if(flag) { // 검열단어에 ans가 있다면,
				break;
			}
	     } */
		
		// 2. 소대문자 변환
		while(true) {
			System.out.println("다시할까요?");
			String ans = sc.next();
			ans = ans.toLowerCase();
			// yes, Yes, YES -> yes
			// y, Y -> y
			if(!ans.equals("yes") && !ans.equals("y")) {
				break;
			}
			
		}//while 종료
	     
		
		/* 예나
		System.out.print("다시 하시겠습니까? ");
		String ans = sc.next();
		
		ans = ans.toLowerCase();
		
		while(true)(
		if(ans.equals("y")||ans.equals("yes")) {
			System.out.println("계속 진행....");
		}
		else {
			System.out.println("[즉시 종료]");
			break;
		}
	}*/
		

	} // main종료

}
