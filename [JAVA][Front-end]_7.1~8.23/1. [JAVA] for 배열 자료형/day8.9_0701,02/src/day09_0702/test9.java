package day09_0702;

import java.util.Random;
import java.util.Scanner;

public class test9 {

	public static void main(String[] args) {	
		/*출석부 프로그램

		몇명의 학생: 3
		   => 이름 입력(이름이 저장된 배열)
		수업기간: 5

		1: 출석 0 : 결석 ( 랜덤 으로 해도 ㄱㅊ)
		day1) 1번학생: 1
		2번학생: 0
		3번학생: 1

		1) 각각 day의 출석률 (실수) 출력
		2) 각각의 학생의 출석률 (실수) 출력ㄴ
		3) 출석률이 80%미만인 학생은 퇴학
		   => 퇴학처리된 학생의 이름출력!~~~
		   */

	      Scanner sc=new Scanner(System.in);
	      
	      System.out.print("학생수입력: ");
	      int stu=sc.nextInt();
	      
	      String[] stuName=new String[stu];
	      for(int i=0;i<stuName.length;i++) {
	         System.out.print((i+1)+"번 학생이름입력: ");
	         stuName[i]=sc.next();
	      }
	      
	      
	      System.out.print("날짜입력: ");
	      int day=sc.nextInt();
	      
	      Random rand=new Random();
	      
	      // 1) data[day][stu]
	      // 2) data[stu][day] 이걸로 진행!ㄴ
	      int[][] data=new int[stu][day];
	      for(int i=0;i<day;i++) {
	         System.out.println("day"+(i+1));
	         int dayCnt=0;
	         for(int j=0;j<stu;j++) {
	            System.out.print((j+1)+"번학생: ");
	            data[j][i]=rand.nextInt(2);
	            if(data[j][i]==1) {
	               System.out.println("출석");
	               dayCnt++;
	            }
	            else {
	               System.out.println("결석");
	            }
	         }
	         System.out.println("day"+(i+1)+" 출석률: "+(dayCnt*100.0/stu)+"%");
	      }
	      
	      for(int i=0;i<stu;i++) {
	         int stuCnt=0;
	         for(int j=0;j<day;j++) {
	            if(data[i][j]==1) {
	               stuCnt++;
	            }
	         }
	         double check=stuCnt*100.0/day;
	         System.out.println((i+1)+"번학생 출석률: "+check+"%");
	         if(check<50.0) {
	            System.out.println(stuName[i]+"학생 퇴학처리...");
	         }
	      }


		/* 예나
		System.out.print("학생 인원수:");
		int stu = sc.nextInt();
		
		System.out.print("수업기간 정수입력(1일 = 1): ");
		int studay = sc.nextInt();

		int[][] StuArr = new int[stu][studay];
		String[] name = new String[stu];
		
		// 학생들의 이름 저장
		for(int i = 0; i < name.length;i++) {
			System.out.print((i+1)+"번 학생의 "+"이름을 입력하세요: ");
			name[i] = sc.next(); // 이름길이 조건문 만들어야할듯
			System.out.print(" ");
		}
		
		double[] AvgArr = new double[stu];
		
		for(int i = 0; i < StuArr.length;i++) {
			
			for(int j = 0;j<StuArr[i].length;j++) {
				
				StuArr[i][j] = rand.nextInt(2); // 0~1까지
				AvgArr[i] += StuArr[i][j];
				System.out.println((i+1)+"번 학생"+(j+1)+"일 출석: "+StuArr[i][j]);
			}
			AvgArr[i] /= studay*1.0; // 평균
			AvgArr[i] *= 100; // 출석률
			System.out.println((i+1)+"번 학생의 출석률"+AvgArr[i]);
			System.out.println();
		}
		
		for(int i = 0; i < AvgArr.length;i++) {
			
			if(AvgArr[i]<80) {
				System.out.println("출석률 80% 미만으로 퇴학처리가 된 학생은 "+name[i]+" 입니다.");
			}
			
		}*/ 
		


	} //main 종료

}
