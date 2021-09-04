package day08_0701;

import java.util.Scanner;

public class TEST4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열 생성
		// Stack vs Heap
		//  Stack : 원시타입이 만들어지는 영역 (int, char, double....)
		// vs Heap : "개발자의 영역", 프로그램이 실행된 이후에도 공간 이용가능
		//	 new 연산자를 이용하여 공간 확보, 초기화가 되어 있음 (new는 쓰레기값이 아닌게 들어있다.)
		
	      System.out.print("학생수입력: ");
		
		// ↓ 힙 영역
	      int stu=sc.nextInt();
	      int[] arr=new int[stu];
	      for(int i=0;i<stu;i++) {
	         System.out.println((i+1)+"번요소: "+arr[i]);
	      }

		// length 사용
		// 요소가 몇개인지 까먹었다! 변수.누르면 관련용어 나옴 (length)
	      for(int i=0;i<arr.length;i++) {
	          arr[i]=i+1;
	       }


		//forEach == 향상된 for문
		//  for(집합에 저장된 데이터의 타입:데이터의 집합)
	      //인덱스 ->int i =0;
	      for(int v : arr) {
	    	  // 인덱스를 찾기 어렵다!
	          System.out.println(v);
	          // 인덱스 -> [i++;]
	       }

		
		
		
	}

}
