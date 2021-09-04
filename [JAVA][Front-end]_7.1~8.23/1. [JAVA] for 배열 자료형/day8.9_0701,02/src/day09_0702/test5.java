package day09_0702;

import java.util.Scanner;

public class test5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [][] stu=new int[2][3];
		
		for(int i = 0; i < 2;i++) {
		System.out.println((i+1)+"번 학생의 성적입력 ");
		for(int j = 0; j < 3; j++) {
			System.out.print("입력: ");
			stu[i][j]=sc.nextInt();
		}
		}
		
		// stu.length == 2
		for(int i = 0; i < stu.length;i++) { // i < 2
			System.out.println((i+1)+"번 학생의 성적출력 ");
			
			// stu[i].length == 3
			for(int j = 0; j < stu[i].length; j++) { // j < 3
				System.out.println(stu[i][j]+" ");
			}
			System.out.println();
			}

		
		
		
	} // main 종료

}
