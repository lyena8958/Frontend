

/* ���� ������Ʈ �޴���
 * �ݾ��Է� -> ������ 7000�� �̸� �Է½� -> [��ȿ���˻�] ���Է�
 *	
 * *���Ǳ� ����
 * 1. �޴�ǥ �ȳ�
 * 2. �޴���ȣ�Է� �� [��ȿ���˻�]if(�Է±ݾ�-���ø޴��ݾ�) < 0 �̸� continue(1���� �����-�޴����Է�)
 * 3. if(��� ����) �� �Է�(1:��ǰ�缱��, 2:����) �� ���ο����� continue or break(�ܵ���ȯ) ����
 * 4. �ܵ���ȯ �� �ܵ���ŭ 10000, 5000...100�� cnt �� cnt 1�̻��̸� ��¸�Ʈ ����  
 * 5. �����λ� �� ����~~!!!!
 * */

package Team1_Project;
import java.util.Scanner;
public class yena1 {
	//[���]
	final int SU = 5; // �޴��� ����
	final static int managerpass = 5959; // �޴��� ����
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �޴�
		String[] muName = {"�Ȱ���", "����", "���", "�عٶ��","ī���̼�"};
		
		// ��ǰ �ݾװ� ���
		int[][] priceCnt = { {7000,15000,20000,15000,12000}, {1, 3, 5, 10, 0} };
		
		int money; // ����� ����
		
		System.out.println("���Ž���: �����ּ���!");
		int buystart = sc.nextInt();
		
		if(MaNager(priceCnt,buystart)) { //���Ž��۹�ư�� �����ڹ�ȣ�� ���ٸ� ����߰� ��, �ý��� ����
			System.exit(0);
		}
		
		menuPrint();
		
		do {//[��ȿ���˻�] �̸��ݾ� �Է½� �ݺ� 
		System.out.print("�ݾ� ����(7,000�� �̻�): ");
		money = sc.nextInt();
	}while(money < 7000);

		System.out.println("[ "+money+" ] ����");
		
		int button; // �޴� �Է¹�ư
		
