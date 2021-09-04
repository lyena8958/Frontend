package day13_0714;

import java.util.Scanner;

public class Test1 {
	/*
	메뉴 5개
	1.치즈버거 400
	2.야채버거 340
	3.우유 170
	4.계란말이 100
	5.샐러드 70
	메뉴를 2개 선택
	합이 500보다 크면 angry, no angry

	1. 배열 세팅
	 - 서로 관련된 데이터인가?
	 - 같은 자료형인가?
	 - 요소의 개수를 정확히 알고있나?
	=> 메뉴명 String[] / 칼로리 int[]

	Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
	   at test.Test1.main(Test1.java:25)
	=> ArrayIndexOutOfBoundsException  구글링
	   : 2  해당인덱스를 건드렸고,(방문) 그 인덱스는 없습니다.
	   (Test1.java:25)  코드의 몇번 라인에서 발생한 예외인지를 출력해줌!
	*/
   public static void main(String[] args) {
            
      String[] menuName=new String[2];
      // 메뉴명이 저장된 배열
      int[] menuKcal=new int[2];
      // 메뉴의 칼로리가 저장된 배열
      Scanner sc=new Scanner(System.in);
      for(int i=0;i<menuName.length;i++) {
         System.out.println((i+1)+"번째 메뉴명입력");
         menuName[i]=sc.next();
         System.out.println("칼로리는?");
         menuKcal[i]=sc.nextInt();
      }
      
      System.out.println("메뉴를 2번 선택하세요.");
      // tip. 배열 vs 변수 -> 일단 변수사용해라.
      int a,b;
      do {
         System.out.println("1번 메뉴입력중...");
         a=sc.nextInt();
      }while(a<1||a>menuName.length);
      // 1보다 작은 메뉴는 없다.
      // 메뉴개수보다 클수는 없다.
      do {
         System.out.println("2번 메뉴입력중...");
         b=sc.nextInt();
      }while(b<1||b>menuName.length);
      
      int i=0;
      int sum=0;
      while(i<2) {
         System.out.println((i+1)+"번 메뉴입력중...");
         a=sc.nextInt();
         if(a<1 || a>menuName.length) {
            continue;
         }
         sum+=menuKcal[a-1];
         i++;
      }
     
      // sum으로 대체가능!
      if(menuKcal[a-1]+menuKcal[b-1]>500) {
         System.out.println("angry");
         // 칼로리를 더하려고 하는데..!
         // 1,2 -> [?],[?] 현실에서 사람이 선택한 번호-1 == [인덱스]
      }
      else {
         System.out.println("no angry");
      }
      
      
   }

}
