package day17_0720;

public class Test6 {

   public static void main(String[] args) {
      
      int[] arr= {0,1,2};
      try {
         //System.out.println(arr[2]/arr[3]);
         //System.out.println(arr[2]/arr[0]);
      }catch(ArrayIndexOutOfBoundsException e) {
         System.out.println("���� �ε����� ����");
      }catch(ArithmeticException e) {
         System.out.println("0���δ� �����������ϴ�!");
      }catch(Exception e){
         e.printStackTrace();
         System.out.println(e.getMessage());
      }finally {
         System.out.println("�׻� �����ϴ� �ڵ�");
      }
      
   }

}