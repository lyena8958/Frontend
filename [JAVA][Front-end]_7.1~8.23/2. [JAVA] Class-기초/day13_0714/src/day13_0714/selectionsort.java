package day13_0714;

public class selectionsort {
// 선택정렬
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 안여경
   // 선택정렬
      /*
       * 로직 
       * 1) 주어진 배열에서 최솟값을 찾음 
       * 2) 최솟값을 맨 앞자리의 값과 교환 (임시변수(tmp)사용하여 최솟값을 선택해놓은 인덱스로 값 교환) 
       * 3) 맨 앞자리를 제외한 나머지 값들중 최솟값을 찾아 교환 
       
       * // 장점
       *  알고리즘이 간단하다. 
       *  버블정렬에 비해 교환하는 횟수가 적다.
       *  배열안에서 변경되므로 새로운 공간을 필요로 하지 않는다. 
       
       *  // 단점 
       *  시간복잡도(==성능==빅오,빅오표기법)가 비효율적이다. 
       *  불안정한 정렬이다.
       */
		
      //int[] arr = { 10, 1, 17, 7, 3 }; // 정렬하기전 숫자 배열 
      /* 랜덤으로 숫자를 받을 때 
        int[] arr = new int[5]; // 숫자를 저장할 배열 선언
         Random rand = new Random(); // 숫자를 랜덤으로 저장 
         for(int i=0;i<arr.length;i++) {
               arr[i] = rand.nextInt(20)+1; //1~20 
           }
       */
      
      // 저장된 배열 확인
		/*
      System.out.print("정렬되기 전 배열 : [ ");
      for (int v : arr) {
         System.out.print(v + " ");
      }
      System.out.print("]");

// ------------------------------------------------------------      
      // 선택정렬
      for (int a = 0; a < arr.length; a++) {
         int minIdx = a; // 최솟값을 찾아 값을 변경할 인덱스 저장

         // 최솟값을 갖고있는 인덱스 검색
         for (int i = a + 1; i < arr.length; i++) {
            if (arr[minIdx] > arr[i]) { // 만약 arr[0] > arr[i]
               minIdx = i; // 조건을 만족한다면 minIdx를 i로 변경
            }
         }
         int tmp = arr[minIdx]; // 이때 arr[minIdx == i] 값의 위치를 변경해준다.
         arr[minIdx] = arr[a];
         arr[a] = tmp;
         
      }
      System.out.println();

      System.out.print("정렬된 배열 : [ ");
      for (int v : arr) {
         System.out.print(v + " ");
      }
      System.out.print("]");*/

/* 양윤혁
		      Scanner sc = new Scanner(System.in);
		      System.out.println("배열의 길이 : ");
		      int n = sc.nextInt(); // 배열의 길이 입력
		      System.out.println();
		      int[] data = new int[n]; // 입력한 길이의 배열 생성
		      Random rand = new Random();
		      for (int i = 0; i < data.length; i++) {
		         data[i] = rand.nextInt(9) + 1; // 1~9까지의 랜덤값 투입
		      }
		      System.out.print("선택정렬 전 : ");
		      for (int v : data) { // 난수로 투입된 값 확인
		         System.out.print(v + " ");
		      }
		      System.out.println("\n");
		//==================================================================================================
		//선택정렬 알고리즘 : 배열 내 최소값을 찾아 앞에서부터 차례로 교환하며 정렬
		      int temp; // 최소값을 담을 변수

		      for (int i = 0; i < data.length - 1; i++) { // 먼저 입력한 길이만큼
		         int min = i; // 최소값을 담을 변수
		         for (int j = i + 1; j < data.length; j++) { // 처음에 i번째 인덱스를 최소값으로 가정하고 그 다음 인덱스의 값(j)을 i와 비교.
		            if (data[min] > data[j]) { // 0번째 인덱스와 1.. 2.. 3.. 4.. 인덱스 값 비교
		               min = j; // 최소값 인덱스 갱신
		            }
		         }
		         temp = data[min]; // 가장 작은 값을 temp 변수에 넣고
		         data[min] = data[i]; // 최소값이 존재하던 위치에 i번째 인덱스 값을 대입 교환해준다.
		         data[i] = temp; // i번째 인덱스에 가장 작은 값을 대입하여 i값이 증가함에 따라 차곡차곡 그 다음 최소값이 저장된다.

		         System.out.print((i + 1) + "회전 : "); // 정렬되어가는 과정
		         for (int v : data) {
		            System.out.print(v + " ");
		         }
		         System.out.println();

		      }
		//==================================================================================================
		      System.out.println();
		      System.out.print("선택정렬 후 : ");
		      for (int v : data) {
		         System.out.print(v + " ");
		      }

		   }
		}*/
	}

}
