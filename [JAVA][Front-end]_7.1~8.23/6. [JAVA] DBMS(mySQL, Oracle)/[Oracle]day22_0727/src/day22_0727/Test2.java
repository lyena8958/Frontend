package day22_0727;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
// ����
class Student{
	Student(int snum, String name, int score1, int score2, int dateCnt){
		this.snum = snum;
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.dateCnt = dateCnt;
		this.scoreAvg = (score1+score2) / 2.0; //������� ����
		this.grade = false;
		this.rank = 1;
		if(this.scoreAvg>=90.0 && this.dateCnt<=1) {
			this.grade= true;
		}
		System.out.println(this.name+"�� ��ϿϷ�!!");
	}
	int snum; // �й�
	String name; // �̸�
	int score1; // ����1
	int score2; // ����2
	int dateCnt; // �Ἦ�ϼ�
	int rank;
	double scoreAvg;
	boolean grade; 

}
public class Test2 {

	public static void main(String[] args) {

		// 1. ������ ��������
		// 2. ���󿩺� ����ϱ�
		//		����� 90.0���̻�, �Ἦ�ϼ� 1�� ���� (�Ƹ�)
		// 3. �������ϱ�(��������� �Ǵ�, �Ἦ�ϼ��� ����xxx)
		// ȫ�浿->�Ƹ�->�ƹ���->Ƽ��

		// +) ��������ϴ°ͱ���!

		ArrayList<Student> data = new ArrayList();

		String DName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3308/leedb";
		String user = "root";
		String pw = "8958";
		String sql = "select * from student";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(DName); // ����̹� ����
			conn = DriverManager.getConnection(url,user,pw); // db����
			stmt = conn.createStatement(); // db����
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int snum = rs.getInt("snum");
				String name = rs.getString("name");
				int score1 = rs.getInt("score1");
				int score2 = rs.getInt("score2");
				int dateCnt = rs.getInt("dateCnt");
				data.add(new Student(snum, name, score1, score2, dateCnt));
			}		

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
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//finally

		// �������� ���
		System.out.println("=====��������=====");
		for(Student v: data) {
			if(v.grade) {
				System.out.println(v.snum+" "+v.name);
			}
		}
		System.out.println("=================");

		// ��� ���
		for(int i = 0; i < data.size();i++) {
			for(Student v: data) {
				if(data.get(i).scoreAvg < v.scoreAvg) {
					data.get(i).rank++;
				}
			}
		}

		// ��� �������
		for(int i = 0; i < data.size(); i++) {
			for(Student stu:data) {
				if(i+1==stu.rank) { // i����� ���ٸ� ���
					System.out.println(stu.name+"��,  "+stu.rank+"��");
				}
			}
		}
		
	} //main

}
