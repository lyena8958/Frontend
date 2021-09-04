package Team1_Project;

import java.util.Scanner;

public class test2 {
	   // -------------------------------------------����� ���� �Լ� 
	   // �޴� ��� �Լ�s
	   static void menu(int[][] a, String[] b) {
	      System.out.println(" ====================�� Flower Machine ��==================");
	      System.out.println("                 �� ����ϴ� ������� ������ ���ϼ���  ��            \n");
	      System.out.println("                          [MENU]                          \n");
	      for (int i = 0; i < a.length; i++) {
	         System.out.print("["+(i + 1)+"]"+ b[i] + " ");
	         System.out.print(a[i][0] + "��  ");
	      }
	      System.out.println("\n\n"); // �ٹٲ�
	   }

	   // �ݾ� ������ ��ȯ�ϴ� �Լ�
	   static int changeMoney(int money) {
	      if (money < 7000) {
	         System.out.println("[ERROR!!] �ݾ��� �����մϴ�  o��o;");
	         System.out.println("��ȯ �ݾ� :" + money + "��\n");
	         money = 0; // ��ȯ�� �ʱ�ȭ
	      }
	      return money; 
	   }

	   // -------------------------------------------������ ���� �Լ�
	   // ������ ��� �޴� ���&�޴���ȣ �Է�
	   static void managerMenu() {
	      System.out.println("[1]��ǰ����  [2]���ݺ���  [3]������  [4]�����ڸ�� ����");
	      System.out.print("���� �޴� ���� : ");
	   }

	   // ������ ��� �޴�����, ���뺯�� �Լ�
	   static Boolean MaNager(int[][] fpriceCnt, String[] flower) {
	      Scanner sc = new Scanner(System.in);
	      System.out.print("������ ��й�ȣ �Է� : "); // ������ ��й�ȣ = 1004
	      int pswd = sc.nextInt();
	      if (pswd == 1004) {
	         System.out.println("[ ������ ��� ] �� �����ϼ̽��ϴ� :D ");
	      } else {
	         System.out.println("[Error] ��й�ȣ�� Ʋ�Ƚ��ϴ�.\nXXXXXX ���ٺҰ� XXXXXX\n");
	         return true; // �����ڸ������
	      }
	      // ������ ��ǰ ����  �Լ�
	      int productNum;
	      
	      // �޴���ȣ ��ȿ���˻�
	      while(true) { 
	    	   System.out.print("������ ��ǰ��ȣ �Է� : ");
		       productNum = sc.nextInt();
		       if(1 <= productNum && productNum <= 5) { // 1~5����
		    	   break;
		       }
		       System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���!( 1~5 )\n");
	      }
	     
	      System.out.println("[ " + flower[productNum-1] + " ] ��ǰ�� ���õǾ����ϴ�.\n");
	      
	      // ��ǰ���� �޴� ���� �Լ�
	      int cateGoryNum; // ī�װ� �ѹ�
	      
	      //ī�װ� ��ȣ ��ȿ���˻�
	      while(true) {
	    	  managerMenu();
		      cateGoryNum = sc.nextInt(); // ī�װ� �Է�
		      if(1 <= cateGoryNum && cateGoryNum <= 4) { // 1~4����
		    	  break;
		      }
		      System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���!( 1~4 )\n");
	      }
	      if (cateGoryNum < 4) {
	         if (cateGoryNum == 1) { // ��ǰ����
	            System.out.print("������ ��ǰ�� : ");
	            flower[productNum-1] = sc.next();
	            System.out.println(flower[productNum-1] + "(��)�� ��ǰ�� ����Ǿ����ϴ�.\n");
	         }
	         else if (cateGoryNum == 2) { // ��ǰ���ݺ���
	            System.out.println("���� " + flower[productNum-1] + "�� �ݾ��� " + fpriceCnt[productNum-1][0] + "�� �Դϴ�.");
	            System.out.print("������ �ݾ��� �Է����ּ��� : ");
	            fpriceCnt[productNum-1][0] = sc.nextInt();
	            System.out.println(fpriceCnt[productNum-1][0] + "�� ���� �ݾ��� ����Ǿ����ϴ�.\n");
	         } else if (cateGoryNum == 3) { // ������
	            System.out.println("���� " + flower[productNum-1] + "�� �ܿ����� " + fpriceCnt[productNum-1][1] + " �Դϴ�.\n");
	            System.out.print("�߰��Ͻ� ��ǰ ���� �Է����ּ��� : ");
	            int add = sc.nextInt(); // �߰� ��� ��
	            fpriceCnt[productNum-1][1] += add;
	            System.out.println("�԰� �Ϸ�Ǿ����ϴ�.\n���� ��� :  " + fpriceCnt[productNum-1][1] + " �Դϴ�.");
	         }
	         return false;
	      } // 1~3ī�װ�

	      else { // 4 �����ڸ�� ����
	         return true;
	      }
	   }

