package day23_0728;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test3 {
	
	public static void main(String[] args) {
	
		// ��������
		// == �Լ��� ���� sql�� ó�� (����Ŭ�� ����!)
		// auto_increment == nvl
		// nvl(A,B): A���� ���ڽ��ϴ�. ��, A�� ���ٸ� B�� ��ü�Ͽ� ����ϰڽ��ϴ�. // nollvalue:�Լ�(���ڵΰ�)
		// nvl(�÷����߿� ����ū��, 0)+1
		
		Scanner sc = new Scanner(System.in);
		
		String DName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kim";
		String pw = "8958";

		Connection conn = null;
		PreparedStatement pstmt = null; // Statement���� ���̾�

		try {
			Class.forName(DName);// �޼���(forName) ���̷ܹ�⸦ ����

			conn = DriverManager.getConnection(url,user,pw); // ���ͷ�

			// �������� �� �� ?�� ���� �� �ִ�. // ?�ε����� ������ 1���� ����
			String sql = "insert into member values ((select nvl(max(num),0)+1 from member),?, ?)";
			pstmt = conn.prepareStatement(sql); //���� ��ÿ� �ٷ� sql�� ���� �� �ִ�!
			
			System.out.println("����� ȸ���� �̸��Է�");
			String name = sc.next();
			System.out.println("���� ȸ������ �̺�Ʈ ������, 3000����Ʈ ����!!!");
			
			// �ε��� ��ġ�� sql�� ? ��ġ    ?�ε����� ������ 1���� ����
			pstmt.setString(1, name);
			pstmt.setInt(2, 3000);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}//main����

}
