package day21_0726;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
// Test5
//class Student{ // ���̺��� ���� ��ü
//	int snum;
//	String sname;
//	int score;
//	int srank;
//	String grade;
//	Student(int snum, String sname, int score, int srank, String grade){
//		this.snum = snum;
//		this.sname = sname;
//		this.score = score;
//		this.srank = srank;
//		this.grade = grade;
//		System.out.println(sname+"�л� ��ϿϷ�!");
//	}
//	@Override
//	public String toString() {
//		return "Student [snum=" + snum + ", sname=" + sname + ", score=" + score + ", srank=" + srank + ", grade="
//				+ grade + "]";
//	}
//	
//	
//}
public class Test5_1 {

	public static void main(String[] args) {
		// db -> �ڹ� �������̵�
		String DName="com.mysql.cj.jdbc.Driver"; // ������Ʈ ������ ���ͼ� cj���� ������ : com.mysql.jdbc.Driver ��� 

		String url = "jdbc:mysql://localhost:3308/leedb"; // localhost== ex) 10.219.130.80
		String user="root";
		String password = "8958";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from student";
		
		ArrayList <Student> data =new ArrayList();
		
		try {
			// ����̹� ����
			Class.forName(DName); // �ش� ��ɾ�� ����ó�� �ʿ�
			
			// db����
			conn = DriverManager.getConnection(url, user, password); // Connection = conn �̾����� ���̳θ� ���������� ������ ����
			// ���̷ܹ�Ⱑ �ִ� ����̴�.
			
			//�÷����� ����
			stmt = conn.createStatement(); 
			
			rs = stmt.executeQuery(sql);
			
			// DB->�ڹٷ� ������ ��������!
			while(rs.next()) {
				int snum = rs.getInt("snum");
				String sname = rs.getString("sname");
				int score = rs.getInt("score");
				int srank = rs.getInt("srank");
				String grade = rs.getString("grade");
				data.add(new Student(snum, sname,score,srank,grade));
//				System.out.println(rs.getString("sname")); // rs �ּҰ����� ��
//				System.out.println(rs.getInt("score"));
			}
			System.out.println();
			System.out.println("==�л���==");
			
			// �߰��ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
			// �ڹٿ��ִ� ������ ����
			for(int i = 0; i < data.size();i++) {
				data.get(i).sname = "�л�"+(i+1); // �̸��� ��� �ٲܰž� 
				stmt.executeUpdate("update student set sname='"+data.get(i).sname+"' where snum="+data.get(i).snum); // executeQuery�� rs�̶� ���������ִ�.
				// ����(�̸�)�� �־���ϴ� db���� �ۼ��� �� ó�� ���� ����ǥ�� �־�����Ѵ�. 
			}
			for(Student stu:data) {
				System.out.println(stu);
			}
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {//conn �����̷��
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Ȯ��");
		
	}

}
