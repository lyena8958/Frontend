package Team1_Project;

import java.util.Scanner;

public class yena2_An {

    static void menu(int[][] a,String[] b) {
        for (int i = 0; i < a.length; i++) {
            System.out.print((i+1)+":"+b[i] + " ");
            System.out.print(a[i][0] + "�� ");
        }System.out.println("\n\n"); // �ٹٲ�
    }
    static int changeMoney(int button,int money,int[][]fpriceCnt){
        if (money >= fpriceCnt[button][0]) {
            money -= fpriceCnt[button][0]; // ��ȯ�� �ʱ�ȭ
            System.out.println("��ȯ �ݾ� :" + money + "��\n\n");
        }
        else if (money < 7000) {
        	System.out.println("�ݾ��� �����մϴ� . ");
        }
        return money;
    }

    //�Լ� [����] - �޴����� - ī�װ� - ���� 
    static Boolean MaNager(int[][] fpriceCnt, String []flower){
    	Scanner sc = new Scanner(System.in);
    	
        System.out.println("������ ��й�ȣ �Է� : ");
        int pswd = sc.nextInt();
        if (pswd == 1004) {
            System.out.println("[ ������ ��� ] �� �����ϼ̽��ϴ� :D ");
        } else {
            System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. ���ٺҰ�");
            return true; // �����ڸ�� ����
        }
    	// �� �޴��Է�
        int menuNum;
    		do {//�޴���ȣ ��ȿ���˻�
    	System.out.println("������ ��ǰ��ȣ�� �Է��ϼ���. ");
    	menuNum = sc.nextInt();	
    	System.out.println(flower[menuNum-1]+" ����!!\n\n");
    		}while(menuNum < 1 || 5 < menuNum); 
    	 
    	// 	ī�װ� ����
    	int cateGoryNum; // ī�װ� �ѹ�
    		do {
        System.out.println("[1] ��ǰ����  [2] ��ǰ���ݺ���  [3]������ [4] �����ڸ�� ����");
        System.out.print("�޴��� �����ϼ��� : ");
        cateGoryNum = sc.nextInt(); // ī�װ� �Է�
    		}while(cateGoryNum < 1 || 4 < cateGoryNum);
    		if(cateGoryNum<4) {
        if (cateGoryNum == 1) {  // ��ǰ����
                System.out.printf("�����Ͻ� ��ǰ�� : ");
                flower[menuNum-1] = sc.next();
                System.out.println(flower[menuNum-1]+"�� (��)�� ��ǰ�� ����Ǿ����ϴ�.\n");
        }
        
        else if (cateGoryNum == 2) { // ��ǰ���ݺ���
                System.out.println("�� "+flower[menuNum-1]+"�� �ݾ��� "+fpriceCnt[menuNum-1][0]+" �Դϴ�.");
                System.out.println("���� �ݾ��� �Է����ּ��� : ");
                fpriceCnt[menuNum-1][0] = sc.nextInt();
                System.out.println(fpriceCnt[menuNum-1][0]+"���� �ݾ��� ����Ǿ����ϴ�.\n");
        }
        else if (cateGoryNum == 3) {  // ������
        	System.out.println("�� "+flower[menuNum-1]+"�� �ܿ����� "+fpriceCnt[menuNum-1][1]+" �Դϴ�.");
        	System.out.println("�߰� ��� ���� �Է����ּ��� : ");
        	int add = sc.nextInt(); // �߰� ��� ��
            fpriceCnt[menuNum-1][1] += add;
            System.out.println("�԰� �Ϸ�!! �� ���� "+fpriceCnt[menuNum-1][1]+" �Դϴ�.");
        }
        return false;
    		} // 1~3ī�װ�
    		
        else { // 4 �����ڸ�� ����
        	return true;
        }
    		}
    		



    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
		String[] flower = {"�Ȱ���", "����", "���", "�عٶ��", "ī���̼�"};
        int[][] fpriceCnt = {{7000, 2}, {15000, 2}, {20000, 2}, {15000, 0}, {12000, 1}}; // ��ǰ����&����� ����Ǿ��ִ� ���߹迭
		
