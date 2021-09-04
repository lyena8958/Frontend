package day20_0723;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// ���� DBMS(MySQL)�� member ���̺� ���� 
		String DName = "com.mysql.jdbc.Driver";

		String url = "jdbc:mysql://localhost:3308/leedb";
		String user = "root";
		String password = "8958";

		String sql = "select * from member";
		
		
		
		// �����===================================================================
		
		// try���� ������ �߻��ϸ� close�� �ȵǱ⶧����
		// finally���� �ݵ��close ��������ش� 
		
		//finally ���� close�ϱ� ���� �Ʒ� null�� �ʱ�ȭ
		Connection conn = null; //
		Statement stmt = null;//
		ResultSet rs =null ;//
		try {
				Class.forName(DName); //�޸�����

			// ���ܰ��߻��ϸ� conn�� ��������ʱ⶧��
			 conn = DriverManager.getConnection(url, user, password); // db���� 
																				
			 stmt = conn.createStatement();
			 
			 // �˻�@@@@@@@@@@@@@@@@@ num
			 /*
			 System.out.println("�˰���� ��ȣ�� �Է��ϼ���!");
			 Scanner sc = new Scanner(System.in);
			 int num =sc.nextInt();
			 // ex)select *from member where mnum=3; �� ���� ��
			 String sql2 = "select * from member2 where mnum="+num;
			 rs = stmt.executeQuery(sql2); 

			if (rs.next()) {
				System.out.print(rs.getInt("mnum") + " "); 
				System.out.print(rs.getString("mname") + "��, ");
				System.out.println(rs.getInt("point") + "p");

			}else {
				System.out.println("�ش��ȣ�� ����� �����ϴ�!");
			}*/
			 
			 
			 // �˻�@@@@@@@@@@@@@@@@@ point
			 System.out.println("�˻������� �� ����Ʈ�� �Է��ϼ���");
			 Scanner sc = new Scanner(System.in);
			 int point = sc.nextInt();
			 String sql2 = "select * from member2 where point>="+point;
			 rs = stmt.executeQuery(sql2);  // ȫ�浿�Ƹ��ƹ��� ����!(==itr)
			 
			 // rs�� ����Ȱ� 1 2 3 �̶�� 
			 // if���� 1�� �������� ������������ 23�� while���� ������
			 // ��Ȯ�ϰԴ� ���� next�������� ��������.(1. next(1) 2. (1)delete next(2 3))
//			 if(!rs.next()) {// ù��°����� ȫ�浿�� ���ư��� == �������� �����⶧����
//				 System.out.println("�˻��������");
//			 }
			 boolean flag=true; // ���� ���������� ���� ����
			 while (rs.next()) {//�ƹ����� �Ƹ�������
					System.out.print(rs.getInt("mnum") + " "); 
					System.out.print(rs.getString("mname") + "��, ");
					System.out.println(rs.getInt("point") + "p");
					flag=false;
				}
			 if(flag) {
				 System.out.println("�˻��������");
			 }
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{// ������ �߻��ϸ� close�� ����ȵǴ�(null.close) try -->finally�� ����
			// �ؾߵ� ����ó���� ���̳θ� �ȿ��� �ϰڴ�.(�μ������� ����!)
			// ������ ������ �ۿ��� ���� -> �ʱ�ȭ�ض�
				
			// re.close�� �ݵ�� �����൵�ȴ�.(stmt���� �ϱ⶧��)
			// ���������� ��ü�� �������������� null.close�� �����Ǹ� ū ������ �Ǳ� ������
			// ���ǹ����� �������ش�. (�Ҵ������ ����!!, �������� ������ �ʿ���� ����)
			if(rs!=null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}

			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		//���������� ���ϸ� �ڸ��� �ڲٴþ�� �����̺���������.
		
		
		/* ����================================================================
		try {
			Class.forName(DName);

			Connection conn = DriverManager.getConnection(url, user, password); 
																				
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql); 

			while (rs.next()) {
				System.out.print(rs.getInt("mnum") + " "); 
				System.out.print(rs.getString("mname") + "��, ");
				System.out.print(rs.getInt("mpoint") + "p");

				System.out.println();
			}

			stmt.close(); 
			conn.close(); 

		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/


	}

}
// DBMS(MySQL)�� member ���̺� ����
// 1001 ȫ�浿 100p
// 1002 �ƹ��� 120p 
// 1003 �Ƹ� 70p

// console���� �������� �������.
//1001 ȫ�浿��, 100p
//1002 �ƹ�����, 120p 
//1003 �Ƹ���, 70p