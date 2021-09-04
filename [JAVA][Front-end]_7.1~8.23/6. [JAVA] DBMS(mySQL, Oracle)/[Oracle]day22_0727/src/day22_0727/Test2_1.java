package day22_0727;
// �����
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class Student2{

	private int num; // �й�
	private String name; // �̸�
	private double avg;
	private int rank;
	private boolean grade;
	Student2(int num, String name, int score1, int score2, int dateCnt){
		this.num = num;
		this.name = name;
		this.avg = (score1+score2)/2.0;
		this.rank = 1; // �켱 1��ó�� ��, �ٸ� �����Ϳ��� ��
		this.grade = false;
		if(this.avg >= 90.0 && dateCnt<=1) {
			this.grade = true;
		}
		System.out.println(name+"�л� ��ϿϷ�!");
	}
	// ����� ����������� ���ͼ��� ����
	public boolean isGrade() {// getter (boolean�� �ٸ���)
		return grade;
	}
	public int getRank() {
		return rank;
	}
	public void setRank() {
		this.rank++;
	}
	public double getAvg() {
		return avg;
	}
	@Override
	public String toString() {
		return num + "���л� " + name + " �����" + rank + " [" + grade + "]";
	}
}
public class Test2_1 {

	public static void main(String[] args) {

		// 1. ������ ��������
		// 2. ���󿩺� ����ϱ�
		//		����� 90.0���̻�, �Ἦ�ϼ� 1�� ���� (�Ƹ�)
		// 3. �������ϱ�(��������� �Ǵ�, �Ἦ�ϼ��� ����xxx)
		// ȫ�浿->�Ƹ�->�ƹ���->Ƽ��

		// +) ��������ϴ°ͱ���!

		
		ArrayList<Student2> data = new ArrayList();

		String DName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3308/leedb";
		String user = "root";
		String pw = "8958";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DName); // ����̹� ����
			conn = DriverManager.getConnection(url,user,pw); // db����
			stmt = conn.createStatement(); // db����

			//String sql = "select * from student";
			String sql = "select * from student order by dateCnt asc";
			rs = stmt.executeQuery(sql);	
			while(rs.next()) {
				int num = rs.getInt("snum"); 
				String name = rs.getString("name"); 
				int score1 = rs.getInt("score1");
				int score2 = rs.getInt("score2");
				int dateCnt= rs.getInt("dateCnt");

				data.add(new Student2(num,name,score1,score2,dateCnt));
			}

			rs.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally
		System.out.println();
		System.out.println("���󿩺�");
		for(Student2 stu:data) {
			if(stu.isGrade()) {
				System.out.println(stu);
			}
		}

		// ����۾�
		for(int i = 0; i < data.size();i++) {
			for(Student2 stu:data) {
				if(data.get(i).getAvg()< stu.getAvg()) {
					data.get(i).setRank(); //rank++
				}
			}
		}
		
		// ������� 1.java����
		System.out.println("����Ȯ��");
		for(int i=1;i<=data.size();i++) {
			for(Student2 stu:data) {
				if(i==stu.getRank()) {
					System.out.println(stu);
					break;
				}

			}
		}
		// ������� 2. db���� ��� Į���߰� - select order by asc;


	} //main

}