	   // main ����
	   public static void main(String[] args) {
	      
	         Scanner sc = new Scanner(System.in);
	         // �迭�غ�
	         String[] flower = { "�Ȱ���", "����", "���", "�عٶ��", "ī���̼�" };
	         int[][] fpriceCnt = { { 7000, 2 }, { 15000, 2 }, { 20000, 2 }, { 15000, 0 }, { 12000, 1 } }; // ��ǰ����&���
	                                                                                 // ����Ǿ��ִ�
	         while (true) {       // ������ ��� ����� ����� ��� �ݿ��� ���� �ݺ��� ���                                                                  // ���߹迭

	         // ����ڸ�� �� �����ڸ�� ������ ����
	         System.out.println(" [1]����ڸ��   [2]�����ڸ��  [3]���α׷� ����");
	         System.out.print("�޴� ���� :  ");
	         int modeSelect = sc.nextInt(); // ����� ��� �� ������ ��� ����

	         if (modeSelect == 2) {
	            // [�Լ�ȣ��]
	            if (MaNager(fpriceCnt, flower)) {
	               System.out.println("�����ڸ�带 �����մϴ� :��\n");
	               continue;
	            }
	         } else if (modeSelect == 1) {
	            menu(fpriceCnt, flower); // �޴��� ����Լ� ȣ��

	            // �ݾ� ���� ����
	            int money; // ����ڰ� ���� �ݾ��� �Է¹޾� ������ ����
	            do {
	               System.out.print("�ݾ� �Է� : ");
	               money = sc.nextInt(); // �ݾ� �Է¹ޱ�
	               // �Է±ݾ��� �ּ� �ݾ׺��� ������
	               changeMoney(money); // �ݾ׺����� �ݾ� ��ȯ�ϴ� �Լ� ȣ��
	            } while (money < 7000);

	            // �Է¹�ư ����
	            int button;// �Է¹��� ��ư ����
	            boolean flag = false;// ��ǰ ��� �Ǿ����� Ȯ���� flag ����
	            while (true) {
	               System.out.print("�����Ͻ� ��ǰ ��ȣ�� �Է����ּ��� ������: ");
	               button = sc.nextInt();
	               System.out.println();

	               // �޴� ��ư ��ȿ���˻�
	               if (button < 1 || 5 < button) {
	                  System.out.println("[ERROR!!] �߸��� ��ȣ�Դϴ١�_��\n1~5�� ���� �Է����ּ��� ������\n");
	                  continue;
	               }
	               // ��ǰ ���
	               for (int i = 0; i < fpriceCnt.length; i++) { // 5���ݺ�
	                  for (int j = 0; j < 1; j++) {
	                     if (button == i + 1) { // �Է��� ��ư��ȣ�� ��ǰ��ȣ�� ��ġ�ϴٸ�

	                        if (fpriceCnt[i][1] == 0) { // ���� ��ư�� �Է¹޾����� ��� 0�̰ų� �׺��� �۴ٸ� ��� ���ٶ�� ��Ʈ ����� �ٽ� ����
	                           System.out.println("�����Ͻ� ��ǰ�� �����Ǿ����ϴ� T^T");
	                           System.out.println("������ ��� �˼��մϴ�.\n �� ������ ����ó : 123)123-1234 \n");
	                           flag = false;
	                           continue;
	                        }
	                        if (money < fpriceCnt[i][0]) { // ���� ���������� ��ǰ������ ũ��
	                           System.out.println("[ERROR!!] �ݾ��� �����մϴ� ������;;");
	                           continue;
	                        }
	                        fpriceCnt[i][1]--; // i�� �ε����� ��� �ϳ� ���̰�
	                        money -= fpriceCnt[i][0]; // �������� ���ݸ�ŭ ����
	                        System.out.printf("��[ %s ]��\n", flower[i]); // i��°��ǰ���� ��� �Ǿ��ٴ� �޼���
	                        System.out.println("�ܿ� �ݾ�: \"" + money + "��\" ���ҽ��ϴ�.\n");
	                        flag = true; // ��ǰ ��� �Ǻ��ϴ� flag
	                     }
	                  }
	               }

	               if (flag == true && money < 7000) { // ��ǰ ���� �ݾ��� �����ϸ� ����
	                  break;
	               } else if (flag == true && money >= 7000) { // ��ǰ ���� �ݾ��� ���������� �籸��? �ߴ� ����
	                  System.out.print("��ǰ�� �߰� �����Ͻðڽ��ϱ�?\nYes = 1, No = 2 : ");
	                  int ansYN = sc.nextInt();
	                  System.out.println();
	                  if (1 == ansYN) { // Yes���ý� ����
	                     continue;
	                  } else if (2 == ansYN) { // No ���ý� ����
	                     break;
	                  }

	               }
	            }
	            // ���� �� ��ȯ
	            if (money > 0) {
	               System.out.println("\n��ȯ �ݾ� : " + money + "��\n");
	               money = 0; // ��ȯ�� money �ʱ�ȭ
	            }

				// �����Ʈ
				System.out.println(" ---------------------------------------------------------- ");
				System.out.println("                                    �������ּż� �����մϴ�!��                 ");
				System.out.println("                                   ���ο� �Ϸ� �Ǽ���  ����   ��    ��  ~  ��               ");
				System.out.println(" ==========================================================");
			
			} else if (modeSelect == 3) {
				System.out.println("\n                  ���α׷��� �����մϴ� :D\n�̿����ּż� �����մϴ�  ��u���� ������ �� �̿����ּ��� ��  ");
				break;
			} else {
				System.out.println("\n                 �߸��� �Է��Դϴ� :-( \n          �ٽ� �Է����ּ���  1 / 2 / 3\n");

			}
		}
	}
}