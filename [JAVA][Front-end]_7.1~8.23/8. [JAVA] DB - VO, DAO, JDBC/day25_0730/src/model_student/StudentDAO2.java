package model_student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.JDBC;
//강사님
public class StudentDAO2 { // imp는 
	
	// 단일리턴 로그인, 인증처리 등
	static String sql_SELECT_ONE = "select * from student where num=?"; // 리턴이 하나
	
	// 다수리턴 like구문을 활용한 검색역시 ALL일수있음
	// 검색, 다수의 데이터가 반환될 수 있는 처리 - 검색결과가 없거나, 1개 일 수도 있음에 유의!
	static String sql_SELECT_ALL = "select * from student order by num asc";

	static String sql_INSERT = "insert into student values ((select nvl(max(num), 0)+1 from student), ?, ?, ?)";
	static String sql_UPDATE = 	"update student set name=?, score1=?, score2=? where num=?";
	//	ex) 마이페이지
	
	static String sql_DELETE = 	"delete from student where num=?";

	private Connection conn = null;
	private PreparedStatement pstmt = null;

	// 등급을 반환하는 메서드
	// vo에서도 할 순있지만 테이블 구조만 받기때문에 대부분 DAO에서한다.
	//  실은 늦더라도 DB에서 추가하는게 젤좋음 걍 실습용으로 나눈것,,ㅎ 
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
		System.out.println("확인 " + res);
		return res;
	}
	

	public StudentVO selectOne(StudentVO vo) {
		conn= JDBC.getConnection();
		StudentVO data = null; //일단 객체화는 안함
		// 검색결과없을 때 null반환됨
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// 검색결과가 있으면 -> data가 존재!!
				data = new StudentVO();
				data.setNum(rs.getInt("num"));
				data.setName(rs.getString("name"));
				data.setScore1(rs.getInt("score1"));
				data.setScore2(rs.getInt("score2"));
				data.setGrade(returnGrade(rs.getInt("score1"), rs.getInt("score2"))); // setGrade를 가져온다.
			}
//				else {
//				// view에서 하는것
//				System.out.println("검색결과없음!");
//			}
//			
			rs.close();
			System.out.println("selectOne 수행완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		return data;
	}
	
	public ArrayList<StudentVO> selectAll(StudentVO vo) { 
		// 검색기능을 추가할 경우,
		// VO객체가 인자로 있으니까 vo에 있는 정보를 이용하시면 됩니다!
		// 유지보수성
		conn= JDBC.getConnection();
		StudentVO data = null; //일단 객체화는 안함
		ArrayList<StudentVO> datas = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			//boolean flag = true; //데이터 존재여부
			
			while(rs.next()) {
				//flag = false;
				data = new StudentVO();
				data.setNum(rs.getInt("num"));
				data.setName(rs.getString("name"));
				data.setScore1(rs.getInt("score1"));
				data.setScore2(rs.getInt("score2"));
				data.setGrade(returnGrade(rs.getInt("score1"), rs.getInt("score2"))); // setGrade를 가져온다.
				datas.add(data);
			}
			rs.close();
			//if(flag) {
			///	System.out.println("검색결과없음!");
			//}
			System.out.println("selectAll 수행완료");
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
			System.out.println("insert 수행완료");
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
			System.out.println("update 수행완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	
	public void deleteStu(StudentVO vo) {

		conn= JDBC.getConnection();
		try {//pstmt = ?를 인지할수있는 능력
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeUpdate();
			System.out.println("delete 수행완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
	}

	
}
