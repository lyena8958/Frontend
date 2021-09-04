package day17_0720;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;

class AgeException extends Exception{
	AgeException(){
		super("나이범위문제!"); // 개발자가 원하는멘트가 나오게끔 하기위함
	}
}

public class Test9 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		// 버스카드생성기기
		
		// 나이를입력하세요
		// 1~100만 입력가능
		// 0, -1, 101, 20000 => 범위문제!
		// 10살=> 타입문제!
		//------------------------------------다시입력
		//String[] data = [1. 선불교통 2. 후불교통카드 ]
		// 1,2 => 카드생성!
		// 1,2xx => 인덱스범위문제!
		//------------------------------------종료해주세요
		//항상 "안녕히가세요." 문구 출력해주세요
		
		//Exception excep = new Exception("");
		AgeException ae = new AgeException();
		
	      while(true) {
	          System.out.println("나이입력");
	          try {
	             int age=sc.nextInt();
	             if(age<1||100<age) {
	                throw ae;
	             }
		}catch(AgeException e) {//범위문제만 하고싶어서 재정의
			System.out.println(e.getMessage());
			System.out.println("재입력!");
			continue;
		}catch(Exception e) {
			System.out.println("예상외 문제발생!");
			return;
		}
		break;
	}
	      ArrayList<String> al=new ArrayList();
	      al.add("선불교통카드");
	      al.add("후불교통카드");
	      Iterator itr=al.iterator();
	      while(itr.hasNext()) {
	         System.out.print(itr.next()+" ");
	      }
	      System.out.println();

	      System.out.println("만들카드번호입력");

	      try {
	         int num=sc.nextInt();
	         System.out.println(al.get(num-1)+"가 생성됩니다.");
	      }catch(IndexOutOfBoundsException e) {
	         System.out.println(e.getMessage());
	         System.out.println("자동으로 "+al.get(al.size()-1)+"가 생성됩니다.");
	         //return;
	      }finally {
	         System.out.println("안녕히가세요.");
	      }


		/*ㅇㅖ나
		Exception excep = new Exception("1~100 사이의 정수만 입력이 가능합니다.");
		int ans;
		while(true) {// 나이입력
			
			System.out.println("나이를 입력하세요");
			try {
				ans = sc.nextInt();
				if(ans<1||100<ans) {
					throw excep;
				}
			}catch(InputMismatchException e) {
				System.out.println("자료형이 올바르지않습니다. 정수로 다시 입력해주세요!");
				sc.nextLine();//버퍼정리
				continue;
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("다시 입력하세요!");
				sc.nextLine();//버퍼정리
				continue;
			}
			break;
		}
		String[] data = {"선불교통", "후불교통"};
		
		System.out.println("1. "+data[0]+"\t2. "+data[1]);
		System.out.print("두 가지 종류 중 하나를 선택해주세요(1번, 2번)");
		
		ans = 0;
		try {
			ans= sc.nextInt();
			System.out.println(data[ans-1]+"카드 선택이 되었습니다!");
		}catch(ArrayIndexOutOfBoundsException e) {
			sc.nextLine();
			System.out.println("올바르지 않은 입력으로 발급이 안되었습니다.");
		}finally {
			System.out.println("이용해 주셔서 감사합니다. 안녕히 가세요!");
		}*/
		
		
		
	}//main종료

}
