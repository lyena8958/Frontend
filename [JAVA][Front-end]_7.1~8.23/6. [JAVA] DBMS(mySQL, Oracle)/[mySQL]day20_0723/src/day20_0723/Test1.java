package day20_0723;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
DB ����
JDBC API: DBMS�� �����͸� CRUD�� �� �ְ� ����  (�ڹ�DB���� �÷���)

 1) JDBC ����̹� �޸𸮿�(JVM) �ε� (�ڹٿ��� ������ ���ϼ������� JVM�� �ִ�)
 2) DB�� ����
 3) DB�� �����͸� read, write(CRUD)
 4) DB���������� 

 */
public class Test1 {
	public static void main(String[] args) {
		
		// ����̹��� �̸��� ���������ϸ� �޸𸮿� ���縦 ���ش�.
		
		// Class.forName(DName);
		String DName="com.mysql.jdbc.Driver"; // ����̹�
		  // Mysql DBMS �ּ��޾ƾ��� �Ʒ� �������̾ƴ϶��
		// String DName_Mysql="com.mysql.jdbc.Driver"; // ����̹�

		
		//DriverManager
		// �Ʒ�ó�� ���������� ���� �̸� �������´�.
		String url="jdbc:mysql://localhost:3308/leedb";
		//			��������			IP�ּ�   :��Ʈ��ȣ/DB��(��Ű����)
		//						ip:����pc�����ϱ⶧���� �ּҸ���������
		String user="root";
		String password="8958";

		
		String sql ="select * from student2"; 
		
		try {
			// (1) �ε� - sqlƲ�Ȱų� �ش�db�������� ����Ұ�
			Class.forName(DName); // 	Class.forName("com.mysql.jdbc.Driver"); �� �� ������ ���������� ������.
			// JDBC�� ����̹� Ŭ�������� �а��Ͽ�
			// �޸𸮿� �����ų����
			
			
			// ����Ÿ��: Ŀ�ؼ��̱⶧���� Ŀ�ؼ� �������� (getConnection- ���ͷ�)
			Connection conn=DriverManager.getConnection(url, user, password); //DriverManager.getConnection(url, user, password)
			//url:�����Ҽ��ִ°��
			// DB������ �����ϸ�, �ش�DB�� �����Ҽ��ְ� ���ִ�
			// Ŀ�ؼ� Connection ��ü�� ��ȯ�޴´�!
			// �ֿܼ� ȭ���� write�Ҽ��ִ°� scanner == Ŀ�ؼ� (�����ǹ�) ->�Ѵ� Ŭ������ ��ü!
			
			// DBMS�� �ڹ��� �ܺ�, �л�1�� ����, �л�2�� ���� ���������ص� ����̾���. ��°� �����ϴ°� Connection(Ŀ�ؼ�)
			// == Ŀ�ؼ��ϳ��� ����� �ϳ� (������ ���� ����->�ּ��Է��ϸ� �����ȣ�� �ڵ����ζߵ���)
			Statement stmt = conn.createStatement();
			// Connection ��ü���� ������ Statement ��ü��
			// DB�����Ϳ� �����Ҽ��ִ�!
			ResultSet rs = stmt.executeQuery(sql); // ����Result set, ���� string sql������ ����(�����ڸ� ���Է��ؾߵȴ�. ������ �𸣱⶧���Ф�)
			
			//ResultSet ��ü(==rs)�� ����
			// table�� --->> class ��ü
			while(rs.next()) { // rs�� itr�� ����Ͽ�, �������ִ�?��� ���°��̴�.(���� - boolean)
				//Ÿ���� �����Ҽ��ִ�.
				System.out.println(rs.getInt("num")); // (rs.getInt(columnLabel - �Ӽ�,��Ʈ����Ʈ)
				System.out.println(rs.getInt("score"));
				System.out.println(rs.getString("sname"));
				System.out.println("=====");
			}
			
			//(4)db��������
			stmt.close(); // �ȴݾ��ָ� ������ ���� �߻��� ....re.close();���� �� ���༭ re.close�����൵��
			conn.close(); // �ϸ� stmt�� ����Ȯ���� ������ ������ ������ ������� �ݾ��ش�.
			
		} catch (ClassNotFoundException e) {  //forName Ŭ������ ã�������ʴ´� �� ������ ���� �� �ִ�
			e.printStackTrace();
		} catch (SQLException e) {//DriverManager
			e.printStackTrace();
		} 
		
		// DBMS�� �ڹ��� �ܺ�, �л�1�� ����, �л�2�� ���� ���������ص� ����̾���. ��°� �����ϴ°� Connection(Ŀ�ؼ�)
		// == Ŀ�ؼ��ϳ��� ����� �ϳ� (������ ���� ����->�ּ��Է��ϸ� �����ȣ�� �ڵ����ζߵ���)

		
		// --> �̴�� �߻��ϸ� ������ ���� "ClassNotFoundException" jar����;ߵ�
		// ������Ʈ �����ʹ�ư->properties -> java blild Path -> Libraries -> add external... -> apply
		// add�� �ڷ�� kim_0621 ->���ҽ�->db����->jar����
		
		// ����!!!!!!!--> Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
	}

}
