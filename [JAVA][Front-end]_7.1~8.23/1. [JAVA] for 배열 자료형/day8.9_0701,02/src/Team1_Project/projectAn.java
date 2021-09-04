package Team1_Project;

import java.util.Scanner;

public class projectAn {

    static void menu(int[][] a,String[] b) {
        for (int i = 0; i < a.length; i++) {
            System.out.print((i+1)+":"+b[i] + " ");
            System.out.print(a[i][0] + "�� ");
        }System.out.println("\n\n"); // �ٹٲ�
    }
    static int changeMoney(int money){
        if (money < 7000) {
            System.out.println("�ݾ��� �����մϴ�   ");
            System.out.println("��ȯ �ݾ� :" + money + "��");
            money = 0; // ��ȯ�� �ʱ�ȭ
        }
        return money;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // �ɴٹ� ���� ���
        String[] flower = {"�Ȱ���", "����", "���", "�عٶ��", "ī���̼�"};
        int[][] fpriceCnt = {{7000, 2}, {15000, 2}, {20000, 2}, {15000, 0}, {12000, 1}}; // ��ǰ����&����� ����Ǿ��ִ� ���߹迭
        

        System.out.println(" 1)����ڸ��  2) �����ڸ��");
        System.out.print("�������ּ��� :D ");
        int modeSelect = sc.nextInt();

        if (modeSelect == 1) {
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
              changeMoney(money);
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
                                flag = false;
                                continue;
                            }
                            if(money< fpriceCnt[i][0]) { //���� ���������� ��ǰ������ ũ��
                                System.out.println("�ݾ��� �����մϴ� TvT");
                                continue;
                            }
                            fpriceCnt[i][1]--;   // i�� �ε����� ��� �ϳ� ���̰�
                            money -= fpriceCnt[i][0]; // �������� ���ݸ�ŭ ����
                            System.out.printf("%s �� \n", flower[i]); // i��°��ǰ���� ��� �Ǿ��ٴ� �޼���
                            flag = true; // ��ǰ ��� �Ǻ��ϴ� flag
                        }
                    }
                }

                if (flag == true && money>=7000) { // ��ǰ ���� �ݾ��� ���������� �� ����
                    continue;
                }else if (flag == true && money<7000) { // ��ǰ ���� �ݾ��� �����ϸ� ������
                    break;
                }
            }
            // ���� �� ��ȯ
            if(money>0){
                System.out.println("��ȯ�ݾ� : " + money + "��");
                money = 0; // ��ȯ�� money �ʱ�ȭ
            }
            // �����Ʈ
            System.out.println(" �������ּż� �����մϴ�");
            System.out.println(" ���ο� �Ϸ� �Ǽ��� @->->-");

        } else if (modeSelect == 2) {
            while(true) {
                System.out.println("������ ��й�ȣ �Է� : ");
                int pswd = sc.nextInt();
                if (pswd == 1004) {
                    System.out.println("[ ������ ��� ] �� �����ϼ̽��ϴ� :D ");
                    break;
                } else {
                    System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�. ���ٺҰ�");
                }
            }

            while (true) {
                System.out.println("[1] ��ǰ����  [2] ��ǰ���ݺ���  [3]������ [4] �����ڸ�� ����");
                System.out.print("�޴��� �����ϼ��� : ");
                int manageNum = sc.nextInt();

                if (manageNum == 1) {  // ��ǰ����
                    for (int i = 0; i < flower.length; i++) {
                        System.out.printf("%d�� �����Ͻ� ��ǰ�� : ", i + 1);
                        flower[i] = sc.next();
                    }
                    for (int i = 0; i < flower.length; i++) {
                        System.out.println(flower[i]);
                    }
                }
                else if (manageNum == 2) { // ��ǰ���ݺ���
                    for (int i = 0; i < fpriceCnt.length; i++) {
                        System.out.printf("%d�� �����Ͻ� �ݾ� : ",i+1);
                        fpriceCnt[i][0] = sc.nextInt();
                    }
                    for (int i = 0; i < fpriceCnt.length; i++) {
                        System.out.println(fpriceCnt[i][0]);
                    }
                }else if (manageNum == 3) {  // ������
                    for (int i = 0; i < fpriceCnt.length; i++) {
                        System.out.printf("%d�� ��� �߰� : ",i+1);
                        fpriceCnt[i][1] = sc.nextInt();
                    }
                    for (int i = 0; i < fpriceCnt.length; i++) {
                        System.out.println(fpriceCnt[i][1]);
                    }

                }else if (manageNum == 4) { // �������� ����
                    System.out.println("������ ��� ����");
                    break;
                }else{
                    System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
                }
            }
        }else{
            System.out.println("�߸��� �Է��Դϴ�. :( �ٽ� �Է��ϼ��� 1 or 2");

        }
    }
}