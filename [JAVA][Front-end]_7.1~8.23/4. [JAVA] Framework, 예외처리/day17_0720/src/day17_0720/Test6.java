package day17_0720;

public class Test6 {

   public static void main(String[] args) {
      
      int[] arr= {0,1,2};
      try {
         //System.out.println(arr[2]/arr[3]);
         //System.out.println(arr[2]/arr[0]);
      }catch(ArrayIndexOutOfBoundsException e) {
         System.out.println("없는 인덱스에 접근");
      }catch(ArithmeticException e) {
         System.out.println("0으로는 나눌수없습니다!");
      }catch(Exception e){
         e.printStackTrace();
         System.out.println(e.getMessage());
      }finally {
         System.out.println("항상 수행하는 코드");
      }
      
   }

}