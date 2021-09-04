//�̿���
// ����� �� -> day22_0727 Test1
package day21_0726;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//����� ���� ����ó��
class MyException extends Exception {
	MyException(String msg) {
		super(msg);
	}
}

// �� ������ Ŭ����
class Customer {
	Customer(int cnum, String cname, String cphonenum, String address) {
		this.cnum = cnum;
		this.cname = cname;
		this.cphonenum = cphonenum;
		this.address = address;
	}

	// ������
	int cnum; // ����ȣ
	String cname; // ����
	String cphonenum; // �޴�����ȣ
	String address; // �ּ�

	// �����
	@Override
	public String toString() { 
		return "����ȣ: " + cnum + ", ����: " + cname + ", �޴�����ȣ:" + cphonenum + ", �ּ�:" + address;
	}

}

public class Test8 {
	// ����������Ʈ
	/*
	 * ����-������Ʈ / ���� �� ���� ���α׷� ���̺�-������ ����ȣ(pk),�̸�,��ȭ��ȣ(String),�ּ� 1 �Ƹ�
	 * 010-1234-5678 ����� ���Ǳ�
	 * 
	 * 1)�������߰� C 2)���������� U -> ��ȭ��ȣ����-1 �ּ�-2 3)���������� D 4)�������� R 5+) �������˻� 6)����
	 */

