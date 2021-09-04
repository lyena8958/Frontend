package day09_0702;

import java.util.Random;

public class test15 {

	// 1번)강사님
   static int findMaxIndex(int[] arr) {
      int max=arr[0];
      int maxIndex=0;
      for(int i=1;i<arr.length;i++) {
         if(max<arr[i]) {
            max=arr[i];
            maxIndex=i;
         }
      }
      return maxIndex;
   }
 // 2번)강사님
   static void sortArr(int[] arr) {
	      for(int i=0;i<arr.length-1;i++) {
	         for(int j=0;j<arr.length-1;j++) {
	            if(arr[j] > arr[j+1]) {
	               int tmp=arr[j];
	               arr[j]=arr[j+1];
	               arr[j+1]=tmp;
	            }
	         }
	      }
	   }
	   

   
// 2번)예나
   static void ArrIndex(int[] arr) { 

	   for(int i = 0; i < arr.length-1;i++) {
		   for(int j = 0; j <arr.length-1;j++) {
			   
			   if(arr[j] > arr[j+1]){ // 1  2 3 
			   int tmp = arr[j];
				   arr[j] = arr[j+1];
				   arr[j+1] = tmp;
			   }
		   }
		   
	   }
	   
	   }
   
   
   public static void main(String[] args) {
	   
	   // 1. 배열을 인자로 받아서
	      // 최대값의 위치를 반환하는 함수
      int num=10;
      int[] data=new int[num];
      Random rand=new Random();
      for(int i=0;i<data.length;i++) {
         data[i]=rand.nextInt(10)+1;
      }
      for(int v:data) {
         System.out.println(v);
      }
      System.out.println("["+findMaxIndex(data)+"]");
      
     
      
      // 2. 배열을 인자로 받아서
      // 정렬해주는 정렬함수
      
      // hint) void sortArr(int[] arr) << 메서드 시그니처
      
      sortArr(data);
      for(int v:data) {
         System.out.print(v+" ");
      }

      // 예나
      int[] data2=new int[num];
      
      System.out.print("[");
      
      for(int i = 0; i<data2.length;i++) {
    	  
    	  data2[i] = rand.nextInt(10)+1;
    	  System.out.print(data2[i]+" ");
      }
      System.out.println("]");
      
      ArrIndex(data2);
      
      System.out.print("[");
      for(int i = 0; i < data2.length;i++) {
    	  
    	  System.out.print(data2[i]+" ");
    	  
      }
      System.out.println("]");
      
   }}

