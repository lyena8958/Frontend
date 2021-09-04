package day10_0705;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		
		// 문제)
		// 배열크기 입력: 7
		// 1~100까지 랜덤수를 위의 배열에 저장
		// [ 34 96 1 20 35 ]
		// 최대값은 96이고,
		// 최소값은 [2]에 위치합니다.
		
		// 예나
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("배열크기 입력: ");
		int num = sc.nextInt();
		
		int[] arr = new int[num];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100)+1; // 1~100
		}
		
		// 저장된 랜덤 값 출력
		System.out.print("[ ");
		for(int v: arr) {
			System.out.print(v+" ");
		}
		System.out.println("]");
		
		int maxValue = arr[0]; // 최대값
		int minValue = arr[0]; // 최소값
		int minIndex = 0; // 최소값의 위치 (~번)
		
		for(int i = 0; i < arr.length; i++) {//max,min을 0부터 초기화했기 때문에, i =1로 하는게 좋다(속도)
			if(maxValue<arr[i]) {
				maxValue = arr[i];
			}
			if(minValue > arr[i]) {
				minIndex = i;
				minValue = arr[i];
			}
		}
System.out.println("최대값은 "+maxValue+"이고,");
System.out.println("최소값의 Index는 [ "+(minIndex+1)+" ] 번에 위치하며,"+minValue+" 입니다.");
		
/* 강사님 답!
      Scanner sc=new Scanner(System.in);
      Random rand=new Random();
      
      System.out.print("배열크기입력: ");
      int num=sc.nextInt();
      int[] data=new int[num];
      for(int i=0;i<data.length;i++) {
         data[i]=rand.nextInt(100)+1;
      }
      System.out.print("[ ");
      for(int v:data) {
         System.out.print(v+" ");
      }
      System.out.println("]");
      
      int max=data[0];
      int min=data[0];
      int minIndex=0;
      
      for(int i=1;i<data.length;i++) {
         if(max<data[i]) {
            // max가 max가 아니었다면,
            max=data[i];
         }
         else if(min>data[i]) {
            min=data[i];
            minIndex=i;
         }
      }
      System.out.println("max: "+max);
      System.out.println("min위치: ["+minIndex+"]");
      */
 


		
	} // main 종료

}
