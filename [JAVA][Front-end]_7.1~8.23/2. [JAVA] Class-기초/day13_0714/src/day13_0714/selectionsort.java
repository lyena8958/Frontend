package day13_0714;

public class selectionsort {
// ��������
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �ȿ���
   // ��������
      /*
       * ���� 
       * 1) �־��� �迭���� �ּڰ��� ã�� 
       * 2) �ּڰ��� �� ���ڸ��� ���� ��ȯ (�ӽú���(tmp)����Ͽ� �ּڰ��� �����س��� �ε����� �� ��ȯ) 
       * 3) �� ���ڸ��� ������ ������ ������ �ּڰ��� ã�� ��ȯ 
       
       * // ����
       *  �˰����� �����ϴ�. 
       *  �������Ŀ� ���� ��ȯ�ϴ� Ƚ���� ����.
       *  �迭�ȿ��� ����ǹǷ� ���ο� ������ �ʿ�� ���� �ʴ´�. 
       
       *  // ���� 
       *  �ð����⵵(==����==���,���ǥ���)�� ��ȿ�����̴�. 
       *  �Ҿ����� �����̴�.
       */
		
      //int[] arr = { 10, 1, 17, 7, 3 }; // �����ϱ��� ���� �迭 
      /* �������� ���ڸ� ���� �� 
        int[] arr = new int[5]; // ���ڸ� ������ �迭 ����
         Random rand = new Random(); // ���ڸ� �������� ���� 
         for(int i=0;i<arr.length;i++) {
               arr[i] = rand.nextInt(20)+1; //1~20 
           }
       */
      
      // ����� �迭 Ȯ��
		/*
      System.out.print("���ĵǱ� �� �迭 : [ ");
      for (int v : arr) {
         System.out.print(v + " ");
      }
      System.out.print("]");

// ------------------------------------------------------------      
      // ��������
      for (int a = 0; a < arr.length; a++) {
         int minIdx = a; // �ּڰ��� ã�� ���� ������ �ε��� ����

         // �ּڰ��� �����ִ� �ε��� �˻�
         for (int i = a + 1; i < arr.length; i++) {
            if (arr[minIdx] > arr[i]) { // ���� arr[0] > arr[i]
               minIdx = i; // ������ �����Ѵٸ� minIdx�� i�� ����
            }
         }
         int tmp = arr[minIdx]; // �̶� arr[minIdx == i] ���� ��ġ�� �������ش�.
         arr[minIdx] = arr[a];
         arr[a] = tmp;
         
      }
      System.out.println();

      System.out.print("���ĵ� �迭 : [ ");
      for (int v : arr) {
         System.out.print(v + " ");
      }
      System.out.print("]");*/

/* ������
		      Scanner sc = new Scanner(System.in);
		      System.out.println("�迭�� ���� : ");
		      int n = sc.nextInt(); // �迭�� ���� �Է�
		      System.out.println();
		      int[] data = new int[n]; // �Է��� ������ �迭 ����
		      Random rand = new Random();
		      for (int i = 0; i < data.length; i++) {
		         data[i] = rand.nextInt(9) + 1; // 1~9������ ������ ����
		      }
		      System.out.print("�������� �� : ");
		      for (int v : data) { // ������ ���Ե� �� Ȯ��
		         System.out.print(v + " ");
		      }
		      System.out.println("\n");
		//==================================================================================================
		//�������� �˰��� : �迭 �� �ּҰ��� ã�� �տ������� ���ʷ� ��ȯ�ϸ� ����
		      int temp; // �ּҰ��� ���� ����

		      for (int i = 0; i < data.length - 1; i++) { // ���� �Է��� ���̸�ŭ
		         int min = i; // �ּҰ��� ���� ����
		         for (int j = i + 1; j < data.length; j++) { // ó���� i��° �ε����� �ּҰ����� �����ϰ� �� ���� �ε����� ��(j)�� i�� ��.
		            if (data[min] > data[j]) { // 0��° �ε����� 1.. 2.. 3.. 4.. �ε��� �� ��
		               min = j; // �ּҰ� �ε��� ����
		            }
		         }
		         temp = data[min]; // ���� ���� ���� temp ������ �ְ�
		         data[min] = data[i]; // �ּҰ��� �����ϴ� ��ġ�� i��° �ε��� ���� ���� ��ȯ���ش�.
		         data[i] = temp; // i��° �ε����� ���� ���� ���� �����Ͽ� i���� �����Կ� ���� �������� �� ���� �ּҰ��� ����ȴ�.

		         System.out.print((i + 1) + "ȸ�� : "); // ���ĵǾ�� ����
		         for (int v : data) {
		            System.out.print(v + " ");
		         }
		         System.out.println();

		      }
		//==================================================================================================
		      System.out.println();
		      System.out.print("�������� �� : ");
		      for (int v : data) {
		         System.out.print(v + " ");
		      }

		   }
		}*/
	}

}
