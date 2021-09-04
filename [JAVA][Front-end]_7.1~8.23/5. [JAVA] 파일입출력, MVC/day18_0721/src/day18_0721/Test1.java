package day18_0721;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

//강사님
class EvenException extends Exception{
	EvenException(){
		super("짝수를 입력하셨습니다.");
	}
}


//예나
class ActException extends Exception{
	ActException(String msg){
		super(msg);
	}
	
	
}
public class Test1 {
	public static void main(String[] args) {
		// 문제
		/*ArrayList data 
		 1) 정수만 입력
		-> 문자열 입력xxx
		=> 예외가발생하면 다시 입력
		 2) 정수중에서는 홀수만 입력
		-> 짝수 => 예외로써 처리해주세요!~~
		 3) 5개가 저장되면 종료
		 4) itr를 사용하여 한번에 데이터를 출력*/

		Scanner sc = new Scanner(System.in);
	
		//강사님
		ArrayList<Integer> data = new ArrayList();
		EvenException excep =  new EvenException();
		int num;
		while(data.size()<5) {
			System.out.println("정수입력");
			try {
				 num =sc.nextInt();
				if(num%2==0) {
					throw excep;
					// Exception으로 하게되면 홀수니?와 다른 예외처리랑 오류형태가 비교하기 어려우므로 지정예외처리를 만든다.
				}
			}catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("다른타입을 입력하셨습니다!");
				continue;
			}catch(EvenException e) {
				System.out.println(e.getMessage());
				continue;
			}catch(Exception e) {
				System.out.println("미확인예외발생!");
				continue;
			}
			data.add(num);
		}
		Iterator itr = data.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next()+" ");
		}
		
		// 예나
		/*
		ArrayList al = new ArrayList();
		ActException exc = new ActException("짝수입력 불가! 홀수로 다시입력해주세요.");
		
		while(al.size()<5) {
			int num = 0;
			System.out.println("정수만 입력하세요.");
			try {
				num = sc.nextInt();	
				if(num%2==0) {
					throw exc;
				}
			}catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("타입 오류! 다시 입력하세요.");
				continue;
			}
			catch(ActException e) {
				System.out.println(e.getMessage());
				continue;
			}
			catch(Exception e) {
				e.printStackTrace();
			}			 	
			System.out.println(num+"입력완료!");
			al.add(num);
			
		}
		
		Iterator<Integer> itr = al.iterator();
		
		System.out.println("저장된 홀수 정수입니다.");
		System.out.println(al);*/
		
		
		
	}


}
