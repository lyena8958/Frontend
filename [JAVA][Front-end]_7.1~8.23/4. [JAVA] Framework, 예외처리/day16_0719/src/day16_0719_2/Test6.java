package day16_0719_2;

import java.util.ArrayList;
import java.util.Scanner;

// ���Ǳ� ���α׷� -> �÷��� �����ӿ�ũ�� Ȱ���غ���!
class Cafe {
	String manu;
	int price;
	int cnt; // ���

	Cafe(String menu) {
		this(menu, 2000);
	}

	Cafe(String menu, int price) {
		this.manu = menu;
		this.price = price;
		this.cnt = 5;
	}

	void change(String menu) {
		this.manu = menu;
		System.out.println("�޴��̸� ����Ϸ�!");
	}

	void change(int price) {
		this.price = price;
		System.out.println("���ݺ���Ϸ�!");
	}

	void addCnt() {// ����߰��� ���� 10��
		this.cnt += 10;
		System.out.println(this.manu + "��(��) �߰���!");
	}

	@Override
	public String toString() {
		return manu + ": " + price + "�� [" + cnt + "]";
	}

	public boolean equals(Object obj) {
		Cafe c = (Cafe) obj;
		if (c.manu == this.manu) {
			return false;
		}
		return true;
	}

}

public class Test6 {
	static int NumCheck(int a, int b, int num) {

		while (true) {
			if (num < a || b < num) {
				System.out.println("[���Է�] " + a + "�̻� " + b + "���Ϸ� �ٽ� �Է����ּ���!");
				num = new Scanner(System.in).nextInt();
				continue;
			}
			break;
		}
		return num;
	}

