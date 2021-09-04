package day09_0702;

import java.util.Random;
import java.util.Scanner;

public class test12_강사님답 {
	public static void main(String[] args) {

      // 정렬-->검색
      // 이분검색==이진탐색
      
      int[] data=new int[10];
      Random rand=new Random();
      for(int i=0;i<data.length;i++) {
         data[i]=rand.nextInt(10)+1;
         for(int j=0;j<i;j++) {
            if(data[i]==data[j]) {
               i--;
               break;
            }
         }
      }
     // 비교수행
      for(int i=0;i<data.length-1;i++) {
         for(int j=0;j<data.length-1;j++) {
            // 비교수행
            if(data[j] > data[j+1]) {
               int tmp=data[j];
               data[j]=data[j+1];
               data[j+1]=tmp;
            }
         }
      }
      
      
      
      for(int v:data) {
         System.out.print(v+" ");
      }
      
      System.out.println();
      
      
      Scanner sc=new Scanner(System.in);
      System.out.print("찾는값입력: ");
      int value=sc.nextInt();
      
      
      int l=0,h=data.length-1; //low high
      while(l<=h) {
			// cross(교차현상)이 발생하면, 종료
			//종료조건 구현해야함
			int m=(l+h)/2; // middle 중간값을 구하기 위함(0+9)/2 = [4]
         if(data[m]==value) {
            System.out.println("["+m+"]에 존재!");
            break;
         }
         else if(data[m]<value) {
            l=m+1; // 일단값을 고정
         }
         else {
            h=m-1; // m:5 그러면, 1~4까지 안내해야하니 -1를 해줘야 한다!!
         }
         //대입연산자 기준으로 왼쪽을 바꿔버린다.
         System.out.println(l+"확인"+h);
         	
      }
      
      if(l>h) {
         System.out.println("값없음...");
      }
   
		
		
		
		
		
	}
}