	//int�� ����ó���Լ�
	static int NumCheck(int a, int b) {
		MyException excp = new MyException("[�Է¿���] �ٽ� �Է����ּ���.");

		int num;
		while (true) {
			try {
				num = new Scanner(System.in).nextInt();
				if(num<a||b<num) {
					System.out.println("");
					throw excp;
				}
			}catch(InputMismatchException e) {
				new Scanner(System.in).next();
				System.out.println("[Ÿ�Կ���] �ٽ��Է����ּ���.");
				continue;
			}catch(MyException e) {
				System.out.println(e.getMessage());
				continue;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}

			break;
		}
		return num;
	}
	// (�����ε�) int�� ����ó���Լ� (���ھ���)
	static int NumCheck() {
		MyException excp = new MyException("[�Է¿���] �ٽ� �Է����ּ���.");
		int num;
		while (true) {
			try {
				num = new Scanner(System.in).nextInt();
			}catch(InputMismatchException e) {
				new Scanner(System.in).next();
				System.out.println("[Ÿ�Կ���] �ٽ��Է����ּ���.");
				continue;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}

			break;
		}
		return num;
	}
	// String�� ����ó���Լ� (���ھ���)
	static String strCheck() {
		MyException excp = new MyException("[�Է¿���] �ٽ� �Է����ּ���.");
		String str;
		while (true) {
			try {
				str = new Scanner(System.in).nextLine();
			}catch(InputMismatchException e) {
				new Scanner(System.in).next();
				System.out.println("[Ÿ�Կ���] �ٽ��Է����ּ���.");
				continue;
			}catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}

			break;
		}
		return str;
	}
	// ����ȣ �� �Լ� - boolean��ȯ
	static boolean cnumCom(ArrayList<Customer> data,int cnum) {
		for(int i = 0; i < data.size(); i++) {
			if(cnum == data.get(i).cnum) {
				System.out.println(data.get(i).cname+"��, �ݰ����ϴ�.");
				return true;
			}
		}
		return false;
	}
	// ����ȣ �� �Լ� (�����ε�) - index ��ȯ 
	static int cnumIndex(ArrayList<Customer> data,int cnum) {
		for(int i = 0; i < data.size(); i++) {
			if(cnum == data.get(i).cnum) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ������ ������ �迭����Ʈ
		ArrayList<Customer> data = new ArrayList<Customer>();

		// ����̹� �ּ�
		String DName = "com.mysql.cj.jdbc.Driver";

		String url = "jdbc:mysql://localhost:3308/leedb";
		String user = "root";
		String pw = "8958";
		String sql = "select * from customer order by cnum asc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// ����̹� ����
			Class.forName(DName);

			// db����
			conn = DriverManager.getConnection(url, user, pw);

			// db����
			stmt = conn.createStatement();

			// ����ü ����
			rs = stmt.executeQuery(sql); // select�� �Ҷ��� ��

			// db�� �Էµ� ������ customerŬ���� ��üȭ
			while (rs.next()) {
				data.add(new Customer(rs.getInt("cnum"), rs.getString("cname"), rs.getString("cphonenum"),
						rs.getString("address")));
			}


			// ���� ����ȣ (data.size()-1.cnum == Last index cnum) ��������ȣ
			int nextCnum = data.get(data.size()-1).cnum;


			// �����α׷� *********************S T A R T***********************
			while (true) {

				System.out.println("\n\n�ۡ�ȸ�� ���������� �Դϴ�. ���Ͻô� ��ư�� �Է��Ͽ� �ּ���.\n");
				System.out.println("1.ȸ������\n2.����������\n3.ȸ��Ż��\n4.��������\n5.�����˻�\n6.����");

				int act = NumCheck(1, 6); // ��弱��,  ����ó���Լ�ȣ�� 1�̻� 6���� �Է�

				// [ȸ������]
				if (act == 1) {
					System.out.println("- - - - - - - - - - -ȸ������ ���- - - - - - - - - - -");
					// �������� �Է�
					System.out.println("������ �Է����ּ���. ");
					String cname = strCheck(); 
					System.out.println("�޴�����ȣ�� �Է����ּ���. ");
					String cphonenum = strCheck();
					System.out.println("�ּҸ� �Է����ּ���. ");
					String address = strCheck();

					nextCnum++;// �ο��� ����ȣ

					// DB ������ ����
					sql = "insert into customer values(" + nextCnum + ", '" + cname + "', '" + cphonenum + "', '"
							+ address + "')";
					// ���԰� ������ ��üȭ 
					data.add(new Customer(nextCnum, cname, cphonenum, address));

					stmt.executeUpdate(sql); // ������ ������Ʈ
					System.out.println(cname+"��, �ݰ����ϴ�!! ȸ������ �Ϸ�Ǿ����ϴ�! :D");
				}
				// [����������]
				else if (act == 2) {
					System.out.println("- - - - - - - - - - -���������� ���- - - - - - - - - - -");
					System.out.println("����Ȯ���� ���� ����ȣ�� �Է����ּ���. ");

					int cnum = NumCheck(); // ����ȣ �Է�

					// (����ȣ ��)
					// ������ ����ȣ�� ��ġ�����ʴٸ�
					if(!cnumCom(data, cnum)) {//�Լ�ȣ�� -> ����ȣ�� ������ false��ȯ
						System.out.println("����ȣ�� ��ġ���� �ʽ��ϴ�. �������� ��� ����˴ϴ�.");
						continue; // ���α׷� ó������ �̵�
					}
					// �Լ�ȣ�� -> ������� index ��ȯ
					int index = cnumIndex(data,cnum); 

					// ��ȣ�� ��ġ�ϴٸ� ��������
					System.out.println("������ ����� �������ּ���!!");
					System.out.println("1. �̸�\t2.�޴�����ȣ\t3.�ּ�");
					act = NumCheck(); // �����ϼ���

					if (act == 1) {// �̸�����
						System.out.println("������ �̸��� �Է����ּ���. ");
						String cname = strCheck();; // �����̸��Է�
						sql = "update customer set cname='" + cname + "' where cnum=" + cnum;
						stmt.executeUpdate(sql); // db������ ����
						data.get(index).cname = cname; // ��ü �����ͺ���
						System.out.println(cname + "���� ���� �Ϸ�Ǿ����ϴ�.");
					}

					else if (act == 2) {// �޴�����ȣ����
						System.out.println("������ �޴�����ȣ�� �Է����ּ���. ");
						String cphonenum = strCheck(); // �����ȣ�Է�
						sql = "update customer set cphonenum='" + cphonenum + "' where cnum=" + cnum;
						stmt.executeUpdate(sql); // db������ ����
						data.get(index).cphonenum = cphonenum; // ��ü �����ͺ���;
						System.out.println(cphonenum + "���� ���� �Ϸ�Ǿ����ϴ�.");
					} else if (act == 3) {// �ּҺ���
						System.out.println("������ �ּҸ� �Է����ּ���. ");
						String address = strCheck();// �����ּ��Է�
						sql = "update customer set address='" + address + "' where cnum=" + cnum;
						stmt.executeUpdate(sql);// db������ ����
						data.get(index).address = address; // ��ü �����ͺ���;
						System.out.println(address + "���� ���� �Ϸ�Ǿ����ϴ�.");
					} else {// ��� ��ȣ�� �ƴ϶��
						System.out.println("���õ� ��尡 �ƴմϴ�. ���Է����ּ���!");
						continue;
					}
				} 
				// [����������]
				else if (act == 3) {
					System.out.println("- - - - - - - - - - -ȸ��Ż�� ���- - - - - - - - - - -");
					System.out.println("����Ȯ���� ���� ����ȣ�� �Է����ּ���. ");

					int cnum = NumCheck(); // ����ȣ �Է�

					// ������ ����ȣ�� ��ġ�����ʴٸ�
					if(!cnumCom(data, cnum)) {//�Լ�ȣ�� -> ����ȣ�� ������ false��ȯ
						System.out.println("����ȣ�� ��ġ���� �ʽ��ϴ�. �������� ��� ����˴ϴ�.");
						continue; // ���α׷� ó������ �̵�
					}
					// �Լ�ȣ�� -> ������� index ��ȯ
					int index = cnumIndex(data,cnum); 

					data.remove(index);// ȸ��Ż��� �����ͻ���
					sql = "delete from customer where cnum="+cnum;
					stmt.executeLargeUpdate(sql);
					System.out.println("ȸ�� Ż�� �Ϸ� �Ǿ����ϴ�.\n\n");
				}
				// [��������]
				else if (act == 4) { 
					System.out.println("==========================�����==========================");
					for (int i = 0; i < data.size(); i++) {
						System.out.println(data.get(i)); // ���� ���
						System.out.println();
					}
					System.out.println("========================================================\n\n");
				} 
				// [���˻�]
				else if (act == 5) {
					System.out.println("- - - - - - - - - - -�������˻� ���- - - - - - - - - - -");
					System.out.println("����Ȯ���� ���� ����ȣ�� �Է����ּ���. ");

					int cnum = NumCheck(); // ����ȣ �Է�

					// ������ ����ȣ�� ��ġ�����ʴٸ�
					if(!cnumCom(data, cnum)) {//�Լ�ȣ�� -> ����ȣ�� ������ false��ȯ
						System.out.println("����ȣ�� ��ġ���� �ʽ��ϴ�. �������� ��� ����˴ϴ�.");
						continue; // ���α׷� ó������ �̵�
					}
					// �Լ�ȣ�� -> ����� index ��ȯ
					int index = cnumIndex(data,cnum); 

					sql = "select * from customer where cnum=" + cnum;
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						System.out.println("����: " + rs.getString("cname") + "\t" + "�޴���ȭ: " + rs.getString("cphonenum")
						+ "\t" + "�ּ�: " + rs.getString("address"));
						System.out.println();
					}
				}
				// [���α׷� ����]
				else {
					System.out.println("\n- - - - - - - - - - -���α׷� ����- - - - - - - - - - -");
					System.out.println("�̿��� �ּż� ����帳�ϴ�. ���� �Ϸ� ��������!\n\n");
					break;
				}

			} // while ���α׷�����
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { // ���������� ������ ���� �ʾҴٸ� ��������
				if (!(conn == null)) {
					conn.close();
				}
				if (!(stmt == null)) {
					stmt.close();
				}
				if (!(rs == null)) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}//main����

}