		// �����Ǳ� �̿� START��
		while(true) { 
			
			//���� �������� �� ��ȯ���� ī��Ʈ
			int mCount[][] = { { 10000, 5000, 1000, 500, 100 } , {0,0,0,0,0} };
			
			// [�Լ�]�޴��� �ȳ�
			menuPrint();
			
			System.out.println("���Ǳ� ��ȣ Ŭ��(1~5): ");
			button = sc.nextInt();
			
			// [��ȿ���˻�]�Է¹�ư 
			if(button<1||5<button) {
				System.out.println("[Error] �޴���ȣ 1~5�� ���� ���Է� ���ּ���.");
				continue;  // ��ȣ ���Է� �� �޴��Ǻ��� ��ȳ�
			}
			
			
			// �Է��� �ݾ� - ���� �޴� = ���̳ʽ� �ݾ� Ȯ���ϴ� ����
			int minus = money - priceCnt[0][button-1];
			
			// [��ȿ���˻�]���Աݾ� - ���űݾ� = 0 �̸��� ���, �޴� �缱��
			if(minus<0) { // + �ð��� �ȴٸ� �ݾ��� ó������ �Է��ϴ� �� �� ������!!~
				System.out.println("\n===================================================");
				System.out.printf("[���Է�] �Է±ݾ�: %d, %s: %d�� = %d���� �����մϴ�.\n�޴� ����â���� �ǵ��ư��ϴ�.\n",money,muName[button-1], priceCnt[0][button-1],priceCnt[0][button-1]-money);
				System.out.println("===================================================\n\n");
				continue;
			}
			
			// ���õ� �޴��ȳ�
			System.out.println(muName[button-1]+" ����!\n");
			
			money -= priceCnt[0][button-1]; //��ȯ�� �ݾ�
			
			
			// ��� ����
			priceCnt[1][button-1]--;
			
			// ������ ��ǰ�� �ִٸ�, �缱��or������� ������ �Ѵ�. (�缱��==1)
			if(priceCnt[1][button-1] < 0) {
			if(soldout(priceCnt[1][button-1])){
				mReturn(mCount,money); // [�Լ�] - �ܵ����� ���� cnt 
				break;
			}
			else {
				continue;
			}
			}
			
			mReturn(mCount,money); // [�Լ�] - �ܵ����� ���� cnt 
			
			break;
		}
		System.out.println("\n�������� ���Ǳ� �̿��� �ּż� �����մϴ٢����� *�Ƹ��ٿ� �Ϸ� ��������  \n");

	} //====================================================================================================================== main
	 //=======================================================================================================================  ����
	// ������ ��� �Լ�
	public static Boolean MaNager(int[][] priceCnt,int pass) {
		Scanner sc = new Scanner(System.in);
		if(pass==managerpass) {
			
			System.out.println("��� �߰��� �޴���ȣ�� �Է�: ");
			int mgnum = sc.nextInt();	// ������ �޴���ȣ �Է�
			System.out.println("��� �����Է�: ");
			int cntAdd = sc.nextInt(); // �߰��� �����
			priceCnt[1][mgnum] += cntAdd; 
			
			return true;
			
		}
		return false;
	
	}
	
	
	// ���� �ȳ� �Լ�(1�Ǵ� 0 ��ȯ)
	public static Boolean soldout(int user) {
		Scanner sc = new Scanner(System.in);
		

			System.out.println("�����Ͻ� ��ǰ�� �����Ǿ����ϴ�.\n");
			
			do { //[��ȿ���˻�] �ȳ���Ʈ 1,0 �� �� �Է��� ��� �ݺ�
				System.out.print("��ǰ �缱��: 1��\t���� ���: 2�� �Է� >> ");
				user = sc.nextInt(); // ���� ����	
			}while(!(user==1||user==2));
			if(user==1) {
				return false;
			}
			else {
				return true;
			}
		}//if����
	
	   static int MoneyCom(int money) {
		      if (money < 7000) {
		         System.out.println("[ERROR!!] �ݾ��� �����մϴ�  o��o;");
		         System.out.println("��ȯ �ݾ� :" + money + "��\n");
		         money = 0; // ��ȯ�� �ʱ�ȭ
		      }
		      return money; 
		   }	
	// ��ȯ�ݾ� ���(����)
	public static int CashReturn(int[][] mCount, int money){
	   if (money > 0) { // ��ȯ�� �ݾ��� 0���� ũ��
		   System.out.print("[ ");
        	System.out.println(money+"�� ��ȯ�˴ϴ�.");
            for (int i = 0; money > 0;) { // �ܵ��� 0�� �ɶ����� �ݺ�
            
                if (money >= mCount[0][i] ) { // 10000..500..10�� ������ ���� �۴ٸ�?
                	mCount[1][i]++;	// ���� cnt++;
                    money -= mCount[0][i]; // ����� �������ŭ �ܵ� ���� 
                }
                else {
                	i++;
                }
            }//for1
            for (int i = 0; i < 5; i++) {
                if (mCount[1][i]==0) { // ���󸶴� ��ȯ�� ������ ���ٸ�, �ǵ��ư���.
                    continue;
                }
                else { // ��µ� ���� �ȳ�
                	System.out.println("- "+mCount[0][i]+"��: "+mCount[1][i]+"�� ");
            }
                System.out.print("]");
        }//for2
		
	}//if>0 
        else {
        	System.out.println("��ȯ�ݾ� = 0\n");
        }
	   
	   return money; // ���� money ��ȯ
	}//�Լ�����
	
	// [�Լ�] �޴��� ���
	public static void menuPrint() {
		System.out.println("��         ��  ��   ��");
		System.out.println("�� �� �� �� �š��Ţ��� �Ţ��� ������ �Ţ��� ������ �Ţ��� ������ �Ţ��� \n�� �� �Ųɢ����Ǳ⡣�Ţ��� �Ţ��šŢ��� �Ţ��šŢ��� �Ţ��šŢ��� �Ţ���");
		System.out.println(" �� �� �Ţ��� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��\n�� �� �� ��  �ҡ� �ҡ� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��");
		System.out.println(" _-(())(())-_ �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��\n-((()))��((()))- ��  1.�Ȱ���     7,000���� �Ţ��� �� ");
		System.out.println("(())��((��))��(())�� �� 2.����      15,000�� �� �� �� �Ţ� \n�� �� ��(())��(()) �� �� ��  3. ���     20,000���� �Ţ��� �� ");
		System.out.println("��   ��   ��  �� | |  �� �� �� ��   4. �عٶ�� 15,000�� �� �� �� �� \n��  �� �� �� ��   == �� �� �� �� ��    5. ī���̼� 12,000�� �� �Ţ�");
		System.out.println("��  ��  �� �� d| |b �� �� �� �� �Ţ��� �� �š��� �� �Ţ��� �� �� �� �� �� �� �� ��  \n��  ��  ��  ��  ��  ��  ��  ��  �Ţ� ��  ��  �� �� ��  ��  �Ţ� ��  �� ��  �� �� �� �� ��");
		System.out.println(" �� �� �� �Ţ��� �� �� �� �Ţ��� �� �� �� �Ţ��� �� �� �Ţ��� �� �� �� �� �� ��  �� �� �� ��  \n�� �� �� �� �� �Ţ� �� �� �� �Ţ��� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� \n�� �š��� �Ţ��� �� �� �Ţ��� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� �� ��");	
			}
	
}
