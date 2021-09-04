package day13_0714;

import java.util.Random;
import java.util.Scanner;

public class insertionsort {
	// 삽입정렬 예나
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		System.out.println("원소의 개수를 입력하세요");
		int n = sc.nextInt();
		int[] data = new int[n]; // 숫자 저장배열

		// 랜덤값 부여
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(50) + 1; // 1~50
			System.out.print(data[i] + " "); // 값표시
		}
		System.out.println(); // 줄정리

		// 삽입정렬 두번째자리부터 비교(첫자리는 비교대상없기때문)
		for (int a = 1; a < data.length; a++) {// 두번째 인덱스부터
			int IndexMin = a; // 대상 a 지정
			for (int i = 0; i < a; i++) { // 처음부터 대상전까지 반복
				// 비교대상이 더 숫자가 작다면 값을 삽입하여 변경해준다.(오름차순이니 적은숫자가 앞으로 가야함)
				if (data[IndexMin] < data[i]) {
					int tmp = data[a]; // 임시저장변수
					data[a] = data[i];
					data[i] = tmp;
					IndexMin = i; // 바뀐 대상의 위치로 인덱스번호 변경(현재 까지 비교한 값중 가장 작은 값)	
				}
			}// 정렬된 값 출력
			for (int v : data) {
				System.out.print(v + " ");
			}
			System.out.println();

		}
			
		/* 이병재
  Random rand = new Random();
      int[] arr = new int[5];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = rand.nextInt(30) + 1;
      }

      /////////////// 최초 배열 출력 //////////////////
      System.out.print("최초 배열 : ");
      for (int v : arr) {
         System.out.print(v + " ");
      }

      ////////////// 삽입정렬 알고리즘 /////////////////
      for (int i = 1; i < arr.length; i++) {          // 배열 값 선택 하여
         while (i > 0 && arr[i - 1] > arr[i]) {    // 비교 삽입
            int tmp = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = tmp;
            i--;
         }

      }

      ////////////// 회전 결과 출력 /////////////////
      System.out.print("\n 최종 배열 : ");
      for (int v : arr) {
         System.out.print(v + " ");
      }
   }*/

	} // main종료
}