package day17_0720;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num;
		while(true) {//.
			
			System.out.println("양수입력");
			try {//입력된 스트링이 있다면 버퍼에 문자가 남아있어 무한반복을 하게됨
				num = sc.nextInt();
			}
			catch(InputMismatchException e) {
				sc.nextLine(); // 버퍼정리(남아있는데이터는 사라진다.)
				System.out.println("자료형이 올바르지않습니다!");
				num=0;//아래 조건else로 가기위함
				//num대신 continue;로도 활용가능
			}
			if(num>0) {
				break;
			}
			else {
				System.out.println("다시!");
			}
			
		}
		
	}

}
