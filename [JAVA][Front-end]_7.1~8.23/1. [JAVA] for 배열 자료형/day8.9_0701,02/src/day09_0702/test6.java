package day09_0702;

import java.util.Random;
import java.util.Scanner;

public class test6 {

	/*학생의 수를 입력하세요.
	학생들이 시험을 몇번볼지도 입력해주세요.

	2 3
	학생1번 채점중...
	0~100 랜덤으로 채점진행!

	이 학생의 평균들을 저장한 배열을 출력해주세요!~~
	1등의 번호를 출력해주세요!~~
	 * */
	public static void main(String[] args) {
		
		// 강사님 답
	      Scanner sc=new Scanner(System.in);
	      System.out.print("학생수: ");
	      int stu=sc.nextInt();
	      System.out.print("시험수: ");
	      int test=sc.nextInt();
	      
	      int[][] STU=new int[stu][test];
	      
	      Random rand=new Random();
	      double[] stuAvg=new double[stu];
	      for(int i=0;i<STU.length;i++) {
	         for(int j=0;j<STU[i].length;j++) {
	            STU[i][j]=rand.nextInt(101);
	            System.out.print( STU[i][j]+"점 ");
	            stuAvg[i]+=STU[i][j];
	         }
	         stuAvg[i]/=STU[i].length;
	         System.out.println("평균 " +stuAvg[i]+"점 ");
	      }
	      
	      
	      double max=stuAvg[0];
	      int maxIndex=0;
	      for(int i=1;i<stuAvg.length;i++) {
	         if(max<stuAvg[i]) {
	            max=stuAvg[i];
	            maxIndex=i;
	         }
	      }
	      
	      System.out.println("1등은 "+(maxIndex+1)+"번학생입니다.");
	      

		
		
		/* 예나 마지막 풀다맘
		Random rand = new Random();
		
		System.out.print("학생의 수를 입력하세요: ");
		int stu = sc.nextInt();
		System.out.print("총 시험 몇회인지 입력하세요 ");		
		int num = sc.nextInt();

		
		int [][] arr = new int[stu][num];
		double [] darr = new double[stu];
		
		
		for(int i =0; i < arr.length;i++) {
			System.out.println("학생"+(i+1)+"번 채점중...");
			for(int j = 0; j < arr[i].length;j++) {
				arr[i][j] = rand.nextInt(101); // 0~100
				darr[i] += arr[i][j];
				System.out.println((j+1)+"회 시험"+arr[i][j]+"점!");
			}
			darr[i] /= arr[i].length;
			darr[i] *= 1.0;
			System.out.printf("[평균] : %f점\n\n", darr[i]);
			}
		
		double max = darr[0];
		
		for(int i = 0; i<(arr[0].length-1;i++){
		if(darr[i]<darr[i+1]){
		max = darr[i+1];
		}
		
		}
		// 풀다맘
		System.out.println("1등의 번호는 "+(max+1)+" 입니다!");
		
*/
	} // main 종료
}

// for - arr[i+1]번 채점중 ...
// 
// for	 rand[i][j] = rand

// double d[stu]
// for(<double[i].length) 
