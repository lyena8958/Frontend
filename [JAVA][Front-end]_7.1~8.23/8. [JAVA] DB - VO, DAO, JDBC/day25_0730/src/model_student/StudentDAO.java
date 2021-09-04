package model_student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.JDBC;


// 문제 sql, VO 생성된 것을 통해 JDBC, DAO를 생성해라.
// 예나
//CRUD담당
public class StudentDAO {

	static String sql_SELECT_ONE = "select * from student where num = ?";
	static String sql_SELECT_ALL = "select * from student where name like ? order by a asc";
	static String sql_INSERT = "insert into student values((select nvl(max(num), 0) +1 from student), ?, ?, ?)";
	static String sql_UPDATE = "update student set name=?, score1=?, score2=? where num=?";
	static String sql_DELETE = "dalete from student where num = ?";
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	public StudentVO getStudent(StudentVO vo) {
		
		vo = null;
		conn = JDBC.getConnection();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setScore1(rs.getInt("score1"));
				vo.setScore2(rs.getInt("score2"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				JDBC.close(conn, pstmt);
		}
		System.out.println("getStudent 수행완료");
		return vo;
	}
	
	public ArrayList<StudentVO> getStudentList(StudentVO vo) {
		ArrayList<StudentVO> voList = new ArrayList();
		
		conn = JDBC.getConnection();
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			pstmt.setString(1, vo.getName());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StudentVO data = new StudentVO();
				data.setNum(rs.getInt("num"));
				data.setName(rs.getString("name"));
				data.setScore1(rs.getInt("score1"));
				data.setScore2(rs.getInt("score2"));
				
				voList.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				JDBC.close(conn, pstmt);
		}
		System.out.println("getStudentList 수행완료");
		return voList;
		
	}
	public void StudentInsert(StudentVO vo) {
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getScore1());
			pstmt.setInt(3, vo.getScore2());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		System.out.println("StudentInsert 수행완료");
		
	}
	public void StudentUpdate(StudentVO vo) {
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getScore1());
			pstmt.setInt(3, vo.getScore2());
			pstmt.setInt(4, vo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		System.out.println("StudentUpdate 수행완료");
		
	}
	public void StudentDelete(StudentVO vo) {
		
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		System.out.println("StudentDelete 수행완료");
		
	}
}