    	while(true) {

    	  System.out.println(" 1)����ڸ�� \t2) �����ڸ��\t3)���α׷� ����");
          System.out.print("�������ּ��� :D ");
          int modeSelect = sc.nextInt();
         
    	if(modeSelect==1) {
               // �ɴٹ� ���Ǳ�
            System.out.println(" ==========* Flower Machine *========");
            System.out.println("        �� ����ϴ� ������� ������ ���ϼ���  ��   \n");
            System.out.println("              MENU          ");


            menu(fpriceCnt, flower); // �޴��� ����Լ� ȣ

        // �ݾ�����
            int money; // ����ڰ� ���� �ݾ��� �Է¹޾� ������ ����
            do {
                System.out.print("�ݾ� ���Ա� : ");
                money = sc.nextInt(); // �ݾ� �Է¹ޱ�
                // �Է±ݾ��� �ּ� �ݾ׺��� ������
            	if(money < 7000) {
          		  System.out.println("�ݾ��� �����մϴ�   ");
          	         System.out.println("��ȯ �ݾ� :" + money + "��");
          	         money = 0; // ��ȯ�� �ʱ�ȭ
          	}
            } while (money<7000);
         // �Է¹�ư
            int button;// �Է¹��� ��ư ����
            boolean flag = false;// ��ǰ ��� �Ǿ����� Ȯ���� flag ����
            while (true) {
                System.out.print("�����Ͻ� ��ǰ ��ȣ�� �Է����ּ��� uUu : ");
                button = sc.nextInt();

                // �޴� ��ư ��ȿ���˻�
                if (button < 1 || 5 < button) {
                    System.out.println("�߸��� ��ȣ�Դϴ�  1~5�� ���� �Է����ּ���");
                    continue;
                }
                // ��ǰ ���
                for(int i=0;i<fpriceCnt.length;i++) { //5���ݺ�
                    for(int j=0;j<1;j++) {
                        if(button == i+1) { // �Է��� ��ư��ȣ�� ��ǰ��ȣ�� ��ġ�ϴٸ�
                            if(fpriceCnt[i][1]==0) { // ���� ��ư�� �Է¹޾����� ��� 0�̰ų� �׺��� �۴ٸ� ��� ���ٶ�� ��Ʈ ����� �ٽ� ����
                                System.out.println("�����Ͻ� ��ǰ�� �����Ǿ����ϴ� T^T");
                                System.out.println("�����ڿ��� �����س��ڽ��ϴ� T^T");
                                money += fpriceCnt[button][0];
                                flag = false;
                                continue;
                            }
                            if(money< fpriceCnt[i][0]) { //���� ���������� ��ǰ������ ũ��
                                System.out.println("�ݾ��� �����մϴ� TvT");
                                continue;
                            }
                            fpriceCnt[i][1]--;   // i�� �ε����� ��� �ϳ� ���̰�
                            money -= fpriceCnt[i][0]; // �������� ���ݸ�ŭ ����
                            System.out.printf("�� [ %s ] ��\n", flower[i]); // i��°��ǰ���� ��� �Ǿ��ٴ� �޼���
                            System.out.println("�ܿ��ݾ�: \""+money+"��\" ���ҽ��ϴ�.");
                            flag = true; // ��ǰ ��� �Ǻ��ϴ� flag
                        }
                    }
                }
                if (flag == true && money < 7000) { // ��ǰ ���� �ݾ��� �����ϸ� ����
                    break;
                 } else if (flag == true && money >= 7000) { // ��ǰ ���� �ݾ��� ���������� �籸��? �ߴ� ����
                    System.out.println("��ǰ�� �߰� �����Ͻðڽ��ϱ�? ���� = 1, �����׸� = 2");
                    int ansYN = sc.nextInt();
                    if (1 == ansYN) { // Yes���ý� ����
                    	System.out.println(money+"�� ���ҽ��ϴ�.\n");
                       continue;
                    }else if(2==ansYN) { // No ���ý� ����
                    	money = changeMoney(button,money,fpriceCnt);
                              break;
                           }

                 }
            
            // ���� �� ��ȯ
                money = changeMoney(button,money,fpriceCnt);
            // �����Ʈ
          
       
        }
            System.out.println(" �������ּż� �����մϴ�");
            System.out.println(" ���ο� �Ϸ� �Ǽ��� @->->-");

        
        } // user
    	
    	if(modeSelect==2) {
        	//[�Լ�ȣ��]
        	if(MaNager(fpriceCnt,flower)) {
            	System.out.println("�����ڸ�� ����\n================================");
            	continue;
        	} 
    	}// manager
    	
        if(modeSelect==3) {
        	System.out.println("���α׷��� ���� �Ǿ����ϴ�.\n");
        	break;
        }
    	   
    	}// ���α׷� ����


    }
}
