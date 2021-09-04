package day08_0701;

import java.util.Scanner;

public class TEST3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
	
		
		/*
		 * 1. 반지름입력: 10
			원의 넓이는 314.0입니다.
			(실수로 출력)
		 */
		
		// 강사님 답!
		System.out.print("반지름입력: ");
	      int r=sc.nextInt();
	      
	      final double PI=3.14; // 상수화
	      double area=r*r*PI;
	      System.out.println("원의 넓이는 "+area+"입니다.");

		
		
		// 예나 답
		/*
		System.out.print("반지름입력: ");
		double d = sc.nextInt();
		System.out.println("원의 넓이는"+3.14*d*d+"입니다.");
		
		
		System.out.println("");
		*/
		
		/*
		 * 2. 정수3번입력
			정수 1입력: 10
			정수 2입력: 20
			정수 3입력: 30
			합은 60이고, 평균은 20.0입니다.
      			(평균 실수)
		 * */
		
		
		// 강사님 답!
	      int sum=0;
	      for(int i=0;i<3;i++) {
	         System.out.print("정수 "+(i+1)+"입력: ");
	         int n=sc.nextInt();
	         sum+=n;
	      }
	      System.out.print("합은 "+sum+"이고, ");
	      double avg=sum/3.0;
	      System.out.println("평균은 "+avg+"입니다.");

		
		
		//예나 답
	      /*
		int sum = 0;
		double d2 = 0;
		
		for(int j = 1; j <= 3; j++) {
			System.out.print("정수 "+j+"번 입력: ");
			int a = sc.nextInt();
			sum+=a;
			
			if(j == 3) {
				d2 = sum * 1.0/ j;
			}
		}
		
		System.out.println("합은 "+sum+"이고, 평균은"+d2+"입니다.");
		
		*/
		
	}

}
