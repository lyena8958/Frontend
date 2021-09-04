package model_student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.JDBC;
//�����
public class StudentDAO2 { // imp�� 
	
	// ���ϸ��� �α���, ����ó�� ��
	static String sql_SELECT_ONE = "select * from student where num=?"; // ������ �ϳ�
	
	// �ټ����� like������ Ȱ���� �˻����� ALL�ϼ�����
	// �˻�, �ټ��� �����Ͱ� ��ȯ�� �� �ִ� ó�� - �˻������ ���ų�, 1�� �� ���� ������ ����!
	static String sql_SELECT_ALL = "select * from student order by num asc";

	static String sql_INSERT = "insert into student values ((select nvl(max(num), 0)+1 from student), ?, ?, ?)";
	static String sql_UPDATE = 	"update student set name=?, score1=?, score2=? where num=?";
	//	ex) ����������
	
	static String sql_DELETE = 	"delete from student where num=?";

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	// ����� ��ȯ�ϴ� �޼���
	// vo������ �� �������� ���̺� ������ �ޱ⶧���� ��κ� DAO�����Ѵ�.
	//  ���� �ʴ��� DB���� �߰��ϴ°� ������ �� �ǽ������� ������,,�� 
	char returnGrade(int score1, int score2) {
		char res = 'F';
		double avg = (score1 + score2) / 2.0;
		if(avg >= 90.0) {
			res= 'A';
		}
		else if (avg >= 70.0) {
			res = 'B';
		}
		else if (avg >= 50.0) {
			res = 'C';
		}
		System.out.println("Ȯ�� " + res);
		return res;
	}
	

	public StudentVO selectOne(StudentVO vo) {
		conn= JDBC.getConnection();
		StudentVO data = null; //�ϴ� ��üȭ�� ����
		// �˻�������� �� null��ȯ��
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// �˻������ ������ -> data�� ����!!
				data = new StudentVO();
				data.setNum(rs.getInt("num"));
				data.setName(rs.getString("name"));
				data.setScore1(rs.getInt("score1"));
				data.setScore2(rs.getInt("score2"));
				data.setGrade(returnGrade(rs.getInt("score1"), rs.getInt("score2"))); // setGrade�� �����´�.
			}
//				else {
//				// view���� �ϴ°�
//				System.out.println("�˻��������!");
//			}
//			
			rs.close();
			System.out.println("selectOne ����Ϸ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}
	
	public ArrayList<StudentVO> selectAll(StudentVO vo) { 
		// �˻������ �߰��� ���,
		// VO��ü�� ���ڷ� �����ϱ� vo�� �ִ� ������ �̿��Ͻø� �˴ϴ�!
		// ����������
		conn= JDBC.getConnection();
		StudentVO data = null; //�ϴ� ��üȭ�� ����
		ArrayList<StudentVO> datas = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			//boolean flag = true; //������ ���翩��
			
			while(rs.next()) {
				//flag = false;
				data = new StudentVO();
				data.setNum(rs.getInt("num"));
				data.setName(rs.getString("name"));
				data.setScore1(rs.getInt("score1"));
				data.setScore2(rs.getInt("score2"));
				data.setGrade(returnGrade(rs.getInt("score1"), rs.getInt("score2"))); // setGrade�� �����´�.
				datas.add(data);
			}
			rs.close();
			//if(flag) {
			///	System.out.println("�˻��������!");
			//}
			System.out.println("selectAll ����Ϸ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
	
	public void insertStu(StudentVO vo ) {

		conn= JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getScore1());
			pstmt.setInt(3, vo.getScore2());
			pstmt.executeUpdate();
			System.out.println("insert ����Ϸ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public void updateStu(StudentVO vo) {

		conn= JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getScore1());
			pstmt.setInt(3, vo.getScore2());
			pstmt.setInt(4, vo.getNum());
			pstmt.executeUpdate();
			System.out.println("update ����Ϸ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	
	public void deleteStu(StudentVO vo) {

		conn= JDBC.getConnection();
		try {//pstmt = ?�� �����Ҽ��ִ� �ɷ�
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeUpdate();
			System.out.println("delete ����Ϸ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}

	
}
