package day13_0714;

import java.util.Random;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * 미어캣이 5마리가 있다.
		 * 앞의 한마리는 볼 수 있으나,
		 * 본인보다 키가 큰 미어캣이 있으면 다음미어캣을 못본다.
		 * 이때 총 5마리의 머리를 볼 수 있는 개수를 입력하세요
		 * */
		int[] cat = new int[5];
		Random rand= new Random();
		for(int i = 0; i < 5; i++) {
			cat[i] = rand.nextInt(9)+1; // 1~9
		}
		for(int v: cat) {
			System.out.print(v+" ");
		}
		System.out.println();
		
		// 한마리당 (누가 몇번볼수있는지) 데이터를 저장하는 방법
		// : 배열
		// 결국, 문제가 원하는 것 (전체 볼수있는 마리수)을 저장하는 방법
		// : 변수
		
		//배열
//		int[] data = new int[5];
//		// data[]배열을 0으로 초기화 해야할까요?
//		// new 연산자를 사용하시면 : 1
//		// Heap 메모리 영역을 이용 : 2
//		//  └"개발자의 영역" == 프로그램 실행 이후에도 사용가능한 공간
//		// 자동초기화 : 3
//		
//		for (int a = 0; a < cat.length; a++) {
//			// [0]에 있는 cat의 볼수있는 마리수를 카운팅
//			for (int i = a+1; i < cat.length; i++) {
//				data[a]++;
//				if (cat[a] < cat[i]) { // 자기보다 키가 큰 미어캣을 만난다면,
//					break;
//				}
//			}
//		}
//		int sum = 0;
//		for(int v:data) {
//			System.out.print(v+" ");
//			sum+=v;
//		}
//		System.out.println();
//		System.out.println(sum);
		
		// 변수
		int sum = 0;
		for (int a = 0; a < cat.length; a++) {
			// [0]에 있는 cat의 볼수있는 마리수를 카운팅
			for (int i = a+1; i < cat.length; i++) {
				sum++;
				if (cat[a] < cat[i]) { // 자기보다 키가 큰 미어캣을 만난다면,
					break;
				}
			}
		}
		System.out.println(sum);
		
		
		
	}//main종료

}
