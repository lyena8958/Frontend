package day09_0702;
// 
//���Ǵ�÷ ����("����"�˰���)
//
//����Ƚ��: 3
//
//1~30���� ������ ������
//"�ߺ�����"
//[ _ _ _ _ _ _ _ _ _ _ ]�� ����
//3 2 1 4 5 10 9 8 7 6
//�������� ����
//1 2 3 4 5 6 7 8 9 10
//_ _ _ _ _ _ _ _ _ _ << ����� �þ�
//
//��ȸ3�� == ����Ƚ��
//
//[ _ _ _ _ 30 _ _ 8 _ _ ] >> ���ڿ��迭
//
//��ȸ2��
//.
//.
import java.util.Random;
import java.util.Scanner;

public class test10 {

	public static void main(String[] args) {
		
		// ����� ��
		Scanner sc=new Scanner(System.in);
      System.out.print("����Ƚ��: ");
      int cnt=sc.nextInt();
      
      Random rand=new Random();
      
      int[] data=new int[10];
      for(int i=0;i<data.length;i++) {
         while(true) {
            data[i]=rand.nextInt(30)+1;
            System.out.println(data[i]);
            Boolean flag=true;
            
            for(int j=0;j<i;j++) { // j<=i-1
               if(data[i]==data[j]) {
                  flag=false;
                  System.out.println("�ߺ��߻�!");
                  break;
               }
            }
            
            if(flag) { // �ߺ������ʾҴٸ�,
               break;
            }
            
            
         }
      }
      
      //�� Ȯ���ϱ� ���� �ݺ���
//      for(int v:data) {
//    	  System.out.print(v+" ");
//      }
      
      for(int i = 0; i < data.length-1;i++) {
    	  for(int j = 0; j<data.length-1;j++) {
    		  // �� �۾��� �ݵ�� �����Ͱ��� -1ȸ �۵��Ѵ�!!!
    		  if(data[j] > data[j+1]) {
    			  int tmp = data[j];
    			  data[j] = data[j+1];
    			  data[j+1] = tmp;
    		  }
    	  }  
      }
    //�� Ȯ���ϱ� ���� �ݺ���
//      for(int v:data) {
//    	  System.out.print(v+" ");
      
//      }
//      
      String[] showData = new String[10];
      for(int i = 0; i < showData.length;i++) {
    	  showData[i] = "_";
      }
      while(cnt>0) { // cnt�� 0�̻��̸�!!
    	  System.out.print("[ ");
    	  for(String v:showData) {
    		  System.out.print(v+" ");
    	  }
    	  System.out.println("]");
    	  System.out.print("�����Է�: ");
    	  int ans = sc.nextInt();
    	  
    	  Boolean  flag = true; // �ϴ� ������ٴ� �����Ͽ�
    	  
		  // ���ľ˰��� 0����  ���������� ã�°� (����� Ʋ�����ʴ´�.) 
    	  for(int i = 0; i <data.length;i++) {
    		  if(ans==data[i]) {
    			   flag = false; 
    			  System.out.println("��������!");
    			  showData[i] = String.valueOf(ans); // test11.java ����(����->���ں�ȯ)
    			  // showData[i]="*"
    			  break;
    		  }
    	  }
    	  
    	  if( flag) {
    		  cnt--;
    	  }
    	  
    	  flag = true; // ����
    	  for(int i = 0; i < showData.length;i++) {
    		  if(showData[i]=="_") {
    			  flag = false;
    			  break;
    		  }
    	  }
    	  if(flag) {
    		  System.out.println("WIN!!!!!!!!!!");
    		  break;
    	  }
    	  
    	  
    	  if(cnt==0) {
        	  System.out.println("GameOver....");
          }
    	 
      }
     

		
		// ����
		/*
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		int dieCnt = 3;
		System.out.println("���� ���� Ƚ��: ");
		int cnt = sc.nextInt();
		
		// ����� �þ� �ȳ�
		char str = '_';
		
		int[] Number = new int[10];
		
		// ���� ���� ��ȣ�Է� + �ߺ��� ����
		for(int i = 0; i < 10; i++) {
		Number[i] = rand.nextInt(30)+1; // 1~30����
		for(int j = 0; j <i; j++) { // j<10�ϸ� ������������ ������ ���� ��������
		if(Number[i]==Number[j]) {
			i--; // �ߺ� i��° �ٽ� �ݺ��� ���� ����
			break;
			}
		}
		}
		
		// �������� ����
		for(int i = 0; i < 9; i++) {
		for(int j = 0; j < 9; j++) {
				if(Number[j] > Number[j+1]) {
					int tmp = Number[j];
					Number[j] = Number[j+1];
					Number[j+1] = tmp;
					}
		}
		}
		for(int j = 0; j < 10; j++) {
			System.out.print(Number[j]+" ");
		}
				
while(true) {
	int[] checkCnt = new int[10];
	int user;
	Boolean flag= false;
	
	System.out.print("������ ���� ���ڸ� �Է��ϼ���(1~30����) ");
	System.out.println();
	user = sc.nextInt();
	
	// ���� ���� ���ο� �迭�� �ִ� �ݺ���

	for(int v:Number) {
		if(user==v) {
			System.out.println("ã�Ҵ�!");
			checkCnt[i] = Number[i];
		}
		else {
			flag = true;
		}
	}
	if(flag) {
		dieCnt--;
	}
	
	//����� ��¹ݺ�
	for(int i = 0; i < Number.length;i++) {
		
		if(checkCnt[i]==0) {
		
		System.out.print(str+" ");
		}
		else {
			System.out.print(checkCnt[i]+" ");
		}
	}
	
	if(dieCnt < 0) {
		System.out.println("��ȸ�� ��� ���� �Ǿ� ���α׷��� ����˴ϴ�.");
		break;
	}
	System.out.println("��ȸ�� "+dieCnt+"�� ���ҽ��ϴ�!!!");*/
		/*
		int[] arr = new int[cnt];
		for(int i = 0; i <arr.length;i++) {
			arr[i] = rand.nextInt(3)+1;
		}
		for(int v:arr) {
			System.out.println(v);
		}*/

		
		 // 0~0 10
		// 1~ 0 10
		// 2~0 10
	//} 

}
}
