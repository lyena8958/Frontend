package day13_0714;

import java.util.Random;

public class insertionsort1 {
   static final int SIZE = 5;
   public static void main(String[] args) {


      Random rand = new Random();
      int[] data;

      data = new int[SIZE];         

      for(int i = 0 ; i < data.length ; i++) {
         data[i] = rand.nextInt(100)+1;      //랜덤값으로 배열 입력
      }

      System.out.print("저장된 배열 : ");
      for(int v : data) {
         System.out.print(v + " ");
      }
      System.out.println();

      for(int i = 1 ; i< data.length; i++) {
         int tmp = data[i];               //임시변수에 i번째 데이터 저장
         int index = 0;                  //인덱스를 저장할 변수

         for(int j = i-1 ; j >= 0 ; j--) {   // i-1인 이유는 배열범위에서 벗어나지 않기위해
            if(tmp < data[j]) {            //저장된 변수 보다 data[j]가 크면 밀어내기
               data[j+1] = data[j];
            }
            else {                     //저장된 변수 보다 data[j]가 작으면 중지 
               index = j+1;            //j+1이 빈공간
               break;
            }
         }

         data[index] =tmp;               //임시변수에 저장된 값을 자리에 삽입

         System.out.print(i + "회전 : ");      //1회전마다 정렬된 배열출력   
         for(int v : data) {
            System.out.print(v + " ");
         }
         System.out.println();
      }
      
      
      System.out.print("정렬된 배열 : ");         //정렬된 배열출력
      for(int v : data) {
         System.out.print(v + " ");
      }
      System.out.println();


   }
}