	public static void main(String[] args) {
		/* ����
		���α׷�����

		1.���� 2.���� 3.����߰� 4.����

		1)
		��Ϻ���
		���Ź�ȣ
		����
		�� ���� �ݾ�

		2)
		�޴��̸� vs ����

		3)
		��Ϻ���
		�߰���ȣ*/
		Scanner sc = new Scanner(System.in);
		ArrayList<Cafe> cafe = new ArrayList();
		ArrayList<Cafe> al = new ArrayList(); // �����

		al.add(new Cafe("�Ƹ޸�ī��"));
		al.add(new Cafe("ī���", 2500));

		// ����� ��
		/*
		while (true) {
			System.out.println("1-���� 2-���� 3-����߰� 4-�޴��߰� 5-����");
			int act = sc.nextInt();
			if (act == 1) {
				System.out.println("==�޴���==");
				for(int i = 0; i < al.size();i++) {
					System.out.println((i+1)+"�� "+al.get(i));
				}
				System.out.println();
				System.out.println("������ �޴��� ��ȣ�Է�: "); 
				int num = sc.nextInt(); // ��ȿ���˻簡 �ʿ��ϳ� ����
				System.out.println("���� ���� �Է�");
				int cnt = sc.nextInt(); // ����2
				if(al.get(num-1).cnt<cnt) {
					System.out.println("��������!");
					continue;
				}
				System.out.println("�� �ݾ��� "+al.get(num-1).price*cnt+"���Դϴ�.");
				al.get(num-1).cnt-=cnt;
				
			} 
			  else if(act==2) {
		            System.out.println("������ �޴��� ��ȣ�Է�");
		            int num=sc.nextInt();
		            System.out.println("1-�޴�����  2-���ݺ���");
		            int ans=sc.nextInt();
		            if(ans==1) {
		               al.get(num-1).change("�޴���");
		            }
		            else {
		               al.get(num-1).change(1000);
		            }
		         }

			else if (act == 3) {
				for (Cafe menu : al) {
					System.out.println(menu);
				}
				System.out.println("��� �߰��� �޴���ȣ�Է�");
				int num = sc.nextInt();
				if (num < 1 || al.size() < num) {
					System.out.println("��ȣ����!");
					continue;
				}
				al.get(num - 1).addCnt();
			} 
			else if (act == 4) {
				System.out.println("�߰��Ͻ� �޴��� �̸��Է�");
				String name = sc.next();
				System.out.println("������ �Բ� �Է�?");
				String ans = sc.next();
				if(ans.equals("yes")||ans.equals("Y")) { // �޴�+�����Է�
					System.out.println("�����Է�");
					int price = sc.nextInt();
					al.add(new Cafe(name,price));
				}
				else {// �޴��Է�
					al.add(new Cafe(name));
				}
			} 
			else if (act == 5) {
				break;
			} 
			else {
				System.out.println("�߸��Է���!");
			}
		}*/

		// ����
		// ���Ÿ�忡 ���񱳿� �ѱݾ� �����ʿ�
		while(true) {
			System.out.println("1.����ڸ��  2. �����ڸ��  3. ���α׷� ����");
			int ans = NumCheck(1,3,sc.nextInt());
			//����ڸ��
			if(ans == 1) {
			while(true) {
				System.out.println("==����ڸ��==\n1.�޴��� Ȯ��  2. ����  3. ����� ����");
				ans = NumCheck(1,3,sc.nextInt());
				// �޴���Ȯ��
				if(ans==1) {
					System.out.println("========�޴���=======\n");
					for(Cafe v: cafe) {
						System.out.println(v);
					}
				}//ifend
					else if (ans == 2) {
						if (cafe.size() == 0) { // ��ȿ���˻�
							System.out.println("������ ��ǰ�� �����ϴ�. �̿뿡 ������ ��� �˼��մϴ�.");
							continue;
						}
						int pay = 0; //�����ݾ�
						while (true) {
							System.out.println("��������: 0���Դϴ�. ��� �����Ͻ÷��� �ٸ����ڸ� �Է��ϼ���");
							ans = sc.nextInt();
							if (ans == 0) {
								break;
							}
							System.out.println("========�޴���=======\n");
							for (Cafe v : cafe) {
								System.out.println(v);
							}
							System.out.println("�����Ͻ� �޴��� ��ȣ�� �Է����ּ���!");
							ans = NumCheck(1, cafe.size(), sc.nextInt());
							if (cafe.get(ans - 1).cnt == 0) {
								System.out.println("[���� ����] �ش� �޴� ��� ���� ���Ű� �Ұ��մϴ�.");
								continue;
							}
							System.out.println(cafe.get(ans - 1) + " �ֹ��Ϸ�!!");
							pay +=cafe.get(ans-1).price;
							System.out.println("�� �ݾ�: "+pay);
							cafe.get(ans - 1).cnt--;
						}
					}
				else {
					System.out.println("����� ��带 �����մϴ�! �̿뿡 ����帳�ϴ�.");
					break;
				}
				
			}
			}
			
			
		else if (ans ==2) {
		while (true) {
			System.out.println("==�����ڸ��==\n1.�޴� �� ���ݺ���\t2.����߰�\t3.�޴��߰�\t4.����");
			ans = NumCheck(1, 5, sc.nextInt());
				if (ans == 1) {// ����
				System.out.println("[������] 1.�޴��̸�\t2.����\t");
				ans = NumCheck(1, 2, sc.nextInt());
				System.out.println("========�޴���=======\n");
				for (Cafe v : cafe) {
					System.out.println(v);
				}
				System.out.println(ans + "�� ��弱��: ������ �޴��� �������ּ���!");
				int menuPick = NumCheck(1, cafe.size(), sc.nextInt());
				if (ans == 1) {// �޴��̸�����
					System.out.println("������ �޴��̸��� �Է����ּ���!");
					String manuName = sc.next();
					boolean flag = true;
					for (int i = 0; i < cafe.size(); i++) {
						if (manuName.equals(cafe.get(i).manu)) {
							System.out.println(cafe.get(menuPick - 1).manu + "�� " + manuName + "����Ϸ�!!");
							cafe.get(menuPick - 1).manu = manuName;
							flag = false;
						}
					}
				} else if (ans == 2) {// ���ݺ���
					System.out.println("������ �ݾ��� �Է����ּ���!");
					ans = sc.nextInt();
					System.out.println(cafe.get(menuPick - 1).price + "�� " + ans + "����Ϸ�!!");
					cafe.get(menuPick - 1).price = ans;
				}
			} else if (ans == 2) {// ����߰�
				System.out.println("��� �߰��� �޴��� �������ּ���!");
				for (Cafe v : cafe) {
					System.out.print(v);
					System.out.println();
				}
				ans = NumCheck(1, cafe.size(), sc.nextInt());
				System.out.println(cafe.get(ans - 1).manu + "�����ϼ̽��ϴ�. �߰��� ������� �Է��ϼ���: ");
				int add = sc.nextInt();
				cafe.get(ans - 1).addCnt();
			} else if (ans == 3) { // �޴��߰�
				System.out.println("�߰��� �޴��� ���ڷ� �Է����ּ���!");
				String menuAdd = sc.next();
				boolean flag = false;
				// �޴��� ��ȿ���˻�
				for (int i = 0; i < cafe.size(); i++) {
					if (cafe.get(i).manu.equals(menuAdd)) {
						flag = true;
					}
				}
				if (flag) {// �ߺ��� �޴��� ������ ���� ����
					System.out.println("[����] �ߺ��� �޴��� ����� �Ұ��մϴ�.");
					continue;
				}
				System.out.println("�ݾ��� �Է����ּ���!");
				ans = sc.nextInt();
				cafe.add(new Cafe(menuAdd, ans));
				System.out.println("[�Ÿ޴�] " + menuAdd + ": " + ans + "�� ��� �Ϸ�!!");
			} else if (ans == 4) {// ����
				System.out.println("ī�� ���α׷��� �����մϴ�. �̿��� �ּż� �����մϴ�!");
				break;
			}

		}
		}
		else {
			System.out.println("ī�� ���α׷��� ����˴ϴ�. �̿��� �ּż� �����մϴ�.");
			break;
		}
		}

	}// main����
}
