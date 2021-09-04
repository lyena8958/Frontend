package day23_0728;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

// 4�ܰ�
// ����̹��ε�
// DB����
// DB�����Ϳ� read, write ��
// DB��������
public class Test1 {

	public static void main(String[] args) {
		
		String DName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kim";
		String pw = "8958";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(DName);// �޼���(forName) ���̷ܹ�⸦ ����
			
			conn = DriverManager.getConnection(url,user,pw); // ���ͷ�
			
			stmt = conn.createStatement();
			
			int menuCnt = 0;
			
			// �޴������� ����
			String sql = "select count(*) from menu"; // count�Լ� == ����� ����
			ResultSet rs = stmt.executeQuery(sql); // executeQuery ���� -> rs
			
			
			while(rs.next()) {// select�� ����� �ڸ��� == count 1��°
				menuCnt = rs.getInt(1); // �޴����� 3��
				// System.out.println("������ ������ "+rs.getInt(1)+"�� �Դϴ�."); // ������ �� ����
			}
			
			rs.close();
			
			// �޴������ ���
			sql = "select * from menu";
			rs = stmt.executeQuery(sql);
			System.out.println("==�޴����==");
			
			ArrayList<Integer> numMem = new ArrayList();
			ArrayList<Integer> data = new ArrayList();
			ArrayList<Integer> point = new ArrayList();
			while(rs.next()) {// 1, 2, 3 --> ����� �ڸ��� (0�̾ƴ϶� 1���ͽ���)
				System.out.println(rs.getInt("mnum")+"."+rs.getString("mname")+"  ���: "+rs.getInt("cnt"));
				data.add(rs.getInt("cnt"));
			}
			System.out.println();
			sql = "select point, num from member";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				point.add(rs.getInt(1)); // ����Ʈ����
				numMem.add(rs.getInt(2)); // ��ȣ����
			}
			rs.close();
			
			Scanner sc = new Scanner(System.in);
			int mnum;
			while(true) {
				System.out.println("�޴���ȣ �Է�");
				mnum = sc.nextInt();
				
				if(mnum <1 || menuCnt<mnum) {
					System.out.println("�ش�޴���ȣ�� �����ϴ�! �ٽ��Է��ϼ���!");
					continue;
				}
				if(data.get(mnum-1)<=0) {
					System.out.println("�ش�޴��� ���� ��� �����ϴ�! �ٸ� �޴��� �ֹ����ּ���!");
					continue;
				}
				//sql="update menu set cnt=cnt-1 where mnum = "+mnum; // sql�� ���������ڰ�����
				//stmt.executeUpdate(sql);
				System.out.println("�ֹ��Ϸ�!");
				data.set(mnum-1, data.get(mnum-1)-1); // ������ �ʱ�ȭ�� �ٽ� �Ǳ⶧���� ���� ������Ű�� ����.
				break;
			}
			
			System.out.println("������ ��ȣ�Է�");
			int num = sc.nextInt();		// �����ݾ׿��� ����Ʈ�� �����Ҽ�������
			//String sqlP = "update member set point=point+100 where num="+num; // num�� 1�� �Է��ϸ� member���̺��� num�� �޶� �Է��� �ȵ�
			//int res = stmt.executeUpdate(sql);
			// System.out.println("res= "+res); num�� 1001�� �� ȸ����ȣ�� �ƴ� 1�̳� �Է��ϸ� 
			// ����� ����� ���ٸ�, 0�� ����(��ȯ)�ȴ�. => 1(����� �ִٸ� 1�� ��ȯ)
			boolean flag = true;
			for(Object obj:numMem) {
				if((int)obj==num) {
					flag=false;
					System.out.println("���ſϷ�!");
					point.set(num-1001, (point.get(num-1001)+100));
					String sqlP = "update member set point=point+100 where num="+num;
					stmt.executeUpdate(sqlP);
				}
			}
			if(flag) {//���� �Ϸᰡ �ȵǾ��ٸ�
				System.out.println("�ش� ����ȣ�� ��ȿ���� �ʾ� ���Ű� �Ұ��մϴ�!");
				data.set(mnum-1, data.get(mnum-1)+1); // ����߰�
			}
			
			sql="update menu set cnt="+data.get(mnum-1)+" where mnum = "+mnum;
			stmt.executeUpdate(sql);
			
			
			
		}catch (Exception e) { // �����ٸ� �ֻ��� �μ������� �ص���
			e.printStackTrace();
		} finally {
			try {//���� �������� Ŭ���� �������
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
	}//main����

}
